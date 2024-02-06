package com.hexaware.dao;

import java.util.List;

import com.hexaware.model.Applicant;
import com.hexaware.model.Company;
import com.hexaware.model.JobApplication;
import com.hexaware.model.JobListing;

public interface ICareerHubService {
 
	void InsertJobListing(JobListing jobListing);
	void InsertCompany (Company company);
	void InsertApplicant(Applicant applicant);
	void InsertJobApplication(JobApplication jobApplication);
	List<JobListing> GetJobListings();
	List<Company> GetCompanies();
	List<Applicant> GetApplicants();
	List<JobApplication> GetApplicationsForJob (); 

}
