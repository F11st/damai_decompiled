package com.taobao.weex.adapter;

import com.taobao.weex.WXSDKInstance;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IWXJscProcessManager {
    boolean enableBackUpThreadCache();

    boolean enableBackupThread();

    long rebootTimeout();

    boolean shouldReboot();

    boolean withException(WXSDKInstance wXSDKInstance);
}
