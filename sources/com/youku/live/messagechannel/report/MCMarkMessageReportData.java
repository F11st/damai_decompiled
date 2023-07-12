package com.youku.live.messagechannel.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.xadsdk.request.builder.IRequestConst;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MCMarkMessageReportData {
    @JSONField(name = "bfdt")
    public long bfdt;
    @JSONField(name = "bft")
    public long bft;
    @JSONField(name = "bpdt")
    public long bpdt;
    @JSONField(name = IRequestConst.CS)
    public String cs;
    @JSONField(name = "ddt")
    public long ddt;
    @JSONField(name = "dt")
    public long dt;
    @JSONField(name = "mid")
    public String mid;
    @JSONField(name = "mt")
    public String mt;
    @JSONField(name = "pto")
    public boolean pto;
    @JSONField(name = "qos")
    public String qos;
    @JSONField(name = "st")
    public long st;

    public MCMarkMessageReportData(String str, String str2, String str3, String str4, long j, long j2, long j3, long j4, long j5, long j6, boolean z) {
        this.mid = str;
        this.cs = str2;
        this.mt = str3;
        this.qos = str4;
        this.st = j;
        this.dt = j2;
        this.ddt = j3;
        this.bft = j4;
        this.bfdt = j5;
        this.bpdt = j6;
        this.pto = z;
    }
}
