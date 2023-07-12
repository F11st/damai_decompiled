package de.greenrobot.event.util;

import android.util.Log;
import de.greenrobot.event.EventBus;
import java.lang.reflect.Constructor;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AsyncExecutor {

    /* compiled from: Taobao */
    /* renamed from: de.greenrobot.event.util.AsyncExecutor$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ AsyncExecutor this$0;
        final /* synthetic */ RunnableEx val$runnable;

        AnonymousClass1(AsyncExecutor asyncExecutor, RunnableEx runnableEx) {
            this.val$runnable = runnableEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.val$runnable.run();
            } catch (Exception e) {
                try {
                    Object newInstance = AsyncExecutor.a(this.this$0).newInstance(e);
                    if (newInstance instanceof HasExecutionScope) {
                        ((HasExecutionScope) newInstance).setExecutionScope(AsyncExecutor.b(this.this$0));
                    }
                    AsyncExecutor.c(this.this$0).i(newInstance);
                } catch (Exception e2) {
                    Log.e(EventBus.p, "Original exception:", e);
                    throw new RuntimeException("Could not create failure event", e2);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface RunnableEx {
        void run() throws Exception;
    }

    static /* synthetic */ Constructor a(AsyncExecutor asyncExecutor) {
        throw null;
    }

    static /* synthetic */ Object b(AsyncExecutor asyncExecutor) {
        throw null;
    }

    static /* synthetic */ EventBus c(AsyncExecutor asyncExecutor) {
        throw null;
    }
}
