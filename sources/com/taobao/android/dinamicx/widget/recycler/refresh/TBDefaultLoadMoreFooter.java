package com.taobao.android.dinamicx.widget.recycler.refresh;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.taobao.android.dinamic.R$color;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.R$string;
import com.taobao.android.dinamicx.widget.recycler.refresh.TBLoadMoreFooter;
import com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TBDefaultLoadMoreFooter extends TBLoadMoreFooter {
    private String[] mDefaultLoadMoreTips;
    private String[] mLoadMoreTips;
    private TextView mLoadMoreView;
    private CustomProgressBar mProgressbar;
    private TBLoadMoreFooter.LoadMoreState mState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.refresh.TBDefaultLoadMoreFooter$a */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class C6519a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TBLoadMoreFooter.LoadMoreState.values().length];
            a = iArr;
            try {
                iArr[TBLoadMoreFooter.LoadMoreState.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TBLoadMoreFooter.LoadMoreState.PUSH_TO_LOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TBLoadMoreFooter.LoadMoreState.RELEASE_TO_LOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[TBLoadMoreFooter.LoadMoreState.LOADING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public TBDefaultLoadMoreFooter(Context context) {
        super(context);
        TBLoadMoreFooter.LoadMoreState loadMoreState = TBLoadMoreFooter.LoadMoreState.NONE;
        this.mState = loadMoreState;
        Context context2 = getContext();
        int i = R$string.uik_load_more;
        Context context3 = getContext();
        int i2 = R$string.uik_release_to_load;
        Context context4 = getContext();
        int i3 = R$string.uik_loading;
        Context context5 = getContext();
        int i4 = R$string.uik_load_more_finished;
        this.mDefaultLoadMoreTips = new String[]{context2.getString(i), context3.getString(i2), context4.getString(i3), context5.getString(i4)};
        this.mLoadMoreTips = new String[]{getContext().getString(i), getContext().getString(i2), getContext().getString(i3), getContext().getString(i4)};
        float f = getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        linearLayout.setGravity(1);
        int i5 = (int) (12.0f * f);
        linearLayout.setPadding(0, i5, 0, 0);
        addView(linearLayout, layoutParams);
        CustomProgressBar customProgressBar = new CustomProgressBar(context);
        this.mProgressbar = customProgressBar;
        customProgressBar.setId(R$id.uik_load_more_footer_progress);
        int i6 = (int) (f * 28.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i6, i6);
        layoutParams2.rightMargin = i5;
        this.mProgressbar.setVisibility(8);
        linearLayout.addView(this.mProgressbar, layoutParams2);
        TextView textView = new TextView(context);
        this.mLoadMoreView = textView;
        textView.setId(R$id.uik_load_more_footer_text);
        this.mLoadMoreView.setText(i);
        this.mLoadMoreView.setTextSize(1, 10.0f);
        this.mLoadMoreView.setGravity(16);
        this.mLoadMoreView.setTextColor(Color.parseColor("#444444"));
        linearLayout.addView(this.mLoadMoreView, new LinearLayout.LayoutParams(-2, i6));
        setBackgroundResource(R$color.uik_load_more_footer_bg);
        changeToState(loadMoreState);
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBLoadMoreFooter
    public void changeToState(TBLoadMoreFooter.LoadMoreState loadMoreState) {
        TBLoadMoreFooter.LoadMoreState loadMoreState2;
        if (this.mLoadMoreView == null || (loadMoreState2 = this.mState) == loadMoreState) {
            return;
        }
        TBSwipeRefreshLayout.OnPushLoadMoreListener onPushLoadMoreListener = this.mPushLoadMoreListener;
        if (onPushLoadMoreListener != null) {
            onPushLoadMoreListener.onLoadMoreStateChanged(loadMoreState2, loadMoreState);
        }
        this.mState = loadMoreState;
        int i = C6519a.a[loadMoreState.ordinal()];
        if (i == 1) {
            this.mProgressbar.stopLoadingAnimation();
            this.mProgressbar.setVisibility(8);
            TextView textView = this.mLoadMoreView;
            String[] strArr = this.mLoadMoreTips;
            textView.setText(strArr == null ? this.mDefaultLoadMoreTips[3] : strArr[3]);
        } else if (i == 2) {
            this.mProgressbar.stopLoadingAnimation();
            this.mProgressbar.setVisibility(8);
            TextView textView2 = this.mLoadMoreView;
            String[] strArr2 = this.mLoadMoreTips;
            textView2.setText(strArr2 == null ? this.mDefaultLoadMoreTips[0] : strArr2[0]);
            setVisibility(0);
        } else if (i == 3) {
            this.mProgressbar.stopLoadingAnimation();
            this.mProgressbar.setVisibility(8);
            TextView textView3 = this.mLoadMoreView;
            String[] strArr3 = this.mLoadMoreTips;
            textView3.setText(strArr3 == null ? this.mDefaultLoadMoreTips[1] : strArr3[1]);
            setVisibility(0);
        } else if (i != 4) {
        } else {
            this.mProgressbar.setVisibility(0);
            this.mProgressbar.startLoadingAnimaton();
            TextView textView4 = this.mLoadMoreView;
            String[] strArr4 = this.mLoadMoreTips;
            textView4.setText(strArr4 == null ? this.mDefaultLoadMoreTips[2] : strArr4[2]);
            setVisibility(0);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBLoadMoreFooter
    public TBLoadMoreFooter.LoadMoreState getCurrentState() {
        return this.mState;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBLoadMoreFooter
    public TextView getLoadMoreTipView() {
        return this.mLoadMoreView;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBLoadMoreFooter
    public void setLoadMoreTipColor(@ColorInt int i) {
        TextView textView = this.mLoadMoreView;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBLoadMoreFooter
    public void setLoadMoreTips(String[] strArr) {
        if (strArr == null || strArr.length != 4) {
            this.mLoadMoreTips = null;
        }
        this.mLoadMoreTips = strArr;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBLoadMoreFooter
    public void setProgress(float f) {
    }
}
