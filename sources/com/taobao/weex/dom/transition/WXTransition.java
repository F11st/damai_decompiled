package com.taobao.weex.dom.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.collection.ArrayMap;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.Constants;
import com.taobao.weex.dom.CSSShorthand;
import com.taobao.weex.ui.animation.BackgroundColorProperty;
import com.taobao.weex.ui.animation.TransformParser;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.utils.SingleFunctionParser;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXResourceUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.apache.commons.lang3.CharUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXTransition {
    private static final Set<String> LAYOUT_PROPERTIES;
    public static final Pattern PROPERTY_SPLIT_PATTERN = Pattern.compile("\\||,");
    private static final Set<String> TRANSFORM_PROPERTIES;
    public static final String TRANSITION_DELAY = "transitionDelay";
    public static final String TRANSITION_DURATION = "transitionDuration";
    public static final String TRANSITION_PROPERTY = "transitionProperty";
    public static final String TRANSITION_TIMING_FUNCTION = "transitionTimingFunction";
    private Runnable animationRunnable;
    private long delay;
    private long duration;
    private Interpolator interpolator;
    private ValueAnimator layoutValueAnimator;
    private WXComponent mWXComponent;
    private Runnable transformAnimationRunnable;
    private ObjectAnimator transformAnimator;
    private Runnable transitionEndEvent;
    private volatile AtomicInteger lockToken = new AtomicInteger(0);
    private List<String> properties = new ArrayList(4);
    private Handler handler = new Handler();
    private Map<String, Object> layoutPendingUpdates = new ArrayMap();
    private Map<String, Object> transformPendingUpdates = new ArrayMap();
    private Map<String, Object> targetStyles = new ArrayMap();

    static {
        HashSet hashSet = new HashSet();
        LAYOUT_PROPERTIES = hashSet;
        hashSet.add("width");
        hashSet.add("height");
        hashSet.add(Constants.Name.MARGIN_TOP);
        hashSet.add(Constants.Name.MARGIN_BOTTOM);
        hashSet.add(Constants.Name.MARGIN_LEFT);
        hashSet.add(Constants.Name.MARGIN_RIGHT);
        hashSet.add("left");
        hashSet.add("right");
        hashSet.add("top");
        hashSet.add("bottom");
        hashSet.add("paddingLeft");
        hashSet.add("paddingRight");
        hashSet.add("paddingTop");
        hashSet.add("paddingBottom");
        HashSet hashSet2 = new HashSet();
        TRANSFORM_PROPERTIES = hashSet2;
        hashSet2.add("opacity");
        hashSet2.add("backgroundColor");
        hashSet2.add("transform");
    }

    public static void asynchronouslyUpdateLayout(WXComponent wXComponent, final String str, final float f) {
        if (wXComponent == null) {
            return;
        }
        final String ref = wXComponent.getRef();
        final String instanceId = wXComponent.getInstanceId();
        if (TextUtils.isEmpty(ref) || TextUtils.isEmpty(instanceId)) {
            return;
        }
        WXSDKManager.v().D().post(new Runnable() { // from class: com.taobao.weex.dom.transition.WXTransition.7
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                str2.hashCode();
                char c = 65535;
                switch (str2.hashCode()) {
                    case -1501175880:
                        if (str2.equals("paddingLeft")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1383228885:
                        if (str2.equals("bottom")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1221029593:
                        if (str2.equals("height")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1044792121:
                        if (str2.equals(Constants.Name.MARGIN_TOP)) {
                            c = 3;
                            break;
                        }
                        break;
                    case -289173127:
                        if (str2.equals(Constants.Name.MARGIN_BOTTOM)) {
                            c = 4;
                            break;
                        }
                        break;
                    case 115029:
                        if (str2.equals("top")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 3317767:
                        if (str2.equals("left")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 90130308:
                        if (str2.equals("paddingTop")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 108511772:
                        if (str2.equals("right")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case 113126854:
                        if (str2.equals("width")) {
                            c = '\t';
                            break;
                        }
                        break;
                    case 202355100:
                        if (str2.equals("paddingBottom")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case 713848971:
                        if (str2.equals("paddingRight")) {
                            c = 11;
                            break;
                        }
                        break;
                    case 975087886:
                        if (str2.equals(Constants.Name.MARGIN_RIGHT)) {
                            c = '\f';
                            break;
                        }
                        break;
                    case 1970934485:
                        if (str2.equals(Constants.Name.MARGIN_LEFT)) {
                            c = CharUtils.CR;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        WXBridgeManager.getInstance().setPadding(instanceId, ref, CSSShorthand.EDGE.LEFT, f);
                        return;
                    case 1:
                        WXBridgeManager.getInstance().setPosition(instanceId, ref, CSSShorthand.EDGE.BOTTOM, f);
                        return;
                    case 2:
                        WXBridgeManager.getInstance().setStyleHeight(instanceId, ref, f);
                        return;
                    case 3:
                        WXBridgeManager.getInstance().setMargin(instanceId, ref, CSSShorthand.EDGE.TOP, f);
                        return;
                    case 4:
                        WXBridgeManager.getInstance().setMargin(instanceId, ref, CSSShorthand.EDGE.BOTTOM, f);
                        return;
                    case 5:
                        WXBridgeManager.getInstance().setPosition(instanceId, ref, CSSShorthand.EDGE.TOP, f);
                        return;
                    case 6:
                        WXBridgeManager.getInstance().setPosition(instanceId, ref, CSSShorthand.EDGE.LEFT, f);
                        return;
                    case 7:
                        WXBridgeManager.getInstance().setPadding(instanceId, ref, CSSShorthand.EDGE.TOP, f);
                        return;
                    case '\b':
                        WXBridgeManager.getInstance().setPosition(instanceId, ref, CSSShorthand.EDGE.RIGHT, f);
                        return;
                    case '\t':
                        WXBridgeManager.getInstance().setStyleWidth(instanceId, ref, f);
                        return;
                    case '\n':
                        WXBridgeManager.getInstance().setPadding(instanceId, ref, CSSShorthand.EDGE.BOTTOM, f);
                        return;
                    case 11:
                        WXBridgeManager.getInstance().setPadding(instanceId, ref, CSSShorthand.EDGE.RIGHT, f);
                        return;
                    case '\f':
                        WXBridgeManager.getInstance().setMargin(instanceId, ref, CSSShorthand.EDGE.RIGHT, f);
                        return;
                    case '\r':
                        WXBridgeManager.getInstance().setMargin(instanceId, ref, CSSShorthand.EDGE.LEFT, f);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private PropertyValuesHolder createLayoutPropertyValueHolder(String str, Object obj) {
        String str2;
        PropertyValuesHolder ofFloat;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1501175880:
                str2 = "paddingLeft";
                if (str.equals(str2)) {
                    c = 0;
                    break;
                }
                break;
            case -1383228885:
                if (str.equals("bottom")) {
                    str2 = "paddingLeft";
                    c = 1;
                    break;
                }
                str2 = "paddingLeft";
                break;
            case -1221029593:
                if (str.equals("height")) {
                    str2 = "paddingLeft";
                    c = 2;
                    break;
                }
                str2 = "paddingLeft";
                break;
            case -1044792121:
                if (str.equals(Constants.Name.MARGIN_TOP)) {
                    c = 3;
                }
                str2 = "paddingLeft";
                break;
            case -289173127:
                if (str.equals(Constants.Name.MARGIN_BOTTOM)) {
                    c = 4;
                }
                str2 = "paddingLeft";
                break;
            case 115029:
                if (str.equals("top")) {
                    c = 5;
                }
                str2 = "paddingLeft";
                break;
            case 3317767:
                if (str.equals("left")) {
                    c = 6;
                }
                str2 = "paddingLeft";
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    c = 7;
                }
                str2 = "paddingLeft";
                break;
            case 108511772:
                if (str.equals("right")) {
                    c = '\b';
                }
                str2 = "paddingLeft";
                break;
            case 113126854:
                if (str.equals("width")) {
                    c = '\t';
                }
                str2 = "paddingLeft";
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    c = '\n';
                }
                str2 = "paddingLeft";
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    c = 11;
                }
                str2 = "paddingLeft";
                break;
            case 975087886:
                if (str.equals(Constants.Name.MARGIN_RIGHT)) {
                    c = '\f';
                }
                str2 = "paddingLeft";
                break;
            case 1970934485:
                if (str.equals(Constants.Name.MARGIN_LEFT)) {
                    c = CharUtils.CR;
                }
                str2 = "paddingLeft";
                break;
            default:
                str2 = "paddingLeft";
                break;
        }
        switch (c) {
            case 0:
                ofFloat = PropertyValuesHolder.ofFloat(str2, this.mWXComponent.getPadding().get(CSSShorthand.EDGE.LEFT), WXViewUtils.getRealPxByWidth(WXUtils.getFloatByViewport(obj, this.mWXComponent.getViewPortWidth()), this.mWXComponent.getViewPortWidth()));
                break;
            case 1:
                ofFloat = PropertyValuesHolder.ofFloat("bottom", this.mWXComponent.getLayoutPosition().getBottom(), WXViewUtils.getRealPxByWidth(WXUtils.getFloatByViewport(obj, this.mWXComponent.getViewPortWidth()), this.mWXComponent.getViewPortWidth()));
                break;
            case 2:
                ofFloat = PropertyValuesHolder.ofFloat("height", this.mWXComponent.getLayoutHeight(), WXViewUtils.getRealPxByWidth(WXUtils.getFloat(obj, Float.valueOf(0.0f)).floatValue(), this.mWXComponent.getViewPortWidth()));
                break;
            case 3:
                ofFloat = PropertyValuesHolder.ofFloat(Constants.Name.MARGIN_TOP, this.mWXComponent.getMargin().get(CSSShorthand.EDGE.TOP), WXViewUtils.getRealPxByWidth(WXUtils.getFloatByViewport(obj, this.mWXComponent.getViewPortWidth()), this.mWXComponent.getViewPortWidth()));
                break;
            case 4:
                ofFloat = PropertyValuesHolder.ofFloat(Constants.Name.MARGIN_BOTTOM, this.mWXComponent.getMargin().get(CSSShorthand.EDGE.BOTTOM), WXViewUtils.getRealPxByWidth(WXUtils.getFloatByViewport(obj, this.mWXComponent.getViewPortWidth()), this.mWXComponent.getViewPortWidth()));
                break;
            case 5:
                ofFloat = PropertyValuesHolder.ofFloat("top", this.mWXComponent.getLayoutPosition().getTop(), WXViewUtils.getRealPxByWidth(WXUtils.getFloatByViewport(obj, this.mWXComponent.getViewPortWidth()), this.mWXComponent.getViewPortWidth()));
                break;
            case 6:
                ofFloat = PropertyValuesHolder.ofFloat("left", this.mWXComponent.getLayoutPosition().getLeft(), WXViewUtils.getRealPxByWidth(WXUtils.getFloatByViewport(obj, this.mWXComponent.getViewPortWidth()), this.mWXComponent.getViewPortWidth()));
                break;
            case 7:
                ofFloat = PropertyValuesHolder.ofFloat("paddingTop", this.mWXComponent.getPadding().get(CSSShorthand.EDGE.TOP), WXViewUtils.getRealPxByWidth(WXUtils.getFloatByViewport(obj, this.mWXComponent.getViewPortWidth()), this.mWXComponent.getViewPortWidth()));
                break;
            case '\b':
                ofFloat = PropertyValuesHolder.ofFloat("right", this.mWXComponent.getLayoutPosition().getRight(), WXViewUtils.getRealPxByWidth(WXUtils.getFloatByViewport(obj, this.mWXComponent.getViewPortWidth()), this.mWXComponent.getViewPortWidth()));
                break;
            case '\t':
                ofFloat = PropertyValuesHolder.ofFloat("width", this.mWXComponent.getLayoutWidth(), WXViewUtils.getRealPxByWidth(WXUtils.getFloat(obj, Float.valueOf(0.0f)).floatValue(), this.mWXComponent.getViewPortWidth()));
                break;
            case '\n':
                ofFloat = PropertyValuesHolder.ofFloat("paddingBottom", this.mWXComponent.getPadding().get(CSSShorthand.EDGE.BOTTOM), WXViewUtils.getRealPxByWidth(WXUtils.getFloatByViewport(obj, this.mWXComponent.getViewPortWidth()), this.mWXComponent.getViewPortWidth()));
                break;
            case 11:
                ofFloat = PropertyValuesHolder.ofFloat("paddingRight", this.mWXComponent.getPadding().get(CSSShorthand.EDGE.RIGHT), WXViewUtils.getRealPxByWidth(WXUtils.getFloatByViewport(obj, this.mWXComponent.getViewPortWidth()), this.mWXComponent.getViewPortWidth()));
                break;
            case '\f':
                ofFloat = PropertyValuesHolder.ofFloat(Constants.Name.MARGIN_RIGHT, this.mWXComponent.getMargin().get(CSSShorthand.EDGE.RIGHT), WXViewUtils.getRealPxByWidth(WXUtils.getFloatByViewport(obj, this.mWXComponent.getViewPortWidth()), this.mWXComponent.getViewPortWidth()));
                break;
            case '\r':
                ofFloat = PropertyValuesHolder.ofFloat(Constants.Name.MARGIN_LEFT, this.mWXComponent.getMargin().get(CSSShorthand.EDGE.LEFT), WXViewUtils.getRealPxByWidth(WXUtils.getFloatByViewport(obj, this.mWXComponent.getViewPortWidth()), this.mWXComponent.getViewPortWidth()));
                break;
            default:
                ofFloat = null;
                break;
        }
        return ofFloat == null ? PropertyValuesHolder.ofFloat(str, 1.0f, 1.0f) : ofFloat;
    }

    private static Interpolator createTimeInterpolator(String str) {
        if (!TextUtils.isEmpty(str)) {
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
                case 3105774:
                    if (str.equals(Constants.TimeFunction.EASE)) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
                case 1:
                    return PathInterpolatorCompat.create(0.0f, 0.0f, 1.0f, 1.0f);
                case 2:
                    return PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
                case 3:
                    return PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f);
                case 4:
                    return PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
                default:
                    try {
                        List parse = new SingleFunctionParser(str, new SingleFunctionParser.FlatMapper<Float>() { // from class: com.taobao.weex.dom.transition.WXTransition.8
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.taobao.weex.utils.SingleFunctionParser.FlatMapper
                            public Float map(String str2) {
                                return Float.valueOf(Float.parseFloat(str2));
                            }
                        }).parse("cubic-bezier");
                        if (parse != null && parse.size() == 4) {
                            return PathInterpolatorCompat.create(((Float) parse.get(0)).floatValue(), ((Float) parse.get(1)).floatValue(), ((Float) parse.get(2)).floatValue(), ((Float) parse.get(3)).floatValue());
                        }
                    } catch (RuntimeException e) {
                        if (WXEnvironment.isApkDebugable()) {
                            WXLogUtils.e("WXTransition", e);
                            break;
                        }
                    }
                    break;
            }
        }
        return PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
    }

    private void doLayoutPropertyValuesHolderAnimation(PropertyValuesHolder[] propertyValuesHolderArr) {
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderArr);
        this.layoutValueAnimator = ofPropertyValuesHolder;
        ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.taobao.weex.dom.transition.WXTransition.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                for (PropertyValuesHolder propertyValuesHolder : valueAnimator.getValues()) {
                    String propertyName = propertyValuesHolder.getPropertyName();
                    WXTransition.asynchronouslyUpdateLayout(WXTransition.this.mWXComponent, propertyName, ((Float) valueAnimator.getAnimatedValue(propertyName)).floatValue());
                }
            }
        });
        this.layoutValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.taobao.weex.dom.transition.WXTransition.6
            boolean hasCancel = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.hasCancel = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (this.hasCancel) {
                    return;
                }
                super.onAnimationEnd(animator);
                WXTransition.this.onTransitionAnimationEnd();
            }
        });
        Interpolator interpolator = this.interpolator;
        if (interpolator != null) {
            this.layoutValueAnimator.setInterpolator(interpolator);
        }
        this.layoutValueAnimator.setStartDelay(this.delay);
        this.layoutValueAnimator.setDuration(this.duration);
        this.layoutValueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPendingTransformAnimation(int i) {
        View targetView;
        ObjectAnimator objectAnimator = this.transformAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.transformAnimator = null;
        }
        if (this.transformPendingUpdates.size() == 0 || (targetView = getTargetView()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(8);
        String string = WXUtils.getString(this.transformPendingUpdates.remove("transform"), null);
        if (!TextUtils.isEmpty(string)) {
            for (PropertyValuesHolder propertyValuesHolder : TransformParser.toHolders(TransformParser.parseTransForm(this.mWXComponent.getInstanceId(), string, (int) this.mWXComponent.getLayoutWidth(), (int) this.mWXComponent.getLayoutHeight(), this.mWXComponent.getViewPortWidth()))) {
                arrayList.add(propertyValuesHolder);
            }
            synchronized (this.targetStyles) {
                this.targetStyles.put("transform", string);
            }
        }
        for (String str : this.properties) {
            if (TRANSFORM_PROPERTIES.contains(str) && this.transformPendingUpdates.containsKey(str)) {
                Object remove = this.transformPendingUpdates.remove(str);
                synchronized (this.targetStyles) {
                    this.targetStyles.put(str, remove);
                }
                str.hashCode();
                if (str.equals("opacity")) {
                    arrayList.add(PropertyValuesHolder.ofFloat(View.ALPHA, targetView.getAlpha(), WXUtils.getFloat(remove, Float.valueOf(1.0f)).floatValue()));
                    targetView.setLayerType(1, null);
                } else if (str.equals("backgroundColor")) {
                    int color = WXResourceUtils.getColor(WXUtils.getString(this.mWXComponent.getStyles().getBackgroundColor(), null), 0);
                    int color2 = WXResourceUtils.getColor(WXUtils.getString(remove, null), 0);
                    if (WXViewUtils.getBorderDrawable(targetView) != null) {
                        color = WXViewUtils.getBorderDrawable(targetView).getColor();
                    } else if (targetView.getBackground() instanceof ColorDrawable) {
                        color = ((ColorDrawable) targetView.getBackground()).getColor();
                    }
                    arrayList.add(PropertyValuesHolder.ofObject(new BackgroundColorProperty(), new ArgbEvaluator(), Integer.valueOf(color), Integer.valueOf(color2)));
                }
            }
        }
        if (i == this.lockToken.get()) {
            this.transformPendingUpdates.clear();
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(targetView, (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[arrayList.size()]));
        this.transformAnimator = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(this.duration);
        long j = this.delay;
        if (j > 0) {
            this.transformAnimator.setStartDelay(j);
        }
        Interpolator interpolator = this.interpolator;
        if (interpolator != null) {
            this.transformAnimator.setInterpolator(interpolator);
        }
        this.transformAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.taobao.weex.dom.transition.WXTransition.4
            boolean hasCancel = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.hasCancel = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (this.hasCancel) {
                    return;
                }
                super.onAnimationEnd(animator);
                WXTransition.this.onTransitionAnimationEnd();
            }
        });
        this.transformAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doTransitionAnimation(final int i) {
        View targetView = getTargetView();
        if (targetView == null) {
            return;
        }
        if (this.targetStyles.size() > 0) {
            for (String str : this.properties) {
                if (LAYOUT_PROPERTIES.contains(str) || TRANSFORM_PROPERTIES.contains(str)) {
                    if (!this.layoutPendingUpdates.containsKey(str) && !this.transformPendingUpdates.containsKey(str)) {
                        synchronized (this.targetStyles) {
                            if (this.targetStyles.containsKey(str)) {
                                this.mWXComponent.getStyles().put(str, this.targetStyles.remove(str));
                            }
                        }
                    }
                }
            }
        }
        Runnable runnable = this.transitionEndEvent;
        if (runnable != null) {
            targetView.removeCallbacks(runnable);
        }
        if (this.transitionEndEvent == null && ((float) this.duration) > Float.MIN_NORMAL) {
            this.transitionEndEvent = new Runnable() { // from class: com.taobao.weex.dom.transition.WXTransition.2
                @Override // java.lang.Runnable
                public void run() {
                    WXTransition.this.transitionEndEvent = null;
                    if (((float) WXTransition.this.duration) >= Float.MIN_NORMAL && WXTransition.this.mWXComponent != null && WXTransition.this.mWXComponent.getEvents().contains(Constants.Event.ON_TRANSITION_END)) {
                        WXTransition.this.mWXComponent.fireEvent(Constants.Event.ON_TRANSITION_END);
                    }
                }
            };
        }
        Runnable runnable2 = this.transformAnimationRunnable;
        if (runnable2 != null) {
            targetView.removeCallbacks(runnable2);
        }
        Runnable runnable3 = new Runnable() { // from class: com.taobao.weex.dom.transition.WXTransition.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (WXTransition.this.lockToken) {
                    if (i == WXTransition.this.lockToken.get()) {
                        WXTransition.this.doPendingTransformAnimation(i);
                    }
                }
            }
        };
        this.transformAnimationRunnable = runnable3;
        targetView.post(runnable3);
        doPendingLayoutAnimation();
    }

    public static WXTransition fromMap(Map<String, Object> map, WXComponent wXComponent) {
        String string;
        if (map.get(TRANSITION_PROPERTY) == null || (string = WXUtils.getString(map.get(TRANSITION_PROPERTY), null)) == null) {
            return null;
        }
        WXTransition wXTransition = new WXTransition();
        updateTransitionProperties(wXTransition, string);
        if (wXTransition.properties.isEmpty()) {
            return null;
        }
        wXTransition.duration = parseTimeMillis(map, TRANSITION_DURATION, 0L);
        wXTransition.delay = parseTimeMillis(map, TRANSITION_DELAY, 0L);
        wXTransition.interpolator = createTimeInterpolator(WXUtils.getString(map.get(TRANSITION_TIMING_FUNCTION), null));
        wXTransition.mWXComponent = wXComponent;
        return wXTransition;
    }

    private View getTargetView() {
        WXComponent wXComponent = this.mWXComponent;
        if (wXComponent != null) {
            return wXComponent.getHostView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTransitionAnimationEnd() {
        Runnable runnable;
        if (this.duration > 0 && this.transitionEndEvent != null) {
            View targetView = getTargetView();
            if (targetView != null && (runnable = this.transitionEndEvent) != null) {
                targetView.post(runnable);
            }
            this.transitionEndEvent = null;
        }
        synchronized (this.targetStyles) {
            if (this.targetStyles.size() > 0) {
                for (String str : this.properties) {
                    if (this.targetStyles.containsKey(str)) {
                        this.mWXComponent.getStyles().put(str, this.targetStyles.remove(str));
                    }
                }
                this.targetStyles.clear();
            }
        }
    }

    private static long parseTimeMillis(Map<String, Object> map, String str, long j) {
        String string = WXUtils.getString(map.get(str), null);
        if (string != null) {
            string = string.replaceAll("ms", "");
        }
        if (string != null) {
            if (WXEnvironment.isApkDebugable() && string.contains("px")) {
                WXLogUtils.w("Transition Duration Unit Only Support ms, " + string + " is not ms Unit");
            }
            string = string.replaceAll("px", "");
        }
        if (TextUtils.isEmpty(string)) {
            return j;
        }
        try {
            return Float.parseFloat(string);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    private static void updateTransitionProperties(WXTransition wXTransition, String str) {
        if (str == null) {
            return;
        }
        wXTransition.properties.clear();
        for (String str2 : PROPERTY_SPLIT_PATTERN.split(str)) {
            String trim = str2.trim();
            if (!TextUtils.isEmpty(trim)) {
                if (!LAYOUT_PROPERTIES.contains(trim) && !TRANSFORM_PROPERTIES.contains(trim)) {
                    if (WXEnvironment.isApkDebugable()) {
                        WXLogUtils.e("WXTransition Property Not Supported" + trim + " in " + str);
                    }
                } else {
                    wXTransition.properties.add(trim);
                }
            }
        }
    }

    public void doPendingLayoutAnimation() {
        ValueAnimator valueAnimator = this.layoutValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.layoutValueAnimator = null;
        }
        if (this.layoutPendingUpdates.size() == 0) {
            return;
        }
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[this.layoutPendingUpdates.size()];
        int i = 0;
        for (String str : this.properties) {
            if (LAYOUT_PROPERTIES.contains(str) && this.layoutPendingUpdates.containsKey(str)) {
                Object remove = this.layoutPendingUpdates.remove(str);
                synchronized (this.targetStyles) {
                    this.targetStyles.put(str, remove);
                }
                propertyValuesHolderArr[i] = createLayoutPropertyValueHolder(str, remove);
                i++;
            }
        }
        this.layoutPendingUpdates.clear();
        doLayoutPropertyValuesHolderAnimation(propertyValuesHolderArr);
    }

    public List<String> getProperties() {
        return this.properties;
    }

    public boolean hasTransitionProperty(Map<String, Object> map) {
        for (String str : this.properties) {
            if (map.containsKey(str)) {
                return true;
            }
        }
        return false;
    }

    public void startTransition(Map<String, Object> map) {
        synchronized (this.lockToken) {
            if (getTargetView() == null) {
                return;
            }
            final int incrementAndGet = this.lockToken.incrementAndGet();
            for (String str : this.properties) {
                if (map.containsKey(str)) {
                    Object remove = map.remove(str);
                    if (LAYOUT_PROPERTIES.contains(str)) {
                        this.layoutPendingUpdates.put(str, remove);
                    } else if (TRANSFORM_PROPERTIES.contains(str)) {
                        this.transformPendingUpdates.put(str, remove);
                    }
                }
            }
            int numberInt = WXUtils.getNumberInt(this.mWXComponent.getAttrs().get("actionDelay"), 16);
            long j = this.duration;
            if (numberInt > j) {
                numberInt = (int) j;
            }
            Runnable runnable = this.animationRunnable;
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: com.taobao.weex.dom.transition.WXTransition.1
                @Override // java.lang.Runnable
                public void run() {
                    if (incrementAndGet == WXTransition.this.lockToken.get()) {
                        WXTransition.this.doTransitionAnimation(incrementAndGet);
                    }
                    WXTransition.this.animationRunnable = null;
                }
            };
            this.animationRunnable = runnable2;
            if (numberInt > 0) {
                this.handler.postDelayed(runnable2, numberInt);
            } else {
                runnable2.run();
            }
        }
    }

    public void updateTranstionParams(Map<String, Object> map) {
        if (map.containsKey(TRANSITION_DELAY)) {
            this.mWXComponent.getStyles().put(TRANSITION_DELAY, map.remove(TRANSITION_DELAY));
            this.delay = parseTimeMillis(this.mWXComponent.getStyles(), TRANSITION_DELAY, 0L);
        }
        if (map.containsKey(TRANSITION_TIMING_FUNCTION) && map.get(TRANSITION_TIMING_FUNCTION) != null) {
            this.mWXComponent.getStyles().put(TRANSITION_TIMING_FUNCTION, map.remove(TRANSITION_TIMING_FUNCTION));
            this.interpolator = createTimeInterpolator(this.mWXComponent.getStyles().get(TRANSITION_TIMING_FUNCTION).toString());
        }
        if (map.containsKey(TRANSITION_DURATION)) {
            this.mWXComponent.getStyles().put(TRANSITION_DURATION, map.remove(TRANSITION_DURATION));
            this.duration = parseTimeMillis(this.mWXComponent.getStyles(), TRANSITION_DURATION, 0L);
        }
        if (map.containsKey(TRANSITION_PROPERTY)) {
            this.mWXComponent.getStyles().put(TRANSITION_PROPERTY, map.remove(TRANSITION_PROPERTY));
            updateTransitionProperties(this, WXUtils.getString(this.mWXComponent.getStyles().get(TRANSITION_PROPERTY), null));
        }
    }
}
