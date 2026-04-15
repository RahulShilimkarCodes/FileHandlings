package jsonDataDriven;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPojo {
	
	@JsonProperty("username")
	private String username;
	
	@JsonProperty("password")
	private String password;
	
	public UserPojo() {};		// Default constructor (needed for JSON deserialization)
	
	public UserPojo(String username,String password)
	{
		this.username=username;
		this.password=password;
	}
	
	public void setUserName(String username)
	{
		this.username=username;
	}
	
	public String getUserName()
	{
		return username;
	}
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	

}
