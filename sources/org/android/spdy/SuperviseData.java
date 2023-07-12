package org.android.spdy;

import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SuperviseData {
    public int bodySize;
    public int compressSize;
    public int originContentLength;
    public int recvBodySize;
    public int recvCompressSize;
    public int recvUncompressSize;
    public long requestStart;
    public long responseBodyStart;
    public long responseEnd;
    public long responseHeaderEnd;
    public long responseStart;
    public long sendEnd;
    public long sendStart;
    public long streamFinRecvTime;
    public int streamRS;
    public int streamSS;
    public int uncompressSize;
    private long srtt = -1;
    private long connSendSize = -1;
    private long connRecvSize = -1;
    private int recvPacketCount = -1;
    private int sendPacketCount = -1;
    private long connLastRdEventIdleTime = -1;

    SuperviseData() {
    }

    public String getConnInfo() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("connSendSize=");
        sb.append(this.connSendSize);
        sb.append(",connRecvSize=");
        sb.append(this.connRecvSize);
        sb.append(",sendPacketCount=");
        sb.append(this.sendPacketCount);
        sb.append(",recvPacketCount=");
        sb.append(this.recvPacketCount);
        sb.append(",connLastRdEventIdleTime=");
        sb.append(this.connLastRdEventIdleTime);
        sb.append("us");
        sb.append(",srtt=");
        sb.append(this.srtt);
        sb.append("us");
        return sb.toString();
    }

    public String superviseDataToString() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("tnetProcessTime=");
        sb.append(this.sendStart - this.requestStart);
        sb.append(",sendCostTime=");
        sb.append(this.sendEnd - this.sendStart);
        sb.append(",firstDateTime=");
        sb.append(this.responseStart - this.sendEnd);
        sb.append(",recvHeaderTime=");
        sb.append(this.responseHeaderEnd - this.responseStart);
        sb.append(",recvBodyTime=");
        sb.append(this.responseEnd - this.responseBodyStart);
        sb.append(",reqEnd2BeginTime=");
        sb.append(this.streamFinRecvTime - this.requestStart);
        sb.append(",reqHeadSize=");
        sb.append(this.uncompressSize);
        sb.append(",reqHeadCompressSize=");
        sb.append(this.compressSize);
        sb.append(",reqBodySize=");
        sb.append(this.bodySize);
        sb.append(",rspHeadCompressSize=");
        sb.append(this.recvCompressSize);
        sb.append(",rspHeadSize=");
        sb.append(this.recvUncompressSize);
        sb.append(",recvBodyCompressSize=");
        sb.append(this.recvBodySize);
        sb.append(",contentLength=");
        sb.append(this.originContentLength);
        sb.append(",streamSS=");
        sb.append(this.streamSS);
        sb.append(",streamRS=");
        sb.append(this.streamRS);
        sb.append(",connInfo=[");
        sb.append(getConnInfo());
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }
}
