/**
 * [module]
 * CommonLogger.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.tsrvfw.common.logger;

import org.apache.log4j.Logger;

/**
 * 共通ロガークラス
 *
 * @author tsubaki
 *
 */
public class CommonLogger extends Logger{

    /**
     * コンストラクタ
     * @param name クラス名
     */
    protected CommonLogger(String name) {
        super(name);
    }

    /**
     * infoレベルログ出力
     *
     * @param className 実行クラス名称
     * @param message ログメッセージ
     */
    public void info(String className, String message){
        this.info(className, message);
    }

}
