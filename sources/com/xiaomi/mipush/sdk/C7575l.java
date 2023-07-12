package com.xiaomi.mipush.sdk;

import com.xiaomi.push.ho;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.mipush.sdk.l */
/* loaded from: classes11.dex */
public class C7575l {
    private static HashMap<EnumC7568e, C7576a> a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.mipush.sdk.l$a */
    /* loaded from: classes11.dex */
    public static class C7576a {
        public String a;
        public String b;

        public C7576a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    static {
        a(EnumC7568e.ASSEMBLE_PUSH_HUAWEI, new C7576a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(EnumC7568e.ASSEMBLE_PUSH_FCM, new C7576a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(EnumC7568e.ASSEMBLE_PUSH_COS, new C7576a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(EnumC7568e.ASSEMBLE_PUSH_FTOS, new C7576a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    public static au a(EnumC7568e enumC7568e) {
        int i = C7577m.a[enumC7568e.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return au.UPLOAD_FTOS_TOKEN;
                }
                return au.UPLOAD_COS_TOKEN;
            }
            return au.UPLOAD_FCM_TOKEN;
        }
        return au.UPLOAD_HUAWEI_TOKEN;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static C7576a m655a(EnumC7568e enumC7568e) {
        return a.get(enumC7568e);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static ho m656a(EnumC7568e enumC7568e) {
        return ho.AggregatePushSwitch;
    }

    private static void a(EnumC7568e enumC7568e, C7576a c7576a) {
        if (c7576a != null) {
            a.put(enumC7568e, c7576a);
        }
    }
}
