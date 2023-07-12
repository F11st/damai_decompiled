package com.taobao.android.launcher.statistics.common.monitor.image;

import com.taobao.phenix.lifecycle.IPhenixLifeCycle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.bs1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Phenix implements IPhenixLifeCycle {
    public final List<ImageInfo> requestedImages = new ArrayList(256);
    public final List<ImageInfo> finishedImages = new ArrayList(256);
    public final List<ImageInfo> canceledImages = new ArrayList(256);
    public final List<ImageInfo> failedImages = new ArrayList(256);

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class ImageInfo {
        final long endTime;
        final String extension;
        final String name;
        final String requestId;
        final String requestUrl;
        final long size;
        final long startTime;

        ImageInfo(String str, String str2, String str3) {
            this(str, str2, str3, null, -1L, 0L, 0L);
        }

        public Map<String, Object> toMap() {
            HashMap hashMap = new HashMap(7);
            hashMap.put("name", this.name);
            hashMap.put("size", Long.valueOf(this.size));
            hashMap.put("request_id", this.requestId);
            hashMap.put("request_url", this.requestUrl);
            hashMap.put("start_time", Long.valueOf(this.startTime));
            hashMap.put("end_time", Long.valueOf(this.endTime));
            hashMap.put("extension", this.extension);
            return hashMap;
        }

        ImageInfo(String str, String str2, String str3, String str4, long j, long j2, long j3) {
            this.requestId = str;
            this.requestUrl = str2;
            this.name = str3;
            this.extension = str4;
            this.size = j;
            this.startTime = j2;
            this.endTime = j3;
        }
    }

    public void clear() {
        this.requestedImages.clear();
        this.finishedImages.clear();
        this.canceledImages.clear();
        this.failedImages.clear();
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onCancel(String str, String str2, Map<String, Object> map) {
        this.canceledImages.add(new ImageInfo(str, str2, str2));
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onError(String str, String str2, Map<String, Object> map) {
        this.failedImages.add(new ImageInfo(str, str2, str2));
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onEvent(String str, String str2, Map<String, Object> map) {
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onFinished(String str, String str2, Map<String, Object> map) {
        this.finishedImages.add(new ImageInfo(str, str2, str2));
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onRequest(String str, String str2, Map<String, Object> map) {
        this.requestedImages.add(new ImageInfo(str, str2, str2));
    }

    public void start() {
        bs1.b().a(this);
    }

    public void stop() {
        bs1.b().c(this);
    }
}
