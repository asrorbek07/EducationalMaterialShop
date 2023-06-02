package com.example.educationalmaterialsshop.service;

public interface BaseService<T,R> {
    R create(T t);
    R get(Integer id);
    R getAll();
    R update(T t, Integer id);
    R delete(Integer id);
}
