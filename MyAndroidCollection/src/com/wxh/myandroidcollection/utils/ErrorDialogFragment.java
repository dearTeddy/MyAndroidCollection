package com.wxh.myandroidcollection.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockDialogFragment;
import com.wxh.myandroidcollection.R;

public final class ErrorDialogFragment extends SherlockDialogFragment {

    private static final String ERROR = "error";
    private static final String TITLE = "title";
    private DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog,
		                int whichButton) {
		}
	};

    public void setOnClickListener(DialogInterface.OnClickListener onClickListener) {
		this.onClickListener = onClickListener;
	}


	public static ErrorDialogFragment newInstance(String error) {
        ErrorDialogFragment frag = new ErrorDialogFragment();
        Bundle args = new Bundle();
        args.putString(ERROR, error);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public void onSaveInstanceState(Bundle arg0) {
        // TODO Auto-generated method stub
//		super.onSaveInstanceState(arg0);
        Log.e("errordialog", " -- onSaveInstanceState");
    }


    public static ErrorDialogFragment newInstance(String error, String title) {
        ErrorDialogFragment frag = new ErrorDialogFragment();
        Bundle args = new Bundle();
        args.putString(ERROR, error);
        args.putString(TITLE, title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String error = getArguments().getString(ERROR);
        String title = getArguments().getString(TITLE);
        Dialog alertDialog = null;
        if (title != null) {
        	alertDialog = new AlertDialog.Builder(getActivity())
                    .setMessage(error)
                    .setTitle(title)
                    .setNeutralButton(R.string.btn_error_neutral, onClickListener)
                    .create();
        } else {
        	alertDialog = new AlertDialog.Builder(getActivity())
                    .setMessage(error)
                    .setNeutralButton(R.string.btn_error_neutral, onClickListener)
                    .create();
        }
        
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
    }
}