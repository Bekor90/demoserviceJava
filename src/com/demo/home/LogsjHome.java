package com.demo.home;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StringType;

import com.demo.entity.Logsj;
import com.demo.utils.HibernateUtil;

public class LogsjHome extends GeneralHome  {
	
	public LogsjHome() {
		this.tblname = "logs4j";
	}
	
public void InsertLogs(Logsj log){
		
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			setSchema(session);
		
		String queryString = "INSERT INTO " + this.tblname
				+ "(logusuario, logip, logtipo, logparametro, logrespuesta) "
				+ "VALUES(:p1, :p2, :p3, :p4, :p5)";

		Query query = session.createSQLQuery(queryString)
				.setParameter("p1", log.getLogusuario(), StringType.INSTANCE)
				.setParameter("p2", log.getLogip(), StringType.INSTANCE)
				.setParameter("p3", log.getLogtipo(), StringType.INSTANCE)
				.setParameter("p4", log.getLogparametro(), StringType.INSTANCE)
				.setParameter("p5", log.getLogrespuesta(), StringType.INSTANCE);
		
		query.executeUpdate();
		tx.commit();
		}catch (RuntimeException  e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw e;
		} finally {
			if(session != null) {
				session.close();				
			}
		}
	}
	
}
