package user.mgt;

import java.io.File;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import user.mgt.core.bean.Address;
import user.mgt.core.bean.User;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}
	
	public void testUserInsertion() {
		SessionFactory factory = new AnnotationConfiguration()
				.addAnnotatedClass(User.class).addAnnotatedClass(Address.class)
				.configure().buildSessionFactory();

		User user = new User();
		user.setFirstName("Test");

		Session session = factory.openSession();
		Transaction tnx = session.beginTransaction();
		session.save(user);
		tnx.commit();
	}
}
