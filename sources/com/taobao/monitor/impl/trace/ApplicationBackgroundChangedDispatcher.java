package com.taobao.monitor.impl.trace;

import com.taobao.monitor.impl.trace.AbsDispatcher;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ApplicationBackgroundChangedDispatcher extends AbsDispatcher<BackgroundChangedListener> {
    public static final int B2F = 0;
    public static final int F2B = 1;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface BackgroundChangedListener {
        void onChanged(int i, long j);
    }

    /* compiled from: Taobao */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface Status {
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements AbsDispatcher.ListenerCaller<BackgroundChangedListener> {
        final /* synthetic */ int a;
        final /* synthetic */ long b;

        a(ApplicationBackgroundChangedDispatcher applicationBackgroundChangedDispatcher, int i, long j) {
            this.a = i;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(BackgroundChangedListener backgroundChangedListener) {
            backgroundChangedListener.onChanged(this.a, this.b);
        }
    }

    public void f(int i, long j) {
        c(new a(this, i, j));
    }
}
