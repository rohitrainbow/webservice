package com.theimitation.webservice.service;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import com.theimitation.webservice.util.PaytmConstants;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	 @Override
	public String paymentRedirect(String orderId, String custId, String mobileNo, String email, String txnAmount)
			 {
		String merchantMid = PaytmConstants.MID;
		// Key in your staging and production MID available in your dashboard
		String merchantKey = PaytmConstants.MERCHANT_KEY;
		// Key in your staging and production merchant key available in your dashboard
		String channelId = PaytmConstants.CHANNEL_ID;
		String website = PaytmConstants.WEBSITE;
		// This is the staging value. Production value is available in your dashboard
		String industryTypeId = PaytmConstants.INDUSTRY_TYPE_ID;
		// This is the staging value. Production value is available in your dashboard
		String callbackUrl = "http://www.google.com";
		TreeMap<String, String> paytmParams = new TreeMap<String, String>();
		paytmParams.put("MID", merchantMid);
		paytmParams.put("ORDER_ID", orderId);
		paytmParams.put("CHANNEL_ID", channelId);
		paytmParams.put("CUST_ID", custId);
		paytmParams.put("MOBILE_NO", mobileNo);
		paytmParams.put("EMAIL", email);
		paytmParams.put("TXN_AMOUNT", txnAmount);
		paytmParams.put("WEBSITE", website);
		paytmParams.put("INDUSTRY_TYPE_ID", industryTypeId);
		paytmParams.put("CALLBACK_URL", callbackUrl);
		String paytmChecksum=null;
		try {
			paytmChecksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(merchantKey,
					paytmParams);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder outputHtml = new StringBuilder();
		outputHtml.append(
				"<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
		outputHtml.append("<html>");
		outputHtml.append("<head>");
		outputHtml.append("<title>Merchant Checkout Page</title>");
		outputHtml.append("</head>");
		outputHtml.append("<body>");
		outputHtml.append("<center><h1>Please do not refresh this page...</h1></center>");
		String transactionURL = "https://securegw-stage.paytm.in/theia/processTransaction"; // for staging
		// $transactionURL="https://securegw.paytm.in/theia/processTransaction"; // for
		// production
		outputHtml.append("<form method='post' action='" + transactionURL + "' name='f1'>");
		for (Map.Entry<String, String> entry : paytmParams.entrySet()) {
			outputHtml.append("<input type='hidden' name='" + entry.getKey() + "' value='" + entry.getValue() + "'>");
		}
		outputHtml.append("<input type='hidden' name='CHECKSUMHASH' value='" + paytmChecksum + "'>");
		outputHtml.append("</form>");
		outputHtml.append("<script type='text/javascript'>");
		outputHtml.append("document.f1.submit();");
		outputHtml.append("</script>");
		outputHtml.append("</body>");
		outputHtml.append("</html>");
		return outputHtml.toString();
	}

}
