package com.example.sem2projectar_interface2.ui.OpenProject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OpenProjectViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OpenProjectViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is share fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}