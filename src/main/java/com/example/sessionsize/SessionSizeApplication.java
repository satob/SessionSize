package com.example.sessionsize;

import java.io.IOException;
import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SessionSizeApplication {

	public static void main(String[] args) throws IOException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, MalformedObjectNameException {
	    /*
	    String pid = ManagementFactory.getRuntimeMXBean().getName();
	    pid = pid.substring(0, pid.indexOf('@'));
	    String date = new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(new Date());
	    String fileName = "./FatalError_" + "_" + date + ".log";
	    HotSpotDiagnosticMXBean bean = ManagementFactory.newPlatformMXBeanProxy(
	        ManagementFactory.getPlatformMBeanServer(),
	        "com.sun.management:type=HotSpotDiagnostic",
	        HotSpotDiagnosticMXBean.class);
	    bean.setVMOption("ErrorFile", fileName);
         */
	    // bean.setVMOption("HeapDumpOnOutOfMemoryError", "true");
	    // bean.setVMOption("HeapDumpPath", fileName);

	    SessionMonitor monitor = new SessionMonitor(); // MBean オブジェクトの生成
	    String name = "com.example.sessionsize:type=SessionMonitor"; // MBean 名
	    MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer(); // MBeanServer を取得
	    mBeanServer.registerMBean(monitor, new ObjectName(name)); // 登録

		SpringApplication.run(SessionSizeApplication.class, args);
	}

}
