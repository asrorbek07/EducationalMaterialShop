package com.example.educationalmaterialsshop.controller;

import com.example.educationalmaterialsshop.controller.converter.InputConverter;
import com.example.educationalmaterialsshop.model.entity.Input;
import com.example.educationalmaterialsshop.model.payload.request.InputCreateRequest;
import com.example.educationalmaterialsshop.model.payload.response.InputResponse;
import com.example.educationalmaterialsshop.service.InputService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableMethodSecurity
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/input/")
public class InputController {
    private final InputService inputService;
    @PostMapping()
    public InputResponse create(
            @RequestBody InputCreateRequest inputCreateRequest
            ){
        Input input = InputConverter.convertToEntity(inputCreateRequest);
        return InputConverter.from(inputService.create(inputCreateRequest.getSupplierId(), inputCreateRequest.getProductId(), input));
    }

    @GetMapping("all")
    public List<InputResponse> getAll(){
        return InputConverter.from(inputService.getAll());
    }
}
