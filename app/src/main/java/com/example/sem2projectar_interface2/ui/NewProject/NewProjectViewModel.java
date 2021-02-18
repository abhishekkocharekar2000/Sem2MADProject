package com.example.sem2projectar_interface2.ui.NewProject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewProjectViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NewProjectViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}