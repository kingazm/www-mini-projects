package com.kingazm;

import com.kingazm.dashboard_page.controller.DashboardController;
import com.kingazm.metrics_api.controller.AllMetricsController;;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    static AllMetricsController allMetricsController = new AllMetricsController();

    static DashboardController dashboardController = new DashboardController();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/api/all", allMetricsController);
        server.createContext("/dashboard", dashboardController);
        server.setExecutor(null);
        server.start();
    }
}
