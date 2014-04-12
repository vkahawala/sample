package user.mgt.core;

import user.mgt.core.bean.User;
import user.mgt.core.util.SavableStatus;

public class UserManagementService {

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
}
