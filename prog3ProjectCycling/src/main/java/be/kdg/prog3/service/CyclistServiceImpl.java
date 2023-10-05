package be.kdg.prog3.service;

import be.kdg.prog3.domain.Cyclist;
import be.kdg.prog3.repository.DataFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CyclistServiceImpl implements CyclistService {
    @Override
    public List<Cyclist> getAllCyclists() {
        return DataFactory.cyclists;
    }

    @Override
    public List<Cyclist> getCyclistsByNationality() {
        List<Cyclist> cyclists = DataFactory.cyclists;

        return cyclists.stream()
                .collect(Collectors.groupingBy(Cyclist::getNationality))
                .values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
