package com.youku.live.widgets.context;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.impl.BasePlugin;
import com.youku.live.widgets.protocol.IDestroyable;
import com.youku.live.widgets.protocol.IPlugin;
import com.youku.live.widgets.protocol.IPluginMananger;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PluginMananger implements IDestroyable, IPluginMananger {
    private static transient /* synthetic */ IpChange $ipChange;
    private Map<String, Queue<IPlugin>> cache;
    private volatile boolean destroyed = false;

    private Map<String, Queue<IPlugin>> getCache() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "104795125")) {
            return (Map) ipChange.ipc$dispatch("104795125", new Object[]{this});
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

    private Queue<IPlugin> getElements(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1581885413")) {
            return (Queue) ipChange.ipc$dispatch("-1581885413", new Object[]{this, str});
        }
        Map<String, Queue<IPlugin>> cache = getCache();
        Queue<IPlugin> queue = cache.get(str);
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

    @Override // com.youku.live.widgets.protocol.IPluginMananger
    public IPlugin createPlugin(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2130959332")) {
            return (IPlugin) ipChange.ipc$dispatch("2130959332", new Object[]{this, str});
        }
        if (this.destroyed || TextUtils.isEmpty(str)) {
            return null;
        }
        return getElements(str).poll();
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-630633788")) {
            ipChange.ipc$dispatch("-630633788", new Object[]{this});
            return;
        }
        this.destroyed = true;
        Map<String, Queue<IPlugin>> cache = getCache();
        if (cache != null) {
            for (Map.Entry<String, Queue<IPlugin>> entry : cache.entrySet()) {
                Queue<IPlugin> value = entry.getValue();
                if (value != null) {
                    for (IPlugin iPlugin : value) {
                        if (iPlugin instanceof BasePlugin) {
                            BasePlugin basePlugin = (BasePlugin) iPlugin;
                            basePlugin.mRecycled = false;
                            basePlugin.destroyImp();
                        }
                    }
                    value.clear();
                }
            }
            cache.clear();
        }
    }

    @Override // com.youku.live.widgets.protocol.IPluginMananger
    public boolean releaseInstance(IPlugin iPlugin) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-600511601")) {
            return ((Boolean) ipChange.ipc$dispatch("-600511601", new Object[]{this, iPlugin})).booleanValue();
        }
        if (!this.destroyed && (iPlugin instanceof BasePlugin)) {
            String str = ((BasePlugin) iPlugin).name;
            if (str != null) {
                getElements(str).add(iPlugin);
            } else {
                iPlugin.destroy();
            }
            return true;
        }
        return false;
    }
}
