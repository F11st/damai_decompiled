package tb;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final /* synthetic */ class j9 implements Function {
    public static final /* synthetic */ j9 a = new j9();

    private /* synthetic */ j9() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return Boolean.valueOf(((SupportSQLiteDatabase) obj).yieldIfContendedSafely());
    }
}
