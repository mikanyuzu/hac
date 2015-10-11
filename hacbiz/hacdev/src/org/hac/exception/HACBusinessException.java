/**
 * [module]
 * HACBusinessException.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.exception;

import org.tsrvfw.exception.TsrvfwBusinessException;

/**
 * クラス
 *
 * @author tsubaki
 *
 */
public class HACBusinessException extends TsrvfwBusinessException{

	public HACBusinessException(String code, String message, String... params) {
		super(code, message, params);
	}

	/**  */
	private static final long serialVersionUID = -1039459620397567628L;

}

