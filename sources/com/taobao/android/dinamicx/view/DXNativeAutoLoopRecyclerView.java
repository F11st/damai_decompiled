package com.taobao.android.dinamicx.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.MotionEvent;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.timer.DXTimerListener;
import com.taobao.android.dinamicx.widget.DXSliderLayout;
import java.lang.ref.WeakReference;
import tb.r10;
import tb.s00;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXNativeAutoLoopRecyclerView extends DXNativeRecyclerView {
    public static final int TYPE_NESTED_HORIZONTAL = 1;
    public static final int TYPE_NESTED_NONE = 0;
    public static final int TYPE_NESTED_VERTICAL = 2;
    private final int MIN_SCROLL_INSTANCE;
    private boolean autoPlay;
    private boolean avoidIncessantScroll;
    private int currentIndex;
    private DinamicXEngine dinamicXEngine;
    private int interval;
    private boolean isInterceptMultipointLock;
    private boolean isInterceptMultipointTouch;
    private float mCurrentX;
    private float mCurrentY;
    private Boolean mIsHorizontalScroll;
    private int mNestedDirection;
    private final BroadcastReceiver mReceiver;
    private boolean manualSwitchEnabled;
    private boolean needProcessViewLifeCycle;
    private OnPageChangeListener onPageChangeListener;
    private boolean overrideCanScrollHorizontal;
    private a runnable;
    private boolean scrollAble;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnPageChangeListener {
        void onPageSelected(int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a implements DXTimerListener {
        private WeakReference<DXNativeAutoLoopRecyclerView> a;

        public a(DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView) {
            this.a = new WeakReference<>(dXNativeAutoLoopRecyclerView);
        }

        private int a(@NonNull RecyclerView recyclerView) {
            return ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        }

        @Override // com.taobao.android.dinamicx.timer.DXTimerListener
        public void onTimerCallback() {
            s00.d("DXNativeAutoLoopRecyclerView", "DXNativeAutoLoopRecyclerView", "timer callback");
            DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView = this.a.get();
            if (dXNativeAutoLoopRecyclerView == null) {
                return;
            }
            if (dXNativeAutoLoopRecyclerView.getAvoidIncessantScroll()) {
                try {
                    int increaseCurrentIndex = dXNativeAutoLoopRecyclerView.increaseCurrentIndex();
                    int a = a(dXNativeAutoLoopRecyclerView);
                    int i = increaseCurrentIndex - a;
                    if (Math.abs(i) > 10) {
                        dXNativeAutoLoopRecyclerView.scrollToPosition(increaseCurrentIndex);
                        e eVar = new e(r10.DB_NAME);
                        e.a aVar = new e.a("Render", "RENDER_ERROR", e.DX_ERROR_CODE_SLIDER_LAYOUT_RECYCLER_VIEW_ERROR);
                        aVar.e = "nextPosition = " + increaseCurrentIndex + ";nowPosition = " + a + ";Math.abs(nextPosition - nowPosition) > ： " + i + ";interval = " + dXNativeAutoLoopRecyclerView.interval + ";needProcessViewLifeCycle = " + dXNativeAutoLoopRecyclerView.needProcessViewLifeCycle;
                        eVar.c.add(aVar);
                    } else {
                        dXNativeAutoLoopRecyclerView.smoothScrollToPosition(increaseCurrentIndex);
                    }
                } catch (Throwable th) {
                    s00.d("DXNativeAutoLoopRecyclerView", "DXNativeAutoLoopRecyclerView", "unexpected exception." + th.getMessage());
                }
            } else {
                dXNativeAutoLoopRecyclerView.smoothScrollToPosition(dXNativeAutoLoopRecyclerView.increaseCurrentIndex());
            }
            OnPageChangeListener onPageChangeListener = dXNativeAutoLoopRecyclerView.getOnPageChangeListener();
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(dXNativeAutoLoopRecyclerView.getCurrentIndex());
            }
        }
    }

    public DXNativeAutoLoopRecyclerView(@NonNull Context context) {
        super(context);
        this.MIN_SCROLL_INSTANCE = 10;
        this.manualSwitchEnabled = true;
        this.needProcessViewLifeCycle = true;
        this.mCurrentX = 0.0f;
        this.mCurrentY = 0.0f;
        this.mIsHorizontalScroll = null;
        this.mNestedDirection = 0;
        this.avoidIncessantScroll = false;
        this.isInterceptMultipointTouch = true;
        this.isInterceptMultipointLock = false;
        this.scrollAble = true;
        this.overrideCanScrollHorizontal = false;
        this.mReceiver = new BroadcastReceiver() { // from class: com.taobao.android.dinamicx.view.DXNativeAutoLoopRecyclerView.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    DXNativeAutoLoopRecyclerView.this.stopTimer();
                } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                    if (DXNativeAutoLoopRecyclerView.this.isShown()) {
                        DXNativeAutoLoopRecyclerView.this.startTimer();
                    } else {
                        DXNativeAutoLoopRecyclerView.this.stopTimer();
                    }
                }
            }
        };
        new PagerSnapHelper().attachToRecyclerView(this);
        this.mNestedDirection = 1;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        boolean canScrollHorizontally = super.canScrollHorizontally(i);
        if (this.overrideCanScrollHorizontal) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if ((getAdapter() instanceof DXSliderLayout.AutoLoopScrollerAdapter) && layoutManager != null) {
                canScrollHorizontally = layoutManager.canScrollHorizontally();
            }
            return canScrollHorizontally & this.manualSwitchEnabled;
        }
        return canScrollHorizontally;
    }

    @Override // com.taobao.android.dinamicx.view.DXNativeRecyclerView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.scrollAble) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.isInterceptMultipointTouch) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 1) {
                this.isInterceptMultipointLock = false;
            } else if (actionMasked == 5) {
                this.isInterceptMultipointLock = true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } else if (!this.autoPlay) {
            return super.dispatchTouchEvent(motionEvent);
        } else {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (this.manualSwitchEnabled) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.mCurrentX = motionEvent.getX();
                    this.mCurrentY = motionEvent.getY();
                    this.mIsHorizontalScroll = null;
                    stopTimer();
                } else if (action == 1) {
                    this.mCurrentX = 0.0f;
                    this.mCurrentY = 0.0f;
                    this.mIsHorizontalScroll = null;
                    startTimer();
                } else if (action != 2) {
                    if (action == 3) {
                        this.mCurrentX = 0.0f;
                        this.mCurrentY = 0.0f;
                        this.mIsHorizontalScroll = null;
                        startTimer();
                    }
                } else if (this.mNestedDirection != 0) {
                    Boolean bool = this.mIsHorizontalScroll;
                    if ((bool != null && bool.booleanValue()) || (this.mIsHorizontalScroll == null && Math.abs(motionEvent.getX() - this.mCurrentX) > 10.0f)) {
                        this.mIsHorizontalScroll = Boolean.TRUE;
                        if (this.mNestedDirection == 1) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                            dispatchTouchEvent = true;
                        } else {
                            dispatchTouchEvent = false;
                        }
                    }
                    Boolean bool2 = this.mIsHorizontalScroll;
                    if ((bool2 != null && !bool2.booleanValue()) || (this.mIsHorizontalScroll == null && Math.abs(motionEvent.getY() - this.mCurrentY) > 10.0f)) {
                        this.mIsHorizontalScroll = Boolean.FALSE;
                        if (this.mNestedDirection == 2) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                            return true;
                        }
                        return false;
                    }
                }
            }
            return dispatchTouchEvent;
        }
    }

    public boolean getAvoidIncessantScroll() {
        return this.avoidIncessantScroll;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public int getInterval() {
        return this.interval;
    }

    public OnPageChangeListener getOnPageChangeListener() {
        return this.onPageChangeListener;
    }

    public int increaseCurrentIndex() {
        int i = this.currentIndex + 1;
        this.currentIndex = i;
        return i;
    }

    public boolean isAutoPlay() {
        return this.autoPlay;
    }

    public boolean isInterceptMultipointTouch() {
        return this.isInterceptMultipointTouch;
    }

    @Override // com.taobao.android.dinamicx.view.DXNativeRecyclerView
    public boolean isSlider() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
            s00.b("DXNativeAutoLoopRecyclerView onAttachedToWindow" + getCurrentIndex());
            if (this.needProcessViewLifeCycle && this.autoPlay) {
                startTimer();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                getContext().registerReceiver(this.mReceiver, intentFilter);
                s00.b("DXNativeAutoLoopRecyclerView registerReceiver mReceiver" + this.mReceiver);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            s00.b("DXNativeAutoLoopRecyclerView onDetachedFromWindow" + getCurrentIndex());
            if (this.needProcessViewLifeCycle && this.autoPlay) {
                stopTimer();
                getContext().unregisterReceiver(this.mReceiver);
                s00.b("DXNativeAutoLoopRecyclerView unregisterReceiver mReceiver" + this.mReceiver);
            }
        } catch (Throwable unused) {
            e eVar = new e(r10.DB_NAME);
            e.a aVar = new e.a("Render", "Render_Fltten_Crash", e.DXERROR_RENDER_DXNativeAutoLoopRecyclerView_UNRESGISTER_ERROR);
            aVar.e = "mReceiver : " + this.mReceiver;
            eVar.c.add(aVar);
            DXAppMonitor.n(eVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.scrollAble) {
            if (this.isInterceptMultipointTouch) {
                return this.manualSwitchEnabled && super.onInterceptTouchEvent(motionEvent);
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 1) {
                this.isInterceptMultipointLock = false;
            } else if (actionMasked == 5) {
                this.isInterceptMultipointLock = true;
            }
            if (this.isInterceptMultipointLock) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.scrollAble && this.manualSwitchEnabled) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        s00.b("DXNativeAutoLoopRecyclerView onWindowVisibilityChanged visibility" + i);
        if (this.needProcessViewLifeCycle && this.autoPlay) {
            if (i == 0) {
                startTimer();
            } else {
                stopTimer();
            }
        }
    }

    public void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    public void setAvoidIncessantScroll(boolean z) {
        this.avoidIncessantScroll = z;
    }

    public void setCurrentIndex(int i) {
        this.currentIndex = i;
    }

    public void setDinamicXEngine(DinamicXEngine dinamicXEngine) {
        this.dinamicXEngine = dinamicXEngine;
    }

    public void setInterceptMultipointTouch(boolean z) {
        this.isInterceptMultipointTouch = z;
    }

    public void setInterval(int i) {
        this.interval = i;
    }

    public void setManualSwitchEnabled(boolean z) {
        this.manualSwitchEnabled = z;
    }

    public void setNeedProcessViewLifeCycle(boolean z) {
        this.needProcessViewLifeCycle = z;
    }

    public void setNestedType(@IntRange(from = 0, to = 2) int i) {
        this.mNestedDirection = i;
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.onPageChangeListener = onPageChangeListener;
    }

    public void setOverrideCanScrollHorizontal(boolean z) {
        this.overrideCanScrollHorizontal = z;
    }

    public void setScrollAble(boolean z) {
        this.scrollAble = z;
    }

    public void startTimer() {
        if (this.autoPlay) {
            if (this.runnable == null) {
                this.runnable = new a(this);
            }
            if (this.dinamicXEngine != null) {
                s00.b("DXNativeAutoLoopRecyclerView startTimer");
                this.dinamicXEngine.M(this.runnable, this.interval);
            }
        }
    }

    public void stopTimer() {
        if (this.autoPlay) {
            if (this.dinamicXEngine != null) {
                s00.b("DXNativeAutoLoopRecyclerView stopTimer" + getCurrentIndex());
                this.dinamicXEngine.T(this.runnable);
            }
            try {
                s00.b("DXNativeAutoLoopRecyclerView stopTimer   scrollToPosition(getCurrentIndex())" + getCurrentIndex());
                scrollToPosition(getCurrentIndex());
            } catch (Throwable unused) {
                s00.b("DXNativeAutoLoopRecyclerView exception method=stopTimer,action=scrollToPosition,position=" + getCurrentIndex());
            }
        }
    }
}
