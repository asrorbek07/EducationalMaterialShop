package com.example.educationalmaterialsshop.service;

import com.example.educationalmaterialsshop.model.entity.Supplier;
import com.example.educationalmaterialsshop.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public List<Supplier> getAll(){
        return supplierRepository.findAll();
    }
}
