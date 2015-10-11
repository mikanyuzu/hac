package org.tsrvfw.dto;

import java.sql.Timestamp;

public abstract class AbstractDTO {

	public AbstractDTO(){
	}

	private String userId;

	private String accountId;

	private Timestamp registDateTime;

	private String registUser;

	private String isDelete;

	private Timestamp updateDateTime;

    private String updateUser;

    private boolean isAllSelect;

	public Timestamp getRegistDateTime() {
		return registDateTime;
	}

	public void setRegistDateTime(Timestamp registDateTime) {
		this.registDateTime = registDateTime;
	}

	public String getRegistUser() {
		return registUser;
	}

	public void setRegistUser(String registUser) {
		this.registUser = registUser;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public Timestamp getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Timestamp updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public boolean isAllSelect() {
		return isAllSelect;
	}

	public void setAllSelect(boolean isAllSelect) {
		this.isAllSelect = isAllSelect;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

}
