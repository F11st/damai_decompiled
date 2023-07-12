package com.uploader.implement;

import android.util.Log;
import com.uploader.export.IUploaderLog;

/* compiled from: Taobao */
/* renamed from: com.uploader.implement.a */
/* loaded from: classes11.dex */
public class C7364a {
    private static volatile IUploaderLog a = null;
    private static volatile int b = 31;

    public static final int a(int i, String str, String str2) {
        return b(i, str, str2, null);
    }

    public static final int b(int i, String str, String str2, Throwable th) {
        if (str != null) {
            str = "<aus>" + str;
        }
        IUploaderLog iUploaderLog = a;
        if (iUploaderLog != null) {
            return iUploaderLog.print(i, str, str2, th);
        }
        if ((b & i) == 0) {
            return 0;
        }
        if (i == 1) {
            if (th != null) {
                str2 = str2 + '\n' + Log.getStackTraceString(th);
            }
            return Log.println(2, str, str2);
        } else if (i == 2) {
            if (th != null) {
                str2 = str2 + '\n' + Log.getStackTraceString(th);
            }
            return Log.println(3, str, str2);
        } else if (i == 4) {
            if (th != null) {
                str2 = str2 + '\n' + Log.getStackTraceString(th);
            }
            return Log.println(4, str, str2);
        } else if (i == 8) {
            if (th != null) {
                str2 = str2 + '\n' + Log.getStackTraceString(th);
            }
            return Log.println(5, str, str2);
        } else if (i != 16) {
            return 0;
        } else {
            if (th != null) {
                str2 = str2 + '\n' + Log.getStackTraceString(th);
            }
            return Log.println(6, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void c(IUploaderLog iUploaderLog) {
        a = iUploaderLog;
    }

    public static final boolean d(int i) {
        IUploaderLog iUploaderLog = a;
        if (iUploaderLog != null) {
            return iUploaderLog.isEnabled(i);
        }
        return (i & b) != 0;
    }
}
