package my.scripts;

import org.openjdk.btrace.core.annotations.BTrace;
import org.openjdk.btrace.core.annotations.Duration;
import org.openjdk.btrace.core.annotations.Kind;
import org.openjdk.btrace.core.annotations.Location;
import org.openjdk.btrace.core.annotations.OnMethod;
import org.openjdk.btrace.core.annotations.ProbeClassName;
import org.openjdk.btrace.core.annotations.ProbeMethodName;
import org.openjdk.btrace.core.annotations.Self;
import org.openjdk.btrace.core.annotations.TargetInstance;
import org.openjdk.btrace.core.annotations.TargetMethodOrField;
import org.openjdk.btrace.core.annotations.Where;

import static org.openjdk.btrace.core.BTraceUtils.classForName;
import static org.openjdk.btrace.core.BTraceUtils.classOf;
import static org.openjdk.btrace.core.BTraceUtils.name;
import static org.openjdk.btrace.core.BTraceUtils.println;

/**
 * @author chenhanli
 * @date 2022/1/24 4:30 下午
 */
@BTrace
public class TracingOrderCommandCreate {

    // private static final String METHOD_CALL_CLASS = "+com.bigo.ec.platform.trade.center.api.OrderCommandAPI";
    //private static final String TRACED_METHOD = "create";

    // private static final String METHOD_CALL_CLASS = "com.bigo.ec.platform.trade.center.service.application.OrderCommandApplication";
    //private static final String TRACED_METHOD = "preCreatingOrder";

    //private static final String TRACED_CLASS = "com.bigo.ec.platform.trade.center.service.domain.order.service.impl.OrderCommandServiceImpl";
    //private static final String TRACED_METHOD = "preCreatingOrder";

    //private static final String TRACED_CLASS = "com.bigo.ec.platform.trade.center.service.repo.impl.OrderRepoImpl";
    //private static final String TRACED_METHOD = "/createOrder/";

    //private static final String TRACED_CLASS = "com.bigo.ec.platform.trade.center.service.repo.impl.OrderRepoImpl";
    //private static final String TRACED_METHOD = "insertOrderPO";

    // private static final String TRACED_CLASS = "+com.bigo.ec.platform.trade.center.service.repo.mapper.OrderMapper";
    // private static final String TRACED_METHOD = "insertOrder";

    //private static final String TRACED_CLASS = "com.alibaba.druid.filter.FilterChainImpl";
    //private static final String TRACED_METHOD = "connection_prepareStatement";

    private static final String TRACED_CLASS = "+com.mysql.jdbc.ConnectionImpl";
    private static final String TRACED_METHOD = "prepareStatement";

    private static final int COST_THRESHOLD_MILLIS = 10;

    @OnMethod(
            clazz = TRACED_CLASS,
            method = TRACED_METHOD,
            location=@Location(Kind.RETURN)
    )
    public static void traceMethod(@ProbeClassName String probeClassName, @ProbeMethodName String probeMethod, @Duration long duration){
        long cost = duration / 1000000;
        println("[" + cost + "ms] " + probeClassName + "#" + probeMethod);
        println();
    }

    @OnMethod(
            clazz = TRACED_CLASS,
            method = TRACED_METHOD,
            location=@Location(value = Kind.CALL, clazz = "/.*/", method = "/.*/", where = Where.AFTER)
    )
    public static void traceMethodCall(@Self Object self,
                                       @ProbeClassName String probeClassName, @ProbeMethodName String probeMethod,
                                       @TargetInstance Object targetInstance, @TargetMethodOrField String targetMethodOrField,
                                       @Duration long duration){
        //println("self=" + self);
        //println("probeClassName=" + probeClassName);
        //println("probeMethod=" + probeMethod);
        //println("targetInstance=" + targetInstance);
        //println("targetMethodOrField=" + targetMethodOrField);
        //println("duration=" + duration);

        long cost = duration / 1000000;
        if (cost < COST_THRESHOLD_MILLIS) {
            return;
        }

        println("[" + cost + "ms] " + probeClassName + "#" + probeMethod);

        if (null == targetInstance) {
            println("\t-> " + targetMethodOrField);
        } else {
            println("\t-> " + name(classOf(targetInstance)) + "#" + targetMethodOrField);
        }

        println("");
    }

}
