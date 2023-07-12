package com.youku.live.widgets.connector;

import android.content.Context;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.youku.live.widgets.ActivityLifecycleState;
import com.youku.live.widgets.WidgetInstance;
import com.youku.live.widgets.model.template.WidgetModel;
import com.youku.live.widgets.monitor.IPerfMonitor;
import com.youku.live.widgets.protocol.IDataBridgeHandler;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IEngineInstanceVisibleListener;
import com.youku.live.widgets.protocol.IEventHandler;
import com.youku.live.widgets.protocol.IPlugin;
import com.youku.live.widgets.protocol.IProps;
import com.youku.live.widgets.protocol.IResult;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.protocol.Orientation;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class EngineInstanceConnector implements IEngineInstance {
    private static transient /* synthetic */ IpChange $ipChange;
    private WidgetInstance mInstance;

    public EngineInstanceConnector(WidgetInstance widgetInstance) {
        this.mInstance = widgetInstance;
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void addDataHandler(String str, IDataHandler iDataHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1566110187")) {
            ipChange.ipc$dispatch("-1566110187", new Object[]{this, str, iDataHandler});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.addDataHandler(str, iDataHandler);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void addDataHandlers(String[] strArr, IDataHandler iDataHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-712562221")) {
            ipChange.ipc$dispatch("-712562221", new Object[]{this, strArr, iDataHandler});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.addDataHandlers(strArr, iDataHandler);
        }
    }

    @Override // com.youku.live.widgets.protocol.IEventDispatcher
    public boolean addEventHandler(String str, IEventHandler iEventHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2007502549")) {
            return ((Boolean) ipChange.ipc$dispatch("-2007502549", new Object[]{this, str, iEventHandler})).booleanValue();
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.addEventHandler(str, iEventHandler);
        }
        return false;
    }

    @Override // com.youku.live.widgets.protocol.ILayerMananger
    public String addLayer(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-347663764")) {
            return (String) ipChange.ipc$dispatch("-347663764", new Object[]{this, str});
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.addLayer(str);
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public void addVisibleListener(IEngineInstanceVisibleListener iEngineInstanceVisibleListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "794199190")) {
            ipChange.ipc$dispatch("794199190", new Object[]{this, iEngineInstanceVisibleListener});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.addVisibleListener(iEngineInstanceVisibleListener);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void asyncPutData(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "99322979")) {
            ipChange.ipc$dispatch("99322979", new Object[]{this, str, obj});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.asyncPutData(str, obj);
        }
    }

    public void attach(WidgetInstance widgetInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "648808004")) {
            ipChange.ipc$dispatch("648808004", new Object[]{this, widgetInstance});
        } else {
            this.mInstance = widgetInstance;
        }
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-593107197")) {
            ipChange.ipc$dispatch("-593107197", new Object[]{this});
        } else {
            this.mInstance = null;
        }
    }

    @Override // com.youku.live.widgets.protocol.ILayerMananger
    public String closeDialog(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-418555066")) {
            return (String) ipChange.ipc$dispatch("-418555066", new Object[]{this, str});
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.closeDialog(str);
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public void delayRunOnMainThread(Runnable runnable, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-926255115")) {
            ipChange.ipc$dispatch("-926255115", new Object[]{this, runnable, Integer.valueOf(i)});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.delayRunOnMainThread(runnable, i);
        }
    }

    @Override // com.youku.live.widgets.protocol.IEventDispatcher
    public void deleteEventHandler(String str, IEventHandler iEventHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2053884985")) {
            ipChange.ipc$dispatch("-2053884985", new Object[]{this, str, iEventHandler});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.deleteEventHandler(str, iEventHandler);
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IActiveStateChangedListener
    public void didActive() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1828684693")) {
            ipChange.ipc$dispatch("-1828684693", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-35557508")) {
            ipChange.ipc$dispatch("-35557508", new Object[]{this});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.didAppear();
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IActiveStateChangedListener
    public void didDeactive() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1390054902")) {
            ipChange.ipc$dispatch("-1390054902", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "90863030")) {
            ipChange.ipc$dispatch("90863030", new Object[]{this});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.didDisappear();
        }
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public void enableCSSLayoutNotifyConfigChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "173306201")) {
            ipChange.ipc$dispatch("173306201", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.enableCSSLayoutNotifyConfigChanged(z);
        }
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public IPlugin findPluginByName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1016376013")) {
            return (IPlugin) ipChange.ipc$dispatch("-1016376013", new Object[]{this, str});
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.findPluginByName(str);
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public IWidget findWidgetById(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "953905985")) {
            return (IWidget) ipChange.ipc$dispatch("953905985", new Object[]{this, str});
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.findWidgetById(str);
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public List<IWidget> findWidgetsByName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1084361947")) {
            return (List) ipChange.ipc$dispatch("-1084361947", new Object[]{this, str});
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.findWidgetsByName(str);
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityStateReader
    public ActivityLifecycleState getActivityLifecycleState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "227164336")) {
            return (ActivityLifecycleState) ipChange.ipc$dispatch("227164336", new Object[]{this});
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.getActivityLifecycleState();
            return null;
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityStateReader
    public int getActivityOrientation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-728221726")) {
            return ((Integer) ipChange.ipc$dispatch("-728221726", new Object[]{this})).intValue();
        }
        return 1;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public Context getContext() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "52501305")) {
            return (Context) ipChange.ipc$dispatch("52501305", new Object[]{this});
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.getContext();
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public Object getData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1215114472")) {
            return ipChange.ipc$dispatch("-1215114472", new Object[]{this, str});
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.getData(str);
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public Map<String, Object> getEnvironments() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "509521007")) {
            return (Map) ipChange.ipc$dispatch("509521007", new Object[]{this});
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.getEnvironments();
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public String getInstTag() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1371879620")) {
            return (String) ipChange.ipc$dispatch("1371879620", new Object[]{this});
        }
        WidgetInstance widgetInstance = this.mInstance;
        return widgetInstance != null ? widgetInstance.toString() : toString();
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public IProps getOptions() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2070623004")) {
            return (IProps) ipChange.ipc$dispatch("-2070623004", new Object[]{this});
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.getOptions();
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public Orientation getOrientation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-296341207")) {
            return (Orientation) ipChange.ipc$dispatch("-296341207", new Object[]{this});
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.getOrientation();
        }
        return Orientation.ORIENTATION_PORTAIT;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public IPerfMonitor getPerfMonitor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "676767524")) {
            return (IPerfMonitor) ipChange.ipc$dispatch("676767524", new Object[]{this});
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.getPerfMonitor();
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.ILayerMananger
    public ViewGroup getRootView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1430388286")) {
            return (ViewGroup) ipChange.ipc$dispatch("-1430388286", new Object[]{this});
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.getRootView();
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public int getStandardWidth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1519554906")) {
            return ((Integer) ipChange.ipc$dispatch("1519554906", new Object[]{this})).intValue();
        }
        WidgetInstance widgetInstance = this.mInstance;
        return widgetInstance != null ? widgetInstance.getStandardWidth() : FeatureFactory.PRIORITY_ABOVE_NORMAL;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public IProps getTheme() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1210006641")) {
            return (IProps) ipChange.ipc$dispatch("-1210006641", new Object[]{this});
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.getTheme();
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IPageableController
    public boolean isPageable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "468352715")) {
            return ((Boolean) ipChange.ipc$dispatch("468352715", new Object[]{this})).booleanValue();
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.isPageable();
        }
        return false;
    }

    @Override // com.youku.live.widgets.protocol.IPageableController
    public boolean lockPageable(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-246381772")) {
            return ((Boolean) ipChange.ipc$dispatch("-246381772", new Object[]{this, str})).booleanValue();
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.lockPageable(str);
        }
        return false;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public Object pollRecycleView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "532403665")) {
            return ipChange.ipc$dispatch("532403665", new Object[]{this, str});
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.pollRecycleView(str);
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IEventDispatcher
    public void postEvent(int i, String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "159365934")) {
            ipChange.ipc$dispatch("159365934", new Object[]{this, Integer.valueOf(i), str, map});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.postEvent(i, str, map);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void putData(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "652202845")) {
            ipChange.ipc$dispatch("652202845", new Object[]{this, str, obj});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.putData(str, obj);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void putDataOnly(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1910021871")) {
            ipChange.ipc$dispatch("-1910021871", new Object[]{this, str, obj});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.putDataOnly(str, obj);
        }
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public boolean recycleView(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "931386498")) {
            return ((Boolean) ipChange.ipc$dispatch("931386498", new Object[]{this, str, obj})).booleanValue();
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.recycleView(str, obj);
        }
        return false;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public void removeAllFromMainThread() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1275897638")) {
            ipChange.ipc$dispatch("1275897638", new Object[]{this});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.removeAllFromMainThread();
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void removeData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "498247958")) {
            ipChange.ipc$dispatch("498247958", new Object[]{this, str});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.removeData(str);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void removeDataHandler(String str, IDataHandler iDataHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "950023118")) {
            ipChange.ipc$dispatch("950023118", new Object[]{this, str, iDataHandler});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.removeDataHandler(str, iDataHandler);
        }
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public void removeFromMainThread(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-882641561")) {
            ipChange.ipc$dispatch("-882641561", new Object[]{this, runnable});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.removeFromMainThread(runnable);
        }
    }

    @Override // com.youku.live.widgets.protocol.ILayerMananger
    public boolean removeLayer(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1627815695")) {
            return ((Boolean) ipChange.ipc$dispatch("-1627815695", new Object[]{this, str})).booleanValue();
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.removeLayer(str);
        }
        return false;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public void removeVisibleListener(IEngineInstanceVisibleListener iEngineInstanceVisibleListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "878978511")) {
            ipChange.ipc$dispatch("878978511", new Object[]{this, iEngineInstanceVisibleListener});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.removeVisibleListener(iEngineInstanceVisibleListener);
        }
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public void runOnMainThread(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "647969793")) {
            ipChange.ipc$dispatch("647969793", new Object[]{this, runnable});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.runOnMainThread(runnable);
        }
    }

    @Override // com.youku.live.widgets.protocol.ILayerMananger
    public String showDialog(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2123875999")) {
            return (String) ipChange.ipc$dispatch("-2123875999", new Object[]{this, str});
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.showDialog(str);
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IPageableController
    public boolean unlockPageable(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1758733947")) {
            return ((Boolean) ipChange.ipc$dispatch("1758733947", new Object[]{this, str})).booleanValue();
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.unlockPageable(str);
        }
        return false;
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IActiveStateChangedListener
    public void willActive() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906348830")) {
            ipChange.ipc$dispatch("-906348830", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void willAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "886778355")) {
            ipChange.ipc$dispatch("886778355", new Object[]{this});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.willAppear();
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IActiveStateChangedListener
    public void willDeactive() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "211446465")) {
            ipChange.ipc$dispatch("211446465", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void willDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1802202145")) {
            ipChange.ipc$dispatch("-1802202145", new Object[]{this});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.willDisappear();
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void addDataHandler(String str, IDataBridgeHandler iDataBridgeHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1716828478")) {
            ipChange.ipc$dispatch("1716828478", new Object[]{this, str, iDataBridgeHandler});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.addDataHandler(str, iDataBridgeHandler);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void addDataHandlers(List<String> list, IDataHandler iDataHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1158868765")) {
            ipChange.ipc$dispatch("1158868765", new Object[]{this, list, iDataHandler});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.addDataHandlers(list, iDataHandler);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void asyncPutData(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1825065343")) {
            ipChange.ipc$dispatch("1825065343", new Object[]{this, str, obj, obj2});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.asyncPutData(str, obj, obj2);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void getData(String str, IResult iResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1370641097")) {
            ipChange.ipc$dispatch("1370641097", new Object[]{this, str, iResult});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.getData(str, iResult);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void putData(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "668632569")) {
            ipChange.ipc$dispatch("668632569", new Object[]{this, str, obj, obj2});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.putData(str, obj, obj2);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void putDataOnly(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1594199725")) {
            ipChange.ipc$dispatch("1594199725", new Object[]{this, str, obj, obj2});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.putDataOnly(str, obj, obj2);
        }
    }

    @Override // com.youku.live.widgets.protocol.ILayerMananger
    public String showDialog(WidgetModel widgetModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-887234535")) {
            return (String) ipChange.ipc$dispatch("-887234535", new Object[]{this, widgetModel});
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            return widgetInstance.showDialog(widgetModel);
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void addDataHandlers(String[] strArr, IDataBridgeHandler iDataBridgeHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2085916284")) {
            ipChange.ipc$dispatch("2085916284", new Object[]{this, strArr, iDataBridgeHandler});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.addDataHandlers(strArr, iDataBridgeHandler);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void addDataHandlers(List<String> list, IDataBridgeHandler iDataBridgeHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1304802374")) {
            ipChange.ipc$dispatch("1304802374", new Object[]{this, list, iDataBridgeHandler});
            return;
        }
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.addDataHandlers(list, iDataBridgeHandler);
        }
    }
}
