package com.wxh.myandroidcollection.utils;


import com.wxh.myandroidcollection.config.BuildConfig;

import android.util.Log;

public class LogUtil {

	public static void v(String tag,String msg){
		if (BuildConfig.DEBUG && msg != null) {
			Log.d(tag, msg);
		}
	}

	public static void i(String tag, String msg){
		if (BuildConfig.DEBUG && msg != null) {
			Log.i(tag, msg);
		}
	}

	public static void e(String tag, String msg){
		if (BuildConfig.DEBUG && msg != null) {
			Log.e(tag, msg);
		}
	}

	public static void w(String tag, String msg){
		if (BuildConfig.DEBUG && msg != null) {
			Log.w(tag, msg);
		}
	}

	public static void wtf(String tag, String msg){
		if (BuildConfig.DEBUG && msg != null) {
			Log.wtf(tag, msg);
		}
	}

}
