package cn.damai.tetris.component.home.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import androidx.viewpager.widget.ViewPager;
import cn.damai.commonbusiness.R$color;
import cn.damai.tetris.component.home.widget.TabLottieLinearView;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.l62;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class HomeTabScrollView extends HorizontalScrollView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int LOTTIE = 3;
    public static final int SKIP = 2;
    public static final int THICK = 0;
    public static final int THIN = 1;
    TabLottieLinearView.OnBindListener listener;
    protected boolean mAutoSelectWhenClick;
    private Context mContext;
    private int mDaSize;
    private boolean mFakeBoldText;
    private int mHeight;
    private boolean mIsEqual;
    private boolean mIsShowLine;
    private TabLinearView mLayout;
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
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1779756091")) {
                ipChange.ipc$dispatch("1779756091", new Object[]{this, view});
                return;
            }
            HomeTabScrollView homeTabScrollView = HomeTabScrollView.this;
            if (homeTabScrollView.mAutoSelectWhenClick) {
                if (homeTabScrollView.mLayout.mSrcollStart) {
                    return;
                }
                HomeTabScrollView.this.selectTitle(((ScrollTitleBean) view.getTag()).index);
            }
            if (HomeTabScrollView.this.mOnClickListener != null) {
                HomeTabScrollView.this.mOnClickListener.onClick(view);
            }
        }
    }

    public HomeTabScrollView(Context context) {
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
        if (AndroidInstantRuntime.support(ipChange, "463388872")) {
            ipChange.ipc$dispatch("463388872", new Object[]{this});
        } else {
            setHorizontalScrollBarEnabled(false);
        }
    }

    private void scrollToIndex(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1730902016")) {
            ipChange.ipc$dispatch("1730902016", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mLayout.post(new Runnable() { // from class: cn.damai.tetris.component.home.widget.HomeTabScrollView.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    View childAt;
                    int width;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-759369996")) {
                        ipChange2.ipc$dispatch("-759369996", new Object[]{this});
                        return;
                    }
                    int width2 = HomeTabScrollView.this.getWidth() / 2;
                    int i2 = 0;
                    for (int i3 = 0; i3 <= i; i3++) {
                        if (HomeTabScrollView.this.mLayout.getChildAt(i3) != null && (childAt = HomeTabScrollView.this.mLayout.getChildAt(i3)) != null) {
                            if (i3 < i) {
                                width = childAt.getWidth();
                            } else {
                                width = childAt.getWidth() / 2;
                            }
                            i2 += width;
                        }
                    }
                    HomeTabScrollView.this.smoothScrollTo(i2 - width2, 0);
                }
            });
        }
    }

    public void commit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1014678054")) {
            ipChange.ipc$dispatch("1014678054", new Object[]{this});
            return;
        }
        if (this.mLayout == null) {
            if (this.mLineType == 3) {
                this.mLayout = new ScrollSkipLinearView(this.mContext);
            } else {
                this.mLayout = new TabLottieLinearView(this.mContext);
            }
            this.mLayout.setParentView(this);
            TabLottieLinearView.OnBindListener onBindListener = this.listener;
            if (onBindListener != null) {
                ((TabLottieLinearView) this.mLayout).setOnBindListener(onBindListener);
            }
        }
        removeAllViews();
        addView(this.mLayout);
        TabLinearView tabLinearView = this.mLayout;
        tabLinearView.mSelectIndex = -1;
        tabLinearView.setLineShow(this.mIsShowLine);
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

    public void enableColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1539260019")) {
            ipChange.ipc$dispatch("-1539260019", new Object[]{this});
            return;
        }
        TabLinearView tabLinearView = this.mLayout;
        if (tabLinearView instanceof TabLottieLinearView) {
            ((TabLottieLinearView) tabLinearView).enableColor();
        }
    }

    public void enableWhite() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1252960007")) {
            ipChange.ipc$dispatch("1252960007", new Object[]{this});
            return;
        }
        TabLinearView tabLinearView = this.mLayout;
        if (tabLinearView instanceof TabLottieLinearView) {
            ((TabLottieLinearView) tabLinearView).enableWhite();
        }
    }

    public int getCurrentIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1758401905")) {
            return ((Integer) ipChange.ipc$dispatch("1758401905", new Object[]{this})).intValue();
        }
        TabLinearView tabLinearView = this.mLayout;
        if (tabLinearView == null) {
            return -1;
        }
        return tabLinearView.mSelectIndex;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1835469083")) {
            ipChange.ipc$dispatch("-1835469083", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else {
            super.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void selectTitle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1386585138")) {
            ipChange.ipc$dispatch("1386585138", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        TabLinearView tabLinearView = this.mLayout;
        if (tabLinearView == null || tabLinearView.mSrcollStart || i == -1) {
            return;
        }
        tabLinearView.setFontSize(i);
        if (this.mIsEqual) {
            return;
        }
        scrollToIndex(i);
    }

    public HomeTabScrollView setAutoSelect(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "632086981")) {
            return (HomeTabScrollView) ipChange.ipc$dispatch("632086981", new Object[]{this, Boolean.valueOf(z)});
        }
        this.mAutoSelectWhenClick = z;
        return this;
    }

    public HomeTabScrollView setBindListener(TabLottieLinearView.OnBindListener onBindListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1338621764")) {
            return (HomeTabScrollView) ipChange.ipc$dispatch("-1338621764", new Object[]{this, onBindListener});
        }
        this.listener = onBindListener;
        return this;
    }

    public HomeTabScrollView setDefaultPadding(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1125541511")) {
            return (HomeTabScrollView) ipChange.ipc$dispatch("-1125541511", new Object[]{this, Integer.valueOf(i)});
        }
        this.mPaddingLeftRight = l62.a(this.mContext, i);
        return this;
    }

    public HomeTabScrollView setFontColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2077606807")) {
            return (HomeTabScrollView) ipChange.ipc$dispatch("-2077606807", new Object[]{this, Integer.valueOf(i)});
        }
        this.mSelectedFontColor = i;
        this.mUnSelectedFontColor = i;
        return this;
    }

    public HomeTabScrollView setFontSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-775858548")) {
            return (HomeTabScrollView) ipChange.ipc$dispatch("-775858548", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.mXiaoSize = i;
        this.mDaSize = i2;
        return this;
    }

    public HomeTabScrollView setHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2031542896")) {
            return (HomeTabScrollView) ipChange.ipc$dispatch("-2031542896", new Object[]{this, Integer.valueOf(i)});
        }
        this.mHeight = i;
        return this;
    }

    public HomeTabScrollView setIsEqual(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1584311696")) {
            return (HomeTabScrollView) ipChange.ipc$dispatch("1584311696", new Object[]{this, Boolean.valueOf(z)});
        }
        this.mIsEqual = z;
        return this;
    }

    public void setLineColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1151000333")) {
            ipChange.ipc$dispatch("-1151000333", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mLayout.setLineColor(i);
        }
    }

    public HomeTabScrollView setLineShow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1152160971")) {
            return (HomeTabScrollView) ipChange.ipc$dispatch("1152160971", new Object[]{this, Boolean.valueOf(z)});
        }
        this.mIsShowLine = z;
        return this;
    }

    public HomeTabScrollView setLineType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1266413239")) {
            return (HomeTabScrollView) ipChange.ipc$dispatch("1266413239", new Object[]{this, Integer.valueOf(i)});
        }
        this.mLineType = i;
        return this;
    }

    public HomeTabScrollView setOnTitleClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1439220034")) {
            return (HomeTabScrollView) ipChange.ipc$dispatch("1439220034", new Object[]{this, onClickListener});
        }
        this.mOnClickListener = onClickListener;
        return this;
    }

    public HomeTabScrollView setSelectTextFakeBold(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1459540765")) {
            return (HomeTabScrollView) ipChange.ipc$dispatch("1459540765", new Object[]{this, Boolean.valueOf(z)});
        }
        this.mFakeBoldText = z;
        return this;
    }

    public HomeTabScrollView setSpace(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "446620955")) {
            return (HomeTabScrollView) ipChange.ipc$dispatch("446620955", new Object[]{this, Integer.valueOf(i)});
        }
        this.mSpace = i;
        return this;
    }

    public HomeTabScrollView setTitle(List<ScrollTitleBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "378443337")) {
            return (HomeTabScrollView) ipChange.ipc$dispatch("378443337", new Object[]{this, list});
        }
        this.mList = list;
        return this;
    }

    public HomeTabScrollView setViewPager(ViewPager viewPager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-393120729")) {
            return (HomeTabScrollView) ipChange.ipc$dispatch("-393120729", new Object[]{this, viewPager});
        }
        this.pager = viewPager;
        return this;
    }

    public void updateColor(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1486694003")) {
            ipChange.ipc$dispatch("1486694003", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        TabLinearView tabLinearView = this.mLayout;
        if (tabLinearView != null) {
            this.mSelectedFontColor = i;
            this.mUnSelectedFontColor = i2;
            tabLinearView.setFontColor(i, i2);
            this.mLayout.updateFontColor();
        }
    }

    public HomeTabScrollView setFontColor(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "597541756")) {
            return (HomeTabScrollView) ipChange.ipc$dispatch("597541756", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.mSelectedFontColor = i;
        this.mUnSelectedFontColor = i2;
        return this;
    }

    public HomeTabScrollView(Context context, AttributeSet attributeSet) {
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
