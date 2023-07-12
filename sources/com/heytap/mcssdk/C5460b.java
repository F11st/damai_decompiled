package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.e.InterfaceC5468c;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import java.util.List;
import tb.b53;
import tb.iw2;
import tb.o73;
import tb.z53;

/* compiled from: Taobao */
/* renamed from: com.heytap.mcssdk.b */
/* loaded from: classes10.dex */
public class C5460b {
    public static void a(final Context context, final Intent intent, final IDataMessageCallBackService iDataMessageCallBackService) {
        if (context == null) {
            z53.b("context is null , please check param of parseIntent()");
        } else if (intent == null) {
            z53.b("intent is null , please check param of parseIntent()");
        } else if (iDataMessageCallBackService == null) {
            z53.b("callback is null , please check param of parseIntent()");
        } else if (iw2.h(context)) {
            o73.a(new Runnable() { // from class: com.heytap.mcssdk.b.1
                @Override // java.lang.Runnable
                public void run() {
                    List<BaseMode> a = b53.a(context, intent);
                    if (a == null) {
                        return;
                    }
                    for (BaseMode baseMode : a) {
                        if (baseMode != null) {
                            for (InterfaceC5468c interfaceC5468c : C5462c.m().r()) {
                                if (interfaceC5468c != null) {
                                    interfaceC5468c.a(context, baseMode, iDataMessageCallBackService);
                                }
                            }
                        }
                    }
                }
            });
        } else {
            z53.b("push is null ,please check system has push");
        }
    }
}
