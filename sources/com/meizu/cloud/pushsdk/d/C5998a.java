package com.meizu.cloud.pushsdk.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.c.c.InterfaceC5954a;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.d.b.AbstractC6002a;
import com.meizu.cloud.pushsdk.d.b.EnumC6006b;
import com.meizu.cloud.pushsdk.d.b.InterfaceC6010f;
import com.meizu.cloud.pushsdk.d.b.a.C6004a;
import com.meizu.cloud.pushsdk.d.e.AbstractC6022a;
import com.meizu.cloud.pushsdk.d.e.C6026c;
import com.meizu.cloud.pushsdk.d.e.a.C6024a;
import com.meizu.cloud.pushsdk.d.f.C6030c;
import com.meizu.cloud.pushsdk.d.f.C6032e;
import com.meizu.cloud.pushsdk.d.f.EnumC6029b;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.d.a */
/* loaded from: classes10.dex */
public class C5998a {
    private static AbstractC6022a a;
    private static BroadcastReceiver b;

    public static AbstractC6022a a(Context context, InterfaceC5954a interfaceC5954a, InterfaceC6010f interfaceC6010f) {
        if (a == null) {
            synchronized (C5998a.class) {
                if (a == null) {
                    AbstractC6022a a2 = a(b(context, interfaceC5954a, interfaceC6010f), (C6026c) null, context);
                    a = a2;
                    a(context, a2);
                }
            }
        }
        return a;
    }

    public static AbstractC6022a a(Context context, boolean z) {
        if (a == null) {
            synchronized (C5998a.class) {
                if (a == null) {
                    a = a(b(context, null, null), (C6026c) null, context);
                }
            }
        }
        DebugLogger.i("PushAndroidTracker", "can upload subject " + z);
        if (z) {
            a.a(a(context));
        }
        return a;
    }

    private static AbstractC6022a a(AbstractC6002a abstractC6002a, C6026c c6026c, Context context) {
        return new C6024a(new AbstractC6022a.C6023a(abstractC6002a, "PushAndroidTracker", context.getPackageCodePath(), context, C6024a.class).a(EnumC6029b.VERBOSE).a(Boolean.FALSE).a(c6026c).a(4));
    }

    private static C6026c a(Context context) {
        return new C6026c.C6027a().a(context).a();
    }

    private static String a() {
        String str = MzSystemUtils.isOverseas() ? PushConstants.URL_ABROAD_STATICS_DOMAIN : PushConstants.URL_STATICS_DOMAIN;
        DebugLogger.e("QuickTracker", "current statics domain is " + str);
        return str;
    }

    private static void a(Context context, final AbstractC6022a abstractC6022a) {
        if (b != null) {
            return;
        }
        b = new BroadcastReceiver() { // from class: com.meizu.cloud.pushsdk.d.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (C6032e.a(context2)) {
                    C6030c.a("QuickTracker", "restart track event: %s", "online true");
                    AbstractC6022a.this.a();
                }
            }
        };
        context.registerReceiver(b, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
    }

    private static AbstractC6002a b(Context context, InterfaceC5954a interfaceC5954a, InterfaceC6010f interfaceC6010f) {
        AbstractC6002a.C6003a a2 = new AbstractC6002a.C6003a(a(), context, C6004a.class).a(interfaceC6010f).a(interfaceC5954a).a(1);
        EnumC6006b enumC6006b = EnumC6006b.DefaultGroup;
        return new C6004a(a2.a(enumC6006b).b(enumC6006b.a()).c(2));
    }
}
