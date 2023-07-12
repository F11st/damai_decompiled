package com.kcrason.dynamicpagerindicatorlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.ali.user.mobile.app.constant.UTConstant;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.jw2;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 c2\u00020\u00012\u00020\u0002:\u0003defB'\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010^\u0012\b\b\u0002\u0010`\u001a\u00020\u0003¢\u0006\u0004\ba\u0010bJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\"\u0010\u001c\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010 \u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0004\u001a\u00020\u0003J \u0010\"\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0003H\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0003H\u0016J\u000e\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)J\u000e\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020,J \u00101\u001a\u00020\u001d2\u0006\u00100\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0018\u00102\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00107\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00105R\u0016\u00108\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00105R\u0016\u00109\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00105R\u0016\u0010:\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010;R\u0016\u0010=\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00105R\u0016\u0010>\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00105R\u0016\u0010?\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010@R\u0016\u0010B\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00105R\u0016\u0010C\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u00105R\u0016\u0010D\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u00105R\u0016\u0010E\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u00105R\u0016\u0010F\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u00105R\u0016\u0010G\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010;R\u0016\u0010H\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u00105R\u0016\u0010I\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u00105R\u0016\u0010J\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u00105R\u0016\u0010K\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u00105R\u0018\u0010L\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010N\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010Q\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010S\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010V\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u00105R(\u0010Y\u001a\u0004\u0018\u00010P2\b\u0010Y\u001a\u0004\u0018\u00010P8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]¨\u0006g"}, d2 = {"Lcom/kcrason/dynamicpagerindicatorlibrary/DynamicPagerIndicator;", "Landroid/widget/RelativeLayout;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "Ltb/wt2;", "transformScrollIndicator", "dynamicScrollIndicator", "tabTitleColorGradient", "tabTitleSizeGradient", "transactionScrollTitleParentToCenter", "linkageScrollTitleParentToCenter", "updateTitleStyle", "Lcom/kcrason/dynamicpagerindicatorlibrary/ScrollableLine;", "addScrollableLine", "calculateFirstItemWidth", "", "text", "calculateTextWidth", "calculateIndicatorLineWidth", "Landroid/widget/LinearLayout;", "createTabParentView", "Landroid/widget/TextView;", "textView", "Landroidx/viewpager/widget/PagerAdapter;", "pagerAdapter", "setTabTitleTextView", "Lcom/kcrason/dynamicpagerindicatorlibrary/BasePagerTabView;", "basePagerTabView", "setTabViewLayoutParams", "getPagerTabView", "positionOffsetPixels", "onPageScrolled", "onPageSelected", "", "isUpdateScrollLine", "updateIndicator", "state", "onPageScrollStateChanged", "Lcom/kcrason/dynamicpagerindicatorlibrary/DynamicPagerIndicator$OnOutPageChangeListener;", "onOutPageChangeListener", "setOnOutPageChangeListener", "Lcom/kcrason/dynamicpagerindicatorlibrary/DynamicPagerIndicator$OnItemTabClickListener;", "onItemTabClickListener", "setOnItemTabClickListener", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "createTabView", "mOnOutPageChangeListener", "Lcom/kcrason/dynamicpagerindicatorlibrary/DynamicPagerIndicator$OnOutPageChangeListener;", "mPagerIndicatorMode", "I", "mPagerIndicatorScrollToCenterMode", "mTabPadding", "mTabPaddingTop", "mTabPaddingBottom", "mTabNormalTextSize", UTConstant.Args.UT_SUCCESS_F, "mTabSelectedTextSize", "mTabNormalTextColor", "mTabSelectedTextColor", "isTabNormalTextBold", "Z", "isTabSelectedTextBold", "mTabTextColorMode", "mTabTextSizeMode", "mIndicatorLineScrollMode", "mIndicatorLineHeight", "mIndicatorLineWidth", "mIndicatorLineRadius", "mIndicatorLineStartColor", "mIndicatorLineEndColor", "mIndicatorLineMarginTop", "mIndicatorLineMarginBottom", "mTabParentView", "Landroid/widget/LinearLayout;", "mScrollableLine", "Lcom/kcrason/dynamicpagerindicatorlibrary/ScrollableLine;", "Landroidx/viewpager/widget/ViewPager;", "mViewPager", "Landroidx/viewpager/widget/ViewPager;", "mOnItemTabClickListener", "Lcom/kcrason/dynamicpagerindicatorlibrary/DynamicPagerIndicator$OnItemTabClickListener;", "Landroid/widget/HorizontalScrollView;", "mAutoScrollHorizontalScrollView", "Landroid/widget/HorizontalScrollView;", "mCurrentPosition", "viewPager", "getViewPager", "()Landroid/support/v4/view/ViewPager;", "setViewPager", "(Landroid/support/v4/view/ViewPager;)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "a", "OnItemTabClickListener", "OnOutPageChangeListener", "dynamicpagerindicatorlibrary_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes10.dex */
public class DynamicPagerIndicator extends RelativeLayout implements ViewPager.OnPageChangeListener {
    public static final a Companion = new a(null);
    public static final int INDICATOR_MODE_FIXED = 2;
    public static final int INDICATOR_MODE_SCROLLABLE = 1;
    public static final int INDICATOR_MODE_SCROLLABLE_CENTER = 3;
    public static final int INDICATOR_SCROLL_MODE_DYNAMIC = 1;
    public static final int INDICATOR_SCROLL_MODE_TRANSFORM = 2;
    public static final int PAGER_INDICATOR_SCROLL_TO_CENTER_MODE_LINKAGE = 1;
    public static final int PAGER_INDICATOR_SCROLL_TO_CENTER_MODE_TRANSACTION = 2;
    public static final int TAB_TEXT_COLOR_MODE_COMMON = 1;
    public static final int TAB_TEXT_COLOR_MODE_GRADIENT = 2;
    public static final int TAB_TEXT_SIZE_MODE_COMMON = 1;
    public static final int TAB_TEXT_SIZE_MODE_GRADIENT = 2;
    private HashMap _$_findViewCache;
    private boolean isTabNormalTextBold;
    private boolean isTabSelectedTextBold;
    private HorizontalScrollView mAutoScrollHorizontalScrollView;
    private int mCurrentPosition;
    private int mIndicatorLineEndColor;
    private int mIndicatorLineHeight;
    private int mIndicatorLineMarginBottom;
    private int mIndicatorLineMarginTop;
    private float mIndicatorLineRadius;
    private int mIndicatorLineScrollMode;
    private int mIndicatorLineStartColor;
    private int mIndicatorLineWidth;
    private OnItemTabClickListener mOnItemTabClickListener;
    private OnOutPageChangeListener mOnOutPageChangeListener;
    private int mPagerIndicatorMode;
    private int mPagerIndicatorScrollToCenterMode;
    private ScrollableLine mScrollableLine;
    private int mTabNormalTextColor;
    private float mTabNormalTextSize;
    private int mTabPadding;
    private int mTabPaddingBottom;
    private int mTabPaddingTop;
    private LinearLayout mTabParentView;
    private int mTabSelectedTextColor;
    private float mTabSelectedTextSize;
    private int mTabTextColorMode;
    private int mTabTextSizeMode;
    private ViewPager mViewPager;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/kcrason/dynamicpagerindicatorlibrary/DynamicPagerIndicator$OnItemTabClickListener;", "", "", "position", "Ltb/wt2;", "onItemTabClick", "dynamicpagerindicatorlibrary_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes10.dex */
    public interface OnItemTabClickListener {
        void onItemTabClick(int i);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H&¨\u0006\f"}, d2 = {"Lcom/kcrason/dynamicpagerindicatorlibrary/DynamicPagerIndicator$OnOutPageChangeListener;", "", "", "position", "", "positionOffset", "positionOffsetPixels", "Ltb/wt2;", "onPageScrolled", "onPageSelected", "state", "onPageScrollStateChanged", "dynamicpagerindicatorlibrary_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes10.dex */
    public interface OnOutPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class b implements View.OnClickListener {
        final /* synthetic */ int b;

