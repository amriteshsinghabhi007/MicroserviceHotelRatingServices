package com.ads.electronic.store.ElectronicStore.helper;

import com.ads.electronic.store.ElectronicStore.dtos.PageableResponse;
import com.ads.electronic.store.ElectronicStore.dtos.UserDto;
import com.ads.electronic.store.ElectronicStore.entity.User;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class HelperMethods{
    public static <U,V>PageableResponse<V> getPageableResponse(Page<U> page,Class<V> type){
        List<U> entity = page.getContent();

        List<V> userDtoList = entity.stream().map(object -> new ModelMapper().map(object,type)).collect(Collectors.toList());

        PageableResponse<V> pageableResponse = new PageableResponse<>();
        pageableResponse.setContent(userDtoList);
        pageableResponse.setPageNumber(page.getNumber());
        pageableResponse.setPageSize(page.getSize());
        pageableResponse.setTotalPageElement(page.getTotalElements());
        pageableResponse.setTotalPageSize(page.getTotalPages());
        pageableResponse.setLastPage(page.isLast());

        return pageableResponse;
    }
}
