package com.uc.webview.export.extension;

import android.webkit.ValueCallback;
import com.uc.webview.export.extension.ExtImageDecoder;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class a implements ValueCallback<Integer> {
    final /* synthetic */ ExtImageDecoder.ImageDecoderListener a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ExtImageDecoder.ImageDecoderListener imageDecoderListener) {
        this.a = imageDecoderListener;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(Integer num) {
        this.a.onInit(num.intValue());
    }
}
