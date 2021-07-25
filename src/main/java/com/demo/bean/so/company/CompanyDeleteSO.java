package com.demo.bean.so.company;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CompanyDeleteSO {
    @NotEmpty
    private List<@NotNull Integer> ids;
}
