package com.nimidev.bankingledger.service;

import java.util.List;

public interface HelperService {

    <D> D map(Object source, Class<D> destinationType);
    <S, T> List<T> mapList(List<S> source, Class<T> targetClass);
}
