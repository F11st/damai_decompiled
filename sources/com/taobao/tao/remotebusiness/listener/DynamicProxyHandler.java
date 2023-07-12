package com.taobao.tao.remotebusiness.listener;

import com.taobao.tao.remotebusiness.MtopBusiness;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import mtopsdk.mtop.common.MtopListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DynamicProxyHandler implements InvocationHandler {
    private MtopCacheListenerImpl cacheListener;
    private MtopFinishListenerImpl finishListener;
    private MtopListener listener;
    private MtopBusiness mtopBusiness;
    private MtopProgressListenerImpl progressListener;

    public DynamicProxyHandler(MtopBusiness mtopBusiness, MtopListener mtopListener) {
        this.finishListener = new MtopFinishListenerImpl(mtopBusiness, mtopListener);
        this.mtopBusiness = mtopBusiness;
        this.listener = mtopListener;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        String name = method.getName();
        name.hashCode();
        char c = 65535;
        switch (name.hashCode()) {
            case -1809154262:
                if (name.equals("onDataReceived")) {
                    c = 0;
                    break;
                }
                break;
            case 1030363105:
                if (name.equals("onCached")) {
                    c = 1;
                    break;
                }
                break;
            case 1177139532:
                if (name.equals("onHeader")) {
                    c = 2;
                    break;
                }
                break;
            case 2096292721:
                if (name.equals("onFinished")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 2:
                if (this.progressListener == null) {
                    this.progressListener = new MtopProgressListenerImpl(this.mtopBusiness, this.listener);
                }
                return method.invoke(this.progressListener, objArr);
            case 1:
                if (this.cacheListener == null) {
                    this.cacheListener = new MtopCacheListenerImpl(this.mtopBusiness, this.listener);
                }
                return method.invoke(this.cacheListener, objArr);
            case 3:
                return method.invoke(this.finishListener, objArr);
            default:
                return null;
        }
    }
}
