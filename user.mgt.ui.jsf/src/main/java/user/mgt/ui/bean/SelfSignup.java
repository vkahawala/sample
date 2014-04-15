package user.mgt.ui.bean;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import user.mgt.core.UserManagementService;
import user.mgt.core.bean.User;
import user.mgt.ui.util.SecurityUtil;

@ManagedBean(name = "signup", eager = true)
@RequestScoped
public class SelfSignup {

	private static Log log = LogFactory.getLog(Login.class);
	private UserManagementService userMgtService;

	private String userName;
	private String password;

	public SelfSignup() {
		super();
		userMgtService = new UserManagementService();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String submit() {

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA");
			digest.update(password.getBytes());
			byte[] pwd = digest.digest();
			password = SecurityUtil.formatByteArray(pwd);

			User user = new User();
			user.setUserName(userName);
			user.setPwd(password);

			userMgtService.createUser(user);

		} catch (NoSuchAlgorithmException e) {
			log.error(e);
			return "self-signup";
		} catch (Exception e) {
			log.error(e);
			return "self-signup";
		}
		return "index";
	}
}
