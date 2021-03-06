// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
/**
 * Concrete View of Info Screen
 */

package com.canefaitrien.spacetrader;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.canefaitrien.spacetrader.models.Controller;
import com.canefaitrien.spacetrader.utils.MusicManager;

/**
 * Info page which displays some of the stats of the player
 * 
 * @author Son Nguyen
 * @author Daniel Xiao
 * 
 * @version $Revision: 1.0 $
 */
public class InfoActivity extends RootActivity {

	/**
	 * Field TAG.
	 * (value is ""Info"")
	 */
	private static final String TAG = "Info";

	/**
	 * Field data.
	 */
	private Controller data;

	/**
	 * Field continueMusic.
	 */
	private boolean continueMusic;

	/**
	 * Field infoView.
	 */
	@SuppressWarnings("unused")
	private InfoView infoView; // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.unassignedField, unusedField

	/**
	 * Method called when creating the info page
	 * @param savedInstanceState Bundle
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		// FrameLayout main = new FrameLayout(this);
		// main.setLayoutParams(new
		// LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		// setContentView(main);
		// main.setBackgroundResource(R.drawable.starfield_b);
		//
		// infoView = new InfoView(this);
		// main.addView(infoView);
		// grab data and set data
		data = SpaceTrader.getController();
		Log.d(TAG, "loaded data");
		applyFont();
		populateData();
	}

	/**
	 * Populates the page with data
	 */
	private void populateData() {

		//
		final TextView nameView = (TextView) findViewById(R.id.tv_name);
		final TextView pilotPts = (TextView) findViewById(R.id.tv_pilot);
		final TextView fighterPts = (TextView) findViewById(R.id.tv_fighter);
		final TextView traderPts = (TextView) findViewById(R.id.tv_trader);
		final TextView engineerPts = (TextView) findViewById(R.id.tv_engineer);

		nameView.setText(" " + data.getPlayer().getName());
		pilotPts.setText(" " + data.getPlayer().getPilotPts());
		fighterPts.setText(" " + data.getPlayer().getFighterPts());
		traderPts.setText(" " + data.getPlayer().getTraderPts());
		engineerPts.setText(" " + data.getPlayer().getEngineerPts());

		final TextView currentPlanet = (TextView) findViewById(R.id.tv_planet);
		final TextView money = (TextView) findViewById(R.id.tv_money);

		currentPlanet.setText("Current planet: " + data.getLocation().getName()
				+ "\nTech Level: " + data.getLocation().getStringTechLevel()
				+ "\nSituation: " + data.getLocation().getStringSituation());
		money.setText("$" + String.valueOf(data.getMoney()));
	}

	/**
	 * Method applyFont.
	 */
	public void applyFont() {
		final ViewGroup activityViewGroup = (ViewGroup) findViewById(
				android.R.id.content).getRootView();
		setAppFont(activityViewGroup, appFont);
	}

	/**
	 * called when paused
	 */
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "onPause called.");
		if (!continueMusic) {
			MusicManager.pause();
		}
	}

	/**
	 * called when resumed
	 */
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume called.");
		continueMusic = true;
		MusicManager.start(this, MusicManager.MUSIC_GAME);
		populateData();
		// infoView.invalidate();
	}

	/**
	 * called when started
	 */
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart called.");
	}

	/**
	 * called when stopped
	 */
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "onStop called.");
	}

	/**
	 * called when restarted
	 */
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "onRestart called.");
	}

	// /**
	// * called when destroyed
	// */
	// protected void onDestroy() {
	// super.onDestroy();
	// }

}
