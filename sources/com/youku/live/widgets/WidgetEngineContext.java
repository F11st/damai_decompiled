package com.youku.live.widgets;

import android.app.Activity;
import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.context.ConfigMananger;
import com.youku.live.widgets.context.PluginMananger;
import com.youku.live.widgets.context.ViewMananger;
import com.youku.live.widgets.context.WidgetInstanceMananger;
import com.youku.live.widgets.context.WidgetMananger;
import com.youku.live.widgets.protocol.IDestroyable;
import com.youku.live.widgets.protocol.IEngineContext;
import com.youku.live.widgets.protocol.IPageableController;
import com.youku.live.widgets.protocol.IPluginMananger;
import com.youku.live.widgets.protocol.IViewMananger;
import com.youku.live.widgets.protocol.IWidgetInstanceMananger;
import com.youku.live.widgets.protocol.IWidgetMananger;
import com.youku.live.widgets.protocol.activity.IActivityStateReader;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class WidgetEngineContext implements IEngineContext {
    private static transient /* synthetic */ IpChange $ipChange;
    private static IPageableController sDefaultPageableController = new IPageableController() { // from class: com.youku.live.widgets.WidgetEngineContext.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.youku.live.widgets.protocol.IPageableController
        public boolean isPageable() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-801080211")) {
                return ((Boolean) ipChange.ipc$dispatch("-801080211", new Object[]{this})).booleanValue();
            }
            return false;
        }

        @Override // com.youku.live.widgets.protocol.IPageableController
        public boolean lockPageable(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1284594646")) {
                return ((Boolean) ipChange.ipc$dispatch("1284594646", new Object[]{this, str})).booleanValue();
            }
            return false;
        }

        @Override // com.youku.live.widgets.protocol.IPageableController
        public boolean unlockPageable(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-146710883")) {
                return ((Boolean) ipChange.ipc$dispatch("-146710883", new Object[]{this, str})).booleanValue();
            }
            return false;
        }
    };
    private Activity mActivity;
    private IActivityStateReader mActivityStateReader;
    private Context mApplicationConctext;
    private ConfigMananger mConfigMananger;
    private IPageableController mPageableController;
    private IPluginMananger mPluginMananger = new PluginMananger();
    private IWidgetMananger mWidgetMananger = new WidgetMananger();
    private IWidgetInstanceMananger mWidgetInstanceMananger = new WidgetInstanceMananger();
    private IViewMananger mViewMananger = new ViewMananger();

    public WidgetEngineContext bindActivityController(Activity activity, IActivityStateReader iActivityStateReader, IPageableController iPageableController) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1005539076")) {
            return (WidgetEngineContext) ipChange.ipc$dispatch("1005539076", new Object[]{this, activity, iActivityStateReader, iPageableController});
        }
        this.mActivity = activity;
        this.mActivityStateReader = iActivityStateReader;
        this.mPageableController = iPageableController;
        return this;
    }

    public WidgetEngineContext bindActivityStateReader(Activity activity, IActivityStateReader iActivityStateReader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1649646301")) {
            return (WidgetEngineContext) ipChange.ipc$dispatch("-1649646301", new Object[]{this, activity, iActivityStateReader});
        }
        this.mActivity = activity;
        this.mActivityStateReader = iActivityStateReader;
        return this;
    }

    @Override // com.youku.live.widgets.protocol.IWidgetInstanceMananger
    public WidgetInstance createInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2008885465")) {
            return (WidgetInstance) ipChange.ipc$dispatch("-2008885465", new Object[]{this});
        }
        IWidgetInstanceMananger iWidgetInstanceMananger = this.mWidgetInstanceMananger;
        WidgetInstance createInstance = iWidgetInstanceMananger != null ? iWidgetInstanceMananger.createInstance() : null;
        if (createInstance != null) {
            createInstance.setEngineContext(this);
        }
        return createInstance;
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1276519679")) {
            ipChange.ipc$dispatch("-1276519679", new Object[]{this});
            return;
        }
        IPluginMananger iPluginMananger = this.mPluginMananger;
        if (iPluginMananger instanceof IDestroyable) {
            ((IDestroyable) iPluginMananger).destroy();
            this.mPluginMananger = null;
        }
        IWidgetMananger iWidgetMananger = this.mWidgetMananger;
        if (iWidgetMananger instanceof IDestroyable) {
            ((IDestroyable) iWidgetMananger).destroy();
        }
        IWidgetInstanceMananger iWidgetInstanceMananger = this.mWidgetInstanceMananger;
        if (iWidgetInstanceMananger instanceof IDestroyable) {
            ((IDestroyable) iWidgetInstanceMananger).destroy();
        }
        IViewMananger iViewMananger = this.mViewMananger;
        if (iViewMananger instanceof IDestroyable) {
            ((IDestroyable) iViewMananger).destroy();
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityStateReader
    public ActivityLifecycleState getActivityLifecycleState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "820810811") ? (ActivityLifecycleState) ipChange.ipc$dispatch("820810811", new Object[]{this}) : ActivityLifecycleState.CREATED;
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityStateReader
    public int getActivityOrientation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2068587767")) {
            return ((Integer) ipChange.ipc$dispatch("2068587767", new Object[]{this})).intValue();
        }
        IActivityStateReader iActivityStateReader = this.mActivityStateReader;
        if (iActivityStateReader != null) {
            return iActivityStateReader.getActivityOrientation();
        }
        return 1;
    }

    @Override // com.youku.live.widgets.protocol.IEngineContext
    public Context getApplicationContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1596798814") ? (Context) ipChange.ipc$dispatch("1596798814", new Object[]{this}) : this.mApplicationConctext;
    }

    public ConfigMananger getConfigMananger() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1183327209")) {
            return (ConfigMananger) ipChange.ipc$dispatch("1183327209", new Object[]{this});
        }
        if (this.mConfigMananger == null) {
            synchronized (this) {
                if (this.mConfigMananger == null) {
                    this.mConfigMananger = new ConfigMananger();
                }
            }
        }
        return this.mConfigMananger;
    }

    @Override // com.youku.live.widgets.protocol.IEngineContext
    public Activity getCurrentActivity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "653398923") ? (Activity) ipChange.ipc$dispatch("653398923", new Object[]{this}) : this.mActivity;
    }

    @Override // com.youku.live.widgets.protocol.IEngineContext
    public IPageableController getPageableController() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1309224053")) {
            return (IPageableController) ipChange.ipc$dispatch("-1309224053", new Object[]{this});
        }
        IPageableController iPageableController = this.mPageableController;
        return iPageableController == null ? sDefaultPageableController : iPageableController;
    }

    @Override // com.youku.live.widgets.protocol.IEngineContext
    public IPluginMananger getPluginMananger() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1684777771") ? (IPluginMananger) ipChange.ipc$dispatch("-1684777771", new Object[]{this}) : this.mPluginMananger;
    }

    @Override // com.youku.live.widgets.protocol.IEngineContext
    public IWidgetInstanceMananger getWidgetInstanceMananger() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1684651081") ? (IWidgetInstanceMananger) ipChange.ipc$dispatch("1684651081", new Object[]{this}) : this.mWidgetInstanceMananger;
    }

    @Override // com.youku.live.widgets.protocol.IEngineContext
    public IWidgetMananger getWidgetMananger() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1388379341") ? (IWidgetMananger) ipChange.ipc$dispatch("-1388379341", new Object[]{this}) : this.mWidgetMananger;
    }

    public WidgetEngineContext initialize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-92497108")) {
            return (WidgetEngineContext) ipChange.ipc$dispatch("-92497108", new Object[]{this});
        }
        this.mApplicationConctext = this.mActivity.getApplicationContext();
        return this;
    }

    public Object pollRecycleView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-435682970")) {
            return ipChange.ipc$dispatch("-435682970", new Object[]{this, str});
        }
        IViewMananger iViewMananger = this.mViewMananger;
        if (iViewMananger != null) {
            return iViewMananger.pollRecycleView(str);
        }
        return null;
    }

    public boolean recycleView(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-923248371")) {
            return ((Boolean) ipChange.ipc$dispatch("-923248371", new Object[]{this, str, obj})).booleanValue();
        }
        IViewMananger iViewMananger = this.mViewMananger;
        if (iViewMananger != null) {
            return iViewMananger.recycleView(str, obj);
        }
        return false;
    }

    @Override // com.youku.live.widgets.protocol.IWidgetInstanceMananger
    public boolean releaseInstance(WidgetInstance widgetInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2055572606")) {
            return ((Boolean) ipChange.ipc$dispatch("2055572606", new Object[]{this, widgetInstance})).booleanValue();
        }
        if (widgetInstance == null) {
            return false;
        }
        IWidgetInstanceMananger iWidgetInstanceMananger = this.mWidgetInstanceMananger;
        boolean releaseInstance = iWidgetInstanceMananger != null ? iWidgetInstanceMananger.releaseInstance(widgetInstance) : false;
        if (releaseInstance) {
            return releaseInstance;
        }
        widgetInstance.destroy();
        return true;
    }

    public WidgetEngineContext unbindActivityStateReader(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1151894419")) {
            return (WidgetEngineContext) ipChange.ipc$dispatch("-1151894419", new Object[]{this, activity});
        }
        this.mActivity = null;
        this.mActivityStateReader = null;
        this.mPageableController = null;
        return this;
    }
}
