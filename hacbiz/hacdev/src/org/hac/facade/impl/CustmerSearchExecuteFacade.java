/**
 * [module]
 * CustmerSearchExecuteFacade.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.facade.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hac.model.impl.CustmerModel;
import org.tsrvfw.constant.ActionCommonConst;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.facade.AbstractFacade;
import org.tsrvfw.model.AbstractModel;
import org.tsrvfw.service.AbstractService;

/**
 * クラス
 *
 * @author tsubaki
 *
 */
public class CustmerSearchExecuteFacade extends AbstractFacade {

	/** 業務処理コンポーネント　入力値チェック */
	private AbstractService inputRequireCheck;
	
	/** 業務処理コンポーネント　顧客マスタ検索 */
	private AbstractService searchCustmer;
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Map<String, Object> executeBusiness(AbstractModel model)
			throws TsrvfwSystemException, TsrvfwBusinessException {
		
		// 検索条件を格納
		Map<String, Object> searchConditionMap = new HashMap<String, Object>();
		searchConditionMap.put("hub_mng_no", ((CustmerModel)model).getHubMngNo());
		searchConditionMap.put("custmer_mng_no", ((CustmerModel)model).getCustmerMngNo());
		searchConditionMap.put("custmer_name_first", ((CustmerModel)model).getCustmerNameFirst());
		searchConditionMap.put("custmer_name_last", ((CustmerModel)model).getCustmerNameLast());
		searchConditionMap.put("custmer_name_first_read", ((CustmerModel)model).getCustmerNameFirstRead());
		searchConditionMap.put("custmer_name_last_read", ((CustmerModel)model).getCustmerNameLastRead());
		searchConditionMap.put("custmer_gender", ((CustmerModel)model).getCustmerGender());
		searchConditionMap.put("custmer_age", ((CustmerModel)model).getCustmerAge());
		searchConditionMap.put("custmer_address1", ((CustmerModel)model).getCustmerAddress1());
		searchConditionMap.put("custmer_address2", ((CustmerModel)model).getCustmerAddress2());
		searchConditionMap.put("custmer_address3", ((CustmerModel)model).getCustmerAddress3());
		searchConditionMap.put("custmer_tel", ((CustmerModel)model).getCustmerTel());
		searchConditionMap.put("custmer_tel_cel", ((CustmerModel)model).getCustmerTelCell());
		searchConditionMap.put("custmer_email", ((CustmerModel)model).getCustmerEmail());
		searchConditionMap.put("custmer_employment", ((CustmerModel)model).getCustmerEmployment());
		searchConditionMap.put("custmer_employment_tel", ((CustmerModel)model).getCustmerEmploymentTel());
		searchConditionMap.put("custmer_employment_email", ((CustmerModel)model).getCustmerEmploymentEmail());
		searchConditionMap.put("send_email_type", ((CustmerModel)model).getSendEmailType());
		searchConditionMap.put("first_visit_date", ((CustmerModel)model).getFristVisitDate());
		searchConditionMap.put("custmer_regist_date", ((CustmerModel)model).getCustmerRegistDate());
		searchConditionMap.put("member_type", ((CustmerModel)model).getMemberType());
		searchConditionMap.put("member_dist", ((CustmerModel)model).getMemberDist());
		
		Map<String, Object> searchCustmerResltMap = searchCustmer.execute(searchConditionMap);
		((CustmerModel)model).setCustmerDataMapList((List<Map<String,Object>>)searchCustmerResltMap.get("select_result"));
		// 処理結果Map生成
		Map<String, Object> facadeResultMap = new HashMap<String, Object>();
		facadeResultMap.put(ActionCommonConst.RESULT_CODE,
				ActionCommonConst.RESULT_SUCCESS);
		return facadeResultMap;
	}

	/**
	 * 
	 */
	@Override
	public Map<String, Object> executeBusinessException()
			throws TsrvfwSystemException {
		
		// 処理結果Map生成
		Map<String, Object> facadeResultMap = new HashMap<String, Object>();
		facadeResultMap.put(ActionCommonConst.RESULT_CODE,
				ActionCommonConst.BUSINESS_ERR);
		return facadeResultMap;
	}
	
	/**
	 * 業務処理コンポーネント　入力値チェック
	 * @param service　業務処理コンポーネント　入力値チェック
	 */
	public void setInputRequireCheck(AbstractService service) {
		this.inputRequireCheck = service;
	}
	
	/**
	 * 業務処理コンポーネント　顧客マスタ検索
	 * @param service　業務処理コンポーネント　顧客マスタ検索
	 */
	public void setSearchCustmer(AbstractService service) {
		this.searchCustmer = service;
	}
}

