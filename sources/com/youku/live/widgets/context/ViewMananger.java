package com.youku.live.widgets.context;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.protocol.IDestroyable;
import com.youku.live.widgets.protocol.IViewMananger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ViewMananger implements IDestroyable, IViewMananger {
    private static transient /* synthetic */ IpChange $ipChange;
    private Map<String, Queue<Object>> cache;
    private volatile boolean destroyed = false;

    private Map<String, Queue<Object>> getCache() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "351607591")) {
            return (Map) ipChange.ipc$dispatch("351607591", new Object[]{this});
        }
        if (this.cache == null) {
            synchronized (this) {
                if (this.cache == null) {
                    this.cache = new HashMap();
                }
            }
        }
        return this.cache;
    }

    private Queue<Object> getElements(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1242738519")) {
            return (Queue) ipChange.ipc$dispatch("-1242738519", new Object[]{this, str});
        }
        Map<String, Queue<Object>> cache = getCache();
        Queue<Object> queue = cache.get(str);
        if (queue == null) {
            synchronized (this) {
                if (cache.get(str) == null) {
                    cache.put(str, new LinkedList());
                }
            }
            return cache.get(str);
        }
        return queue;
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1626406354")) {
            ipChange.ipc$dispatch("1626406354", new Object[]{this});
            return;
        }
        this.destroyed = true;
        Map<String, Queue<Object>> cache = getCache();
        if (cache != null) {
            for (Map.Entry<String, Queue<Object>> entry : cache.entrySet()) {
                Queue<Object> value = entry.getValue();
                if (value != null) {
                    value.clear();
                }
            }
            cache.clear();
        }
    }

    @Override // com.youku.live.widgets.protocol.IViewMananger
    public Object pollRecycleView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2086558219")) {
            return ipChange.ipc$dispatch("-2086558219", new Object[]{this, str});
        }
        Queue<Object> elements = getElements(str);
        if (elements != null) {
            return elements.poll();
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IViewMananger
    public boolean recycleView(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1216833826")) {
            return ((Boolean) ipChange.ipc$dispatch("-1216833826", new Object[]{this, str, obj})).booleanValue();
        }
        Queue<Object> elements = getElements(str);
        if (elements != null) {
            return elements.add(obj);
        }
        return false;
    }
}
