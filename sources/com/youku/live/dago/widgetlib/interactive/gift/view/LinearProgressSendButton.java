package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.config.GiftTheme;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dago.widgetlib.interactive.utils.ThemeUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LinearProgressSendButton extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private Drawable mMaskProgressDrawable;
    private Drawable mMaskProgressHalfDrawable;
    private ImageView mProgressMask;
    private View mRootView;
    private Drawable mSendBtnDrawable;
    private Drawable mSendBtnHalfDrawable;
    private TextView mSendText;
    private TextView mSendTextFront;
    private boolean mShowHalf;
    private Drawable mUnSelectedDrawable;

    public LinearProgressSendButton(@NonNull Context context) {
        super(context, null);
        this.mShowHalf = true;
        this.mContext = context;
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-340818963")) {
            ipChange.ipc$dispatch("-340818963", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.C7942layout.dago_pgc_ykl_linear_send_progress_button, this);
        this.mRootView = inflate;
        this.mSendText = (TextView) inflate.findViewById(R.id.send_text);
        this.mSendTextFront = (TextView) this.mRootView.findViewById(R.id.send_text_tv);
        this.mProgressMask = (ImageView) this.mRootView.findViewById(R.id.progress_mask);
    }

    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-46995847")) {
            ipChange.ipc$dispatch("-46995847", new Object[]{this});
        } else if (this.mProgressMask.getBackground() != null) {
            ((ClipDrawable) this.mProgressMask.getBackground()).setLevel(10000);
        }
    }

    public void setButtonState(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1262817583")) {
            ipChange.ipc$dispatch("1262817583", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mShowHalf = z;
        if (z) {
            this.mProgressMask.setVisibility(0);
            this.mSendTextFront.setVisibility(0);
            this.mSendText.setBackground(this.mSendBtnHalfDrawable);
            this.mProgressMask.setBackground(this.mMaskProgressHalfDrawable);
            reset();
        } else {
            this.mProgressMask.setVisibility(8);
            this.mSendTextFront.setVisibility(8);
            this.mSendText.setBackground(this.mSendBtnDrawable);
            this.mProgressMask.setBackground(this.mMaskProgressDrawable);
        }
        this.mSendText.setTextColor(-1);
        this.mSendTextFront.setTextColor(-1);
    }

    public void setProgress(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1168393910")) {
            ipChange.ipc$dispatch("-1168393910", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mProgressMask.getBackground() != null) {
            ((ClipDrawable) this.mProgressMask.getBackground()).setLevel(i * 100);
        }
    }

    public void setSendText(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1047155413")) {
            ipChange.ipc$dispatch("1047155413", new Object[]{this, charSequence});
            return;
        }
        this.mSendText.setText(charSequence);
        this.mSendTextFront.setText(charSequence);
    }

    public void setUnSelState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1011381718")) {
            ipChange.ipc$dispatch("1011381718", new Object[]{this});
            return;
        }
        this.mSendText.setBackground(this.mUnSelectedDrawable);
        this.mSendText.setTextColor(Color.parseColor("55ffffff"));
        this.mSendTextFront.setTextColor(Color.parseColor("55ffffff"));
    }

    public void updateTheme(GiftTheme giftTheme) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1936062940")) {
            ipChange.ipc$dispatch("-1936062940", new Object[]{this, giftTheme});
            return;
        }
        int dip2px = DensityUtil.dip2px(getContext(), 1.0f);
        float f = dip2px * 15;
        this.mUnSelectedDrawable = ThemeUtils.getRadiusDrawable(Color.parseColor("#666666"), 0, 0, 0.0f, f, f, 0.0f);
        int i = giftTheme.btnGiantProgressBgColor;
        int i2 = giftTheme.btnGiantStartColor;
        int i3 = giftTheme.btnGiantEndColor;
        int i4 = giftTheme.themeColor;
        this.mSendBtnHalfDrawable = ThemeUtils.getRadiusDrawable(i, i4, dip2px, 0.0f, f, f, 0.0f);
        this.mSendBtnDrawable = ThemeUtils.getGradientDrawable(i2, i3, GradientDrawable.Orientation.LEFT_RIGHT, i4, dip2px, f);
        this.mMaskProgressHalfDrawable = ThemeUtils.getClipDrawable(ThemeUtils.getGradientDrawable(i2, i3, GradientDrawable.Orientation.LEFT_RIGHT, i4, dip2px, 0.0f, f, f, 0.0f), 3, 1);
        this.mMaskProgressDrawable = ThemeUtils.getClipDrawable(ThemeUtils.getGradientDrawable(i2, i3, GradientDrawable.Orientation.LEFT_RIGHT, i4, dip2px, f), 3, 1);
        this.mSendText.setBackground(this.mSendBtnHalfDrawable);
        this.mProgressMask.setBackground(this.mMaskProgressHalfDrawable);
        reset();
    }

    public LinearProgressSendButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mShowHalf = true;
        this.mContext = context;
        initView();
    }

    public LinearProgressSendButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShowHalf = true;
        this.mContext = context;
        initView();
    }
}
