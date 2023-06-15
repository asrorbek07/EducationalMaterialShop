package com.example.educationalmaterialsshop.controller.converter;

import com.example.educationalmaterialsshop.model.entity.Supplier;
import com.example.educationalmaterialsshop.model.payload.response.SupplierResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class SupplierConverter {
    public SupplierResponse from(Supplier supplier){
        return SupplierResponse.builder()
                .id(supplier.getId())
                .phoneNumber(supplier.getPhoneNumber())
                .address(supplier.getAddress())
                .date(supplier.getDate())
                .company(supplier.getCompany())
                .fullName(supplier.getFullName())
                .build();
    }
    public List<SupplierResponse> from(List<Supplier> suppliers){
        return suppliers.stream().map(SupplierConverter::from).toList();
    }
}
