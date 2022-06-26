package com.example.sessionsizeagent;

import java.lang.instrument.Instrumentation;
import java.lang.management.ManagementFactory;

import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.ObjectName;

public class SessionSizeAgent {
    public static void premain(String agentArgs, Instrumentation instrumentation) throws JMException {
        SessionMonitor monitor = new SessionMonitor();
        String name = "com.example.sessionsize:type=SessionMonitor";
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(monitor, new ObjectName(name));
    }
}
