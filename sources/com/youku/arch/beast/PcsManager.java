package com.youku.arch.beast;

import android.content.Context;
import android.util.Log;
import com.ali.user.open.core.exception.RpcException;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.base.TaoBaseService;
import com.ut.device.UTDevice;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PcsManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String DOWNSTREAM_SERVICE_CLASS_NAME = "com.youku.player.accs.PlayerAccsService";
    public static final String SERVICE_ID = "accs-youku-scheduler";
    private static TaoBaseService downstreamService;
    private static Context sApplicationContext;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class PcsCommandConfirmation {
        private static transient /* synthetic */ IpChange $ipChange;
        private String cmdId;
        private int cmdType;
        private PcsResponseCode responseCode;

        PcsCommandConfirmation(int i, String str, PcsResponseCode pcsResponseCode) {
            this.cmdType = i;
            this.cmdId = str;
            this.responseCode = pcsResponseCode;
        }

        String formJSONString() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1057075558")) {
                return (String) ipChange.ipc$dispatch("1057075558", new Object[]{this});
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msgType", (Object) 99);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cmdId", (Object) this.cmdId);
            jSONObject2.put("cmdType", (Object) Integer.valueOf(this.cmdType));
            jSONObject2.put("deviceId", (Object) UTDevice.getUtdid(PcsManager.sApplicationContext));
            jSONObject2.put("success", (Object) Integer.valueOf(this.responseCode.code));
            jSONObject2.put("ext", (Object) "");
            jSONObject.put("content", (Object) jSONObject2);
            return jSONObject.toJSONString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public enum PcsResponseCode {
        RSPN_SUCCESS(200),
        RSPN_REDUNDANT(402),
        RSPN_ILLEGAL(400),
        RSPN_CONTENT_ILLEGAL(RpcException.ErrorCode.API_UNAUTHORIZED);
        
        public final int code;

        PcsResponseCode(int i) {
            this.code = i;
        }
    }

    private static void ensureDownstreamService() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1199624394")) {
            ipChange.ipc$dispatch("-1199624394", new Object[0]);
        } else if (downstreamService == null) {
            synchronized (PcsManager.class) {
                if (downstreamService == null) {
                    try {
                        downstreamService = (TaoBaseService) Class.forName(DOWNSTREAM_SERVICE_CLASS_NAME).newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1337554055")) {
            ipChange.ipc$dispatch("-1337554055", new Object[]{context});
            return;
        }
        sApplicationContext = context.getApplicationContext();
        Log.d("BeastLib", "pcsManager registered");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String parseAndUpdate(java.lang.String r10, com.youku.arch.beast.PcsAccsService.PackedRawAccsData r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.beast.PcsManager.parseAndUpdate(java.lang.String, com.youku.arch.beast.PcsAccsService$PackedRawAccsData, java.lang.String):java.lang.String");
    }
}
