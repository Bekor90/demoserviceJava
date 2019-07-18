package com.demo.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

//	private static Logger log = LoggerFactory.getLogger(HibernateUtil.class);
	private static SessionFactory sessionFactory;
	private static String schema = "";

	// Disable constructor to guaranty a single instance 
	private HibernateUtil() {
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");
				setSchema((configuration.getProperty("hibernate.default_schema")));

				ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
//				log.error("Could not locate SessionFactory in JNDI", e);
				throw new IllegalStateException("Could not locate SessionFactory in JNDI");
			}
		}
		return sessionFactory;
	}
	
	public static void close() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
		sessionFactory = null;
	}
	public static String getSchema() {
		return schema;
	}
	public static void setSchema(String schema) {
		HibernateUtil.schema = schema;
	}
}
