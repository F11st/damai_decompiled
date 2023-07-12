package tb;

import com.alibaba.ability.middleware.IMiddlewareHub;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class rf1 {
    @NotNull
    public static final rf1 INSTANCE = new rf1();
    public static IMiddlewareHub a;

    private rf1() {
    }

    @NotNull
    public static final IMiddlewareHub a() {
        IMiddlewareHub iMiddlewareHub = a;
        if (iMiddlewareHub == null) {
            b41.A("middlewareHub");
        }
        return iMiddlewareHub;
    }
}
