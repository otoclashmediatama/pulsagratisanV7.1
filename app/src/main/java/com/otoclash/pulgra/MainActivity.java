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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.content.Context;
import android.os.Vibrator;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.graphics.Typeface;

public class MainActivity extends AppCompatActivity {
	
	
	private double n = 0;
	private HashMap<String, Object> firebasedata = new HashMap<>();
	private HashMap<String, Object> serverstatus = new HashMap<>();
	
	private ArrayList<String> inf = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear8;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear7;
	private LinearLayout linear11;
	private LinearLayout halamanakun;
	private ImageView imageintro;
	private TextView intro;
	private Button tombol_masuk;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private ImageView imageview1;
	private ImageView imageview2;
	private ImageView imageview3;
	private ImageView imageview4;
	private ImageView imageview5;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private TextView next;
	
	private Vibrator gtr;
	private Intent i_cek123 = new Intent();
	private AlertDialog.Builder pendahuluan;
	private SharedPreferences G7YtJQ;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		halamanakun = (LinearLayout) findViewById(R.id.halamanakun);
		imageintro = (ImageView) findViewById(R.id.imageintro);
		intro = (TextView) findViewById(R.id.intro);
		tombol_masuk = (Button) findViewById(R.id.tombol_masuk);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		next = (TextView) findViewById(R.id.next);
		gtr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		pendahuluan = new AlertDialog.Builder(this);
		G7YtJQ = getSharedPreferences("G7YtJQ", Activity.MODE_PRIVATE);
		
		tombol_masuk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				G7YtJQ.edit().putString("intro", "1").commit();
				i_cek123.setClass(getApplicationContext(), Cekcek123Activity.class);
				i_cek123.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(i_cek123);
				finish();
			}
		});
		
		next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				n++;
				if (n == 1) {
					imageintro.setImageResource(R.drawable.masukimage);
					intro.setText("Setiap harinya jangan lupa absen masuk, biar kamu dapat bonus coin");
					imageview1.setImageResource(R.drawable.bundarputih);
					imageview2.setImageResource(R.drawable.bundarhitam);
				}
				else {
					if (n == 2) {
						imageintro.setImageResource(R.drawable.bagikan);
						intro.setText("Jangan lupa bagikan ke temen, biar kamu tambah banyak coin");
						imageview1.setImageResource(R.drawable.bundarputih);
						imageview2.setImageResource(R.drawable.bundarputih);
						imageview3.setImageResource(R.drawable.bundarhitam);
					}
					else {
						if (n == 3) {
							imageintro.setImageResource(R.drawable.rateapp);
							intro.setText("Kalau kamu suka, kasih bintang aku biar kamu aku kasih tambah coin");
							imageview1.setImageResource(R.drawable.bundarputih);
							imageview2.setImageResource(R.drawable.bundarputih);
							imageview3.setImageResource(R.drawable.bundarputih);
							imageview4.setImageResource(R.drawable.bundarhitam);
						}
						else {
							if (n == 4) {
								imageintro.setImageResource(R.drawable.logogame);
								intro.setText("Mainkan Game Dapatkan Poinnya");
								imageview1.setImageResource(R.drawable.bundarputih);
								imageview2.setImageResource(R.drawable.bundarputih);
								imageview3.setImageResource(R.drawable.bundarputih);
								imageview4.setImageResource(R.drawable.bundarputih);
								imageview5.setImageResource(R.drawable.bundarhitam);
							}
							else {
								if (n == 5) {
									halamanakun.setVisibility(View.VISIBLE);
									linear11.setVisibility(View.GONE);
									next.setVisibility(View.INVISIBLE);
								}
							}
						}
					}
				}
			}
		});
	}
	private void initializeLogic() {
		_font();
		if (G7YtJQ.getString("intro", "").equals("1")) {
			i_cek123.setClass(getApplicationContext(), Cekcek123Activity.class);
			i_cek123.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(i_cek123);
			finish();
		}
		else {
			n = 0;
			imageintro.setImageResource(R.drawable.coinkepulsa);
			intro.setText("Kumpulin coin, nanti kalau sudah mencukupi tukar sama pulsa");
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { linear2.setElevation(25f);}
			android.graphics.drawable.GradientDrawable linearLy = new android.graphics.drawable.GradientDrawable();  linearLy.setColor(Color.WHITE);  linearLy.setCornerRadius(25);  linear2.setBackground(linearLy);
		}
		pendahuluan.setTitle("Perlu Diketahui");
		pendahuluan.setMessage("Selamat datang di aplikasi Pulsa Gratisan\n\nWajib Baca Sebelum Menggunakan:\n\n1. Aplikasi ini berisi iklan\n\n2. Iklan yang tampil adalah poin untuk kalian\n\n3. Poin yang akan terkumpul yang nanti ditukar dengan pulsa\n\nDengan poin - poin di atas, kalian memahami dan menyetujui keberadaan iklan yang tampil di aplikasi ini");
		setTheme(android.R.style.Theme_Material);
		pendahuluan.setPositiveButton("Ya, saya setuju", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				SketchwareUtil.showMessage(getApplicationContext(), "Terimakasih");
			}
		});
		pendahuluan.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				SketchwareUtil.showMessage(getApplicationContext(), "Sampai jumpa");
				finish();
			}
		});
		pendahuluan.create().show();
	}
	
	@Override
	public void onBackPressed() {
		
	}
	private void _font () {
		intro.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		tombol_masuk.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		next.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
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
