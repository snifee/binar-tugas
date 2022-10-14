package com.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter

public class Kelas {

    private String namaKelas;
    private List<Double> nilaiSiswa;

    public Kelas() {
    }
}
