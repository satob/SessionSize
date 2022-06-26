package com.example.sessionsizeagent;

import org.apache.catalina.Manager;
import org.apache.catalina.Session;

import net.sourceforge.sizeof.SizeOf;

public class SessionMonitor implements SessionMonitorMBean {

    private static Manager sessionManager = null;

    public static void setSessionManager(Manager manager) {
        sessionManager = manager;
        // System.out.println("SessionManager have been set.");
    }

    @Override
    public long getMemoryConsumption() {
        if (sessionManager != null) {
            Session [] sessions = sessionManager.findSessions();
            return SizeOf.deepSizeOf(sessions);
        } else {
            System.out.println("SessionManager is not ready.");
            return -1;
        }
    }

    @Override
    public long getNumberOfActiveHttpSession() {
        return sessionManager.findSessions().length;
    }
}
