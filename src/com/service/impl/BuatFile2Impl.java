package com.service.impl;

import com.service.BuatFile;
import com.service.BuatFile2;
import lombok.Getter;
import lombok.Setter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter

public class BuatFile2Impl implements BuatFile2 {
    private static FileWriter file;

    @Override
    public void CetakFile2(HashMap<Double, Integer> modus){

        try{
            file = new FileWriter("data_sekolah_modus.txt");
            file.write("Berikut Hasil Pengolahan Nilai:\n");
            file.write("Nilai\t\t\t|\tFrekuensi\n");


            for (Map.Entry<Double,Integer> entry : modus.entrySet()){

                String checkValue = (entry.getKey() < 6.0 ? "kurang dari 6" : entry.getKey().toString());

                file.write(checkValue+"\t\t\t|\t"+entry.getValue()+"\n");
            }


            file.close();

        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