        b(int i) {
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (DynamicPagerIndicator.this.mOnItemTabClickListener != null) {
                OnItemTabClickListener onItemTabClickListener = DynamicPagerIndicator.this.mOnItemTabClickListener;
                if (onItemTabClickListener == null) {
                    b41.u();
                }
                onItemTabClickListener.onItemTabClick(this.b);
            }
            if (DynamicPagerIndicator.this.mViewPager != null) {
                ViewPager viewPager = DynamicPagerIndicator.this.mViewPager;
                if (viewPager == null) {
                    b41.u();
                }
                viewPager.setCurrentItem(this.b);
            }
        }
    }

    @JvmOverloads
    public DynamicPagerIndicator(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public DynamicPagerIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ DynamicPagerIndicator(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final ScrollableLine addScrollableLine() {
        ScrollableLine indicatorLineRadius;
        Context context = getContext();
        b41.e(context, WPKFactory.INIT_KEY_CONTEXT);
        this.mScrollableLine = new ScrollableLine(context, null, 0, 6, null);
        calculateIndicatorLineWidth();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mIndicatorLineHeight);
        layoutParams.topMargin = this.mIndicatorLineMarginTop;
        layoutParams.bottomMargin = this.mIndicatorLineMarginBottom;
        layoutParams.addRule(12);
        ScrollableLine scrollableLine = this.mScrollableLine;
        if (scrollableLine != null) {
            scrollableLine.setLayoutParams(layoutParams);
        }
        ScrollableLine scrollableLine2 = this.mScrollableLine;
        if (scrollableLine2 != null && (indicatorLineRadius = scrollableLine2.setIndicatorLineRadius(this.mIndicatorLineRadius)) != null) {
            indicatorLineRadius.setIndicatorLineHeight(this.mIndicatorLineHeight);
        }
        ScrollableLine scrollableLine3 = this.mScrollableLine;
        if (scrollableLine3 == null) {
            b41.u();
        }
        return scrollableLine3;
    }

    private final int calculateFirstItemWidth() {
        LinearLayout linearLayout = this.mTabParentView;
        if (linearLayout == null) {
            b41.u();
        }
        View childAt = linearLayout.getChildAt(0);
        if (childAt instanceof TextView) {
            return (int) (calculateTextWidth(((TextView) childAt).getText().toString()) + (this.mTabPadding * 2));
        }
        return 0;
    }

    private final void calculateIndicatorLineWidth() {
        int i = this.mPagerIndicatorMode;
        if (i != 1 && i != 3) {
            if (this.mIndicatorLineWidth == 0) {
                jw2 jw2Var = jw2.INSTANCE;
                Context context = getContext();
                b41.e(context, WPKFactory.INIT_KEY_CONTEXT);
                int c = jw2Var.c(context);
                LinearLayout linearLayout = this.mTabParentView;
                if (linearLayout == null) {
                    b41.u();
                }
                this.mIndicatorLineWidth = c / linearLayout.getChildCount();
            }
        } else if (this.mIndicatorLineWidth == 0) {
            this.mIndicatorLineWidth = calculateFirstItemWidth();
        }
    }

    private final int calculateTextWidth(String str) {
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(this.mTabSelectedTextColor);
        textPaint.setTextSize(this.mTabSelectedTextSize);
        return (int) textPaint.measureText(str);
    }

    private final LinearLayout createTabParentView() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        int i = this.mPagerIndicatorMode;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((i == 3 || i == 2) ? -1 : -2, -1);
        linearLayout.setGravity(this.mPagerIndicatorMode == 3 ? 17 : 16);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(0);
        return linearLayout;
    }

