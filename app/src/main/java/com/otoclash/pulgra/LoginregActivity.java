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
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import android.content.Context;
import android.os.Vibrator;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.view.View;
import android.widget.CompoundButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.graphics.Typeface;

public class LoginregActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String PxUctpSgNfA = "";
	private double p01n4 = 0;
	private String P01n4 = "";
	private String Em41L = "";
	private String N0p3 = "";
	private String P455 = "";
	private String EncryptedTextMail = "";
	private String EncryptedTextPhone = "";
	private String EncryptedTextPass = "";
	private String EncryptedTextPoinA = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String DecryptedTextMail = "";
	private String DecryptedTextPhone = "";
	private String DecryptedTextPass = "";
	private String DecryptedTextPoinA = "";
	
	private ArrayList<String> listmap = new ArrayList<>();
	private ArrayList<String> listloginmap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private CheckBox persetujuan;
	private LinearLayout linear14;
	private Button tombol_daftar;
	private EditText emaireg;
	private EditText nopereg;
	private EditText passreg;
	private TextView termscondition;
	private LinearLayout linear5;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private EditText nopelogin;
	private EditText passlogin;
	private Button tombol_login;
	
	private SharedPreferences G7YtJQ;
	private Intent i_konten = new Intent();
	private Vibrator gtr;
	private Intent i_terms = new Intent();
	private DatabaseReference S3rvDat4b453 = _firebase.getReference("S3rvDat4b453");
	private ChildEventListener _S3rvDat4b453_child_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.loginreg);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		persetujuan = (CheckBox) findViewById(R.id.persetujuan);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		tombol_daftar = (Button) findViewById(R.id.tombol_daftar);
		emaireg = (EditText) findViewById(R.id.emaireg);
		nopereg = (EditText) findViewById(R.id.nopereg);
		passreg = (EditText) findViewById(R.id.passreg);
		termscondition = (TextView) findViewById(R.id.termscondition);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		nopelogin = (EditText) findViewById(R.id.nopelogin);
		passlogin = (EditText) findViewById(R.id.passlogin);
		tombol_login = (Button) findViewById(R.id.tombol_login);
		G7YtJQ = getSharedPreferences("G7YtJQ", Activity.MODE_PRIVATE);
		gtr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		persetujuan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				persetujuan.setChecked(true);
			}
		});
		
		persetujuan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					G7YtJQ.edit().putString("check", "1").commit();
				}
				else {
					G7YtJQ.edit().putString("check", "0").commit();
				}
			}
		});
		
		tombol_daftar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (emaireg.getText().toString().equals("") || (nopereg.getText().toString().equals("") || (passreg.getText().toString().equals("") || G7YtJQ.getString("check", "").equals("")))) {
					SketchwareUtil.showMessage(getApplicationContext(), "Semua Kolom Wajib Di isi !");
				}
				else {
					if (listmap.contains(emaireg.getText().toString()) || listmap.contains(nopereg.getText().toString())) {
						SketchwareUtil.showMessage(getApplicationContext(), "Data sudah terdaftar di server !");
					}
					else {
						_createDATAREG();
						_uploadTOSERVER();
						SketchwareUtil.showMessage(getApplicationContext(), "Register Sukses !👍");
						emaireg.setText("");
						nopereg.setText("");
						passreg.setText("");
						persetujuan.setChecked(false);
						nopelogin.setText(DecryptedTextPhone);
					}
				}
			}
		});
		
		termscondition.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				gtr.vibrate((long)(20));
				i_terms.setClass(getApplicationContext(), TermsconditionActivity.class);
				i_terms.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(i_terms);
				finish();
			}
		});
		
		tombol_login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (listloginmap.contains(nopelogin.getText().toString().concat("π".concat(passlogin.getText().toString())))) {
					SketchwareUtil.showMessage(getApplicationContext(), "Login Berhasil Untuk Akun [ ".concat(nopelogin.getText().toString().concat(" ]")));
					N0p3 = nopelogin.getText().toString();
					PxUctpSgNfA = "Q53Gs6K1U31U8ZgURuCpWISkWjgRlrvSqvQcJFkj0JA";
					try {
						EncryptedTextPhone = encrypt(N0p3);
						G7YtJQ.edit().putString("T2tCbA", EncryptedTextPhone).commit();
					} catch (Exception e){
						SketchwareUtil.showMessage(getApplicationContext(), "Login Encrypt Failed");
					}
					G7YtJQ.edit().putString("HriPPNUf0TirYQ", "1").commit();
					i_konten.setClass(getApplicationContext(), KontenActivity.class);
					i_konten.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
					startActivity(i_konten);
					finish();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Akun belum register / Password Salah !");
					passlogin.setError("Pastikan Password Yang Kamu Masukkan Benar");
				}
			}
		});
		
		_S3rvDat4b453_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				map = new Gson().fromJson(new Gson().toJson(_childValue), new TypeToken<HashMap<String, Object>>(){}.getType());
				listloginmap.add(map.get("phone").toString().concat("π".concat(map.get("pass").toString())));
				listmap.add(map.get("email").toString());
				listmap.add(map.get("phone").toString());
				listmap.add(map.get("pass").toString());
				listmap.add(map.get("poin").toString());
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				map = new Gson().fromJson(new Gson().toJson(_childValue), new TypeToken<HashMap<String, Object>>(){}.getType());
				listloginmap.add(map.get("phone").toString().concat("π".concat(map.get("pass").toString())));
				listmap.add(map.get("email").toString());
				listmap.add(map.get("phone").toString());
				listmap.add(map.get("pass").toString());
				listmap.add(map.get("poin").toString());
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
		p01n4 = 15;
		if (G7YtJQ.getString("HriPPNUf0TirYQ", "").equals("1")) {
			i_konten.setClass(getApplicationContext(), KontenActivity.class);
			i_konten.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(i_konten);
			finish();
		}
		else {
			
		}
	}
	
	@Override
	public void onBackPressed() {
		
	}
	private void _eNk121p () {
	}
	private String encrypt(String Data) throws Exception {
		javax.crypto.spec.SecretKeySpec key = generateKey();
		javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES");
		c.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes());
		return Base64.encodeToString(encVal, Base64.DEFAULT);
	}
	
	
	private void _s4nd13nkr1p () {
	}
	private javax.crypto.spec.SecretKeySpec generateKey() throws Exception {
		final java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
		byte[] bytes = PxUctpSgNfA.getBytes("UTF-8");
		digest.update(bytes, 0, bytes.length);
		byte[] key = digest.digest();
		return new javax.crypto.spec.SecretKeySpec(key, "AES");
	}
	
	
	private void _D3k121p () {
	}
	private String decrypt(String outputString) throws Exception {
		javax.crypto.spec.SecretKeySpec key = generateKey();
		javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES");
		c.init(javax.crypto.Cipher.DECRYPT_MODE, key);
		byte[] decodeValue = Base64.decode(outputString, Base64.DEFAULT);
		byte[] decValue = c.doFinal(decodeValue);
		return new String(decValue);
	}
	
	
	private void _createDATAREG () {
		Em41L = emaireg.getText().toString();
		N0p3 = nopereg.getText().toString();
		P455 = passreg.getText().toString();
		P01n4 = String.valueOf((long)(p01n4));
		PxUctpSgNfA = "Q53Gs6K1U31U8ZgURuCpWISkWjgRlrvSqvQcJFkj0JA";
		try {
			EncryptedTextMail = encrypt(Em41L);
			EncryptedTextPhone = encrypt(N0p3);
			EncryptedTextPass = encrypt(P455);
			EncryptedTextPoinA = encrypt(P01n4);
			G7YtJQ.edit().putString("PcM79DM", EncryptedTextMail).commit();
			G7YtJQ.edit().putString("T2tCbA", EncryptedTextPhone).commit();
			G7YtJQ.edit().putString("PxUctpSgNfA", EncryptedTextPass).commit();
			G7YtJQ.edit().putString("za1PVO+S8nQ", EncryptedTextPoinA).commit();
		} catch (Exception e){
			SketchwareUtil.showMessage(getApplicationContext(), "Register Encrypt Failed");
		}
	}
	
	
	private void _uploadTOSERVER () {
		Em41L = G7YtJQ.getString("PcM79DM", "");
		N0p3 = G7YtJQ.getString("T2tCbA", "");
		P455 = G7YtJQ.getString("PxUctpSgNfA", "");
		P01n4 = G7YtJQ.getString("za1PVO+S8nQ", "");
		PxUctpSgNfA = "Q53Gs6K1U31U8ZgURuCpWISkWjgRlrvSqvQcJFkj0JA";
		try {
			DecryptedTextMail = decrypt(Em41L);
			DecryptedTextPhone = decrypt(N0p3);
			DecryptedTextPass = decrypt(P455);
			DecryptedTextPoinA = decrypt(P01n4);
			map = new HashMap<>();
			map.put("email", DecryptedTextMail);
			map.put("phone", DecryptedTextPhone);
			map.put("pass", DecryptedTextPass);
			map.put("poin", DecryptedTextPoinA);
			S3rvDat4b453.push().updateChildren(map);
		} catch (Exception e){
			SketchwareUtil.showMessage(getApplicationContext(), "Upload Server Decrypt Data Failed");
		}
	}
	
	
	private void _font () {
		persetujuan.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		tombol_daftar.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		
		emaireg.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		nopereg.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		passreg.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		termscondition.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		nopelogin.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		passlogin.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
		tombol_login.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lato.ttf"), 1);
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
