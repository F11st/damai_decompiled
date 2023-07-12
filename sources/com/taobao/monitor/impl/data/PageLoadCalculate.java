package com.taobao.monitor.impl.data;

import android.view.View;
import com.taobao.monitor.impl.data.calculator.ICalculator;
import com.taobao.monitor.impl.data.calculator.ICalculatorFactory;
import java.lang.ref.WeakReference;
import tb.ff;
import tb.fu0;
import tb.gf;
import tb.ho2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PageLoadCalculate implements IExecutor, Runnable {
    private static final long INTERVAL = 75;
    private WeakReference<View> containRef;
    private final String fullPageName;
    private IPageLoadPercent lifecycle;
    private volatile boolean stopped = false;
    private final ICalculatorFactory calculatorFactory = new gf();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface IPageLoadPercent {
        void pageLoadEndByTag(WeakReference<View> weakReference);

        void pageLoadPercent(float f, long j);

        void pageRootViewChanged(View view);
    }

    public PageLoadCalculate(View view, String str) {
        this.containRef = new WeakReference<>(view);
        this.fullPageName = str;
    }

    private void calculateDraw(View view, View view2) {
        ff calculate;
        if (this.lifecycle == null) {
            return;
        }
        long a = ho2.a();
        ICalculator createCalculator = this.calculatorFactory.createCalculator(this.fullPageName, view, view2);
        if (createCalculator == null || (calculate = createCalculator.calculate()) == null) {
            return;
        }
        View a2 = calculate.a();
        if (a2 != null) {
            this.containRef = new WeakReference<>(a2);
            this.lifecycle.pageRootViewChanged(a2);
            run();
        } else if (calculate.b() != null) {
            this.lifecycle.pageLoadEndByTag(new WeakReference<>(calculate.b()));
            stop();
        } else {
            this.lifecycle.pageLoadPercent(calculate.d() ? 1.0f : calculate.c(), a);
        }
    }

    private void check() {
        View view = this.containRef.get();
        if (view == null) {
            stop();
            return;
        }
        try {
            View findViewById = view.findViewById(view.getResources().getIdentifier("content", "id", "android"));
            if (findViewById == null) {
                findViewById = view;
            }
            if (findViewById.getHeight() * findViewById.getWidth() == 0) {
                return;
            }
            calculateDraw(findViewById, view);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.monitor.impl.data.IExecutor
    public void execute() {
        fu0.e().b().postDelayed(this, 50L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.stopped) {
            return;
        }
        check();
        fu0.e().b().postDelayed(this, 75L);
    }

    public PageLoadCalculate setLifecycle(IPageLoadPercent iPageLoadPercent) {
        this.lifecycle = iPageLoadPercent;
        return this;
    }

    @Override // com.taobao.monitor.impl.data.IExecutor
    public void stop() {
        this.stopped = true;
        fu0.e().b().removeCallbacks(this);
        fu0.e().d().post(new Runnable() { // from class: com.taobao.monitor.impl.data.PageLoadCalculate.1
            @Override // java.lang.Runnable
            public void run() {
                PageLoadCalculate.this.lifecycle = null;
            }
        });
    }
}
