package jsonFile;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeesListPOJO {
	
	@JsonProperty("employees")
	private List<EmployeePOJO> employees;

	public EmployeesListPOJO() {}		//jackson needs this for deserialization
	//If you only have a parameterized constructor (and no no-args constructor), Jackson cannot instantiate your class.
	
	public EmployeesListPOJO (List<EmployeePOJO> employees)
	{
		this.employees = employees;
	}
	
	public List<EmployeePOJO> getEmployees()
	{
		return employees;
	}
	
	public void setEmployees(List<EmployeePOJO> employees)
	{
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "EmployeesListPOJO [employees =" + employees + "]";
	}

}
