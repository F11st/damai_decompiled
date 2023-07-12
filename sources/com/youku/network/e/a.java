package com.youku.network.e;

import com.taobao.orange.OrangeConfig;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class a {
    public static boolean a() {
        try {
            return Boolean.parseBoolean(OrangeConfig.getInstance().getConfig("http_request", "request_timeout", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
