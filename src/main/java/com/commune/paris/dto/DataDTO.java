package com.commune.paris.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class DataDTO {

    private List<String> nameList = new ArrayList<>();

    private List<Integer> countList = new ArrayList<>();
}
