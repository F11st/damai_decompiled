package com.youku.live.dago.liveplayback.widget.plugins.toptip;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TopTipConfigManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "TopTipConfigManager";
    private static Map<Integer, RemoteTopTipInfo> sTopTipInfoMap = new HashMap();

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class RemoteTopTipInfo {
        private static transient /* synthetic */ IpChange $ipChange;
        public String bgImgUrl;
        public int displayTime;
        public int frequency;
        public int frequencyType;
        public String icon;
        public String reminder;
        public String styleType;
        public int type;

        public boolean isCustomStyle() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "876858534") ? ((Boolean) ipChange.ipc$dispatch("876858534", new Object[]{this})).booleanValue() : "3".equals(this.styleType);
        }

        public boolean isVipStyle() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "182622360") ? ((Boolean) ipChange.ipc$dispatch("182622360", new Object[]{this})).booleanValue() : "2".equals(this.styleType);
        }

        public String toString() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "836721626")) {
                return (String) ipChange.ipc$dispatch("836721626", new Object[]{this});
            }
            StringBuilder sb = new StringBuilder();
            sb.append(jn1.BLOCK_START_STR);
            sb.append("bgImgUrl: " + this.bgImgUrl);
            sb.append(", displayTime: " + this.displayTime);
            sb.append(", frequency: " + this.frequency);
            sb.append(", frequencyType: " + this.frequencyType);
            sb.append(", icon: " + this.icon);
            sb.append(", reminder: " + this.reminder);
            sb.append(", styleType: " + this.styleType);
            sb.append(", type: " + this.type);
            sb.append("}");
            return sb.toString();
        }
    }

    public static RemoteTopTipInfo getRemoteTopTipInfo(int i, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1346710301")) {
            return (RemoteTopTipInfo) ipChange.ipc$dispatch("1346710301", new Object[]{Integer.valueOf(i), context});
        }
        if (sTopTipInfoMap.size() == 0) {
            parseData(context);
        }
        return sTopTipInfoMap.get(Integer.valueOf(i));
    }

    private static void parseData(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-81782535")) {
            ipChange.ipc$dispatch("-81782535", new Object[]{context});
            return;
        }
        String string = context.getSharedPreferences("player_detail_config", 0).getString("player_reminder_info", "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    RemoteTopTipInfo remoteTopTipInfo = new RemoteTopTipInfo();
                    if (jSONObject.has("bgimgUrl")) {
                        remoteTopTipInfo.bgImgUrl = jSONObject.getString("bgimgUrl");
                    }
                    if (jSONObject.has("displayTime")) {
                        remoteTopTipInfo.displayTime = jSONObject.getInt("displayTime");
                    }
                    if (jSONObject.has("frequency")) {
                        remoteTopTipInfo.frequency = jSONObject.getInt("frequency");
                    }
                    if (jSONObject.has("frequencyType")) {
                        remoteTopTipInfo.frequencyType = jSONObject.getInt("frequencyType");
                    }
                    if (jSONObject.has(RemoteMessageConst.Notification.ICON)) {
                        remoteTopTipInfo.icon = jSONObject.getString(RemoteMessageConst.Notification.ICON);
                    }
                    if (jSONObject.has(NotificationCompat.CATEGORY_REMINDER)) {
                        remoteTopTipInfo.reminder = jSONObject.getString(NotificationCompat.CATEGORY_REMINDER);
                    }
                    if (jSONObject.has("styleType")) {
                        remoteTopTipInfo.styleType = jSONObject.getString("styleType");
                    }
                    if (jSONObject.has("type")) {
                        int i2 = jSONObject.getInt("type");
                        remoteTopTipInfo.type = i2;
                        sTopTipInfoMap.put(Integer.valueOf(i2), remoteTopTipInfo);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
