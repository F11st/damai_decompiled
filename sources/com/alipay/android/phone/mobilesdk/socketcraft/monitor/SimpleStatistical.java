package com.alipay.android.phone.mobilesdk.socketcraft.monitor;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SimpleStatistical {
    public long startConnAllTime = 0;
    public long endConnAllTime = 0;
    public long connectedTime = 0;
    public long disconnectedTime = 0;
    public long recvMsgCount = 0;
    public long sendMsgCount = 0;
    public String recvMsgLenArray = "";
    public String sendMsgLenArray = "";
    public String targetHost = "";
    public long dnsTime = -1;
    public long tcpTime = -1;
    public long sslTime = -1;
    public long wsHsTime = -1;

    public long getConnAllTime() {
        long j = this.startConnAllTime;
        if (j > 0) {
            long j2 = this.endConnAllTime;
            if (j2 > j) {
                return j2 - j;
            }
            return -1L;
        }
        return -1L;
    }

    public long getLinkLiveTime() {
        long j = this.connectedTime;
        if (j > 0) {
            long j2 = this.disconnectedTime;
            if (j2 > j) {
                return j2 - j;
            }
            return -1L;
        }
        return -1L;
    }
}
