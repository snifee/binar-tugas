package com.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter

public class Sekolah{
    private List<Kelas> listKelas;

    public Sekolah() {
        this.listKelas = new ArrayList<>();
    }

    public void addToListkelas(Kelas kelas){
        this.listKelas.add(kelas);
    }

    public List<Double> NilaiKeseluruhan(){
        List<Double> nilaiKeseluruhan = new ArrayList();
        for (Kelas k : this.getListKelas()){

            for (Double d : k.getNilaiSiswa()){
                nilaiKeseluruhan.add(d);
            }
        }

        return nilaiKeseluruhan;
    }
}
