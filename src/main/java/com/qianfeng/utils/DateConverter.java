package com.qianfeng.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *@Author feri
 *@Date Created in 2019/3/1 14:45
 */
public class DateConverter implements Converter<String, Date> {
    private static final List<String> formarts = new ArrayList<>(4);
    static {
        formarts.add("yyyy");
        formarts.add("yyyy-MM");
        formarts.add("yyyy-MM-dd");
        formarts.add("yyyy-MM-dd hh");
        formarts.add("yyyy-MM-dd hh:mm");
        formarts.add("yyyy-MM-dd hh:mm:ss");
    }
    @Override
    public Date convert(String source) {
        if(StringUtils.isEmpty(source)){
            return null;
        }
        try {
            String formatter = "";
            if (source.matches("^\\d{4}$")) {
                formatter = formarts.get(0);
            }
            else if (source.matches("^\\d{4}-\\d{1,2}$")) {
                formatter = formarts.get(1);
            } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
                formatter = formarts.get(2);
            } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}$")) {
                formatter = formarts.get(3);
            }else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
            formatter = formarts.get(4);
        }else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
                formatter = formarts.get(5);
            } else {
                throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat(formatter);
            return dateFormat.parse(source);
        } catch (Exception e){
            return null;
        }
    }
}