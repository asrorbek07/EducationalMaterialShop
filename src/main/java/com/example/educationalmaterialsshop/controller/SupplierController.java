package com.example.educationalmaterialsshop.controller;

import com.example.educationalmaterialsshop.controller.converter.SupplierConverter;
import com.example.educationalmaterialsshop.model.payload.response.SupplierResponse;
import com.example.educationalmaterialsshop.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableMethodSecurity
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/supplier/")
public class SupplierController {
    private final SupplierService supplierService;
    @GetMapping("all")
    public List<SupplierResponse> getAll(){
        return SupplierConverter.from(supplierService.getAll());
    }
}
