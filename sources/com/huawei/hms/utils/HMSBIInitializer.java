package com.huawei.hms.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.C5706a;
import com.huawei.hms.stats.C5708c;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class HMSBIInitializer {
    public static final Object d = new Object();
    public static HMSBIInitializer e;
    public static HiAnalyticsInstance f;
    public final Context a;
    public AtomicBoolean b = new AtomicBoolean(false);
    public boolean c = C5708c.a();

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.utils.HMSBIInitializer$a */
    /* loaded from: classes10.dex */
    public class C5734a implements IQueryUrlCallBack {
        public C5734a() {
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackFail(int i) {
            HMSLog.e("HMSBIInitializer", "get grs failed, the errorcode is " + i);
            HMSBIInitializer.this.b.set(false);
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackSuccess(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (!HMSBIInitializer.this.c) {
                    HmsHiAnalyticsUtils.init(HMSBIInitializer.this.a, false, false, false, str, "com.huawei.hwid");
                } else {
                    HiAnalyticsConfig build = new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build();
                    HiAnalyticsInstance unused = HMSBIInitializer.f = new HiAnalyticsInstance.Builder(HMSBIInitializer.this.a).setOperConf(build).setMaintConf(new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build()).create(HiAnalyticsConstant.HA_SERVICE_TAG);
                    HMSBIInitializer.f.setAppid("com.huawei.hwid");
                }
                HMSLog.i("HMSBIInitializer", "BI URL acquired successfully");
            }
            HMSBIInitializer.this.b.set(false);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.utils.HMSBIInitializer$b */
    /* loaded from: classes10.dex */
    public class AsyncTaskC5735b extends AsyncTask<String, Integer, Void> {
        public AsyncTaskC5735b() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            HMSBIInitializer.this.a(strArr[0]);
            return null;
        }

        public /* synthetic */ AsyncTaskC5735b(HMSBIInitializer hMSBIInitializer, C5734a c5734a) {
            this();
        }
    }

    public HMSBIInitializer(Context context) {
        this.a = context;
    }

    public static HMSBIInitializer getInstance(Context context) {
        synchronized (d) {
            if (e == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    e = new HMSBIInitializer(applicationContext);
                } else {
                    e = new HMSBIInitializer(context);
                }
            }
        }
        return e;
    }

    public HiAnalyticsInstance getAnalyticsInstance() {
        return f;
    }

    public void initBI() {
        boolean initFlag;
        if (!this.c) {
            initFlag = HmsHiAnalyticsUtils.getInitFlag();
        } else {
            initFlag = HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
        }
        HMSLog.i("HMSBIInitializer", "Builder->biInitFlag :" + initFlag);
        if (initFlag || C5706a.c(this.a) || !this.b.compareAndSet(false, true)) {
            return;
        }
        String issueCountryCode = GrsApp.getInstance().getIssueCountryCode(this.a);
        if (!TextUtils.isEmpty(issueCountryCode)) {
            issueCountryCode = issueCountryCode.toUpperCase(Locale.ENGLISH);
        }
        if (!"UNKNOWN".equalsIgnoreCase(issueCountryCode) && !TextUtils.isEmpty(issueCountryCode)) {
            new AsyncTaskC5735b(this, null).execute(issueCountryCode);
            return;
        }
        HMSLog.e("HMSBIInitializer", "Failed to get device issue country");
        this.b.set(false);
    }

    public boolean isInit() {
        if (!this.c) {
            return HmsHiAnalyticsUtils.getInitFlag();
        }
        return HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    public final void a(String str) {
        HMSLog.i("HMSBIInitializer", "Start to query GRS");
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setIssueCountry(str);
        new GrsClient(this.a, grsBaseInfo).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOTV2", new C5734a());
    }
}
