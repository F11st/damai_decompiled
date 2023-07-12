package com.youku.antitheftchain.interfaces;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface AntiTheftChain {
    String getCkey(AntiTheftChainParam antiTheftChainParam);

    void initSecurityGuard(Context context, AntiTheftChainClientType antiTheftChainClientType);

    void initSecurityGuard(Context context, AntiTheftChainClientType antiTheftChainClientType, String str);
}
