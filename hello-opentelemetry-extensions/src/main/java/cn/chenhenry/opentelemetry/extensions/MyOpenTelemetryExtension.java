package cn.chenhenry.opentelemetry.extensions;

import com.google.auto.service.AutoService;
import io.opentelemetry.javaagent.tooling.AgentExtension;
import net.bytebuddy.agent.builder.AgentBuilder;

/**
 * @author chenhanli
 * @date 2022/3/18 6:31 下午
 */
@AutoService(AgentExtension.class)
public class MyOpenTelemetryExtension implements AgentExtension {
    @Override
    public AgentBuilder extend(AgentBuilder agentBuilder) {
        System.err.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx 成功加载自定义拓展包");
        return agentBuilder;
    }

    @Override
    public String extensionName() {
        return "chl-opentelemetry-extension";
    }
}
