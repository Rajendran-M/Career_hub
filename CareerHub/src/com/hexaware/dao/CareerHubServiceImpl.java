package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.exception.ApplicationDeadlineException;
import com.hexaware.exception.InvalidEmailFormatException;
import com.hexaware.model.Applicant;
import com.hexaware.model.Company;
import com.hexaware.model.JobApplication;
import com.hexaware.model.JobListing;
import com.hexaware.util.DBConnUtil;

public class CareerHubServiceImpl implements ICareerHubService {

	private static Connection connection;

	public CareerHubServiceImpl() {
		CareerHubServiceImpl.connection = DBConnUtil.getConnection();
	}

	@Override
	public void InsertJobListing(JobListing jobListing) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO JobListing (JobID, CompanyID, JobTitle, JobDescription, JobLocation, Salary, JobType, PostedDate) VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, jobListing.getJobID());
			ps.setInt(2, jobListing.getCompanyID());
			ps.setString(3, jobListing.getJobTitle());
			ps.setString(4, jobListing.getJobDescription());
			ps.setString(5, jobListing.getJobLocaton());
			ps.setInt(6, jobListing.getSalary());
			ps.setString(7, jobListing.getJobType());
			// ps.setDate(3, java.sql.Date.valueOf(appointment.getAppointmentDate()));
			ps.setDate(8, java.sql.Date.valueOf(jobListing.getPostedDate()));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void InsertCompany(Company company) {

		try {
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO Company (CompanyID, CompanyName, Location) VALUES(?,?,?)");
			ps.setInt(1, company.getCompanyID());
			ps.setString(2, company.getCompanyName());
			ps.setString(3, company.getLocation());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void InsertApplicant(Applicant applicant) {

		String query = "INSERT INTO Applicant (ApplicantID, FirstName, LastName, Email, Phone, Resume) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, applicant.getApplicantID());
			ps.setString(2, applicant.getFirstName());
			ps.setString(3, applicant.getLastName());
			ps.setString(4, applicant.getEmail());
			ps.setString(5, applicant.getPhone());
			ps.setString(6, applicant.getResume());
			ps.executeUpdate();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void InsertJobApplication(JobApplication jobApplication) {

		String query = "INSERT INTO JobApplication (ApplicationID, JobID, ApplicantID, ApplicationDate, CoverLetter) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, jobApplication.getApplicationID());
			ps.setInt(3, jobApplication.getApplicantID());
			ps.setInt(2, jobApplication.getJobID());
			ps.setDate(4, java.sql.Date.valueOf(jobApplication.getApplicationDate()));
			ps.setString(5, jobApplication.getCoverLetter());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<JobListing> GetJobListings() {

		List<JobListing> joblist = new ArrayList<>();
		String query = "SELECT * FROM JobListing ";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			// ps.setInt(1,JobID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				joblist.add(mapJobListing(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return joblist;
	}

	@Override
	public List<Company> GetCompanies() {

		List<Company> company = new ArrayList<>();
		String query = "SELECT * FROM Company";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			// ps.setInt(1,CompanyID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				company.add(mapCompany(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return company;
	}

	@Override
	public List<Applicant> GetApplicants() {
		// TODO Auto-generated method stub
		List<Applicant> applicant = new ArrayList<>();
		String query = "SELECT * FROM Applicant";
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				applicant.add(mapApplicant(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return applicant;
	}

	@Override
	public List<JobApplication> GetApplicationsForJob() {

		List<JobApplication> jobapplication = new ArrayList<>();
		String query = "SELECT * FROM JobApplication";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				jobapplication.add(mapJobApplication(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobapplication;
	}

	private JobListing mapJobListing(ResultSet rs) throws SQLException {
		JobListing joblisting = new JobListing();
		joblisting.setJobID(rs.getInt("JobID"));
		joblisting.setCompanyID(rs.getInt("CompanyID"));
		joblisting.setJobTitle(rs.getString("JobTitle"));
		joblisting.setJobDescription(rs.getString("JobDescription"));
		joblisting.setJobLocaton(rs.getString("JobLocation"));
		joblisting.setSalary(rs.getInt("Salary"));
		joblisting.setJobType(rs.getString("JobType"));
		joblisting.setPostedDate(rs.getDate("PostedDate").toLocalDate());
		return joblisting;
	}

	private Company mapCompany(ResultSet rs) throws SQLException {
		Company companies = new Company();
		companies.setCompanyID(rs.getInt("CompanyID"));
		companies.setCompanyName(rs.getString("CompanyName"));
		companies.setLocation(rs.getString("Location"));
		return companies;
	}

	private Applicant mapApplicant(ResultSet rs) {
		Applicant applicants = new Applicant();
		try {
			applicants.setApplicantID(rs.getInt("ApplicantID"));
			applicants.setFirstName(rs.getString("FirstName"));
			applicants.setLastName(rs.getString("LastName"));

			applicants.setEmail(rs.getString("Email"));

			applicants.setPhone(rs.getString("Phone"));
			applicants.setResume(rs.getString("Resume"));
			return applicants;
		} catch (Exception e) {
			System.err.println("Error: Invalid email format - " + e.getMessage());
		}
		return applicants;
	}

	private JobApplication mapJobApplication(ResultSet rs) throws SQLException {
		JobApplication jobapplication = new JobApplication();
		jobapplication.setApplicationID(rs.getInt("ApplicationID"));
		jobapplication.setJobID(rs.getInt("JobID"));
		jobapplication.setApplicantID(rs.getInt("ApplicantID"));
		try {
			jobapplication.setApplicationDate(rs.getDate("ApplicationDate").toLocalDate());
		} catch (ApplicationDeadlineException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jobapplication.setCoverLetter(rs.getString("CoverLetter"));
		return jobapplication;
	}

}
