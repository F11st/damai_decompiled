package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
final class b implements NotCompleted {
    public static final b INSTANCE = new b();

    private b() {
    }

    @NotNull
    public String toString() {
        return "Active";
    }
}
