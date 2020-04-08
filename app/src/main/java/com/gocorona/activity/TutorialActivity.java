package com.gocorona.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.gocorona.R;
import com.gocorona.adapter.ImageAdaptorTutorial;

import static java.lang.Boolean.TRUE;

public class TutorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new ImageAdaptorTutorial(this));


//        viewPager.setCurrentItem(2,TRUE);


        try {
            Toast.makeText(this, "Welcome to Intersection Calculator Tutorial!!", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onBackPressed() {
        try {
            Toast.makeText(this, "Click Download Location History from Google", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onBackPressed();
    }
}
