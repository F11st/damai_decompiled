package kotlin.concurrent;

import java.util.TimerTask;
import kotlin.jvm.functions.Function1;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class TimersKt$timerTask$1 extends TimerTask {
    final /* synthetic */ Function1<TimerTask, wt2> $action;

    /* JADX WARN: Multi-variable type inference failed */
    public TimersKt$timerTask$1(Function1<? super TimerTask, wt2> function1) {
        this.$action = function1;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.$action.invoke(this);
    }
}
