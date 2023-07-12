package com.taobao.slide.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.Arrays;
import tb.au1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SlideConfig implements Serializable {
    private static final String[] DEFAULT_DC_HOSTS = {"orange-dc.alibaba.com", "orange-dc-pre.alibaba.com", "orange-dc-daily.alibaba.net"};
    private static final String[][] DEFAULT_PROBE_HOSTS = {new String[]{"acs.m.taobao.com"}, new String[]{"acs.wapa.taobao.com"}, new String[]{"acs.waptest.taobao.com"}};
    private String appKey;
    private String appSecret;
    private String appVersion;
    private String authCode;
    private String dcHost;
    private boolean enableCheck;
    private ENV env;
    private String[] probeHosts;
    private String ttid;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum ENV {
        ONLINE,
        PREPARE,
        TEST
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b {
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String[] h;
        private ENV a = ENV.ONLINE;
        private boolean i = true;

        public SlideConfig a() {
            SlideConfig slideConfig = new SlideConfig();
            au1.d(this.a);
            slideConfig.env = this.a;
            au1.b(this.c);
            slideConfig.appKey = this.c;
            au1.b(this.b);
            slideConfig.appVersion = this.b;
            slideConfig.appSecret = this.d;
            slideConfig.authCode = this.e;
            slideConfig.ttid = this.f;
            if (!TextUtils.isEmpty(this.g)) {
                slideConfig.dcHost = this.g;
            } else {
                slideConfig.dcHost = SlideConfig.DEFAULT_DC_HOSTS[this.a.ordinal()];
            }
            String[] strArr = this.h;
            if (strArr == null || strArr.length <= 0) {
                slideConfig.probeHosts = SlideConfig.DEFAULT_PROBE_HOSTS[this.a.ordinal()];
            } else {
                slideConfig.probeHosts = strArr;
            }
            slideConfig.enableCheck = this.i;
            return slideConfig;
        }

        public b b(@NonNull String str) {
            this.c = str;
            return this;
        }

        public b c(@NonNull String str) {
            this.b = str;
            return this;
        }

        public b d(boolean z) {
            this.i = z;
            return this;
        }

        public b e(@NonNull ENV env) {
            this.a = env;
            return this;
        }

        public b f(@NonNull String str) {
            this.f = str;
            return this;
        }
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getAuthCode() {
        return this.authCode;
    }

    public String getDcHost() {
        return this.dcHost;
    }

    public ENV getEnv() {
        return this.env;
    }

    public String[] getProbeHosts() {
        return this.probeHosts;
    }

    public String getTtid() {
        return this.ttid;
    }

    public boolean isEnableCheck() {
        return this.enableCheck;
    }

    public String toString() {
        return "SlideConfig{env=" + this.env + ", appVersion='" + this.appVersion + "', appKey='" + this.appKey + "', authCode='" + this.authCode + "', ttid='" + this.ttid + "', dcHost='" + this.dcHost + "', probeHosts=" + Arrays.toString(this.probeHosts) + ", enableCheck=" + this.enableCheck + '}';
    }

    private SlideConfig() {
    }
}
