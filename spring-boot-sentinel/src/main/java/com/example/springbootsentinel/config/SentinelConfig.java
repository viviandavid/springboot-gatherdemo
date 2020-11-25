package com.example.springbootsentinel.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author lsd
 * @Date 2020/4/17 15:53
 * @Version 1.0
 **/
@Configuration
public class SentinelConfig {
    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

    @PostConstruct
    private void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("testInterface");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(1);
        rule.setLimitApp("default");
        rules.add(rule);
        FlowRuleManager.loadRules(rules);

        //降级规则，可以多个degradeRule rule
        //DegradeRuleManager.getRules()可以获取到已经设置的降级规则
        List<DegradeRule> degradeRules = new ArrayList<>();
        DegradeRule degradeRule = new DegradeRule();
        //设置资源名称，sentinel降级都是以资源为单位进行
        degradeRule.setResource("circuitBreaker");
        //使用异常统计降级,分钟统计,滑动时间窗口
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        //异常数达到的数量阈值
        degradeRule.setCount(2);
        //秒级时间窗口,该值必须有且必须大于零，否则降级将无法生效
        degradeRule.setTimeWindow(1);
        degradeRules.add(degradeRule);
        //重新加载限流规则，此处将覆盖原有的限流，所以如果想要不覆盖
        //请使用DegradeRuleManager.getRules()获取到的加入到rules中
        DegradeRuleManager.loadRules(degradeRules);
    }
}
