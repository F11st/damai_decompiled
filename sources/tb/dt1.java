package tb;

import android.util.Log;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.norm.ILogAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class dt1 {
    public static boolean a = true;
    public static boolean b;

    public static void a(String str) {
        try {
            if (a) {
                Log.e("PopLayer", str);
            }
            ArrayList<ILogAdapter> logAdapters = PopLayer.getReference().getLogAdapters();
            if (logAdapters == null || logAdapters.isEmpty() || !PopLayer.getReference().isLogOutputMode) {
                return;
            }
            Iterator<ILogAdapter> it = logAdapters.iterator();
            while (it.hasNext()) {
                it.next().Loge(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(String str, Object... objArr) {
        try {
            if (a) {
                Log.i("PopLayer", objArr.length == 0 ? str : String.format(str, objArr));
            }
            ArrayList<ILogAdapter> logAdapters = PopLayer.getReference().getLogAdapters();
            if (logAdapters == null || logAdapters.isEmpty() || !PopLayer.getReference().isLogOutputMode) {
                return;
            }
            Iterator<ILogAdapter> it = logAdapters.iterator();
            while (it.hasNext()) {
                it.next().Logi(str, objArr);
            }
        } catch (Throwable th) {
            a("log.error.e=" + th.toString() + th.getMessage());
        }
    }

    public static void c(String str, Throwable th) {
        a(str + "\nstack:" + Log.getStackTraceString(th));
        if (b) {
            throw new RuntimeException(th);
        }
    }
}
