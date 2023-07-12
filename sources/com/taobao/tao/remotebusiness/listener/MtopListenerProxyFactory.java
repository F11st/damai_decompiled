package com.taobao.tao.remotebusiness.listener;

import com.taobao.tao.remotebusiness.IRemoteCacheListener;
import com.taobao.tao.remotebusiness.IRemoteProcessListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopListener;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopListenerProxyFactory {
    public static MtopListener getMtopListenerProxy(MtopBusiness mtopBusiness, MtopListener mtopListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(MtopCallback.MtopFinishListener.class);
        if (mtopListener instanceof IRemoteProcessListener) {
            arrayList.add(MtopCallback.MtopProgressListener.class);
            arrayList.add(MtopCallback.MtopHeaderListener.class);
        }
        if ((mtopListener instanceof IRemoteCacheListener) || mtopBusiness.mtopProp.useCache) {
            arrayList.add(MtopCallback.MtopCacheListener.class);
        }
        return (MtopListener) Proxy.newProxyInstance(MtopListener.class.getClassLoader(), (Class[]) arrayList.toArray(new Class[arrayList.size()]), new DynamicProxyHandler(mtopBusiness, mtopListener));
    }
}
