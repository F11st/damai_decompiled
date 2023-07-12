package com.tencent.stat.event;

import android.content.Context;
import com.alipay.sdk.m.s.C4293a;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.tencent.stat.StatAppMonitor;
import com.tencent.stat.common.StatCommonHelper;
import io.flutter.wpkbridge.U4WPKAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MonitorStatEvent extends Event {
    private static String appVersion;
    private static String simOperator;
    private StatAppMonitor monitor;

    public MonitorStatEvent(Context context, int i, StatAppMonitor statAppMonitor) {
        super(context, i);
        this.monitor = null;
        this.monitor = statAppMonitor;
    }

    @Override // com.tencent.stat.event.Event
    public EventType getType() {
        return EventType.MONITOR_STAT;
    }

    @Override // com.tencent.stat.event.Event
    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        StatAppMonitor statAppMonitor = this.monitor;
        if (statAppMonitor == null) {
            return false;
        }
        jSONObject.put("na", statAppMonitor.getInterfaceName());
        jSONObject.put("rq", this.monitor.getReqSize());
        jSONObject.put("rp", this.monitor.getRespSize());
        jSONObject.put("rt", this.monitor.getResultType());
        jSONObject.put(U4WPKAdapter.KEY_TM, this.monitor.getMillisecondsConsume());
        jSONObject.put("rc", this.monitor.getReturnCode());
        jSONObject.put("sp", this.monitor.getSampling());
        if (appVersion == null) {
            appVersion = StatCommonHelper.getAppVersion(this.ctx);
        }
        StatCommonHelper.jsonPut(jSONObject, C4293a.w, appVersion);
        if (simOperator == null) {
            simOperator = StatCommonHelper.getSimOperator(this.ctx);
        }
        StatCommonHelper.jsonPut(jSONObject, "op", simOperator);
        jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, StatCommonHelper.getLinkedWay(this.ctx));
        return true;
    }
}
