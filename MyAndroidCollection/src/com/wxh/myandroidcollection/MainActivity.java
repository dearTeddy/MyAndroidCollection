package com.wxh.myandroidcollection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
	private static final String TAG = MainActivity.class.getSimpleName();
	private Button 			mBtnTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		initView();
//		initData();
	}
	
	private void initView() {
		mBtnTextView = (Button) findViewById(R.id.btnEditText);
	}
	
	private void initData() {
		mBtnTextView.setOnClickListener(onEditLisner);
	}
	
	private OnClickListener onEditLisner = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i;
			Bundle b;
			
			i = new Intent(MainActivity.this, EditTextActivity.class);
			startActivity(i);
		}
	};

	@Override
	protected void onResume() {
		super.onResume();
	}
	
	@Override
	protected void onStart() {
		super.onStart();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.btnEditText:
			Intent i;
			Bundle b;
			
			i = new Intent(MainActivity.this, EditTextActivity.class);
			startActivity(i);
			break;

		default:
			break;
		}
	}
}
