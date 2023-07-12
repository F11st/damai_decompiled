package com.youku.arch.v3.page;

import android.content.Context;
import android.net.Uri;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DelegateManagerCache {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile DelegateManagerCache instance;
    private ConcurrentHashMap<String, DelegateConfigure> concurrentHashMap;

    public DelegateManagerCache() {
        this.concurrentHashMap = null;
        this.concurrentHashMap = new ConcurrentHashMap<>();
    }

    public static DelegateManagerCache getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119054937")) {
            return (DelegateManagerCache) ipChange.ipc$dispatch("119054937", new Object[0]);
        }
        if (instance == null) {
            synchronized (DelegateManagerCache.class) {
                if (instance == null) {
                    instance = new DelegateManagerCache();
                }
            }
        }
        return instance;
    }

    public String getCommonDelegatePath(String str, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1863370121")) {
            return (String) ipChange.ipc$dispatch("-1863370121", new Object[]{this, str, context});
        }
        return "android.resource://" + context.getPackageName() + "/raw/" + str + "_delegate_config";
    }

    public synchronized DelegateConfigure initDelegates(String str, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-64937925")) {
            return (DelegateConfigure) ipChange.ipc$dispatch("-64937925", new Object[]{this, str, context});
        }
        if (!this.concurrentHashMap.contains(str)) {
            this.concurrentHashMap.put(str, new DelegateManager(str, context).getDelegateConfigure());
        }
        return this.concurrentHashMap.get(str);
    }

    public synchronized DelegateConfigure initDelegates(String str, Context context, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "833415564")) {
            return (DelegateConfigure) ipChange.ipc$dispatch("833415564", new Object[]{this, str, context, uri});
        }
        if (!this.concurrentHashMap.contains(str)) {
            this.concurrentHashMap.put(str, new DelegateManager(str, context).getDelegateConfigure(uri));
        }
        return this.concurrentHashMap.get(str);
    }
}
