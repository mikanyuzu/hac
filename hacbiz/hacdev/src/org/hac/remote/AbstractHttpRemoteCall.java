/**
 * [module]
 * AbstractHttpRemoteCall.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.remote;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.tsrvfw.common.logger.CommonLogger;
import org.tsrvfw.common.message.MessageConfigManager;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.service.AbstractService;

/**
 * リモート呼び出し処理基底クラス
 * @author sysusr1
 *
 */
public abstract class AbstractHttpRemoteCall implements HttpRemoteCallInterface{

	/** ロガー */
	protected Logger log = CommonLogger.getLogger(this.getClass().getName());
	
	/** 業務処理クラスインスタンス */
	protected AbstractService service;
	
	/**
	 * 業務処理
	 */
	@Override
	public Map<String, Object> execute(Map<String, Object> inputData){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			
			Map<String, Object> checkResult = executeBusiness(inputData);
			resultMap.put("remote_result", 0);
			resultMap.put("remote_result_data", checkResult);
		} catch (TsrvfwSystemException e) {
			resultMap.put("remote_result", 2);
			try {
				log.error(e);
				log.error(MessageConfigManager.getLogMessageFromInnerCode("org.hac.remote.AbstractHttpRemoteCall:90001"));
			} catch (TsrvfwSystemException e1) {
				log.error("メッセージ取得に失敗しました");
			}
		} catch (TsrvfwBusinessException e) {
			e.printStackTrace();
			resultMap.put("remote_result", 1);
			try {
				log.error(e);
				String message = MessageConfigManager.getLogMessageFromInnerCode(e.getInnerCode());
				String editMessage = MessageFormat.format(message, e.getParams());
				log.error(editMessage);
			} catch (TsrvfwSystemException e1) {
				log.error("メッセージ取得に失敗しました");
			}
		}
		return resultMap;
	}
	
	/**
	 * 業務処理クラスインスタンス設定
	 * @param service
	 */
	public void setService(AbstractService service){
		this.service = service;
	}

	
	/**
	 * 各サブクラス業務処理
	 * @param inputData 入力データ
	 * @return 処理結果
	 * @throws TsrvfwBusinessException 
	 * @throws TsrvfwSystemException 
	 */
	protected abstract Map<String, Object> executeBusiness(Map<String, Object> inputData) throws TsrvfwSystemException, TsrvfwBusinessException;
}
