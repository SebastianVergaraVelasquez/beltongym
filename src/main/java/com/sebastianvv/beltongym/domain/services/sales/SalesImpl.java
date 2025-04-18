package com.sebastianvv.beltongym.domain.services.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianvv.beltongym.domain.repositories.SalesRepository;
import com.sebastianvv.beltongym.persistence.entities.Sales;

@Service
public class SalesImpl implements ISales{

    @Autowired
    private SalesRepository salesRepository;

    @Override
    public Sales save(Sales sale) {
        return salesRepository.save(sale);
    }

    @Override
    public Optional<Sales> findById(int id) {
        return salesRepository.findById(id);
    }

    @Override
    public List<Sales> findAll() {
        return (List<Sales>) salesRepository.findAllWithUser();
    }

    @Override
    public void deleteById(int id) {
       salesRepository.deleteById(id);
    }

}
