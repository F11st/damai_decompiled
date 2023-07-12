package tb;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class uc1 extends CoroutineDispatcher {
    @NotNull
    public abstract uc1 a();

    /* JADX INFO: Access modifiers changed from: protected */
    @InternalCoroutinesApi
    @Nullable
    public final String c() {
        uc1 uc1Var;
        uc1 c = da0.c();
        if (this == c) {
            return "Dispatchers.Main";
        }
        try {
            uc1Var = c.a();
        } catch (UnsupportedOperationException unused) {
            uc1Var = null;
        }
        if (this == uc1Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String c = c();
        if (c != null) {
            return c;
        }
        return o40.a(this) + '@' + o40.b(this);
    }
}
