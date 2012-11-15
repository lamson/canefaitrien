package com.canefaitrien.spacetrader;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.utils.AbstractActivity;

//This class should have the actions for clicking a planet
public class GalaxyMapActivity extends AbstractActivity implements OnTouchListener {

	private GalaxyView galaxy;

	LinearLayout galaxyLayout;
	Button button;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("Galaxy", "Created Galaxy");
		galaxyLayout = (LinearLayout) findViewById(R.id.galaxy_layout);
		// draw planets
		galaxy = new GalaxyView(this,SpaceTrader.getController().getUniverse());
		galaxy.setBackgroundColor(Color.BLACK);
		galaxy.setOnTouchListener(this);

		
		setContentView(galaxy);
		//setContentView(galaxyLayout);
		
		//galaxyLayout.addView(galaxy);
		
		//button = new Button(this);
		//galaxyLayout.addView(button);
		

	}
	public void onCreateDialog(String planetName) {
	    AlertDialog.Builder builder = new AlertDialog.Builder(this);//getActivity());
	    builder.setTitle(""+planetName);
	    builder.setMessage("It's a Planet");
	    String[] strs = new String[2];
	    strs[0] = "Option";
	    strs[1] = "hei";
	    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
	    	 public void onClick(DialogInterface dialog, int which) {
	    		 //Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
	           }
	    });
	    
	    builder.setItems(strs, new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int which) {
	               // The 'which' argument contains the index position
	               // of the selected item
	           }
	    });
	    AlertDialog alert = builder.create();
	    alert.show();
	}

	public boolean onTouch(View v, MotionEvent e) {
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			Log.d("Galaxy", "ActionDown" +  (int)e.getRawX() + " " +  (int)e.getRawY());
			for(Planet p : SpaceTrader.getController().getUniverse()) {
				if(p.isClicked(new Point((int)e.getRawX(), (int)e.getRawY()))){
					Log.d("Galaxy", "clicked " +p.getName());
					// need some sort of popup to invoke move
					onCreateDialog(p.getName());
				}
			}

		}
		return true;
	}
}
