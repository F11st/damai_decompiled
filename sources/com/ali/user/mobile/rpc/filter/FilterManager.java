package com.ali.user.mobile.rpc.filter;

import com.ali.user.mobile.rpc.RpcResponse;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class FilterManager {
    public static final String CONTINUE = "CONTINUE";
    public static final String STOP = "STOP";
    private static final String TAG = "FilterManager";
    private static FilterManager instance;

    private FilterManager() {
    }

    public static FilterManager getInstance() {
        if (instance == null) {
            synchronized (FilterManager.class) {
                if (instance == null) {
                    instance = new FilterManager();
                }
            }
        }
        return instance;
    }

    public void afterRpc(List<IAfterFilter> list, RpcResponse rpcResponse) {
        String doAfter;
        if (list == null) {
            return;
        }
        Iterator<IAfterFilter> it = list.iterator();
        while (it.hasNext() && (doAfter = it.next().doAfter(rpcResponse)) != null && !"STOP".equals(doAfter)) {
        }
    }

    public void beforeRpc(List<IBeforeFilter> list) {
        String doBefore;
        if (list == null) {
            return;
        }
        Iterator<IBeforeFilter> it = list.iterator();
        while (it.hasNext() && (doBefore = it.next().doBefore()) != null && !"STOP".equals(doBefore)) {
        }
    }
}
