package kotlin.time;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@SinceKotlin(version = "1.3")
@ExperimentalTime
/* loaded from: classes3.dex */
public interface TimeSource {
    @NotNull
    public static final a Companion = a.a;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    @NotNull
    TimeMark markNow();
}
