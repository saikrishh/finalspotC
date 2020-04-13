package com.gocorona.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gocorona.MainActivity;
import com.gocorona.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import simplifii.framework.activity.BaseActivity;

public class RegisterActivity extends BaseActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initToolBar("Sign Up");
        initViews();
        setOnClickListener(R.id.btn_submit);
        Toast.makeText(this, "Turn on GPS", Toast.LENGTH_LONG).show();
    }


    private void initViews() {
        setTermsAndConditionClick();
    }

    private void setTermsAndConditionClick() {
        TextView mTermConditionTV = findViewById(R.id.tv_terms_condition);
        String text = getResources().getString(R.string.terms_conditions);
        String str = getResources().getString(R.string.reg_lbl_agree_with_tnc);
        SpannableString ss = new SpannableString(str);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Intent intent = new Intent(RegisterActivity.this, TermsConditionsActivity.class);
                showToast("click worked");
                startActivityForResult(intent, 109);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        ss.setSpan(clickableSpan, str.indexOf(text), str.indexOf(text) + (text.length()), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTermConditionTV.setText(ss);
        mTermConditionTV.setMovementMethod(LinkMovementMethod.getInstance());
        mTermConditionTV.setHighlightColor(Color.TRANSPARENT);

        mTermConditionTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, TermsConditionsActivity.class);
                startActivityForResult(intent, 109);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.btn_submit:
                startNextActivity(MainActivity.class);

/*                boolean n = checkgps();
                    int m = turnonGPS(gpsstatus);
                    showToast("n = "+Boolean.toString(n)+", m = "+String.valueOf(n));
 */
            break;
        }
    }
/*
    GoogleApiClient googleApiClient;
    private int turnonGPS(final int gpsstatus) {
        if (gpsstatus!=1) {
            AlertDialog alertDialog = new AlertDialog.Builder(getApplicationContext())
                    .setIcon(R.mipmap.infoicon)
                    .setTitle("Turn on GPS")
                    .setMessage("")
                    .setPositiveButton("Enable GPS from Settings", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            gpsset=false;
                            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                            checkgps();
                            if (gpsset==true) {
                                finish();
                                startNextActivity(MainActivity.class);
                            }
                            else
                                showToast("You were kidding .. You jus went to settings and came back");
                        }
                    })
                    .setNegativeButton("I Enabled GPS", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //set what should happen when negative button is clicked
                            checkgps();
                            if (gpsset==true){
                                showToast("GPS enabled");
                                startNextActivity(MainActivity.class);
                            }else
                                turnonGPS(gpsstatus);

                        }
                    })
                    .show();
        }
        return gpsstatus;
    }

    LocationManager manager = null;
    boolean gpsset;

    public boolean checkgps() {
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(getApplicationContext(), "GPS is not enabled", Toast.LENGTH_SHORT).show();
            gpsset = false;
        } else
        {Toast.makeText(getApplicationContext(), "GPS is enabled", Toast.LENGTH_SHORT).show();
        gpsset=true;
        }
        return gpsset;
    }
*/



    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
