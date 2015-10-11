/**
 * [module]
 * ActionCommonConst.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.tsrvfw.constant;

/**
 * 業務アクション処理定数保持クラス
 * 
 * @author tsubaki
 * 
 */
public class ActionCommonConst {

	/** 処理成功 */
	public static final String RESULT_SUCCESS = "success";

	/** 想定内システムエラー発生 */
	public static final String SYSTEM_ERR = "system_error";

	/** 業務エラー発生 */
	public static final String BUSINESS_ERR = "business_error";

	/** 処理結果キー */
	public static final String RESULT_CODE = "result_code";

	/** 業務エラーメッセージ取得キー */
	public static final String BIS_ERR_MESSAGE = "bis_err_message";

	/** 画面表示コード取得キー */
	public static final String KEY_DISPLAY_CODE = "display_code";

	/**
	 * 隠蔽コンストラクタ
	 */
	private ActionCommonConst() {
	}
}
