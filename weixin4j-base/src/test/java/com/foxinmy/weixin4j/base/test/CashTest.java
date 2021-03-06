package com.foxinmy.weixin4j.base.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.payment.mch.CorpPayment;
import com.foxinmy.weixin4j.payment.mch.CorpPaymentResult;
import com.foxinmy.weixin4j.payment.mch.Redpacket;
import com.foxinmy.weixin4j.payment.mch.RedpacketRecord;
import com.foxinmy.weixin4j.payment.mch.RedpacketSendResult;
import com.foxinmy.weixin4j.type.MPPaymentCheckNameType;

/**
 * 现金发放测试
 * 
 * @className CashTest
 * @author jy
 * @date 2015年4月1日
 * @since JDK 1.6
 * @see
 */
public class CashTest extends PayTest {

	@Test
	public void sendRedpacket() throws WeixinException, IOException {
		Redpacket redpacket = new Redpacket("HB001", "无忧钱庄",
				"oyFLst1bqtuTcxK-ojF8hOGtLQao", 1d, 1);
		redpacket.setActName("红包测试");
		redpacket.setClientIp("127.0.0.1");
		redpacket.setRemark("快来领取红包吧！");
		redpacket.setWishing("来就送钱");
		RedpacketSendResult result = PAY3.sendRedpack(new FileInputStream(
				caFile), redpacket);
		System.err.println(result);
	}

	@Test
	public void queryRedpacket() throws WeixinException, IOException {
		String outTradeNo = "HB001";
		RedpacketRecord record = PAY3.queryRedpack(new FileInputStream(caFile),
				outTradeNo);
		System.err.println(record);
	}

	@Test
	public void mpPayment() throws WeixinException, IOException {
		CorpPayment payment = new CorpPayment("MP001",
				"ofW1gwok9vZIyle0YbA-eQe83Uk8",
				MPPaymentCheckNameType.NO_CHECK, "企业付款测试", 1d, "127.0.0.1");
		CorpPaymentResult result = PAY3.corpPayment(
				new FileInputStream(caFile), payment);
		System.err.println(result);
	}

	@Test
	public void mchPaymentQuery() throws WeixinException, IOException {
		System.err.println(PAY3.queryCorpPayment(new FileInputStream(caFile),
				"MP001"));
	}
}
