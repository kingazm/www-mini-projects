# System Monitor Dashboard
This is a system dashboard, allowing user to monitor dynamically changing parameters like RAM and CPU usage, system running, time and disk space available. The project relies on ajax, JQuery and Java to serve the HTML&CSS content.

## To run the app locally:
```bash
cd src/main/java
javac -d out $(find com -name "*.java")
java -cp out com.kingazm.Main
```

The actual UI will be on localhost:8000/dashboard, and computer metrics API on localhost:8000/api/all


