package com.youku.kubus;

import android.util.LongSparseArray;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
@NoProguard
/* loaded from: classes2.dex */
class DataSource {
    private Map<String, Object> dataSets = new HashMap();
    private Map<String, Event> mStickEventSets = new HashMap();
    private LongSparseArray<Response> responses = new LongSparseArray<>();
    private LongSparseArray<Request> requests = new LongSparseArray<>();

    protected synchronized Object getData(String str) {
        return this.dataSets.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Request getRequest(long j) {
        return this.requests.get(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Response getResponse(long j) {
        return this.responses.get(j);
    }

    protected synchronized void putData(String str, Object obj) {
        this.dataSets.put(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void putRequest(long j, Request request) {
        this.requests.put(j, request);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void putResponse(long j, Response response) {
        this.responses.put(j, response);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void removeRequest(long j) {
        this.requests.remove(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void removeResponse(long j) {
        this.responses.remove(j);
    }
}
