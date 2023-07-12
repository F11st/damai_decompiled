package com.taobao.weex.performance;

import androidx.annotation.NonNull;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXConfigAdapter;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.utils.WXUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import tb.jn1;
import tb.oz2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXStateRecord {
    private RecordList<a> a;
    private RecordList<a> b;
    private RecordList<a> c;
    private RecordList<a> d;
    private RecordList<a> e;
    private RecordList<a> f;
    private RecordList<a> g;
    private long h;
    private Runnable i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class RecordList<E> extends ConcurrentLinkedQueue<E> {
        private int maxSize;

        public RecordList(int i) {
            this.maxSize = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a implements Comparable<a> {
        private long a;
        private String b;
        private String c;

        public a(long j, String str, String str2) {
            this.a = j;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(@NonNull a aVar) {
            long j = this.a;
            long j2 = aVar.a;
            if (j == j2) {
                return 0;
            }
            return j > j2 ? 1 : -1;
        }

        public String toString() {
            return jn1.ARRAY_START + this.b + ',' + this.a + ',' + this.c + "]->";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b {
        private static final WXStateRecord a = new WXStateRecord();
    }

    public static WXStateRecord d() {
        return b.a;
    }

    private void j(RecordList<a> recordList, a aVar) {
        if (recordList == null || aVar == null) {
            return;
        }
        try {
            recordList.add(aVar);
            if (recordList.isEmpty() || recordList.size() <= ((RecordList) recordList).maxSize) {
                return;
            }
            recordList.poll();
        } catch (Throwable th) {
            th.getStackTrace();
        }
    }

    public Map<String, String> e() {
        HashMap hashMap = new HashMap(5);
        hashMap.put("reInitCount", String.valueOf(WXBridgeManager.reInitCount));
        ArrayList arrayList = new ArrayList(this.a.size() + this.b.size() + this.c.size() + this.d.size() + this.e.size() + this.f.size());
        arrayList.addAll(this.a);
        arrayList.addAll(this.b);
        arrayList.addAll(this.c);
        arrayList.addAll(this.d);
        arrayList.addAll(this.e);
        arrayList.addAll(this.f);
        arrayList.addAll(this.g);
        Collections.sort(arrayList);
        hashMap.put("stateInfoList", arrayList.toString());
        IWXConfigAdapter J = WXSDKManager.v().J();
        if (J != null && "true".equalsIgnoreCase(J.getConfig(oz2.WXAPM_CONFIG_GROUP, "dumpIpcPageInfo", "true"))) {
            hashMap.put("pageQueueInfo", WXBridgeManager.getInstance().dumpIpcPageInfo());
        }
        return hashMap;
    }

    public void f(String str) {
        j(this.d, new a(WXUtils.getFixUnixTime(), str, "onJSCCrash"));
    }

    public void g(String str) {
        j(this.e, new a(WXUtils.getFixUnixTime(), str, "onJSEngineReload"));
    }

    public void h() {
        n("setJsfmVersion");
    }

    public void i(String str, String str2) {
        j(this.b, new a(WXUtils.getFixUnixTime(), str, str2));
    }

    public void k(String str, String str2) {
        if (str2.length() > 200) {
            str2 = str2.substring(0, 200);
        }
        j(this.a, new a(WXUtils.getFixUnixTime(), str, str2));
    }

    public void l(String str, String str2) {
        if (str2.length() > 200) {
            str2 = str2.substring(0, 200);
        }
        j(this.g, new a(WXUtils.getFixUnixTime(), str, str2));
    }

    public void m(String str) {
        j(this.f, new a(WXUtils.getFixUnixTime(), "jsWatch", str));
    }

    public void n(String str) {
        j(this.c, new a(WXUtils.getFixUnixTime(), "JSFM", str));
    }

    public void o() {
        WXBridgeManager.getInstance().post(this.i);
    }

    private WXStateRecord() {
        this.h = -1L;
        this.i = new Runnable() { // from class: com.taobao.weex.performance.WXStateRecord.1
            @Override // java.lang.Runnable
            public void run() {
                if (WXStateRecord.this.h == -1) {
                    WXStateRecord.this.h = WXUtils.getFixUnixTime();
                }
                long fixUnixTime = WXUtils.getFixUnixTime() - WXStateRecord.this.h;
                WXStateRecord wXStateRecord = WXStateRecord.this;
                wXStateRecord.m("diff:" + fixUnixTime);
                WXStateRecord.this.h = WXUtils.getFixUnixTime();
                WXBridgeManager.getInstance().postDelay(WXStateRecord.this.i, 500L);
            }
        };
        this.a = new RecordList<>(10);
        this.b = new RecordList<>(20);
        this.c = new RecordList<>(10);
        this.d = new RecordList<>(10);
        this.e = new RecordList<>(10);
        this.f = new RecordList<>(20);
        this.g = new RecordList<>(20);
    }
}
