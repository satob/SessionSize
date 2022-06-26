# SessionSize
Monitoring size of HttpSession

Use Java8 and execute:

```
java -javaagent:"/path/to/SizeOf.jar" -javaagent:"/path/to/byteman.jar=script:/path/to/GetSessionManager.btm,boot:/path/to/byteman.jar" -D"org.jboss.byteman.debug" -D"org.jboss.byteman.verbose" -D"org.jboss.byteman.transform.all" -jar ./target/SessionSize-0.0.1-SNAPSHOT.jar
```

## TODO

- Make SessionMonitor works as agent
