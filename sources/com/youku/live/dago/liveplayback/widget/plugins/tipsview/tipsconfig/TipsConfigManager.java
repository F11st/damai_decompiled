package com.youku.live.dago.liveplayback.widget.plugins.tipsview.tipsconfig;

import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.open.SocialConstants;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TipsConfigManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "TipsConfigManager";
    private static Map<String, TipInfo> sCacheTipsInfoMap;
    private static volatile Map<String, TipInfo> sTipsInfoMap;

    public static TipInfo getTipInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-968723825")) {
            return (TipInfo) ipChange.ipc$dispatch("-968723825", new Object[]{str});
        }
        if (sTipsInfoMap != null) {
            return sTipsInfoMap.get(str);
        }
        return null;
    }

    public static void handleTipsType(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2017236952")) {
            ipChange.ipc$dispatch("2017236952", new Object[]{jSONObject});
        } else if (jSONObject == null || !jSONObject.has("data")) {
        } else {
            JSONObject jSONObject3 = jSONObject.getJSONObject("data");
            if (jSONObject3.has("toastId")) {
                String string = jSONObject3.getString("toastId");
                if (sCacheTipsInfoMap == null) {
                    sCacheTipsInfoMap = new HashMap();
                }
                TipInfo tipInfo = sCacheTipsInfoMap.get(string);
                if (tipInfo == null) {
                    tipInfo = new TipInfo();
                    tipInfo.tipId = string;
                    sCacheTipsInfoMap.put(string, tipInfo);
                }
                if (jSONObject3.has("duration")) {
                    tipInfo.duration = jSONObject3.getInt("duration");
                }
                if (jSONObject3.has(SocialConstants.PARAM_COMMENT)) {
                    tipInfo.desc = jSONObject3.getString(SocialConstants.PARAM_COMMENT);
                }
                if (jSONObject3.has("title")) {
                    tipInfo.title = jSONObject3.getString("title");
                }
                if (jSONObject3.has("style") && (jSONObject2 = jSONObject3.getJSONObject("style")) != null) {
                    if (jSONObject2.has(BaseCellItem.TYPE_BUTTON)) {
                        tipInfo.buttonText = jSONObject2.getString(BaseCellItem.TYPE_BUTTON);
                    }
                    if (jSONObject2.has("text")) {
                        tipInfo.text = jSONObject2.getString("text");
                    }
                    if (jSONObject2.has("bigImg")) {
                        tipInfo.bigImg = jSONObject2.getString("bigImg");
                    }
                    if (jSONObject2.has("smallImg")) {
                        tipInfo.smallImg = jSONObject2.getString("smallImg");
                    }
                    if (jSONObject2.has("enableX")) {
                        tipInfo.enableClose = Boolean.valueOf(jSONObject2.getBoolean("enableX"));
                    }
                    if (jSONObject2.has(RemoteMessageConst.Notification.ICON)) {
                        tipInfo.icon = jSONObject2.getString(RemoteMessageConst.Notification.ICON);
                    }
                    if (jSONObject2.has("bgImg")) {
                        tipInfo.bgImg = jSONObject2.getString("bgImg");
                    }
                    if (jSONObject2.has("type")) {
                        tipInfo.type = jSONObject2.getInt("type");
                    }
                }
                if (jSONObject3.has("frequency")) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("frequency");
                    if (jSONObject4.has(AdUtConstants.XAD_UT_ARG_COUNT)) {
                        tipInfo.frequencyCount = jSONObject4.getInt(AdUtConstants.XAD_UT_ARG_COUNT);
                    }
                    if (jSONObject4.has("type")) {
                        tipInfo.frequencyType = jSONObject4.getInt("type");
                    }
                }
            }
        }
    }

    public static void refreshTipsState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1736523170")) {
            ipChange.ipc$dispatch("1736523170", new Object[0]);
        } else {
            sTipsInfoMap = sCacheTipsInfoMap;
        }
    }

    public static void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-140213469")) {
            ipChange.ipc$dispatch("-140213469", new Object[0]);
            return;
        }
        if (sTipsInfoMap != null) {
            sTipsInfoMap.clear();
        }
        Map<String, TipInfo> map = sCacheTipsInfoMap;
        if (map != null) {
            map.clear();
        }
    }
}
