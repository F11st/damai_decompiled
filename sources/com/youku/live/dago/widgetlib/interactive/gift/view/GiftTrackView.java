package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftTrackBean;
import com.youku.live.dago.widgetlib.interactive.gift.view.frameanimation.AnimationsContainer;
import com.youku.live.dago.widgetlib.interactive.gift.view.frameanimation.FramesSequenceAnimation;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftTrackView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private int currentBgResId;
    private boolean isAnimationRunning;
    private ImageView mBackAnimImage;
    private ImageView mFrontAnimImage;
    private GiftTrackBean mGiftTrackBean;
    private ImageView mImageViewGiftIcon;
    private int mNumber;
    private TextPaint mTextPaint;
    private TextView mTextViewGiftNumber;
    private static final String TAG = GiftTrackView.class.getSimpleName();
    public static int TYPE_USER_TO_ACTOR = 0;
    public static int TYPE_ACTOR_TO_USER = 1;
    public static int TYPE_USER_TO_USER = 2;

    public GiftTrackView(Context context, boolean z, GiftTrackBean giftTrackBean) {
        super(context);
        this.mNumber = 0;
        this.isAnimationRunning = false;
        this.currentBgResId = R.drawable.dago_pgc_gift_track_a_bg;
        this.mGiftTrackBean = giftTrackBean;
        initView(context, z);
    }

    private void initPaint(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "319369448")) {
            ipChange.ipc$dispatch("319369448", new Object[]{this, context});
            return;
        }
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setTextSize(DensityUtil.dip2px(context, 11.0f));
        this.mTextPaint.setTypeface(Typeface.defaultFromStyle(1));
    }

    private void initView(Context context, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1809107539")) {
            ipChange.ipc$dispatch("1809107539", new Object[]{this, context, Boolean.valueOf(z)});
            return;
        }
        setClipChildren(false);
        LayoutInflater.from(context).inflate(R.layout.dago_pgc_ykl_gift_track_item, (ViewGroup) this, true);
        initPaint(context);
        ImageView imageView = (ImageView) findViewById(R.id.iv_user_avatar);
        TextView textView = (TextView) findViewById(R.id.tv_gift_name);
        this.mBackAnimImage = (ImageView) findViewById(R.id.back_anim);
        this.mFrontAnimImage = (ImageView) findViewById(R.id.front_anim);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.combo_root_view);
        GiftTrackBean giftTrackBean = this.mGiftTrackBean;
        String str = giftTrackBean.userName;
        String str2 = giftTrackBean.anchorName;
        String str3 = giftTrackBean.giftName;
        ((TextView) findViewById(R.id.tv_user_name)).setText(str);
        if (TextUtils.isEmpty(this.mGiftTrackBean.anchorId)) {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            textView.setText(String.format(context.getString(R.string.dago_pgc_gift_box_send_to), str3));
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(str2);
            yellowColorSpan(context, spannableString);
            SpannableString spannableString2 = new SpannableString("送给");
            whiteColorSpan(context, spannableString2);
            spannableStringBuilder.append((CharSequence) spannableString2);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) str3);
            textView.setText(spannableStringBuilder);
        }
        this.mTextViewGiftNumber = (TextView) findViewById(R.id.tv_gift_number);
        TextPaint textPaint = this.mTextPaint;
        this.mTextViewGiftNumber.setWidth((int) (textPaint.measureText(" x" + this.mGiftTrackBean.giftNum) + 10.0f));
        this.mImageViewGiftIcon = (ImageView) findViewById(R.id.iv_gift_icon);
        DagoImageLoader.getInstance().showCircle(getContext(), this.mGiftTrackBean.userIcon, imageView, R.drawable.dago_pgc_ykl_gift_track_bg);
        DagoImageLoader.getInstance().showDefault(getContext(), this.mGiftTrackBean.giftIcon, this.mImageViewGiftIcon);
        this.mImageViewGiftIcon.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dago_pgc_track_gift_icon_anim));
    }

    private void whiteColorSpan(Context context, SpannableString spannableString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469340658")) {
            ipChange.ipc$dispatch("1469340658", new Object[]{this, context, spannableString});
        }
    }

    private void yellowColorSpan(Context context, SpannableString spannableString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2084104395")) {
            ipChange.ipc$dispatch("-2084104395", new Object[]{this, context, spannableString});
        } else {
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ffd862")), 0, spannableString.length(), 17);
        }
    }

    public ImageView getBackAnimImage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2053247871") ? (ImageView) ipChange.ipc$dispatch("-2053247871", new Object[]{this}) : this.mBackAnimImage;
    }

    public ImageView getFrontAnimImage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1389879193") ? (ImageView) ipChange.ipc$dispatch("1389879193", new Object[]{this}) : this.mFrontAnimImage;
    }

    public TextView getGiftNumberTextView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1783001087") ? (TextView) ipChange.ipc$dispatch("-1783001087", new Object[]{this}) : this.mTextViewGiftNumber;
    }

    public ImageView getImageViewGiftIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "61758951") ? (ImageView) ipChange.ipc$dispatch("61758951", new Object[]{this}) : this.mImageViewGiftIcon;
    }

    public int getNumber() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "738279458") ? ((Integer) ipChange.ipc$dispatch("738279458", new Object[]{this})).intValue() : this.mNumber;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1969004817")) {
            ipChange.ipc$dispatch("1969004817", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        clearAnimation();
        TextView textView = this.mTextViewGiftNumber;
        if (textView != null) {
            textView.clearAnimation();
        }
        ImageView imageView = this.mImageViewGiftIcon;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    public void setGiftNumber(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "319816592")) {
            ipChange.ipc$dispatch("319816592", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mNumber = i;
        TextView textView = this.mTextViewGiftNumber;
        if (textView != null) {
            textView.setText(" x" + i);
        }
    }

    public void startTrackBgAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362995139")) {
            ipChange.ipc$dispatch("-362995139", new Object[]{this});
        } else if (isShown() && !this.isAnimationRunning) {
            this.isAnimationRunning = true;
            final FramesSequenceAnimation createProgressDialogAnim = AnimationsContainer.getInstance(getContext()).createProgressDialogAnim(this.mFrontAnimImage);
            final TranslateAnimation translateAnimation = new TranslateAnimation(2, -0.97f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
            translateAnimation.setDuration(1000L);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, -1.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
            translateAnimation2.setDuration(1500L);
            translateAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GiftTrackView.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1636789485")) {
                        ipChange2.ipc$dispatch("-1636789485", new Object[]{this, animation});
                    } else {
                        GiftTrackView.this.mBackAnimImage.setVisibility(8);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1344442495")) {
                        ipChange2.ipc$dispatch("-1344442495", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1793502636")) {
                        ipChange2.ipc$dispatch("1793502636", new Object[]{this, animation});
                        return;
                    }
                    GiftTrackView.this.mBackAnimImage.setVisibility(0);
                    GiftTrackView.this.mFrontAnimImage.startAnimation(translateAnimation);
                }
            });
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GiftTrackView.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-943396780")) {
                        ipChange2.ipc$dispatch("-943396780", new Object[]{this, animation});
                        return;
                    }
                    FramesSequenceAnimation framesSequenceAnimation = createProgressDialogAnim;
                    if (framesSequenceAnimation != null) {
                        framesSequenceAnimation.start();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1019905696")) {
                        ipChange2.ipc$dispatch("1019905696", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1871006035")) {
                        ipChange2.ipc$dispatch("-1871006035", new Object[]{this, animation});
                    } else {
                        GiftTrackView.this.mFrontAnimImage.setVisibility(0);
                    }
                }
            });
            createProgressDialogAnim.setOnAnimStopListener(new FramesSequenceAnimation.OnAnimationListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GiftTrackView.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.interactive.gift.view.frameanimation.FramesSequenceAnimation.OnAnimationListener
                public void onAnimationEnd() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-448877547")) {
                        ipChange2.ipc$dispatch("-448877547", new Object[]{this});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.view.frameanimation.FramesSequenceAnimation.OnAnimationListener
                public void onAnimationStart() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2064614510")) {
                        ipChange2.ipc$dispatch("2064614510", new Object[]{this});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.view.frameanimation.FramesSequenceAnimation.OnAnimationListener
                public void onAnimationStop() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1306076104")) {
                        ipChange2.ipc$dispatch("-1306076104", new Object[]{this});
                        return;
                    }
                    GiftTrackView.this.mFrontAnimImage.setVisibility(8);
                    GiftTrackView.this.mBackAnimImage.setVisibility(8);
                    GiftTrackView.this.isAnimationRunning = false;
                }
            });
            this.mBackAnimImage.startAnimation(translateAnimation2);
        }
    }

    public void updateBg(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1951797621")) {
            ipChange.ipc$dispatch("1951797621", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (10 <= i && i < 50) {
            int i2 = this.currentBgResId;
            int i3 = R.drawable.dago_pgc_gift_track_a_bg;
            if (i2 != i3) {
                this.currentBgResId = i3;
                this.mBackAnimImage.setImageResource(i3);
            }
        } else if (50 <= i && i < 100) {
            int i4 = this.currentBgResId;
            int i5 = R.drawable.dago_pgc_gift_track_b_bg;
            if (i4 != i5) {
                this.currentBgResId = i5;
                this.mBackAnimImage.setImageResource(i5);
            }
        } else if (i >= 100) {
            int i6 = this.currentBgResId;
            int i7 = R.drawable.dago_pgc_gift_track_c_bg;
            if (i6 != i7) {
                this.currentBgResId = i7;
                this.mBackAnimImage.setImageResource(i7);
            }
        }
        if (i >= 10) {
            startTrackBgAnim();
        }
    }
}
