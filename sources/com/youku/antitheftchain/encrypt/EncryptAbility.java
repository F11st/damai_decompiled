package com.youku.antitheftchain.encrypt;

import android.content.Context;
import com.youku.antitheftchain.interfaces.AntiTheftChainClientType;
import com.youku.antitheftchain.interfaces.AntiTheftChainParam;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface EncryptAbility {
    String encrypt(AntiTheftChainParam antiTheftChainParam);

    void initSecurityGuard(Context context, AntiTheftChainClientType antiTheftChainClientType, String str);
}
