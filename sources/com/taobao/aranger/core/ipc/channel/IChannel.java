package com.taobao.aranger.core.ipc.channel;

import com.taobao.aranger.exception.IPCException;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
interface IChannel {
    void internalRecycle(List<String> list) throws IPCException;
}
