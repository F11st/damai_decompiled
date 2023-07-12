package com.alibaba.aliweex.adapter.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.alibaba.aliweex.R$id;
import com.alibaba.aliweex.R$layout;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
@SuppressLint({"HandlerLeak"})
/* loaded from: classes15.dex */
public class Marquee extends FrameLayout {
    private static final int sSTOP_MSG = 1;
    private Context context;
    private int currentY;
    private long delayTime;
    private long durationTime;
    private Handler handler;
    private long intervalTime;
    private boolean isFirst;
    private boolean isStop;
    private Runnable mLogic;
    private FrameLayout marqueeRealView;
    private ScrollView scrollView;
    private long time;
    private long times;
    private int viewHeight;
    private List<View> viewList;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.view.Marquee$a */
    /* loaded from: classes15.dex */
    public class HandlerC3072a extends Handler {
        public HandlerC3072a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            Marquee.this.isStop = false;
        }
    }

    public Marquee(Context context) {
        this(context, null);
    }

    static /* synthetic */ long access$708(Marquee marquee) {
        long j = marquee.times;
        marquee.times = 1 + j;
        return j;
    }

    static /* synthetic */ long access$908(Marquee marquee) {
        long j = marquee.time;
        marquee.time = 1 + j;
        return j;
    }

    private void init() {
        this.delayTime = 0L;
        this.intervalTime = DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
        this.durationTime = 500L;
        this.time = 1L;
        this.times = 0L;
        this.isFirst = true;
        this.currentY = 0;
        this.viewList = new ArrayList();
        LayoutInflater.from(this.context).inflate(R$layout.huichang_marquee_layout, (ViewGroup) this, true);
        this.scrollView = (ScrollView) findViewById(R$id.huichang_marquee_scroll_view);
        this.marqueeRealView = (FrameLayout) findViewById(R$id.huichang_marquee_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postDelayedInner(Runnable runnable, long j) {
        Handler handler = this.handler;
        if (handler == null || j < 0) {
            return;
        }
        handler.postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postInner(Runnable runnable) {
        Handler handler = this.handler;
        if (handler == null) {
            return;
        }
        handler.post(runnable);
    }

    public void destroy() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public View getRealView() {
        return this.marqueeRealView;
    }

    public void setDelayTime(long j) {
        this.delayTime = j;
    }

    public void setDurationTime(long j) {
        this.durationTime = j;
    }

    public void setIntervalTime(long j) {
        this.intervalTime = j;
    }

    public void setViewList(List<View> list, FrameLayout.LayoutParams layoutParams) {
        this.handler.removeCallbacksAndMessages(null);
        this.marqueeRealView.removeAllViews();
        this.viewList.clear();
        this.viewList.addAll(list);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
        layoutParams2.setMargins(0, 0, 0, 0);
        this.scrollView.setLayoutParams(layoutParams2);
        this.viewHeight = layoutParams.height;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int size = this.viewList.size();
        for (int i = 0; i < size; i++) {
            View view = this.viewList.get(i);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, view.getMeasuredHeight());
            layoutParams3.setMargins(0, this.viewHeight * this.viewList.indexOf(view), 0, 0);
            view.setLayoutParams(layoutParams3);
            view.forceLayout();
            view.requestLayout();
            this.marqueeRealView.addView(view, layoutParams3);
        }
    }

    public void startScroll() {
        Handler handler = this.handler;
        if (handler == null) {
            return;
        }
        handler.removeCallbacks(null);
        this.isStop = false;
        int i = this.viewHeight;
        if (i <= 0) {
            return;
        }
        postDelayedInner(this.mLogic, this.durationTime / i);
    }

    public void startScrollA() {
        Handler handler = this.handler;
        if (handler == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        this.marqueeRealView.scrollTo(0, 0);
        this.currentY = 0;
        postDelayedInner(this.mLogic, 20L);
    }

    public void stopScroll() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public Marquee(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new HandlerC3072a(Looper.getMainLooper());
        this.mLogic = new Runnable() { // from class: com.alibaba.aliweex.adapter.view.Marquee.1
            @Override // java.lang.Runnable
            public void run() {
                if (Marquee.this.marqueeRealView.getChildCount() <= 0 || Marquee.this.viewHeight == 0) {
                    return;
                }
                if (!Marquee.this.isFirst) {
                    if (Marquee.this.isStop) {
                        Marquee.this.postInner(this);
                        return;
                    }
                    Marquee.this.currentY++;
                    Marquee.this.marqueeRealView.scrollTo(0, Marquee.this.currentY);
                    if (Marquee.this.marqueeRealView.getScrollY() % Marquee.this.viewHeight == 0 && Marquee.this.handler != null) {
                        Marquee.this.isStop = true;
                        Marquee.this.handler.sendEmptyMessageDelayed(1, Marquee.this.intervalTime);
                        View childAt = Marquee.this.marqueeRealView.getChildAt(0);
                        Marquee.this.marqueeRealView.removeViewAt(0);
                        Marquee.access$708(Marquee.this);
                        if (Marquee.this.times % Marquee.this.viewList.size() == 0) {
                            Marquee.access$908(Marquee.this);
                        }
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
                        layoutParams.setMargins(0, (int) (Marquee.this.viewHeight * (((Marquee.this.times % Marquee.this.viewList.size()) - 1) + (Marquee.this.time * Marquee.this.viewList.size()))), 0, 0);
                        childAt.setLayoutParams(layoutParams);
                        Marquee.this.marqueeRealView.addView(childAt);
                    }
                    Marquee marquee = Marquee.this;
                    marquee.postDelayedInner(this, marquee.durationTime / Marquee.this.viewHeight);
                    return;
                }
                Marquee.this.isFirst = false;
                Marquee marquee2 = Marquee.this;
                marquee2.postDelayedInner(this, marquee2.delayTime);
            }
        };
        this.context = context;
        init();
    }
}
