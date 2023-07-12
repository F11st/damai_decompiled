package com.alibaba.pictures.bricks.view;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RawRes;
import com.airbnb.lottie.LottieListener;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.moimage.MoImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class BaseIconButton extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private SafeLottieAnimationView btnIcon;
    @NotNull
    private LinearLayout btnIconContainer;
    @NotNull
    private TextView btnTxt;
    @NotNull
    private MoImageView iconImg;
    @Nullable
    private String iconUrl;
    private boolean isLottie;
    @Nullable
    private String lottieRes;
    @Nullable
    private String lottieUrl;
    @NotNull
    private BricksIconFontTextView txtIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseIconButton(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        LayoutInflater.from(getContext()).inflate(R$layout.bricks_common_base_icon_button, (ViewGroup) this, true);
        View findViewById = findViewById(R$id.btn_icon_container);
        b41.h(findViewById, "findViewById(R.id.btn_icon_container)");
        this.btnIconContainer = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R$id.lottie_icon);
        b41.h(findViewById2, "findViewById(R.id.lottie_icon)");
        this.btnIcon = (SafeLottieAnimationView) findViewById2;
        View findViewById3 = findViewById(R$id.txt_icon);
        b41.h(findViewById3, "findViewById(R.id.txt_icon)");
        this.txtIcon = (BricksIconFontTextView) findViewById3;
        View findViewById4 = findViewById(R$id.img_icon);
        b41.h(findViewById4, "findViewById(R.id.img_icon)");
        this.iconImg = (MoImageView) findViewById4;
        View findViewById5 = findViewById(R$id.btn_txt);
        b41.h(findViewById5, "findViewById(R.id.btn_txt)");
        this.btnTxt = (TextView) findViewById5;
    }

    private final int dp2px(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "916473270") ? ((Integer) ipChange.ipc$dispatch("916473270", new Object[]{this, Float.valueOf(f)})).intValue() : (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public final void addLottieListener(@Nullable Animator.AnimatorListener animatorListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-752711171")) {
            ipChange.ipc$dispatch("-752711171", new Object[]{this, animatorListener});
        } else {
            this.btnIcon.addAnimatorListener(animatorListener);
        }
    }

    public final void cancelIconAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1495079110")) {
            ipChange.ipc$dispatch("-1495079110", new Object[]{this});
        } else if (this.isLottie) {
            this.btnIconContainer.setVisibility(0);
            this.btnIcon.setVisibility(0);
            this.txtIcon.setVisibility(8);
            this.iconImg.setVisibility(8);
            this.btnIcon.cancelAnimation();
            this.btnIcon.setProgress(0.0f);
        }
    }

    public final void hideIcon() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-458171804")) {
            ipChange.ipc$dispatch("-458171804", new Object[]{this});
            return;
        }
        this.txtIcon.setVisibility(8);
        this.iconImg.setVisibility(8);
        this.btnIcon.setVisibility(8);
        this.btnIconContainer.setVisibility(8);
        this.btnIcon.setVisibility(8);
        this.btnTxt.setGravity(17);
    }

    public final void playLottieAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-592489190")) {
            ipChange.ipc$dispatch("-592489190", new Object[]{this});
        } else if (this.isLottie) {
            this.btnIconContainer.setVisibility(0);
            this.btnIcon.setVisibility(0);
            this.txtIcon.setVisibility(8);
            this.iconImg.setVisibility(8);
            this.btnIcon.setProgress(0.0f);
            this.btnIcon.playAnimation();
        }
    }

    public final void setButtonColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1112557395")) {
            ipChange.ipc$dispatch("1112557395", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.btnTxt.setTextColor(i);
        }
    }

    public final void setButtonImgIconSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "345306733")) {
            ipChange.ipc$dispatch("345306733", new Object[]{this, Integer.valueOf(i)});
        } else if (i <= 0) {
        } else {
            float f = i;
            this.iconImg.setMaxWidth(dp2px(f));
            this.iconImg.setMaxHeight(dp2px(f));
        }
    }

    public final void setButtonLottieIconSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "132813189")) {
            ipChange.ipc$dispatch("132813189", new Object[]{this, Integer.valueOf(i)});
        } else if (i <= 0) {
        } else {
            LinearLayout linearLayout = this.btnIconContainer;
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            float f = i;
            layoutParams.height = dp2px(f);
            layoutParams.width = dp2px(f);
            linearLayout.setLayoutParams(layoutParams);
        }
    }

    public final void setButtonText(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1821126092")) {
            ipChange.ipc$dispatch("-1821126092", new Object[]{this, str});
        } else {
            this.btnTxt.setText(str);
        }
    }

    public final void setButtonTextIconSize(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1915050913")) {
            ipChange.ipc$dispatch("1915050913", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
        } else if (i <= 0) {
        } else {
            this.txtIcon.setTextSize(1, i);
            this.txtIcon.getPaint().setFakeBoldText(z);
        }
    }

    public final void setButtonTextSize(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1052618086")) {
            ipChange.ipc$dispatch("-1052618086", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
        } else if (i <= 0) {
        } else {
            this.btnTxt.setTextSize(1, i);
            this.btnTxt.getPaint().setFakeBoldText(z);
        }
    }

    public final void setIconLottieProgress(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1238341796")) {
            ipChange.ipc$dispatch("-1238341796", new Object[]{this, Float.valueOf(f)});
        } else if (this.isLottie) {
            this.btnIcon.setProgress(f);
        }
    }

    public final void setIconRes(@NotNull String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "239556144")) {
            ipChange.ipc$dispatch("239556144", new Object[]{this, str, Boolean.valueOf(z)});
            return;
        }
        b41.i(str, "res");
        this.isLottie = z;
        if (z) {
            this.lottieRes = str;
            this.btnIcon.setAnimation(str);
            return;
        }
        this.txtIcon.setText(str);
    }

    public final void setIconUrlRes(@NotNull String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-280985621")) {
            ipChange.ipc$dispatch("-280985621", new Object[]{this, str, Boolean.valueOf(z)});
            return;
        }
        b41.i(str, "res");
        this.isLottie = z;
        if (z) {
            this.lottieUrl = str;
            this.btnIcon.setAnimationFromUrl(str);
            return;
        }
        this.iconUrl = str;
        this.iconImg.setUrl(str);
    }

    public final void setImgIconPadding(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "172953199")) {
            ipChange.ipc$dispatch("172953199", new Object[]{this, Integer.valueOf(i)});
        } else if (i <= 0) {
        } else {
            ViewGroup.LayoutParams layoutParams = this.iconImg.getLayoutParams();
            b41.h(layoutParams, "iconImg.layoutParams");
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).setMargins(dp2px(i), 0, 0, 0);
            }
        }
    }

    public final void setLottieIconFailListener(@Nullable LottieListener<Throwable> lottieListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869924320")) {
            ipChange.ipc$dispatch("-869924320", new Object[]{this, lottieListener});
        } else if (this.isLottie) {
            this.btnIcon.setFailureListener(lottieListener);
        }
    }

    public final void setLottieLocalRes(@RawRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "490134350")) {
            ipChange.ipc$dispatch("490134350", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.isLottie = true;
        this.btnIcon.setAnimation(i);
    }

    public final void setTextIconColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1335584959")) {
            ipChange.ipc$dispatch("1335584959", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 0) {
        } else {
            this.txtIcon.setTextColor(i);
        }
    }

    public final void setTextIconPadding(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1909589267")) {
            ipChange.ipc$dispatch("-1909589267", new Object[]{this, Integer.valueOf(i)});
        } else if (i <= 0) {
        } else {
            ViewGroup.LayoutParams layoutParams = this.txtIcon.getLayoutParams();
            b41.h(layoutParams, "txtIcon.layoutParams");
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).setMargins(dp2px(i), 0, 0, 0);
            }
        }
    }

    public final void showIcon() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "50398281")) {
            ipChange.ipc$dispatch("50398281", new Object[]{this});
        } else if (this.isLottie) {
            this.txtIcon.setVisibility(8);
            this.iconImg.setVisibility(8);
            this.btnIconContainer.setVisibility(0);
            this.btnIcon.setVisibility(0);
        } else {
            this.txtIcon.setVisibility(0);
            this.iconImg.setVisibility(8);
            this.btnTxt.setGravity(3);
            this.btnIconContainer.setVisibility(8);
            this.btnIcon.setVisibility(8);
        }
    }

    public final void showIconUrlAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1681027276")) {
            ipChange.ipc$dispatch("-1681027276", new Object[]{this});
        } else if (this.isLottie) {
            this.btnIconContainer.setVisibility(0);
            this.btnIcon.setVisibility(0);
            this.txtIcon.setVisibility(8);
            this.iconImg.setVisibility(8);
            this.btnIcon.setAnimationFromUrl(this.lottieUrl);
            this.btnIcon.setProgress(0.0f);
            this.btnIcon.playAnimation();
        }
    }

    public final void showImgIcon() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-498997236")) {
            ipChange.ipc$dispatch("-498997236", new Object[]{this});
        } else if (this.isLottie) {
            this.txtIcon.setVisibility(8);
            this.iconImg.setVisibility(8);
            this.btnIconContainer.setVisibility(0);
            this.btnIcon.setVisibility(0);
        } else {
            this.txtIcon.setVisibility(8);
            this.iconImg.setVisibility(0);
            this.btnTxt.setGravity(3);
            this.btnIconContainer.setVisibility(8);
            this.btnIcon.setVisibility(8);
        }
    }

    public final void visibleLottieIconAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-496546683")) {
            ipChange.ipc$dispatch("-496546683", new Object[]{this});
        } else if (this.isLottie) {
            this.btnIconContainer.setVisibility(0);
            this.btnIcon.setVisibility(0);
            this.txtIcon.setVisibility(8);
            this.iconImg.setVisibility(8);
            this.btnIcon.setProgress(1.0f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseIconButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        LayoutInflater.from(getContext()).inflate(R$layout.bricks_common_base_icon_button, (ViewGroup) this, true);
        View findViewById = findViewById(R$id.btn_icon_container);
        b41.h(findViewById, "findViewById(R.id.btn_icon_container)");
        this.btnIconContainer = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R$id.lottie_icon);
        b41.h(findViewById2, "findViewById(R.id.lottie_icon)");
        this.btnIcon = (SafeLottieAnimationView) findViewById2;
        View findViewById3 = findViewById(R$id.txt_icon);
        b41.h(findViewById3, "findViewById(R.id.txt_icon)");
        this.txtIcon = (BricksIconFontTextView) findViewById3;
        View findViewById4 = findViewById(R$id.img_icon);
        b41.h(findViewById4, "findViewById(R.id.img_icon)");
        this.iconImg = (MoImageView) findViewById4;
        View findViewById5 = findViewById(R$id.btn_txt);
        b41.h(findViewById5, "findViewById(R.id.btn_txt)");
        this.btnTxt = (TextView) findViewById5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseIconButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        LayoutInflater.from(getContext()).inflate(R$layout.bricks_common_base_icon_button, (ViewGroup) this, true);
        View findViewById = findViewById(R$id.btn_icon_container);
        b41.h(findViewById, "findViewById(R.id.btn_icon_container)");
        this.btnIconContainer = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R$id.lottie_icon);
        b41.h(findViewById2, "findViewById(R.id.lottie_icon)");
        this.btnIcon = (SafeLottieAnimationView) findViewById2;
        View findViewById3 = findViewById(R$id.txt_icon);
        b41.h(findViewById3, "findViewById(R.id.txt_icon)");
        this.txtIcon = (BricksIconFontTextView) findViewById3;
        View findViewById4 = findViewById(R$id.img_icon);
        b41.h(findViewById4, "findViewById(R.id.img_icon)");
        this.iconImg = (MoImageView) findViewById4;
        View findViewById5 = findViewById(R$id.btn_txt);
        b41.h(findViewById5, "findViewById(R.id.btn_txt)");
        this.btnTxt = (TextView) findViewById5;
    }
}
