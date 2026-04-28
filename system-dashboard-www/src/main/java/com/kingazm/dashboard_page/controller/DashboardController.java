package com.kingazm.dashboard_page.controller;

import com.kingazm.dashboard_page.html.HtmlRenderer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class DashboardController implements HttpHandler {
    private final HtmlRenderer renderer = new HtmlRenderer();

    @Override
    public void handle(HttpExchange t) throws IOException {
        String html = renderer.renderPage();
        t.sendResponseHeaders(200, html.getBytes().length);
        OutputStream os = t.getResponseBody();
        os.write(html.getBytes());
        os.close();
    }
}
