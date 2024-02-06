package com.hexaware.main;


import java.util.Scanner;

import com.hexaware.controller.*;
import com.hexaware.dao.*;


public class MainModule {
	static Controller view = new Controller();
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
			System.out.println("[9.Search job by salary]");
			System.out.println("[10. exit]");
			
			int choice = scn.nextInt();
			
			switch(choice) {
			case 1: 
				view.jobListing();
				
				break;
			case 2:
				view.getCompany();
				break;
			case 3:
				view.getApplicant();
				break;
			case 4:
				view.getJobApplication();
	
				break;
			case 5:
				view.insertCompany();
				
				break;
			case 6:
				view.inserJoblist();	
				break;
			case 7:
				view.insertApplicant();
					break;
			case 8:
				view.inserJobapplication();
				
				break;
			case 9:
				System.out.println(view.jobBySalary());
				
				
				break;
			case 10:
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
