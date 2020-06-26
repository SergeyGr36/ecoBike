package com.sergey.service;

import com.sergey.pojo.Bike;

import java.util.ArrayList;
import java.util.List;

public class DataRepository {
    private List<Bike> list = new ArrayList<>();

    public void addData(Bike dataToWrite) {
        list.add(dataToWrite);
    }
    public List<Bike> getList() {
            return list;
    }
}
