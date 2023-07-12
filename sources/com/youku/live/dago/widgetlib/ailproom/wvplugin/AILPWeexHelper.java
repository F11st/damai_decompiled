package com.youku.live.dago.widgetlib.ailproom.wvplugin;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.bridge.WXModuleManager;
import com.taobao.weex.common.WXModule;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPWeexHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    public static WXModule findModuleByInstanceId(WXSDKInstance wXSDKInstance, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818076623")) {
            return (WXModule) ipChange.ipc$dispatch("-818076623", new Object[]{wXSDKInstance, str});
        }
        if (wXSDKInstance != null && str != null) {
            try {
                Field declaredField = WXModuleManager.class.getDeclaredField("sInstanceModuleMap");
                declaredField.setAccessible(true);
                return (WXModule) ((Map) ((Map) declaredField.get(new ConcurrentHashMap())).get(wXSDKInstance.getInstanceId())).get(str);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
