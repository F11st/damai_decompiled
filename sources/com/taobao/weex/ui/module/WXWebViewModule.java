package com.taobao.weex.ui.module;

import com.taobao.weex.WXSDKManager;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXWeb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXWebViewModule extends WXModule {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum Action {
        reload,
        goBack,
        goForward,
        postMessage
    }

    private void action(Action action, String str, Object obj) {
        WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(this.mWXSDKInstance.getInstanceId(), str);
        if (wXComponent instanceof WXWeb) {
            ((WXWeb) wXComponent).setAction(action.name(), obj);
        }
    }

    @JSMethod(uiThread = true)
    public void goBack(String str) {
        action(Action.goBack, str);
    }

    @JSMethod(uiThread = true)
    public void goForward(String str) {
        action(Action.goForward, str);
    }

    @JSMethod(uiThread = true)
    public void postMessage(String str, Object obj) {
        action(Action.postMessage, str, obj);
    }

    @JSMethod(uiThread = true)
    public void reload(String str) {
        action(Action.reload, str);
    }

    private void action(Action action, String str) {
        action(action, str, null);
    }
}
