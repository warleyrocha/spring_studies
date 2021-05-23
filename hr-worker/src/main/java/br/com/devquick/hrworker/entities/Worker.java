package br.com.devquick.hrworker.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_WORKER")
public class Worker implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal dailyIncome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return id.equals(worker.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


