package com.vinaykumar.chapter_two_test;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    int count = 0 ;

    MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();

    public MutableLiveData<Integer> getInitialCount(){
        mutableLiveData.setValue(count);
        return mutableLiveData;
    }

    public void getCurrentCount() {
        count = count+1;
        mutableLiveData.setValue(count);
    }
}
