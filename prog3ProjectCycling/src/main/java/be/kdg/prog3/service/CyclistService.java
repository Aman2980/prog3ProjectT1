package be.kdg.prog3.service;

import be.kdg.prog3.domain.Cyclist;

import java.util.List;

public interface CyclistService {

    List<Cyclist> getAllCyclists();

    List<Cyclist> getCyclistsByNationality();

}
