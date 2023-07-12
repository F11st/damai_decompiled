package com.youku.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baseproject.ui.R$dimen;
import com.baseproject.ui.R$drawable;
import com.baseproject.ui.R$layout;
import com.baseproject.ui.R$string;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class LoadingMoreFooter extends LinearLayout implements FooterImpl {
    private static final int ROTATE_ANIM_DURATION = 400;
    public static final int STATE_COMPLETE = 1;
    public static final int STATE_LOADING = 0;
    public static final int STATE_NOMORE = 2;
    protected Context context;
    private boolean hasBottomPadding;
    private View mProgress;
    private RotateAnimation mRotateCircleAnim;
    protected TextView mText;
    private boolean noMoreHintStay;
    private View noMoreView;
    protected SimpleViewSwitcher progressCon;

    public LoadingMoreFooter(Context context) {
        super(context);
        this.noMoreHintStay = false;
        this.hasBottomPadding = false;
        this.context = context;
        initView();
    }

    public void initView() {
        setGravity(17);
        setBottomPadding(this.hasBottomPadding);
        setBackgroundColor(Color.parseColor("#ffFFFFFF"));
        SimpleViewSwitcher simpleViewSwitcher = new SimpleViewSwitcher(getContext());
        this.progressCon = simpleViewSwitcher;
        simpleViewSwitcher.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        addView(this.progressCon);
        TextView textView = new TextView(getContext());
        this.mText = textView;
        textView.setText(R$string.listview_loading);
        this.mText.setTextSize(0, getResources().getDimensionPixelOffset(R$dimen.home_card_item_text_size));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins((int) getResources().getDimension(R$dimen.textandiconmargin), 0, 0, 0);
        this.mText.setLayoutParams(layoutParams);
        addView(this.mText);
        this.noMoreView = LayoutInflater.from(getContext()).inflate(R$layout.collection_nomore_hor_line, (ViewGroup) this, false);
        this.noMoreView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.noMoreView);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateCircleAnim = rotateAnimation;
        rotateAnimation.setDuration(400L);
        this.mRotateCircleAnim.setRepeatCount(-1);
        this.mRotateCircleAnim.setRepeatMode(-1);
        this.mRotateCircleAnim.setInterpolator(new LinearInterpolator());
    }

    @Override // com.youku.widget.FooterImpl
    public boolean isNoMoreHintStay() {
        return this.noMoreHintStay;
    }

    public void setBottomPadding(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        this.hasBottomPadding = z;
        int dimensionPixelSize = z ? getResources().getDimensionPixelSize(R$dimen.skin_tab_page_bottom_margin) : 0;
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.home_card_item_box_title_layout_height);
        if (getLayoutParams() == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, dimensionPixelSize2 + dimensionPixelSize);
        } else {
            layoutParams = getLayoutParams();
        }
        layoutParams.width = -1;
        layoutParams.height = dimensionPixelSize2 + dimensionPixelSize;
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, dimensionPixelSize);
    }

    @Override // com.youku.widget.FooterImpl
    public void setNoMoreHintStay(boolean z) {
        this.noMoreHintStay = z;
    }

    public void setProgressStyle() {
        ImageView imageView = new ImageView(getContext());
        this.mProgress = imageView;
        this.progressCon.setView(imageView);
    }

    @Override // com.youku.widget.FooterImpl
    public void setState(int i) {
        if (i == 0) {
            View view = this.mProgress;
            if (view != null && this.progressCon != null) {
                YoukuLoading.show(this.context, (ImageView) view);
                this.progressCon.setVisibility(0);
                this.mProgress.setVisibility(0);
            }
            this.mText.setText(getContext().getText(R$string.listview_loading));
            this.mText.setTextColor(Color.parseColor("#666666"));
            setVisibility(0);
            this.noMoreView.setVisibility(8);
        } else if (i == 1) {
            View view2 = this.mProgress;
            if (view2 != null) {
                YoukuLoading.dismiss(this.context, (ImageView) view2);
            }
            this.mText.setText(getContext().getText(R$string.listview_loading));
            this.mText.setTextColor(Color.parseColor("#666666"));
            setVisibility(8);
        } else if (i == 2) {
            if (this.noMoreHintStay) {
                this.noMoreView.setVisibility(0);
                this.mText.setText(getContext().getText(R$string.nomore_loading));
                View view3 = this.mProgress;
                if (view3 != null) {
                    YoukuLoading.dismiss(this.context, (ImageView) view3);
                    ((ImageView) this.mProgress).setImageResource(R$drawable.personalized_no_more);
                    this.mProgress.setVisibility(8);
                    this.progressCon.setVisibility(8);
                }
                this.mText.setTextColor(Color.parseColor("#d4d4d4"));
                setVisibility(0);
            } else {
                this.mText.setText(getContext().getText(R$string.nomore_loading));
                View view4 = this.mProgress;
                if (view4 != null) {
                    YoukuLoading.dismiss(this.context, (ImageView) view4);
                    ((ImageView) this.mProgress).setImageResource(R$drawable.personalized_no_more);
                }
                this.mText.setTextColor(Color.parseColor("#d4d4d4"));
                setVisibility(8);
            }
        }
        this.mText.setVisibility(8);
    }

    public LoadingMoreFooter(Context context, boolean z) {
        super(context);
        this.noMoreHintStay = false;
        this.hasBottomPadding = false;
        this.context = context;
        this.hasBottomPadding = z;
        initView();
    }

    public LoadingMoreFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.noMoreHintStay = false;
        this.hasBottomPadding = false;
        this.context = context;
        initView();
    }
}
