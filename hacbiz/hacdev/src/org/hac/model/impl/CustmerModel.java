/**
 * [module]
 * CustmerModel.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.model.impl;

import java.util.List;
import java.util.Map;

/**
 * クラス
 *
 * @author tsubaki
 *
 */
public class CustmerModel extends CommonModel {

	/** 顧客管理No */
	private String custmerMngNo;
	
	/** 氏名（姓） */
	private String custmerNameFirst;
	
	/** ふりがな（姓） */
	private String custmerNameFirstRead;
	
	/** 氏名（名） */
	private String custmerNameLast;
	
	/** ふりがな（名） */
	private String custmerNameLastRead;
	
	/** 性別 */
	private String custmerGender;
	
	/** 年齢 */
	private String custmerAge;
	
	/** 住所（都道府県） */
	private String custmerAddress1;
	
	/** 住所（市町村区） */
	private String custmerAddress2;
	
	/** 住所（その他） */
	private String custmerAddress3;
	
	/** TEL（自宅） */
	private String custmerTel;
	
	/** TEL（携帯） */
	private String custmerTelCell;
	
	/** Eメールアドレス（個人） */
	private String custmerEmail;
	
	/** 勤務先（会社名） */
	private String custmerEmployment;
	
	/** 勤務先（連絡先） */
	private String custmerEmploymentTel;
	
	/** Eメールアドレス（会社） */
	private String custmerEmploymentEmail;
	
	/** メールマガジン配信先 */
	private String sendEmailType;
	
	/** 初回来店日 */
	private String fristVisitDate;
	
	/** 顧客登録日 */
	private String custmerRegistDate;
	
	/** カード会員種類 */
	private String memberType;
	
	/** カード会員番号 */
	private String memberDist;
	
	/** 顧客データリスト */
	private List<Map<String, Object>> custmerDataMapList;

	/**
	 * 顧客管理No
	 * @return 顧客管理No
	 */
	public String getCustmerMngNo() {
		return custmerMngNo;
	}

	/**
	 * 顧客管理No
	 * @param custmerMngNo 顧客管理No
	 */
	public void setCustmerMngNo(String custmerMngNo) {
		this.custmerMngNo = custmerMngNo;
	}
	
	/**
	 * @return custmerNameFirst
	 */
	public String getCustmerNameFirst() {
		return custmerNameFirst;
	}

	/**
	 * @param custmerNameFirst 設定する custmerNameFirst
	 */
	public void setCustmerNameFirst(String custmerNameFirst) {
		this.custmerNameFirst = custmerNameFirst;
	}

	/**
	 * @return custmerNameFirstRead
	 */
	public String getCustmerNameFirstRead() {
		return custmerNameFirstRead;
	}

	/**
	 * @param custmerNameFirstRead 設定する custmerNameFirstRead
	 */
	public void setCustmerNameFirstRead(String custmerNameFirstRead) {
		this.custmerNameFirstRead = custmerNameFirstRead;
	}

	/**
	 * @return custmerNameLast
	 */
	public String getCustmerNameLast() {
		return custmerNameLast;
	}

	/**
	 * @param custmerNameLast 設定する custmerNameLast
	 */
	public void setCustmerNameLast(String custmerNameLast) {
		this.custmerNameLast = custmerNameLast;
	}

	/**
	 * @return custmerNameLastRead
	 */
	public String getCustmerNameLastRead() {
		return custmerNameLastRead;
	}

	/**
	 * @param custmerNameLastRead 設定する custmerNameLastRead
	 */
	public void setCustmerNameLastRead(String custmerNameLastRead) {
		this.custmerNameLastRead = custmerNameLastRead;
	}

	/**
	 * @return custmerGender
	 */
	public String getCustmerGender() {
		return custmerGender;
	}

	/**
	 * @param custmerGender 設定する custmerGender
	 */
	public void setCustmerGender(String custmerGender) {
		this.custmerGender = custmerGender;
	}

	/**
	 * @return custmerAge
	 */
	public String getCustmerAge() {
		return custmerAge;
	}

	/**
	 * @param custmerAge 設定する custmerAge
	 */
	public void setCustmerAge(String custmerAge) {
		this.custmerAge = custmerAge;
	}

	/**
	 * @return custmerAddress1
	 */
	public String getCustmerAddress1() {
		return custmerAddress1;
	}

	/**
	 * @param custmerAddress1 設定する custmerAddress1
	 */
	public void setCustmerAddress1(String custmerAddress1) {
		this.custmerAddress1 = custmerAddress1;
	}

