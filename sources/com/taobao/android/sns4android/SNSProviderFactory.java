package com.taobao.android.sns4android;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SNSProviderFactory {
    private static volatile SNSProviderFactory instance;
    private Map<SNSPlatform, SNSSignInAbstractHelper> mServiceProviderMap = new HashMap();

    private SNSProviderFactory() {
    }

    public static SNSProviderFactory getInstance() {
        if (instance == null) {
            synchronized (SNSProviderFactory.class) {
                if (instance == null) {
                    instance = new SNSProviderFactory();
                }
            }
        }
        return instance;
    }

    public void cleanUp() {
        this.mServiceProviderMap.clear();
    }

    public SNSSignInAbstractHelper getSNSProvider(SNSPlatform sNSPlatform) {
        return this.mServiceProviderMap.get(sNSPlatform);
    }

    public void putSNSProvider(SNSPlatform sNSPlatform, SNSSignInAbstractHelper sNSSignInAbstractHelper) {
        this.mServiceProviderMap.put(sNSPlatform, sNSSignInAbstractHelper);
    }
}
