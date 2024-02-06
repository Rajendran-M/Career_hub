package com.hexaware.main;

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
public class MainModule {
	static ICareerHubService serviceImpl = new CareerHubServiceImpl();
	public static void main(String[] args)throws Exception {
		System.out.println("------------------------------\n");
		System.out.println("Welcome to Career Hub  \n");
		System.out.println("-------------------------------\n");
	
		Scanner scn = new Scanner(System.in);
		
		boolean flag = true;
		while(flag) {
			System.out.print("\n Please enter your choice -> [1-8] \n\n");
			System.out.println("[1.Get Job Listing]");
			System.out.println("[2.Get Companies]");
			System.out.println("[3.Get Applicants]");
			System.out.println("[4.Get Job Application]");
			System.out.println("[5.Insert a Company]");
			System.out.println("[6.Insert a Job List]");
			System.out.println("[7.Insert a Applicant]");
			System.out.println("[8.Insert a Job Application]");
			System.out.println("[9. exit]");
			
			int choice = scn.nextInt();
			
			switch(choice) {
			case 1: 
				System.out.println("All the available job listing are mentioned below: ");
				ArrayList<JobListing> joblist =  (ArrayList<JobListing>) serviceImpl.GetJobListings();
				System.out.println(joblist);
				break;
			case 2:
				System.out.println("All the available companies are mentioned below: ");
				ArrayList<Company> comp1 = (ArrayList<Company>) serviceImpl.GetCompanies();
				System.out.println(comp1);
				break;
			case 3:
				System.out.println("All the available Applicants are mentioned below: ");
				ArrayList<Applicant> application = (ArrayList<Applicant>) serviceImpl.GetApplicants();
				System.out.println(application);
				break;
			case 4:
				System.out.println("All the available Job applications are mentioned below: ");
				ArrayList<JobApplication> jobapply = (ArrayList<JobApplication>) serviceImpl.GetApplicationsForJob();
				System.out.println(jobapply);
				break;
			case 5:
				
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
				break;
			case 6:
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
				JobListing jobList = new JobListing(jobid,jobCompanyid,jobtitle,jobDetails,joblocation,jobSalary,jobtype,napd);
				serviceImpl.InsertJobListing(jobList);
				System.out.println("record inserted successfully");
				break;
			case 7:
				System.out.println("enter the applicant id");
				int aid = scn.nextInt();
				scn.nextLine();
				System.out.println("enter the first name of applicant");
			
				String afirstName = scn.nextLine();
				
				System.out.println("enter the last name of applicant");
				String alastName = scn.nextLine();
				
				System.out.println("enter the email of the applicant");
				String aEmail = scn.nextLine();
			;
				System.out.println("enter the phone number of the applicant");
				String aphone = scn.nextLine();
				//scn.nextLine();
				System.out.println("upload the resume");
				String aresume = scn.nextLine();
				//scn.nextLine();
				Applicant aprofile = new Applicant(aid,afirstName,alastName,aEmail,aphone,aresume);
				serviceImpl.InsertApplicant(aprofile);
				System.out.println("record inserted");
				break;
			case 8:
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
				break;
			case 9:
				flag = false;
				System.out.println("exiting....");
				break;
			default :
				System.out.println("Please enter the values between 1 - 9");
				break;
			}
				
		}
	}

}
