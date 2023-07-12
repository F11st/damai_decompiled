package com.alibaba.wireless.security.aopsdk;

import com.alibaba.wireless.security.aopsdk.e.f.e;

/* loaded from: classes.dex */
public class InvocationConfig {
    private e a;
    public int matchedAction;
    public e matchedRule;
    public int matchedStrategyId;
    public Object newReturnValue;
    public Throwable newThrowable;
    public boolean shouldBlock;
    public boolean shouldCacheResult;
    public boolean shouldCallback;
    public boolean shouldCatch;
    public boolean shouldChangeReturnValue;
    public boolean shouldIntercept;

    public e getCacheRule() {
        return this.a;
    }

    public int getRuleId() {
        return this.matchedRule.m;
    }

    public void setCacheRule(e eVar) {
        this.a = eVar;
    }
}
