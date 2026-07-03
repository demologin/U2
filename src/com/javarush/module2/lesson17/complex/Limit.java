package com.javarush.module2.lesson17.complex;

import java.time.LocalDateTime;

public class Limit {
    private Long maxEvents;

    private LocalDateTime finishTime;

    @Override
    public String toString() {
        return "Limit{" +
               "\n\tmaxEvents=" + maxEvents +
               "\n\tfinishTime=" + finishTime +
               "\n\t}";
    }
}
