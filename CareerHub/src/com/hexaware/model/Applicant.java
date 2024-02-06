package com.hexaware.model;

import java.time.LocalDate;

import com.hexaware.exception.InvalidEmailFormatException;



public class Applicant {
	private int applicantID;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String resume;

	public Applicant() {
		
	}

	public Applicant(int applicantID, String firstName, String lastName, String email, String phone, String resume) {
		
		this.applicantID = applicantID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.resume = resume;
	}

	public int getApplicantID() {
		return applicantID;
	}

	public void setApplicantID(int applicantID) {
		applicantID = applicantID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		lastName = lastName;
	}

	public String getEmail() {
		return email;
	}
//	

	public void setEmail(String email) throws InvalidEmailFormatException {
	    validateEmail(email);
	    email = email;
	}


	private void validateEmail(String email) throws InvalidEmailFormatException {
		   if (!email.contains("@")) {
		        throw new InvalidEmailFormatException("Email must contain @ symbol");	 }  }


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		phone = phone;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		resume = resume;
	}
	
    public void createProfile(String email, String firstName, String lastName, String phone) throws InvalidEmailFormatException {
        validateEmail(email); // Validate email format
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
    public void applyForJob(int jobID, String coverLetter) {
    
        int applicantID = this.applicantID;
        
        
        LocalDate applicationDate = LocalDate.now();
        
        
        JobApplication jobApplication = new JobApplication(0, jobID, applicantID, applicationDate, coverLetter);
        System.out.println(jobApplication);
        
        
    }


	@Override
	public String toString() {
		return "\nApplicant [ApplicantID=" + applicantID + ", FirstName=" + firstName + ", LastName=" + lastName + ", Email="
				+ email + ", Phone=" + phone + ", Resume=" + resume + "] \n";
	}


}
