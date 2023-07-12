package com.alibaba.analytics.core.logbuilder;

import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import com.ut.mini.extend.UTExtendSwitch;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;
import tb.hl2;
import tb.q01;
import tb.we2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class TimeStampAdjustMgr {
    public static final String TAG_TIME_ADJUST_HOST_PORT = "time_adjust_host";
    private static TimeStampAdjustMgr f = new TimeStampAdjustMgr();
    private long a = 0;
    private String b = "https://";
    private String c = "acs.m.taobao.com";
    private String d = "/gw/mtop.common.getTimestamp/*";
    private boolean e = false;

    public static TimeStampAdjustMgr k() {
        return f;
    }

    public boolean h() {
        return this.e;
    }

    public long i() {
        return System.currentTimeMillis() + this.a;
    }

    public long j(String str) {
        long j;
        try {
            j = Long.parseLong(str);
        } catch (Exception e) {
            Logger.f("TimeStampAdjustMgr", e);
            j = 0;
        }
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        return j + this.a;
    }

    public void l() {
        Logger.f("TimeStampAdjustMgr", "bTimeStampAdjust", Boolean.valueOf(UTExtendSwitch.bTimeStampAdjust));
        if (UTExtendSwitch.bTimeStampAdjust) {
            hl2.c().d(null, new Runnable() { // from class: com.alibaba.analytics.core.logbuilder.TimeStampAdjustMgr.1
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    String str = TimeStampAdjustMgr.this.c;
                    String a = we2.a(Variables.n().j(), TimeStampAdjustMgr.TAG_TIME_ADJUST_HOST_PORT);
                    if (!TextUtils.isEmpty(a)) {
                        str = a;
                    }
                    String str2 = TimeStampAdjustMgr.this.b + str + TimeStampAdjustMgr.this.d;
                    q01.C9588a a2 = q01.a(1, str2, null, false);
                    Logger.f("TimeStampAdjustMgr", "url", str2, "response", a2);
                    if (a2 == null || a2.a == null) {
                        return;
                    }
                    try {
                        byte[] bArr = a2.a;
                        JSONObject optJSONObject = new JSONObject(new String(bArr, 0, bArr.length)).optJSONObject("data");
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("t");
                            if (TextUtils.isEmpty(optString)) {
                                return;
                            }
                            try {
                                long parseLong = Long.parseLong(optString);
                                long j = parseLong - currentTimeMillis;
                                if (j > 180000 || currentTimeMillis - parseLong > 180000) {
                                    TimeStampAdjustMgr.this.a = j;
                                    TimeStampAdjustMgr.this.e = true;
                                }
                                Logger.f("TimeStampAdjustMgr", "t", optString, "now", Long.valueOf(currentTimeMillis), "diff", Long.valueOf(TimeStampAdjustMgr.this.a), AgooConstants.MESSAGE_FLAG, Boolean.valueOf(TimeStampAdjustMgr.this.e));
                            } catch (Throwable unused) {
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }, 0L);
        }
    }
}
