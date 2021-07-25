package com.demo.bean.so.client;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ClientDeleteSO {
    @NotEmpty
    private List<@NotNull Integer> ids;
}
