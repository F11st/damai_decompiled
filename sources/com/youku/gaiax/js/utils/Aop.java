package com.youku.gaiax.js.utils;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJD\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/youku/gaiax/js/utils/Aop;", "", "T", "Lkotlin/Function0;", "task", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "time", "Ltb/wt2;", "upload", "aopTaskTime", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Aop {
    @NotNull
    public static final Aop INSTANCE = new Aop();

    private Aop() {
    }

    public final <T> T aopTaskTime(@NotNull Function0<? extends T> function0, @NotNull Function1<? super Long, wt2> function1) {
        b41.i(function0, "task");
        b41.i(function1, "upload");
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        T invoke = function0.invoke();
        long currentThreadTimeMillis2 = SystemClock.currentThreadTimeMillis();
        long j = currentThreadTimeMillis2 - currentThreadTimeMillis;
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("aopTaskTime() called with: startTime = " + currentThreadTimeMillis + ", endTime = " + currentThreadTimeMillis2 + ", diff = " + j);
        }
        function1.invoke(Long.valueOf(j));
        return invoke;
    }
}
