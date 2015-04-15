package me.ele.coffee.job.tokenpicker.manager;

import java.sql.Timestamp;

import me.ele.coffee.job.tokenpicker.model.Token;

public class TokenManager {
	

	private Token lastToken;

	private Token currentToken;

	private long createTime;

	private long expiredTime;

	public static Token getNewToken(String url) {
		return null;
	}

	public Token getLastToken() {
		return lastToken;
	}

	public void setLastToken(Token lastToken) {
		this.lastToken = lastToken;
	}

	public Token getCurrentToken() {
		return currentToken;
	}

	public void setCurrentToken(Token currentToken) {
		this.currentToken = currentToken;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public long getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(long expiredTime) {
		this.expiredTime = expiredTime;
	}

}
