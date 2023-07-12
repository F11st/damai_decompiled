package com.taobao.accs.ut.statistics;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SendAckStatistic implements UTInterface {
    private static final String TAG = "accs.SendAckStatistic";
    public String dataId;
    public String deviceId;
    public String failReason;
    public String sendTime;
    public String serviceId;
    public String sessionId;
    private final String PAGE_NAME = "sendAck";
    private boolean isCommitted = false;

    @Override // com.taobao.accs.ut.statistics.UTInterface
    public void commitUT() {
        String str;
        String str2;
        if (this.isCommitted) {
            return;
        }
        this.isCommitted = true;
        HashMap hashMap = new HashMap();
        try {
            str = this.deviceId;
            try {
                str2 = String.valueOf((int) Constants.SDK_VERSION_CODE);
            } catch (Throwable th) {
                th = th;
                str2 = null;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
            str2 = null;
        }
        try {
            hashMap.put(PushConstants.DEVICE_ID, this.deviceId);
            hashMap.put("session_id", this.sessionId);
            hashMap.put("data_id", this.dataId);
            hashMap.put("ack_date", this.sendTime);
            hashMap.put("service_id", this.serviceId);
            hashMap.put("fail_reasons", this.failReason);
            UTMini.getInstance().commitEvent(66001, "sendAck", str, (Object) null, str2, hashMap);
        } catch (Throwable th3) {
            th = th3;
            ALog.d(TAG, UTMini.getCommitInfo(66001, str, (String) null, str2, hashMap) + " " + th.toString(), new Object[0]);
        }
    }
}
