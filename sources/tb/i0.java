package tb;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class i0 {
    public static String a(long j) {
        if (j >= 0 && j < 1024) {
            return j + " B";
        } else if (j >= 1024 && j < 1048576) {
            return (j / 1024) + " KB";
        } else if (j >= 1048576 && j < 1073741824) {
            return (j / 1048576) + " MB";
        } else if (j >= 1073741824 && j < 1099511627776L) {
            return (j / 1073741824) + " GB";
        } else if (j >= 1099511627776L) {
            return (j / 1099511627776L) + " TB";
        } else {
            return j + " Bytes";
        }
    }

    private static String b(Object[] objArr) {
        String str = "";
        for (int i = 0; i < objArr.length; i++) {
            str = str + objArr[i] + " ";
        }
        return str;
    }

    public static int c(String str, Object... objArr) {
        return 0;
    }

    public static int d(String str, Throwable th, Object... objArr) {
        return Log.e(str, b(objArr), th);
    }

    public static int e(String str, Object... objArr) {
        return Log.e(str, b(objArr));
    }
}
