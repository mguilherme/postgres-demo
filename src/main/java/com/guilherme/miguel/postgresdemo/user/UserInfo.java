package com.guilherme.miguel.postgresdemo.user;

import lombok.Data;

import java.util.List;

/**
 * @author Miguel Guilherme
 */
@Data
public class UserInfo {

    private int ttl;

    private String notes;

    private List<Integer> luckyNumbers;

    private AdditionalInfo additionalInfo;

}
