package com.hexaware.model;

import java.time.LocalDate;
import java.util.List;

public class JobListing {
	
	private int jobID;
	private int companyID;
	private String jobTitle;
	private String jobDescription;
	private String jobLocaton;
	private int salary;
	private String jobType;
	private LocalDate postedDate;
	public JobListing() {
		
	}

	public JobListing(int jobID, int companyID, String jobTitle, String jobDescription, String jobLocaton, int salary,
			String jobType, LocalDate postedDate) {
		
		this.jobID = jobID;
		this.companyID = companyID;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.jobLocaton = jobLocaton;
		this.salary = salary;
		this.jobType = jobType;
		this.postedDate = postedDate;
	}

	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobLocaton() {
		return jobLocaton;
	}
	public void setJobLocaton(String jobLocaton) {
		this.jobLocaton = jobLocaton;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public LocalDate getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}
	
	public void apply(int applicantId,String coverLetter) {
		
	}
	
    public List<Applicant> getApplicants(){
    	
		return null;
    	
    }
   public  LocalDate getJobpostDate() {
	return postedDate;
	   
   }
    
	@Override
	public String toString() {
		return "\nJobListing [JobID=" + jobID + ", CompanyID=" + companyID + ", JobTitle=" + jobTitle + ", JobDescription="
				+ jobDescription + ", JobLocaton=" + jobLocaton + ", Salary=" + salary + ", JobType=" + jobType
				+ ", PostedDate=" + postedDate + "] \n";
	}

}