    private final void dynamicScrollIndicator(int i, float f) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        LinearLayout linearLayout = this.mTabParentView;
        if (linearLayout != null) {
            if (linearLayout == null) {
                b41.u();
            }
            if (i < linearLayout.getChildCount()) {
                LinearLayout linearLayout2 = this.mTabParentView;
                if (linearLayout2 == null) {
                    b41.u();
                }
                View childAt = linearLayout2.getChildAt(i);
                if (childAt instanceof BasePagerTabView) {
                    i3 = childAt.getRight();
                    i4 = childAt.getLeft();
                    i2 = childAt.getWidth();
                } else {
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                }
                LinearLayout linearLayout3 = this.mTabParentView;
                if (linearLayout3 == null) {
                    b41.u();
                }
                View childAt2 = linearLayout3.getChildAt(i + 1);
                int width = childAt2 != null ? childAt2.getWidth() : 0;
                double d = f;
                if (d <= 0.5d) {
                    float f2 = ((i2 - this.mIndicatorLineWidth) / 2) + i4;
                    float f3 = (2 * f * (((i2 - i6) / 2) + (width - ((width - i6) / 2)))) + (i3 - ((i2 - i6) >> 1));
                    ScrollableLine scrollableLine = this.mScrollableLine;
                    if (scrollableLine != null) {
                        scrollableLine.updateScrollLineWidth(f2, f3, this.mIndicatorLineStartColor, this.mIndicatorLineEndColor, f);
                        return;
                    }
                    return;
                }
                float f4 = i4 + ((i2 - i5) >> 1) + (((float) (d - 0.5d)) * 2.0f * ((i2 - ((i2 - i5) >> 1)) + ((width - i5) >> 1)));
                float f5 = (i3 + width) - ((width - this.mIndicatorLineWidth) / 2);
                ScrollableLine scrollableLine2 = this.mScrollableLine;
                if (scrollableLine2 != null) {
                    scrollableLine2.updateScrollLineWidth(f4, f5, this.mIndicatorLineEndColor, this.mIndicatorLineStartColor, f);
                }
            }
        }
    }

