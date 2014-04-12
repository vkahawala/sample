package user.mgt.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import user.mgt.core.util.DBUtil;
import user.mgt.core.util.SavableStatus;

public abstract class Savable {

	private static Log log = LogFactory.getLog(UserManagementService.class);

	private SavableStatus status;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	public SavableStatus getStatus() {
		return status;
	}

	public void setStatus(SavableStatus status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Serializable save() throws Exception {
		Session session = null;
		Transaction tnx = null;
		try {
			session = DBUtil.getSession();
			tnx = session.beginTransaction();

			Serializable returnVal = null;
			if (status == SavableStatus.INSERT) {
				returnVal = session.save(this);
			} else if (status == SavableStatus.UPDATE) {
				session.update(this);
				returnVal = this.id;
			} else if (status == SavableStatus.DELETE) {
				session.delete(this);
			}

			tnx.commit();
			return returnVal;

		} catch (Exception e) {
			log.error(e);
			DBUtil.rollback(tnx);
			throw new Exception(e.getMessage());
		} finally {
			DBUtil.close(session);
		}

	}
}
