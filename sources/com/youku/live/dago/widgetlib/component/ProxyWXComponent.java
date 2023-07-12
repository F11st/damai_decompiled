package com.youku.live.dago.widgetlib.component;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;
import com.youku.live.widgets.monitor.IPerfMonitor;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.widgets.weex.WeexHelper;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class ProxyWXComponent<T extends View> extends WXComponent<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    IPerfMonitor perfMonitor;

    public ProxyWXComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, str, z, basicComponentData);
        this.perfMonitor = null;
    }

    protected void clearPerfMonitor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-625910726")) {
            ipChange.ipc$dispatch("-625910726", new Object[]{this});
        } else {
            this.perfMonitor = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void createViewImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1640643715")) {
            ipChange.ipc$dispatch("-1640643715", new Object[]{this});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            this.perfMonitor = widgetEngineInstance.getPerfMonitor();
        }
        IPerfMonitor iPerfMonitor = this.perfMonitor;
        if (iPerfMonitor != null) {
            iPerfMonitor.perfPointBegin(getClass().getSimpleName());
        }
        super.createViewImpl();
        IPerfMonitor iPerfMonitor2 = this.perfMonitor;
        if (iPerfMonitor2 != null) {
            iPerfMonitor2.perfPointEnd(getClass().getSimpleName(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void perfMonitorPoint(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1225312179")) {
            ipChange.ipc$dispatch("1225312179", new Object[]{this, str, str2});
            return;
        }
        IPerfMonitor iPerfMonitor = this.perfMonitor;
        if (iPerfMonitor != null) {
            iPerfMonitor.point(str, str2);
        }
    }

    public ProxyWXComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        this.perfMonitor = null;
    }

    public ProxyWXComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.perfMonitor = null;
    }

    public ProxyWXComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, int i, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, i, basicComponentData);
        this.perfMonitor = null;
    }
}
