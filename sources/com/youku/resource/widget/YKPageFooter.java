package com.youku.resource.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import anet.channel.status.NetworkStatusHelper;
import com.youku.resource.R;
import com.youku.resource.utils.AppPerfABUtils;
import com.youku.resource.utils.ColorConfigureManager;
import com.youku.resource.utils.DimenUtils;
import com.youku.resource.utils.DynamicColorDefine;
import com.youku.widget.FooterImpl;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKPageFooter extends FrameLayout implements FooterImpl {
    public static final int FOOTER_HEIGHT_DP_LOADING = 63;
    public static final int FOOTER_HEIGHT_DP_NOMORE = 53;
    public static final String REFRESH_FOOTER_FAIL = "未获取到内容，请刷新重试";
    public static final String REFRESH_FOOTER_FAIL_NETWORK = "您还没有连接网络";
    public static final String REFRESH_FOOTER_INIT = "";
    public static final String REFRESH_FOOTER_LOADING = "正在加载中...";
    public static final String REFRESH_FOOTER_NOTHING = "呀~到底啦！不如去看看其它精彩内容~";
    public static final String REFRESH_FOOTER_SUCCESS = "";
    public static final int STATE_COMPLETE_FAIL = 2;
    public static final int STATE_COMPLETE_SUCCESS = 1;
    public static final int STATE_LOADING = 0;
    public static final int STATE_NOMORE = 3;
    @Deprecated
    protected ImageView footerLogo;
    protected FrameLayout loadingLayout;
    protected TextView loadingText;
    protected YKLoading mLoading;
    private boolean noMoreHintStay;
    protected FrameLayout noMoreLayout;
    protected TextView noMoreText;
    private String noMoreTextStr;
    public static int footer_text_color_default = Color.parseColor("#B4B4B4");
    public static final int footer_logo_color_default = Color.parseColor("#1E000000");

    public YKPageFooter(Context context) {
        super(context);
        this.noMoreHintStay = false;
        this.noMoreTextStr = REFRESH_FOOTER_NOTHING;
        initView(context);
    }

    private TextView getNoMoreText() {
        return this.noMoreText;
    }

    public TextView getLoadingText() {
        return this.loadingText;
    }

    protected void handleLoading() {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.loadingLayout.setVisibility(0);
        if (!AppPerfABUtils.isOpenDegrade()) {
            this.loadingText.setVisibility(8);
            YKLoading yKLoading = this.mLoading;
            if (yKLoading != null) {
                yKLoading.setVisibility(0);
                this.mLoading.startAnimation();
            }
        } else {
            YKLoading yKLoading2 = this.mLoading;
            if (yKLoading2 != null) {
                yKLoading2.setVisibility(8);
            }
            this.loadingText.setVisibility(0);
            this.loadingText.setText(REFRESH_FOOTER_LOADING);
        }
        this.noMoreLayout.setVisibility(8);
    }

    protected void handleLoadingFinishFail() {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        YKLoading yKLoading = this.mLoading;
        if (yKLoading != null && yKLoading.getVisibility() == 0) {
            this.mLoading.stopAnimation();
            this.mLoading.setVisibility(8);
        }
        this.loadingText.setVisibility(0);
        this.loadingText.setText(NetworkStatusHelper.n() ? REFRESH_FOOTER_FAIL : REFRESH_FOOTER_FAIL_NETWORK);
        this.noMoreLayout.setVisibility(8);
    }

    protected void handleLoadingFinishSuccess() {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        YKLoading yKLoading = this.mLoading;
        if (yKLoading != null && yKLoading.getVisibility() == 0) {
            this.mLoading.stopAnimation();
            this.mLoading.setVisibility(8);
        }
        this.loadingText.setVisibility(0);
        this.loadingText.setText("");
        this.noMoreLayout.setVisibility(8);
    }

    protected void handleNoMore() {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        YKLoading yKLoading = this.mLoading;
        if (yKLoading != null && yKLoading.getVisibility() == 0) {
            this.mLoading.stopAnimation();
            this.mLoading.setVisibility(8);
        }
        this.loadingText.setVisibility(0);
        this.loadingText.setText("");
        this.loadingLayout.setVisibility(8);
        this.noMoreLayout.setVisibility(0);
        this.noMoreText.setText(this.noMoreTextStr);
    }

    protected void initLoading(Context context) {
        TextView textView = new TextView(context);
        this.loadingText = textView;
        textView.setGravity(17);
        this.loadingText.setTextColor(footer_text_color_default);
        this.loadingText.setText(REFRESH_FOOTER_LOADING);
        this.loadingText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.font_size_middle4));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.loadingText.setLayoutParams(layoutParams);
        this.loadingLayout.addView(this.loadingText);
        if (AppPerfABUtils.isOpenDegrade()) {
            return;
        }
        this.mLoading = (YKLoading) LayoutInflater.from(context).inflate(R.C8074layout.resource_yk_loading, (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.mLoading.setLayoutParams(layoutParams2);
        this.loadingLayout.addView(this.mLoading);
    }

    protected void initNoMore(Context context) {
        TextView textView = new TextView(context);
        this.noMoreText = textView;
        textView.setText(this.noMoreTextStr);
        this.noMoreText.setTextColor(footer_text_color_default);
        this.noMoreText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.font_size_middle4));
        this.noMoreText.setGravity(17);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.resource_size_17));
        layoutParams.gravity = 48;
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.resource_size_9);
        this.noMoreText.setLayoutParams(layoutParams);
        this.noMoreLayout.addView(this.noMoreText);
    }

    protected void initView(Context context) {
        if (ColorConfigureManager.getInstance() != null && ColorConfigureManager.getInstance().getColorMap() != null) {
            footer_text_color_default = ColorConfigureManager.getInstance().getColorMap().get(DynamicColorDefine.YKN_QUATERNARY_INFO).intValue();
        }
        this.loadingLayout = new FrameLayout(context);
        this.loadingLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_63)));
        initLoading(context);
        addView(this.loadingLayout);
        this.noMoreLayout = new FrameLayout(context);
        this.noMoreLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_53)));
        initNoMore(context);
        addView(this.noMoreLayout);
    }

    @Override // com.youku.widget.FooterImpl
    public boolean isNoMoreHintStay() {
        return this.noMoreHintStay;
    }

    public void resetFooterColor() {
        this.loadingText.setTextColor(footer_text_color_default);
        this.noMoreText.setTextColor(footer_text_color_default);
    }

    public void setFooterColor(int i) {
        this.loadingText.setTextColor(i);
        this.noMoreText.setTextColor(i);
    }

    @Override // com.youku.widget.FooterImpl
    public void setNoMoreHintStay(boolean z) {
        this.noMoreHintStay = z;
    }

    public void setNoMoreText(String str) {
        if (TextUtils.equals(str, this.noMoreTextStr)) {
            return;
        }
        this.noMoreTextStr = str;
    }

    @Override // com.youku.widget.FooterImpl
    public void setState(int i) {
        if (i == 0) {
            handleLoading();
        } else if (i == 1) {
            handleLoadingFinishSuccess();
        } else if (i == 2) {
            handleLoadingFinishFail();
        } else if (i != 3) {
        } else {
            handleNoMore();
        }
    }

    public YKPageFooter(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.noMoreHintStay = false;
        this.noMoreTextStr = REFRESH_FOOTER_NOTHING;
        initView(context);
    }

    public YKPageFooter(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.noMoreHintStay = false;
        this.noMoreTextStr = REFRESH_FOOTER_NOTHING;
        initView(context);
    }
}
