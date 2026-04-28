package com.kingazm.metrics_api.metrics;

import java.io.File;

public class DiskMetrics {
    File root = new File("/");
    final double DIVISOR_FOR_GB_VALUE = 1073741824;

    public double getTotalGB() {
        return (double)root.getTotalSpace() / DIVISOR_FOR_GB_VALUE;
    }

    public double getFreeGB() {
        return (double)root.getFreeSpace() / DIVISOR_FOR_GB_VALUE;
    }

    public double getUsableGB() {
        return (double)root.getUsableSpace() / DIVISOR_FOR_GB_VALUE;
    }

    public double getUsedGB() {
        return getTotalGB() - getFreeGB();
    }

}
