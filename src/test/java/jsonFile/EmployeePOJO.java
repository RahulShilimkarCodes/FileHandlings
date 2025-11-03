package jsonFile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeePOJO {
	/*
	 * "id": 1, "first_name": "Donald", "last_name": "OConnell", "email":
	 * "Donald@gmail.com", "gender": "Male"
	 */

		@JsonProperty("id")
	    private int id;

	   // @JsonProperty("first_name")		
	    private String first_name;

	    @JsonProperty("last_name")		//- this is to link the mismatch between json and pojo by linking the variables to JSON
	    private String last_name;

	    @JsonProperty("email")
	    private String email;

	    @JsonProperty("gender")
	    private String gender;

	public EmployeePOJO() {
	}

	public EmployeePOJO(int id, String first_name, String last_name, String email, String gender) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "EmployeePOJO [id=" + id + ", firstName=" + first_name + ", lastName=" + last_name + ", email=" + email
				+ ", gender=" + gender + "]";
	}

}
