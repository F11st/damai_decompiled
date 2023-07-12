package com.tencent.tauth;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IUiListener {
    void onCancel();

    void onComplete(Object obj);

    void onError(UiError uiError);

    void onWarning(int i);
}
