/**
 * [module] EmailSend.java Copyright (c) 2014 M.Tsubaki This software is
 * released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */

package org.hac.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.tsrvfw.constant.ActionCommonConst;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.service.AbstractService;

import com.sun.mail.smtp.SMTPTransport;

/**
 * Email送信コンポーネント
 *
 * @author tsubaki
 */
public class EmailSend extends AbstractService {

	/*
	 * (非 Javadoc)
	 *
	 * @see org.tsrvfw.service.AbstractService#executeService(java.util.Map)
	 */
	@Override
	protected Map<String, Object> executeService(Map<String, Object> inputData)
			throws TsrvfwBusinessException {
		Properties objPrp = new Properties();
		objPrp.put("mail.smtp.host", "smtp.gmail.com"); // SMTPサーバ名
	      // 認証（する）
		objPrp.put("mail.smpt.auth", "true");
	      // ポート指定（サブミッションポート）
		objPrp.put("mail.smtp.port", "587");
		// STARTTLSによる暗号化（する）
		objPrp.put("mail.smtp.starttls.enable", "true");
		// メールセッションを確立
		Session session = Session.getDefaultInstance(objPrp, null);
		// 送信メッセージを生成
		MimeMessage objMsg = new MimeMessage(session);
		SMTPTransport t = null;
		try {
			// 送信先（TOのほか、CCやBCCも設定可能）
			objMsg.setRecipients(Message.RecipientType.TO, "bizdevtm200@gmail.com");
			// Fromヘッダ

			InternetAddress objFrm = new InternetAddress("tsuba999@gmail.com", "M.tsubaki");

			objMsg.setFrom(objFrm);
			// 件名
			objMsg.setSubject("メールテスト", "ISO-2022-JP");

			// 本文
			objMsg.setText("こんにちは", "ISO-2022-JP");

			t = (SMTPTransport) session.getTransport("smtp");
			t.connect("smtp.gmail.com", "bizdevtm200@gmail.com", "Pbizdevtm200");
	        t.sendMessage(objMsg, objMsg.getAllRecipients());
			// メール送信
		} catch (UnsupportedEncodingException e) {
			log.error("送信失敗！");
			log.error(e);
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO 自動生成された catch ブロック
			log.error("送信失敗！！！");
			log.error(e);
			e.printStackTrace();
		} finally {
			if (t != null) {
				try {
					t.close();
				} catch (MessagingException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(ActionCommonConst.RESULT_CODE, ActionCommonConst.RESULT_SUCCESS);
		return resultMap;
	}

}
