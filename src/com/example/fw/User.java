package com.example.fw; 
 
public class User implements Comparable<User>{ 
 
	public String login; 
	public String email; 
	public String password; 
 
	public User() { 
 	  } 
  
 	public User setLogin(String login) { 
 		this.login = login; 
 		return this; 
 	} 
  
 	public User setEmail(String email) { 
 		this.email = email; 
 		return this; 
 	} 
  
 	public User setPassword(String password) { 
 		this.password = password; 
 		return this; 
 	} 
  
 	public String getLogin() { 
 		return login; 
 	} 
  
 	public String getEmail() { 
 		return email; 
 	} 
  
 	@Override 
 	public int hashCode() { 
 		final int prime = 31; 
 		int result = 1; 
 /*		result = prime * result + ((email == null) ? 0 : email.hashCode()); 
 		result = prime * result + ((login == null) ? 0 : login.hashCode());*/ 
 		return result; 
 	} 
  
 	@Override 
 	public boolean equals(Object obj) { 
 		if (this == obj) 
 			return true; 
 		if (obj == null) 
 			return false; 
 		if (getClass() != obj.getClass()) 
 			return false; 
 		User other = (User) obj; 
 		if (email == null) { 
 			if (other.email != null) 
 				return false; 
 		} else if (!email.equals(other.email)) 
 			return false; 
 		if (login == null) { 
 			if (other.login != null) 
 				return false; 
 		} else if (!login.equals(other.login)) 
 			return false; 
 		return true; 
 	} 
  
 	@Override 
 	public String toString() { 
 		return "User [login=" + login + ", email=" + email + "]"; 
 	} 
  
 	@Override 
 	public int compareTo(User other) { 
 		int compareLogin = login.toLowerCase().compareTo(other.login.toLowerCase()); 
 		int compareEmail = email.toLowerCase().compareTo(other.email.toLowerCase()); 
 		if (compareLogin != 0){ 
 			return compareLogin; 
 		} else { 
 			return compareEmail; 
 		} 
 	} 
  
 } 
