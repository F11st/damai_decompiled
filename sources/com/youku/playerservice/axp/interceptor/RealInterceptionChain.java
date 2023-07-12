package com.youku.playerservice.axp.interceptor;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class RealInterceptionChain implements Chain {
    private int mAction;
    private final int mIndex;
    private final List<Interceptor> mInterceptors;
    private Object mParam;

    public RealInterceptionChain(List<Interceptor> list, int i, int i2, Object obj) {
        this.mInterceptors = list;
        this.mAction = i;
        this.mIndex = i2;
        this.mParam = obj;
    }

    @Override // com.youku.playerservice.axp.interceptor.Chain
    public int getAction() {
        return this.mAction;
    }

    @Override // com.youku.playerservice.axp.interceptor.Chain
    public <T> T getParam() {
        return (T) this.mParam;
    }

    @Override // com.youku.playerservice.axp.interceptor.Chain
    public void proceed() {
        if (this.mIndex >= this.mInterceptors.size()) {
            throw new AssertionError();
        }
        this.mInterceptors.get(this.mIndex).intercept(new RealInterceptionChain(this.mInterceptors, this.mAction, this.mIndex + 1, this.mParam));
    }

    @Override // com.youku.playerservice.axp.interceptor.Chain
    public void setParam(Object obj) {
        this.mParam = obj;
    }
}
