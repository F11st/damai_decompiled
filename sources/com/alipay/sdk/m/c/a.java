package com.alipay.sdk.m.c;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import org.android.agoo.common.AgooConstants;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class a {
    public static final String a = "ro.build.version.emui";
    public static final String b = "hw_sc.build.platform.version";

    public static com.alipay.sdk.m.b.b a(Context context) {
        String brand = Build.getBRAND();
        com.alipay.sdk.m.d.a.b("Device", "Brand", brand);
        if (TextUtils.isEmpty(brand)) {
            return null;
        }
        if (!brand.equalsIgnoreCase("huawei") && !brand.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR) && !brand.equalsIgnoreCase("华为")) {
            if (!brand.equalsIgnoreCase("xiaomi") && !brand.equalsIgnoreCase("redmi") && !brand.equalsIgnoreCase("meitu") && !brand.equalsIgnoreCase("小米") && !brand.equalsIgnoreCase("blackshark")) {
                if (brand.equalsIgnoreCase("vivo")) {
                    return new h();
                }
                if (!brand.equalsIgnoreCase("oppo") && !brand.equalsIgnoreCase("oneplus") && !brand.equalsIgnoreCase("realme")) {
                    if (!brand.equalsIgnoreCase("lenovo") && !brand.equalsIgnoreCase("zuk")) {
                        if (brand.equalsIgnoreCase("nubia")) {
                            return new e();
                        }
                        if (brand.equalsIgnoreCase("samsung")) {
                            return new g();
                        }
                        if (a()) {
                            return new b();
                        }
                        if (brand.equalsIgnoreCase("meizu") || brand.equalsIgnoreCase("mblu")) {
                            return new d();
                        }
                        return null;
                    }
                    return new c();
                }
                return new f();
            }
            return new i();
        }
        return new b();
    }

    public static boolean a() {
        return (TextUtils.isEmpty(a(a)) && TextUtils.isEmpty(a(b))) ? false : true;
    }

    public static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }
}
