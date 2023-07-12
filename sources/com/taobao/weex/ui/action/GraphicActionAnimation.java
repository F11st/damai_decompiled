package com.taobao.weex.ui.action;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.alibaba.fastjson.JSON;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.animation.BackgroundColorProperty;
import com.taobao.weex.ui.animation.HeightProperty;
import com.taobao.weex.ui.animation.WXAnimationBean;
import com.taobao.weex.ui.animation.WXAnimationModule;
import com.taobao.weex.ui.animation.WidthProperty;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.taobao.weex.ui.view.border.BorderDrawable;
import com.taobao.weex.utils.SingleFunctionParser;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXResourceUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GraphicActionAnimation extends BasicGraphicAction {
    private static final String TAG = "GraphicActionAnimation";
    @Nullable
    private final String callback;
    @Nullable
    private WXAnimationBean mAnimationBean;
    private final boolean styleNeedInit;

    public GraphicActionAnimation(@NonNull WXSDKInstance wXSDKInstance, @NonNull String str, @NonNull WXAnimationBean wXAnimationBean) {
        super(wXSDKInstance, str);
        this.styleNeedInit = false;
        this.callback = null;
        this.mAnimationBean = wXAnimationBean;
    }

    @Nullable
    private ObjectAnimator createAnimator(View view, int i) {
        WXAnimationBean.Style style;
        if (view == null || (style = this.mAnimationBean.styles) == null) {
            return null;
        }
        List<PropertyValuesHolder> holders = style.getHolders();
        if (!TextUtils.isEmpty(style.backgroundColor)) {
            BorderDrawable borderDrawable = WXViewUtils.getBorderDrawable(view);
            if (borderDrawable != null) {
                holders.add(PropertyValuesHolder.ofObject(new BackgroundColorProperty(), new ArgbEvaluator(), Integer.valueOf(borderDrawable.getColor()), Integer.valueOf(WXResourceUtils.getColor(style.backgroundColor))));
            } else if (view.getBackground() instanceof ColorDrawable) {
                holders.add(PropertyValuesHolder.ofObject(new BackgroundColorProperty(), new ArgbEvaluator(), Integer.valueOf(((ColorDrawable) view.getBackground()).getColor()), Integer.valueOf(WXResourceUtils.getColor(style.backgroundColor))));
            }
        }
        if (view.getLayoutParams() != null && (!TextUtils.isEmpty(style.width) || !TextUtils.isEmpty(style.height))) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (!TextUtils.isEmpty(style.width)) {
                holders.add(PropertyValuesHolder.ofInt(new WidthProperty(), layoutParams.width, (int) WXViewUtils.getRealPxByWidth(WXUtils.getFloat(style.width), i)));
            }
            if (!TextUtils.isEmpty(style.height)) {
                holders.add(PropertyValuesHolder.ofInt(new HeightProperty(), layoutParams.height, (int) WXViewUtils.getRealPxByWidth(WXUtils.getFloat(style.height), i)));
            }
        }
        if (style.getPivot() != null) {
            Pair<Float, Float> pivot = style.getPivot();
            view.setPivotX(((Float) pivot.first).floatValue());
            view.setPivotY(((Float) pivot.second).floatValue());
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, (PropertyValuesHolder[]) holders.toArray(new PropertyValuesHolder[holders.size()]));
        ofPropertyValuesHolder.setStartDelay(this.mAnimationBean.delay);
        return ofPropertyValuesHolder;
    }

    @Nullable
    private Animator.AnimatorListener createAnimatorListener(final WXSDKInstance wXSDKInstance, @Nullable final String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new AnimatorListenerAdapter() { // from class: com.taobao.weex.ui.action.GraphicActionAnimation.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                WXSDKInstance wXSDKInstance2 = wXSDKInstance;
                if (wXSDKInstance2 != null && !wXSDKInstance2.isDestroy()) {
                    WXSDKManager.v().a(wXSDKInstance.getInstanceId(), str, new HashMap());
                } else {
                    WXLogUtils.e("RenderContextImpl-onAnimationEnd WXSDKInstance == null NPE or instance is destroyed");
                }
            }
        };
    }

    @Nullable
    private Interpolator createTimeInterpolator() {
        String str = this.mAnimationBean.timingFunction;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1965120668:
                if (str.equals("ease-in")) {
                    c = 0;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c = 1;
                    break;
                }
                break;
            case -789192465:
                if (str.equals("ease-out")) {
                    c = 2;
                    break;
                }
                break;
            case -361990811:
                if (str.equals("ease-in-out")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new AccelerateInterpolator();
            case 1:
                return new LinearInterpolator();
            case 2:
                return new DecelerateInterpolator();
            case 3:
                return new AccelerateDecelerateInterpolator();
            default:
                try {
                    List parse = new SingleFunctionParser(this.mAnimationBean.timingFunction, new SingleFunctionParser.FlatMapper<Float>() { // from class: com.taobao.weex.ui.action.GraphicActionAnimation.2
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.taobao.weex.utils.SingleFunctionParser.FlatMapper
                        public Float map(String str2) {
                            return Float.valueOf(Float.parseFloat(str2));
                        }
                    }).parse("cubic-bezier");
                    if (parse != null && parse.size() == 4) {
                        return PathInterpolatorCompat.create(((Float) parse.get(0)).floatValue(), ((Float) parse.get(1)).floatValue(), ((Float) parse.get(2)).floatValue(), ((Float) parse.get(3)).floatValue());
                    }
                } catch (RuntimeException unused) {
                }
                return null;
        }
    }

    private void startAnimation(@NonNull WXSDKInstance wXSDKInstance, @Nullable WXComponent wXComponent) {
        if (wXComponent != null) {
            WXAnimationBean wXAnimationBean = this.mAnimationBean;
            if (wXAnimationBean != null) {
                wXComponent.setNeedLayoutOnAnimation(wXAnimationBean.needLayout);
            }
            if (wXComponent.getHostView() == null) {
                wXComponent.postAnimation(new WXAnimationModule.AnimationHolder(this.mAnimationBean, this.callback));
                return;
            }
            try {
                ObjectAnimator createAnimator = createAnimator(wXComponent.getHostView(), wXSDKInstance.getInstanceViewPortWidth());
                if (createAnimator != null) {
                    Animator.AnimatorListener createAnimatorListener = createAnimatorListener(wXSDKInstance, this.callback);
                    if (Build.VERSION.SDK_INT < 18 && wXComponent.isLayerTypeEnabled()) {
                        wXComponent.getHostView().setLayerType(2, null);
                    }
                    Interpolator createTimeInterpolator = createTimeInterpolator();
                    if (createAnimatorListener != null) {
                        createAnimator.addListener(createAnimatorListener);
                    }
                    if (createTimeInterpolator != null) {
                        createAnimator.setInterpolator(createTimeInterpolator);
                    }
                    wXComponent.getHostView().setCameraDistance(this.mAnimationBean.styles.getCameraDistance());
                    createAnimator.setDuration(this.mAnimationBean.duration);
                    createAnimator.start();
                }
            } catch (RuntimeException e) {
                WXLogUtils.e(TAG, WXLogUtils.getStackTrace(e));
            }
        }
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        WXSDKInstance wXSDKInstance;
        if (this.mAnimationBean == null) {
            return;
        }
        WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(getPageId(), getRef());
        if ((wXComponent == null && (!TemplateDom.isVirtualDomRef(getRef()) || (wXComponent = TemplateDom.findVirtualComponentByVRef(getPageId(), getRef())) == null)) || (wXSDKInstance = WXSDKManager.v().G().getWXSDKInstance(getPageId())) == null || this.mAnimationBean.styles == null) {
            return;
        }
        if (this.styleNeedInit) {
            String str = (String) wXComponent.getStyles().get(Constants.Name.TRANSFORM_ORIGIN);
            if (TextUtils.isEmpty(this.mAnimationBean.styles.transformOrigin)) {
                this.mAnimationBean.styles.transformOrigin = str;
            }
            WXAnimationBean.Style style = this.mAnimationBean.styles;
            style.init(style.transformOrigin, style.transform, (int) wXComponent.getLayoutWidth(), (int) wXComponent.getLayoutHeight(), wXSDKInstance.getInstanceViewPortWidth(), wXSDKInstance);
        }
        startAnimation(wXSDKInstance, wXComponent);
    }

    public GraphicActionAnimation(@NonNull WXSDKInstance wXSDKInstance, @NonNull String str, @Nullable String str2, @Nullable String str3) {
        super(wXSDKInstance, str);
        this.styleNeedInit = true;
        this.callback = str3;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.mAnimationBean = (WXAnimationBean) JSON.parseObject(str2, WXAnimationBean.class);
    }

    public GraphicActionAnimation(@NonNull WXSDKInstance wXSDKInstance, @NonNull String str, @NonNull WXAnimationBean wXAnimationBean, @Nullable String str2) {
        super(wXSDKInstance, str);
        this.styleNeedInit = false;
        this.mAnimationBean = wXAnimationBean;
        this.callback = str2;
    }
}
