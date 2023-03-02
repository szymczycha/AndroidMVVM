package com.example.app02.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class YearViewModel extends ViewModel {
    public MutableLiveData<Integer> yearLiveData;
    public YearViewModel(){
        yearLiveData = new MutableLiveData<>();
    }
    public void setupData(int year){
        yearLiveData.setValue(year);
    }
    public MutableLiveData<Integer> getObservedYear(){
        return yearLiveData;
    }
    public void changeYear(int year){
        yearLiveData.setValue(year);
    }
}
