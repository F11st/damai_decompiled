package com.taobao.android.protodb;

import android.app.Application;
import androidx.annotation.Keep;
import java.io.File;
import tb.C9121f0;
import tb.n71;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class Series extends NativeBridgedObject {
    public Series(long j) {
        super(j);
    }

    @Keep
    private native void nativeAppendRecord(String str, String str2, ValueWrapper[] valueWrapperArr);

    @Keep
    private native long nativeGetRecord(String str);

    @Keep
    private static native long nativeOpen(String str, Config config);

    public static Series open(String str, Config config) {
        Application a = C9121f0.a();
        if (a != null) {
            if (NativeBridgedObject.sNativeLibraryLoaded) {
                long nativeOpen = nativeOpen(a.getFilesDir() + File.separator + "lsdb-series-" + str, config);
                if (nativeOpen > 0) {
                    return new Series(nativeOpen);
                }
                return null;
            }
            return null;
        }
        throw new RuntimeException("failed to get android context!");
    }

    public void appendRecord(n71 n71Var, String str, Object... objArr) {
        ValueWrapper[] valueWrapperArr = new ValueWrapper[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj instanceof String) {
                valueWrapperArr[i] = ValueWrapper.stringValue((String) obj);
            } else if (obj instanceof Number) {
                if (obj instanceof Integer) {
                    valueWrapperArr[i] = ValueWrapper.intValue(((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    valueWrapperArr[i] = ValueWrapper.longValue(((Long) obj).longValue());
                } else if (obj instanceof Float) {
                    valueWrapperArr[i] = ValueWrapper.floatValue(((Float) obj).floatValue());
                } else if (obj instanceof Double) {
                    valueWrapperArr[i] = ValueWrapper.doubleValue(((Double) obj).doubleValue());
                }
            }
        }
        nativeAppendRecord(n71Var.a(), str, valueWrapperArr);
    }

    public Record getRecord(n71 n71Var) {
        long nativeGetRecord = nativeGetRecord(n71Var.a());
        if (nativeGetRecord > 0) {
            return new Record(nativeGetRecord);
        }
        return null;
    }

    public static Series open(String str, String str2, Config config) {
        if (NativeBridgedObject.sNativeLibraryLoaded) {
            long nativeOpen = nativeOpen(str + File.separator + "lsdb-series-" + str2, config);
            if (nativeOpen > 0) {
                return new Series(nativeOpen);
            }
            return null;
        }
        return null;
    }
}
