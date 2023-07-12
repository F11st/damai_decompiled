package com.alibaba.wireless.security.aopsdk;

import androidx.annotation.Keep;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Keep
/* loaded from: classes.dex */
public class AopDelegateChain extends AopBridge {
    private final List<AopBridge> mDelegates = new CopyOnWriteArrayList();
    private AopBridge mainDelegate;

    public AopDelegateChain(AopBridge aopBridge) {
        this.mainDelegate = aopBridge;
    }

    public void addDelegate(AopBridge aopBridge) {
        if (aopBridge != null) {
            this.mDelegates.add(aopBridge);
        }
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public void callAfterBridge(Invocation invocation) {
        this.mainDelegate.callAfterBridge(invocation);
        for (AopBridge aopBridge : this.mDelegates) {
            aopBridge.callAfterBridge(invocation);
        }
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public boolean callBeforeBridge(Invocation invocation) {
        boolean callBeforeBridge = this.mainDelegate.callBeforeBridge(invocation);
        Iterator<AopBridge> it = this.mDelegates.iterator();
        while (true) {
            boolean z = callBeforeBridge;
            if (!it.hasNext()) {
                return z;
            }
            callBeforeBridge = it.next().callBeforeBridge(invocation) | z;
        }
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public void callOnConstructor(Invocation invocation) {
        this.mainDelegate.callOnConstructor(invocation);
        for (AopBridge aopBridge : this.mDelegates) {
            aopBridge.callOnConstructor(invocation);
        }
    }

    public AopBridge getMainDelegate() {
        return this.mainDelegate;
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public boolean getTp() {
        return this.mainDelegate.getTp();
    }

    public void removeDelegate(AopBridge aopBridge) {
        this.mDelegates.remove(aopBridge);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public void reportTimeCost(Invocation invocation) {
        this.mainDelegate.reportTimeCost(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public Object resultBridge(Invocation invocation) throws Throwable {
        return this.mainDelegate.resultBridge(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public void resultBridgeV(Invocation invocation) throws Throwable {
        this.mainDelegate.resultBridgeV(invocation);
    }

    public void setMainDelegate(AopBridge aopBridge) {
        this.mainDelegate = aopBridge;
    }
}
