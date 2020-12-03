package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

/*Serwlet do wyświetlania zdjęć*/
/*Mapowanie wszytskich adresów /galeria/*, za * podajemy nazwę pliku zdjęcia*/
@WebServlet(name = "Photo", urlPatterns = "/galeria/*")
public class Photo extends HttpServlet {

    /*Wiśwetla zdjęcie którego nazwa pliku została podana jako argument w adresie.*/
    /*Zdjęcia znadują się w folderze /home/dawid/Desktop/cukierniakremowka/zdjecia */
    /*Jeśli zdjecie o podanej nazwie nie znaduje się w folderze, zwracana jest odpowiedź z kodem 404*/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getPathInfo() == null) {
            response.setStatus(404);
            return;
        }
        var paths = request.getPathInfo().split("/");
        if (paths.length < 2) {
            response.setStatus(404);
            return;
        }
        var fName = paths[1];
        var directoryFiles = new File("/home/dawid/Desktop/cukierniakremowka/zdjecia").listFiles();
        for(var file : Objects.requireNonNull(directoryFiles)) {
            if (file.getName().equals(fName)) {
                //response.addHeader("Content-Disposition", String.format("attachment; filename=%s", fName));
                byte[] img = Files.readAllBytes(file.toPath());
                response.setContentType("image");
                var output = response.getOutputStream();
                output.write(img);
                output.flush();
                return;
            }
        }
        response.setStatus(404);
    }
}
