package com.youku.alixplayer.util;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes5.dex */
public class NativeMap implements Destructable {
    private long mNativeId;

    static {
        SystemSoLoader.load("alixplayer");
    }

    public NativeMap() {
        this.mNativeId = init();
    }

    private NativeMap(long j) {
        this.mNativeId = j;
    }

    public native void clear();

    public native void deinit();

    @Override // com.youku.alixplayer.util.Destructable
    public void destruct() {
        deinit();
    }

    public void finalize() {
        destruct();
    }

    public native String get(String str);

    public native String[] getAllKVs();

    public native long init();

    public native void put(String str, String str2);

    public native void putAll(NativeMap nativeMap);

    public native void remove(String str);
}
