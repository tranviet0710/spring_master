package com.eazybytes.model;

/**
 * @author VietDev
 * @date 26/07/2023
 * @role
 */
public class Holiday {
    private String day;
    private String reason;
    private Type type;

    public enum Type{
        FESTIVAL, FEDERAL
    }

    public Holiday(String day, String reason, Type type) {
        this.day = day;
        this.reason = reason;
        this.type = type;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "day='" + day + '\'' +
                ", reason='" + reason + '\'' +
                ", type=" + type +
                '}';
    }
}

