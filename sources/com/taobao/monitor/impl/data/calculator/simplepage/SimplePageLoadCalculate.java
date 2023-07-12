package com.taobao.monitor.impl.data.calculator.simplepage;

import android.annotation.TargetApi;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.UiThread;
import com.taobao.monitor.impl.data.IExecutor;
import tb.ho2;

/* compiled from: Taobao */
@TargetApi(16)
/* loaded from: classes11.dex */
public class SimplePageLoadCalculate implements ViewTreeObserver.OnDrawListener, IExecutor {

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.data.calculator.simplepage.SimplePageLoadCalculate$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ SimplePageLoadCalculate this$0;

        AnonymousClass1(SimplePageLoadCalculate simplePageLoadCalculate) {
        }

        @Override // java.lang.Runnable
        public void run() {
            SimplePageLoadCalculate.a(this.this$0);
            SimplePageLoadCalculate.c(this.this$0).onLastVisibleTime(SimplePageLoadCalculate.b(this.this$0));
            if (SimplePageLoadCalculate.d(this.this$0) <= SimplePageLoadCalculate.b(this.this$0)) {
                return;
            }
            SimplePageLoadCalculate.c(this.this$0).onLastUsableTime(SimplePageLoadCalculate.d(this.this$0));
            throw null;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.data.calculator.simplepage.SimplePageLoadCalculate$2  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ SimplePageLoadCalculate this$0;

        AnonymousClass2(SimplePageLoadCalculate simplePageLoadCalculate) {
        }

        @Override // java.lang.Runnable
        @UiThread
        public void run() {
            SimplePageLoadCalculate.g(this.this$0);
            if (SimplePageLoadCalculate.f(this.this$0) > 2) {
                SimplePageLoadCalculate.e(this.this$0, ho2.a());
                return;
            }
            SimplePageLoadCalculate.h(this.this$0).removeCallbacks(this);
            SimplePageLoadCalculate.h(this.this$0).postDelayed(this, 16L);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.data.calculator.simplepage.SimplePageLoadCalculate$3  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ SimplePageLoadCalculate this$0;

        AnonymousClass3(SimplePageLoadCalculate simplePageLoadCalculate) {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewTreeObserver viewTreeObserver = SimplePageLoadCalculate.i(this.this$0).getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnDrawListener(this.this$0);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.data.calculator.simplepage.SimplePageLoadCalculate$4  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ SimplePageLoadCalculate this$0;

        AnonymousClass4(SimplePageLoadCalculate simplePageLoadCalculate) {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewTreeObserver viewTreeObserver = SimplePageLoadCalculate.i(this.this$0).getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnDrawListener(this.this$0);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface SimplePageLoadListener {
        void onLastUsableTime(long j);

        void onLastVisibleTime(long j);
    }

    static /* synthetic */ void a(SimplePageLoadCalculate simplePageLoadCalculate) {
        throw null;
    }

    static /* synthetic */ long b(SimplePageLoadCalculate simplePageLoadCalculate) {
        throw null;
    }

    static /* synthetic */ SimplePageLoadListener c(SimplePageLoadCalculate simplePageLoadCalculate) {
        throw null;
    }

    static /* synthetic */ long d(SimplePageLoadCalculate simplePageLoadCalculate) {
        throw null;
    }

    static /* synthetic */ long e(SimplePageLoadCalculate simplePageLoadCalculate, long j) {
        throw null;
    }

    static /* synthetic */ int f(SimplePageLoadCalculate simplePageLoadCalculate) {
        throw null;
    }

    static /* synthetic */ int g(SimplePageLoadCalculate simplePageLoadCalculate) {
        throw null;
    }

    static /* synthetic */ Handler h(SimplePageLoadCalculate simplePageLoadCalculate) {
        throw null;
    }

    static /* synthetic */ View i(SimplePageLoadCalculate simplePageLoadCalculate) {
        throw null;
    }
}
