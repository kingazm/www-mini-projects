package com.kingazm.metrics_api.controller;

import com.kingazm.metrics_api.metrics.CpuMetrics;
import com.kingazm.metrics_api.metrics.DiskMetrics;
import com.kingazm.metrics_api.metrics.SystemMetrics;
import com.kingazm.metrics_api.metrics.TimeMetrics;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class AllMetricsController implements HttpHandler {

    private final SystemMetrics systemMetrics = new SystemMetrics();
    private final CpuMetrics cpuMetrics = new CpuMetrics();
    private final DiskMetrics diskMetrics = new DiskMetrics();
    private final TimeMetrics timeMetrics = new TimeMetrics();

    @Override
    public void handle(HttpExchange t) throws IOException {
        String json = """                                                                                                                                                                  
          {                   
              "systemName":  "%s", 
              "userName": "%s",
              "currentTime":  "%s",        
              "cpuUsagePercentage":  %.2f,
              "totalGB":  %.2f,
              "freeGB":   %.2f,
              "usableGB": %.2f,
              "usedGB":   %.2f,
              "ramUsagePercentage": %.2f,
              "heapUsagePercentage": %.2f                                                                                                                                                          
          }
          """.formatted(
                systemMetrics.getSystemName(),
                systemMetrics.getUserName(),
                timeMetrics.getCurrentTime(),
                cpuMetrics.getSystemCpuPercent(),
                diskMetrics.getTotalGB(),
                diskMetrics.getFreeGB(),
                diskMetrics.getUsableGB(),
                diskMetrics.getUsedGB(),
                systemMetrics.getRamUsagePercentage(),
                systemMetrics.getHeapUsagePercentage()
        );

        t.sendResponseHeaders(200, json.getBytes().length);
        OutputStream os = t.getResponseBody();
        os.write(json.getBytes());
        os.close();
    }
}
