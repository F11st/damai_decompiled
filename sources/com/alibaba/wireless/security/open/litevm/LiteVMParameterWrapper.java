package com.alibaba.wireless.security.open.litevm;

import com.alibaba.wireless.security.open.litevm.LiteVMParamType;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class LiteVMParameterWrapper {
    private LiteVMParamType.PARAM_TYPE a;
    private Object b;

    public LiteVMParameterWrapper(LiteVMParamType.PARAM_TYPE param_type, Object obj) {
        this.a = param_type;
        this.b = obj;
    }

    public int getType() {
        return this.a.getValue();
    }

    public Object getValue() {
        return this.b;
    }
}
