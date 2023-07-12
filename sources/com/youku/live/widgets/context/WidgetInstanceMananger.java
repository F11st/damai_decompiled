package com.youku.live.widgets.context;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.WidgetInstance;
import com.youku.live.widgets.protocol.IDestroyable;
import com.youku.live.widgets.protocol.IWidgetInstanceMananger;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class WidgetInstanceMananger implements IDestroyable, IWidgetInstanceMananger {
    private static transient /* synthetic */ IpChange $ipChange;
    private Queue<WidgetInstance> mWidgetInstancesInCache;
    private List<WidgetInstance> mWidgetInstancesInUse;

    private Queue<WidgetInstance> getWidgetInstancesInCache() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "292931039")) {
            return (Queue) ipChange.ipc$dispatch("292931039", new Object[]{this});
        }
        if (this.mWidgetInstancesInCache == null) {
            synchronized (this) {
                if (this.mWidgetInstancesInCache == null) {
                    this.mWidgetInstancesInCache = new ConcurrentLinkedQueue();
                }
            }
        }
        return this.mWidgetInstancesInCache;
    }

    private List<WidgetInstance> getWidgetInstancesInUse() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1355813907")) {
            return (List) ipChange.ipc$dispatch("-1355813907", new Object[]{this});
        }
        if (this.mWidgetInstancesInUse == null) {
            synchronized (this) {
                if (this.mWidgetInstancesInUse == null) {
                    this.mWidgetInstancesInUse = new CopyOnWriteArrayList();
                }
            }
        }
        return this.mWidgetInstancesInUse;
    }

    @Override // com.youku.live.widgets.protocol.IWidgetInstanceMananger
    public WidgetInstance createInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1150143370")) {
            return (WidgetInstance) ipChange.ipc$dispatch("1150143370", new Object[]{this});
        }
        WidgetInstance poll = getWidgetInstancesInCache().poll();
        if (poll == null) {
            poll = new WidgetInstance();
        }
        getWidgetInstancesInUse().add(poll);
        return poll;
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1622980030")) {
            ipChange.ipc$dispatch("1622980030", new Object[]{this});
            return;
        }
        Iterator<WidgetInstance> it = getWidgetInstancesInUse().iterator();
        if (it != null) {
            while (it.hasNext()) {
                WidgetInstance next = it.next();
                if (next != null) {
                    next.destroy();
                }
            }
        }
        getWidgetInstancesInUse().clear();
        getWidgetInstancesInCache().clear();
    }

    @Override // com.youku.live.widgets.protocol.IWidgetInstanceMananger
    public boolean releaseInstance(WidgetInstance widgetInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1340404769")) {
            return ((Boolean) ipChange.ipc$dispatch("1340404769", new Object[]{this, widgetInstance})).booleanValue();
        }
        if (widgetInstance != null && getWidgetInstancesInUse().remove(widgetInstance)) {
            widgetInstance.destroy();
            getWidgetInstancesInCache().add(widgetInstance);
            return true;
        }
        return false;
    }
}
