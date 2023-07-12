package com.uc.webview.export.internal.update;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.update.g */
/* loaded from: classes11.dex */
public final class C7318g implements ValueCallback<Object[]> {
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(Object[] objArr) {
        Object[] objArr2 = objArr;
        if (((Integer) objArr2[0]).intValue() != 8) {
            return;
        }
        SDKFactory.p.put(IWaStat.VIDEO_ERROR_CODE_VERIFY, (Integer) objArr2[1]);
    }
}
