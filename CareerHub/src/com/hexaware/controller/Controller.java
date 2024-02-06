package com.hexaware.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.model.Company;
import com.hexaware.model.JobListing;
import com.hexaware.util.DBConnUtil;


public class Controller {

	public Controller() {}
	
		public List<JobListing> getJobs(int id) {
		Connection connection = DBConnUtil.getConnection();
			List<JobListing> jobs = new ArrayList<>();
			
			String query = "SELECT * FROM joblisting Where companyId = ";
			try {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setInt(1,id);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
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
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return jobs;
		}
		
			
	}


