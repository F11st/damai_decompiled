package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class dz {
    public static void a(Context context, String str, int i, String str2) {
        al.a(context).a(new ea(context, str, i, str2));
    }

    private static void a(Context context, HashMap<String, String> hashMap) {
        eh m855a = ed.a(context).m855a();
        if (m855a != null) {
            m855a.a(context, hashMap);
        }
    }

    private static void b(Context context, HashMap<String, String> hashMap) {
        eh m855a = ed.a(context).m855a();
        if (m855a != null) {
            m855a.c(context, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str, int i, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("awake_info", str);
            hashMap.put("event_type", String.valueOf(i));
            hashMap.put(SocialConstants.PARAM_COMMENT, str2);
            int a = ed.a(context).a();
            if (a != 1) {
                if (a != 2) {
                    if (a == 3) {
                        a(context, hashMap);
                    }
                }
                c(context, hashMap);
            } else {
                a(context, hashMap);
            }
            b(context, hashMap);
        } catch (Exception e) {
            AbstractC7535b.a(e);
        }
    }

    private static void c(Context context, HashMap<String, String> hashMap) {
        eh m855a = ed.a(context).m855a();
        if (m855a != null) {
            m855a.b(context, hashMap);
        }
    }
}
