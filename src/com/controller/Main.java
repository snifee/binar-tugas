package com.controller;

import com.model.Kelas;
import com.model.Sekolah;
import com.service.BuatFileMeanMedian;
import com.service.BuatFileModus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

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
//                Scanner fileReader = new Scanner(new File("data/data_sekolah.csv"));
                BufferedReader br = new BufferedReader(new FileReader("D:\\Mine\\Downloads\\data_sekolah.csv"));

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


            }catch (IOException e){
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

                BuatFileModus fileModus = new BuatFileModus(sekolah.NilaiKeseluruhan());
                fileModus.CetakFile();

            } else if (pilihan==2) {

                BuatFileMeanMedian fileMeanMedian = new BuatFileMeanMedian(sekolah.NilaiKeseluruhan());
                fileMeanMedian.CetakFile();

            } else if (pilihan==3) {
                BuatFileModus fileModus = new BuatFileModus(sekolah.NilaiKeseluruhan());
                fileModus.CetakFile();

                BuatFileMeanMedian fileMeanMedian = new BuatFileMeanMedian(sekolah.NilaiKeseluruhan());
                fileMeanMedian.CetakFile();

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
