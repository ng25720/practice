package com.productservice.Utils.Shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class EntityResponse<T> {
    private String message;
    private Integer statusCode;
    private T entity;
}