    private final void linkageScrollTitleParentToCenter(int i, float f) {
        int i2;
        int i3;
        LinearLayout linearLayout = this.mTabParentView;
        if (linearLayout != null) {
            if (linearLayout == null) {
                b41.u();
            }
            if (i < linearLayout.getChildCount()) {
                LinearLayout linearLayout2 = this.mTabParentView;
                if (linearLayout2 == null) {
                    b41.u();
                }
                View childAt = linearLayout2.getChildAt(i);
                if (childAt != null) {
                    i3 = childAt.getRight();
                    i2 = childAt.getWidth();
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                LinearLayout linearLayout3 = this.mTabParentView;
                if (linearLayout3 == null) {
                    b41.u();
                }
                View childAt2 = linearLayout3.getChildAt(i + 1);
                int width = childAt2 != null ? childAt2.getWidth() : 0;
                jw2 jw2Var = jw2.INSTANCE;
                Context context = getContext();
                b41.e(context, WPKFactory.INIT_KEY_CONTEXT);
                int i4 = i2 / 2;
                int c = ((int) (((width / 2) + i4) * f)) + ((i3 - i4) - (((jw2Var.c(context) - getPaddingLeft()) - getPaddingRight()) / 2));
                HorizontalScrollView horizontalScrollView = this.mAutoScrollHorizontalScrollView;
                if (horizontalScrollView != null) {
                    if (horizontalScrollView == null) {
                        b41.u();
                    }
                    horizontalScrollView.scrollTo(c, 0);
                }
            }
        }
    }

    private final void setTabTitleTextView(TextView textView, int i, PagerAdapter pagerAdapter) {
        if (textView != null) {
            ViewPager viewPager = this.mViewPager;
            if (viewPager == null) {
                b41.u();
            }
            if (i == viewPager.getCurrentItem()) {
                textView.setTextSize(0, this.mTabSelectedTextSize);
                textView.setTextColor(this.mTabSelectedTextColor);
                textView.setTypeface(this.isTabSelectedTextBold ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            } else {
                textView.setTextSize(0, this.mTabNormalTextSize);
                textView.setTextColor(this.mTabNormalTextColor);
                textView.setTypeface(this.isTabNormalTextBold ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            }
            textView.setGravity(17);
            textView.setText((String) pagerAdapter.getPageTitle(i));
        }
    }

    private final void setTabViewLayoutParams(BasePagerTabView basePagerTabView, int i) {
        LinearLayout.LayoutParams layoutParams;
        int i2 = this.mPagerIndicatorMode;
        if (i2 != 1 && i2 != 3) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1);
        }
        layoutParams.gravity = 17;
        basePagerTabView.setLayoutParams(layoutParams);
        int i3 = this.mTabPadding;
        basePagerTabView.setPadding(i3, this.mTabPaddingTop, i3, this.mTabPaddingBottom);
        basePagerTabView.setOnClickListener(new b(i));
        if (basePagerTabView.getParent() == null) {
            LinearLayout linearLayout = this.mTabParentView;
            if (linearLayout == null) {
                b41.u();
            }
            linearLayout.addView(basePagerTabView);
        }
    }

    private final void tabTitleColorGradient(int i, float f) {
        TextView tabTextView;
        TextView tabTextView2;
        LinearLayout linearLayout = this.mTabParentView;
        if (linearLayout != null) {
            if (linearLayout == null) {
                b41.u();
            }
            if (i < linearLayout.getChildCount()) {
                LinearLayout linearLayout2 = this.mTabParentView;
                if (linearLayout2 == null) {
                    b41.u();
                }
                View childAt = linearLayout2.getChildAt(i);
                if ((childAt instanceof BasePagerTabView) && (tabTextView2 = ((BasePagerTabView) childAt).getTabTextView()) != null) {
                    tabTextView2.setTextColor(jw2.INSTANCE.b(this.mTabSelectedTextColor, this.mTabNormalTextColor, f));
                }
                LinearLayout linearLayout3 = this.mTabParentView;
                if (linearLayout3 == null) {
                    b41.u();
                }
                View childAt2 = linearLayout3.getChildAt(i + 1);
                if (!(childAt2 instanceof BasePagerTabView) || (tabTextView = ((BasePagerTabView) childAt2).getTabTextView()) == null) {
                    return;
                }
                tabTextView.setTextColor(jw2.INSTANCE.b(this.mTabNormalTextColor, this.mTabSelectedTextColor, f));
            }
        }
    }

    private final void tabTitleSizeGradient(int i, float f) {
        TextView tabTextView;
        TextView tabTextView2;
        LinearLayout linearLayout = this.mTabParentView;
        if (linearLayout != null) {
            if (linearLayout == null) {
                b41.u();
            }
            if (i < linearLayout.getChildCount()) {
                LinearLayout linearLayout2 = this.mTabParentView;
                if (linearLayout2 == null) {
                    b41.u();
                }
                View childAt = linearLayout2.getChildAt(i);
                if ((childAt instanceof BasePagerTabView) && (tabTextView2 = ((BasePagerTabView) childAt).getTabTextView()) != null) {
                    float f2 = this.mTabSelectedTextSize;
                    tabTextView2.setTextSize(0, f2 - (Math.abs(f2 - this.mTabNormalTextSize) * f));
                }
                LinearLayout linearLayout3 = this.mTabParentView;
                if (linearLayout3 == null) {
                    b41.u();
                }
                View childAt2 = linearLayout3.getChildAt(i + 1);
                if (!(childAt2 instanceof BasePagerTabView) || (tabTextView = ((BasePagerTabView) childAt2).getTabTextView()) == null) {
                    return;
                }
                tabTextView.setTextSize(0, (Math.abs(this.mTabSelectedTextSize - this.mTabNormalTextSize) * f) + this.mTabNormalTextSize);
            }
        }
    }

    private final void transactionScrollTitleParentToCenter(int i) {
        LinearLayout linearLayout = this.mTabParentView;
        if (linearLayout == null) {
            b41.u();
        }
        View childAt = linearLayout.getChildAt(i);
        b41.e(childAt, "mTabParentView!!.getChildAt(position)");
        int left = childAt.getLeft();
        LinearLayout linearLayout2 = this.mTabParentView;
        if (linearLayout2 == null) {
            b41.u();
        }
        View childAt2 = linearLayout2.getChildAt(i);
        b41.e(childAt2, "mTabParentView!!.getChildAt(position)");
        int width = childAt2.getWidth();
        jw2 jw2Var = jw2.INSTANCE;
        Context context = getContext();
        b41.e(context, WPKFactory.INIT_KEY_CONTEXT);
        int c = ((jw2Var.c(context) - getPaddingLeft()) - getPaddingRight()) / 2;
        HorizontalScrollView horizontalScrollView = this.mAutoScrollHorizontalScrollView;
        if (horizontalScrollView != null) {
            if (horizontalScrollView == null) {
                b41.u();
            }
            horizontalScrollView.smoothScrollTo((left + (width / 2)) - c, 0);
        }
    }

    private final void transformScrollIndicator(int i, float f) {
        LinearLayout linearLayout = this.mTabParentView;
        if (linearLayout != null) {
            if (linearLayout == null) {
                b41.u();
            }
            View childAt = linearLayout.getChildAt(i);
            b41.e(childAt, "positionView");
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            LinearLayout linearLayout2 = this.mTabParentView;
            if (linearLayout2 == null) {
                b41.u();
            }
            View childAt2 = linearLayout2.getChildAt(i + 1);
            int width2 = childAt2 != null ? childAt2.getWidth() : 0;
            int i2 = this.mIndicatorLineWidth;
            float f2 = (((width - ((width - i2) >> 1)) + ((width2 - i2) >> 1)) * f) + ((width - i2) / 2) + left;
            float right = ((((width - i2) / 2) + (width2 - ((width2 - i2) / 2))) * f) + (childAt.getRight() - ((width - this.mIndicatorLineWidth) >> 1));
            ScrollableLine scrollableLine = this.mScrollableLine;
            if (scrollableLine != null) {
                int i3 = this.mIndicatorLineStartColor;
                scrollableLine.updateScrollLineWidth(f2, right, i3, i3, f);
            }
        }
    }

    private final void updateTitleStyle(int i) {
        TextView tabTextView;
        LinearLayout linearLayout = this.mTabParentView;
        if (linearLayout == null) {
            throw new RuntimeException("TitleParentView is null");
        }
        if (linearLayout == null) {
            b41.u();
        }
        int childCount = linearLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            LinearLayout linearLayout2 = this.mTabParentView;
            if (linearLayout2 == null) {
                b41.u();
            }
            View childAt = linearLayout2.getChildAt(i2);
            if ((childAt instanceof BasePagerTabView) && (tabTextView = ((BasePagerTabView) childAt).getTabTextView()) != null) {
                if (i == i2) {
                    tabTextView.setTextColor(this.mTabSelectedTextColor);
                    tabTextView.setTypeface(this.isTabSelectedTextBold ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
                    tabTextView.setTextSize(0, this.mTabSelectedTextSize);
                } else {
                    tabTextView.setTextColor(this.mTabNormalTextColor);
                    tabTextView.setTypeface(this.isTabNormalTextBold ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
                    tabTextView.setTextSize(0, this.mTabNormalTextSize);
                }
            }
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @NotNull
    public BasePagerTabView createTabView(@NotNull Context context, @NotNull PagerAdapter pagerAdapter, int i) {
        b41.j(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.j(pagerAdapter, "pagerAdapter");
        return new PagerTabView(context, null, 0, 6, null);
    }

    @Nullable
    public final BasePagerTabView getPagerTabView(int i) {
        LinearLayout linearLayout = this.mTabParentView;
        if (linearLayout != null) {
            if (linearLayout == null) {
                b41.u();
            }
            if (i < linearLayout.getChildCount()) {
                LinearLayout linearLayout2 = this.mTabParentView;
                if (linearLayout2 == null) {
                    b41.u();
                }
                View childAt = linearLayout2.getChildAt(i);
                if (childAt != null) {
                    return (BasePagerTabView) childAt;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.kcrason.dynamicpagerindicatorlibrary.BasePagerTabView");
            }
        }
        return null;
    }

    @Nullable
    public final ViewPager getViewPager() {
        return this.mViewPager;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        OnOutPageChangeListener onOutPageChangeListener = this.mOnOutPageChangeListener;
        if (onOutPageChangeListener != null) {
            if (onOutPageChangeListener == null) {
                b41.u();
            }
            onOutPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        OnOutPageChangeListener onOutPageChangeListener = this.mOnOutPageChangeListener;
        if (onOutPageChangeListener != null) {
            if (onOutPageChangeListener == null) {
                b41.u();
            }
            onOutPageChangeListener.onPageScrolled(i, f, i2);
        }
        if (this.mIndicatorLineScrollMode == 1) {
            dynamicScrollIndicator(i, f);
        } else {
            transformScrollIndicator(i, f);
        }
        if (this.mTabTextColorMode == 2) {
            tabTitleColorGradient(i, f);
        }
        if (this.mTabTextSizeMode == 2) {
            tabTitleSizeGradient(i, f);
        }
        if (this.mCurrentPosition == i && f == 0.0f) {
            updateTitleStyle(i);
        }
        if (this.mPagerIndicatorMode == 1 && this.mPagerIndicatorScrollToCenterMode == 1) {
            linkageScrollTitleParentToCenter(i, f);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentPosition = i;
        OnOutPageChangeListener onOutPageChangeListener = this.mOnOutPageChangeListener;
        if (onOutPageChangeListener != null) {
            if (onOutPageChangeListener == null) {
                b41.u();
            }
            onOutPageChangeListener.onPageSelected(i);
        }
        updateTitleStyle(i);
        if (this.mPagerIndicatorMode == 1 && this.mPagerIndicatorScrollToCenterMode == 2) {
            transactionScrollTitleParentToCenter(i);
        }
    }

    public final void setOnItemTabClickListener(@NotNull OnItemTabClickListener onItemTabClickListener) {
        b41.j(onItemTabClickListener, "onItemTabClickListener");
        this.mOnItemTabClickListener = onItemTabClickListener;
    }

    public final void setOnOutPageChangeListener(@NotNull OnOutPageChangeListener onOutPageChangeListener) {
        b41.j(onOutPageChangeListener, "onOutPageChangeListener");
        this.mOnOutPageChangeListener = onOutPageChangeListener;
    }

    public final void setViewPager(@Nullable ViewPager viewPager) {
        if (viewPager != null && viewPager.getAdapter() != null) {
            this.mViewPager = viewPager;
            viewPager.addOnPageChangeListener(this);
            updateIndicator(false);
            if (this.mPagerIndicatorMode == 1) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                relativeLayout.addView(this.mTabParentView);
                relativeLayout.addView(addScrollableLine());
                HorizontalScrollView horizontalScrollView = new HorizontalScrollView(getContext());
                this.mAutoScrollHorizontalScrollView = horizontalScrollView;
                horizontalScrollView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                HorizontalScrollView horizontalScrollView2 = this.mAutoScrollHorizontalScrollView;
                if (horizontalScrollView2 == null) {
                    b41.u();
                }
                horizontalScrollView2.setHorizontalScrollBarEnabled(false);
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                linearLayout.setOrientation(1);
                linearLayout.addView(relativeLayout);
                HorizontalScrollView horizontalScrollView3 = this.mAutoScrollHorizontalScrollView;
                if (horizontalScrollView3 == null) {
                    b41.u();
                }
                horizontalScrollView3.addView(linearLayout);
                addView(this.mAutoScrollHorizontalScrollView);
                return;
            }
            addView(this.mTabParentView);
            addView(addScrollableLine());
            return;
        }
        throw new RuntimeException("viewpager or pager adapter is null");
    }

    public final void updateIndicator(boolean z) {
        View createTabView;
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            if (viewPager == null) {
                b41.u();
            }
            if (viewPager.getAdapter() == null) {
                return;
            }
            ViewPager viewPager2 = this.mViewPager;
            if (viewPager2 == null) {
                b41.u();
            }
            PagerAdapter adapter = viewPager2.getAdapter();
            if (adapter == null) {
                b41.u();
            }
            int count = adapter.getCount();
            if (this.mTabParentView == null) {
                this.mTabParentView = createTabParentView();
            }
            LinearLayout linearLayout = this.mTabParentView;
            if (linearLayout == null) {
                b41.u();
            }
            int childCount = linearLayout.getChildCount();
            if (childCount > count) {
                LinearLayout linearLayout2 = this.mTabParentView;
                if (linearLayout2 == null) {
                    b41.u();
                }
                linearLayout2.removeViews(count, childCount - count);
            }
            int i = 0;
            while (i < count) {
                if (i < childCount) {
                    LinearLayout linearLayout3 = this.mTabParentView;
                    if (linearLayout3 == null) {
                        b41.u();
                    }
                    createTabView = linearLayout3.getChildAt(i);
                    b41.e(createTabView, "mTabParentView!!.getChildAt(i)");
                } else {
                    Context context = getContext();
                    b41.e(context, WPKFactory.INIT_KEY_CONTEXT);
                    createTabView = createTabView(context, adapter, i);
                }
                if (createTabView instanceof BasePagerTabView) {
                    BasePagerTabView basePagerTabView = (BasePagerTabView) createTabView;
                    setTabTitleTextView(basePagerTabView.getTabTextView(), i, adapter);
                    setTabViewLayoutParams(basePagerTabView, i);
                    i++;
                } else {
                    throw new IllegalArgumentException("childView must be BasePagerTabView");
                }
            }
            if (z) {
                post(new Runnable() { // from class: com.kcrason.dynamicpagerindicatorlibrary.DynamicPagerIndicator$updateIndicator$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        DynamicPagerIndicator dynamicPagerIndicator = DynamicPagerIndicator.this;
                        ViewPager viewPager3 = dynamicPagerIndicator.mViewPager;
                        if (viewPager3 == null) {
                            b41.u();
                        }
                        dynamicPagerIndicator.onPageScrolled(viewPager3.getCurrentItem(), 0.0f, 0);
                        DynamicPagerIndicator dynamicPagerIndicator2 = DynamicPagerIndicator.this;
                        ViewPager viewPager4 = dynamicPagerIndicator2.mViewPager;
                        if (viewPager4 == null) {
                            b41.u();
                        }
                        dynamicPagerIndicator2.onPageSelected(viewPager4.getCurrentItem());
                    }
                });
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DynamicPagerIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.j(context, WPKFactory.INIT_KEY_CONTEXT);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DynamicPagerIndicator);
        int i2 = R$styleable.DynamicPagerIndicator_tabPadding;
        jw2 jw2Var = jw2.INSTANCE;
        this.mTabPadding = (int) obtainStyledAttributes.getDimension(i2, jw2Var.a(context, 16.0f));
        this.mTabPaddingBottom = (int) obtainStyledAttributes.getDimension(R$styleable.DynamicPagerIndicator_tabPaddingBottom, 0.0f);
        this.mTabPaddingTop = (int) obtainStyledAttributes.getDimension(R$styleable.DynamicPagerIndicator_tabPaddingTop, 0.0f);
        this.mTabNormalTextColor = obtainStyledAttributes.getColor(R$styleable.DynamicPagerIndicator_tabNormalTextColor, Color.parseColor("#999999"));
        this.mTabSelectedTextColor = obtainStyledAttributes.getColor(R$styleable.DynamicPagerIndicator_tabSelectedTextColor, Color.parseColor("#222230"));
        this.isTabNormalTextBold = obtainStyledAttributes.getBoolean(R$styleable.DynamicPagerIndicator_isTabNormalTextBold, false);
        this.isTabSelectedTextBold = obtainStyledAttributes.getBoolean(R$styleable.DynamicPagerIndicator_isTabSelectedTextBold, false);
        this.mTabNormalTextSize = obtainStyledAttributes.getDimension(R$styleable.DynamicPagerIndicator_tabNormalTextSize, jw2Var.d(context, 18.0f));
        this.mTabSelectedTextSize = obtainStyledAttributes.getDimension(R$styleable.DynamicPagerIndicator_tabSelectedTextSize, jw2Var.d(context, 18.0f));
        this.mTabTextColorMode = obtainStyledAttributes.getInt(R$styleable.DynamicPagerIndicator_tabTextColorMode, 1);
        this.mTabTextSizeMode = obtainStyledAttributes.getInt(R$styleable.DynamicPagerIndicator_tabTextSizeMode, 1);
        this.mIndicatorLineHeight = (int) obtainStyledAttributes.getDimension(R$styleable.DynamicPagerIndicator_indicatorLineHeight, jw2Var.a(context, 4.0f));
        this.mIndicatorLineWidth = (int) obtainStyledAttributes.getDimension(R$styleable.DynamicPagerIndicator_indicatorLineWidth, jw2Var.a(context, 40.0f));
        this.mIndicatorLineRadius = obtainStyledAttributes.getDimension(R$styleable.DynamicPagerIndicator_indicatorLineRadius, 0.0f);
        this.mIndicatorLineScrollMode = obtainStyledAttributes.getInt(R$styleable.DynamicPagerIndicator_indicatorLineScrollMode, 1);
        this.mIndicatorLineStartColor = obtainStyledAttributes.getColor(R$styleable.DynamicPagerIndicator_indicatorLineStartColor, Color.parseColor("#f4ce46"));
        this.mIndicatorLineEndColor = obtainStyledAttributes.getColor(R$styleable.DynamicPagerIndicator_indicatorLineEndColor, Color.parseColor("#ff00ff"));
        this.mIndicatorLineMarginTop = (int) obtainStyledAttributes.getDimension(R$styleable.DynamicPagerIndicator_indicatorLineMarginTop, 0.0f);
        this.mIndicatorLineMarginBottom = (int) obtainStyledAttributes.getDimension(R$styleable.DynamicPagerIndicator_indicatorLineMarginBottom, 0.0f);
        this.mPagerIndicatorMode = obtainStyledAttributes.getInt(R$styleable.DynamicPagerIndicator_pagerIndicatorMode, 2);
        this.mPagerIndicatorScrollToCenterMode = obtainStyledAttributes.getInt(R$styleable.DynamicPagerIndicator_pagerIndicatorScrollToCenterMode, 1);
        obtainStyledAttributes.recycle();
    }
}
