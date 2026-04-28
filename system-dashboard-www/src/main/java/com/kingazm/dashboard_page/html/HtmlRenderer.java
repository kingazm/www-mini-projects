package com.kingazm.dashboard_page.html;

public class HtmlRenderer {
    public String renderPage() {
        return """
                <html>
                <head>
                <meta charset="UTF-8">
                  <link rel="preconnect" href="https://fonts.googleapis.com">
                   <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>                                                                                                              \s
                   <link href="https://fonts.googleapis.com/css2?family=JetBrains+Mono:wght@300;400;500;700&display=swap" rel="stylesheet">
               
                <script
                src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
                <script>
                async function getAllMetrics() {
                    const res = await fetch('/api/all');                                                                                                                                        \s
                    const data = await res.json();
                    const json = JSON.stringify(data);
                    const metrics = JSON.parse(json);
                    
                    $("#systemName").text(metrics.systemName);
                    $("#currentTime").text(metrics.currentTime);
                    $("#cpuUsagePercentage").text(metrics.cpuUsagePercentage + " %s");
                    $("#totalGB").text(metrics.totalGB + " GB");  
                    $("#freeGB").text(metrics.freeGB + " GB");   
                    $("#usedGB").text(metrics.usedGB + " GB");  
                    $("#usableGB").text(metrics.usableGB + " GB");
                    
                    $("#dashboard-header").text("Welcome back, " + metrics.userName);
                    
                    $("#ramUsagePercentage").text(metrics.ramUsagePercentage + " %s");
                    $("#heapUsagePercentage").text(metrics.heapUsagePercentage + " %s");
                };
             
                
                $(document).ready(function(){
                    setInterval(async () => {
                       getAllMetrics();                                                                                                                                                                                                                                                                                                    
                  }, 1000);
                });

                </script>
                
                <style>
                    %s
                </style>
                
                </head>
                
                <body>
                <h1 id="dashboard-header">Welcome back</h1>
                <div class="live-badge">LIVE SYSTEM MONITOR</div>

                <div class="dashboard-container">
                
                    <div class="left-column">
                        <div class="time-box">
                            <h2>Time</h2>
                            <p id = "currentTime">Loading...</p>
                        </div>
                        
                        <div class="system-box">
                        <h2>System</h2>
                        <p id = "systemName">Loading...</p>
                        
                        <h2>CPU usage</h2>
                        <p id = "cpuUsagePercentage">Loading...</p>
                        
                        <h2>RAM usage</h2>
                        <p id = "ramUsagePercentage">Loading...</p>
                        
                        </div>
 
                    </div>
                    
                    <div class="right-column">
                        <div class="disk-box">
                            <h2>Total disk space in GB</h2>
                            <p id = "totalGB">Loading...</p>
                        
                            <h2>Free disk space in GB</h2>
                            <p id = "freeGB">Loading...</p>
                        
                            <h2>Used disk space in GB</h2>
                            <p id = "usedGB">Loading...</p>
                        </div>
                        
                        <div class="time-box">
                            <h2>Heap memory usage</h2>
                            <p id = "heapUsagePercentage">Loading...</p>  
                        </div>
                        
                    </div>
                   
                    
                </div>
               
                    %s
                
               </body>
                
                </html>""".formatted("%", "%", "%",
                renderStyles(),
                renderFooter()
        );
    }

    private String renderFooter() {
        return "<div class='footer'>by Kinga Żmuda &copy; 2026</div>";
    }

    private String renderStyles() {
        return """

            *, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }

            body {
                background: #000;
                color: #1bbc68;
                font-family: 'JetBrains Mono', monospace;
                font-weight: 400;
                min-height: 100vh;
                display: flex;
                flex-direction: column;
                overflow-x: hidden;
            }

            body::after {
                content: '';
                position: fixed;
                inset: 0;
                background: repeating-linear-gradient(
                    to bottom,
                    transparent 0px,
                    transparent 3px,
                    rgba(0, 0, 0, 0.08) 3px,
                    rgba(0, 0, 0, 0.08) 4px
                );
                pointer-events: none;
                z-index: 9999;
            }

            @keyframes blink {
                0%, 100% { opacity: 1; }
                50%       { opacity: 0; }
            }

            @keyframes pulse-glow {
                0%, 100% { box-shadow: 0 0 8px #1bbc6855,  0 0 20px #1bbc6822; }
                50%       { box-shadow: 0 0 16px #1bbc68aa, 0 0 40px #1bbc6844; }
            }

            @keyframes fadeIn {
                from { opacity: 0; transform: translateY(12px); }
                to   { opacity: 1; transform: translateY(0);    }
            }

            #dashboard-header {
                text-align: center;
                margin-top: 6vh;
                margin-bottom: 0.5vh;
                font-weight: 700;
                font-size: clamp(22px, 3vw, 40px);
                letter-spacing: 4px;
                text-transform: uppercase;
                text-shadow: 0 0 10px #1bbc68cc, 0 0 30px #1bbc6855;
                animation: fadeIn 0.8s ease both;
            }

            #dashboard-header::after {
                content: '_';
                animation: blink 1.1s step-end infinite;
            }

            .live-badge {
                display: flex;
                align-items: center;
                justify-content: center;
                gap: 8px;
                font-size: 15px;
                letter-spacing: 3px;
                color: #1bbc6899;
                margin-top: 2vh;
                margin-bottom: 2vh;
                animation: fadeIn 1s ease 0.3s both;
            }

            .live-badge::before {
                content: '';
                width: 8px;
                height: 8px;
                border-radius: 50%;
                background: #1bbc68;
                box-shadow: 0 0 6px #1bbc68;
                animation: blink 1.4s ease-in-out infinite;
            }

            .dashboard-container {
                display: flex;
                flex-wrap: wrap;
                gap: 2vw;
                margin: 6vh 5vw 4vh;
                animation: fadeIn 0.9s ease 0.2s both;
                flex: 1;
            }

            .left-column  { flex: 2 1 220px; display: flex; flex-direction: column; gap: 2vh; }
            .right-column { flex: 3 1 300px; display: flex; flex-direction: column; gap: 2vh; }

            .time-box,
            .system-box,
            .disk-box {
                background: #050505;
                border: 1px solid #1bbc6833;
                border-radius: 12px;
                padding: 20px 24px;
                animation: pulse-glow 4s ease-in-out infinite;
                transition: border-color 0.3s ease;
            }

            .time-box:hover,
            .system-box:hover,
            .disk-box:hover {
                border-color: #1bbc6877;
            }

            h2 {
                font-size: 20px;
                font-weight: 700;
                letter-spacing: 3px;
                text-transform: uppercase;
                color: #1bbc6877;
                margin-bottom: 4px;
                margin-top: 16px;
            }

            h2:first-child { margin-top: 0; }

            h2::before {
                content: '> ';
                color: #1bbc6844;
            }

            p {
                font-size: clamp(18px, 2vw, 26px);
                font-weight: 700;
                letter-spacing: 1px;
                color: #1bbc68;
                text-shadow: 0 0 8px #1bbc6888;
                min-height: 1.4em;
            }

            .footer {
                text-align: center;
                font-size: 20px;
                letter-spacing: 3px;
                color: #1bbc6877;
                padding-top: 8vh;
                border-top: 1px solid #1bbc6818;
                margin-top: auto;
                height: 20vh;
            }
        """;
    }
}