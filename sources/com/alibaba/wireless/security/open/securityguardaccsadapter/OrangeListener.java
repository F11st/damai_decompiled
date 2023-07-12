package com.alibaba.wireless.security.open.securityguardaccsadapter;

import com.alibaba.wireless.security.framework.IRouterComponent;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrangeListener implements OConfigListener {
    private static final boolean DEBUG = false;
    private static final String TAG = "OrangeListener";
    public static final /* synthetic */ int a = 0;
    private static volatile IRouterComponent gGlobalRounterComponent;

    public static String getOrangeConfig(String str, String str2, String str3) {
        try {
            return OrangeConfig.getInstance().getConfig(str, str2, str3);
        } catch (Exception unused) {
            return null;
        }
    }

    private IRouterComponent getRouterComponent() {
        if (gGlobalRounterComponent == null) {
            synchronized (OConfigListener.class) {
                if (gGlobalRounterComponent == null) {
                    try {
                        gGlobalRounterComponent = SecurityGuardManager.getInstance(OrangeAdapter.gContext).getSGPluginManager().getRouter();
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return gGlobalRounterComponent;
    }

    @Override // com.taobao.orange.OConfigListener
    public void onConfigUpdate(String str, Map<String, String> map) {
        String jSONObject;
        IRouterComponent routerComponent;
        Map<String, String> configs = OrangeConfig.getInstance().getConfigs(str);
        if (configs != null) {
            try {
                jSONObject = new JSONObject(configs).toString();
            } catch (Exception unused) {
            }
            if (jSONObject != null || (routerComponent = getRouterComponent()) == null) {
            }
            routerComponent.doCommand(11153, jSONObject);
            return;
        }
        jSONObject = null;
        if (jSONObject != null) {
        }
    }
}
