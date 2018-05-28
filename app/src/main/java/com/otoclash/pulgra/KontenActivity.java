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
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.widget.LinearLayout;
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.graphics.Typeface;

public class KontenActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private FloatingActionButton _fab;
	private DrawerLayout _drawer;
	private double klikmenu = 0;
	private String N0p3 = "";
	private String PxUctpSgNfA = "";
	private String DecryptedTextPhone = "";
	private HashMap<String, Object> map = new HashMap<>();
	private HashMap<String, Object> informasi = new HashMap<>();
	private double jam = 0;
	private double menit = 0;
	private double detik = 0;
	private double cek = 0;
	private double timerEllapse = 0;
	private double p15 = 0;
	private double P05 = 0;
	private HashMap<String, Object> cekRating = new HashMap<>();
	private double P100 = 0;
	private double P50 = 0;
	private double P1 = 0;
	
	private ArrayList<String> listAkun = new ArrayList<>();
	private ArrayList<String> listNilai = new ArrayList<>();
	
	private LinearLayout lay1;
	private LinearLayout lay_sidemenu_konten;
	private LinearLayout lay_footer;
	private LinearLayout lay_isi_konten;
	private LinearLayout lay_head_menu;
	private LinearLayout layout_pebagi_konten;
	private Button tombol_layberanda;
	private Button tombol_laybooster;
	private Button tombol_laypesanadmin;
	private Button tombol_kegame;
	private LinearLayout layout_beranda;
	private LinearLayout layout_boosterpoin;
	private LinearLayout lay_pesan_admin;
	private LinearLayout lay_header;
	private ScrollView vscrollberanda;
	private LinearLayout linear42;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private ImageView imageview16;
	private TextView textview20;
	private TextView hitungwaktuon;
	private TextView nope_akun;
	private TextView textview2;
	private TextView poin_akun;
	private LinearLayout horisontal_beranda;
	private LinearLayout linear46;
	private LinearLayout linear33;
	private LinearLayout linear45;
	private LinearLayout linear47;
	private TextView tanggal;
	private LinearLayout linear48;
	private TextView teks_absenharian;
	private ImageView gambar_absenharian;
	private ImageView imageview18;
	private Button follow_ig;
	private ImageView imageview20;
	private Button like_fb;
	private LinearLayout layout_ads_medium;
	private ScrollView vscroll1;
	private LinearLayout linear32;
	private LinearLayout linear34;
	private LinearLayout linear35;
	private LinearLayout linear36;
	private ImageView gambar_bagikan;
	private TextView teks_bagikan;
	private ImageView gambar_ratingapp;
	private TextView teks_ratingapp;
	private TextView nilai_app;
	private ImageView gambar_boosterpoin;
	private TextView teks_boosterpoin;
	private LinearLayout linear37;
	private ScrollView vscroll2;
	private ImageView imageview15;
	private TextView textview17;
	private LinearLayout linear38;
	private TextView pesan_admin;
	private TextView textview19;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_linear10;
	private ScrollView _drawer_vscroll1;
	private ImageView _drawer_imageview1;
	private LinearLayout _drawer_linear2;
	private LinearLayout _drawer_hubungiadmin;
	private LinearLayout _drawer_ketentuanpengguna;
	private LinearLayout _drawer_penukaranpoin;
	private LinearLayout _drawer_tentangkami;
	private LinearLayout _drawer_linear8;
	private LinearLayout _drawer_igpulgra;
	private LinearLayout _drawer_facebookpulgra;
	private ImageView _drawer_imageview2;
	private TextView _drawer_textview1;
	private ImageView _drawer_imageview4;
	private TextView _drawer_textview3;
	private ImageView _drawer_imageview5;
	private TextView _drawer_textview4;
	private ImageView _drawer_imageview3;
	private TextView _drawer_textview2;
	private TextView _drawer_textview6;
	private ImageView _drawer_imageview6;
	private TextView _drawer_textview5;
	private ImageView _drawer_imageview7;
	private TextView _drawer_textview7;
	
	private AlertDialog.Builder keluar_d;
	private ObjectAnimator animasiSideMenu = new ObjectAnimator();
	private Intent i_brows_ext = new Intent();
	private SharedPreferences G7YtJQ;
	private DatabaseReference pesanSistem = _firebase.getReference("pesanSistem");
	private ChildEventListener _pesanSistem_child_listener;
	private TimerTask runTimeCheckUpdate;
	private Intent i_kontakkami = new Intent();
	private Intent i_tentangkami = new Intent();
	private Intent i_terms = new Intent();
	private Intent i_tukarpulsa = new Intent();
	private TimerTask tmr_durasiOn;
	private Calendar tanggalan = Calendar.getInstance();
	private TimerTask delayAddPoin;
	private DatabaseReference cekRatingApp = _firebase.getReference("cekRatingApp");
	private ChildEventListener _cekRatingApp_child_listener;
	private AlertDialog.Builder kasih_nilai_d;
	private AlertDialog.Builder videoreward_d;
	private TimerTask tmr_autoAds;
	private DatabaseReference S3rvDat4b453 = _firebase.getReference("S3rvDat4b453");
	private ChildEventListener _S3rvDat4b453_child_listener;
	private Intent i_game = new Intent();
	private TimerTask progdial_dismis;
	private AlertDialog.Builder donasi;
	private Intent i_igfollow = new Intent();
	private Intent i_fblike = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.konten);
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
		
		_drawer = (DrawerLayout) findViewById(R.id._drawer);ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(KontenActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);
		
		lay1 = (LinearLayout) findViewById(R.id.lay1);
		lay_sidemenu_konten = (LinearLayout) findViewById(R.id.lay_sidemenu_konten);
		lay_footer = (LinearLayout) findViewById(R.id.lay_footer);
		lay_isi_konten = (LinearLayout) findViewById(R.id.lay_isi_konten);
		lay_head_menu = (LinearLayout) findViewById(R.id.lay_head_menu);
		layout_pebagi_konten = (LinearLayout) findViewById(R.id.layout_pebagi_konten);
		tombol_layberanda = (Button) findViewById(R.id.tombol_layberanda);
		tombol_laybooster = (Button) findViewById(R.id.tombol_laybooster);
		tombol_laypesanadmin = (Button) findViewById(R.id.tombol_laypesanadmin);
		tombol_kegame = (Button) findViewById(R.id.tombol_kegame);
		layout_beranda = (LinearLayout) findViewById(R.id.layout_beranda);
		layout_boosterpoin = (LinearLayout) findViewById(R.id.layout_boosterpoin);
		lay_pesan_admin = (LinearLayout) findViewById(R.id.lay_pesan_admin);
		lay_header = (LinearLayout) findViewById(R.id.lay_header);
		vscrollberanda = (ScrollView) findViewById(R.id.vscrollberanda);
		linear42 = (LinearLayout) findViewById(R.id.linear42);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		imageview16 = (ImageView) findViewById(R.id.imageview16);
		textview20 = (TextView) findViewById(R.id.textview20);
		hitungwaktuon = (TextView) findViewById(R.id.hitungwaktuon);
		nope_akun = (TextView) findViewById(R.id.nope_akun);
		textview2 = (TextView) findViewById(R.id.textview2);
		poin_akun = (TextView) findViewById(R.id.poin_akun);
		horisontal_beranda = (LinearLayout) findViewById(R.id.horisontal_beranda);
		linear46 = (LinearLayout) findViewById(R.id.linear46);
		linear33 = (LinearLayout) findViewById(R.id.linear33);
		linear45 = (LinearLayout) findViewById(R.id.linear45);
		linear47 = (LinearLayout) findViewById(R.id.linear47);
		tanggal = (TextView) findViewById(R.id.tanggal);
		linear48 = (LinearLayout) findViewById(R.id.linear48);
		teks_absenharian = (TextView) findViewById(R.id.teks_absenharian);
		gambar_absenharian = (ImageView) findViewById(R.id.gambar_absenharian);
		imageview18 = (ImageView) findViewById(R.id.imageview18);
		follow_ig = (Button) findViewById(R.id.follow_ig);
		imageview20 = (ImageView) findViewById(R.id.imageview20);
		like_fb = (Button) findViewById(R.id.like_fb);
		layout_ads_medium = (LinearLayout) findViewById(R.id.layout_ads_medium);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear32 = (LinearLayout) findViewById(R.id.linear32);
		linear34 = (LinearLayout) findViewById(R.id.linear34);
		linear35 = (LinearLayout) findViewById(R.id.linear35);
		linear36 = (LinearLayout) findViewById(R.id.linear36);
		gambar_bagikan = (ImageView) findViewById(R.id.gambar_bagikan);
		teks_bagikan = (TextView) findViewById(R.id.teks_bagikan);
		gambar_ratingapp = (ImageView) findViewById(R.id.gambar_ratingapp);
		teks_ratingapp = (TextView) findViewById(R.id.teks_ratingapp);
		nilai_app = (TextView) findViewById(R.id.nilai_app);
		gambar_boosterpoin = (ImageView) findViewById(R.id.gambar_boosterpoin);
		teks_boosterpoin = (TextView) findViewById(R.id.teks_boosterpoin);
		linear37 = (LinearLayout) findViewById(R.id.linear37);
		vscroll2 = (ScrollView) findViewById(R.id.vscroll2);
		imageview15 = (ImageView) findViewById(R.id.imageview15);
		textview17 = (TextView) findViewById(R.id.textview17);
		linear38 = (LinearLayout) findViewById(R.id.linear38);
		pesan_admin = (TextView) findViewById(R.id.pesan_admin);
		textview19 = (TextView) findViewById(R.id.textview19);
		_drawer_linear1 = (LinearLayout) _nav_view.findViewById(R.id.linear1);
		_drawer_linear10 = (LinearLayout) _nav_view.findViewById(R.id.linear10);
		_drawer_vscroll1 = (ScrollView) _nav_view.findViewById(R.id.vscroll1);
		_drawer_imageview1 = (ImageView) _nav_view.findViewById(R.id.imageview1);
		_drawer_linear2 = (LinearLayout) _nav_view.findViewById(R.id.linear2);
		_drawer_hubungiadmin = (LinearLayout) _nav_view.findViewById(R.id.hubungiadmin);
		_drawer_ketentuanpengguna = (LinearLayout) _nav_view.findViewById(R.id.ketentuanpengguna);
		_drawer_penukaranpoin = (LinearLayout) _nav_view.findViewById(R.id.penukaranpoin);
		_drawer_tentangkami = (LinearLayout) _nav_view.findViewById(R.id.tentangkami);
		_drawer_linear8 = (LinearLayout) _nav_view.findViewById(R.id.linear8);
		_drawer_igpulgra = (LinearLayout) _nav_view.findViewById(R.id.igpulgra);
		_drawer_facebookpulgra = (LinearLayout) _nav_view.findViewById(R.id.facebookpulgra);
		_drawer_imageview2 = (ImageView) _nav_view.findViewById(R.id.imageview2);
		_drawer_textview1 = (TextView) _nav_view.findViewById(R.id.textview1);
		_drawer_imageview4 = (ImageView) _nav_view.findViewById(R.id.imageview4);
		_drawer_textview3 = (TextView) _nav_view.findViewById(R.id.textview3);
		_drawer_imageview5 = (ImageView) _nav_view.findViewById(R.id.imageview5);
		_drawer_textview4 = (TextView) _nav_view.findViewById(R.id.textview4);
		_drawer_imageview3 = (ImageView) _nav_view.findViewById(R.id.imageview3);
		_drawer_textview2 = (TextView) _nav_view.findViewById(R.id.textview2);
		_drawer_textview6 = (TextView) _nav_view.findViewById(R.id.textview6);
		_drawer_imageview6 = (ImageView) _nav_view.findViewById(R.id.imageview6);
		_drawer_textview5 = (TextView) _nav_view.findViewById(R.id.textview5);
		_drawer_imageview7 = (ImageView) _nav_view.findViewById(R.id.imageview7);
		_drawer_textview7 = (TextView) _nav_view.findViewById(R.id.textview7);
		keluar_d = new AlertDialog.Builder(this);
		G7YtJQ = getSharedPreferences("G7YtJQ", Activity.MODE_PRIVATE);
		kasih_nilai_d = new AlertDialog.Builder(this);
		videoreward_d = new AlertDialog.Builder(this);
		donasi = new AlertDialog.Builder(this);
		
		tombol_layberanda.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				tombol_layberanda.setBackgroundColor(0xFFF06292);
				tombol_laybooster.setBackgroundColor(0xFFEC407A);
				tombol_laypesanadmin.setBackgroundColor(0xFFEC407A);
				layout_beranda.setVisibility(View.VISIBLE);
				layout_boosterpoin.setVisibility(View.GONE);
				lay_pesan_admin.setVisibility(View.GONE);
			}
		});
		
		tombol_laybooster.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				tombol_layberanda.setBackgroundColor(0xFFEC407A);
				tombol_laybooster.setBackgroundColor(0xFFF06292);
				tombol_laypesanadmin.setBackgroundColor(0xFFEC407A);
				layout_beranda.setVisibility(View.GONE);
				layout_boosterpoin.setVisibility(View.VISIBLE);
				lay_pesan_admin.setVisibility(View.GONE);
			}
		});
		
		tombol_laypesanadmin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				tombol_layberanda.setBackgroundColor(0xFFEC407A);
				tombol_laybooster.setBackgroundColor(0xFFEC407A);
				tombol_laypesanadmin.setBackgroundColor(0xFFF06292);
				layout_beranda.setVisibility(View.GONE);
				layout_boosterpoin.setVisibility(View.GONE);
				lay_pesan_admin.setVisibility(View.VISIBLE);
			}
		});
		
		tombol_kegame.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				i_game.setClass(getApplicationContext(), GamelistActivity.class);
				i_game.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(i_game);
				finish();
			}
		});
		
		teks_absenharian.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (G7YtJQ.getString("date", "").equals(tanggal.getText().toString())) {
					SketchwareUtil.showMessage(getApplicationContext(), "Hari ini kamu sudah absen");
				}
				else {
					G7YtJQ.edit().putString("date", tanggal.getText().toString()).commit();
					_tambahanPoin15();
				}
			}
		});
		
		gambar_absenharian.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (G7YtJQ.getString("date", "").equals(tanggal.getText().toString())) {
					SketchwareUtil.showMessage(getApplicationContext(), "Hari ini kamu sudah absen");
				}
				else {
					G7YtJQ.edit().putString("date", tanggal.getText().toString()).commit();
					_tambahanPoin15();
				}
			}
		});
		
		follow_ig.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				i_igfollow.setAction(Intent.ACTION_VIEW);
				i_igfollow.setData(Uri.parse("https://www.instagram.com"));
				startActivity(i_igfollow);
			}
		});
		
		like_fb.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				i_igfollow.setAction(Intent.ACTION_VIEW);
				i_igfollow.setData(Uri.parse("https://www.facebook.com"));
				startActivity(i_igfollow);
			}
		});
		
		gambar_bagikan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//create dialog builder
				final AlertDialog alertDialog = new AlertDialog.Builder(KontenActivity.this).create();
				
				alertDialog.setCancelable(false);
				
				LayoutInflater inflater = getLayoutInflater();
				//here type R.layout.YOUR_VIEW
				View convertView = (View) inflater.inflate(R.layout.pilahan_bagi_c, null);
				alertDialog.setView(convertView);
				//define it's widgets
				Button btn_wa = (Button) convertView.findViewById(R.id.wa);
				Button btn_fb = (Button) convertView.findViewById(R.id.fb);
				
				//listeners and other codes for dialog
				btn_wa.setOnClickListener(new View.OnClickListener(){
					    public void onClick(View v){
						        alertDialog.dismiss();
						        try {
							            Intent intentwa = new Intent(Intent.ACTION_SEND);
							            intentwa.setType("text/plain");
							            intentwa.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.otoclash.pulgra");
							            intentwa.setPackage("com.whatsapp");
							            startActivity(intentwa);
							        }catch(Exception e){
							            Toast.makeText(KontenActivity.this, "Error! Sepertinya kamu belum instal aplikasi WhatsApp",
							                    Toast.LENGTH_SHORT).show();
							        }
						    }
				});
				btn_fb.setOnClickListener(new View.OnClickListener(){
					    public void onClick(View v){
						        alertDialog.dismiss();
						        try {
							            Intent intentfb = new Intent(Intent.ACTION_SEND);
							            intentfb.setType("text/plain");
							            intentfb.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.otoclash.pulgra");
							            intentfb.setPackage("com.facebook.katana");
							            startActivity(intentfb);
							        }catch(Exception e){
							            Toast.makeText(KontenActivity.this, "Error! Sepertinya kamu belum instal aplikasi Facebook", Toast.LENGTH_SHORT).show();
							        }
						    }
				});
				
				alertDialog.show();
				delayAddPoin = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_tambahanPoin5();
							}
						});
					}
				};
				_timer.schedule(delayAddPoin, (int)(5000));
			}
		});
		
		teks_bagikan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//create dialog builder
				final AlertDialog alertDialog = new AlertDialog.Builder(KontenActivity.this).create();
				
				alertDialog.setCancelable(false);
				
				LayoutInflater inflater = getLayoutInflater();
				//here type R.layout.YOUR_VIEW
				View convertView = (View) inflater.inflate(R.layout.pilahan_bagi_c, null);
				alertDialog.setView(convertView);
				//define it's widgets
				Button btn_wa = (Button) convertView.findViewById(R.id.wa);
				Button btn_fb = (Button) convertView.findViewById(R.id.fb);
				
				//listeners and other codes for dialog
				btn_wa.setOnClickListener(new View.OnClickListener(){
					    public void onClick(View v){
						        alertDialog.dismiss();
						        try {
							            Intent intentwa = new Intent(Intent.ACTION_SEND);
							            intentwa.setType("text/plain");
							            intentwa.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.otoclash.pulgra");
							            intentwa.setPackage("com.whatsapp");
							            startActivity(intentwa);
							        }catch(Exception e){
							            Toast.makeText(KontenActivity.this, "Error! Sepertinya kamu belum instal aplikasi WhatsApp",
							                    Toast.LENGTH_SHORT).show();
							        }
						    }
				});
				btn_fb.setOnClickListener(new View.OnClickListener(){
					    public void onClick(View v){
						        alertDialog.dismiss();
						        try {
							            Intent intentfb = new Intent(Intent.ACTION_SEND);
							            intentfb.setType("text/plain");
							            intentfb.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.otoclash.pulgra");
							            intentfb.setPackage("com.facebook.katana");
							            startActivity(intentfb);
							        }catch(Exception e){
							            Toast.makeText(KontenActivity.this, "Error! Sepertinya kamu belum instal aplikasi Facebook", Toast.LENGTH_SHORT).show();
							        }
						    }
				});
				
				alertDialog.show();
				delayAddPoin = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_tambahanPoin5();
							}
						});
					}
				};
				_timer.schedule(delayAddPoin, (int)(5000));
			}
		});
		
		gambar_ratingapp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (nilai_app.getText().toString().equals("")) {
					kasih_nilai_d.setTitle("Kasih Nilai");
					kasih_nilai_d.setCancelable(false);
					kasih_nilai_d.setView(R.layout.dialog_rating_c);
					kasih_nilai_d.setPositiveButton("IYA", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							cekRating = new HashMap<>();
							cekRating.put("nope", nope_akun.getText().toString());
							cekRating.put("kasihNilai", "1");
							cekRatingApp.push().updateChildren(cekRating);
							final String appPackageName = getPackageName();
							try {
								startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
							}
							catch (android.content.ActivityNotFoundException anfe) {
								startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
							}
							_tambahanPoin50();
						}
					});
					kasih_nilai_d.setNegativeButton("ENGGAK", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							SketchwareUtil.showMessage(getApplicationContext(), "Kamu melewatkan tambahan 50 poin!");
						}
					});
					kasih_nilai_d.create().show();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Kamu sudah pernah kasih rating!");
				}
			}
		});
		
		teks_ratingapp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (nilai_app.getText().toString().equals("")) {
					kasih_nilai_d.setTitle("Kasih Nilai");
					kasih_nilai_d.setCancelable(false);
					kasih_nilai_d.setView(R.layout.dialog_rating_c);
					kasih_nilai_d.setPositiveButton("IYA", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							cekRating = new HashMap<>();
							cekRating.put("nope", nope_akun.getText().toString());
							cekRating.put("kasihNilai", "1");
							cekRatingApp.push().updateChildren(cekRating);
							final String appPackageName = getPackageName();
							try {
								startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
							}
							catch (android.content.ActivityNotFoundException anfe) {
								startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
							}
							_tambahanPoin50();
						}
					});
					kasih_nilai_d.setNegativeButton("ENGGAK", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							SketchwareUtil.showMessage(getApplicationContext(), "Kamu melewatkan tambahan 50 poin!");
						}
					});
					kasih_nilai_d.create().show();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Kamu sudah pernah kasih rating!");
				}
			}
		});
		
		gambar_boosterpoin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				videoreward_d.setTitle("Konfirmasi Video Ads");
				videoreward_d.setMessage("Dengan menekan (Ya) maka anda setuju iklan Video akan ditampilkan.\n\nJika iklan Video tidak muncul mohon ulangi kembali untuk memastikan Tambahan Poin didapatkan");
				videoreward_d.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						SketchwareUtil.showMessage(getApplicationContext(), "Load VideoAds");
						_tambahanPoin50();
					}
				});
				videoreward_d.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				videoreward_d.create().show();
			}
		});
		
		teks_boosterpoin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				videoreward_d.setTitle("Konfirmasi Video Ads");
				videoreward_d.setMessage("Dengan menekan (Ya) maka anda setuju iklan Video akan ditampilkan.\n\nJika iklan Video tidak muncul mohon ulangi kembali untuk memastikan Tambahan Poin didapatkan");
				videoreward_d.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						SketchwareUtil.showMessage(getApplicationContext(), "Load VideoAds");
						_tambahanPoin50();
					}
				});
				videoreward_d.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				videoreward_d.create().show();
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				donasi.setView(R.layout.donasi);
				donasi.setMessage("Kami membuat aplikasi ini dengan waktu dan materi, kami sangat menghargai bantuan anda agar kami berkembang.\n\nHanya dengan menekan Ya, anda sudah membantu semangat kami.\n\n");
				donasi.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						SketchwareUtil.showMessage(getApplicationContext(), "ads show");
					}
				});
				donasi.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				donasi.create().show();
			}
		});
		
		_pesanSistem_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				informasi = new Gson().fromJson(new Gson().toJson(_childValue), new TypeToken<HashMap<String, Object>>(){}.getType());
				G7YtJQ.edit().putString("updateInfoAdmin", informasi.get("pesanDariAdmin").toString()).commit();
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				informasi = new Gson().fromJson(new Gson().toJson(_childValue), new TypeToken<HashMap<String, Object>>(){}.getType());
				G7YtJQ.edit().putString("updateInfoAdmin", informasi.get("pesanDariAdmin").toString()).commit();
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
		pesanSistem.addChildEventListener(_pesanSistem_child_listener);
		
		_cekRatingApp_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				cekRating = new Gson().fromJson(new Gson().toJson(_childValue), new TypeToken<HashMap<String, Object>>(){}.getType());
				if (cekRating.get("nope").toString().equals(nope_akun.getText().toString())) {
					nilai_app.setText(cekRating.get("kasihNilai").toString());
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		cekRatingApp.addChildEventListener(_cekRatingApp_child_listener);
		
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
					
					poin_akun.setText(map.get("poin").toString());
					
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
					
					poin_akun.setText(map.get("poin").toString());
					
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
		
		_drawer_hubungiadmin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				i_kontakkami.setClass(getApplicationContext(), KontakKamiActivity.class);
				i_kontakkami.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(i_kontakkami);
				finish();
			}
		});
		
		_drawer_ketentuanpengguna.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				i_terms.setClass(getApplicationContext(), TermsconditionsActivity.class);
				i_terms.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(i_terms);
				finish();
			}
		});
		
		_drawer_penukaranpoin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				i_tukarpulsa.setClass(getApplicationContext(), PenukaranpoinActivity.class);
				i_tukarpulsa.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(i_tukarpulsa);
				finish();
			}
		});
		
		_drawer_tentangkami.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				i_tentangkami.setClass(getApplicationContext(), TentangkamiActivity.class);
				i_tentangkami.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(i_tentangkami);
				finish();
			}
		});
		
		_drawer_igpulgra.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				
			}
		});
		
		_drawer_facebookpulgra.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				
			}
		});
	}
	private void initializeLogic() {
		_font();
		_actionDecrypt();
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { lay_head_menu.setElevation(15f);}
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { lay_header.setElevation(25f);}
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { layout_ads_medium.setElevation(25f);}
		tombol_layberanda.setBackgroundColor(0xFFF06292);
		tombol_laybooster.setBackgroundColor(0xFFEC407A);
		tombol_laypesanadmin.setBackgroundColor(0xFFEC407A);
		tombol_layberanda.setVisibility(View.VISIBLE);
		layout_boosterpoin.setVisibility(View.GONE);
		lay_pesan_admin.setVisibility(View.GONE);
		_downloadPoinServer();
		_hitunganWaktuOn();
		runTimeCheckUpdate = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						pesan_admin.setText(G7YtJQ.getString("updateInfoAdmin", ""));
						_tanggalHariINI();
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(runTimeCheckUpdate, (int)(100), (int)(100));
	}
	
	@Override
	public void onBackPressed() {
		keluar_d.setTitle("Keluar");
		keluar_d.setMessage("Meninggalkan aplikasi ?");
		keluar_d.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				finishAffinity();
				int pid = android.os.Process.myPid();
				
				android.os.Process.killProcess(pid);
				
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				startActivity(intent);
			}
		});
		keluar_d.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		keluar_d.create().show();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		S3rvDat4b453.addChildEventListener(_S3rvDat4b453_child_listener);
		cekRatingApp.addChildEventListener(_cekRatingApp_child_listener);
		pesanSistem.addChildEventListener(_pesanSistem_child_listener);
		final ProgressDialog prog = new ProgressDialog(KontenActivity.this);
		prog.setIcon(R.drawable.ic_server);
		prog.setMax(100);prog.setTitle("Menghubungkan Server");
		prog.setMessage("Harap Menunggu..........");
		prog.setIndeterminate(true);
		prog.setCancelable(false);
		prog.show();
		progdial_dismis = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (!poin_akun.getText().toString().equals("0")) {
							prog.dismiss();
							progdial_dismis.cancel();
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(progdial_dismis, (int)(100), (int)(100));
	}
	private void _deCryptScript () {
	}
	private String decrypt(String outputString) throws Exception {
		javax.crypto.spec.SecretKeySpec key = generateKey();
		javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES");
		c.init(javax.crypto.Cipher.DECRYPT_MODE, key);
		byte[] decodeValue = Base64.decode(outputString, Base64.DEFAULT);
		byte[] decValue = c.doFinal(decodeValue);
		return new String(decValue);
	}
	
	
	private void _enCryptScript () {
	}
	private String encrypt(String Data) throws Exception {
		javax.crypto.spec.SecretKeySpec key = generateKey();
		javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES");
		c.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes());
		return Base64.encodeToString(encVal, Base64.DEFAULT);
	}
	
	
	private void _keyLockEncrypt () {
	}
	private javax.crypto.spec.SecretKeySpec generateKey() throws Exception {
		final java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
		byte[] bytes = PxUctpSgNfA.getBytes("UTF-8");
		digest.update(bytes, 0, bytes.length);
		byte[] key = digest.digest();
		return new javax.crypto.spec.SecretKeySpec(key, "AES");
	}
	
	
	private void _actionDecrypt () {
		N0p3 = G7YtJQ.getString("T2tCbA", "");
		PxUctpSgNfA = "Q53Gs6K1U31U8ZgURuCpWISkWjgRlrvSqvQcJFkj0JA";
		try {
			DecryptedTextPhone = decrypt(N0p3);
			nope_akun.setText(DecryptedTextPhone);
		} catch (Exception e){
			SketchwareUtil.showMessage(getApplicationContext(), "Decrypt Data Failed");
		}
	}
	
	
	private void _downloadPoinServer () {
		
	}
	
	
	private void _timerEllspse (final double _sec) {
		jam = _sec / 3600;
		menit = (_sec % 3600) / 60;
		detik = _sec % 60;
		hitungwaktuon.setText(String.valueOf((long)(jam)).concat(":").concat(String.valueOf((long)(menit)).concat(":").concat(String.valueOf((long)(detik)))));
	}
	
	
	private void _hitunganWaktuOn () {
		if (cek == 0) {
			tmr_durasiOn = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							timerEllapse++;
							_timerEllspse(timerEllapse);
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(tmr_durasiOn, (int)(1000), (int)(1000));
			cek = 1;
		}
	}
	
	
	private void _tanggalHariINI () {
		tanggal.setText(new SimpleDateFormat("dd/MM/yyyy").format(tanggalan.getTime()));
		tanggalan = Calendar.getInstance();
	}
	
	
	private void _tambahanPoin15 () {
		p15 = Double.parseDouble(poin_akun.getText().toString()) + 15;
		map = new HashMap<>();
		map.put("email", "");
		map.put("phone", nope_akun.getText().toString());
		map.put("pass", "");
		map.put("poin", String.valueOf((long)(p15)));
		S3rvDat4b453.push().updateChildren(map);
	}
	
	
	private void _tambahanPoin5 () {
		P05 = Double.parseDouble(poin_akun.getText().toString()) + 5;
		map = new HashMap<>();
		map.put("email", "");
		map.put("phone", nope_akun.getText().toString());
		map.put("pass", "");
		map.put("poin", String.valueOf((long)(P05)));
		S3rvDat4b453.push().updateChildren(map);
	}
	
	
	private void _tambahPoin100 () {
		P100 = Double.parseDouble(poin_akun.getText().toString()) + 100;
		map = new HashMap<>();
		map.put("email", "");
		map.put("phone", nope_akun.getText().toString());
		map.put("pass", "");
		map.put("poin", String.valueOf((long)(P100)));
		S3rvDat4b453.push().updateChildren(map);
	}
	
	
	private void _tambahanPoin50 () {
		P50 = Double.parseDouble(poin_akun.getText().toString()) + 50;
		map = new HashMap<>();
		map.put("email", "");
		map.put("phone", nope_akun.getText().toString());
		map.put("pass", "");
		map.put("poin", String.valueOf((long)(P50)));
		S3rvDat4b453.push().updateChildren(map);
	}
	
	
	private void _tambahanPoin1 () {
		P1 = Double.parseDouble(poin_akun.getText().toString()) + 1;
		map = new HashMap<>();
		map.put("email", "");
		map.put("phone", nope_akun.getText().toString());
		map.put("pass", "");
		map.put("poin", String.valueOf((long)(P1)));
		S3rvDat4b453.push().updateChildren(map);
	}
	
	
	private void _font () {
		tombol_layberanda.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		tombol_laybooster.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		tombol_laypesanadmin.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		tombol_kegame.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		textview20.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		hitungwaktuon.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		nope_akun.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		poin_akun.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		follow_ig.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		like_fb.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		teks_absenharian.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		tanggal.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		teks_bagikan.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		teks_ratingapp.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		nilai_app.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		teks_boosterpoin.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		textview17.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		pesan_admin.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		textview19.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
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
