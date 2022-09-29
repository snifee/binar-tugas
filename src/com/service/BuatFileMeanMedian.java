package com.service;

import com.model.impl.BuatFile;
import lombok.Getter;
import lombok.Setter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.*;

@Setter
@Getter

public class BuatFileMeanMedian implements BuatFile {
    protected static FileWriter file;
    private List<Double> listNilai;
    private Map<Double,Integer> mapModus;

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

        Collections.sort(newListNilai);

        Integer jumahData = this.listNilai.size();

        int middleValue=0;

        if (newListNilai.size()%2==0){
            middleValue = newListNilai.size()/2;
            return (newListNilai.get(middleValue)+newListNilai.get(middleValue+1))/2;
        }

        middleValue = Math.round(newListNilai.size()/2);

        return newListNilai.get(middleValue);
    }

//    private Double Modus(){
//        Double maxValue = 0.0;
//
//        for (Map.Entry<Double,Integer> entry : this.mapModus.entrySet()){
//            Integer max = 0,buffer;
//
//            if (entry.getValue()>max){
//                maxValue = entry.getKey();
//                max = entry.getValue();
//            }
//
//        }
//
//        return maxValue;
//    }

    public void CetakFile(){

        try{
            file = new FileWriter("data_sekolah_mean_median.txt");
            file.write("Berikut Hasil Pengolahan Nilai:\n");
            file.write("Nilai Mean      :"+this.Mean()+"\n");
            file.write("Nilai Median    :"+this.Median()+"\n");
//            file.write("Nilai Median    :"+this.Modus()+"\n");
            file.close();

        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
