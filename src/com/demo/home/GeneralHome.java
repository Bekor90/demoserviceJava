package com.demo.home;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;

import com.demo.utils.HibernateUtil;

public class GeneralHome {
	 
	protected String tblname;
	
	public GeneralHome() {
		
	}
	
	protected void setSchema(Session s) throws RuntimeException {
		Connection connection = ((SessionImpl) s).connection();
		try {
			connection.prepareStatement("SET search_path TO " + HibernateUtil.getSchema()).execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getTblname() {
		return tblname;
	}

	public void setTblname(String tblname) {
		this.tblname = tblname;
	}

}
