package com.taobao.android.protodb;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class Record extends NativeBridgedObject {
    public Record(long j) {
        super(j);
    }

    @Keep
    private native double nativeGetDouble(int i);

    @Keep
    private native double nativeGetDoubleByColumnName(String str);

    @Keep
    private native float nativeGetFloat(int i);

    @Keep
    private native float nativeGetFloatByColumnName(String str);

    @Keep
    private native int nativeGetInt(int i);

    @Keep
    private native int nativeGetIntByColumnName(String str);

    @Keep
    private native long nativeGetLong(int i);

    @Keep
    private native long nativeGetLongByColumnName(String str);

    @Keep
    private native String nativeGetString(int i);

    @Keep
    private native String nativeGetStringByColumnName(String str);

    public double getDouble(int i) {
        return nativeGetDouble(i);
    }

    public float getFloat(int i) {
        return nativeGetFloat(i);
    }

    public int getInt(int i) {
        return nativeGetInt(i);
    }

    public Long getLong(int i) {
        return Long.valueOf(nativeGetLong(i));
    }

    public String getString(int i) {
        return nativeGetString(i);
    }

    public double getDouble(String str) {
        return nativeGetDoubleByColumnName(str);
    }

    public float getFloat(String str) {
        return nativeGetFloatByColumnName(str);
    }

    public int getInt(String str) {
        return nativeGetIntByColumnName(str);
    }

    public long getLong(String str) {
        return nativeGetLongByColumnName(str);
    }

    public String getString(String str) {
        return nativeGetStringByColumnName(str);
    }
}
