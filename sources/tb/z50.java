package tb;

import android.util.Log;
import com.alibaba.android.onescheduler.ILogger;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class z50 implements ILogger {
    @Override // com.alibaba.android.onescheduler.ILogger
    public int d(String str, String str2) {
        return Log.d(str, str2);
    }

    @Override // com.alibaba.android.onescheduler.ILogger
    public int e(String str, String str2) {
        return Log.e(str, str2);
    }

    @Override // com.alibaba.android.onescheduler.ILogger
    public int i(String str, String str2) {
        return Log.i(str, str2);
    }

    @Override // com.alibaba.android.onescheduler.ILogger
    public int v(String str, String str2) {
        return Log.v(str, str2);
    }

    @Override // com.alibaba.android.onescheduler.ILogger
    public int w(String str, String str2) {
        return Log.w(str, str2);
    }

    @Override // com.alibaba.android.onescheduler.ILogger
    public int wtf(String str, String str2) {
        return Log.wtf(str, str2);
    }

    @Override // com.alibaba.android.onescheduler.ILogger
    public int d(String str, String str2, Throwable th) {
        return Log.d(str, str2, th);
    }

    @Override // com.alibaba.android.onescheduler.ILogger
    public int e(String str, String str2, Throwable th) {
        return Log.e(str, str2, th);
    }

    @Override // com.alibaba.android.onescheduler.ILogger
    public int i(String str, String str2, Throwable th) {
        return Log.i(str, str2, th);
    }

    @Override // com.alibaba.android.onescheduler.ILogger
    public int v(String str, String str2, Throwable th) {
        return Log.v(str, str2, th);
    }

    @Override // com.alibaba.android.onescheduler.ILogger
    public int w(String str, String str2, Throwable th) {
        return Log.w(str, str2, th);
    }

    @Override // com.alibaba.android.onescheduler.ILogger
    public int wtf(String str, Throwable th) {
        return Log.wtf(str, th);
    }

    @Override // com.alibaba.android.onescheduler.ILogger
    public int w(String str, Throwable th) {
        return Log.w(str, th);
    }

    @Override // com.alibaba.android.onescheduler.ILogger
    public int wtf(String str, String str2, Throwable th) {
        return Log.wtf(str, str2, th);
    }
}
