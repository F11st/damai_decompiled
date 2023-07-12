package com.alipay.sdk.m.j;

import android.text.TextUtils;
import com.alipay.sdk.app.PayResultActivity;
import com.alipay.sdk.m.l.C4230a;
import com.alipay.sdk.m.m.C4245a;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.j.a */
/* loaded from: classes12.dex */
public class C4211a {
    public static String a = "";
    public static final C4245a.C4247b b;
    public static final C4245a.C4247b c;
    public static List<C4245a.C4247b> d;

    static {
        C4245a.C4247b c4247b = new C4245a.C4247b("com.eg.android.AlipayGphone", 73, C4230a.k);
        b = c4247b;
        c = new C4245a.C4247b(PayResultActivity.d, 40, "e6b1bdcb890370f2f2419fe06d0fdf7628ad0083d52da1ecfe991164711bbf9297e75353de96f1740695d07610567b1240549af9cbd87d06919ac31c859ad37ab6907c311b4756e1e208775989a4f691bff4bbbc58174d2a96b1d0d970a05114d7ee57dfc33b1bafaf6e0d820e838427018b6435f903df04ba7fd34d73f843df9434b164e0220baabb10c8978c3f4c6b7da79d8220a968356d15090dea07df9606f665cbec14d218dd3d691cce2866a58840971b6a57b76af88b1a65fdffd2c080281a6ab20be5879e0330eb7ff70871ce684e7174ada5dc3159c461375a0796b17ce7beca83cf34f65976d237aee993db48d34a4e344f4d8b7e99119168bdd7");
        d = Collections.singletonList(c4247b);
    }

    public static void a(String str) {
        a = str;
        str.hashCode();
        if (!str.equals("hk")) {
            d = Collections.singletonList(b);
        } else {
            d = Collections.singletonList(c);
        }
    }

    public static boolean b() {
        return TextUtils.isEmpty(a) || TextUtils.equals(AdvanceSetting.CLEAR_NOTIFICATION, a);
    }

    public static String a() {
        return a;
    }
}
