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
import android.widget.EditText;
import android.widget.Button;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.SharedPreferences;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.content.Intent;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.graphics.Typeface;

public class PenukaranpoinActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private String EncryptedTextMail = "";
	private String EncryptedTextPoin = "";
	private String DecryptedTextPhone = "";
	private String PxUctpSgNfA = "";
	private String N0p3 = "";
	private String M41L = "";
	private String P01n = "";
	private String poinmu = "";
	private String DecryptedTextPoinmu = "";
	private double poincek = 0;
	private HashMap<String, Object> dataMapPenarikan = new HashMap<>();
	private String P455 = "";
	private String EncryptedTextPass = "";
	private double angkaPengurangan = 0;
	private double poinSetelahDikurangi = 0;
	private String DecryptedTextPass = "";
	
	private ArrayList<String> listAkunData = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout actionbar;
	private LinearLayout linear3;
	private LinearLayout layout_cekoperator;
	private LinearLayout layout_listoperator;
	private LinearLayout lay_nominalpulsa;
	private LinearLayout linear6;
	private ImageView imageview1;
	private TextView nopeakun;
	private TextView poinkamu;
	private TextView textview2;
	private EditText edittext1;
	private TextView textview1;
	private EditText edittext2;
	private LinearLayout linear4;
	private Button tmbl_cekoperator;
	private LinearLayout layout_loading;
	private LinearLayout loadingbar_layout;
	private TextView textview3;
	private ImageView logo_operator;
	private TextView operator;
	private TextView textview5;
	private TextView nominalpulsa;
	private LinearLayout linear8;
	private LinearLayout linear7;
	private Button tombol_ajukanpulsa;
	private TextView passhiden;
	private TextView feedback_penukaran;
	private TextView emailhiden;
	
	private TimerTask delaycekoperator;
	private SharedPreferences aOMV8otH2Frk4w;
	private SharedPreferences G7YtJQ;
	private TimerTask runtime_check;
	private DatabaseReference hoOKgkC5HO0L8FkDVS0 = _firebase.getReference("hoOKgkC5HO0L8FkDVS0");
	private ChildEventListener _hoOKgkC5HO0L8FkDVS0_child_listener;
	private Intent i_konten = new Intent();
	private TimerTask tmr_otomatisKeKonten;
	private DatabaseReference S3rvDat4b453 = _firebase.getReference("S3rvDat4b453");
	private ChildEventListener _S3rvDat4b453_child_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.penukaranpoin);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		actionbar = (LinearLayout) findViewById(R.id.actionbar);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		layout_cekoperator = (LinearLayout) findViewById(R.id.layout_cekoperator);
		layout_listoperator = (LinearLayout) findViewById(R.id.layout_listoperator);
		lay_nominalpulsa = (LinearLayout) findViewById(R.id.lay_nominalpulsa);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		nopeakun = (TextView) findViewById(R.id.nopeakun);
		poinkamu = (TextView) findViewById(R.id.poinkamu);
		textview2 = (TextView) findViewById(R.id.textview2);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		textview1 = (TextView) findViewById(R.id.textview1);
		edittext2 = (EditText) findViewById(R.id.edittext2);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		tmbl_cekoperator = (Button) findViewById(R.id.tmbl_cekoperator);
		layout_loading = (LinearLayout) findViewById(R.id.layout_loading);
		loadingbar_layout = (LinearLayout) findViewById(R.id.loadingbar_layout);
		textview3 = (TextView) findViewById(R.id.textview3);
		logo_operator = (ImageView) findViewById(R.id.logo_operator);
		operator = (TextView) findViewById(R.id.operator);
		textview5 = (TextView) findViewById(R.id.textview5);
		nominalpulsa = (TextView) findViewById(R.id.nominalpulsa);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		tombol_ajukanpulsa = (Button) findViewById(R.id.tombol_ajukanpulsa);
		passhiden = (TextView) findViewById(R.id.passhiden);
		feedback_penukaran = (TextView) findViewById(R.id.feedback_penukaran);
		emailhiden = (TextView) findViewById(R.id.emailhiden);
		aOMV8otH2Frk4w = getSharedPreferences("aOMV8otH2Frk4w", Activity.MODE_PRIVATE);
		G7YtJQ = getSharedPreferences("G7YtJQ", Activity.MODE_PRIVATE);
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.length() > 4) {
					edittext1.setError("Masukkan di sini hanya 4 Digit Awal Nomer Anda");
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		tmbl_cekoperator.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (edittext1.getText().toString().equals("") && edittext2.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "No HP belum lengkap");
				}
				else {
					layout_loading.setVisibility(View.VISIBLE);
					delaycekoperator = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									_penentuanOperator();
								}
							});
						}
					};
					_timer.schedule(delaycekoperator, (int)(3000));
				}
			}
		});
		
		tombol_ajukanpulsa.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (edittext1.getText().toString().equals("") && edittext2.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "No. HP Tujuan klaim Puksa Belum di isi");
				}
				else {
					if (operator.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Belum Menentukan Operator");
					}
					else {
						dataMapPenarikan = new HashMap<>();
						dataMapPenarikan.put("email", emailhiden.getText().toString());
						dataMapPenarikan.put("nopeAkun", nopeakun.getText().toString());
						dataMapPenarikan.put("nopeTukar", edittext1.getText().toString().concat(edittext2.getText().toString()));
						dataMapPenarikan.put("operator", operator.getText().toString());
						dataMapPenarikan.put("nominal", nominalpulsa.getText().toString());
						hoOKgkC5HO0L8FkDVS0.push().updateChildren(dataMapPenarikan);
						feedback_penukaran.setText("Pengajuan penukaran poin dengan pulsa ".concat(nominalpulsa.getText().toString().concat(" berhasil, kami akan proses paling cepat 1 x 24 Jam. Harap bersabar, terimakasih atas pengertiannya.")));
						_updateDataAkun();
						tmr_otomatisKeKonten = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										i_konten.setClass(getApplicationContext(), KontenActivity.class);
										i_konten.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
										startActivity(i_konten);
										finish();
									}
								});
							}
						};
						_timer.schedule(tmr_otomatisKeKonten, (int)(3000));
					}
				}
			}
		});
		
		_hoOKgkC5HO0L8FkDVS0_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		hoOKgkC5HO0L8FkDVS0.addChildEventListener(_hoOKgkC5HO0L8FkDVS0_child_listener);
		
		_S3rvDat4b453_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				map = new Gson().fromJson(new Gson().toJson(_childValue), new TypeToken<HashMap<String, Object>>(){}.getType());
				listAkunData.add(map.get("email").toString());
				listAkunData.add(map.get("phone").toString());
				listAkunData.add(map.get("pass").toString());
				listAkunData.add(map.get("poin").toString());
				if (map.get("phone").toString().equals(DecryptedTextPhone)) {
					poinkamu.setText(map.get("poin").toString());
					emailhiden.setText(map.get("email").toString());
					passhiden.setText(map.get("pass").toString());
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				map = new Gson().fromJson(new Gson().toJson(_childValue), new TypeToken<HashMap<String, Object>>(){}.getType());
				listAkunData.add(map.get("email").toString());
				listAkunData.add(map.get("phone").toString());
				listAkunData.add(map.get("pass").toString());
				listAkunData.add(map.get("poin").toString());
				if (map.get("phone").toString().equals(DecryptedTextPhone)) {
					poinkamu.setText(map.get("poin").toString());
					emailhiden.setText(map.get("email").toString());
					passhiden.setText(map.get("pass").toString());
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
		_font();
		runtime_check = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_cekNominalPulsa();
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(runtime_check, (int)(100), (int)(100));
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { actionbar.setElevation(25f);}
		layout_loading.setVisibility(View.GONE);
		layout_listoperator.setVisibility(View.GONE);
		lay_nominalpulsa.setVisibility(View.GONE);
		tombol_ajukanpulsa.setVisibility(View.GONE);
		ProgressBar cpb = new ProgressBar(PenukaranpoinActivity.this);  loadingbar_layout.addView(cpb);
		_actionDecryptData();
		_actionEncryptData();
	}
	
	@Override
	public void onBackPressed() {
		i_konten.setClass(getApplicationContext(), KontenActivity.class);
		i_konten.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		startActivity(i_konten);
		finish();
	}
	private void _penentuanOperator () {
		if (edittext1.getText().toString().equals("0811") || (edittext1.getText().toString().equals("0812") || (edittext1.getText().toString().equals("0813") || (edittext1.getText().toString().equals("0821") || (edittext1.getText().toString().equals("0822") || (edittext1.getText().toString().equals("0823") || (edittext1.getText().toString().equals("0852") || edittext1.getText().toString().equals("0853")))))))) {
			operator.setText("Telkomsel");
			logo_operator.setImageResource(R.drawable.telkomsel);
			layout_cekoperator.setVisibility(View.GONE);
			layout_listoperator.setVisibility(View.VISIBLE);
			lay_nominalpulsa.setVisibility(View.VISIBLE);
		}
		else {
			if (edittext1.getText().toString().equals("0814") || (edittext1.getText().toString().equals("0815") || (edittext1.getText().toString().equals("0816") || (edittext1.getText().toString().equals("0855") || (edittext1.getText().toString().equals("0856") || (edittext1.getText().toString().equals("0857") || edittext1.getText().toString().equals("0858"))))))) {
				operator.setText("Indosat");
				logo_operator.setImageResource(R.drawable.indosat);
				layout_cekoperator.setVisibility(View.GONE);
				layout_listoperator.setVisibility(View.VISIBLE);
				lay_nominalpulsa.setVisibility(View.VISIBLE);
			}
			else {
				if (edittext1.getText().toString().equals("0817") || (edittext1.getText().toString().equals("0818") || (edittext1.getText().toString().equals("0819") || (edittext1.getText().toString().equals("0859") || (edittext1.getText().toString().equals("0877") || (edittext1.getText().toString().equals("0878") || edittext1.getText().toString().equals("0879"))))))) {
					operator.setText("XL");
					logo_operator.setImageResource(R.drawable.myxl);
					layout_cekoperator.setVisibility(View.GONE);
					layout_listoperator.setVisibility(View.VISIBLE);
					lay_nominalpulsa.setVisibility(View.VISIBLE);
				}
				else {
					if (edittext1.getText().toString().equals("0896") || (edittext1.getText().toString().equals("0897") || (edittext1.getText().toString().equals("0898") || edittext1.getText().toString().equals("0899")))) {
						operator.setText("Three");
						logo_operator.setImageResource(R.drawable.three);
						layout_cekoperator.setVisibility(View.GONE);
						layout_listoperator.setVisibility(View.VISIBLE);
						lay_nominalpulsa.setVisibility(View.VISIBLE);
					}
					else {
						if (edittext1.getText().toString().equals("0831") || edittext1.getText().toString().equals("0838")) {
							operator.setText("AXIS");
							logo_operator.setImageResource(R.drawable.axis);
							layout_cekoperator.setVisibility(View.GONE);
							layout_listoperator.setVisibility(View.VISIBLE);
							lay_nominalpulsa.setVisibility(View.VISIBLE);
						}
						else {
							SketchwareUtil.showMessage(getApplicationContext(), "Operator No. HP kamu tidak kami dukung");
							layout_loading.setVisibility(View.VISIBLE);
						}
					}
				}
			}
		}
	}
	
	
	private void _encryptData () {
	}
	private String encrypt(String Data) throws Exception {
		javax.crypto.spec.SecretKeySpec key = generateKey();
		javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES");
		c.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes());
		return Base64.encodeToString(encVal, Base64.DEFAULT);
	}
	
	
	private void _decryptData () {
	}
	private String decrypt(String outputString) throws Exception {
		javax.crypto.spec.SecretKeySpec key = generateKey();
		javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES");
		c.init(javax.crypto.Cipher.DECRYPT_MODE, key);
		byte[] decodeValue = Base64.decode(outputString, Base64.DEFAULT);
		byte[] decValue = c.doFinal(decodeValue);
		return new String(decValue);
	}
	
	
	private void _keyEncryptData () {
	}
	private javax.crypto.spec.SecretKeySpec generateKey() throws Exception {
		final java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
		byte[] bytes = PxUctpSgNfA.getBytes("UTF-8");
		digest.update(bytes, 0, bytes.length);
		byte[] key = digest.digest();
		return new javax.crypto.spec.SecretKeySpec(key, "AES");
	}
	
	
	private void _actionDecryptData () {
		N0p3 = G7YtJQ.getString("T2tCbA", "");
		PxUctpSgNfA = "Q53Gs6K1U31U8ZgURuCpWISkWjgRlrvSqvQcJFkj0JA";
		try {
			DecryptedTextPhone = decrypt(N0p3);
			nopeakun.setText(DecryptedTextPhone);
		} catch (Exception e){
			SketchwareUtil.showMessage(getApplicationContext(), "Decrypt Data Failed");
		}
	}
	
	
	private void _actionEncryptData () {
		M41L = emailhiden.getText().toString();
		P01n = poinkamu.getText().toString();
		P455 = passhiden.getText().toString();
		PxUctpSgNfA = "Q53Gs6K1U31U8ZgURuCpWISkWjgRlrvSqvQcJFkj0JA";
		try {
			EncryptedTextMail = encrypt(M41L);
			EncryptedTextPoin = encrypt(P01n);
			EncryptedTextPass = encrypt(P455);
			aOMV8otH2Frk4w.edit().putString("PcM79DM", EncryptedTextMail).commit();
			aOMV8otH2Frk4w.edit().putString("za1PVO+S8nQ", EncryptedTextPoin).commit();
			aOMV8otH2Frk4w.edit().putString("PxUctpSgNfA", EncryptedTextPass).commit();
		} catch (Exception e){
			SketchwareUtil.showMessage(getApplicationContext(), "Encrypt Failed");
		}
	}
	
	
	private void _cekNominalPulsa () {
		if (Double.parseDouble(poinkamu.getText().toString()) < 10000) {
			nominalpulsa.setText("0");
			tombol_ajukanpulsa.setVisibility(View.GONE);
		}
		else {
			if ((Double.parseDouble(poinkamu.getText().toString()) > 10000) && ((Double.parseDouble(poinkamu.getText().toString()) < 50000) || (Double.parseDouble(poinkamu.getText().toString()) == 10000))) {
				nominalpulsa.setText("10,000");
				tombol_ajukanpulsa.setVisibility(View.VISIBLE);
			}
			else {
				if ((Double.parseDouble(poinkamu.getText().toString()) > 50000) && ((Double.parseDouble(poinkamu.getText().toString()) < 100000) || (Double.parseDouble(poinkamu.getText().toString()) == 50000))) {
					nominalpulsa.setText("50,000");
					tombol_ajukanpulsa.setVisibility(View.VISIBLE);
				}
				else {
					if ((Double.parseDouble(poinkamu.getText().toString()) > 100000) || (Double.parseDouble(poinkamu.getText().toString()) == 100000)) {
						nominalpulsa.setText("100,000");
						tombol_ajukanpulsa.setVisibility(View.VISIBLE);
					}
					else {
						nominalpulsa.setText("Failed");
					}
				}
			}
		}
	}
	
	
	private void _penguranganPoin () {
		if (nominalpulsa.getText().toString().equals("10,000")) {
			angkaPengurangan = 1000;
		}
		else {
			if (nominalpulsa.getText().toString().equals("50,000")) {
				angkaPengurangan = 5000;
			}
			else {
				if (nominalpulsa.getText().toString().equals("100,000")) {
					angkaPengurangan = 10000;
				}
			}
		}
		poinSetelahDikurangi = Double.parseDouble(poinkamu.getText().toString()) - angkaPengurangan;
	}
	
	
	private void _updateDataAkun () {
		_penguranganPoin();
		map = new HashMap<>();
		map.put("email", emailhiden.getText().toString());
		map.put("phone", nopeakun.getText().toString());
		map.put("pass", passhiden.getText().toString());
		map.put("poin", String.valueOf((long)(poinSetelahDikurangi)));
		S3rvDat4b453.push().updateChildren(map);
	}
	
	
	private void _font () {
		nopeakun.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		poinkamu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		edittext1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		edittext2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		tmbl_cekoperator.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		operator.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		nominalpulsa.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		tombol_ajukanpulsa.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		passhiden.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		feedback_penukaran.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		emailhiden.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
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
