package kotlin.time;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@SinceKotlin(version = "1.3")
@ExperimentalTime
/* loaded from: classes3.dex */
public interface TimeSource {
    @NotNull
    public static final C8607a Companion = C8607a.a;

    /* compiled from: Taobao */
    /* renamed from: kotlin.time.TimeSource$a */
    /* loaded from: classes3.dex */
    public static final class C8607a {
        static final /* synthetic */ C8607a a = new C8607a();

        private C8607a() {
        }
    }

    @NotNull
    TimeMark markNow();
}
