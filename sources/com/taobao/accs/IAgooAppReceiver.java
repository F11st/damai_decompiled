package com.taobao.accs;

import androidx.annotation.Keep;
import com.taobao.aranger.annotation.type.Callback;
import com.taobao.aranger.exception.IPCException;

/* compiled from: Taobao */
@Callback
/* loaded from: classes8.dex */
public interface IAgooAppReceiver extends IAppReceiverV1 {
    @Keep
    String getAppkey() throws IPCException;

    @Override // com.taobao.accs.IAppReceiverV1
    @Keep
    void onBindApp(int i, String str) throws IPCException;
}
