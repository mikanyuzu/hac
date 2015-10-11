package org.tsrvfw.interceptor;

import java.util.Map;

import org.tsrvfw.common.message.MessageConfigManager;
import org.tsrvfw.exception.TsrvfwSystemException;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * セッションチェックインターセプタクラス
 *
 * @author tsubaki
 *
 */
public class SessionCheckerInterceptor extends AbstractInterceptor {

	/** シリアルID */
	private static final long serialVersionUID = -2336420394581937003L;

	/**
	 * セッションチェック処理実行
	 *
	 * @param paramActionInvocation ActionInvocation
	 * @return 処理結果
	 */
	@Override
	public String intercept(ActionInvocation invoker) throws Exception {
		checkParams(invoker);
		String result = invoker.invoke();
		checkParams(invoker);
		return result;
	}

	/**
	 * セッションチェック処理
	 *
	 * @param invoker ActionInvocation
	 * @throws TsrvfwSystemException 想定内システムエラーが発生した場合
	 */
	private void checkParams(ActionInvocation invoker) throws TsrvfwSystemException {
		Map<String,Object> params = invoker.getInvocationContext().getParameters();
		if (params == null || params.isEmpty() || params.get("userId") == null){
			throw new TsrvfwSystemException(MessageConfigManager.getViewMessageFromInnerCode(this.getClass().getName() + ":00001"));
		}
	}

}
