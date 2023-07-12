package com.youku.playerservice.axp.interceptor;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class RealInterceptionWrapper {
    public RealInterceptionWrapper(int i, Object obj, List<Interceptor> list, Interceptor interceptor) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(interceptor);
        new RealInterceptionChain(arrayList, i, 0, obj).proceed();
    }
}
