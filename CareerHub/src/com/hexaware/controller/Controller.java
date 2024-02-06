package com.hexaware.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.model.Company;
import com.hexaware.model.JobListing;
import com.hexaware.util.DBConnUtil;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.hexaware.controller.*;
import com.hexaware.dao.*;
import com.hexaware.model.Applicant;
import com.hexaware.model.Company;
import com.hexaware.model.JobApplication;
import com.hexaware.model.JobListing;
import com.hexaware.exception.*;

public class Controller {
	Scanner scn = new Scanner(System.in);
	static ICareerHubService serviceImpl = new CareerHubServiceImpl();

	public Controller() {
	}

	public List<JobListing> getJobs(int id) {
		Connection connection = DBConnUtil.getConnection();
		List<JobListing> jobs = new ArrayList<>();

		String query = "SELECT * FROM joblisting Where companyId = ";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				JobListing joblisting = new JobListing();
				joblisting.setJobID(rs.getInt("JobID"));
				joblisting.setCompanyID(rs.getInt("CompanyID"));
				joblisting.setJobTitle(rs.getString("JobTitle"));
				joblisting.setJobDescription(rs.getString("JobDescription"));
				joblisting.setJobLocaton(rs.getString("JobLocation"));
				joblisting.setSalary(rs.getInt("Salary"));
				joblisting.setJobType(rs.getString("JobType"));
				joblisting.setPostedDate(rs.getDate("PostedDate").toLocalDate());
				jobs.add(joblisting);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<JobListing> jobBySalary() {
		System.out.println("Enter Expected Salary");
		double sal = scn.nextDouble();
		Connection connection = DBConnUtil.getConnection();
		List<JobListing> jobs = new ArrayList<>();

		String query = "SELECT * FROM joblisting Where salary > ? ";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setDouble(1, sal);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				JobListing joblisting = new JobListing();
				joblisting.setJobID(rs.getInt("JobID"));
				joblisting.setCompanyID(rs.getInt("CompanyID"));
				joblisting.setJobTitle(rs.getString("JobTitle"));
				joblisting.setJobDescription(rs.getString("JobDescription"));
				joblisting.setJobLocaton(rs.getString("JobLocation"));
				joblisting.setSalary(rs.getInt("Salary"));
				joblisting.setJobType(rs.getString("JobType"));
				joblisting.setPostedDate(rs.getDate("PostedDate").toLocalDate());
				jobs.add(joblisting);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public void inserJoblist() {
		System.out.println("Ener the job listing");

		System.out.println("Enter the job id ");
		int jobid = scn.nextInt();
		System.out.println("enter the company id");
		int jobCompanyid = scn.nextInt();
		System.out.println("enter the title");
		scn.nextLine();
		String jobtitle = scn.nextLine();
		System.out.println("enter the description");

		String jobDetails = scn.nextLine();

		System.out.println("enter the location");

		String joblocation = scn.nextLine();

		System.out.println("enter the salary");
		int jobSalary = scn.nextInt();
		System.out.println("enter the job type");
		scn.nextLine();
		String jobtype = scn.nextLine();
		System.out.println("enter the posted date in YYYY-MM-DD");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate napd = LocalDate.parse(scn.next(), formatter);
		JobListing jobList = new JobListing(jobid, jobCompanyid, jobtitle, jobDetails, joblocation, jobSalary, jobtype,
				napd);
		serviceImpl.InsertJobListing(jobList);
		System.out.println("record inserted successfully");
	}

	public void insertApplicant() throws InvalidEmailFormatException {
		System.out.println("enter the applicant id");
		int aid = scn.nextInt();
		scn.nextLine();
		System.out.println("enter the first name of applicant");

		String afirstName = scn.nextLine();

		System.out.println("enter the last name of applicant");
		String alastName = scn.nextLine();

		System.out.println("enter the email of the applicant");
		String aEmail = scn.nextLine();
		
		System.out.println("enter the phone number of the applicant");
		String aphone = scn.nextLine();
		// scn.nextLine();
		System.out.println("upload the resume");
		String aresume = scn.nextLine();
		// scn.nextLine();
		Applicant aprofile = new Applicant(aid, afirstName, alastName, aEmail, aphone, aresume);
		serviceImpl.InsertApplicant(aprofile);
		System.out.println("record inserted");

	}
	public void inserJobapplication() {
		System.out.println("enter the job application id");
		int jobAppid = scn.nextInt();
		System.out.println("enter the job id");
		int jajid = scn.nextInt();
		System.out.println("enter the applicant id");
		int jobppid = scn.nextInt();
		System.out.println("upload the cv");
		scn.nextLine();
		String cv = scn.nextLine();
		
		System.out.println("enter the application date in yyyy-mm-dd");
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate napd1 = LocalDate.parse(scn.next(), formatter1);
		scn.nextLine();
		JobApplication jap = new JobApplication(jobAppid,jajid,jobppid,napd1,cv);
		serviceImpl.InsertJobApplication(jap);
		System.out.println("record inserted successfully");
	}
	public void insertCompany() {
		System.out.println("enter the company details");
		System.out.println("enter company id");
		int companyid = scn.nextInt();
		System.out.println("enter company name");
		scn.nextLine();
		String companyName = scn.nextLine();
		System.out.println("enter company location");
		//scn.nextLine();
		String location = scn.nextLine();
		Company company = new Company(companyid,companyName,location);
		serviceImpl.InsertCompany(company);
		System.out.println("record inserted");
	}
	
	public void jobListing() {
		System.out.println("All the available job listing are mentioned below: ");
		ArrayList<JobListing> joblist =  (ArrayList<JobListing>) serviceImpl.GetJobListings();
		System.out.println(joblist);
	}
	public void getCompany() {
		System.out.println("All the available companies are mentioned below: ");
		ArrayList<Company> comp1 = (ArrayList<Company>) serviceImpl.GetCompanies();
		System.out.println(comp1);
	}
	public void getApplicant() {
		System.out.println("All the available Applicants are mentioned below: ");
		ArrayList<Applicant> application = (ArrayList<Applicant>) serviceImpl.GetApplicants();
		System.out.println(application);
	}
	public void getJobApplication() {
		System.out.println("All the available Job applications are mentioned below: ");
		ArrayList<JobApplication> jobapply = (ArrayList<JobApplication>) serviceImpl.GetApplicationsForJob();
		System.out.println(jobapply);
	}
	

}
