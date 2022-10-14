package com.controller;

import com.model.Sekolah;
import com.service.Rumus;
import com.service.impl.BuatFile1Impl;
import com.service.impl.BuatFile2Impl;
import com.service.impl.RumusImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws RuntimeException{

        int pilihan = 0;

        Sekolah sekolah = new Sekolah();

        do {

            System.out.println("--------------------------------------");
            System.out.println("Aplikasi Pegolah Nilai Siswa");
            System.out.println("--------------------------------------");
            System.out.println("File csv dengan nama file data_sekolah");
            System.out.println();
            System.out.println("Pilih Menu:");
            System.out.println("1 Generate txt untuk menampilkan modus");
            System.out.println("2 Generate txt untuk menampilkan mean, median");
            System.out.println("3 Generate dua file");
            System.out.println("0 Exit");
            System.out.print(">>");
            pilihan = input.nextInt();

            if (pilihan==0){
                break;
            }

            try{
//
                sekolah = BacaFile.baca();



            }catch (RuntimeException e){
                System.out.println("--------------------------------");
                System.out.println("Aplikasi Pegolah Nilai Siswa");
                System.out.println("--------------------------------");
                System.out.println("File Tidak ditemukan");
                System.out.println();
                System.out.println("0 Exit");
                System.out.println("1 Kembali ke menu utama");
                System.out.print(">>");
                pilihan = input.nextInt();
            }

            if (pilihan==1){

                RumusImpl rumus = new RumusImpl();

                HashMap<Double,Integer> modus = rumus.modus(sekolah.NilaiKeseluruhan());

                BuatFile2Impl fileModus = new BuatFile2Impl();
                fileModus.CetakFile2(modus);

            } else if (pilihan==2) {

                RumusImpl rumus = new RumusImpl();

                Double median = rumus.median(sekolah.NilaiKeseluruhan());
                Double mean = rumus.mean(sekolah.NilaiKeseluruhan());

                BuatFile1Impl buatFile1 = new BuatFile1Impl();
                buatFile1.CetakFile1(mean,median);
            } else if (pilihan==3) {
                RumusImpl rumus = new RumusImpl();

                HashMap<Double,Integer> modus = rumus.modus(sekolah.NilaiKeseluruhan());

                BuatFile2Impl fileModus = new BuatFile2Impl();
                fileModus.CetakFile2(modus);

                Double median = rumus.median(sekolah.NilaiKeseluruhan());
                Double mean = rumus.mean(sekolah.NilaiKeseluruhan());

                BuatFile1Impl buatFile1 = new BuatFile1Impl();
                buatFile1.CetakFile1(mean,median);

            }

            System.out.println("--------------------------------");
            System.out.println("Aplikasi Pegolah Nilai Siswa");
            System.out.println("--------------------------------");
            System.out.println("File Telah digenerate");
            System.out.println();
            System.out.println("0 Exit");
            System.out.println("1 Kembali ke menu utama");
            System.out.print(">>");
            pilihan = input.nextInt();

        }while(pilihan!=0);



    }
}
