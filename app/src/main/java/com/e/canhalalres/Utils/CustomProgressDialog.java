package com.e.canhalalres.Utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.LayoutDirection;
import android.view.Gravity;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class CustomProgressDialog {

    private static CustomProgressDialog instance = new CustomProgressDialog();

    private CustomProgressDialog() {
    }

    public static CustomProgressDialog getInstance() {
        return instance;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public Dialog customProgressDialog(@NonNull Context context) {
        Dialog dialog = new Dialog(context);
        dialog.setCancelable(false);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        TextView tv=new TextView(context);
        tv.setText("Please wait...");
        // tv.setTextColor(Color.argb(255,0,172,193));
        tv.setTextColor(Color.argb(255,0,0,0));
        tv.setGravity(Gravity.CENTER);
        tv.setPadding(20,20,20,20);
        tv.setTypeface(Typeface.DEFAULT_BOLD);
        tv.setTextSize(20);
        ProgressBar pb=new ProgressBar(context);
        pb.setIndeterminate(true);
        pb.setPadding(20,20,20,20);
        LinearLayout ll=new LinearLayout(context);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity= Gravity.CENTER;
        lp.setLayoutDirection(LayoutDirection.RTL);
        ll.setLayoutParams(lp);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.addView(pb);
        ll.addView(tv);
        dialog.setContentView(ll);
        if(dialog.getWindow()!=null) {
            dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(210,255,255,255)));
        }
        return dialog;
    }
}
