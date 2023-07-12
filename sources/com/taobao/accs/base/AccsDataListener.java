package com.taobao.accs.base;

import androidx.annotation.Keep;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.aranger.annotation.type.Callback;
import com.taobao.aranger.exception.IPCException;

/* compiled from: Taobao */
@Callback
/* loaded from: classes8.dex */
public interface AccsDataListener {
    @Keep
    void onAntiBrush(boolean z, TaoBaseService.ExtraInfo extraInfo) throws IPCException;

    @Keep
    void onBind(String str, int i, TaoBaseService.ExtraInfo extraInfo) throws IPCException;

    @Keep
    void onConnected(TaoBaseService.ConnectInfo connectInfo) throws IPCException;

    @Keep
    void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) throws IPCException;

    @Keep
    void onDisconnected(TaoBaseService.ConnectInfo connectInfo) throws IPCException;

    @Keep
    void onResponse(String str, String str2, int i, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) throws IPCException;

    @Keep
    void onSendData(String str, String str2, int i, TaoBaseService.ExtraInfo extraInfo) throws IPCException;

    @Keep
    void onUnbind(String str, int i, TaoBaseService.ExtraInfo extraInfo) throws IPCException;
}
