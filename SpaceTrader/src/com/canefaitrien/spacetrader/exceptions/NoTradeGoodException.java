package com.canefaitrien.spacetrader.exceptions;

import com.canefaitrien.spacetrader.models.TradeGood;

public class NoTradeGoodException extends Exception {
	public final TradeGood GOOD;

	public NoTradeGoodException(String message, TradeGood good) {
		super(message);
		GOOD = good;
	}
}