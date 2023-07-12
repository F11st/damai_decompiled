package com.uc.webview.export.extension;

import android.os.Bundle;
import android.webkit.ValueCallback;
import com.uc.webview.export.extension.ExtImageDecoder;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.extension.b */
/* loaded from: classes11.dex */
final class C7209b implements ValueCallback<Bundle> {
    final /* synthetic */ ExtImageDecoder.ImageDecoderListener a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7209b(ExtImageDecoder.ImageDecoderListener imageDecoderListener) {
        this.a = imageDecoderListener;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(Bundle bundle) {
        Bundle bundle2 = bundle;
        this.a.onDecode(bundle2.getString("url"), bundle2.getString("format"), bundle2.getInt("result"));
    }
}
