/**
 * [module]
 * LoginModel.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.model.impl;

/**
 * ログイン画面モデルクラス
 *
 * @author tsubaki
 *
 */
public class LoginModel extends CommonModel {
	
	/** パスワード */
	private String pwd;
	
	/**
	 * パスワードの設定
	 * @param pwd パスワード
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	/**
	 * パスワードの取得
	 * @return パスワード
	 */
	public String getPwd() {
		return this.pwd;
	}
}

