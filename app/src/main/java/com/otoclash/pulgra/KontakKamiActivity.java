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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class KontakKamiActivity extends AppCompatActivity {
	
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private EditText isi_pesan;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private ImageView gbr_email;
	private Button tombol_sendmail;
	private ImageView gbr_whatsapp;
	private Button tombol_sendwa;
	
	private Intent i_konten = new Intent();
	private Intent i_wasend = new Intent();
	private Intent i_mailsend = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.kontak_kami);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		isi_pesan = (EditText) findViewById(R.id.isi_pesan);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		gbr_email = (ImageView) findViewById(R.id.gbr_email);
		tombol_sendmail = (Button) findViewById(R.id.tombol_sendmail);
		gbr_whatsapp = (ImageView) findViewById(R.id.gbr_whatsapp);
		tombol_sendwa = (Button) findViewById(R.id.tombol_sendwa);
		
		tombol_sendmail.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				i_mailsend.setAction(Intent.ACTION_VIEW);
				i_mailsend.setData(Uri.parse("mailto:cs@otoclash.com"));
				i_mailsend.putExtra("body", isi_pesan.getText().toString());
				startActivity(i_mailsend);
			}
		});
		
		tombol_sendwa.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				i_wasend.setAction(Intent.ACTION_VIEW);
				i_wasend.setData(Uri.parse("https://api.whatsapp.com/send?phone=6282237215927&text=Salam%20Pulsa Gratisan%20Saya%20Mohon%20Bantuan%20Untuk%20:".concat(isi_pesan.getText().toString().concat("%3E%3E"))));
				startActivity(i_wasend);
			}
		});
	}
	private void initializeLogic() {
	}
	
	@Override
	public void onBackPressed() {
		i_konten.setClass(getApplicationContext(), KontenActivity.class);
		i_konten.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		startActivity(i_konten);
		finish();
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
