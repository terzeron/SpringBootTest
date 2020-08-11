package com.terzeron.springboot;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class WordCount {
    String word;
    Long count;
    Date start;
    Date end;
}
