package tb;

import android.content.Context;
import android.content.ContextWrapper;
import com.alibaba.android.ultron.trade.monitor.IMonitor;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class oh1 {
    public static boolean a(Context context) {
        if (context instanceof IMonitor) {
            return true;
        }
        return (context instanceof ContextWrapper) && (((ContextWrapper) context).getBaseContext() instanceof IMonitor);
    }
}
