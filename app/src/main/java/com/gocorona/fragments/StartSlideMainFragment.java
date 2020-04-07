package com.gocorona.fragments;

import android.view.View;

import com.gocorona.R;
import com.gocorona.model.dummy.QuestionProgressData;

public class StartSlideMainFragment  extends BaseQuestionsFargment {
    private View.OnClickListener mListenerCallback;
    private boolean isBtnClicked;

    public static StartSlideMainFragment newInstance(boolean hideNextBtn) {
        StartSlideMainFragment baseQuestionsFargment = new StartSlideMainFragment();
        baseQuestionsFargment.isBtnClicked = hideNextBtn;
        return baseQuestionsFargment;
    }

    @Override
    public void initViews() {
        setOnClickListener(R.id.questionaireclicked, R.id.interesectcalculator);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        isBtnClicked = true;
        switch (v.getId()) {
            case R.id.questionaireclicked:
                mListenerCallback.onClick(v);
                //showToast("questionaire clicked.. this toast will be deleted");
                break;
            case R.id.interesectcalculator:
                mListenerCallback.onClick(v);
                //showToast("interest calci clicked.. this toast will be deleted");
                break;
        }
    }

    @Override
    public int getViewID() {
        return R.layout.fragment_show_slide_main;
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
        questionProgressData.setTitle("Start");
        questionProgressData.setHideNextBtn(true);
    }

    @Override
    public void setClickListenerCallback(View.OnClickListener listenerCallback) {
        mListenerCallback = listenerCallback;
    }
}
