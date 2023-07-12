package com.taobao.android;

import com.taobao.orange.OrangeConfig;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AliConfigImp implements AliConfigInterface {
    private static final AliConfigImp a = new AliConfigImp(OrangeConfig.getInstance());

    public AliConfigImp(OrangeConfig orangeConfig) {
        new HashMap();
    }

    public static AliConfigImp getInstance() {
        return a;
    }
}
