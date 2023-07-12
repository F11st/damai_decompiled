package tb;

import android.database.Cursor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.LinkedHashMap;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class jq {
    private static transient /* synthetic */ IpChange $ipChange;

    public static g40 a(Cursor cursor) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-64651603")) {
            return (g40) ipChange.ipc$dispatch("-64651603", new Object[]{cursor});
        }
        g40 g40Var = new g40();
        int columnCount = cursor.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            g40Var.a(cursor.getColumnName(i), cursor.getString(i));
        }
        return g40Var;
    }

    public static <T> T b(tk2<T> tk2Var, Cursor cursor) throws Throwable {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58993005")) {
            return (T) ipChange.ipc$dispatch("-58993005", new Object[]{tk2Var, cursor});
        }
        T a = tk2Var.a();
        LinkedHashMap<String, uk> b = tk2Var.b();
        int columnCount = cursor.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            uk ukVar = b.get(cursor.getColumnName(i));
            if (ukVar != null) {
                ukVar.i(a, cursor, i);
            }
        }
        return a;
    }
}
