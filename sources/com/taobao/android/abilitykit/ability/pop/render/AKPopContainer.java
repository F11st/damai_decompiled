package com.taobao.android.abilitykit.ability.pop.render;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.abilitykit.ability.pop.animation.IAKPopAnimationCallback;
import com.taobao.android.abilitykit.ability.pop.render.IAKPopContainer;
import com.taobao.android.abilitykit.ability.pop.render.util.GestureRoundCornerFrameLayout;
import com.taobao.android.abilitykit.ability.pop.render.util.VerticalGestureHandler;
import tb.q;
import tb.u;
import tb.v;
import tb.w;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AKPopContainer<PARAMS extends w, CONTEXT extends q> extends FrameLayout implements IAKPopContainer<PARAMS, CONTEXT> {
    protected final int DEFAULT_BACKGROUND_COLOR;
    boolean hasAnimatedIn;
    @Nullable
    protected ValueAnimator mBackgroundAnimator;
    @Nullable
    protected View mContentView;
    @Nullable
    protected GestureRoundCornerFrameLayout mContentWrapper;
    @Nullable
    private VerticalGestureHandler mGestureUtil;
    protected float mHeightRate;
    @Nullable
    protected View mLoadingView;
    protected w mParams;
    @Nullable
    protected v mPopConfig;
    @Nullable
    protected IAKPopRender mPopRender;
    protected IAKPopContainer.Callback mStateCallback;
    protected int mWindowHeight;
    protected int mWindowWidth;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        a(AKPopContainer aKPopContainer) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    class b implements VerticalGestureHandler.Callback {
        b() {
        }

        @Override // com.taobao.android.abilitykit.ability.pop.render.util.VerticalGestureHandler.Callback
        public boolean canContentViewScrollVertical(int i) {
            IAKPopRender iAKPopRender;
            AKPopContainer aKPopContainer = AKPopContainer.this;
            View view = aKPopContainer.mContentView;
            return (view == null || (iAKPopRender = aKPopContainer.mPopRender) == null || !iAKPopRender.canContentViewScrollVertically(view, i)) ? false : true;
        }

        @Override // com.taobao.android.abilitykit.ability.pop.render.util.VerticalGestureHandler.Callback
        public boolean isAnimating() {
            v vVar = AKPopContainer.this.mPopConfig;
            throw null;
        }

        @Override // com.taobao.android.abilitykit.ability.pop.render.util.VerticalGestureHandler.Callback
        public boolean isPanEnabled() {
            v vVar = AKPopContainer.this.mPopConfig;
            throw null;
        }

        @Override // com.taobao.android.abilitykit.ability.pop.render.util.VerticalGestureHandler.Callback
        public void onCloseBlocked(@NonNull View view) {
            AKPopContainer.this.notifyCloseType("panToDismiss");
        }

        @Override // com.taobao.android.abilitykit.ability.pop.render.util.VerticalGestureHandler.Callback
        public void onStateChanged(@NonNull View view, int i) {
            if (i == 3) {
                AKPopContainer.this.onDismissAnimEnd();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    class c implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        c(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Integer) {
                AKPopContainer.this.setBackgroundColor(Color.argb(((Integer) animatedValue).intValue(), this.a, this.b, this.c));
            }
        }
    }

    public AKPopContainer(@NonNull Context context) {
        super(context);
        this.DEFAULT_BACKGROUND_COLOR = 1291845632;
        this.hasAnimatedIn = false;
    }

    private void animationBackgroundColor(int i, boolean z) {
        ValueAnimator valueAnimator = this.mBackgroundAnimator;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            this.mBackgroundAnimator.cancel();
        }
        this.mBackgroundAnimator = null;
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        if (z) {
            this.mBackgroundAnimator = ValueAnimator.ofInt(0, Color.alpha(i));
        } else {
            this.mBackgroundAnimator = ValueAnimator.ofInt(Color.alpha(i), 0);
        }
        this.mBackgroundAnimator.setDuration(300L);
        this.mBackgroundAnimator.addUpdateListener(new c(red, green, blue));
        this.mBackgroundAnimator.start();
    }

    private void doAnimation(boolean z, @NonNull View view, @NonNull v vVar, @Nullable IAKPopAnimationCallback iAKPopAnimationCallback) {
        throw null;
    }

    private int getBackgroundColor(String str, String str2) {
        if ("color".equals(str) && !TextUtils.isEmpty(str2)) {
            try {
                return Color.parseColor(str2);
            } catch (IllegalArgumentException unused) {
            }
        }
        return 1291845632;
    }

    private void initGestureUtil() {
        if (this.mGestureUtil != null) {
            return;
        }
        new b();
        new u();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCloseType(String str) {
        if (this.mPopRender != null) {
            JSONObject jSONObject = new JSONObject(2);
            jSONObject.put("type", (Object) str);
            this.mPopRender.onBlockClose(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDismissAnimEnd() {
        IAKPopContainer.Callback callback = this.mStateCallback;
        if (callback != null) {
            callback.onDismissAnimationEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupContentView(View view) {
        this.mContentView = view;
        this.mContentWrapper.removeAllViews();
        this.mContentWrapper.addView(this.mContentView);
        this.mContentView.setOnClickListener(new a(this));
        adjustWrapperHeight();
    }

    protected void adjustWrapperHeight() {
    }

    @Override // com.taobao.android.abilitykit.ability.pop.render.IAKPopContainer
    public void changeSize(float f, float f2) {
        if (f2 == -2.0f) {
            throw null;
        }
        if (f2 <= 0.0f || f2 > 1.0f) {
            return;
        }
        this.mHeightRate = f2;
        throw null;
    }

    @Override // com.taobao.android.abilitykit.ability.pop.render.IAKPopContainer
    public void doDismissAnimation() {
        View view = this.mContentView;
        onDismissAnimEnd();
    }

    @Override // com.taobao.android.abilitykit.ability.pop.render.IAKPopContainer
    public ViewGroup onCreateView(@NonNull CONTEXT context, @NonNull PARAMS params, @Nullable View view, @NonNull IAKPopContainer.Callback callback, @NonNull IAKPopRender<PARAMS, CONTEXT> iAKPopRender) {
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.mBackgroundAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mBackgroundAnimator = null;
        }
        this.mPopRender.onViewDetached(this.mContentView);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.mWindowWidth == measuredWidth && this.mWindowHeight == measuredHeight) {
            return;
        }
        this.mWindowHeight = measuredHeight;
        this.mWindowWidth = measuredWidth;
        adjustWrapperHeight();
    }

    @Override // com.taobao.android.abilitykit.ability.pop.render.IAKPopContainer
    public void show() {
    }
}
