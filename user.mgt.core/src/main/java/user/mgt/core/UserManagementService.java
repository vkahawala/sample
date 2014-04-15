package user.mgt.core;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import user.mgt.core.bean.User;
import user.mgt.core.util.DBUtil;
import user.mgt.core.util.SavableStatus;

public class UserManagementService {

	private static Log log = LogFactory.getLog(UserManagementService.class);

	public void createUser(User user) throws Exception {
		user.setStatus(SavableStatus.INSERT);
		user.save();
	}

	public void updateUser(User user) throws Exception {
		user.setStatus(SavableStatus.UPDATE);
		user.save();
	}

	public void deleteUser(User user) throws Exception {
		user.setStatus(SavableStatus.DELETE);
		user.save();
	}

	public User getUser(String userNameO) {
		return null;

	}

	public User login(String userName, String pwd) throws Exception {

		Session session = null;
		try {
			session = DBUtil.getSession();
			Query query = session
					.createQuery("FROM User WHERE userName = :userName");
			query.setString("userName", userName);
			List<?> result = query.list();
			if (result != null && !result.isEmpty()) {
				for (Object o : result) {
					User user = (User) o;
					if (user.getPwd().equals(pwd)) {
						log.info(userName + " login success ");
						return user;
					}
				}
			}
			log.info(userName + " login fail");
		} catch (Exception e) {
			log.error(e);
			throw new Exception(e.getMessage());
		} finally {
			DBUtil.close(session);
		}
		return null;
	}
}
