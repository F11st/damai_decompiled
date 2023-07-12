package com.taobao.accs.base;

import androidx.annotation.Keep;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.aranger.annotation.type.Callback;
import com.taobao.aranger.exception.IPCException;

/* compiled from: Taobao */
@Callback
@Keep
/* loaded from: classes8.dex */
public interface AccsConnectStateListener {
    @Keep
    void onConnected(TaoBaseService.ConnectInfo connectInfo) throws IPCException;

    @Keep
    void onDisconnected(TaoBaseService.ConnectInfo connectInfo) throws IPCException;
}
