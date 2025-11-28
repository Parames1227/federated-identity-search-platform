package com.parames.restaurant_search.mappers;

import com.parames.restaurant_search.domain.dtos.PhotoDto;
import com.parames.restaurant_search.domain.entities.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PhotoMapper {

    PhotoDto toDto(Photo photo);

}
