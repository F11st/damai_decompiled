package com.youku.live.livesdk.wkit.widget.slide;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.core.view.ViewConfigurationCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.utils.ContextUtils;
import com.youku.live.messagechannel.utils.MyLog;
import com.youku.live.widgets.dom.CSSLayout;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class BaseSlideLayout extends CSSLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DEFAULT_LR_SHOW_DURATION = 200;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "LiveHouseSlidingDrawer";
    private Handler handler;
    private boolean isClearScreen;
    private boolean isFullScreen;
    private boolean isLrEnabled;
    long mCurTime;
    private int mEndX;
    private int mEndY;
    private View mFirstSliderContainer;
    private int mHorizontalRange;
    private boolean mIntercept;
    private boolean mIsClearScreen;
    private boolean mIsContentViewShow;
    private boolean mIsLeftSlide;
    private boolean mIsShow;
    long mLastTime;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mScrollX;
    private int mScrollY;
    private OverScroller mScroller;
    private int mSlideDistance;
    private List<View> mSliderContainers;
    private int mStartX;
    private int mStartY;
    private StatusListener mStatusListener;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface StatusListener {
        void onHideContent();

        void onShowContent();

        void onTouchClick(int i, int i2, int i3);
    }

    public BaseSlideLayout(Context context) {
        super(context);
        this.mIsContentViewShow = false;
        this.isLrEnabled = true;
        this.isClearScreen = false;
        this.mIsShow = true;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.mStartY = 0;
        this.mEndY = 0;
        this.mScrollY = 0;
        this.mStartX = 0;
        this.mEndX = 0;
        this.mScrollX = 0;
        this.mSlideDistance = 0;
        this.mIsLeftSlide = true;
        this.mIsClearScreen = false;
        this.mLastTime = 0L;
        this.mCurTime = 0L;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.youku.live.livesdk.wkit.widget.slide.BaseSlideLayout.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1523406299")) {
                    ipChange.ipc$dispatch("1523406299", new Object[]{this, message});
                    return;
                }
                super.handleMessage(message);
                BaseSlideLayout.this.onTouchClick(message.arg1, message.arg2, message.what);
            }
        };
        this.mIntercept = false;
        init(context);
    }

    private int containerGetScrollX() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2040958641")) {
            return ((Integer) ipChange.ipc$dispatch("2040958641", new Object[]{this})).intValue();
        }
        View view = this.mFirstSliderContainer;
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    private void containerScrollTo(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1524177867")) {
            ipChange.ipc$dispatch("1524177867", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        List<View> list = this.mSliderContainers;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (View view : this.mSliderContainers) {
            if (view != null) {
                view.scrollTo(i, i2);
            }
        }
    }

    private void handleLrActionEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2117597341")) {
            ipChange.ipc$dispatch("2117597341", new Object[]{this});
        } else if (this.mFirstSliderContainer != null && this.isLrEnabled) {
            this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            this.mSlideDistance = this.isFullScreen ? this.mScreenHeight : this.mScreenWidth;
            float xVelocity = this.mVelocityTracker.getXVelocity();
            int scrollX = this.mFirstSliderContainer.getScrollX();
            if (Math.abs(xVelocity) >= this.mMinimumVelocity) {
                if (this.mIsLeftSlide) {
                    if (xVelocity > 0.0f) {
                        showContentView();
                    } else {
                        hideContentView();
                    }
                } else if (xVelocity > 0.0f) {
                    hideContentView();
                } else {
                    showContentView();
                }
            } else if (this.mIsLeftSlide) {
                int i = this.mHorizontalRange;
                if (scrollX < i) {
                    showContentView();
                } else if (scrollX > this.mScreenWidth - i) {
                    hideContentView();
                } else if (this.mScrollX > 0) {
                    showContentView();
                } else {
                    hideContentView();
                }
            } else {
                int i2 = this.mHorizontalRange;
                if (scrollX > (-i2)) {
                    showContentView();
                } else if (scrollX < (-this.mScreenWidth) + i2) {
                    hideContentView();
                } else if (this.mScrollX > 0) {
                    hideContentView();
                } else {
                    showContentView();
                }
            }
        }
    }

    private void handleLrActionMove(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1713249442")) {
            ipChange.ipc$dispatch("1713249442", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        List<View> list = this.mSliderContainers;
        if (list == null || list.size() <= 0 || !this.isLrEnabled) {
            return;
        }
        if (this.isFullScreen) {
            this.mSlideDistance = this.mScreenHeight;
        } else {
            this.mSlideDistance = this.mScreenWidth;
        }
        int i2 = this.mIsLeftSlide ? -(i - this.mEndX) : i - this.mEndX;
        for (View view : this.mSliderContainers) {
            if (view != null) {
                view.scrollBy(i2, 0);
            }
        }
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-541256286")) {
            ipChange.ipc$dispatch("-541256286", new Object[]{this, context});
            return;
        }
        setBackgroundColor(Color.argb(0, 0, 0, 0));
        setSoundEffectsEnabled(false);
        this.mScroller = new OverScroller(context);
        this.mScreenWidth = ContextUtils.getScreenWidth(context);
        this.mScreenHeight = ContextUtils.getFullActivityHeight(context);
        float f = context.getResources().getDisplayMetrics().density;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.mMinimumVelocity = (int) (f * 400.0f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mHorizontalRange = this.mScreenWidth / 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTouchClick(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-414765387")) {
            ipChange.ipc$dispatch("-414765387", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        StatusListener statusListener = this.mStatusListener;
        if (statusListener != null) {
            statusListener.onTouchClick(i, i2, i3);
        }
    }

    private void startLrScroller(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-93875438")) {
            ipChange.ipc$dispatch("-93875438", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mScroller.startScroll(i, 0, i2, 0, 200);
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1963867216")) {
            ipChange.ipc$dispatch("-1963867216", new Object[]{this});
            return;
        }
        if (this.mScroller.computeScrollOffset()) {
            if (this.mIsContentViewShow) {
                containerScrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            }
            postInvalidate();
        }
        super.computeScroll();
    }

    public void handleFullScreenPraise(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1503774420")) {
            ipChange.ipc$dispatch("-1503774420", new Object[]{this, motionEvent});
            return;
        }
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            this.mLastTime = this.mCurTime;
            this.mCurTime = System.currentTimeMillis();
            MyLog.v(TAG, "diff= " + (this.mCurTime - this.mLastTime));
            if (this.mCurTime - this.mLastTime < 600) {
                this.mCurTime = 0L;
                this.mLastTime = 0L;
                Handler handler = this.handler;
                if (handler != null) {
                    handler.removeMessages(1);
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.arg1 = this.mEndX;
                    obtain.arg2 = this.mEndY;
                    this.handler.sendMessage(obtain);
                }
            } else if (this.handler != null) {
                Message obtain2 = Message.obtain();
                obtain2.what = 1;
                obtain2.arg1 = this.mEndX;
                obtain2.arg2 = this.mEndY;
                this.handler.sendMessage(obtain2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0088, code lost:
        if (r0 != 4) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handleSlideEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 563
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.livesdk.wkit.widget.slide.BaseSlideLayout.handleSlideEvent(android.view.MotionEvent):boolean");
    }

    public void hideContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2143906120")) {
            ipChange.ipc$dispatch("-2143906120", new Object[]{this});
            return;
        }
        View view = this.mFirstSliderContainer;
        if (view == null) {
            return;
        }
        if (this.mIsLeftSlide) {
            startLrScroller(view.getScrollX(), this.mSlideDistance - this.mFirstSliderContainer.getScrollX());
        } else {
            startLrScroller(view.getScrollX(), -(this.mSlideDistance + this.mFirstSliderContainer.getScrollX()));
        }
        if (!this.isClearScreen) {
            this.isClearScreen = true;
        }
        StatusListener statusListener = this.mStatusListener;
        if (statusListener != null) {
            statusListener.onHideContent();
        }
        this.mIsShow = false;
    }

    public void initContainers(List<View> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "574262053")) {
            ipChange.ipc$dispatch("574262053", new Object[]{this, list});
        } else {
            this.mSliderContainers = list;
        }
    }

    public void initFirst(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-365505474")) {
            ipChange.ipc$dispatch("-365505474", new Object[]{this, view});
        } else {
            this.mFirstSliderContainer = view;
        }
    }

    public boolean isShow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "986380051") ? ((Boolean) ipChange.ipc$dispatch("986380051", new Object[]{this})).booleanValue() : this.mIsShow;
    }

    public void onClearScreenChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "508922424")) {
            ipChange.ipc$dispatch("508922424", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mIsClearScreen != z) {
            this.mIsClearScreen = z;
        }
    }

    @Override // com.youku.live.widgets.dom.CSSLayout, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-845972457")) {
            ipChange.ipc$dispatch("-845972457", new Object[]{this, configuration});
            return;
        }
        super.onConfigurationChanged(configuration);
        int i = getResources().getConfiguration().orientation;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1953535861")) {
            ipChange.ipc$dispatch("-1953535861", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-30737931") ? ((Boolean) ipChange.ipc$dispatch("-30737931", new Object[]{this, motionEvent})).booleanValue() : super.onTouchEvent(motionEvent);
    }

    public void setIntercept(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "157045022")) {
            ipChange.ipc$dispatch("157045022", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIntercept = z;
        }
    }

    public void setLrEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1383886519")) {
            ipChange.ipc$dispatch("1383886519", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isLrEnabled = z;
        }
    }

    public void setScreenMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1828798735")) {
            ipChange.ipc$dispatch("-1828798735", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isFullScreen = z;
        }
    }

    public void setStatusListener(StatusListener statusListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1824775412")) {
            ipChange.ipc$dispatch("-1824775412", new Object[]{this, statusListener});
        } else {
            this.mStatusListener = statusListener;
        }
    }

    public void showContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1534889677")) {
            ipChange.ipc$dispatch("-1534889677", new Object[]{this});
            return;
        }
        View view = this.mFirstSliderContainer;
        if (view == null) {
            return;
        }
        startLrScroller(view.getScrollX(), -this.mFirstSliderContainer.getScrollX());
        if (this.isClearScreen) {
            this.isClearScreen = false;
        }
        StatusListener statusListener = this.mStatusListener;
        if (statusListener != null) {
            statusListener.onShowContent();
        }
        this.mIsShow = true;
    }

    public BaseSlideLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsContentViewShow = false;
        this.isLrEnabled = true;
        this.isClearScreen = false;
        this.mIsShow = true;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.mStartY = 0;
        this.mEndY = 0;
        this.mScrollY = 0;
        this.mStartX = 0;
        this.mEndX = 0;
        this.mScrollX = 0;
        this.mSlideDistance = 0;
        this.mIsLeftSlide = true;
        this.mIsClearScreen = false;
        this.mLastTime = 0L;
        this.mCurTime = 0L;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.youku.live.livesdk.wkit.widget.slide.BaseSlideLayout.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1523406299")) {
                    ipChange.ipc$dispatch("1523406299", new Object[]{this, message});
                    return;
                }
                super.handleMessage(message);
                BaseSlideLayout.this.onTouchClick(message.arg1, message.arg2, message.what);
            }
        };
        this.mIntercept = false;
        init(context);
    }

    public BaseSlideLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsContentViewShow = false;
        this.isLrEnabled = true;
        this.isClearScreen = false;
        this.mIsShow = true;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.mStartY = 0;
        this.mEndY = 0;
        this.mScrollY = 0;
        this.mStartX = 0;
        this.mEndX = 0;
        this.mScrollX = 0;
        this.mSlideDistance = 0;
        this.mIsLeftSlide = true;
        this.mIsClearScreen = false;
        this.mLastTime = 0L;
        this.mCurTime = 0L;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.youku.live.livesdk.wkit.widget.slide.BaseSlideLayout.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1523406299")) {
                    ipChange.ipc$dispatch("1523406299", new Object[]{this, message});
                    return;
                }
                super.handleMessage(message);
                BaseSlideLayout.this.onTouchClick(message.arg1, message.arg2, message.what);
            }
        };
        this.mIntercept = false;
        init(context);
    }
}
