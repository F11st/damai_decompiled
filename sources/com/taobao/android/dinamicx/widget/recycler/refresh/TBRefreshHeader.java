package com.taobao.android.dinamicx.widget.recycler.refresh;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.taobao.android.dinamic.R$color;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.R$string;
import com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader;
import com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TBRefreshHeader extends TBAbsRefreshHeader {
    private static Typeface sIconfont;
    private static int sReference;
    private TextView mArrowTextView;
    private String[] mDefaultRefreshTips;
    private ObjectAnimator mFadeAnimationSet;
    private RefreshHeadView mRefreshHeadView;
    private FrameLayout mRefreshHeaderView;
    private CustomProgressBar mRefreshProgressView;
    private TextView mRefreshTipView;
    private String[] mRefreshTips;
    private View mSecondFloorView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.refresh.TBRefreshHeader$a */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class C6520a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TBAbsRefreshHeader.RefreshState.values().length];
            a = iArr;
            try {
                iArr[TBAbsRefreshHeader.RefreshState.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TBAbsRefreshHeader.RefreshState.PULL_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TBAbsRefreshHeader.RefreshState.RELEASE_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[TBAbsRefreshHeader.RefreshState.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[TBAbsRefreshHeader.RefreshState.PREPARE_TO_SECOND_FLOOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[TBAbsRefreshHeader.RefreshState.SECOND_FLOOR_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[TBAbsRefreshHeader.RefreshState.SECOND_FLOOR_END.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public TBRefreshHeader(Context context) {
        super(context);
        Context context2 = getContext();
        int i = R$string.uik_pull_to_refresh;
        Context context3 = getContext();
        int i2 = R$string.uik_release_to_refresh;
        Context context4 = getContext();
        int i3 = R$string.uik_refreshing;
        Context context5 = getContext();
        int i4 = R$string.uik_refresh_finished;
        this.mDefaultRefreshTips = new String[]{context2.getString(i), context3.getString(i2), context4.getString(i3), context5.getString(i4)};
        this.mRefreshTips = new String[]{getContext().getString(i), getContext().getString(i2), getContext().getString(i3), getContext().getString(i4)};
        this.mRefreshHeaderView = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.mRefreshHeaderView.setId(R$id.uik_refresh_header);
        addView(this.mRefreshHeaderView, layoutParams);
        this.mSecondFloorView = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.mSecondFloorView.setId(R$id.uik_refresh_header_second_floor);
        this.mRefreshHeaderView.addView(this.mSecondFloorView, layoutParams2);
        setBackgroundResource(R$color.uik_refresh_head_bg);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        RefreshHeadView refreshHeadView = new RefreshHeadView(context, R$string.uik_refresh_arrow, null, false);
        this.mRefreshHeadView = refreshHeadView;
        this.mRefreshHeaderView.addView(refreshHeadView, layoutParams3);
        this.mRefreshTipView = this.mRefreshHeadView.getRefreshStateText();
        this.mRefreshProgressView = this.mRefreshHeadView.getProgressbar();
        this.mArrowTextView = this.mRefreshHeadView.getArrow();
        changeToState(TBAbsRefreshHeader.RefreshState.NONE);
    }

    private void showArrow() {
        ObjectAnimator objectAnimator = this.mFadeAnimationSet;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.mArrowTextView.setScaleX(1.0f);
        this.mArrowTextView.setScaleY(1.0f);
        this.mArrowTextView.setAlpha(1.0f);
        this.mArrowTextView.setVisibility(0);
    }

    private void startArrowAnim() {
        if (this.mFadeAnimationSet == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mArrowTextView, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.0f), PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f));
            this.mFadeAnimationSet = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(new AccelerateDecelerateInterpolator());
            this.mFadeAnimationSet.setDuration(200L);
        }
        this.mFadeAnimationSet.start();
    }

    public void changeHeaderAlpha(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.mRefreshHeadView.setAlpha(f);
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader
    public void changeToState(TBAbsRefreshHeader.RefreshState refreshState) {
        TBAbsRefreshHeader.RefreshState refreshState2;
        if (this.mRefreshProgressView == null || (refreshState2 = this.mState) == refreshState) {
            return;
        }
        TBSwipeRefreshLayout.OnPullRefreshListener onPullRefreshListener = this.mPullRefreshListener;
        if (onPullRefreshListener != null) {
            onPullRefreshListener.onRefreshStateChanged(refreshState2, refreshState);
        }
        this.mState = refreshState;
        int i = C6520a.a[refreshState.ordinal()];
        if (i == 1) {
            this.mRefreshProgressView.stopLoadingAnimation();
            TextView textView = this.mRefreshTipView;
            String[] strArr = this.mRefreshTips;
            textView.setText(strArr == null ? this.mDefaultRefreshTips[3] : strArr[3]);
            this.mRefreshProgressView.stopLoadingAnimation();
            changeHeaderAlpha(1.0f);
        } else if (i == 2) {
            showArrow();
            this.mRefreshTipView.setVisibility(0);
            TextView textView2 = this.mRefreshTipView;
            String[] strArr2 = this.mRefreshTips;
            textView2.setText(strArr2 == null ? this.mDefaultRefreshTips[0] : strArr2[0]);
            this.mRefreshHeadView.setVisibility(0);
        } else if (i == 3) {
            startArrowAnim();
            TextView textView3 = this.mRefreshTipView;
            String[] strArr3 = this.mRefreshTips;
            textView3.setText(strArr3 == null ? this.mDefaultRefreshTips[1] : strArr3[1]);
            this.mRefreshHeadView.setVisibility(0);
        } else if (i != 4) {
            if (i != 5) {
                return;
            }
            this.mRefreshHeadView.setVisibility(8);
        } else {
            this.mRefreshProgressView.startLoadingAnimaton();
            this.mRefreshProgressView.setVisibility(0);
            this.mArrowTextView.setVisibility(4);
            TextView textView4 = this.mRefreshTipView;
            String[] strArr4 = this.mRefreshTips;
            textView4.setText(strArr4 == null ? this.mDefaultRefreshTips[2] : strArr4[2]);
            this.mRefreshHeadView.setVisibility(0);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader
    public View getRefreshView() {
        return this.mRefreshHeadView;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader
    public View getSecondFloorView() {
        return this.mSecondFloorView;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mRefreshProgressView.setPullDownDistance(getMeasuredHeight());
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader
    public void setProgress(float f) {
        if (this.mState == TBAbsRefreshHeader.RefreshState.PULL_TO_REFRESH) {
            if (getMeasuredHeight() != 0) {
                this.mRefreshProgressView.changeProgressBarState((int) (getMeasuredHeight() * f));
            }
            changeHeaderAlpha(f);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader
    public void setRefreshAnimation(String[] strArr, @Nullable String str) {
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader
    public void setRefreshTipColor(@ColorInt int i) {
        TextView textView = this.mRefreshTipView;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setRefreshTipSize(int i) {
        TextView textView = this.mRefreshTipView;
        if (textView != null) {
            textView.setTextSize(i);
            this.mRefreshTipView.setSingleLine(true);
            this.mRefreshTipView.setMaxLines(1);
            ViewGroup.LayoutParams layoutParams = this.mRefreshTipView.getLayoutParams();
            layoutParams.width = -2;
            this.mRefreshTipView.setLayoutParams(layoutParams);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader
    public void setRefreshTips(String[] strArr) {
        if (strArr != null && strArr.length == 4) {
            this.mRefreshTips = strArr;
        } else {
            this.mRefreshTips = null;
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader
    public void setSecondFloorView(View view) {
        FrameLayout.LayoutParams layoutParams;
        FrameLayout.LayoutParams layoutParams2;
        if (this.mSecondFloorView != null) {
            if (this.mRefreshHeaderView != null) {
                if (view.getLayoutParams() == null) {
                    layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                } else {
                    layoutParams2 = new FrameLayout.LayoutParams(view.getLayoutParams());
                }
                layoutParams2.gravity = 80;
                this.mRefreshHeaderView.removeView(this.mSecondFloorView);
                this.mRefreshHeaderView.addView(view, 0, layoutParams2);
                this.mSecondFloorView = view;
                view.setId(R$id.uik_refresh_header_second_floor);
            }
        } else if (this.mRefreshHeaderView != null) {
            if (view.getLayoutParams() == null) {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            } else {
                layoutParams = new FrameLayout.LayoutParams(view.getLayoutParams());
            }
            layoutParams.gravity = 80;
            this.mRefreshHeaderView.addView(view, 0, layoutParams);
            this.mSecondFloorView = view;
            view.setId(R$id.uik_refresh_header_second_floor);
        }
    }
}
