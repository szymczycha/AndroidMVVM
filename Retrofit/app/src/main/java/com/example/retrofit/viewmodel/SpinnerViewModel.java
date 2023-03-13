package com.example.retrofit.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class SpinnerViewModel extends ViewModel {

    private MutableLiveData<List<String>> mutableUserIds;
    private List<String> userIds;

    public void setMutableUserIds(MutableLiveData<List<String>> mutableUserIds) {
        this.mutableUserIds = mutableUserIds;
    }
    public SpinnerViewModel(){
        this.mutableUserIds = new MutableLiveData<>();
        this.userIds = new ArrayList<>();
        this.mutableUserIds.setValue(this.userIds);
    }

    public MutableLiveData<List<String>> getMutableUserIds() {
        return mutableUserIds;
    }
    public void setUserIds(List<String> newUserIds){
        userIds = newUserIds;
        this.mutableUserIds.setValue(userIds);
    }
}
