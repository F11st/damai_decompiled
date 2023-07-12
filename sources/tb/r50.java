package tb;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class r50 extends wh0 {
    private int d = 5;

    @Override // com.taobao.tcommon.log.FormatLog
    public void d(String str, String str2, Object... objArr) {
        Log.d(str, a(str2, objArr));
    }

    @Override // com.taobao.tcommon.log.FormatLog
    public void e(String str, String str2, Object... objArr) {
        Log.e(str, a(str2, objArr));
    }

    @Override // com.taobao.tcommon.log.FormatLog
    public void i(String str, String str2, Object... objArr) {
        Log.i(str, a(str2, objArr));
    }

    @Override // com.taobao.tcommon.log.FormatLog
    public boolean isLoggable(int i) {
        return i >= this.d;
    }

    @Override // com.taobao.tcommon.log.FormatLog
    public void setMinLevel(int i) {
        this.d = i;
    }

    @Override // com.taobao.tcommon.log.FormatLog
    public void v(String str, String str2, Object... objArr) {
        Log.v(str, a(str2, objArr));
    }

    @Override // com.taobao.tcommon.log.FormatLog
    public void w(String str, String str2, Object... objArr) {
        Log.w(str, a(str2, objArr));
    }

    @Override // com.taobao.tcommon.log.FormatLog
    public void e(int i, String str, String str2) {
        Log.e(str, str2);
    }
}
