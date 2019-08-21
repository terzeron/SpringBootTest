package com.terzeron.springboot;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
@PropertySource("classpath:configprops-conversion.properties")
@ConfigurationProperties(prefix = "conversion")
@Getter
@Setter
@ToString
public class PropertyConversion {
    // 이하 모두 초 단위로
    private Duration timeInDefaultUnit;
    private Duration timeInNano;

    // 입력: 날짜 단위 -> 초 단위
    @DurationUnit(ChronoUnit.DAYS)
    private Duration timeInDays;

    // 이하 모두 바이트 단위로
    private DataSize sizeInDefaultUnit;
    private DataSize sizeInGB;

    // 입력: TB -> B
    @DataSizeUnit(DataUnit.TERABYTES)
    private DataSize sizeInTB;

    private Employee employee;
}
