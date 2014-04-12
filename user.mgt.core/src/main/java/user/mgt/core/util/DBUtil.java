package user.mgt.core.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import user.mgt.core.bean.Address;
import user.mgt.core.bean.User;

public class DBUtil {
	private static SessionFactory sfac;

	static {
		sfac = new AnnotationConfiguration().addAnnotatedClass(User.class)
				.addAnnotatedClass(Address.class).configure()
				.buildSessionFactory();

	}

	private DBUtil() {

	}

	public static Session getSession() {
		return sfac.openSession();
	}

	public static void rollback(Transaction tnx) {
		if (tnx != null) {
			tnx.rollback();
		}
	}

	public static void close(Session session) {

		if (session != null) {
			session.close();
		}

	}
}
