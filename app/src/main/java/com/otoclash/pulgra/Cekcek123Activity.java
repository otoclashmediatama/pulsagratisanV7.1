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
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import java.util.Timer;
import java.util.TimerTask;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.graphics.Typeface;

public class Cekcek123Activity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map_cek = new HashMap<>();
	private HashMap<String, Object> serverstatus = new HashMap<>();
	
	private ArrayList<String> inf = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear5;
	private TextView textinter;
	private ImageView imginter;
	private LinearLayout linear6;
	private LinearLayout linear4;
	private LinearLayout l_load;
	private Button update_ok;
	private Button update_ng;
	
	private TimerTask cek;
	private DatabaseReference versiAPK = _firebase.getReference("versiAPK");
	private ChildEventListener _versiAPK_child_listener;
	private Intent i_downloadUpdate = new Intent();
	private TimerTask tmr_unInstall;
	private SharedPreferences G7YtJQ;
	private Intent i_loginreg = new Intent();
	private ObjectAnimator animasiSinyal = new ObjectAnimator();
	private DatabaseReference infoServer = _firebase.getReference("infoServer");
	private ChildEventListener _infoServer_child_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.cekcek123);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		textinter = (TextView) findViewById(R.id.textinter);
		imginter = (ImageView) findViewById(R.id.imginter);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		l_load = (LinearLayout) findViewById(R.id.l_load);
		update_ok = (Button) findViewById(R.id.update_ok);
		update_ng = (Button) findViewById(R.id.update_ng);
		G7YtJQ = getSharedPreferences("G7YtJQ", Activity.MODE_PRIVATE);
		
		update_ok.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (G7YtJQ.getString("zstate_us", "").equals("off")) {
					//create dialog builder
					final AlertDialog alertDialog = new AlertDialog.Builder(Cekcek123Activity.this).create();
					LayoutInflater inflater = getLayoutInflater();
					//here type R.layout.YOUR_VIEW
					View convertView = (View) inflater.inflate(R.layout.server_off, null);
					alertDialog.setView(convertView);
					//define it's widgets
					Button okbt = (Button) convertView.findViewById(R.id.okbt);
					
					//listeners and other codes for dialog
					okbt.setOnClickListener(new View.OnClickListener(){
						    public void onClick(View v){
							        alertDialog.dismiss();
							        finishAffinity();
							int pid = android.os.Process.myPid();
							
							android.os.Process.killProcess(pid);
							
							Intent intent = new Intent(Intent.ACTION_MAIN);
							intent.addCategory(Intent.CATEGORY_HOME);
							startActivity(intent);
							    }
					});
					
					alertDialog.show();
				}
				else {
					i_loginreg.setClass(getApplicationContext(), LoginregActivity.class);
					i_loginreg.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
					startActivity(i_loginreg);
					finish();
				}
			}
		});
		
		update_ng.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (G7YtJQ.getString("GPS", "").equals("yes")) {
					final String appPackageName = getPackageName();
					try {
						startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
					}
					catch (android.content.ActivityNotFoundException anfe) {
						startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "10 Detik lagi versi lama akan di un-install");
					tmr_unInstall = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									Uri packageURI = Uri.parse("package:".concat("com.otoclash.pulgra")); Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI); startActivity(uninstallIntent);
								}
							});
						}
					};
					_timer.schedule(tmr_unInstall, (int)(10000));
					i_downloadUpdate.setAction(Intent.ACTION_VIEW);
					i_downloadUpdate.setData(Uri.parse("https://otoclash.com/appdownload/"));
					startActivity(i_downloadUpdate);
				}
			}
		});
		
		_versiAPK_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				map_cek = new Gson().fromJson(new Gson().toJson(_childValue), new TypeToken<HashMap<String, Object>>(){}.getType());
				G7YtJQ.edit().putString("onlineCekVersi", map_cek.get("v").toString()).commit();
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				map_cek = new Gson().fromJson(new Gson().toJson(_childValue), new TypeToken<HashMap<String, Object>>(){}.getType());
				G7YtJQ.edit().putString("onlineCekVersi", map_cek.get("v").toString()).commit();
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final String _errorCode = String.valueOf(_param1.getCode());
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		versiAPK.addChildEventListener(_versiAPK_child_listener);
		
		_infoServer_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				serverstatus = new Gson().fromJson(new Gson().toJson(_childValue), new TypeToken<HashMap<String, Object>>(){}.getType());
				inf.add(serverstatus.get("serv").toString());
				G7YtJQ.edit().putString("zstate_us", serverstatus.get("serv").toString()).commit();
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				serverstatus = new Gson().fromJson(new Gson().toJson(_childValue), new TypeToken<HashMap<String, Object>>(){}.getType());
				inf.add(serverstatus.get("serv").toString());
				G7YtJQ.edit().putString("zstate_us", serverstatus.get("serv").toString()).commit();
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final String _errorCode = String.valueOf(_param1.getCode());
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		infoServer.addChildEventListener(_infoServer_child_listener);
	}
	private void initializeLogic() {
		_font();
		ProgressBar hpb = new ProgressBar(this,null, android.R.attr.progressBarStyleHorizontal); l_load.addView(hpb,300,70); hpb.setIndeterminate(true);
		update_ok.setVisibility(View.GONE);
		update_ng.setVisibility(View.GONE);
		G7YtJQ.edit().putString("versiSaat_ini", "7.1").commit();
		G7YtJQ.edit().putString("GPS", "yes").commit();
		textinter.setText("Sedang memeriksa jaringan internet dan versi aplikasi....");
		cek = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						animasiSinyal.setTarget(imginter);
						animasiSinyal.setPropertyName("alpha");
						animasiSinyal.setFloatValues((float)(1), (float)(0.8d));
						animasiSinyal.setDuration((int)(600));
						animasiSinyal.setInterpolator(new LinearInterpolator());
						animasiSinyal.start();
					}
				});
			}
		};
		_timer.schedule(cek, (int)(600));
		cek = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						animasiSinyal.setTarget(imginter);
						animasiSinyal.setPropertyName("alpha");
						animasiSinyal.setFloatValues((float)(0.8d), (float)(0.6d));
						animasiSinyal.setDuration((int)(600));
						animasiSinyal.setInterpolator(new LinearInterpolator());
						animasiSinyal.start();
					}
				});
			}
		};
		_timer.schedule(cek, (int)(1200));
		cek = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						animasiSinyal.setTarget(imginter);
						animasiSinyal.setPropertyName("alpha");
						animasiSinyal.setFloatValues((float)(0.6d), (float)(0.4d));
						animasiSinyal.setDuration((int)(600));
						animasiSinyal.setInterpolator(new LinearInterpolator());
						animasiSinyal.start();
					}
				});
			}
		};
		_timer.schedule(cek, (int)(1800));
		cek = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						animasiSinyal.setTarget(imginter);
						animasiSinyal.setPropertyName("alpha");
						animasiSinyal.setFloatValues((float)(0.4d), (float)(0.2d));
						animasiSinyal.setDuration((int)(600));
						animasiSinyal.setInterpolator(new LinearInterpolator());
						animasiSinyal.start();
					}
				});
			}
		};
		_timer.schedule(cek, (int)(2400));
		cek = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						animasiSinyal.setTarget(imginter);
						animasiSinyal.setPropertyName("alpha");
						animasiSinyal.setFloatValues((float)(0.2d), (float)(1.0d));
						animasiSinyal.setDuration((int)(600));
						animasiSinyal.setInterpolator(new LinearInterpolator());
						animasiSinyal.start();
						imginter.setImageResource(R.drawable.internet_wifi);
						if (G7YtJQ.getString("onlineCekVersi", "").equals(G7YtJQ.getString("versiSaat_ini", ""))) {
							update_ok.setVisibility(View.VISIBLE);
						}
						else {
							update_ng.setVisibility(View.VISIBLE);
						}
						l_load.setVisibility(View.GONE);
					}
				});
			}
		};
		_timer.schedule(cek, (int)(3000));
	}
	
	@Override
	public void onBackPressed() {
		
	}
	private void _font () {
		textinter.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		update_ok.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		update_ng.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
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
