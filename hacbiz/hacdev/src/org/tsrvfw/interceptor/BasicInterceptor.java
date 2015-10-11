package org.tsrvfw.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 業務基底Intercepterクラス
 *
 * @author tsubaki
 *
 */
public class BasicInterceptor extends AbstractInterceptor{

	/** シリアルID */
	private static final long serialVersionUID = 5640742365837250384L;

	/**
	 * 処理実行
	 *
	 * @param paramActionInvocation ActionInvocation
	 * @return 処理結果
	 */
	@Override
	public String intercept(ActionInvocation paramActionInvocation) throws Exception {
		String result = paramActionInvocation.invoke();
		return result;
	}

}
