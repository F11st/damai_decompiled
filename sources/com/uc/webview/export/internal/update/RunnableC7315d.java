package com.uc.webview.export.internal.update;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.utility.C7336i;
import com.uc.webview.export.internal.utility.Log;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.update.d */
/* loaded from: classes11.dex */
public final class RunnableC7315d implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ Callable c;
    final /* synthetic */ Map d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7315d(Context context, String str, Callable callable, Map map) {
        this.a = context;
        this.b = str;
        this.c = callable;
        this.d = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        while (!SDKFactory.b()) {
            try {
                Thread.sleep(200L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (SDKFactory.c((Long) 1L).booleanValue()) {
            Log.i("UpdateUtils", "force system webview, don't download uc player");
        } else if (SDKFactory.c(Long.valueOf((long) PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)).booleanValue()) {
            Log.i("UpdateUtils", "use ucmobile apollo, don't download uc player");
        } else if (!C7336i.a().b(UCCore.OPTION_USE_UC_PLAYER)) {
            Log.i("UpdateUtils", "sUseUCPlayer is false, don't download uc player");
        } else {
            try {
                C7312b.b(this.a, this.b, this.c, this.d);
            } catch (Throwable th) {
                Log.i("UpdateUtils", "updateUCPlayer failed", th);
            }
        }
    }
}
