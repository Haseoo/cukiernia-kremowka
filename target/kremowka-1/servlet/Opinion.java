package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.IOpinionService;
import views.OpinionView;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.stream.Collectors.toList;

@WebServlet("/opinie")
public class Opinion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	public Opinion(IOpinionService opinionService) {
		this.opinionService = opinionService;
	}

	public Opinion() {
		this.opinionService = null;
	}

	/*Wstrzykiwanie implementacji serwisu*/
	private final IOpinionService opinionService;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var opinionViews = opinionService.getOpinions().stream().map(OpinionView::from).collect(toList());
		RequestDispatcher dispatcher;
		var header = request.getHeader("Accept");
		if(header.contains("application/json")) {
			var mapper = new ObjectMapper();
			request.setAttribute("opinions", mapper.writeValueAsString(opinionViews));
			dispatcher = request.getRequestDispatcher("opinionsJson.jsp");
		} else  {
			request.setAttribute("opinions", opinionViews);
			dispatcher = request.getRequestDispatcher("opinionMvc.jsp");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var jsonString = request.getReader().readLine();
		var redPath = getRedirectPathAndSetStatus(response, jsonString);
		RequestDispatcher dispatcher = request.getRequestDispatcher(redPath);
		dispatcher.forward(request, response);
	}

	/* w zależnosci od odpowiedzi serwisu, zwraca adres przekierowania oraz ustawia typ odpowiedzi*/
	private String getRedirectPathAndSetStatus(HttpServletResponse response, String jsonString) {
		String redPath = "";
		if (jsonString == null) {
			redPath = "addParseFail.jsp";
			response.setStatus(401);
		} else {
			var result = opinionService.add(jsonString);
			switch (result) {
				case ADDED:
					redPath = "addSucess.jsp";
					response.setStatus(200);
					break;
				case ADD_ERROR:
					redPath = "addFail.jsp";
					response.setStatus(500);
					break;
				case PARSE_ERROR:
					redPath = "addParseFail.jsp";
					response.setStatus(401);
					break;
				default:
					break;
			}
		}
		return redPath;
	}
}
