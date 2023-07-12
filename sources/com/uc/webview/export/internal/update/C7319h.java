package com.uc.webview.export.internal.update;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.update.UpdateService;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.update.C7312b;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.update.h */
/* loaded from: classes11.dex */
public final class C7319h extends C7312b.C7313a {
    final /* synthetic */ File a;
    final /* synthetic */ ValueCallback b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7319h(Context context, Callable callable, Map map, File file, ValueCallback valueCallback) {
        super(context, callable, map);
        this.a = file;
        this.b = valueCallback;
    }

    @Override // com.uc.webview.export.internal.update.C7312b.C7313a
    public final void a(UpdateService updateService, Throwable th) {
        SDKFactory.a((Long) 1024L);
        if (th != null) {
            SDKFactory.p.put(IWaStat.VIDEO_ERROR_CODE_UPDATE_CHECK_REQUEST, Integer.valueOf(th.getClass().getName().hashCode()));
        } else {
            SDKFactory.a((Long) 2048L);
        }
    }

    @Override // com.uc.webview.export.internal.update.C7312b.C7313a
    public final void b(UpdateService updateService) {
        Throwable exception = updateService.getException();
        if (exception != null) {
            SDKFactory.p.put(IWaStat.VIDEO_ERROR_CODE_DOWNLOAD, Integer.valueOf(exception.getClass().getName().hashCode()));
        }
        super.b(updateService);
    }

    @Override // com.uc.webview.export.internal.update.C7312b.C7313a
    public final void d(UpdateService updateService) {
        C7312b.C7313a.a(IWaStat.VIDEO_DOWNLOAD_SUCCESS, (String) null);
        C7311a.a(this.d);
        super.d(updateService);
    }

    @Override // com.uc.webview.export.internal.update.C7312b.C7313a
    public final void f(UpdateService updateService) {
        super.f(updateService);
        try {
            Thread.sleep(10000L);
            File extractDir = updateService.getExtractDir();
            if (C7311a.a(extractDir)) {
                UCCyclone.recursiveDelete(this.a, true, extractDir);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.uc.webview.export.internal.update.C7312b.C7313a
    public final void i(UpdateService updateService) {
        C7312b.C7313a.a(IWaStat.VIDEO_DOWNLOAD, (String) null);
        SDKFactory.a(Long.valueOf((long) PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID));
    }

    @Override // com.uc.webview.export.internal.update.C7312b.C7313a
    public final void j(UpdateService updateService) {
        SDKFactory.a(Long.valueOf((long) PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH));
        super.j(updateService);
    }

    @Override // com.uc.webview.export.internal.update.C7312b.C7313a
    public final void k(UpdateService updateService) {
        SDKFactory.a((Long) 4096L);
        super.k(updateService);
    }

    @Override // com.uc.webview.export.internal.update.C7312b.C7313a
    public final void l(UpdateService updateService) {
        C7312b.C7313a.a(IWaStat.VIDEO_UNZIP, (String) null);
        SDKFactory.a(Long.valueOf((long) PlaybackStateCompat.ACTION_PLAY_FROM_URI));
        try {
            super.l(updateService);
            C7312b.C7313a.a(IWaStat.VIDEO_UNZIP_SUCCESS, (String) null);
        } catch (Throwable th) {
            SDKFactory.p.put(IWaStat.VIDEO_ERROR_CODE_UNZIP, Integer.valueOf(th.getClass().getName().hashCode()));
            throw th;
        }
    }

    @Override // com.uc.webview.export.internal.update.C7312b.C7313a
    public final void a() {
        SDKFactory.a(Long.valueOf((long) PlaybackStateCompat.ACTION_PREPARE));
    }

    @Override // com.uc.webview.export.internal.update.C7312b.C7313a
    public final ValueCallback<Object[]> b() {
        return this.b;
    }
}
