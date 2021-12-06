package com.nimidev.bankingledger.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HelperServiceImpl implements HelperService{

    private ModelMapper modelMapper;

    @Override
    public <D> D map(Object source, Class<D> destinationType) {
        return source == null ? null : modelMapper.map(source, destinationType);
    }

    HelperServiceImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }
    @Override
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
