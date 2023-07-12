package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.C7688m;
import com.xiaomi.push.al;
import com.xiaomi.push.ed;
import com.xiaomi.push.ef;
import com.xiaomi.push.ho;
import com.xiaomi.push.ht;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bd;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.mipush.sdk.o */
/* loaded from: classes11.dex */
public class C7579o {
    public static void a(Context context, Intent intent, Uri uri) {
        ed a;
        ef efVar;
        if (context == null) {
            return;
        }
        ao.a(context).m620a();
        if (ed.a(context.getApplicationContext()).m855a() == null) {
            ed.a(context.getApplicationContext()).a(C7564b.m629a(context.getApplicationContext()).m630a(), context.getPackageName(), ba.a(context.getApplicationContext()).a(ho.AwakeInfoUploadWaySwitch.a(), 0), new C7566c());
            ba.a(context).a(new C7581q(102, "awake online config", context));
        }
        if ((context instanceof Activity) && intent != null) {
            a = ed.a(context.getApplicationContext());
            efVar = ef.ACTIVITY;
        } else if (!(context instanceof Service) || intent == null) {
            if (uri == null || TextUtils.isEmpty(uri.toString())) {
                return;
            }
            ed.a(context.getApplicationContext()).a(ef.PROVIDER, context, (Intent) null, uri.toString());
            return;
        } else if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            a = ed.a(context.getApplicationContext());
            efVar = ef.SERVICE_COMPONENT;
        } else {
            a = ed.a(context.getApplicationContext());
            efVar = ef.SERVICE_ACTION;
        }
        a.a(efVar, context, intent, (String) null);
    }

    private static void a(Context context, ii iiVar) {
        boolean a = ba.a(context).a(ho.AwakeAppPingSwitch.a(), false);
        int a2 = ba.a(context).a(ho.AwakeAppPingFrequency.a(), 0);
        if (a2 >= 0 && a2 < 30) {
            AbstractC7535b.c("aw_ping: frquency need > 30s.");
            a2 = 30;
        }
        boolean z = a2 >= 0 ? a : false;
        if (!C7688m.m1118a()) {
            a(context, iiVar, z, a2);
        } else if (z) {
            com.xiaomi.push.al.a(context.getApplicationContext()).a((al.AbstractRunnableC7597a) new C7580p(iiVar, context), a2);
        }
    }

    public static final <T extends iu<T, ?>> void a(Context context, T t, boolean z, int i) {
        byte[] a = it.a(t);
        if (a == null) {
            AbstractC7535b.m586a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_help_ping");
        intent.putExtra("extra_help_ping_switch", z);
        intent.putExtra("extra_help_ping_frequency", i);
        intent.putExtra("mipush_payload", a);
        intent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        ao.a(context).m621a(intent);
    }

    public static void a(Context context, String str) {
        AbstractC7535b.m586a("aw_ping : send aw_ping cmd and content to push service from 3rd app");
        HashMap hashMap = new HashMap();
        hashMap.put("awake_info", str);
        hashMap.put("event_type", String.valueOf(9999));
        hashMap.put(SocialConstants.PARAM_COMMENT, "ping message");
        ii iiVar = new ii();
        iiVar.b(C7564b.m629a(context).m630a());
        iiVar.d(context.getPackageName());
        iiVar.c(ht.AwakeAppResponse.f497a);
        iiVar.a(bd.a());
        iiVar.f636a = hashMap;
        a(context, iiVar);
    }

    public static void a(Context context, String str, int i, String str2) {
        ii iiVar = new ii();
        iiVar.b(str);
        iiVar.a(new HashMap());
        iiVar.m1038a().put("extra_aw_app_online_cmd", String.valueOf(i));
        iiVar.m1038a().put("extra_help_aw_info", str2);
        iiVar.a(bd.a());
        byte[] a = it.a(iiVar);
        if (a == null) {
            AbstractC7535b.m586a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_aw_app_logic");
        intent.putExtra("mipush_payload", a);
        ao.a(context).m621a(intent);
    }
}
