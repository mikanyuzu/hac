/**
 * [module]
 * ComponentCommon.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.common;

/**
 * コンポーネント層共通クラス
 *
 * @author tsubaki
 *
 */
public class ComponentCommonConst {

	/** 入力値チェック 条件キー OR */
	public static final String KEY_INPUT_CHECK_CONDITION_OR = "or";

	/** 入力値チェック 条件キー OR */
	public static final String KEY_INPUT_CHECK_CONDITION_AND = "and";
	
	/** 入力値チェック 条件キー */
	public static final String KEY_INPUT_CHECK_CONDITION = "condition";

	/** 入力値チェック データキー */
	public static final String KEY_INPUT_CHECK_DATA = "data";
	
	/** 入力値チェック チェック結果キー */
	public static final String KEY_INPUT_CHECK_RESULT = "ckeck_result";
	
	/** 入力値チェック チェック結果キー OK */
	public static final String KEY_INPUT_CHECK_OK = "OK";

	/** 入力値チェック チェック結果キー NG */
	public static final String KEY_INPUT_CHECK_NG = "NG";
	
	/** ユーザ情報取得キー ユーザID */
	public static final String KEY_USRINFO_USER_ID = "user_id";
	
	/** ユーザ情報取得キー パスワード */
	public static final String KEY_USRINFO_PWD = "user_passwd";
	
	/** ユーザ情報取得キー 店舗管理No */
	public static final String KEY_USRINFO_HUB_MNG_NO = "hub_mng_no";
	
	/** ユーザ情報取得キー 会社管理No */
	public static final String KEY_USRINFO_ORG_MNG_NO = "org_mng_no";
	
	public static final String REGEX_PATTERN_EMAIL = "[0-9a-zA-Z_\\-]+@[0-9a-zA-Z_\\-]+(\\.[0-9a-zA-Z_\\-]+){1,}";
	
	/**
	 * 隠蔽コンストラクタ
	 */
	private ComponentCommonConst(){
		// インスタンス生成禁止
	}
}

