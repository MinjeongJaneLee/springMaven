package com.spring.system.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


@UtilityClass
public class CommonUtils {

    public static final List<String> EXCLUDE_PAGINATION_PARAM = Arrays.asList("page");

    public boolean isBlank(Object src) {
        if (src instanceof Object[]) {
            return ArrayUtils.isEmpty((Object[]) src) || Arrays.stream((Object[]) src).filter(e -> isNotBlank(e)).count() == 0;
        }
        else if (src instanceof Collection) {
            return CollectionUtils.isEmpty((List<?>) src);
        }
        else if (src instanceof Map) {
            return MapUtils.isEmpty((Map<?, ?>) src);
        }
        else if (src instanceof String) {
            return StringUtils.isBlank((String) src);
        }
        else {
            return src == null;
        }
    }


    private boolean isNaN(Number src) {
        if (src instanceof Double) {
            return Double.isNaN((Double) src);
        }
        return false;
    }


    public boolean isNotBlank(Object src) {
        return !isBlank(src);
    }


    public <T> T ifBlank(T src, T defaultValue) {
        if (isBlank(src)) {
            return defaultValue;
        }
        return src;
    }


    public <T> T ifNotBlank(T src, Function<T, T> after) {
        if (isBlank(src)) {
            return src;
        }
        return after.apply(src);
    }


    /**
     * @see {ifBlank}
     */
    @Deprecated
    public String ifBlankStr(String str, String defaultStr) {
        return ifBlank(str, defaultStr);
    }


    public Object ifElse(boolean condition, Object a, Object b) {
        if (condition) {
            return a;
        }
        else {
            return b;
        }
    }


    public String concat(String lhs, String rhs) {
        return StringUtils.join(lhs, rhs);
    }


    public String leftPad(String src, int length, String padding) {
        return StringUtils.leftPad(String.valueOf(src), length, padding);
    }


    public String makeParametersExcludePagination(Map<String, String[]> paramValues) {
        if (isBlank(paramValues)) {
            return StringUtils.EMPTY;
        }

        return StringUtils.defaultString(paramValues.entrySet().stream().filter(es -> {
            return !EXCLUDE_PAGINATION_PARAM.contains(es.getKey()) && isNotBlank(es.getValue());
        }).map(es -> {
            return Arrays.asList(es.getValue()).stream().filter(e -> {
                return isNotBlank(e);
            }).map(e -> {
                return String.format("%s=%s", es.getKey(), e);
            }).collect(Collectors.joining("&"));
        }).collect(Collectors.joining("&")));
    }

    public String maskingId(String src) {
        return ifNotBlank(src, o -> o.replaceAll("(?<=.{3}).(?=.{2})", "*"));
    }


    public String maskingPhone(String src) {
        return ifNotBlank(src, o -> o.replaceAll(".(?=.{4})", "*"));
    }


    public String maskingEmail(String src) {
        return ifNotBlank(src, o -> o.replaceAll("(?<=.{3}).(?=.*@)", "*"));
    }


    public String numberWithCommas(Number src) {
        if (isBlank(src) || isNaN(src)) {
            return "0";
        }

        return StringUtils.replacePattern(src.toString(), "\\B(?=(\\d{3})+(?!\\d))", ",");
    }


    public Date now() {
        return Date.from(Instant.now());
    }

}
