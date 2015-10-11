/**
 * [module]
 * EncodingFilter.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * リクエストパラメータ文字エンコード設定クラス
 * @author sysusr1
 *
 */
public class EncodingFilter implements Filter{

	/** 指定文字コード */
	private String encoding = null;

	/**
	 * 初期処理
	 * @param config
	 * @throws ServletException
	 */
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
	}

	/**
	 * フィルタ処理
	 * @param req
	 * @param res
	 * @param chain
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
						throws ServletException, IOException {
		req.setCharacterEncoding(encoding);
		chain.doFilter(req, res);
	}

	/**
	 * 終了処理
	 */
	public void destroy() {
		encoding = null;
	}	
}
