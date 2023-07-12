package com.alibaba.wireless.security.aopsdk;

import com.alibaba.wireless.security.aopsdk.e.f.RuleConfig;

/* loaded from: classes.dex */
public class InvocationConfig {
    private RuleConfig a;
    public int matchedAction;
    public RuleConfig matchedRule;
    public int matchedStrategyId;
    public Object newReturnValue;
    public Throwable newThrowable;
    public boolean shouldBlock;
    public boolean shouldCacheResult;
    public boolean shouldCallback;
    public boolean shouldCatch;
    public boolean shouldChangeReturnValue;
    public boolean shouldIntercept;

    public RuleConfig getCacheRule() {
        return this.a;
    }

    public int getRuleId() {
        return this.matchedRule.m;
    }

    public void setCacheRule(RuleConfig ruleConfig) {
        this.a = ruleConfig;
    }
}
