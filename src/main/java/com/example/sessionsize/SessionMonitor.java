package com.example.sessionsize;

import org.apache.catalina.Manager;
import org.apache.catalina.Session;

import net.sourceforge.sizeof.SizeOf;

public class SessionMonitor implements SessionMonitorMBean {

    private static Manager sessionManager = null;

    public static void setSessionManager(Manager manager) {
        sessionManager = manager;
    }

    @Override
    public long getMemoryConsumption() {
        if (sessionManager != null) {
            try {
                Session [] sessions = sessionManager.findSessions();
                return SizeOf.deepSizeOf(sessions);
            } catch(RuntimeException e) {
                // Falied to get size of HttpSession object
                e.printStackTrace();
                return -2;
            }
        } else {
            // SessionManager is not ready
            return -1;
        }
    }

    @Override
    public long getNumberOfActiveHttpSession() {
        return sessionManager.findSessions().length;
    }
}
