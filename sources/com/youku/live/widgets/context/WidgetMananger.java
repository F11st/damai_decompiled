package com.youku.live.widgets.context;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.impl.BaseWidget;
import com.youku.live.widgets.protocol.IDestroyable;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.protocol.IWidgetMananger;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class WidgetMananger implements IDestroyable, IWidgetMananger {
    private static transient /* synthetic */ IpChange $ipChange;
    private Map<String, Queue<IWidget>> cache;
    private volatile boolean destroyed = false;

    private Map<String, Queue<IWidget>> getCache() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1144356218")) {
            return (Map) ipChange.ipc$dispatch("-1144356218", new Object[]{this});
        }
        if (this.cache == null) {
            synchronized (this) {
                if (this.cache == null) {
                    this.cache = new ConcurrentHashMap();
                }
            }
        }
        return this.cache;
    }

    private Queue<IWidget> getElements(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1418202730")) {
            return (Queue) ipChange.ipc$dispatch("1418202730", new Object[]{this, str});
        }
        Map<String, Queue<IWidget>> cache = getCache();
        Queue<IWidget> queue = cache.get(str);
        if (queue == null) {
            synchronized (this) {
                if (cache.get(str) == null) {
                    cache.put(str, new ConcurrentLinkedQueue());
                }
            }
            return cache.get(str);
        }
        return queue;
    }

    @Override // com.youku.live.widgets.protocol.IWidgetMananger
    public IWidget createWidget(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1376361965")) {
            return (IWidget) ipChange.ipc$dispatch("-1376361965", new Object[]{this, str});
        }
        if (this.destroyed || TextUtils.isEmpty(str)) {
            return null;
        }
        return getElements(str).poll();
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1657035693")) {
            ipChange.ipc$dispatch("-1657035693", new Object[]{this});
            return;
        }
        this.destroyed = true;
        Map<String, Queue<IWidget>> cache = getCache();
        if (cache != null) {
            for (Map.Entry<String, Queue<IWidget>> entry : cache.entrySet()) {
                Queue<IWidget> value = entry.getValue();
                if (value != null) {
                    for (IWidget iWidget : value) {
                        if (iWidget instanceof BaseWidget) {
                            BaseWidget baseWidget = (BaseWidget) iWidget;
                            baseWidget.mRecycled = false;
                            baseWidget.destroyImp();
                        } else if (iWidget != null) {
                            iWidget.destroy();
                        }
                    }
                    value.clear();
                }
            }
            cache.clear();
        }
    }

    @Override // com.youku.live.widgets.protocol.IWidgetMananger
    public boolean releaseInstance(IWidget iWidget) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-354194129")) {
            return ((Boolean) ipChange.ipc$dispatch("-354194129", new Object[]{this, iWidget})).booleanValue();
        }
        if (!this.destroyed && (iWidget instanceof BaseWidget)) {
            String str = ((BaseWidget) iWidget).name;
            if (str != null) {
                getElements(str).add(iWidget);
            } else {
                iWidget.destroy();
            }
            return true;
        }
        return false;
    }
}
