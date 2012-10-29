package com.canefaitrien.spacetrader;

import android.app.Application;
import com.canefaitrien.spacetrader.models.GameData;

public class SpaceTraderApplication extends Application {
	private static GameData data;


	public static void setData(GameData data) {
		SpaceTraderApplication.data = data;
	}
	
	public static GameData getData() {
		return data;
	}
}

