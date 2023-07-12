package com.uc.webview.export.internal.interfaces;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.uc.webview.export.annotations.Interface;

/* compiled from: Taobao */
@Interface
/* loaded from: classes11.dex */
public interface IOpenFileChooser {
    public static final int FLAG = 100;

    void openFileChooser(ValueCallback<Uri> valueCallback);

    void openFileChooser(ValueCallback<Uri> valueCallback, String str);

    void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2);
}
