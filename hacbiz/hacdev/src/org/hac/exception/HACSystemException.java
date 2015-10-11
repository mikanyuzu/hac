/**
 * [module]
 * HACSystemException.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.exception;

import org.tsrvfw.exception.TsrvfwSystemException;

/**
 * クラス
 *
 * @author tsubaki
 *
 */
public class HACSystemException extends TsrvfwSystemException {

	public HACSystemException(Exception e, String message) {
		super(e, message);
	}

	public HACSystemException(String message) {
		super(message);
	}
	
	/**  */
	private static final long serialVersionUID = 1007878305041616738L;

}

