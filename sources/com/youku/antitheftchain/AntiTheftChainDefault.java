package com.youku.antitheftchain;

import android.content.Context;
import com.youku.antitheftchain.interfaces.AntiTheftChainClientType;
import com.youku.antitheftchain.interfaces.AntiTheftChainParam;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AntiTheftChainDefault extends AntiTheftChainBase {
    @Override // com.youku.antitheftchain.interfaces.AntiTheftChain
    public String getCkey(AntiTheftChainParam antiTheftChainParam) {
        return this.encryptAbility.encrypt(antiTheftChainParam);
    }

    @Override // com.youku.antitheftchain.interfaces.AntiTheftChain
    public void initSecurityGuard(Context context, AntiTheftChainClientType antiTheftChainClientType) {
        this.encryptAbility.initSecurityGuard(context, antiTheftChainClientType, "mwua");
    }

    @Override // com.youku.antitheftchain.interfaces.AntiTheftChain
    public void initSecurityGuard(Context context, AntiTheftChainClientType antiTheftChainClientType, String str) {
        this.encryptAbility.initSecurityGuard(context, antiTheftChainClientType, str);
    }
}
