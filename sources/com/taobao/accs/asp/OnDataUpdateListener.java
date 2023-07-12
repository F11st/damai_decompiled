package com.taobao.accs.asp;

import androidx.annotation.Keep;
import com.taobao.aranger.annotation.type.Callback;
import com.taobao.aranger.exception.IPCException;

/* compiled from: Taobao */
@Callback
@Keep
/* loaded from: classes8.dex */
interface OnDataUpdateListener {
    @Keep
    void onDataUpdate(ModifiedRecord modifiedRecord) throws IPCException;
}
