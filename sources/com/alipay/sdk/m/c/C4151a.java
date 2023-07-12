package com.alipay.sdk.m.c;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.sdk.m.b.InterfaceC4143b;
import com.alipay.sdk.m.d.C4169a;
import org.android.agoo.common.AgooConstants;
import tb.gn1;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.c.a */
/* loaded from: classes12.dex */
public class C4151a {
    public static final String a = "ro.build.version.emui";
    public static final String b = "hw_sc.build.platform.version";

    public static InterfaceC4143b a(Context context) {
        String brand = Build.getBRAND();
        C4169a.b("Device", "Brand", brand);
        if (TextUtils.isEmpty(brand)) {
            return null;
        }
        if (!brand.equalsIgnoreCase("huawei") && !brand.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR) && !brand.equalsIgnoreCase("华为")) {
            if (!brand.equalsIgnoreCase("xiaomi") && !brand.equalsIgnoreCase("redmi") && !brand.equalsIgnoreCase("meitu") && !brand.equalsIgnoreCase("小米") && !brand.equalsIgnoreCase("blackshark")) {
                if (brand.equalsIgnoreCase("vivo")) {
                    return new C4163h();
                }
                if (!brand.equalsIgnoreCase("oppo") && !brand.equalsIgnoreCase("oneplus") && !brand.equalsIgnoreCase("realme")) {
                    if (!brand.equalsIgnoreCase("lenovo") && !brand.equalsIgnoreCase("zuk")) {
                        if (brand.equalsIgnoreCase("nubia")) {
                            return new C4158e();
                        }
                        if (brand.equalsIgnoreCase("samsung")) {
                            return new C4160g();
                        }
                        if (a()) {
                            return new C4152b();
                        }
                        if (brand.equalsIgnoreCase("meizu") || brand.equalsIgnoreCase("mblu")) {
                            return new C4157d();
                        }
                        return null;
                    }
                    return new C4156c();
                }
                return new C4159f();
            }
            return new C4164i();
        }
        return new C4152b();
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
