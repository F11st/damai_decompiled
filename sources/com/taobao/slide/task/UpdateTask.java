package com.taobao.slide.task;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.fastjson.JSON;
import com.taobao.slide.core.SlideException;
import com.taobao.slide.core.SlideReceiver;
import com.taobao.slide.core.b;
import com.taobao.slide.model.AppDO;
import com.taobao.slide.model.AppUpdateDO;
import com.taobao.slide.request.c;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import tb.hh1;
import tb.m42;
import tb.nl;
import tb.u21;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UpdateTask implements Runnable {
    private static final long FAIL_ALLOW_INTERVAL = 180000;
    private static final long FAIL_MAX_COUNTS = 10;
    private static final String KEY_DIG = "dig";
    private static final String KEY_URL = "url";
    private static final String KEY_VER = "ver";
    private static final String TAG = "UpdateTask";
    private static Handler handler;
    private b engine;
    private Boolean fromGateWay;
    private Boolean isJson;
    private String updateInfo;
    private static AtomicInteger continueFailCounts = new AtomicInteger(0);
    private static AtomicBoolean isUpdateAllow = new AtomicBoolean(true);

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a extends c<AppDO> {
        a(UpdateTask updateTask, Context context, String str, String str2) {
            super(context, str, str2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.taobao.slide.request.b
        /* renamed from: f */
        public AppDO d(String str) {
            return (AppDO) JSON.parseObject(str, AppDO.class);
        }
    }

    public UpdateTask(b bVar, boolean z, boolean z2, String str) {
        this.engine = bVar;
        this.isJson = Boolean.valueOf(z);
        this.updateInfo = str;
        this.fromGateWay = Boolean.valueOf(z2);
    }

    public static boolean isAllow() {
        return SlideReceiver.a() && isUpdateAllow.get();
    }

    private AppUpdateDO parse(String str) {
        AppUpdateDO appUpdateDO = new AppUpdateDO();
        for (String str2 : str.split("&")) {
            String[] split = str2.split("=");
            if (split.length == 2) {
                String str3 = split[0];
                String str4 = split[1];
                if ("ver".equals(str3)) {
                    appUpdateDO.ver = nl.d(str4);
                } else if (KEY_DIG.equals(str3)) {
                    appUpdateDO.dig = nl.d(str4);
                } else if ("url".equals(str3)) {
                    appUpdateDO.url = nl.d(str4);
                }
            }
        }
        return appUpdateDO;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppUpdateDO parse;
        synchronized (this) {
            if (this.isJson.booleanValue()) {
                parse = (AppUpdateDO) JSON.parseObject(this.updateInfo, AppUpdateDO.class);
            } else {
                parse = parse(this.updateInfo);
            }
            if (parse != null && parse.isValid()) {
                if (!parse.dig.equals(this.engine.e()) && !parse.ver.equals(this.engine.f())) {
                    m42.g(TAG, TAG, "updateInfo", this.updateInfo);
                    try {
                    } catch (SlideException e) {
                        u21.c(parse.ver, e.getCode());
                        m42.j(TAG, "sync", e, new Object[0]);
                        if (continueFailCounts.get() == 10) {
                            hh1.a(hh1.POINT_MAXFAILS, parse.url);
                            m42.k(TAG, "sync fail exceed max counts so freeze isAllow", new Object[0]);
                            if (handler == null) {
                                handler = new Handler(Looper.getMainLooper());
                            }
                            handler.postDelayed(new Runnable() { // from class: com.taobao.slide.task.UpdateTask.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    m42.k(UpdateTask.TAG, "sync unfreeze isAllow", new Object[0]);
                                    UpdateTask.continueFailCounts.set(0);
                                    UpdateTask.isUpdateAllow.set(true);
                                }
                            }, FAIL_ALLOW_INTERVAL);
                            isUpdateAllow.set(false);
                        }
                        continueFailCounts.incrementAndGet();
                    }
                    if (parse.isValid()) {
                        m42.g(TAG, "run", "result", parse);
                        try {
                            AppDO e2 = new a(this, this.engine.c(), parse.url, parse.dig).e();
                            if (e2 != null && e2.isValid()) {
                                if (this.engine.b().getAppKey().equals(e2.f1032app)) {
                                    if (parse.ver.equals(e2.version)) {
                                        if (nl.h(e2.version, this.engine.f())) {
                                            u21.c(parse.ver, 0);
                                            continueFailCounts.set(0);
                                            isUpdateAllow.set(true);
                                            e2.dig = parse.dig;
                                            this.engine.l(e2, this.fromGateWay.booleanValue());
                                            return;
                                        }
                                        throw new SlideException(1023, "index version not higher");
                                    }
                                    throw new SlideException(1022, "index version invalid");
                                }
                                throw new SlideException(1021, "index appKey invalid");
                            }
                            throw new SlideException(1020, "index invalid");
                        } catch (SlideException e3) {
                            throw e3;
                        }
                    }
                    throw new SlideException(1002, "update invalid");
                }
                return;
            }
            m42.e(TAG, "updateDO invalid", "updateDO", parse);
        }
    }
}
