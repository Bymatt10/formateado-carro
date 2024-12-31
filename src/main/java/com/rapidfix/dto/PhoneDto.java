package com.rapidfix.dto;

import com.rapidfix.OperatorEnum;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@RegisterForReflection
@Data
public class PhoneDto {
    private OperatorEnum operator;
    private String phone;
}
