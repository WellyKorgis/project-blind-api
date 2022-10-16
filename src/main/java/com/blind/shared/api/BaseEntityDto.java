package com.blind.shared.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Getter
@AllArgsConstructor
@MappedSuperclass
@NoArgsConstructor
public class BaseEntityDto {
    private String id;
}
