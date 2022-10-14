package com.service.impl;

import com.service.BuatFile;
import lombok.Getter;
import lombok.Setter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@Setter
@Getter

public class BuatFile1Impl implements BuatFile {
    protected static FileWriter file;
    private List<Double> listNilai;
    private Map<Double,Integer> mapModus;


    public void CetakFile1(Double mean, Double median){
        try{
            file = new FileWriter("data_sekolah_mean_median.txt");
            file.write("Berikut Hasil Pengolahan Nilai:\n");
            file.write("Nilai Mean      :"+mean+"\n");
            file.write("Nilai Median    :"+median+"\n");
//            file.write("Nilai Median    :"+this.Modus()+"\n");
            file.close();

        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
