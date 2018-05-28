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
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.TextView;
import android.app.Activity;
import android.content.SharedPreferences;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.webkit.WebViewClient;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RungameActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private FloatingActionButton _fab;
	private String M41L = "";
	private String P01n = "";
	private String P455 = "";
	private String PxUctpSgNfA = "";
	private String EncryptedTextMail = "";
	private String EncryptedTextPoin = "";
	private String EncryptedTextPass = "";
	private String N0p3 = "";
	private String DecryptedTextPhone = "";
	private HashMap<String, Object> map = new HashMap<>();
	private double p10 = 0;
	
	private ArrayList<String> listAkun = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout l_ads;
	private LinearLayout webdanload;
	private LinearLayout webview;
	private LinearLayout loading;
	private LinearLayout linear2;
	private WebView webview1;
	private TextView email;
	private TextView phone;
	private TextView pass;
	private TextView poin;
	
	private SharedPreferences Lut19Lin11Fan17_;
	private AlertDialog.Builder dialogIntro;
	private AlertDialog.Builder dialog_keluar;
	private TimerTask timerMain;
	private Intent i_konten = new Intent();
	private SharedPreferences G7YtJQ;
	private DatabaseReference S3rvDat4b453 = _firebase.getReference("S3rvDat4b453");
	private ChildEventListener _S3rvDat4b453_child_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.rungame);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_fab = (FloatingActionButton) findViewById(R.id._fab);
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		l_ads = (LinearLayout) findViewById(R.id.l_ads);
		webdanload = (LinearLayout) findViewById(R.id.webdanload);
		webview = (LinearLayout) findViewById(R.id.webview);
		loading = (LinearLayout) findViewById(R.id.loading);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		email = (TextView) findViewById(R.id.email);
		phone = (TextView) findViewById(R.id.phone);
		pass = (TextView) findViewById(R.id.pass);
		poin = (TextView) findViewById(R.id.poin);
		Lut19Lin11Fan17_ = getSharedPreferences("Lut19Lin11Fan17_", Activity.MODE_PRIVATE);
		dialogIntro = new AlertDialog.Builder(this);
		dialog_keluar = new AlertDialog.Builder(this);
		G7YtJQ = getSharedPreferences("G7YtJQ", Activity.MODE_PRIVATE);
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				webview.setVisibility(View.GONE);
				loading.setVisibility(View.VISIBLE);
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				webview.setVisibility(View.VISIBLE);
				loading.setVisibility(View.GONE);
				super.onPageFinished(_param1, _param2);
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				webview1.loadUrl(webview1.getUrl());
				webview1.getSettings().setJavaScriptEnabled(true);
				
				
				webview1.getSettings().setLoadWithOverviewMode(true); webview1.getSettings().setUseWideViewPort(true); final WebSettings webSettings = webview1.getSettings(); final String newUserAgent; newUserAgent = "Mozilla/5.0 (Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"; webSettings.setUserAgentString(newUserAgent);
			}
		});
		
		_S3rvDat4b453_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				map = new Gson().fromJson(new Gson().toJson(_childValue), new TypeToken<HashMap<String, Object>>(){}.getType());
				listAkun.add(map.get("email").toString());
				listAkun.add(map.get("phone").toString());
				listAkun.add(map.get("pass").toString());
				listAkun.add(map.get("poin").toString());
				if (map.get("phone").toString().equals(DecryptedTextPhone)) {
					poin.setText(map.get("poin").toString());
					email.setText(map.get("email").toString());
					pass.setText(map.get("pass").toString());
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				map = new Gson().fromJson(new Gson().toJson(_childValue), new TypeToken<HashMap<String, Object>>(){}.getType());
				listAkun.add(map.get("email").toString());
				listAkun.add(map.get("phone").toString());
				listAkun.add(map.get("pass").toString());
				listAkun.add(map.get("poin").toString());
				if (map.get("phone").toString().equals(DecryptedTextPhone)) {
					poin.setText(map.get("poin").toString());
					email.setText(map.get("email").toString());
					pass.setText(map.get("pass").toString());
				}
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
		S3rvDat4b453.addChildEventListener(_S3rvDat4b453_child_listener);
	}
	private void initializeLogic() {
		setTitle("Game");
		S3rvDat4b453.addChildEventListener(_S3rvDat4b453_child_listener);
		_dialogAwal();
		_actionDecrypt();
		ProgressBar cpb = new ProgressBar(RungameActivity.this);  loading.addView(cpb);
		if (Lut19Lin11Fan17_.getString("switchG", "").equals("1")) {
			webview1.loadUrl("https://otoclash.com/game/pacman/");
			webview1.getSettings().setJavaScriptEnabled(true);
			
			
			webview1.getSettings().setLoadWithOverviewMode(true); webview1.getSettings().setUseWideViewPort(true); final WebSettings webSettings = webview1.getSettings(); final String newUserAgent; newUserAgent = "Mozilla/5.0 (Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"; webSettings.setUserAgentString(newUserAgent);
		}
		else {
			if (Lut19Lin11Fan17_.getString("switchG", "").equals("2")) {
				webview1.loadUrl("https://otoclash.com/game/clumsybird/clumsybird/");
				webview1.getSettings().setJavaScriptEnabled(true);
				
				
				webview1.getSettings().setLoadWithOverviewMode(true); webview1.getSettings().setUseWideViewPort(true); final WebSettings webSettings = webview1.getSettings(); final String newUserAgent; newUserAgent = "Mozilla/5.0 (Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"; webSettings.setUserAgentString(newUserAgent);
			}
			else {
				if (Lut19Lin11Fan17_.getString("switchG", "").equals("3")) {
					webview1.loadUrl("https://otoclash.com/game/hextris/");
					webview1.getSettings().setJavaScriptEnabled(true);
					
					
					webview1.getSettings().setLoadWithOverviewMode(true); webview1.getSettings().setUseWideViewPort(true); final WebSettings webSettings = webview1.getSettings(); final String newUserAgent; newUserAgent = "Mozilla/5.0 (Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"; webSettings.setUserAgentString(newUserAgent);
				}
			}
		}
	}
	
	@Override
	public void onBackPressed() {
		webview1.loadUrl("http://blank.org");
		dialog_keluar.setTitle("Keluar");
		dialog_keluar.setMessage("Kamu Akan Meninggalkan Game dan Kembali ke Halaman Utama ?");
		dialog_keluar.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				i_konten.setClass(getApplicationContext(), KontenActivity.class);
				i_konten.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(i_konten);
				finish();
			}
		});
		dialog_keluar.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		dialog_keluar.create().show();
	}
	private void _dialogAwal () {
		dialogIntro.setTitle("Perlu Diketahui !");
		dialogIntro.setView(R.layout.notifgame);
		dialogIntro.setPositiveButton("Tutup", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				SketchwareUtil.showMessage(getApplicationContext(), "Selamat Bermain");
				timerMain = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								SketchwareUtil.showMessage(getApplicationContext(), "Misi Sukses, Poin Ditambah. Kamu bisa keluar atau tetap lanjut bermain");
								p10 = Double.parseDouble(poin.getText().toString()) + 10;
								map = new HashMap<>();
								map.put("email", email.getText().toString());
								map.put("phone", phone.getText().toString());
								map.put("pass", pass.getText().toString());
								map.put("poin", String.valueOf((long)(p10)));
								S3rvDat4b453.push().updateChildren(map);
							}
						});
					}
				};
				_timer.schedule(timerMain, (int)(30000));
			}
		});
		dialogIntro.create().show();
	}
	
	
	private void _encrypt () {
	}
	private String encrypt(String Data) throws Exception {
		javax.crypto.spec.SecretKeySpec key = generateKey();
		javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES");
		c.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes());
		return Base64.encodeToString(encVal, Base64.DEFAULT);
	}
	
	
	private void _decrypt () {
	}
	private String decrypt(String outputString) throws Exception {
		javax.crypto.spec.SecretKeySpec key = generateKey();
		javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES");
		c.init(javax.crypto.Cipher.DECRYPT_MODE, key);
		byte[] decodeValue = Base64.decode(outputString, Base64.DEFAULT);
		byte[] decValue = c.doFinal(decodeValue);
		return new String(decValue);
	}
	
	
	private void _keyCript () {
	}
	private javax.crypto.spec.SecretKeySpec generateKey() throws Exception {
		final java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
		byte[] bytes = PxUctpSgNfA.getBytes("UTF-8");
		digest.update(bytes, 0, bytes.length);
		byte[] key = digest.digest();
		return new javax.crypto.spec.SecretKeySpec(key, "AES");
	}
	
	
	private void _actionEncrypt () {
		M41L = email.getText().toString();
		P01n = poin.getText().toString();
		P455 = pass.getText().toString();
		PxUctpSgNfA = "Q53Gs6K1U31U8ZgURuCpWISkWjgRlrvSqvQcJFkj0JA";
		try {
			EncryptedTextMail = encrypt(M41L);
			EncryptedTextPoin = encrypt(P01n);
			EncryptedTextPass = encrypt(P455);
			Lut19Lin11Fan17_.edit().putString("PcM79DM", EncryptedTextMail).commit();
			Lut19Lin11Fan17_.edit().putString("za1PVO+S8nQ", EncryptedTextPoin).commit();
			Lut19Lin11Fan17_.edit().putString("PxUctpSgNfA", EncryptedTextPass).commit();
		} catch (Exception e){
			SketchwareUtil.showMessage(getApplicationContext(), "Encrypt Failed");
		}
	}
	
	
	private void _actionDecrypt () {
		N0p3 = G7YtJQ.getString("T2tCbA", "");
		PxUctpSgNfA = "Q53Gs6K1U31U8ZgURuCpWISkWjgRlrvSqvQcJFkj0JA";
		try {
			DecryptedTextPhone = decrypt(N0p3);
			phone.setText(DecryptedTextPhone);
		} catch (Exception e){
			SketchwareUtil.showMessage(getApplicationContext(), "Decrypt Data Failed");
		}
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
