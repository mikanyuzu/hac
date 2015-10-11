/**
 * [module]
 * UpdateUserData.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.hac.common.ComponentCommonConst;
import org.hac.exception.HACBusinessException;
import org.tsrvfw.common.util.LogicUtils;
import org.tsrvfw.constant.ActionCommonConst;
import org.tsrvfw.dao.AbstractDao;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.service.AbstractService;

/**
 * ユーザ情報更新処理クラス
 * @author sysusr1
 *
 */
public class UpdateUserData extends AbstractService {

	/** ユーザ情報Dao */
	private AbstractDao usrDao;
	
	/**
	 * ユーザ情報更新処理
	 */
	@Override
	protected Map<String, Object> executeService(Map<String, Object> inputData)
			throws TsrvfwSystemException, TsrvfwBusinessException {
		// 店舗管理No
		String hubMngNo = LogicUtils.getMapValueToString(inputData, ComponentCommonConst.KEY_USRINFO_HUB_MNG_NO);
		// ユーザID
		String usrId = LogicUtils.getMapValueToString(inputData,	ComponentCommonConst.KEY_USRINFO_USER_ID);
		// パスワード
		String passwd = LogicUtils.getMapValueToString(inputData,	ComponentCommonConst.KEY_USRINFO_PWD);
		// 存在チェック
		if (!LogicUtils.isNotEmptyString(hubMngNo)) {
			throw new HACBusinessException(
					this.getClass().getName() + ":00001", "", "");
		}
		// 存在チェック
		if (!LogicUtils.isNotEmptyString(usrId)) {
			throw new HACBusinessException(
					this.getClass().getName() + ":00002", "", "");
		}
		// 存在チェック
		if (!LogicUtils.isNotEmptyString(passwd)) {
			throw new HACBusinessException(
					this.getClass().getName() + ":00003", "", "");
		}
		// ユーザデータ更新
		Map<String, Object> conditionData = new HashMap<String, Object>();
		conditionData.put(ComponentCommonConst.KEY_USRINFO_HUB_MNG_NO, hubMngNo);
		conditionData.put(ComponentCommonConst.KEY_USRINFO_USER_ID, usrId);
		conditionData.put(ComponentCommonConst.KEY_USRINFO_PWD, passwd);
		conditionData.put("user_name", LogicUtils.getMapValueToString(inputData, "user_name"));
		conditionData.put("user_tel", LogicUtils.getMapValueToString(inputData, "user_tel"));
		conditionData.put("user_mail", LogicUtils.getMapValueToString(inputData, "user_mail"));
		conditionData.put("user_role_type", LogicUtils.getMapValueToString(inputData, "user_role_type"));
		conditionData.put("changed_passwd", LogicUtils.getMapValueToString(inputData, "changed_passwd"));
		conditionData.put("update_user", LogicUtils.getMapValueToString(inputData, "update_user"));
		usrDao.executeUpdate(conditionData, "updateUserDataByKey");
		
		// 結果Map作成
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(ActionCommonConst.RESULT_CODE, ActionCommonConst.RESULT_SUCCESS);
		return resultMap;
	}
	
	/**
	 * ユーザ情報Daoインスタンス設定
	 * @param dao ユーザ情報Dao
	 */
	public void setUsrDao(AbstractDao dao){
		this.usrDao = dao;
	}

}
