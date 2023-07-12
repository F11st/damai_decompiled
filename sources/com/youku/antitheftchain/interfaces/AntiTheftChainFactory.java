package com.youku.antitheftchain.interfaces;

import android.util.Log;
import com.youku.antitheftchain.AntiTheftChainDefault;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AntiTheftChainFactory {
    private static String TAG = "AntiTheftChainFactory";
    private static AntiTheftChain antiTheftChain;

    public static AntiTheftChain create() {
        if (antiTheftChain == null) {
            Log.d(TAG, "AntiTheftChain version 2.0.12");
            antiTheftChain = new AntiTheftChainDefault();
        }
        return antiTheftChain;
    }
}
