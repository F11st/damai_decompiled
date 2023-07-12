package com.taobao.monitor.impl.trace;

import com.taobao.monitor.impl.trace.AbsDispatcher;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import tb.pp1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PageLeaveDispatcher extends AbsDispatcher<PageLeaveListener> {
    public static final int TYPE_BACK = -4;
    public static final int TYPE_F2B = -3;
    public static final int TYPE_JUMP_NEXT_PAGE = -5;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface PageLeaveListener {
        void onLeave(pp1 pp1Var, int i);
    }

    /* compiled from: Taobao */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface PageLeaveType {
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements AbsDispatcher.ListenerCaller<PageLeaveListener> {
        final /* synthetic */ pp1 a;
        final /* synthetic */ int b;

        a(PageLeaveDispatcher pageLeaveDispatcher, pp1 pp1Var, int i) {
            this.a = pp1Var;
            this.b = i;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(PageLeaveListener pageLeaveListener) {
            pageLeaveListener.onLeave(this.a, this.b);
        }
    }

    public void f(pp1 pp1Var, int i) {
        c(new a(this, pp1Var, i));
    }
}
