package com.usu.countermvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {
    private MutableLiveData<Integer> count = new MutableLiveData<>();

    public CounterViewModel() {
        count.setValue(0);
    }

    public MutableLiveData<Integer> getCount() {
        return count;
    }

    public void incrementCommand() {
        count.setValue(count.getValue() + 1);
        // store in database
    }

    public void decrementCommand() {
        count.setValue(count.getValue() - 1);
    }

    public void timesTenCommand() {
        count.setValue(count.getValue() * 10);
    }

    public void halfCommand() {
        count.setValue(count.getValue() / 2);
    }
}
