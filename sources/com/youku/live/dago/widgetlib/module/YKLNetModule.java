package com.youku.live.dago.widgetlib.module;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.youku.live.dago.widgetlib.protocol.YKLNetProtocol;
import com.youku.live.dago.widgetlib.wedome.framework.YKLAdapterFactory;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLNetModule extends WXModule implements Destroyable {
    private static transient /* synthetic */ IpChange $ipChange;
    private JSCallback mCallback;
    private YKLNetProtocol mYklNetProtocol;

    private YKLNetProtocol getAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1230860075") ? (YKLNetProtocol) ipChange.ipc$dispatch("-1230860075", new Object[]{this}) : (YKLNetProtocol) YKLAdapterFactory.getInstance().createInterface(YKLNetModule.class);
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2099030390")) {
            ipChange.ipc$dispatch("-2099030390", new Object[]{this});
            return;
        }
        YKLNetProtocol yKLNetProtocol = this.mYklNetProtocol;
        if (yKLNetProtocol != null) {
            yKLNetProtocol.onDestroy();
        }
    }

    @JSMethod
    public void enableNetEvent(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "369604078")) {
            ipChange.ipc$dispatch("369604078", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (this.mYklNetProtocol == null) {
            this.mYklNetProtocol = getAdapter();
        }
        YKLNetProtocol yKLNetProtocol = this.mYklNetProtocol;
        if (yKLNetProtocol != null) {
            yKLNetProtocol.enableNetEvent(z, this.mWXSDKInstance);
        }
    }

    @JSMethod
    public void netStatus(Map map, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2138122840")) {
            ipChange.ipc$dispatch("2138122840", new Object[]{this, map, jSCallback});
            return;
        }
        this.mCallback = jSCallback;
        if (this.mYklNetProtocol == null) {
            this.mYklNetProtocol = getAdapter();
        }
        YKLNetProtocol yKLNetProtocol = this.mYklNetProtocol;
        if (yKLNetProtocol != null) {
            yKLNetProtocol.netStatus(this.mCallback);
        }
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityCreate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1662585316")) {
            ipChange.ipc$dispatch("-1662585316", new Object[]{this});
            return;
        }
        super.onActivityCreate();
        if (this.mYklNetProtocol == null) {
            this.mYklNetProtocol = getAdapter();
        }
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "91650168")) {
            ipChange.ipc$dispatch("91650168", new Object[]{this});
            return;
        }
        super.onActivityDestroy();
        YKLNetProtocol yKLNetProtocol = this.mYklNetProtocol;
        if (yKLNetProtocol != null) {
            yKLNetProtocol.onDestroy();
        }
    }

    private YKLNetProtocol getAdapter(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1949489697") ? (YKLNetProtocol) ipChange.ipc$dispatch("-1949489697", new Object[]{this, str}) : (YKLNetProtocol) YKLAdapterFactory.getInstance().createInterface(YKLNetModule.class, str, false);
    }
}
