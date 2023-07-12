package tb;

import android.util.Log;
import com.orhanobut.logger.LogAdapter;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class g5 implements LogAdapter {
    @Override // com.orhanobut.logger.LogAdapter
    public void d(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // com.orhanobut.logger.LogAdapter
    public void e(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // com.orhanobut.logger.LogAdapter
    public void i(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // com.orhanobut.logger.LogAdapter
    public void v(String str, String str2) {
        Log.v(str, str2);
    }

    @Override // com.orhanobut.logger.LogAdapter
    public void w(String str, String str2) {
        Log.w(str, str2);
    }

    @Override // com.orhanobut.logger.LogAdapter
    public void wtf(String str, String str2) {
        Log.wtf(str, str2);
    }
}
