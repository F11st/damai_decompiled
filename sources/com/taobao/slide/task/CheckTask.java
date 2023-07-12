package com.taobao.slide.task;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.slide.api.SlideConfig;
import com.taobao.slide.core.SlideException;
import com.taobao.slide.core.b;
import java.util.HashMap;
import java.util.Map;
import tb.m42;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CheckTask implements Runnable {
    private static final long CHECK_UPDATE_INTERVAL = 20000;
    private static final String TAG = "CheckTask";
    private static final String TAOBAO_PACKAGE_NAME = "com.taobao.taobao";
    private static final String TMALL_PACKAGE_NAME = "com.tmall.wireless";
    private static final String VERSION_PARAM = "since";
    private static volatile long lastIndexUpdTime;
    private static String packageName;
    private b engine;
    private String utdid;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a extends com.taobao.slide.request.a<String> {
        final /* synthetic */ String i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(CheckTask checkTask, Context context, SlideConfig slideConfig, String str, String str2, String str3, String str4) {
            super(context, slideConfig, str, str2, str3);
            this.i = str4;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.taobao.slide.request.b
        public Map<String, String> b() {
            HashMap hashMap = new HashMap();
            hashMap.put(CheckTask.VERSION_PARAM, this.i);
            return hashMap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.taobao.slide.request.b
        /* renamed from: h */
        public String d(String str) {
            return str;
        }
    }

    public CheckTask(b bVar, String str) {
        this.engine = bVar;
        this.utdid = str;
    }

    public static synchronized boolean isAllow(Context context) {
        synchronized (CheckTask.class) {
            if (context == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - lastIndexUpdTime <= CHECK_UPDATE_INTERVAL) {
                return false;
            }
            lastIndexUpdTime = currentTimeMillis;
            return true;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String format = String.format("http://%s/probes/_me", this.engine.b().getDcHost());
        String f = this.engine.f();
        m42.c(TAG, "sync", "url", format, "version", f);
        try {
            String e = new a(this, this.engine.c(), this.engine.b(), this.utdid, format, null, f).e();
            if (TextUtils.isEmpty(e)) {
                m42.e(TAG, "sync result is empty", new Object[0]);
            } else {
                new UpdateTask(this.engine, true, true, e).run();
            }
        } catch (SlideException e2) {
            m42.d(TAG, "sync", e2, new Object[0]);
        }
    }
}
