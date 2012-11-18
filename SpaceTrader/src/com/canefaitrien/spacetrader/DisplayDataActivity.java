package com.canefaitrien.spacetrader;

import com.canefaitrien.spacetrader.R;
import com.canefaitrien.spacetrader.models.Marketplace;
import com.canefaitrien.spacetrader.models.Situation;
import com.canefaitrien.spacetrader.models.TechLevel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayDataActivity extends RootActivity {

	private boolean continueMusic;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Get the message from the intent
		Intent intent = getIntent();
		String message = intent
				.getStringExtra(ConfigurationActivity.EXTRA_MESSAGE);

		setContentView(R.layout.activity_display_data);
		TextView textView = (TextView) findViewById(R.id.tv_data);

		// Create the text view
		// TextView textView = new TextView(this);
		textView.setTextSize(20);
		Marketplace mp = new Marketplace(0, TechLevel.HI_TECH,
				Situation.ARTISTIC);
		textView.setText(mp.toString());
		// Set the text view as the activity layout
		// setContentView(textView);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_display_data, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
