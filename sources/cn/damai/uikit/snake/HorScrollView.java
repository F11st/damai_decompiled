package cn.damai.uikit.snake;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import androidx.viewpager.widget.ViewPager;
import cn.damai.uikit.R$color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.l62;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class HorScrollView extends HorizontalScrollView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int LOTTIE = 3;
    public static final int SKIP = 2;
    public static final int THICK = 0;
    public static final int THIN = 1;
    protected boolean mAutoSelectWhenClick;
    private Context mContext;
    private int mDaSize;
    private boolean mFakeBoldText;
    private int mHeight;
    private boolean mIsEqual;
    private boolean mIsShowLine;
    private ScrollLinearView mLayout;
    public int mLineType;
    private List<ScrollTitleBean> mList;
    private View.OnClickListener mOnClickListener;
    private int mPaddingLeftRight;
    private int mSelectedFontColor;
    private int mSpace;
    private int mUnSelectedFontColor;
    private int mXiaoSize;
    private ViewPager pager;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "190646041")) {
                ipChange.ipc$dispatch("190646041", new Object[]{this, view});
                return;
            }
            HorScrollView horScrollView = HorScrollView.this;
            if (horScrollView.mAutoSelectWhenClick) {
                if (horScrollView.mLayout.mSrcollStart) {
                    return;
                }
                int i = HorScrollView.this.mLayout.mSelectIndex;
                int i2 = ((ScrollTitleBean) view.getTag()).index;
                if (i == i2) {
                    return;
                }
                HorScrollView.this.selectTitle(i2);
            }
            if (HorScrollView.this.mOnClickListener != null) {
                HorScrollView.this.mOnClickListener.onClick(view);
            }
        }
    }

    public HorScrollView(Context context) {
        super(context);
        this.mIsShowLine = true;
        this.mDaSize = 16;
        this.mXiaoSize = 16;
        int i = R$color.white;
        this.mSelectedFontColor = i;
        this.mUnSelectedFontColor = i;
        this.mSpace = 20;
        this.mHeight = 44;
        this.mLineType = 1;
        this.mIsEqual = false;
        this.mAutoSelectWhenClick = true;
        this.mPaddingLeftRight = 0;
        this.mContext = context;
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2010220890")) {
            ipChange.ipc$dispatch("-2010220890", new Object[]{this});
        } else {
            setHorizontalScrollBarEnabled(false);
        }
    }

    private void scrollToIndex(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1811493026")) {
            ipChange.ipc$dispatch("-1811493026", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mLayout.post(new Runnable() { // from class: cn.damai.uikit.snake.HorScrollView.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    View childAt;
                    int width;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1111083562")) {
                        ipChange2.ipc$dispatch("-1111083562", new Object[]{this});
                        return;
                    }
                    int width2 = HorScrollView.this.getWidth() / 2;
                    int i2 = 0;
                    for (int i3 = 0; i3 <= i; i3++) {
                        if (HorScrollView.this.mLayout.getChildAt(i3) != null && (childAt = HorScrollView.this.mLayout.getChildAt(i3)) != null) {
                            if (i3 < i) {
                                width = childAt.getWidth();
                            } else {
                                width = childAt.getWidth() / 2;
                            }
                            i2 += width;
                        }
                    }
                    HorScrollView.this.smoothScrollTo(i2 - width2, 0);
                }
            });
        }
    }

    public void commit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1298507900")) {
            ipChange.ipc$dispatch("-1298507900", new Object[]{this});
            return;
        }
        if (this.mLayout == null) {
            int i = this.mLineType;
            if (i == 0) {
                this.mLayout = new ScrollThickLinearView(this.mContext);
            } else if (i == 1) {
                ScrollThinLinearView scrollThinLinearView = new ScrollThinLinearView(this.mContext);
                this.mLayout = scrollThinLinearView;
                scrollThinLinearView.setViewPager(this.pager);
            } else if (i == 2) {
                this.mLayout = new ScrollSkipLinearView(this.mContext);
            } else if (i != 3) {
                return;
            } else {
                this.mLayout = new ScrollLottieLinearView(this.mContext);
            }
            this.mLayout.setParentView(this);
        }
        removeAllViews();
        addView(this.mLayout);
        ScrollLinearView scrollLinearView = this.mLayout;
        scrollLinearView.mSelectIndex = -1;
        scrollLinearView.setLineShow(this.mIsShowLine);
        this.mLayout.setFontSize(this.mXiaoSize, this.mDaSize);
        this.mLayout.setFontColor(this.mSelectedFontColor, this.mUnSelectedFontColor);
        this.mLayout.setSelectTextFakeBold(this.mFakeBoldText);
        this.mLayout.setSpace(this.mSpace);
        this.mLayout.setHeight(this.mHeight);
        this.mLayout.setIsEqual(this.mIsEqual);
        this.mLayout.setDefaultPadding(this.mPaddingLeftRight);
        this.mLayout.setTitle(this.mList, new a());
        if (this.mLayout.getLayoutParams() != null) {
            this.mLayout.getLayoutParams().height = this.mLayout.dip2px(this.mHeight);
        }
    }

    public int getCurrentIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-681661997")) {
            return ((Integer) ipChange.ipc$dispatch("-681661997", new Object[]{this})).intValue();
        }
        ScrollLinearView scrollLinearView = this.mLayout;
        if (scrollLinearView == null) {
            return -1;
        }
        return scrollLinearView.mSelectIndex;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1285786183")) {
            ipChange.ipc$dispatch("1285786183", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else {
            super.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void selectTitle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-494193904")) {
            ipChange.ipc$dispatch("-494193904", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ScrollLinearView scrollLinearView = this.mLayout;
        if (scrollLinearView == null || scrollLinearView.mSrcollStart || i == -1) {
            return;
        }
        scrollLinearView.setFontSize(i);
        this.mLayout.mSelectIndex = i;
        if (this.mIsEqual) {
            return;
        }
        scrollToIndex(i);
    }

    public HorScrollView setAutoSelect(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-614313907")) {
            return (HorScrollView) ipChange.ipc$dispatch("-614313907", new Object[]{this, Boolean.valueOf(z)});
        }
        this.mAutoSelectWhenClick = z;
        return this;
    }

    public HorScrollView setDefaultPadding(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1642926311")) {
            return (HorScrollView) ipChange.ipc$dispatch("-1642926311", new Object[]{this, Integer.valueOf(i)});
        }
        this.mPaddingLeftRight = l62.a(this.mContext, i);
        return this;
    }

    public HorScrollView setFontColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1612782373")) {
            return (HorScrollView) ipChange.ipc$dispatch("1612782373", new Object[]{this, Integer.valueOf(i)});
        }
        this.mSelectedFontColor = i;
        this.mUnSelectedFontColor = i;
        return this;
    }

    public HorScrollView setFontSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-752971486")) {
            return (HorScrollView) ipChange.ipc$dispatch("-752971486", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.mXiaoSize = i;
        this.mDaSize = i2;
        return this;
    }

    public HorScrollView setHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1253649570")) {
            return (HorScrollView) ipChange.ipc$dispatch("1253649570", new Object[]{this, Integer.valueOf(i)});
        }
        this.mHeight = i;
        return this;
    }

    public HorScrollView setIsEqual(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "815709982")) {
            return (HorScrollView) ipChange.ipc$dispatch("815709982", new Object[]{this, Boolean.valueOf(z)});
        }
        this.mIsEqual = z;
        return this;
    }

    public void setLineColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "674391509")) {
            ipChange.ipc$dispatch("674391509", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mLayout.setLineColor(i);
        }
    }

    public HorScrollView setLineShow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-332163577")) {
            return (HorScrollView) ipChange.ipc$dispatch("-332163577", new Object[]{this, Boolean.valueOf(z)});
        }
        this.mIsShowLine = z;
        return this;
    }

    public HorScrollView setLineType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1161191579")) {
            return (HorScrollView) ipChange.ipc$dispatch("1161191579", new Object[]{this, Integer.valueOf(i)});
        }
        this.mLineType = i;
        return this;
    }

    public HorScrollView setOnTitleClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-921415248")) {
            return (HorScrollView) ipChange.ipc$dispatch("-921415248", new Object[]{this, onClickListener});
        }
        this.mOnClickListener = onClickListener;
        return this;
    }

    public HorScrollView setSelectTextFakeBold(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2127022603")) {
            return (HorScrollView) ipChange.ipc$dispatch("-2127022603", new Object[]{this, Boolean.valueOf(z)});
        }
        this.mFakeBoldText = z;
        return this;
    }

    public HorScrollView setSpace(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "920831539")) {
            return (HorScrollView) ipChange.ipc$dispatch("920831539", new Object[]{this, Integer.valueOf(i)});
        }
        this.mSpace = i;
        return this;
    }

    public HorScrollView setTitle(List<ScrollTitleBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1221353161")) {
            return (HorScrollView) ipChange.ipc$dispatch("1221353161", new Object[]{this, list});
        }
        this.mList = list;
        return this;
    }

    public HorScrollView setViewPager(ViewPager viewPager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "366391719")) {
            return (HorScrollView) ipChange.ipc$dispatch("366391719", new Object[]{this, viewPager});
        }
        this.pager = viewPager;
        return this;
    }

    public void updateColor(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-982881451")) {
            ipChange.ipc$dispatch("-982881451", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        ScrollLinearView scrollLinearView = this.mLayout;
        if (scrollLinearView != null) {
            this.mSelectedFontColor = i;
            this.mUnSelectedFontColor = i2;
            scrollLinearView.setFontColor(i, i2);
            this.mLayout.updateFontColor();
        }
    }

    public HorScrollView setFontColor(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1829890614")) {
            return (HorScrollView) ipChange.ipc$dispatch("1829890614", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.mSelectedFontColor = i;
        this.mUnSelectedFontColor = i2;
        return this;
    }

    public HorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsShowLine = true;
        this.mDaSize = 16;
        this.mXiaoSize = 16;
        int i = R$color.white;
        this.mSelectedFontColor = i;
        this.mUnSelectedFontColor = i;
        this.mSpace = 20;
        this.mHeight = 44;
        this.mLineType = 1;
        this.mIsEqual = false;
        this.mAutoSelectWhenClick = true;
        this.mPaddingLeftRight = 0;
        this.mContext = context;
        initView();
    }
}
