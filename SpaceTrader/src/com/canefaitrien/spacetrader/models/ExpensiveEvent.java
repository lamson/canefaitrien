package com.canefaitrien.spacetrader.models;

/**
 * Create expensive event
 * @author apham9
 * @date 10/18/2012
 *
 */
// Radical price increase event, when this even happens on a planet, 
// the price may increase astronomically
public enum ExpensiveEvent {
	DESERT,
	LIFELESS,
	POORSOIL,
	MINERALPOOR,
	NEVER
};