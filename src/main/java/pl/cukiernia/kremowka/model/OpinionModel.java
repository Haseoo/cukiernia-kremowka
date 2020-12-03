package pl.cukiernia.kremowka.model;

import javax.persistence.*;

@Entity
@Table(name = "opinions")
@NamedQueries({
		@NamedQuery(name = "Opinions.findAll", query = "SELECT t FROM OpinionModel t")
})
public class OpinionModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	private Long number;
	private String doLike;
	private String color;
	private String email;
	private String opinion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumber() {
		return number;
	}

	public String getDoLike() {
		return doLike;
	}

	public String getColor() {
		return color;
	}

	public String getEmail() {
		return email;
	}

	public String getOpinion() {
		return opinion;
	}

	@Override
	public String toString() {
		return "OpinionModel [number=" + number + ", like=" + doLike + ", color=" + color + ", email=" + email
				+ ", opinion=" + opinion + "]";
	}
	
	
}
