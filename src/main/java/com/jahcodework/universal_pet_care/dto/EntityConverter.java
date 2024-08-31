package com.jahcodework.universal_pet_care.dto;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

// convert the entity utility class
@Component
@RequiredArgsConstructor
public class EntityConverter<T, D> {
    private final ModelMapper model;


    // convert the entity to class
    public  D mapEntityToDto(T entity, Class<D> dtoClass){
            return model.map(entity, dtoClass);
    }


    public T mapDtoToEntity(D dto, Class<T> entityclass){
        return model.map(dto, entityclass);
    }
}
