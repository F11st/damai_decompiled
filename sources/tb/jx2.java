package tb;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class jx2 {
    public static final boolean a(@NotNull fc fcVar) {
        b41.i(fcVar, "version");
        return fcVar.a() == 1 && fcVar.b() >= 4;
    }

    public static final boolean b(@NotNull fc fcVar) {
        b41.i(fcVar, "version");
        return a(fcVar);
    }
}
