package com.youku.live.widgets.impl;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.ActivityLifecycleState;
import com.youku.live.widgets.WidgetInstance;
import com.youku.live.widgets.constants.AppearState;
import com.youku.live.widgets.dom.CSSLayout;
import com.youku.live.widgets.monitor.IPerfMonitor;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IProps;
import com.youku.live.widgets.protocol.IStyles;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.protocol.IWidgetData;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class BaseWidget implements IWidget {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public boolean isDynamic;
    private List<IWidget> mChildren;
    public IEngineInstance mEngineInstance;
    public View mHostView;
    public boolean mIsAppearLevel;
    private CSSLayout.LayoutParams mLandscapeLayoutParams;
    private IWidget mParent;
    private CSSLayout.LayoutParams mPortraitLayoutParams;
    private IWidgetData mWidgetData;
    private IProps mWidgetProps;
    private IStyles mWidgetStyles;
    public String name;
    public boolean mRecycled = false;
    public Throwable mInitHostViewThrowable = null;
    public boolean mIsInitHostView = false;
    public AppearState mAppearState = AppearState.DID_DISAPPEAR;

    @Override // com.youku.live.widgets.protocol.IWidget
    public boolean addChild(IWidget iWidget) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1892141201") ? ((Boolean) ipChange.ipc$dispatch("1892141201", new Object[]{this, iWidget})).booleanValue() : getChildren().add(iWidget);
    }

    @Override // com.youku.live.widgets.protocol.IWidget
    public boolean closeSelf() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1061805792")) {
            return ((Boolean) ipChange.ipc$dispatch("-1061805792", new Object[]{this})).booleanValue();
        }
        IWidget parent = getParent();
        if (parent != null) {
            return parent.deleteChild(this);
        }
        return false;
    }

    @Override // com.youku.live.widgets.protocol.IWidget
    public boolean deleteChild(IWidget iWidget) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-420516911")) {
            return ((Boolean) ipChange.ipc$dispatch("-420516911", new Object[]{this, iWidget})).booleanValue();
        }
        View hostView = getHostView();
        if (hostView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) hostView;
            View hostView2 = iWidget.getHostView();
            if (hostView2 != null) {
                viewGroup.removeView(hostView2);
            }
        }
        return getChildren().remove(iWidget);
    }

    @Override // com.youku.live.widgets.protocol.IWidget, com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "644857222")) {
            ipChange.ipc$dispatch("644857222", new Object[]{this});
            return;
        }
        Log.e("BaseWidget", "destroy:" + this);
    }

    public void destroyImp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "561161368")) {
            ipChange.ipc$dispatch("561161368", new Object[]{this});
            return;
        }
        willUnmount();
        List<IWidget> list = this.mChildren;
        this.mChildren = null;
        if (list != null) {
            list.clear();
        }
        willDetachView();
        View view = this.mHostView;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
        didDetachView();
        didUnmount();
        if (!this.mRecycled && this.name != null) {
            Log.e(WidgetInstance.TAG_RENDER_IMP, "{roomid:}.destroy." + this.name + "::" + this);
            destroy();
        }
        this.mParent = null;
        this.mWidgetData = null;
        this.mWidgetStyles = null;
        this.mWidgetProps = null;
        boolean z = this.mRecycled;
        if (!z) {
            this.mHostView = null;
        }
        this.mPortraitLayoutParams = null;
        this.mLandscapeLayoutParams = null;
        this.id = null;
        if (z) {
            return;
        }
        this.name = null;
    }

    public void didAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "157301132")) {
            ipChange.ipc$dispatch("157301132", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IWidgetViewAttachStateChangedListener
    public void didAttachView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "786443895")) {
            ipChange.ipc$dispatch("786443895", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IWidgetViewAttachStateChangedListener
    public void didDetachView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2030005911")) {
            ipChange.ipc$dispatch("-2030005911", new Object[]{this});
        }
    }

    public void didDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1123634778")) {
            ipChange.ipc$dispatch("-1123634778", new Object[]{this});
        }
    }

    public void didMount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1617904496")) {
            ipChange.ipc$dispatch("1617904496", new Object[]{this});
        }
    }

    public void didUnmount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "188795913")) {
            ipChange.ipc$dispatch("188795913", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.IWidgetLifecycle
    public void didViewAttach() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "42951607")) {
            ipChange.ipc$dispatch("42951607", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityStateReader
    public ActivityLifecycleState getActivityLifecycleState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1742458560") ? (ActivityLifecycleState) ipChange.ipc$dispatch("1742458560", new Object[]{this}) : getEngineInstance().getActivityLifecycleState();
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityStateReader
    public int getActivityOrientation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "80627666")) {
            return ((Integer) ipChange.ipc$dispatch("80627666", new Object[]{this})).intValue();
        }
        return 1;
    }

    @Override // com.youku.live.widgets.protocol2.IAppearState
    public AppearState getAppearState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2137667788") ? (AppearState) ipChange.ipc$dispatch("-2137667788", new Object[]{this}) : this.mAppearState;
    }

    @Override // com.youku.live.widgets.protocol.IWidget
    public List<IWidget> getChildren() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "93296700")) {
            return (List) ipChange.ipc$dispatch("93296700", new Object[]{this});
        }
        if (this.mChildren == null) {
            synchronized (this) {
                if (this.mChildren == null) {
                    this.mChildren = new LinkedList();
                }
            }
        }
        return this.mChildren;
    }

    @Override // com.youku.live.widgets.protocol.IWidget
    public IEngineInstance getEngineInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1199897900") ? (IEngineInstance) ipChange.ipc$dispatch("1199897900", new Object[]{this}) : this.mEngineInstance;
    }

    @Override // com.youku.live.widgets.protocol.IWidget
    public View getHostView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1995485057") ? (View) ipChange.ipc$dispatch("-1995485057", new Object[]{this}) : this.mHostView;
    }

    public CSSLayout.LayoutParams getLandscapeLayoutParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-229916157") ? (CSSLayout.LayoutParams) ipChange.ipc$dispatch("-229916157", new Object[]{this}) : this.mLandscapeLayoutParams;
    }

    public ViewGroup.LayoutParams getLayoutParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1938936263")) {
            return (ViewGroup.LayoutParams) ipChange.ipc$dispatch("1938936263", new Object[]{this});
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IWidget
    public IProps getOptions() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-435927308")) {
            return (IProps) ipChange.ipc$dispatch("-435927308", new Object[]{this});
        }
        IWidgetData iWidgetData = this.mWidgetData;
        if (iWidgetData != null) {
            return iWidgetData.getOptions();
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IWidget
    public IWidget getParent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-649305876") ? (IWidget) ipChange.ipc$dispatch("-649305876", new Object[]{this}) : this.mParent;
    }

    public CSSLayout.LayoutParams getPortraitLayoutParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "71170093") ? (CSSLayout.LayoutParams) ipChange.ipc$dispatch("71170093", new Object[]{this}) : this.mPortraitLayoutParams;
    }

    @Override // com.youku.live.widgets.protocol.IWidget
    public IProps getProps() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-848604026") ? (IProps) ipChange.ipc$dispatch("-848604026", new Object[]{this}) : this.mWidgetProps;
    }

    @Override // com.youku.live.widgets.protocol.IWidget
    public View getRealView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1484378807") ? (View) ipChange.ipc$dispatch("-1484378807", new Object[]{this}) : this.mHostView;
    }

    @Override // com.youku.live.widgets.protocol.IWidget
    public IProps getTheme() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2012773985")) {
            return (IProps) ipChange.ipc$dispatch("-2012773985", new Object[]{this});
        }
        IEngineInstance iEngineInstance = this.mEngineInstance;
        if (iEngineInstance != null) {
            return iEngineInstance.getTheme();
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IWidget
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2046721672")) {
            ipChange.ipc$dispatch("2046721672", new Object[]{this});
            return;
        }
        View view = this.mHostView;
        if (view != null) {
            view.setVisibility(8);
        }
        List<IWidget> children = getChildren();
        if (children != null) {
            for (IWidget iWidget : children) {
                if (iWidget != null) {
                    iWidget.hide();
                }
            }
        }
    }

    public View initHostView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1577912477")) {
            return (View) ipChange.ipc$dispatch("1577912477", new Object[]{this, context});
        }
        return null;
    }

    public void initWithData(IEngineInstance iEngineInstance, IWidget iWidget, IWidgetData iWidgetData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1337748981")) {
            ipChange.ipc$dispatch("1337748981", new Object[]{this, iEngineInstance, iWidget, iWidgetData});
            return;
        }
        this.mParent = iWidget;
        this.mWidgetData = iWidgetData;
        if (iWidgetData != null) {
            this.mWidgetProps = iWidgetData.getProps();
        }
    }

    @Override // com.youku.live.widgets.protocol.IElementAppearLevel
    public boolean isAppearLevel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1394389505") ? ((Boolean) ipChange.ipc$dispatch("-1394389505", new Object[]{this})).booleanValue() : this.mIsAppearLevel;
    }

    public void perfMonitorPoint(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1245999905")) {
            ipChange.ipc$dispatch("-1245999905", new Object[]{this, str, str2});
            return;
        }
        IEngineInstance engineInstance = getEngineInstance();
        IPerfMonitor perfMonitor = engineInstance != null ? engineInstance.getPerfMonitor() : null;
        if (perfMonitor != null) {
            perfMonitor.point(str, str2);
        }
    }

    public void perfMonitorPointError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-216136181")) {
            ipChange.ipc$dispatch("-216136181", new Object[]{this, str, str2});
            return;
        }
        IEngineInstance engineInstance = getEngineInstance();
        IPerfMonitor perfMonitor = engineInstance != null ? engineInstance.getPerfMonitor() : null;
        if (perfMonitor != null) {
            perfMonitor.pointError(str, str2);
        }
    }

    public void perfMonitorPointWarn(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1026595961")) {
            ipChange.ipc$dispatch("1026595961", new Object[]{this, str, str2});
            return;
        }
        IEngineInstance engineInstance = getEngineInstance();
        IPerfMonitor perfMonitor = engineInstance != null ? engineInstance.getPerfMonitor() : null;
        if (perfMonitor != null) {
            perfMonitor.pointWarn(str, str2);
        }
    }

    @Override // com.youku.live.widgets.protocol2.IAppearState
    public void setAppearState(AppearState appearState) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1425493746")) {
            ipChange.ipc$dispatch("1425493746", new Object[]{this, appearState});
        } else {
            this.mAppearState = appearState;
        }
    }

    public void setCSSLayoutParams(CSSLayout.LayoutParams layoutParams, CSSLayout.LayoutParams layoutParams2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1042903801")) {
            ipChange.ipc$dispatch("1042903801", new Object[]{this, layoutParams, layoutParams2});
            return;
        }
        this.mPortraitLayoutParams = layoutParams;
        this.mLandscapeLayoutParams = layoutParams2;
    }

    @Override // com.youku.live.widgets.protocol.IWidget
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1093573907")) {
            ipChange.ipc$dispatch("-1093573907", new Object[]{this});
            return;
        }
        View view = this.mHostView;
        if (view != null) {
            view.setVisibility(0);
        }
        List<IWidget> children = getChildren();
        if (children != null) {
            for (IWidget iWidget : children) {
                if (iWidget != null) {
                    iWidget.show();
                }
            }
        }
    }

    public void willAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1724538397")) {
            ipChange.ipc$dispatch("-1724538397", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IWidgetViewAttachStateChangedListener
    public void willAttachView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1970564274")) {
            ipChange.ipc$dispatch("-1970564274", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IWidgetViewAttachStateChangedListener
    public void willDetachView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-492046784")) {
            ipChange.ipc$dispatch("-492046784", new Object[]{this});
        }
    }

    public void willDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-796928529")) {
            ipChange.ipc$dispatch("-796928529", new Object[]{this});
        }
    }

    public void willMount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-659557319")) {
            ipChange.ipc$dispatch("-659557319", new Object[]{this});
        }
    }

    public void willUnmount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1981312658")) {
            ipChange.ipc$dispatch("1981312658", new Object[]{this});
        }
    }
}
