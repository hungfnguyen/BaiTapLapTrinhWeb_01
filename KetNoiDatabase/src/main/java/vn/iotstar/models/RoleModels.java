package vn.iotstar.models;

import java.io.Serializable;

public class RoleModels implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7642250428863808370L;
	
	private int roleid;
	private String rolename;
	
	public RoleModels() {
		super();
	}

	public RoleModels(int roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	

}
