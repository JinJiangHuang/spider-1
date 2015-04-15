package me.ele.coffee.job.tokenpicker.utils;

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;

public class WechatUtils {
	private static final String TOKEN = "admin";

	public static final String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_cred"
			+ "ential&appid=wx56dbdd1c379029dd&secret=f3be29b7183e8490032fc21936657457";

	/**
	 * 校验消息是否来自微信
	 * 
	 * @author lonaking
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public boolean checkSignature(String signature, String timestamp,
			String nonce) {
		// dictionary sort
		String[] dataStrings = new String[] { TOKEN, timestamp, nonce };
		Arrays.sort(dataStrings);
		// construct the three string
		String data = dataStrings[0] + dataStrings[1] + dataStrings[2];
		// sha1
		String flag = DigestUtils.shaHex(data);
		// check
		if (flag.equalsIgnoreCase(signature)) {
			return true;
		} else {
			return false;
		}
	}
}
