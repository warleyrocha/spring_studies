package br.com.devquick.hrpayroll.entities;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    private String name;
    private BigDecimal dailyIncome;
    private Integer days;

    public BigDecimal getTotal() {
        return dailyIncome.multiply(BigDecimal.valueOf(days));
    }
}
