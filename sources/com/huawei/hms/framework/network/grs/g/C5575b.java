package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.C5557a;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.e.C5564a;
import com.huawei.hms.framework.network.grs.e.C5566c;
import com.huawei.hms.framework.network.grs.g.k.C5590c;
import com.huawei.hms.framework.network.grs.h.C5597e;
import org.json.JSONException;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.framework.network.grs.g.b */
/* loaded from: classes10.dex */
public class C5575b {
    private final Context a;
    private final GrsBaseInfo b;
    private final C5564a c;

    public C5575b(Context context, C5564a c5564a, GrsBaseInfo grsBaseInfo) {
        this.a = context;
        this.b = grsBaseInfo;
        this.c = c5564a;
    }

    public String a(boolean z) {
        String str;
        String str2 = C5557a.a(this.c.a().a("geoipCountryCode", ""), "geoip.countrycode").get("ROOT");
        Logger.i("GeoipCountry", "geoIpCountry is: " + str2);
        String a = this.c.a().a("geoipCountryCodetime", "0");
        long j = 0;
        if (!TextUtils.isEmpty(a) && a.matches("\\d+")) {
            try {
                j = Long.parseLong(a);
            } catch (NumberFormatException e) {
                Logger.w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", e);
            }
        }
        if (TextUtils.isEmpty(str2) || C5597e.a(Long.valueOf(j))) {
            C5590c c5590c = new C5590c(this.b, this.a);
            c5590c.a("geoip.countrycode");
            C5566c c = this.c.c();
            if (c != null) {
                try {
                    str = C5586i.a(c.a("services", ""), c5590c.c());
                } catch (JSONException e2) {
                    Logger.w("GeoipCountry", "getGeoipCountry merge services occure jsonException. %s", StringUtils.anonymizeMessage(e2.getMessage()));
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    c.b("services", str);
                }
            }
            if (z) {
                C5578d a2 = this.c.b().a(c5590c, "geoip.countrycode", c);
                if (a2 != null) {
                    str2 = C5557a.a(a2.j(), "geoip.countrycode").get("ROOT");
                }
                Logger.i("GeoipCountry", "sync request to query geoip.countrycode is:" + str2);
            } else {
                Logger.i("GeoipCountry", "async request to query geoip.countrycode");
                this.c.b().a(c5590c, null, "geoip.countrycode", c);
            }
        }
        return str2;
    }
}
