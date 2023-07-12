package com.taobao.accs.flowcontrol;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.weex.annotation.JSMethod;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FlowControl {
    public static final int DELAY_MAX = -1;
    public static final int DELAY_MAX_BRUSH = -1000;
    public static final int HIGH_FLOW_CTRL = 2;
    public static final int HIGH_FLOW_CTRL_BRUSH = 3;
    public static final int LOW_FLOW_CTRL = 1;
    public static final int NO_FLOW_CTRL = 0;
    public static final String SERVICE_ALL = "ALL";
    public static final String SERVICE_ALL_BRUSH = "ALL_BRUSH";
    public static final int STATUS_FLOW_CTRL_ALL = 420;
    public static final int STATUS_FLOW_CTRL_BRUSH = 422;
    public static final int STATUS_FLOW_CTRL_CUR = 421;
    private static final String TAG = "FlowControl";
    private Context mContext;
    private FlowCtrlInfoHolder mFlowCtrlHolder;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class FlowControlInfo implements Serializable {
        private static final long serialVersionUID = -2259991484877844919L;
        public String bizId;
        public long delayTime;
        public long expireTime;
        public String serviceId;
        public long startTime;
        public int status;

        public FlowControlInfo(String str, String str2, int i, long j, long j2, long j3) {
            this.serviceId = str;
            this.bizId = str2;
            this.status = i;
            this.delayTime = j;
            this.expireTime = j2 <= 0 ? 0L : j2;
            this.startTime = j3 <= 0 ? 0L : j3;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() - (this.startTime + this.expireTime) > 0;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("flow ctrl serviceId:");
            stringBuffer.append(this.serviceId);
            stringBuffer.append(" bizId:");
            stringBuffer.append(this.bizId);
            stringBuffer.append(" status:");
            stringBuffer.append(this.status);
            stringBuffer.append(" delayTime:");
            stringBuffer.append(this.delayTime);
            stringBuffer.append(" startTime:");
            stringBuffer.append(this.startTime);
            stringBuffer.append(" expireTime:");
            stringBuffer.append(this.expireTime);
            return stringBuffer.toString();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class FlowCtrlInfoHolder implements Serializable {
        private static final long serialVersionUID = 6307563052429742524L;
        Map<String, FlowControlInfo> flowCtrlMap = null;

        public FlowControlInfo get(String str, String str2) {
            if (this.flowCtrlMap == null) {
                return null;
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str + JSMethod.NOT_SET + str2;
            }
            return this.flowCtrlMap.get(str);
        }

        public void put(String str, String str2, FlowControlInfo flowControlInfo) {
            if (!TextUtils.isEmpty(str2)) {
                str = str + JSMethod.NOT_SET + str2;
            }
            if (this.flowCtrlMap == null) {
                this.flowCtrlMap = new HashMap();
            }
            this.flowCtrlMap.put(str, flowControlInfo);
        }
    }

    public FlowControl(Context context) {
        this.mContext = context;
    }

    private void checkFlowCtrl() {
        FlowCtrlInfoHolder flowCtrlInfoHolder = this.mFlowCtrlHolder;
        if (flowCtrlInfoHolder == null || flowCtrlInfoHolder.flowCtrlMap == null) {
            return;
        }
        synchronized (this) {
            Iterator<Map.Entry<String, FlowControlInfo>> it = this.mFlowCtrlHolder.flowCtrlMap.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().isExpired()) {
                    it.remove();
                }
            }
        }
    }

    private boolean checkFlowCtrlInfo(long j, long j2) {
        if (j == 0 || j2 <= 0) {
            ALog.e(TAG, "error flow ctrl info", new Object[0]);
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x008c, code lost:
        if (r5.isExpired() != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0094, code lost:
        if (r0.isExpired() != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0096, code lost:
        checkFlowCtrl();
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c A[Catch: all -> 0x00dc, TryCatch #0 {, blocks: (B:10:0x0013, B:12:0x0032, B:15:0x0039, B:18:0x003f, B:21:0x0046, B:24:0x004c, B:27:0x0053, B:30:0x0059, B:33:0x0060, B:53:0x0088, B:58:0x0096, B:59:0x0099, B:56:0x0090), top: B:66:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0059 A[Catch: all -> 0x00dc, TryCatch #0 {, blocks: (B:10:0x0013, B:12:0x0032, B:15:0x0039, B:18:0x003f, B:21:0x0046, B:24:0x004c, B:27:0x0053, B:30:0x0059, B:33:0x0060, B:53:0x0088, B:58:0x0096, B:59:0x0099, B:56:0x0090), top: B:66:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0090 A[Catch: all -> 0x00dc, TryCatch #0 {, blocks: (B:10:0x0013, B:12:0x0032, B:15:0x0039, B:18:0x003f, B:21:0x0046, B:24:0x004c, B:27:0x0053, B:30:0x0059, B:33:0x0060, B:53:0x0088, B:58:0x0096, B:59:0x0099, B:56:0x0090), top: B:66:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long getFlowCtrlDelay(java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.flowcontrol.FlowControl.getFlowCtrlDelay(java.lang.String, java.lang.String):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00fd A[Catch: all -> 0x0126, TryCatch #1 {all -> 0x0126, blocks: (B:32:0x00ab, B:42:0x00fd, B:43:0x0119, B:47:0x0120, B:36:0x00bd, B:38:0x00db, B:40:0x00e1), top: B:75:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0142 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int updateFlowCtrlInfo(java.util.Map<java.lang.Integer, java.lang.String> r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.flowcontrol.FlowControl.updateFlowCtrlInfo(java.util.Map, java.lang.String):int");
    }
}
