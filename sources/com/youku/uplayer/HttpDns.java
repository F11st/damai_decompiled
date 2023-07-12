package com.youku.uplayer;

import com.youku.arch.analysis.a.C7807b;
import com.youku.player.util.C8059a;
import com.youku.player.util.C8063c;
import com.youku.player.util.C8064d;
import com.youku.player.util.TLogUtilNative;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class HttpDns {
    public static String getIpByHttpDns(String str) {
        if ("1".equals(C8064d.a().a("player_network_https", "use_smart_dns", "0"))) {
            C8063c.a("HttpDns", "start smartdns : " + str);
            List<String> a = C7807b.a().a(str, 5);
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
        return C8059a.b(str);
    }
}
