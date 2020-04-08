package com.gocorona.fragments;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.gocorona.R;
import com.gocorona.adapter.ViewPagerAdapter;
import com.gocorona.model.dummy.QuestionProgressData;

public class TutorialFragment extends BaseQuestionsFargment {
    private View.OnClickListener mListenerCallback;

    public static TutorialFragment newInstance() {
        TutorialFragment tutofrag = new TutorialFragment();

        return tutofrag;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void showInvalidFieldError() {

    }

    @Override
    public void apply(QuestionProgressData questionProgressData) {
        questionProgressData.setProgress(100);
        questionProgressData.setTitle("File Upload");
        questionProgressData.setHideNextBtn(true);
    }

    @Override
    public void setClickListenerCallback(View.OnClickListener listenerCallback) {
        mListenerCallback = listenerCallback;
    }

    @Override
    public void initViews() {

    }

    @Override
    public int getViewID() {

        showToast("fragmenttutorial");

        return R.layout.fragment_gallery;
    }
}
