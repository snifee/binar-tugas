package com.service.impl;

import com.service.Rumus;

import java.io.FileWriter;
import java.util.*;

public class RumusImpl implements Rumus {

    @Override
    public Double mean(List<Double> listNilai){
        Integer jumlahData = listNilai.size();
        Double totalNilai = 0.0;

        for (Double d:listNilai){
            totalNilai+=d;
        }

        return totalNilai/jumlahData;
    }

    @Override
    public Double median(List<Double> listNilai){
        List<Double> newListNilai = new ArrayList<>(listNilai);

        Collections.sort(newListNilai);

        Integer jumlahData = listNilai.size();

        int middleValue=0;

        if (newListNilai.size()%2==0){
            middleValue = newListNilai.size()/2;
            return (newListNilai.get(middleValue)+newListNilai.get(middleValue+1))/2;
        }

        middleValue = Math.round(newListNilai.size()/2);

        return newListNilai.get(middleValue);
    }

    @Override
    public HashMap<Double, Integer> modus(List<Double> listNilai) {
        HashSet<Double> setNilai = new HashSet<>(listNilai);
        HashMap<Double, Integer> result = new HashMap<>();


        for (Double nilai:setNilai){
            int count = 0;
            for (Double nilai1:listNilai){
                if(Double.compare(nilai1,nilai)==0){
                    count++;
                }
            }

            result.put(nilai,count);
        }


        return result;
    }
}
