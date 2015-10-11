package org.hac.model.impl;

import org.tsrvfw.model.AbstractModel;

/**
 * 各画面共通モデルクラス
 *
 * @author tsubaki
 *
 */
public class CommonModel extends AbstractModel{

	/** 簡易検索項目 名前 */
	private String simpleSearchName;
	
	/** 簡易検索項目 TEL */
	private String simpleSearchTel;
	
	/** アカウントID */
	private String accountId;
	
	/** アカウント名称 */
	private String userAccount;
	
	/** ユーザID */
	private String userId;
	
	/** 店舗管理No */
	private String hubMngNo;
	
	/**
	 * 簡易検索項目 名前を取得する
	 * @return 簡易検索項目 名前
	 */
	public String getSimpleSearchName() {
		return simpleSearchName;
	}

	/**
	 * 簡易検索項目 名前を設定する
	 * @param simpleSearchName 簡易検索項目名前
	 */
	public void setSimpleSearchName(String simpleSearchName) {
		this.simpleSearchName = simpleSearchName;
	}

	/**
	 * 簡易検索項目 TELを取得する
	 * @return 簡易検索項目 TEL
	 */
	public String getSimpleSearchTel() {
		return simpleSearchTel;
	}

	/**
	 * 簡易検索項目 TELを設定する
	 * @param simpleSearchTel 簡易検索項目 TEL
	 */
	public void setSimpleSearchTel(String simpleSearchTel) {
		this.simpleSearchTel = simpleSearchTel;
	}
	
	/**
	 * アカウント名称取得処理
	 *
	 * @return アカウント名称
	 */
	public String getUserAccount() {
		return userAccount;
	}

	/**
	 * アカウント名称設定処理
	 *
	 * @param userAccount アカウント名称
	 */
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	
	/**
	 * アカウントID取得処理
	 *
	 * @return アカウントID
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * アカウントID設定処理
	 *
	 * @param accountId アカウントID
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	/**
	 * ユーザID取得処理
	 *
	 * @return ユーザID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * ユーザID設定処理
	 *
	 * @param userId ユーザID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * 店舗管理Noを取得
	 * @return 店舗管理No
	 */
	public String getHubMngNo() {
		return hubMngNo;
	}

	/**
	 * 店舗管理No設定
	 * @param hubMngNo 店舗管理No
	 */
	public void setHubMngNo(String hubMngNo) {
		this.hubMngNo = hubMngNo;
	}
}
