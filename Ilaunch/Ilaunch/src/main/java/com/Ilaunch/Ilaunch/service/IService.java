package com.Ilaunch.Ilaunch.service;

public interface IService <T, ID> {
    T create(T t);
    T read(ID id);
}
