package com.example.manageprojectemployeeretro.utils;

import java.util.List;

public interface EntityMapper<D, E> {
    E toEntity(D dto);
    D toDTO(E entity);
    List<E> toEntityList(List<D> dtoList);
    List<D> toDTOList(List<E> entityList);

}
