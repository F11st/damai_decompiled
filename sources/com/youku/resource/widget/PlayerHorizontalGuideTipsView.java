package com.youku.resource.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.youku.motioncurvex.MotionCurveXOvershootInterpolator;
import com.youku.motioncurvex.MotionCurveXStandardInterpolator;
import com.youku.resource.R;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayerHorizontalGuideTipsView extends FrameLayout {
    private final int ANIM_DURATION_ALPHA;
    private final int ANIM_DURATION_SCALE;
    private final float ANIM_TRANSLATE_INIT_VALUE;
    private ViewGroup mTipsHolder;
    private TextView mTipsView;
    private HorizontalGuideTipsType mType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.resource.widget.PlayerHorizontalGuideTipsView$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$resource$widget$PlayerHorizontalGuideTipsView$HorizontalGuideTipsType;

        static {
            int[] iArr = new int[HorizontalGuideTipsType.values().length];
            $SwitchMap$com$youku$resource$widget$PlayerHorizontalGuideTipsView$HorizontalGuideTipsType = iArr;
            try {
                iArr[HorizontalGuideTipsType.RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$resource$widget$PlayerHorizontalGuideTipsView$HorizontalGuideTipsType[HorizontalGuideTipsType.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum HorizontalGuideTipsType {
        RIGHT,
        LEFT
    }

    public PlayerHorizontalGuideTipsView(Context context) {
        super(context);
        this.ANIM_DURATION_SCALE = 465;
        this.ANIM_DURATION_ALPHA = PlayerGuideTipsView.ANIM_DURATION_ALPHA;
        this.ANIM_TRANSLATE_INIT_VALUE = 0.1f;
        this.mType = HorizontalGuideTipsType.RIGHT;
        initView();
    }

    public static int dp2px(Context context, float f) {
        if (context == null) {
            return 0;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void initView() {
        this.mTipsHolder = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.C8074layout.resource_yk_horizontal_guide_tips_layout, this);
        this.mTipsView = (TextView) findViewById(R.id.tv_tips);
        setTipsType(HorizontalGuideTipsType.RIGHT);
    }

    public void hide() {
        if (getVisibility() == 8) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.yk_amin_guide_tips_alpha_hide);
        loadAnimation.setFillAfter(false);
        setVisibility(8);
        startAnimation(loadAnimation);
    }

    public void setTipsText(String str) {
        this.mTipsView.setText(str);
    }

    public void setTipsType(HorizontalGuideTipsType horizontalGuideTipsType) {
        this.mType = horizontalGuideTipsType;
        int i = AnonymousClass1.$SwitchMap$com$youku$resource$widget$PlayerHorizontalGuideTipsView$HorizontalGuideTipsType[horizontalGuideTipsType.ordinal()];
        if (i == 1) {
            this.mTipsHolder.setBackgroundResource(R.C8072drawable.yk_guide_tips_left);
        } else if (i != 2) {
        } else {
            this.mTipsHolder.setBackgroundResource(R.C8072drawable.yk_guide_tips_right);
        }
    }

    public void show() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        int i = AnonymousClass1.$SwitchMap$com$youku$resource$widget$PlayerHorizontalGuideTipsView$HorizontalGuideTipsType[this.mType.ordinal()];
        if (i == 1) {
            AnimationSet animationSet = new AnimationSet(false);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, -0.1f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(465L);
            translateAnimation.setInterpolator(new MotionCurveXOvershootInterpolator());
            animationSet.addAnimation(translateAnimation);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(230L);
            alphaAnimation.setInterpolator(new MotionCurveXStandardInterpolator());
            animationSet.addAnimation(alphaAnimation);
            startAnimation(animationSet);
        } else if (i != 2) {
        } else {
            AnimationSet animationSet2 = new AnimationSet(false);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.1f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation2.setDuration(465L);
            translateAnimation2.setInterpolator(new MotionCurveXOvershootInterpolator());
            animationSet2.addAnimation(translateAnimation2);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation2.setDuration(230L);
            alphaAnimation2.setInterpolator(new MotionCurveXStandardInterpolator());
            animationSet2.addAnimation(alphaAnimation2);
            startAnimation(animationSet2);
        }
    }

    public PlayerHorizontalGuideTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ANIM_DURATION_SCALE = 465;
        this.ANIM_DURATION_ALPHA = PlayerGuideTipsView.ANIM_DURATION_ALPHA;
        this.ANIM_TRANSLATE_INIT_VALUE = 0.1f;
        this.mType = HorizontalGuideTipsType.RIGHT;
        initView();
    }

    public PlayerHorizontalGuideTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ANIM_DURATION_SCALE = 465;
        this.ANIM_DURATION_ALPHA = PlayerGuideTipsView.ANIM_DURATION_ALPHA;
        this.ANIM_TRANSLATE_INIT_VALUE = 0.1f;
        this.mType = HorizontalGuideTipsType.RIGHT;
        initView();
    }
}
