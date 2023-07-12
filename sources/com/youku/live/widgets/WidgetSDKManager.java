package com.youku.live.widgets;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.impl.EmptyBaseWidget;
import com.youku.live.widgets.protocol.IPlugin;
import com.youku.live.widgets.protocol.IWidget;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class WidgetSDKManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private static WidgetSDKManager gInstance;
    private Map<String, Class> sTypeWidgetMap = new ConcurrentHashMap();
    private Map<String, Class> sTypePluginMap = new ConcurrentHashMap();
    private Map<String, List<IWidget>> sWidgetPool = new ConcurrentHashMap();
    private Map<String, List<IPlugin>> sPluginPool = new ConcurrentHashMap();

    private WidgetSDKManager() {
    }

    public static WidgetSDKManager getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-945442585")) {
            return (WidgetSDKManager) ipChange.ipc$dispatch("-945442585", new Object[0]);
        }
        if (gInstance == null) {
            synchronized (WidgetSDKManager.class) {
                if (gInstance == null) {
                    gInstance = new WidgetSDKManager();
                }
            }
        }
        return gInstance;
    }

    public IPlugin createPlugin(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1958058117")) {
            return (IPlugin) ipChange.ipc$dispatch("-1958058117", new Object[]{this, str});
        }
        List<IPlugin> list = this.sPluginPool.get(str);
        if (list != null && list.size() > 0) {
            return list.remove(0);
        }
        return createPluginNoCache(str);
    }

    public IPlugin createPluginNoCache(String str) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1472410652")) {
            return (IPlugin) ipChange.ipc$dispatch("1472410652", new Object[]{this, str});
        }
        try {
            obj = this.sTypePluginMap.get(str).newInstance();
        } catch (Exception unused) {
            obj = null;
        }
        if (obj != null) {
            return (IPlugin) obj;
        }
        return null;
    }

    public IWidget createWidget(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1019559193")) {
            return (IWidget) ipChange.ipc$dispatch("1019559193", new Object[]{this, str});
        }
        List<IWidget> list = this.sWidgetPool.get(str);
        if (list != null && list.size() > 0) {
            return list.remove(0);
        }
        return createWidgetNoCache(str);
    }

    public IWidget createWidgetNoCache(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1164287420")) {
            return (IWidget) ipChange.ipc$dispatch("1164287420", new Object[]{this, str});
        }
        Object obj = null;
        try {
            obj = this.sTypeWidgetMap.get(str).newInstance();
        } catch (Exception unused) {
        }
        if (obj != null) {
            return (IWidget) obj;
        }
        return new EmptyBaseWidget();
    }

    public void registerPlugin(String str, Class<? extends IPlugin> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-787423066")) {
            ipChange.ipc$dispatch("-787423066", new Object[]{this, str, cls});
            return;
        }
        this.sTypePluginMap.put(str, cls);
        this.sPluginPool.put(str, new ArrayList());
    }

    public void registerWidget(String str, Class<? extends IWidget> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1368979191")) {
            ipChange.ipc$dispatch("1368979191", new Object[]{this, str, cls});
            return;
        }
        this.sTypeWidgetMap.put(str, cls);
        this.sWidgetPool.put(str, new ArrayList());
    }

    public void releasePlugin(String str, IPlugin iPlugin) {
        List<IPlugin> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "516668662")) {
            ipChange.ipc$dispatch("516668662", new Object[]{this, str, iPlugin});
        } else if (str == null || iPlugin == null || (list = this.sPluginPool.get(str)) == null || list.size() >= 10) {
        } else {
            list.add(iPlugin);
        }
    }

    public void releaseWidget(String str, IWidget iWidget) {
        List<IWidget> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-738844778")) {
            ipChange.ipc$dispatch("-738844778", new Object[]{this, str, iWidget});
        } else if (str == null || iWidget == null || (list = this.sWidgetPool.get(str)) == null || list.size() >= 10) {
        } else {
            list.add(iWidget);
        }
    }
}
