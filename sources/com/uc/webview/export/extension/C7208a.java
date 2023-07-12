package com.uc.webview.export.extension;

import android.webkit.ValueCallback;
import com.uc.webview.export.extension.ExtImageDecoder;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.extension.a */
/* loaded from: classes11.dex */
final class C7208a implements ValueCallback<Integer> {
    final /* synthetic */ ExtImageDecoder.ImageDecoderListener a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7208a(ExtImageDecoder.ImageDecoderListener imageDecoderListener) {
        this.a = imageDecoderListener;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(Integer num) {
        this.a.onInit(num.intValue());
    }
}