	/**
	 * @return custmerAddress2
	 */
	public String getCustmerAddress2() {
		return custmerAddress2;
	}

	/**
	 * @param custmerAddress2 設定する custmerAddress2
	 */
	public void setCustmerAddress2(String custmerAddress2) {
		this.custmerAddress2 = custmerAddress2;
	}

	/**
	 * @return custmerAddress3
	 */
	public String getCustmerAddress3() {
		return custmerAddress3;
	}

	/**
	 * @param custmerAddress3 設定する custmerAddress3
	 */
	public void setCustmerAddress3(String custmerAddress3) {
		this.custmerAddress3 = custmerAddress3;
	}

	/**
	 * @return custmerTel
	 */
	public String getCustmerTel() {
		return custmerTel;
	}

	/**
	 * @param custmerTel 設定する custmerTel
	 */
	public void setCustmerTel(String custmerTel) {
		this.custmerTel = custmerTel;
	}

	/**
	 * @return custmerTelCell
	 */
	public String getCustmerTelCell() {
		return custmerTelCell;
	}

	/**
	 * @param custmerTelCell 設定する custmerTelCell
	 */
	public void setCustmerTelCell(String custmerTelCell) {
		this.custmerTelCell = custmerTelCell;
	}

	/**
	 * @return custmerEmail
	 */
	public String getCustmerEmail() {
		return custmerEmail;
	}

	/**
	 * @param custmerEmail 設定する custmerEmail
	 */
	public void setCustmerEmail(String custmerEmail) {
		this.custmerEmail = custmerEmail;
	}

	/**
	 * @return custmerEmployment
	 */
	public String getCustmerEmployment() {
		return custmerEmployment;
	}

	/**
	 * @param custmerEmployment 設定する custmerEmployment
	 */
	public void setCustmerEmployment(String custmerEmployment) {
		this.custmerEmployment = custmerEmployment;
	}

	/**
	 * @return custmerEmploymentTel
	 */
	public String getCustmerEmploymentTel() {
		return custmerEmploymentTel;
	}

	/**
	 * @param custmerEmploymentTel 設定する custmerEmploymentTel
	 */
	public void setCustmerEmploymentTel(String custmerEmploymentTel) {
		this.custmerEmploymentTel = custmerEmploymentTel;
	}

	/**
	 * @return custmerEmploymentEmail
	 */
	public String getCustmerEmploymentEmail() {
		return custmerEmploymentEmail;
	}

	/**
	 * @param custmerEmploymentEmail 設定する custmerEmploymentEmail
	 */
	public void setCustmerEmploymentEmail(String custmerEmploymentEmail) {
		this.custmerEmploymentEmail = custmerEmploymentEmail;
	}

	/**
	 * @return sendEmailType
	 */
	public String getSendEmailType() {
		return sendEmailType;
	}

	/**
	 * @param sendEmailType 設定する sendEmailType
	 */
	public void setSendEmailType(String sendEmailType) {
		this.sendEmailType = sendEmailType;
	}

	/**
	 * @return fristVisitDate
	 */
	public String getFristVisitDate() {
		return fristVisitDate;
	}

	/**
	 * @param fristVisitDate 設定する fristVisitDate
	 */
	public void setFristVisitDate(String fristVisitDate) {
		this.fristVisitDate = fristVisitDate;
	}

	/**
	 * @return custmerRegistDate
	 */
	public String getCustmerRegistDate() {
		return custmerRegistDate;
	}

	/**
	 * @param custmerRegistDate 設定する custmerRegistDate
	 */
	public void setCustmerRegistDate(String custmerRegistDate) {
		this.custmerRegistDate = custmerRegistDate;
	}

	/**
	 * @return memberType
	 */
	public String getMemberType() {
		return memberType;
	}

	/**
	 * @param memberType 設定する memberType
	 */
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	/**
	 * @return memberDist
	 */
	public String getMemberDist() {
		return memberDist;
	}

	/**
	 * @param memberDist 設定する memberDist
	 */
	public void setMemberDist(String memberDist) {
		this.memberDist = memberDist;
	}

	/**
	 * 顧客データリストを取得する
	 * @return 顧客データリスト
	 */
	public List<Map<String, Object>> getCustmerDataMapList() {
		return custmerDataMapList;
	}

	/**
	 * 顧客データリストを設定する
	 * @param custmerDataMapList 顧客データリスト
	 */
	public void setCustmerDataMapList(List<Map<String, Object>> custmerDataMapList) {
		this.custmerDataMapList = custmerDataMapList;
	}
	
}

