package com.uc.webview.export.internal.update;

import android.content.Context;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.utility.Log;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.update.c */
/* loaded from: classes11.dex */
public final class RunnableC7314c implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ Callable c;
    final /* synthetic */ Map d;
    final /* synthetic */ Map e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7314c(Context context, String str, Callable callable, Map map, Map map2) {
        this.a = context;
        this.b = str;
        this.c = callable;
        this.d = map;
        this.e = map2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = 10;
        while (true) {
            if (!SDKFactory.b() && !SDKFactory.j) {
                int i2 = i - 1;
                if (i <= 0) {
                    i = i2;
                    break;
                }
                try {
                    Thread.sleep(200L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2;
            } else {
                break;
            }
        }
        if (i > 0) {
            try {
                C7312b.b(this.a, this.b, this.c, this.d, this.e);
                return;
            } catch (Throwable th) {
                Log.e("UpdateUtils", "updateUCCore failed", th);
                return;
            }
        }
        throw new UCSetupException("Waiting timeout for UCCore initialization finish!");
    }
}
