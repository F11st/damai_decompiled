package tb;

import kotlin.Result;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ai0 {
    private static final boolean a;

    static {
        Object m1271constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            m1271constructorimpl = Result.m1271constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m1271constructorimpl = Result.m1271constructorimpl(i32.a(th));
        }
        a = Result.m1278isSuccessimpl(m1271constructorimpl);
    }

    public static final boolean a() {
        return a;
    }
}
