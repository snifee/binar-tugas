package com.controller;

import com.model.Kelas;
import com.model.Sekolah;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BacaFile {

    public static Sekolah sekolah = new Sekolah();


    public static Sekolah baca(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("data_sekolah.csv"));

            String line = "";

            while((line = br.readLine())!=null){
                String[] nilai = line.split(";");

                Kelas kelas = new Kelas();

                List<Double> listNilai = new ArrayList<>();

                Double buffer = 0.0;

                for (int i = 0; i<nilai.length;i++){
                    if(i==0){
                        kelas.setNamaKelas(nilai[0]);
                    }else {
                        try {
                            buffer = (Double.parseDouble(nilai[i]));
                            listNilai.add(buffer);

                        }catch (Exception e){

                        }
                    }
                }

                kelas.setNilaiSiswa(listNilai);

                sekolah.addToListkelas(kelas);
            }

            return sekolah;

        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}
