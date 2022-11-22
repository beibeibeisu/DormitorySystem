package com.fjl.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class mytest {
    @Test
    public void test01(){
        LocalDate now = LocalDate.now();
        String format = DateTimeFormatter.ofPattern("yyyy年-M月-d日").format(now);
        System.out.println(format);
    }
}
