package com.example;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Document(collection = "users") // MongoDB collection name
@Data
public class UserModel {

	    @Id
	    @JsonFormat private String id;
	    @JsonFormat private String fullName;
	    @JsonFormat private String email;
	    @JsonFormat private String password;
	    @JsonFormat private String mobileNumber;
	    @JsonFormat private String address;
	    @JsonFormat(pattern = "dd-MM-yyyy")
	    private String empDOB;
	    
	    public String getFullName() { return fullName; }
	    public void setFullName(String fullName) { this.fullName = fullName; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public String getPassword() { return password; }
	    public void setPassword(String password) { this.password = password; }

	    public String getMobileNumber() { return mobileNumber; }
	    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

	    public String getAddress() { return address; }
	    public void setAddress(String address) { this.address = address; }

	    public String getEmpDOB() { return empDOB; }
	    public void setEmpDOB(String empDOB) { this.empDOB = empDOB; }

}