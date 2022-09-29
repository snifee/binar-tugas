package com.service;

import com.model.impl.BuatFile;
import lombok.Getter;
import lombok.Setter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Getter
@Setter

public class BuatFileModus implements BuatFile {
    private static FileWriter file;
    private List<Double> listNilai;
    private HashMap<Double,Integer> modus;

    public BuatFileModus(List<Double> listNilai) {
        this.listNilai = listNilai;
    }

    public void CetakFile(){
        HashSet<Double> setNilai = new HashSet<>(this.listNilai);
        this.modus = new HashMap<>();

        try{
            file = new FileWriter("data_sekolah_modus.txt");
            file.write("Berikut Hasil Pengolahan Nilai:\n");
            file.write("Nilai\t\t\t|\tFrekuensi\n");


            for (Double nilai:setNilai){
                int count = 0;
                for (Double nilai1:listNilai){
                    if(Double.compare(nilai1,nilai)==0){
                        count++;
                    }
                }

                file.write(nilai.toString()+"\t\t\t|\t"+count+"\n");
                modus.put(nilai,count);
            }

            file.close();

        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
