package my.scripts;

import org.openjdk.btrace.core.BTraceUtils;
import org.openjdk.btrace.core.annotations.BTrace;
import org.openjdk.btrace.core.annotations.Duration;
import org.openjdk.btrace.core.annotations.Kind;
import org.openjdk.btrace.core.annotations.Location;
import org.openjdk.btrace.core.annotations.OnMethod;
import org.openjdk.btrace.core.annotations.ProbeClassName;
import org.openjdk.btrace.core.annotations.ProbeMethodName;
import org.openjdk.btrace.core.annotations.Where;

import static org.openjdk.btrace.core.BTraceUtils.print;
import static org.openjdk.btrace.core.BTraceUtils.println;
import static org.openjdk.btrace.core.BTraceUtils.strcat;

/**
 * @author chenhanli
 * @date 2022/1/24 4:30 下午
 */
@BTrace
public class TracingScript {

    // @OnMethod(clazz = "/.*/", method = "/.*/", location = @Location(Kind.RETURN))
    @OnMethod(
            clazz = "com.bigo.ec.platform.trade.center.service.controller.OrderCommandAPIController",
            method = "create",
            //location = @Location(value = Kind.CALL, clazz = "/.*/", method = "/.*/", where = Where.AFTER)
            location=@Location(Kind.RETURN)
    )
    public static void slowQuery(@ProbeClassName String probeClassName, @ProbeMethodName String probeMethod, @Duration long duration){
        printMethodCost(probeClassName, probeMethod, duration);
    }

    public static void printMethodCost(String probeClassName, String probeMethod, long duration) {
        long cost = duration / 1000000;
        if(cost > 100){
            String output = probeClassName + "#" + probeMethod + " cost " + cost + "ms";
            println(output);
        }
    }

}
