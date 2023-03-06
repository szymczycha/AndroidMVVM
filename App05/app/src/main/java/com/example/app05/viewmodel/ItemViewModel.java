package com.example.app05.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ItemViewModel extends ViewModel {

    private MutableLiveData<ArrayList<String>> mutableItemList;
    private MutableLiveData<Integer> mutableSelectedIndex;
    private ArrayList<String> itemList;
    private Integer selectedIndex;

    public MutableLiveData<Integer> getMutableSelectedIndex() {
        return mutableSelectedIndex;
    }

    public void changeCategory(Integer selectedIndex){
        Log.d("XXX", "selectedIndex: " + selectedIndex);
        Log.d("XXX", "this.selectedIndex: " + this.selectedIndex);
        Log.d("XXX", "this.mutableSelectedIndex: " + this.mutableSelectedIndex.getValue());
        this.selectedIndex = selectedIndex;
        mutableSelectedIndex.setValue(this.selectedIndex);
        Log.d("XXX", "selectedIndex: " + selectedIndex);
        Log.d("XXX", "this.selectedIndex: " + this.selectedIndex);
        Log.d("XXX", "this.mutableSelectedIndex: " + this.mutableSelectedIndex.getValue());
    }

    public void setMutableSelectedIndex(Integer selectedIndex) {
        this.selectedIndex = selectedIndex;
        mutableSelectedIndex.setValue(this.selectedIndex);
    }

    public ItemViewModel(){
        this.mutableSelectedIndex = new MutableLiveData<>();
        this.mutableItemList = new MutableLiveData<>();
        this.itemList = new ArrayList<>();
        itemList.add("category 1");
        itemList.add("category 2");
        itemList.add("category 3");
        this.selectedIndex = 0;
        this.mutableSelectedIndex.setValue(selectedIndex);
        this.mutableItemList.setValue(this.itemList);
    }

    public MutableLiveData<ArrayList<String>> getObservedItemList(){
        return mutableItemList;
    }
    public void addCategory(String newCategory){
        itemList.add(newCategory);
        mutableItemList.setValue(itemList);
    }
}
