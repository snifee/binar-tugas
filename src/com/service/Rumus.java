package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Rumus {

    Double mean(List<Double> listNilai);

    Double median(List<Double> listNilai);

    HashMap<Double,Integer> modus(List<Double> listNilai);
}
