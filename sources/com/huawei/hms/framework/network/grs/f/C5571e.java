package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.e.C5564a;
import com.huawei.hms.framework.network.grs.g.C5575b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.framework.network.grs.f.e */
/* loaded from: classes10.dex */
public class C5571e {
    private static final String a = "e";
    public static final Set<String> b = Collections.unmodifiableSet(new C5572a(16));

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.framework.network.grs.f.e$a */
    /* loaded from: classes10.dex */
    static class C5572a extends HashSet<String> {
        C5572a(int i) {
            super(i);
            add("ser_country");
            add("reg_country");
            add("issue_country");
            add("geo_ip");
        }
    }

    private static String a(Context context, C5564a c5564a, String str, GrsBaseInfo grsBaseInfo, boolean z) {
        String[] split;
        String str2;
        StringBuilder sb;
        String str3;
        String serCountry = grsBaseInfo.getSerCountry();
        String regCountry = grsBaseInfo.getRegCountry();
        String issueCountry = grsBaseInfo.getIssueCountry();
        for (String str4 : str.split(jn1.G)) {
            if (b.contains(str4.trim())) {
                if ("ser_country".equals(str4.trim()) && !TextUtils.isEmpty(serCountry) && !"UNKNOWN".equals(serCountry)) {
                    str2 = a;
                    sb = new StringBuilder();
                    str3 = "current route_by is serCountry and routerCountry is:";
                } else if ("reg_country".equals(str4.trim()) && !TextUtils.isEmpty(regCountry) && !"UNKNOWN".equals(regCountry)) {
                    Logger.i(a, "current route_by is regCountry and routerCountry is:" + regCountry);
                    return regCountry;
                } else if ("issue_country".equals(str4.trim()) && !TextUtils.isEmpty(issueCountry) && !"UNKNOWN".equals(issueCountry)) {
                    Logger.i(a, "current route_by is issueCountry and routerCountry is:" + issueCountry);
                    return issueCountry;
                } else if ("geo_ip".equals(str4.trim())) {
                    serCountry = new C5575b(context, c5564a, grsBaseInfo).a(z);
                    str2 = a;
                    sb = new StringBuilder();
                    str3 = "current route_by is geo_ip and routerCountry is: ";
                }
                sb.append(str3);
                sb.append(serCountry);
                Logger.i(str2, sb.toString());
                return serCountry;
            }
        }
        return "";
    }

    public static String b(Context context, C5564a c5564a, String str, GrsBaseInfo grsBaseInfo, boolean z) {
        if (TextUtils.isEmpty(str)) {
            Logger.w(a, "routeBy must be not empty string or null.");
            return null;
        } else if ("no_route".equals(str) || "unconditional".equals(str)) {
            Logger.v(a, "routeBy equals NO_ROUTE_POLICY");
            return "no_route_country";
        } else {
            return a(context, c5564a, str, grsBaseInfo, z);
        }
    }
}
