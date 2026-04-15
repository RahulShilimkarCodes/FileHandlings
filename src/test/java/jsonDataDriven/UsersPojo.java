package jsonDataDriven;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsersPojo {

	@JsonProperty("users")
	private List<UserPojo> userList;
		
	public UsersPojo() {};		// Default constructor (needed for JSON deserialization)
	
	public UsersPojo(List<UserPojo> userList)
	{
		this.userList=userList;
	}
	
	public void setUsers(List<UserPojo> userList)
	{
		this.userList=userList;
	}
	
	public List<UserPojo> getUsers()
	{
		return userList;
	}
	
	
}
