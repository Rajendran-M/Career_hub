package com.hexaware.model;


import java.util.ArrayList;
import java.util.List;

import com.hexaware.controller.Controller;

public class Company {
	
	private int companyID;
	private String companyName;
	private String location;
	private List<JobListing> jobListings;
	
	
	
	
	public Company() {
		super();
		
	}




	public Company(int companyID, String companyName, String location) {
		super();
		this.companyID = companyID;
		this.companyName = companyName;
		this.location = location;
		this.jobListings = new ArrayList<>();
	}




	public int getCompanyID() {
		return companyID;
	}




	public void setCompanyID(int companyId) {
		this.companyID = companyId;
	}




	public String getCompanyName() {
		return companyName;
	}




	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}


	public void postJob(String jobTitle, String jobDescription, String jobLocation, double salary, String jobType) {
      
        jobListings.add(new JobListing());
    }
    public List<JobListing> getJobs(){
    	Controller c = new Controller();
		return c.getJobs(this.getCompanyID()) ;
    	
    }

	@Override
	public String toString() {
		return "\nCompany [companyId=" + companyID + ", companyName=" + companyName + ", location=" + location + "]\n";
	}

}
