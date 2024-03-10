package com.nurmatov.mindhunter.domain.entity.userInfo;

import com.nurmatov.mindhunter.domain.enums.SalaryType;
import com.nurmatov.mindhunter.domain.enums.Valute;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private SalaryType salaryType;
    private Double total;
    @Enumerated(EnumType.STRING)
    private Valute valute;
}
