package com.youku.resource.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.youku.resource.R;
import com.youku.resource.utils.Utils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKErrorView extends RelativeLayout {
    public static final int TYPE_NET_ERROE = 1;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_NOT_LOGIN_ERROE = 3;
    public static final int TYPE_NO_COPY_RIGHT_ERROE = 5;
    public static final int TYPE_NO_RESULT_ERROE = 2;
    public static final int TYPE_UPLOAD_ERROE = 4;
    protected boolean animate;
    private boolean attachedToWindow;
    protected int errorType;
    protected LottieAnimationView error_bird;
    protected ImageView error_image;
    protected LottieAnimationView error_lottie;
    protected TextView error_text;
    private boolean mOutWindowVisibilityChangedReally;

    public YKErrorView(Context context) {
        super(context);
        this.errorType = 0;
        this.animate = false;
        this.attachedToWindow = false;
    }

    private void clearAnimate() {
        LottieAnimationView lottieAnimationView = this.error_lottie;
        if (lottieAnimationView != null) {
            if (lottieAnimationView.isAnimating()) {
                this.error_lottie.cancelAnimation();
                this.error_lottie.removeAllAnimatorListeners();
            }
            this.error_lottie.setImageResource(0);
        }
        LottieAnimationView lottieAnimationView2 = this.error_bird;
        if (lottieAnimationView2 != null) {
            if (lottieAnimationView2.isAnimating()) {
                this.error_bird.cancelAnimation();
                this.error_bird.removeAllAnimatorListeners();
            }
            this.error_bird.setImageResource(0);
        }
    }

    private String getJsonPath(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return Utils.getEmptyMonkeyJsonPath();
                        }
                        return Utils.getCopyrightMonkeyJsonPath();
                    }
                    return Utils.getUploadMonkeyJsonPath();
                }
                return Utils.getLoginMonkeyJsonPath();
            }
            return Utils.getEmptyMonkeyJsonPath();
        }
        return Utils.getWifiMonkeyJsonPath();
    }

    private int getResource(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return R.C8072drawable.lottie_error_empty;
                        }
                        return R.C8072drawable.lottie_error_nocopyright;
                    }
                    return R.C8072drawable.lottie_error_upload;
                }
                return R.C8072drawable.lottie_error_notlogin;
            }
            return R.C8072drawable.lottie_error_empty;
        }
        return R.C8072drawable.lottie_error_net;
    }

    private boolean isVisivle() {
        return getVisibility() == 0;
    }

    private void startAnimate() {
        if (this.attachedToWindow && this.errorType != 0 && isVisivle()) {
            LottieAnimationView lottieAnimationView = this.error_lottie;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(0);
                this.error_lottie.setAnimation(getJsonPath(this.errorType));
                if (this.animate && !this.error_lottie.isAnimating()) {
                    this.error_lottie.playAnimation();
                }
            }
            LottieAnimationView lottieAnimationView2 = this.error_bird;
            if (lottieAnimationView2 != null) {
                if (this.errorType == 5) {
                    lottieAnimationView2.setVisibility(0);
                    this.error_bird.setAnimation(Utils.getBirdJsonPath());
                    if (!this.animate || this.error_bird.isAnimating()) {
                        return;
                    }
                    this.error_bird.playAnimation();
                    return;
                }
                lottieAnimationView2.setVisibility(8);
                if (this.error_bird.isAnimating()) {
                    this.error_bird.cancelAnimation();
                }
                this.error_bird.setImageResource(0);
                return;
            }
            return;
        }
        clearAnimate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowVisibilityChanged(int i) {
        this.mOutWindowVisibilityChangedReally = true;
        super.dispatchWindowVisibilityChanged(i);
        this.mOutWindowVisibilityChangedReally = false;
    }

    public int getErrorType() {
        return this.errorType;
    }

    public void hideView() {
        this.errorType = 0;
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.attachedToWindow = true;
        startAnimate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attachedToWindow = false;
        clearAnimate();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            startAnimate();
        } else {
            clearAnimate();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.mOutWindowVisibilityChangedReally) {
            if (i == 0) {
                startAnimate();
            } else if (i == 4 || i == 8) {
                clearAnimate();
            }
        }
    }

    public void setErrorText(String str, int i) {
        this.errorType = i;
        if (!TextUtils.isEmpty(str)) {
            this.error_text.setVisibility(0);
            this.error_text.setText(str);
        } else {
            this.error_text.setVisibility(8);
        }
        this.error_image.setImageResource(getResource(i));
        startAnimate();
    }

    public YKErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.errorType = 0;
        this.animate = false;
        this.attachedToWindow = false;
    }
}
