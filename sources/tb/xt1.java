package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.tao.powermsg.common.IPowerMsgCallback;
import com.taobao.tao.powermsg.common.IPowerMsgDispatcher;
import com.taobao.tao.powermsg.common.IPowerMsgService;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class xt1 {
    private static IPowerMsgService a;

    public static synchronized IPowerMsgService a() {
        IPowerMsgService iPowerMsgService;
        synchronized (xt1.class) {
            if (a == null) {
                try {
                    a = (IPowerMsgService) Class.forName("com.taobao.tao.powermsg.PowerMsgRouter").newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            iPowerMsgService = a;
        }
        return iPowerMsgService;
    }

    public static int b(int i, @NonNull IPowerMsgDispatcher iPowerMsgDispatcher) {
        return a().registerDispatcher(i, null, iPowerMsgDispatcher);
    }

    public static int c(int i, @Nullable String str, IPowerMsgDispatcher iPowerMsgDispatcher) {
        return a().registerDispatcher(i, str, iPowerMsgDispatcher);
    }

    public static void d(int i, @NonNull wt1 wt1Var, @Nullable IPowerMsgCallback iPowerMsgCallback, Object... objArr) {
        a().sendMessage(i, wt1Var, iPowerMsgCallback, objArr);
    }

    public static void e(int i, @NonNull String str, int i2) {
        a().setMsgFetchMode(i, str, i2);
    }

    public static void f(int i, @NonNull String str, String str2, @Nullable IPowerMsgCallback iPowerMsgCallback, Object... objArr) {
        a().subscribe(i, str, str2, null, iPowerMsgCallback, objArr);
    }

    public static void g(int i, @NonNull String str, @NonNull String str2, String str3, String str4, @Nullable IPowerMsgCallback iPowerMsgCallback, Object... objArr) {
        a().subscribe(i, str, str2, str3, str4, iPowerMsgCallback, objArr);
    }

    public static void h(int i, @NonNull String str, String str2, @Nullable IPowerMsgCallback iPowerMsgCallback, Object... objArr) {
        a().unSubscribe(i, str, str2, null, iPowerMsgCallback, objArr);
    }

    public static void i(int i, @NonNull String str, @NonNull String str2, String str3, String str4, @Nullable IPowerMsgCallback iPowerMsgCallback, Object... objArr) {
        a().unSubscribe(i, str, str2, str3, str4, iPowerMsgCallback, objArr);
    }
}
