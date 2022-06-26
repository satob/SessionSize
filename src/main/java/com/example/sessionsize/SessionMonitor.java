package com.example.sessionsize;

import org.apache.catalina.Manager;
import org.apache.catalina.Session;

import net.sourceforge.sizeof.SizeOf;

public class SessionMonitor implements SessionMonitorMBean {

    private static Manager sessionManager = null;

    public static void setSessionManager(Manager manager) {
        sessionManager = manager;
        System.out.println("SessionManager have been set.");
    }

    @Override
    public long getMemoryConsumption() {
        if (sessionManager != null) {
            Session [] sessions = sessionManager.findSessions();
            return SizeOf.deepSizeOf(sessions);
            // System.out.println("Session size: " + SizeOf.deepSizeOf(sessions));

            /*
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos;
            try {
                oos = new ObjectOutputStream(baos);
                oos.writeObject(sessions);
                oos.flush();
                oos.close();
                return baos.toByteArray().length;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return -2;
            */

            // return sessions.length;
        } else {
            System.out.println("SessionManager is not ready.");
            return -1;
        }
    }
}
