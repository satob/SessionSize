package com.example.sessionsizeagent;

public interface SessionMonitorMBean {
    long getMemoryConsumption();
    long getNumberOfActiveHttpSession();
}
