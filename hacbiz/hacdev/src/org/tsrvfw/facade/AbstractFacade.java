package org.tsrvfw.facade;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.tsrvfw.common.logger.CommonLogger;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.model.AbstractModel;

/**
 * 業務Facade層基底クラス
 *
 * @author tsubaki
 *
 */
public abstract class AbstractFacade {

	/** ロガー */
	protected Logger log = CommonLogger.getLogger(this.getClass().getName());

	/**
	 * 業務Facade層処理実行
	 *
	 * @param model 各画面モデルクラス
	 * @return 処理結果
	 * @throws TsrvfwSystemException 想定内システムエラーが発生した場合
	 * @throws TsrvfwBusinessException 業務エラーが発生した場合
	 */
	@Transactional
	public Map<String, Object> execute(AbstractModel model) throws TsrvfwSystemException, TsrvfwBusinessException{
		log.debug("start");
		Map<String, Object> result = executeBusiness(model);
		if (result.isEmpty()){
			throw new TsrvfwSystemException("");
		}
		log.debug("end");
		return result;
	}

	/**
	 * 各業務処理実行
	 *
	 * @param model 各画面モデルクラス
	 * @return 処理結果
	 * @throws TsrvfwSystemException 想定内システムエラーが発生した場合
	 * @throws TsrvfwBusinessException 業務エラーが発生した場合
	 */
	protected abstract Map<String, Object> executeBusiness(AbstractModel model) throws TsrvfwSystemException, TsrvfwBusinessException;

	/**
	 * 業務エラー発生時処理
	 *
	 * @return 処理結果
	 * @throws TsrvfwSystemException 想定内システムエラーが発生した場合
	 */
	public abstract Map<String, Object> executeBusinessException() throws TsrvfwSystemException;
}
