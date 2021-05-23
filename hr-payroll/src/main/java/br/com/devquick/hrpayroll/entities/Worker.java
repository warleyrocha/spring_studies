package br.com.devquick.hrpayroll.entities;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Worker implements Serializable {

    private Long id;
    private String name;
    private BigDecimal dailyIncome;

}

