package com.demo.bean.so.client;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class ClientAddSO {
    @Valid
    private List<ClientAdd> clients;
}