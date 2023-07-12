package com.taobao.accs;

import androidx.annotation.Keep;
import com.taobao.aranger.annotation.type.Callback;
import com.taobao.aranger.exception.IPCException;

/* compiled from: Taobao */
@Callback
/* loaded from: classes8.dex */
public interface IAppReceiverV1 extends IAppReceiver {
    @Keep
    void onBindApp(int i, String str) throws IPCException;
}
