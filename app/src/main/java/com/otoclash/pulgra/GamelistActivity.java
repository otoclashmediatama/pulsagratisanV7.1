package com.otoclash.pulgra;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.graphics.Typeface;

public class GamelistActivity extends AppCompatActivity {
	
	
	private LinearLayout linear1;
	private LinearLayout lay_ads;
	private LinearLayout linear3;
	private LinearLayout l_tombol_pacman;
	private LinearLayout l_tombol_clumsybird;
	private LinearLayout l_tombol_hextris;
	private ImageView logo_pacman;
	private TextView mainkan_pacman;
	private ImageView logo_clumsybird;
	private TextView mainkan_clumsybird;
	private ImageView logo_hextris;
	private TextView mainkan_hextris;
	
	private SharedPreferences Lut19Lin11Fan17_;
	private Intent i_rungame = new Intent();
	private Intent i_konten = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.gamelist);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		lay_ads = (LinearLayout) findViewById(R.id.lay_ads);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		l_tombol_pacman = (LinearLayout) findViewById(R.id.l_tombol_pacman);
		l_tombol_clumsybird = (LinearLayout) findViewById(R.id.l_tombol_clumsybird);
		l_tombol_hextris = (LinearLayout) findViewById(R.id.l_tombol_hextris);
		logo_pacman = (ImageView) findViewById(R.id.logo_pacman);
		mainkan_pacman = (TextView) findViewById(R.id.mainkan_pacman);
		logo_clumsybird = (ImageView) findViewById(R.id.logo_clumsybird);
		mainkan_clumsybird = (TextView) findViewById(R.id.mainkan_clumsybird);
		logo_hextris = (ImageView) findViewById(R.id.logo_hextris);
		mainkan_hextris = (TextView) findViewById(R.id.mainkan_hextris);
		Lut19Lin11Fan17_ = getSharedPreferences("Lut19Lin11Fan17_", Activity.MODE_PRIVATE);
		
		logo_pacman.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Lut19Lin11Fan17_.edit().putString("switchG", "1").commit();
				i_rungame.setClass(getApplicationContext(), RungameActivity.class);
				i_rungame.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(i_rungame);
				finish();
			}
		});
		
		mainkan_pacman.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Lut19Lin11Fan17_.edit().putString("switchG", "1").commit();
				Lut19Lin11Fan17_.edit().putString("switchG", "1").commit();
				i_rungame.setClass(getApplicationContext(), RungameActivity.class);
				i_rungame.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(i_rungame);
				finish();
			}
		});
		
		logo_clumsybird.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Lut19Lin11Fan17_.edit().putString("switchG", "2").commit();
				i_rungame.setClass(getApplicationContext(), RungameActivity.class);
				i_rungame.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(i_rungame);
				finish();
			}
		});
		
		mainkan_clumsybird.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Lut19Lin11Fan17_.edit().putString("switchG", "2").commit();
				i_rungame.setClass(getApplicationContext(), RungameActivity.class);
				i_rungame.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(i_rungame);
				finish();
			}
		});
		
		logo_hextris.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Lut19Lin11Fan17_.edit().putString("switchG", "3").commit();
				i_rungame.setClass(getApplicationContext(), RungameActivity.class);
				i_rungame.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(i_rungame);
				finish();
			}
		});
		
		mainkan_hextris.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Lut19Lin11Fan17_.edit().putString("switchG", "3").commit();
				i_rungame.setClass(getApplicationContext(), RungameActivity.class);
				i_rungame.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(i_rungame);
				finish();
			}
		});
	}
	private void initializeLogic() {
		_font();
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { l_tombol_pacman.setElevation(25f);}
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { l_tombol_clumsybird.setElevation(25f);}
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { l_tombol_hextris.setElevation(25f);}
	}
	
	@Override
	public void onBackPressed() {
		i_konten.setClass(getApplicationContext(), KontenActivity.class);
		i_konten.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		startActivity(i_konten);
		finish();
	}
	private void _font () {
		mainkan_pacman.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		mainkan_clumsybird.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		mainkan_hextris.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
