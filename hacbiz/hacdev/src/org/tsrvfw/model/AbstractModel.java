package org.tsrvfw.model;

import java.util.Map;

/**
 * 業務画面項目保持基底クラス
 *
 * @author tsubaki
 *
 */
public class AbstractModel {

	/** ログイン日時 */
	private String loginTime;

	/** アプリケーションメッセージ */
	private String appMessage = "";

	/** 業務エラーあり */
	private boolean isError;
	
	/** 業務エラー種類 */
	private String errType;

	/** 共通情報 */
	private Map<String, Object> commonInfoMap;

	/** 共通情報 */
	private String commonInfoString;
	
	/** 画面表示コード */
	private String displayCode;
	
	/** 追加画面表示コード */
	private String alphaDisplayCode;
	
	/** 業務区分 */
	private String workType;

	/**
	 * 業務区分取得
	 * @return 業務区分
	 */
	public String getWorkType() {
		return workType;
	}

	/**
	 * 業務区分設定
	 * @param workType 業務区分
	 */
	public void setWorkType(String workType) {
		this.workType = workType;
	}

	/**
	 * 追加画面表示コード取得
	 * @return 追加画面表示コード
	 */
	public String getAlphaDisplayCode() {
		return alphaDisplayCode;
	}

	/**
	 * 追加画面表示コード設定
	 * @param alphaDisplayCode 追加画面表示コード
	 */
	public void setAlphaDisplayCode(String alphaDisplayCode) {
		this.alphaDisplayCode = alphaDisplayCode;
	}

	/**
	 * 画面表示コード取得
	 * @return
	 */
	public String getDisplayCode() {
		return displayCode;
	}

	/**
	 * 画面表示コード設定
	 * @param displayCode
	 */
	public void setDisplayCode(String displayCode) {
		this.displayCode = displayCode;
	}

	/**
	 * ログイン日時取得処理
	 *
	 * @return ログイン日時
	 */
	public String getLoginTime() {
		return loginTime;
	}

	/**
	 * ログイン日時設定処理
	 *
	 * @param loginTime ログイン日時
	 */
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * 共通情報取得処理
	 *
	 * @return 共通情報
	 */
	public Map<String, Object> getCommonInfoMap() {
		return commonInfoMap;
	}

	/**
	 * 共通情報設定処理
	 *
	 * @param commonInfoMap 共通情報
	 */
	public void setCommonInfoMap(Map<String, Object> commonInfoMap) {
		this.commonInfoMap = commonInfoMap;
	}

	/**
	 * 共通情報取得処理
	 *
	 * @return 共通情報
	 */
	public String getCommonInfoString() {
		return commonInfoString;
	}

	/**
	 * 共通情報設定処理
	 *
	 * @param commonInfoMap 共通情報
	 */
	public void setCommonInfoString(String commonInfoString) {
		this.commonInfoString = commonInfoString;
	}

	/**
	 * アプリケーションメッセージ取得
	 *
	 * @return アプリケーションメッセージ
	 */
	public String getAppMessage() {
		return appMessage;
	}

	/**
	 * アプリケーションメッセージ設定
	 *
	 * @param appMessage アプリケーションメッセージ
	 */
	public void setAppMessage(String appMessage) {
		this.appMessage = appMessage;
	}

	/**
	 * 業務エラーあり取得
	 * @return 業務エラーあり
	 */
	public boolean getIsError() {
		return isError;
	}

	/**
	 * 業務エラーあり設定
	 * @param isError 業務エラーあり
	 */
	public void setIsError(boolean isError) {
		this.isError = isError;
	}

	/**
	 * 業務エラー種類取得
	 * @return 業務エラー種類
	 */
	public String getErrType() {
		return errType;
	}

	/**
	 * 業務エラー種類設定
	 * @param errType 業務エラー種類
	 */
	public void setErrType(String errType) {
		this.errType = errType;
	}
}
