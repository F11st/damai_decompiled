package com.youku.live.widgets.weex.module;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class WidgetLayerManangerModule extends WXModule {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    @com.taobao.weex.annotation.JSMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addLayer(java.lang.String r6, com.taobao.weex.bridge.JSCallback r7, com.taobao.weex.bridge.JSCallback r8) {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.widgets.weex.module.WidgetLayerManangerModule.$ipChange
            java.lang.String r1 = "1360236561"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L1d
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r5
            r2[r3] = r6
            r6 = 2
            r2[r6] = r7
            r6 = 3
            r2[r6] = r8
            r0.ipc$dispatch(r1, r2)
            return
        L1d:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.youku.live.widgets.protocol.IEngineInstance r1 = com.youku.live.widgets.widgets.weex.WeexHelper.getWidgetEngineInstance(r5)
            if (r1 == 0) goto L38
            java.lang.String r6 = r1.addLayer(r6)
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L38
            java.lang.String r1 = "layerId"
            r0.put(r1, r6)
            goto L39
        L38:
            r3 = 0
        L39:
            if (r3 == 0) goto L41
            if (r7 == 0) goto L46
            r7.invoke(r0)
            goto L46
        L41:
            if (r8 == 0) goto L46
            r8.invoke(r0)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.widgets.weex.module.WidgetLayerManangerModule.addLayer(java.lang.String, com.taobao.weex.bridge.JSCallback, com.taobao.weex.bridge.JSCallback):void");
    }

    @JSMethod
    public void hideDialog(JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-427739571")) {
            ipChange.ipc$dispatch("-427739571", new Object[]{this, jSCallback, jSCallback2});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if ((widgetEngineInstance != null ? widgetEngineInstance.closeDialog(null) : null) != null) {
            if (jSCallback != null) {
                jSCallback.invoke(new HashMap());
            }
        } else if (jSCallback2 != null) {
            jSCallback2.invoke(new HashMap());
        }
    }

    @JSMethod
    public void removeLayer(String str, JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1939334736")) {
            ipChange.ipc$dispatch("-1939334736", new Object[]{this, str, jSCallback, jSCallback2});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null && !TextUtils.isEmpty(str)) {
            z = widgetEngineInstance.removeLayer(str);
        }
        if (z) {
            if (jSCallback != null) {
                jSCallback.invoke(new HashMap());
            }
        } else if (jSCallback2 != null) {
            jSCallback2.invoke(new HashMap());
        }
    }

    @JSMethod
    public void showDialog(String str, JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "596571388")) {
            ipChange.ipc$dispatch("596571388", new Object[]{this, str, jSCallback, jSCallback2});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        HashMap hashMap = new HashMap(1);
        String str2 = null;
        if (widgetEngineInstance != null && !TextUtils.isEmpty(str)) {
            str2 = widgetEngineInstance.showDialog(str);
        }
        if (str2 == null) {
            if (jSCallback2 != null) {
                jSCallback2.invoke(hashMap);
            }
        } else if (jSCallback != null) {
            hashMap.put("layerId", str2);
            jSCallback.invoke(hashMap);
        }
    }
}
