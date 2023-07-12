package com.youku.network.config;

import android.text.TextUtils;
import com.taobao.orange.OrangeConfig;
import com.youku.httpcommunication.C7926c;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class YKNetworkConfig {
    private static CallType a = CallType.OKHTTP;
    private static volatile boolean b = false;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum CallType {
        NETWORKSDK,
        OKHTTP,
        MTOP
    }

    public static long a() {
        try {
            return Long.parseLong(OrangeConfig.getInstance().getConfig("network_config", "okhttp_length_limit", "-1"));
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public static CallType a(String str) {
        return TextUtils.isEmpty(str) ? a : c(str) ? CallType.OKHTTP : b(str) ? CallType.NETWORKSDK : a;
    }

    public static boolean a(long j, long j2) {
        return j2 != -1 && j > j2;
    }

    public static int b() {
        try {
            return Integer.parseInt(OrangeConfig.getInstance().getConfig("network_config", "response_size_limit", "2097158"));
        } catch (Exception e) {
            e.printStackTrace();
            return 2097158;
        }
    }

    private static boolean b(String str) {
        try {
            return C7926c.a(new URL(str).getHost());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean c() {
        try {
            return Boolean.parseBoolean(OrangeConfig.getInstance().getConfig("network_config", "mtop_business", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean c(String str) {
        try {
            int port = new URL(str).getPort();
            return (port == -1 || port == 80) ? false : true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
