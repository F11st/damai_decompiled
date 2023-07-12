package tb;

import anet.channel.statist.RequestStatistic;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ln0 {
    public String a;
    public String b;
    public String c;
    public long d;
    public long e;

    public ln0() {
    }

    public String toString() {
        return "FlowStat{refer='" + this.a + "', protocoltype='" + this.b + "', req_identifier='" + this.c + "', upstream=" + this.d + ", downstream=" + this.e + '}';
    }

    public ln0(String str, RequestStatistic requestStatistic) {
        this.a = str;
        this.b = requestStatistic.protocolType;
        this.c = requestStatistic.url;
        this.d = requestStatistic.sendDataSize;
        this.e = requestStatistic.recDataSize;
    }
}
