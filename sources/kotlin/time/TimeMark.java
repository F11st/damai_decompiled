package kotlin.time;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@SinceKotlin(version = "1.3")
@ExperimentalTime
/* loaded from: classes3.dex */
public interface TimeMark {
    /* renamed from: elapsedNow-UwyO8pc  reason: not valid java name */
    long m1282elapsedNowUwyO8pc();

    boolean hasNotPassedNow();

    boolean hasPassedNow();

    @NotNull
    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    TimeMark m1283minusLRDsOJo(long j);

    @NotNull
    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    TimeMark m1284plusLRDsOJo(long j);
}
