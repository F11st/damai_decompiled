package com.youku.alixplayer.opensdk.interceptor;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RealInterceptionChain implements Chain<Object> {
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

    @Override // com.youku.alixplayer.opensdk.interceptor.Chain
    public int getAction() {
        return this.mAction;
    }

    @Override // com.youku.alixplayer.opensdk.interceptor.Chain
    public Object getParam() {
        return this.mParam;
    }

    @Override // com.youku.alixplayer.opensdk.interceptor.Chain
    public void proceed() {
        if (this.mIndex < this.mInterceptors.size()) {
            this.mInterceptors.get(this.mIndex).intercept(new RealInterceptionChain(this.mInterceptors, this.mAction, this.mIndex + 1, this.mParam));
            return;
        }
        throw new AssertionError();
    }

    @Override // com.youku.alixplayer.opensdk.interceptor.Chain
    public void setParam(Object obj) {
        this.mParam = obj;
    }
}
