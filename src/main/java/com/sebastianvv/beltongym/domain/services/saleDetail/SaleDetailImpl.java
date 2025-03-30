package com.sebastianvv.beltongym.domain.services.saleDetail;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianvv.beltongym.domain.repositories.SaleDetailRepository;
import com.sebastianvv.beltongym.persistence.entities.SaleDetail;

@Service
public class SaleDetailImpl implements ISaleDetail {

    @Autowired
    private SaleDetailRepository saleDetailRepository;

    @Override
    public SaleDetail save(SaleDetail saleDetail) {
        return saleDetailRepository.save(saleDetail);
    }

    @Override
    public Optional<SaleDetail> findById(UUID id) {
        return saleDetailRepository.findById(id);
    }

    @Override
    public List<SaleDetail> findAll() {
        return (List<SaleDetail>) saleDetailRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
       saleDetailRepository.deleteById(id);
    }

}
