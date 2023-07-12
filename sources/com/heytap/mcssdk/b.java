package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import java.util.List;
import tb.b53;
import tb.iw2;
import tb.o73;
import tb.z53;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b {
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
                            for (com.heytap.mcssdk.e.c cVar : c.m().r()) {
                                if (cVar != null) {
                                    cVar.a(context, baseMode, iDataMessageCallBackService);
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
