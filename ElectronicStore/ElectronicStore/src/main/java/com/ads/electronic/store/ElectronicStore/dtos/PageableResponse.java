package com.ads.electronic.store.ElectronicStore.dtos;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageableResponse <T> {
    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private long totalPageElement;
    private long totalPageSize;
    private boolean isLastPage;
}
