package com.canefaitrien.spacetrader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.canefaitrien.spacetrader.R;
import com.canefaitrien.spacetrader.models.GameData;

public class InfoActivity extends Activity {

	private static final String TAG = "Info";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);

		TextView tv = (TextView) findViewById(R.id.tv_info_content);
		tv.setTextSize(20);

		GameData data = SpaceTrader.getData();

		Log.d(TAG, "loaded data");
		String info = data.getPerson().toString();
		info += "\nMoney: " + data.getMoney();
		info += "\nDifficulty: " + data.getDifficulty();

		Log.d(TAG, "loaded info");

		tv.setText(info);
	}

}
