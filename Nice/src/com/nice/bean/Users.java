package com.nice.bean;

public class Users {

	private String password;
	private int userid;
	private String loginid;
	private String filename;
	private String requestdate;
	private String filestatus;
	private int filesize;
	private int id;
	private int downloadtime;
	private int bandwidth;
	private float downloadcost;
	private String cloudservername;
	private String virtuvalmachine;
	private String logintype;
	private String location;
	private String mailid;
	private String registereddate;
	private int vmcapacity;
	private int difftime;
	private int mintime;

	// private String filename;

	public Users() {
		super();
	}

	public Users(String loginid, String password) {
		super();
		this.loginid = loginid;
		this.password = password;
	}

	public Users(String loginid, String password, String logintype) {
		super();
		this.loginid = loginid;
		this.password = password;
		this.logintype = logintype;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getLogintype() {
		return logintype;
	}

	public void setLogintype(String logintype) {
		this.logintype = logintype.toLowerCase();
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getRegistereddate() {
		return registereddate;
	}

	public void setRegistereddate(String registereddate) {
		this.registereddate = registereddate;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Users(String loginid, String filename, int filesize,
			int downloadtime, int bandwidth, int downloadcost,
			String cloudservername, String virtuvalmachine) {
		super();
		this.loginid = loginid;
		this.filename = filename;
		this.filesize = filesize;
		this.downloadtime = downloadtime;
		this.bandwidth = bandwidth;
		this.downloadcost = downloadcost;
		this.cloudservername = cloudservername;
		this.virtuvalmachine = virtuvalmachine;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public int getDownloadtime() {
		return downloadtime;
	}

	public void setDownloadtime(int downloadtime) {
		this.downloadtime = downloadtime;
	}

	public String getCloudservername() {
		return cloudservername;
	}

	public void setCloudservername(String cloudservername) {
		this.cloudservername = cloudservername;
	}

	public String getVirtuvalmachine() {
		return virtuvalmachine;
	}

	public void setVirtuvalmachine(String virtuvalmachine) {
		this.virtuvalmachine = virtuvalmachine;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBandwidth() {
		return bandwidth;
	}

	public void setBandwidth(int bandwidth) {
		this.bandwidth = bandwidth;
	}

	public float getDownloadcost() {
		return downloadcost;
	}

	public void setDownloadcost(float downloadcost) {
		this.downloadcost = downloadcost;
	}

	public int getVmcapacity() {
		return vmcapacity;
	}

	public void setVmcapacity(int vmcapacity) {
		this.vmcapacity = vmcapacity;
	}

	public int getDifftime() {
		return difftime;
	}

	public void setDifftime(int difftime) {
		this.difftime = difftime;
	}

	public int getMintime() {
		return mintime;
	}

	public void setMintime(int mintime) {
		this.mintime = mintime;
	}

	public String getRequestdate() {
		return requestdate;
	}

	public void setRequestdate(String requestdate) {
		this.requestdate = requestdate;
	}

	public String getFilestatus() {
		return filestatus;
	}

	public void setFilestatus(String filestatus) {
		this.filestatus = filestatus;
	}

}
