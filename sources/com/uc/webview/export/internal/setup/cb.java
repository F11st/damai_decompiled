package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.UCHashMap;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.cyclone.update.UpdateService;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.update.b;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class cb extends b.a {
    final /* synthetic */ File a;
    final /* synthetic */ bq b;
    final /* synthetic */ by c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb(by byVar, Context context, Callable callable, Map map, File file, bq bqVar) {
        super(context, callable, map);
        this.c = byVar;
        this.a = file;
        this.b = bqVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r2.getAbsolutePath().startsWith(r4.a.getAbsolutePath()) == false) goto L24;
     */
    @Override // com.uc.webview.export.internal.update.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.uc.webview.export.cyclone.update.UpdateService r5) {
        /*
            r4 = this;
            r0 = 0
            com.uc.webview.export.internal.setup.UCMRunningInfo r1 = com.uc.webview.export.internal.setup.UCSetupTask.getTotalLoadedUCM()     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L24
            com.uc.webview.export.internal.setup.bt r1 = r1.ucmPackageInfo     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L24
            java.lang.String r1 = r1.dataDir     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L24
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L32
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L32
            java.lang.String r1 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L32
            java.io.File r3 = r4.a     // Catch: java.lang.Throwable -> L32
            java.lang.String r3 = r3.getAbsolutePath()     // Catch: java.lang.Throwable -> L32
            boolean r1 = r1.startsWith(r3)     // Catch: java.lang.Throwable -> L32
            if (r1 != 0) goto L25
        L24:
            r2 = r0
        L25:
            java.io.File r1 = r4.a     // Catch: java.lang.Throwable -> L32
            r3 = 1
            if (r2 != 0) goto L2e
            java.io.File r2 = r5.getExtractDir()     // Catch: java.lang.Throwable -> L32
        L2e:
            com.uc.webview.export.cyclone.UCCyclone.recursiveDelete(r1, r3, r2)     // Catch: java.lang.Throwable -> L32
            goto L36
        L32:
            r1 = move-exception
            r1.printStackTrace()
        L36:
            super.a(r5)     // Catch: java.lang.Throwable -> L46
            com.uc.webview.export.internal.setup.by r5 = r4.c     // Catch: java.lang.Throwable -> L46
            android.util.Pair r1 = new android.util.Pair     // Catch: java.lang.Throwable -> L46
            java.lang.String r2 = "sdk_ucm_wifi"
            r1.<init>(r2, r0)     // Catch: java.lang.Throwable -> L46
            r5.callbackStat(r1)     // Catch: java.lang.Throwable -> L46
            return
        L46:
            r5 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r5 = r5.getMessage()
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.setup.cb.a(com.uc.webview.export.cyclone.update.UpdateService):void");
    }

    @Override // com.uc.webview.export.internal.update.b.a
    public final void b(UpdateService updateService) {
        synchronized (this.c) {
            by.a(this.c);
        }
        super.b(updateService);
    }

    @Override // com.uc.webview.export.internal.update.b.a
    public final void c(UpdateService updateService) {
        synchronized (this.c) {
            by.a(this.c);
        }
        try {
            if (this.c.getExtraException() == null) {
                Throwable exception = updateService.getException();
                String str = "";
                String str2 = "";
                String str3 = "";
                UCKnownException uCKnownException = exception instanceof UCKnownException ? (UCKnownException) exception : new UCKnownException(exception);
                String str4 = "" + uCKnownException.errCode();
                try {
                    str2 = uCKnownException.getRootCause().getMessage();
                } catch (Throwable unused) {
                }
                try {
                    str3 = String.valueOf(Integer.parseInt(str2.substring(str2.indexOf("httpcode:") + 9)));
                } catch (Throwable unused2) {
                }
                try {
                    str = uCKnownException.getRootCause().getClass().getSimpleName();
                } catch (Throwable unused3) {
                }
                this.c.callbackStat(new Pair<>(IWaStat.SETUP_TASK_UPDATE, new UCHashMap().set("cnt", "1").set("code", str3).set("err", str4).set("cls", str).set("msg", str2)));
            }
            if (updateService.getException() != null) {
                this.c.setExtraException(new UCSetupException(updateService.getException()));
            }
            ValueCallback<CALLBACK_TYPE> callback = this.c.getCallback(UCCore.EVENT_DOWNLOAD_EXCEPTION);
            if (callback != 0) {
                callback.onReceiveValue(this.c);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.c(updateService);
    }

    @Override // com.uc.webview.export.internal.update.b.a
    public final void d(UpdateService updateService) {
        super.d(updateService);
        this.b.a(0, null);
    }

    @Override // com.uc.webview.export.internal.update.b.a
    public final void e(UpdateService updateService) {
        synchronized (this.c) {
            by.b(this.c);
        }
        Throwable exception = updateService.getException();
        super.e(updateService);
        this.b.a(3, exception);
        ValueCallback<CALLBACK_TYPE> callback = this.c.getCallback(UCCore.EVENT_DOWNLOAD_FAILED);
        if (callback != 0) {
            callback.onReceiveValue(this.c);
        }
    }

    @Override // com.uc.webview.export.internal.update.b.a
    public final void f(UpdateService updateService) {
        super.f(updateService);
        this.b.a(4, null);
    }

    @Override // com.uc.webview.export.internal.update.b.a
    public final void g(UpdateService updateService) {
        super.g(updateService);
        File downloadFile = updateService.getDownloadFile();
        if (downloadFile != null) {
            this.c.c = downloadFile.getAbsolutePath();
        }
        ValueCallback<CALLBACK_TYPE> callback = this.c.getCallback(UCCore.EVENT_DOWNLOAD_FILE_DELETE);
        if (callback != 0) {
            callback.onReceiveValue(this.c);
        }
    }

    @Override // com.uc.webview.export.internal.update.b.a
    public final void h(UpdateService updateService) {
        super.h(updateService);
        this.c.mPercent = updateService.getPercent();
        ValueCallback<CALLBACK_TYPE> callback = this.c.getCallback(UCCore.EVENT_UPDATE_PROGRESS);
        if (callback != 0) {
            callback.onReceiveValue(this.c);
        }
    }
}
