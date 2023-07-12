package com.youku.uplayer;

import com.youku.arch.analysis.a.b;
import com.youku.player.util.TLogUtilNative;
import com.youku.player.util.a;
import com.youku.player.util.c;
import com.youku.player.util.d;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class HttpDns {
    public static String getIpByHttpDns(String str) {
        if ("1".equals(d.a().a("player_network_https", "use_smart_dns", "0"))) {
            c.a("HttpDns", "start smartdns : " + str);
            List<String> a = b.a().a(str, 5);
            if (a != null) {
                StringBuilder sb = new StringBuilder();
                for (String str2 : a) {
                    sb.append(str2);
                    sb.append(";");
                }
                String sb2 = sb.toString();
                TLogUtilNative.loge("smartdns", "" + str + " result:" + sb2);
                return sb2;
            }
            return "";
        }
        return a.b(str);
    }
}
