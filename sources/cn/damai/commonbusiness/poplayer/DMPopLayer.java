package cn.damai.commonbusiness.poplayer;

import android.app.Activity;
import android.app.Application;
import android.content.ClipboardManager;
import android.graphics.Color;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import cn.damai.common.AppConfig;
import cn.damai.h5container.H5MainActivity;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.alibaba.poplayerconsole.debug.PopLayerDebugManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.bu0;
import tb.dt1;
import tb.ir;
import tb.wj2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class DMPopLayer extends PopLayer {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static class WVTBPopLayerPlugin extends WVApiPlugin {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.taobao.windvane.jsbridge.WVApiPlugin
        public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "283312032")) {
                return ((Boolean) ipChange.ipc$dispatch("283312032", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
            }
            try {
                String str3 = "";
                if ("getClipboardContent".equals(str)) {
                    ClipboardManager clipboardManager = (ClipboardManager) this.mContext.getSystemService("clipboard");
                    if (com.alibaba.wireless.security.aopsdk.replace.android.content.ClipboardManager.getPrimaryClip(clipboardManager).getItemCount() != 0) {
                        str3 = com.alibaba.wireless.security.aopsdk.replace.android.content.ClipboardManager.getPrimaryClip(clipboardManager).getItemAt(0).getText().toString();
                    }
                    wVCallBackContext.success(new JSONObject().put("clipboardText", str3).toString());
                    return true;
                } else if ("info".equals(str)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("isSupportGif", bu0.a());
                    wVCallBackContext.success(jSONObject.toString());
                    return true;
                } else if ("alphaStatistics".equals(str)) {
                    ViewGroup viewGroup = (ViewGroup) this.mWebView.getView().getParent();
                    if (viewGroup == null) {
                        wVCallBackContext.error("targetView is null");
                        return false;
                    }
                    viewGroup.destroyDrawingCache();
                    viewGroup.buildDrawingCache();
                    int alpha = Color.alpha(viewGroup.getDrawingCache().getPixel(1, 1));
                    dt1.b("alpha:" + alpha, new Object[0]);
                    UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder("Poplayer_AlphaStatistics");
                    uTCustomHitBuilder.setProperty("alpha", alpha + "");
                    UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder.build());
                    wVCallBackContext.success();
                    return true;
                } else {
                    wVCallBackContext.error();
                    return false;
                }
            } catch (Throwable th) {
                dt1.c("WVTBPopLayerPlugin.execute.error", th);
                wVCallBackContext.error();
                return false;
            }
        }
    }

    public DMPopLayer() {
        super(new ir(), new DMConfigAdapter(2, "android_poplayer"), new DMConfigAdapter(1, "android_poplayer_app"), new DMConfigAdapter(3, "android_poplayer_view"), new DMLayerMgrAdapter());
    }

    @Override // com.alibaba.poplayer.PopLayer
    public String getActivityInfo(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1180340221")) {
            return (String) ipChange.ipc$dispatch("-1180340221", new Object[]{this, activity});
        }
        if (activity.getClass().getName().equals(H5MainActivity.class)) {
            if (activity.getIntent() == null) {
                return null;
            }
            return activity.getIntent().getExtras().getString("url", "");
        } else if (activity.getIntent() == null) {
            return null;
        } else {
            return activity.getIntent().getDataString();
        }
    }

    @Override // com.alibaba.poplayer.PopLayer
    public boolean isValidConfig(BaseConfigItem baseConfigItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923576912")) {
            return ((Boolean) ipChange.ipc$dispatch("923576912", new Object[]{this, baseConfigItem})).booleanValue();
        }
        if (baseConfigItem == null) {
            return false;
        }
        if (baseConfigItem.extra == null) {
            return true;
        }
        try {
            String c = z20.c();
            JSONArray jSONArray = new JSONObject(baseConfigItem.extra.toString()).getJSONArray("cityId");
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    String obj = jSONArray.get(i).toString();
                    if (!TextUtils.isEmpty(c) && c.equals(obj)) {
                        return true;
                    }
                }
                return false;
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    @Override // com.alibaba.poplayer.PopLayer
    public void onCurActivityInited() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-985909217")) {
            ipChange.ipc$dispatch("-985909217", new Object[]{this});
        } else {
            super.onCurActivityInited();
        }
    }

    @Override // com.alibaba.poplayer.PopLayer
    protected String onGenarateAdapterVersion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "722501773")) {
            return (String) ipChange.ipc$dispatch("722501773", new Object[]{this});
        }
        try {
            return AppConfig.q();
        } catch (Throwable th) {
            dt1.c("DMPopLayer.setup.adapter_version.error", th);
            return "";
        }
    }

    @Override // com.alibaba.poplayer.PopLayer
    public void setup(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1457201794")) {
            ipChange.ipc$dispatch("-1457201794", new Object[]{this, application});
            return;
        }
        try {
            super.setup(application);
            WVPluginManager.registerPlugin("WVTBPopLayer", (Class<? extends WVApiPlugin>) WVTBPopLayerPlugin.class, true);
            registerLogAdapter(new wj2(application));
            WVPluginManager.registerPlugin("WVPopLayerManager", (Class<? extends WVApiPlugin>) PopLayerDebugManager.class, true);
        } catch (Throwable th) {
            dt1.c("DMPopLayer.setup()", th);
        }
    }
}
