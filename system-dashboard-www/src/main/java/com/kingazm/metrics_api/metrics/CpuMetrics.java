package com.kingazm.metrics_api.metrics;

import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class CpuMetrics {

    private static final OperatingSystemMXBean OS_BEAN =
            (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    private final AtomicLong systemCpuRaw  = new AtomicLong(-1);

    public CpuMetrics() {
        Executors.newSingleThreadScheduledExecutor(r -> {
            Thread t = new Thread(r, "cpu-sampler");
            t.setDaemon(true); // don't prevent JVM shutdown
            return t;
        }).scheduleAtFixedRate(this::sample, 0, 1, TimeUnit.SECONDS);
    }

    private void sample() {
        double sys  = OS_BEAN.getCpuLoad();
        double proc = OS_BEAN.getProcessCpuLoad();
        if (sys  >= 0) {
            systemCpuRaw.set(Math.round(sys  * 10_000));
        }
    }

    /** Returns system CPU 0.0–100.0, or -1 if not yet available */
    public double getSystemCpuPercent() {
        long raw = systemCpuRaw.get();
        return raw < 0 ? -1 : raw / 100.0;
    }
}
