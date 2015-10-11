/**
 * [module]
 * DateUtils.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.tsrvfw.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.tsrvfw.exception.TsrvfwSystemException;

/**
 * 日付ユーティリティクラス
 * 
 * @author tsubaki
 * 
 */
public class DateUtils {

	/** 指定DATEフォーマット yyyy */
	public static final String DATE_FORMAT_YYYY = "yyyy";

	/** 指定DATEフォーマット MM */
	public static final String DATE_FORMAT_MM = "MM";

	/** 指定DATEフォーマット dd */
	public static final String DATE_FORMAT_DD = "dd";

	/** 指定DATEフォーマット yyyy */
	public static final String DATE_FORMAT_FULL = "yyyy-MM-dd hh:mm:ss";

	/**
	 * 現在サーバ時刻取得
	 * 
	 * @return 現在サーバ時刻
	 */
	public static Date getSystemDate() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}

	/**
	 * 現在サーバ時刻取得(UnixTimestamp)
	 * @return 現在サーバ時刻(UnixTimestamp)
	 */
	public static long getSystemDateUnixTimestamp() {
		return System.currentTimeMillis() / 1000L;
	}
	
	/**
	 * 日付データ（YYYY-MM-DD）をUnixTmpstampへ変換する
	 * 表示のデリミタ（例「-」）は指定できる。
	 * @param dateValueOfYyyyMmDd 指定日付データ
	 * @param delimiter 日付データの各要素仕切り文字列
	 * @return 変換後のunix timestamp
	 * @throws TsrvfwSystemException 指定日付データをDateオブジェクトに変換できなかった場合
	 */
	public static long editStringDateToUnixTimestamp(String dateValueOfYyyyMmDd, String delimiter) throws TsrvfwSystemException{
		long retValue = 0;
		// 引数チェック
		if (!LogicUtils.isNotEmptyString(dateValueOfYyyyMmDd) || !LogicUtils.isNotEmptyString(delimiter)){
			return retValue;
		}
		String editedDateValueOfYyyyMmDd = dateValueOfYyyyMmDd.replaceAll(delimiter, "/");
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy/MM/dd HH:mm:ss");
		try {
			Date d = format.parse(editedDateValueOfYyyyMmDd + " 00:00:00");
			retValue = d.getTime() / 1000;
		} catch (ParseException e) {
			throw new TsrvfwSystemException(e, "日付変換に失敗しました　引数=" + dateValueOfYyyyMmDd);
		}
		return retValue;
	}

	/**
	 * 指定Dateフォーマット処理
	 * 
	 * @param targetDate
	 *            指定Date
	 * @param format
	 *            フォーマット形式
	 * @return 指定フォーマットDate
	 */
	public static String getFormatDate(Date targetDate, String format) {
		SimpleDateFormat fomatter = new SimpleDateFormat(format);
		return fomatter.format(targetDate);
	}

	/**
	 * 曜日名取得
	 * 
	 * @param calendar
	 *            Calendarインスタンス
	 * @param targetDay
	 *            対象日付
	 * @return 曜日名称
	 */
	public static String getDayOfWeekName(Calendar calendar, int targetDay) {
		String dayOfWeek = "";
		if (calendar != null) {
			calendar.set(Calendar.DATE, targetDay);
			switch (calendar.get(Calendar.DAY_OF_WEEK)) {
			case Calendar.SUNDAY:
				dayOfWeek = "日";
				break;
			case Calendar.MONDAY:
				dayOfWeek = "月";
				break;
			case Calendar.TUESDAY:
				dayOfWeek = "火";
				break;
			case Calendar.WEDNESDAY:
				dayOfWeek = "水";
				break;
			case Calendar.THURSDAY:
				dayOfWeek = "木";
				break;
			case Calendar.FRIDAY:
				dayOfWeek = "金";
				break;
			case Calendar.SATURDAY:
				dayOfWeek = "土";
				break;
			}
		}
		return dayOfWeek;
	}
}
