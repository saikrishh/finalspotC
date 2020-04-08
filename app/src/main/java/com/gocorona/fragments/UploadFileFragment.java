package com.gocorona.fragments;

import android.view.View;
import android.widget.ImageView;

import com.gocorona.R;
import com.gocorona.adapter.QuestionsViewPagerAdapter;
import com.gocorona.customViews.NonSwipeableViewPager;
import com.gocorona.model.dummy.QuestionProgressData;

import java.util.ArrayList;
import java.util.List;

public class UploadFileFragment  extends BaseQuestionsFargment {
    private View.OnClickListener mListenerCallback;

    public static UploadFileFragment newInstance() {
        UploadFileFragment baseQuestionsFargment = new UploadFileFragment();
        return baseQuestionsFargment;
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

    /*@Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.uploadzipclicked:
                showToast("upload karna h");
                break;
            case R.id.runtutorialclicked:
                showToast("run tutorial karna h");
                break;
            case R.id.takeoutclicked:
                showToast("takepout activity chrome intent karna h");
                break;
        }
    }*/

    @Override
    public int getViewID() {
        return R.layout.fragment_upload_file;
    }
}
