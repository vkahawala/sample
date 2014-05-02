package user.mgt.ui.bean;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import user.mgt.core.UserManagementService;
import user.mgt.core.bean.User;
import user.mgt.ui.util.SecurityUtil;

@ManagedBean(name = "login")
@SessionScoped
@RequestScoped
@ApplicationScoped
public class Login {

	private UserManagementService userMgtService;

	private static Log log = LogFactory.getLog(Login.class);
	private String password;
	private String userName;
	private String fullName;

	private User user;

	public Login() {
		super();
		userMgtService = new UserManagementService();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return user.getFirstName() != null ? (user.getFirstName() + " " + user
				.getLastName()) : userName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String signup() {
		return "self-signup";
	}

	public String submit() {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA");
			digest.update(password.getBytes());
			byte[] pwd = digest.digest();
			password = SecurityUtil.formatByteArray(pwd);

			try {
				User user = userMgtService.login(userName, password);
				if (user == null) {
					return "index";
				}
				this.user = user;
			} catch (Exception e) {
				log.error(e);
				return "index";
			}

		} catch (NoSuchAlgorithmException e) {
			log.error(e);
			return "index";
		}
		return "profile?faces-redirect=true";
	}
}
