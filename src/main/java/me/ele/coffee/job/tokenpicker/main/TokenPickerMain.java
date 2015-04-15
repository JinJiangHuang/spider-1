package me.ele.coffee.job.tokenpicker.main;

import java.io.IOException;

import me.ele.coffee.job.tokenpicker.manager.TokenManager;
import me.ele.coffee.job.tokenpicker.model.Token;
import me.ele.coffee.job.tokenpicker.utils.HttpClientUtils;
import me.ele.coffee.job.tokenpicker.utils.JsonHelper;
import me.ele.coffee.job.tokenpicker.utils.WechatUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

/**
 * @author lonaking
 */
public class TokenPickerMain {
	final static Logger logger = LoggerFactory.getLogger(TokenPickerMain.class);

	private static TokenManager manager = new TokenManager();
	
	protected ApplicationContext applicationContext;
	
	protected boolean isInterrupted;
	
	public TokenPickerMain() {
		
	}
	
	private WorkStatus workStatus;
	/**
	 * 当前spider的状态
	 * @author lonaking
	 */
	public static enum WorkStatus {
		Active, Standby
	}

	public static void main(String[] args) throws IOException {
		
		while(true){
			if(manager.getCurrentToken() == null){
				String string = HttpClientUtils.httpsGet(WechatUtils.TOKEN_URL);
				Token token = JsonHelper.transJsonStringToObj(string, Token.class);
				manager.setCurrentToken(token);
				manager.setCreateTime(System.currentTimeMillis());
				manager.setExpiredTime(System.currentTimeMillis()+token.getExpires_in());
				logger.debug("token成功存储{}",token.getAccess_token());
			}
			logger.debug("token成功存储{}",manager.getCurrentToken().getAccess_token());
		}
	}

}
