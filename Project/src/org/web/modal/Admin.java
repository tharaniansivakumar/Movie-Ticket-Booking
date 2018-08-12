package org.web.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mtb_admin")
public class Admin {
	@Id
	@Column(name = "admin_id", length = 22, nullable = false)
	private String adminId;
	@Column(name = "password", length = 22, nullable = false)
	private String password;
	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
