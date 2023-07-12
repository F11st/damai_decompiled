package com.taobao.android.launcher.statistics.common.monitor.network;

import com.taobao.network.lifecycle.IMtopLifecycle;
import com.taobao.network.lifecycle.INetworkLifecycle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.rh1;
import tb.uj1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Network implements IMtopLifecycle, INetworkLifecycle {
    public final List<RequestInfo> mtopRequests = new ArrayList(256);
    public final List<RequestInfo> otherRequests = new ArrayList(256);

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class RequestInfo {
        final long endTime;
        final String requestId;
        final String requestUrl;
        final long startTime;

        RequestInfo(String str, String str2) {
            this(str, str2, 0L, 0L);
        }

        public Map<String, Object> toMap() {
            HashMap hashMap = new HashMap(7);
            hashMap.put("request_id", this.requestId);
            hashMap.put("request_url", this.requestUrl);
            hashMap.put("start_time", Long.valueOf(this.startTime));
            hashMap.put("end_time", Long.valueOf(this.endTime));
            return hashMap;
        }

        RequestInfo(String str, String str2, long j, long j2) {
            this.requestId = str;
            this.requestUrl = str2;
            this.startTime = j;
            this.endTime = j2;
        }
    }

    public void clear() {
    }

    @Override // com.taobao.network.lifecycle.INetworkLifecycle
    public void onCancel(String str, Map<String, Object> map) {
    }

    @Override // com.taobao.network.lifecycle.INetworkLifecycle
    public void onError(String str, Map<String, Object> map) {
    }

    @Override // com.taobao.network.lifecycle.INetworkLifecycle
    public void onEvent(String str, String str2, Map<String, Object> map) {
    }

    @Override // com.taobao.network.lifecycle.INetworkLifecycle
    public void onFinished(String str, Map<String, Object> map) {
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopCancel(String str, Map<String, Object> map) {
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopError(String str, Map<String, Object> map) {
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopEvent(String str, String str2, Map<String, Object> map) {
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopFinished(String str, Map<String, Object> map) {
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopRequest(String str, String str2, Map<String, Object> map) {
        this.mtopRequests.add(new RequestInfo(str, str2));
    }

    @Override // com.taobao.network.lifecycle.INetworkLifecycle
    public void onRequest(String str, String str2, Map<String, Object> map) {
        this.otherRequests.add(new RequestInfo(str, str2));
    }

    @Override // com.taobao.network.lifecycle.INetworkLifecycle
    public void onValidRequest(String str, String str2, Map<String, Object> map) {
    }

    public void start() {
        uj1.a().c(this);
        rh1.a().c(this);
    }

    public void stop() {
        uj1.a().b(this);
        rh1.a().b(this);
    }
}
