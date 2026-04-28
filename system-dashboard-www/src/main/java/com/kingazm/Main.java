package com.kingazm;

import com.kingazm.dashboard_page.controller.DashboardController;
import com.kingazm.metrics_api.controller.AllMetricsController;
import com.kingazm.metrics_api.controller.CpuMetricsController;
import com.kingazm.metrics_api.controller.DiskMetricsController;
import com.kingazm.metrics_api.controller.SystemMetricsController;
import com.kingazm.metrics_api.controller.TimeMetricsController;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    static CpuMetricsController cpuMetricsController = new CpuMetricsController();
    static TimeMetricsController timeMetricsController = new TimeMetricsController();
    static SystemMetricsController systemMetricsController = new SystemMetricsController();
    static DiskMetricsController diskMetricsController = new DiskMetricsController();

    static AllMetricsController allMetricsController = new AllMetricsController();

    static DashboardController dashboardController = new DashboardController();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/api/system", systemMetricsController);
        server.createContext("/api/cpu", cpuMetricsController);
        server.createContext("/api/disk", diskMetricsController);
        server.createContext("/api/time", timeMetricsController);

        server.createContext("/api/all", allMetricsController);

        server.createContext("/dashboard", dashboardController);

        server.setExecutor(null);
        server.start();
    }
}
