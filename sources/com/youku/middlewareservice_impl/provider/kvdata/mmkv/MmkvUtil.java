package com.youku.middlewareservice_impl.provider.kvdata.mmkv;

import androidx.annotation.Keep;
import com.tencent.mmkv.MMKV;

/* compiled from: Taobao */
@Keep
/* loaded from: classes13.dex */
public class MmkvUtil {
    public static final String TAG = "MmkvUtil";

    public static final MMKV getMMKV(String str) {
        return MMKV.mmkvWithID(str);
    }

    public static final MMKV getMMKVMultiProcess(String str) {
        return MMKV.mmkvWithID(str, 2);
    }
}
