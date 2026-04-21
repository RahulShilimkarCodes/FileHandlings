package employeeDataJson;

import java.util.List;

import jsonFile.EmployeesListPOJO;

public class EmployeeDataJson {
	
	String firstName;
	String lastName;
	List<Address> address;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public List<Address> getAddress()
	{
		return address;
	}
	
	public void setAddress(List<Address> address)
	{
		this.address = address;
	}
	
	@Override
	public String toString()
	{
		return "Employees [FirstName "+firstName+" , LastName "+lastName+"] , Address - "+address+"]";
	}

}
