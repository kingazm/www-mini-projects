package com.kingazm.metrics_api.metrics;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;

public class SystemMetrics {
    OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
            OperatingSystemMXBean.class);

    public String getSystemName() {
        return osBean.getName();
    }
    public String getUserName() {
        return System.getProperty("user.name");
    }

    public double getRamUsagePercentage() {
        long totalRam = osBean.getTotalMemorySize();
        long freeRam  = osBean.getFreeMemorySize();
        return (double)(totalRam - freeRam) * 100 / totalRam;
    }

    public double getHeapUsagePercentage() {
        MemoryUsage heap = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        return (double) heap.getUsed() * 100 / heap.getMax();
    }
}
