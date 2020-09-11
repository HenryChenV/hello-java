package cn.chenhenry.java;

import com.sun.tools.attach.*;

import java.io.IOException;
import java.util.List;

/**
 * @author henrychen
 * @date created at 2020/9/11 1:29 下午
 */
public class AgentMainJavaAgentTest {

    public static void main(String[] args) throws IOException, AgentLoadException, AgentInitializationException, AttachNotSupportedException {
        System.out.println("AgentMainJavaAgentTest main start");

        //获取当前系统中所有 运行中的 虚拟机
        List<VirtualMachineDescriptor> list = VirtualMachine.list();

        for (VirtualMachineDescriptor vmd : list) {
            System.out.println(vmd.displayName());

            //如果虚拟机的名称为 xxx 则 该虚拟机为目标虚拟机，获取该虚拟机的 pid
            if (vmd.displayName().endsWith(AgentMainJavaAgentTest.class.getName())) {
                //然后加载 agent.jar 发送给该虚拟机
                VirtualMachine virtualMachine = VirtualMachine.attach(vmd.id());
                virtualMachine.loadAgent("./hello-javaagent/target/hello-javaagent-1.0-SNAPSHOT.jar");
                virtualMachine.detach();
            }
        }

        System.out.println("AgentMainJavaAgentTest main end");
    }

}
