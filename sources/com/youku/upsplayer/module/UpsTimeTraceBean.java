package com.youku.upsplayer.module;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class UpsTimeTraceBean {
    public long time;
    public long timeEndParse;
    public long timeGetCkey;
    public long timeStartParseResult;
    public long timeStartRequest;

    public void startTrace() {
        this.time = System.currentTimeMillis();
    }

    public String toVpmString() {
        return "timeGetCkey:" + this.timeGetCkey + ";timeStartRequest:" + this.timeStartRequest + ";timeStartParseResult:" + this.timeStartParseResult + ";timeEndParse:" + this.timeEndParse;
    }

    public void traceTimeEndParse() {
        long currentTimeMillis = System.currentTimeMillis();
        this.timeEndParse = currentTimeMillis - this.time;
        this.time = currentTimeMillis;
    }

    public void traceTimeGetCkey() {
        long currentTimeMillis = System.currentTimeMillis();
        this.timeGetCkey = currentTimeMillis - this.time;
        this.time = currentTimeMillis;
    }

    public void traceTimeStartParseResult() {
        long currentTimeMillis = System.currentTimeMillis();
        this.timeStartParseResult = currentTimeMillis - this.time;
        this.time = currentTimeMillis;
    }

    public void traceTimeStartRequest() {
        long currentTimeMillis = System.currentTimeMillis();
        this.timeStartRequest = currentTimeMillis - this.time;
        this.time = currentTimeMillis;
    }
}
