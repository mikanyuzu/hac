package org.tsrvfw.service;

import java.util.Map;

import org.apache.log4j.Logger;
import org.tsrvfw.common.logger.CommonLogger;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;

/**
 * 業務処理コンポーネント基底クラス
 *
 * @author tsubaki
 *
 */
public abstract class AbstractService {

	/** ロガー */
	protected Logger log = CommonLogger.getLogger(this.getClass().getName());

	/**
	 * 業務処理実行
	 *
	 * @param inputData 入力情報
	 * @return 処理結果
	 * @throws TsrvfwSystemException 想定内システムエラーが発生した場合
	 * @throws TsrvfwBusinessException 業務エラーが発生した場合
	 */
	public Map<String, Object> execute(Map<String, Object> inputData)
			throws TsrvfwSystemException, TsrvfwBusinessException {
		log.debug("start");
		Map<String, Object> result = executeService(inputData);
		if (result == null || result.isEmpty()) {
			throw new TsrvfwSystemException("System Err");
		}
		log.debug("end");
		return result;
	}

	/**
	 * 各業務処理実行
	 *
	 * @param inputData 入力情報
	 * @return 処理結果
	 * @throws TsrvfwBusinessException 業務エラーが発生した場合
	 */
	protected abstract Map<String, Object> executeService(
			Map<String, Object> inputData) throws TsrvfwSystemException, TsrvfwBusinessException;
}
