package com.wxh.myandroidcollection.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockDialogFragment;
import com.wxh.myandroidcollection.R;

public final class ErrorDialogFragmentWithTitle extends SherlockDialogFragment {

	private static final String ERROR = "error";
	private static final String TITLE = "title";

	public static ErrorDialogFragmentWithTitle newInstance(String error) {
		ErrorDialogFragmentWithTitle frag = new ErrorDialogFragmentWithTitle();
		Bundle args = new Bundle();
		args.putString(ERROR, error);
		frag.setArguments(args);
		return frag;
	}

	@Override
	public void onSaveInstanceState(Bundle arg0) {
		// TODO Auto-generated method stub
		// super.onSaveInstanceState(arg0);
		Log.e("errordialog", " -- onSaveInstanceState");
	}

	public static ErrorDialogFragmentWithTitle newInstance(String error,
			String title) {
		ErrorDialogFragmentWithTitle frag = new ErrorDialogFragmentWithTitle();
		Bundle args = new Bundle();
		args.putString(ERROR, error);
		args.putString(TITLE, title);
		frag.setArguments(args);
		return frag;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog alertDialog;
        String error = getArguments().getString(ERROR);
        String title = getArguments().getString(TITLE);
		View v = getActivity().getLayoutInflater().inflate(R.layout.alerts_dialog_result, null);
		TextView tv1 = (TextView) v.findViewById(R.id.textView1);
		TextView tv2 = (TextView) v.findViewById(R.id.textView2);
//		if (title != null) {
//			tv1.setText(title);
//			tv2.setText(error);
//			alertDialog = new AlertDialog.Builder(getActivity())
//					.setView(v)
//					// .setTitle(title)
//					.setNeutralButton(R.string.alert_no_result_positive,
//							new DialogInterface.OnClickListener() {
//								public void onClick(DialogInterface dialog,
//										int whichButton) {
//
//								}
//							})
//					.setPositiveButton(R.string.alert_no_result_neutral,
//							new DialogInterface.OnClickListener() {
//
//								@Override
//								public void onClick(DialogInterface dialog,
//										int which) {
//									dismiss();
//								}
//							}).create();
//			alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
//
//				@Override
//				public void onShow(DialogInterface dialog) {
//					((AlertDialog) dialog).getButton(Dialog.BUTTON_POSITIVE)
//							.setTextColor(
//									getActivity().getResources().getColor(
//											R.color.blue));
//					((AlertDialog) dialog).getButton(Dialog.BUTTON_NEUTRAL)
//							.setTextColor(
//									getActivity().getResources().getColor(
//											R.color.blue));
//				}
//			});
//			// bt1.setText(Html.fromHtml(getActivity().getResources().getString(R.string.alert_no_result_neutral)));
//			return alertDialog;
//		} else {
			tv1.setText(title);
			tv2.setText(error);
			alertDialog = new AlertDialog.Builder(getActivity())
					.setView(v)
					.setNeutralButton(R.string.alert_dialog_ok,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dismiss();
								}
							}).create();
			alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {

				@Override
				public void onShow(DialogInterface dialog) {
					Button bt1 = ((AlertDialog) dialog)
							.getButton(Dialog.BUTTON_NEUTRAL);
					bt1.setTextColor(getActivity().getResources().getColor(
							R.color.blue));
					bt1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
				}
			});
			return alertDialog;
//		}
	}
}