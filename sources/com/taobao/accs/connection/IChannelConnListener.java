package com.taobao.accs.connection;

import androidx.annotation.Keep;
import com.taobao.aranger.annotation.type.Callback;
import com.taobao.aranger.exception.IPCException;

/* compiled from: Taobao */
@Callback
@Keep
/* loaded from: classes8.dex */
public interface IChannelConnListener {
    @Keep
    void onStart() throws IPCException;
}
