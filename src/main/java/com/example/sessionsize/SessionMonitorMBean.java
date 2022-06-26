package com.example.sessionsize;

public interface SessionMonitorMBean {
    long getMemoryConsumption();
    long getNumberOfActiveHttpSession();
}
