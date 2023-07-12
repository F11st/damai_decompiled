package com.alibaba.wireless.security.aopsdk;

import java.util.Objects;

/* loaded from: classes.dex */
public class AopBridgeDelegate extends AopBridge {
    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public void afterMethod(Invocation invocation) {
        super.afterMethod(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public void beforeMethod(Invocation invocation) {
        super.beforeMethod(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public void callAfterBridge(Invocation invocation) {
        super.callAfterBridge(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public boolean callBeforeBridge(Invocation invocation) {
        return super.callBeforeBridge(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public Object[] getNewArgs(Invocation invocation) {
        return super.getNewArgs(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public Objects getNewReturnValue(Invocation invocation) {
        return super.getNewReturnValue(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public Throwable getNewThrowable(Invocation invocation) {
        return super.getNewThrowable(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public void invokeCallback(Invocation invocation) {
        super.invokeCallback(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public boolean isWatchMode(Invocation invocation) {
        return super.isWatchMode(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public void report(Invocation invocation) {
        super.report(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public Object resultBridge(Invocation invocation) throws Throwable {
        return super.resultBridge(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public void resultBridgeV(Invocation invocation) throws Throwable {
        super.resultBridgeV(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public boolean shouldBlock(Invocation invocation) {
        return super.shouldBlock(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public boolean shouldCallback(Invocation invocation) {
        return super.shouldCallback(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public boolean shouldCatch(Invocation invocation) {
        return super.shouldCatch(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public boolean shouldChangeArgs(Invocation invocation) {
        return super.shouldChangeArgs(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public boolean shouldChangeReturnValue(Invocation invocation) {
        return super.shouldChangeReturnValue(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public boolean shouldSampleDefault(Invocation invocation) {
        return super.shouldSampleDefault(invocation);
    }
}
