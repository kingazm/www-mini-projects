package com.kingazm.metrics_api.metrics;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeMetrics {
    private ZoneId id;
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("HH:mm:ss");

    public TimeMetrics() {
        id = ZoneId.systemDefault();
    }

    public String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now(id);
        return "" + now.format(FMT);
    }
}
