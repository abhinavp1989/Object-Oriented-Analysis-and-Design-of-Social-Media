package model;

public class IncidentTicket {
	protected int id;
	protected int inapuserid;
	protected int inappostid;
	protected int assignedTechnicianid;
	protected String date_created;
	protected String time_created;
	protected String issue;
	
	
	
	
	
	
	//private String street;
	//private String city;
	//private String state;
	//private String zip;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getInapuserid() {
		return inapuserid;
	}

	public void setInapuserid(int inapuserid) {
		this.inapuserid = inapuserid;
	}
	
	public int getInappostid() {
		return inappostid;
	}

	public void setInappostid(int inappostid) {
		this.inappostid = inappostid;
	}
	
	public int getAssignedTechnicianid() {
		return assignedTechnicianid;
	}

	public void setAssignedTechnicianid(int assignedTechnicianid) {
		this.assignedTechnicianid = assignedTechnicianid;
	}
	
	public String getDate() {
		return date_created;
	}

	public void setDate(String date) {
		this.date_created = date_created;
	}

	public String getTime() {
		return time_created;
	}

	public void setTime(String time) {
		this.time_created = time_created;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}
}
