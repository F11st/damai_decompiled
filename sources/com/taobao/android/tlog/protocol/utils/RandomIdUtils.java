package com.taobao.android.tlog.protocol.utils;

import android.util.Log;
import java.util.UUID;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class RandomIdUtils {
    public static String getRandomId() {
        try {
            return UUID.randomUUID().toString().replace("-", "");
        } catch (Exception e) {
            Log.w("randomIdCreater", "get random num failure", e);
            return null;
        }
    }
}
