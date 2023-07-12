package com.alibaba.aliweex.plugin;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
class WorkFlow$WorkFlowException extends RuntimeException {
    WorkFlow$WorkFlowException(Throwable th) {
        super(th);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "WorkException{causeException=" + getCause() + "} " + super.toString();
    }
}
