package com.service;

import com.model.impl.BuatFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuatFileMeanMedian implements BuatFile {
    protected static FileWriter file;
    private List<Double> listNilai;

    public BuatFileMeanMedian(List<Double> listNilai) {
        this.listNilai = listNilai;
    }

    private double Mean(){
        Integer jumahData = this.listNilai.size();
        Double totalNilai = 0.0;

        for (Double d:listNilai){
            totalNilai+=d;
        }

        return totalNilai/jumahData;
    }

    private double Median(){
        List<Double> newListNilai = new ArrayList<>(this.listNilai);

        newListNilai.sort();

        Integer jumahData = this.listNilai.size();

        int middleValue=0;

        if (newListNilai.size()%2==0){
            middleValue = newListNilai.size()/2;
            return (newListNilai.get(middleValue)+newListNilai.get(middleValue+1))/2;
        }

        middleValue = Math.round(newListNilai.size()/2);

        return newListNilai.get(middleValue);
    }

    public void CetakFile(){

        try{
            file = new FileWriter("data_sekolah_mean_median.txt");
            file.write("Berikut Hasil Pengolahan Nilai:\n");
            file.write("Nilai Mean      :"+this.Mean()+"\n");
            file.write("Nilai Median    :"+this.Median());

            file.close();

        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
