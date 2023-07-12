package com.taobao.accs.ut.statistics;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.weex.common.Constants;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ReceiveMsgStat implements UTInterface {
    private static final String TAG = "ReceiveMessage";
    public String dataId;
    public String dataLen;
    public String deviceId;
    public String messageType;
    public String receiveDate;
    public String serviceId;
    public String toBzDate;
    public String userId;
    private final String PAGE_NAME = "receiveMessage";
    public boolean repeat = false;
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
            try {
                hashMap.put(PushConstants.DEVICE_ID, this.deviceId);
                hashMap.put("data_id", this.dataId);
                hashMap.put("receive_date", this.receiveDate);
                hashMap.put("to_bz_date", this.toBzDate);
                hashMap.put("service_id", this.serviceId);
                hashMap.put("data_length", this.dataLen);
                hashMap.put("msg_type", this.messageType);
                hashMap.put("repeat", this.repeat ? Constants.Name.Y : "n");
                hashMap.put(UTDataCollectorNodeColumn.USER_ID, this.userId);
                UTMini.getInstance().commitEvent(66001, "receiveMessage", str, (Object) null, str2, hashMap);
            } catch (Throwable th2) {
                th = th2;
                ALog.d(TAG, UTMini.getCommitInfo(66001, str, (String) null, str2, hashMap) + " " + th.toString(), new Object[0]);
            }
        } catch (Throwable th3) {
            th = th3;
            str = null;
            str2 = null;
        }
    }
}
