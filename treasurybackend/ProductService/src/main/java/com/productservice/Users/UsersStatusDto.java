package com.productservice.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsersStatusDto {
    private Long sn;
    private String status;
    private String remarks;

}
