package com.nice.bean;

public class FileBean {

	private String filename;
	private String attackername;
	private String decfilename;
	private String vmowner;
	private String key;
	private String signature;
	private int fileactualsize;
	private int filedownloadsize;
	private int lossofpackets;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getVmowner() {
		return vmowner;
	}

	public void setVmowner(String vmowner) {
		this.vmowner = vmowner;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public int getFileactualsize() {
		return fileactualsize;
	}

	public void setFileactualsize(int fileactualsize) {
		this.fileactualsize = fileactualsize;
	}

	public int getFiledownloadsize() {
		return filedownloadsize;
	}

	public void setFiledownloadsize(int filedownloadsize) {
		this.filedownloadsize = filedownloadsize;
	}

	public int getLossofpackets() {
		return lossofpackets;
	}

	public void setLossofpackets(int lossofpackets) {
		this.lossofpackets = lossofpackets;
	}

	public String getDecfilename() {
		return decfilename;
	}

	public void setDecfilename(String decfilename) {
		this.decfilename = decfilename;
	}

	public String getAttackername() {
		return attackername;
	}

	public void setAttackername(String attackername) {
		this.attackername = attackername;
	}

}
