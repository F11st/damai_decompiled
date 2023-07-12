package com.youku.antitheftchain;

import com.youku.antitheftchain.encrypt.EncryptAbility;
import com.youku.antitheftchain.encrypt.EncryptAbilityImpl;
import com.youku.antitheftchain.interfaces.AntiTheftChain;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class AntiTheftChainBase implements AntiTheftChain {
    protected EncryptAbility encryptAbility = new EncryptAbilityImpl();
}
