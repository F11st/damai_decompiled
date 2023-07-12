package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baseproject.ui.R$dimen;
import com.baseproject.ui.R$layout;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class LoadingMoreFooter_Logo extends LoadingMoreFooter {
    private View logo_view;

    public LoadingMoreFooter_Logo(Context context) {
        super(context);
    }

    @Override // com.youku.widget.LoadingMoreFooter
    public void initView() {
        super.initView();
        setProgressStyle();
        this.logo_view = LayoutInflater.from(this.context).inflate(R$layout.loading_more_footer_logo, (ViewGroup) null);
    }

    @Override // com.youku.widget.LoadingMoreFooter
    public void setProgressStyle() {
        super.setProgressStyle();
    }

    @Override // com.youku.widget.LoadingMoreFooter, com.youku.widget.FooterImpl
    public void setState(int i) {
        super.setState(i);
        if (i != 2) {
            removeView(this.logo_view);
            this.mText.setVisibility(0);
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R$dimen.tab_guess_videos_login_width));
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        setGravity(17);
        addView(this.logo_view, new LinearLayout.LayoutParams(-1, -1));
        this.mText.setVisibility(8);
        this.progressCon.setVisibility(8);
    }

    public LoadingMoreFooter_Logo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
