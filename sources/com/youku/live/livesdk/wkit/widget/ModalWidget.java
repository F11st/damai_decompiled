package com.youku.live.livesdk.wkit.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.youku.live.livesdk.wkit.widget.view.WebWidgetView;
import com.youku.live.livesdk.wkit.widget.view.WeexWidgetView;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.impl.BaseWidget;
import com.youku.live.widgets.protocol.IDestroyable;
import com.youku.live.widgets.protocol.ISystemEvent;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.protocol.Orientation;
import com.youku.live.widgets.protocol.activity.IActivityResultListener;
import com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener;
import java.util.HashMap;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ModalWidget extends BaseWidget implements View.OnClickListener, ISystemEvent {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int ANIMATION_DURATION = 300;
    public static final String MODAL_CLOSE = "modalClose";
    public static final String TYPE_H5 = "h5";
    public static final String TYPE_NATIVE = "native";
    public static final String TYPE_WEEX = "weex";
    public static final String UNIT_PERCENT = "%";
    public static final String WIDGET_NAME = "Modal";
    private ContainerView mContainerView;
    private View mContentView;
    private View mMaskView;
    private View mRenderView;
    private boolean mSupportAnimation;
    private boolean mSupportMaskClickClose;
    private WebWidgetView mWebView;
    private WeexWidgetView mWeexView;

    private void directCloseSelfDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-181695956")) {
            ipChange.ipc$dispatch("-181695956", new Object[]{this});
        } else {
            getEngineInstance().runOnMainThread(new Runnable() { // from class: com.youku.live.livesdk.wkit.widget.ModalWidget.7
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-162330863")) {
                        ipChange2.ipc$dispatch("-162330863", new Object[]{this});
                    } else {
                        ModalWidget.this.getEngineInstance().closeDialog(ModalWidget.this.id);
                    }
                }
            });
        }
    }

    public static GradientDrawable getRoundRectDrawable(int i, boolean z, int i2, boolean z2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-503709494")) {
            return (GradientDrawable) ipChange.ipc$dispatch("-503709494", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), Integer.valueOf(i3)});
        }
        float[] fArr = new float[8];
        for (int i4 = 0; i4 < 8; i4++) {
            fArr[i4] = i;
        }
        if (z) {
            for (int i5 = 4; i5 < 8; i5++) {
                fArr[i5] = 0.0f;
            }
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(z2 ? i2 : 0);
        if (z2) {
            i3 = 0;
        }
        gradientDrawable.setStroke(i3, i2);
        return gradientDrawable;
    }

    private void hookWeexRelease() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-560119124")) {
            ipChange.ipc$dispatch("-560119124", new Object[]{this});
            return;
        }
        View view = this.mContentView;
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            int childCount = frameLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = frameLayout.getChildAt(i);
                if (childAt instanceof IDestroyable) {
                    ((IDestroyable) childAt).destroy();
                }
            }
        }
    }

    private boolean initAnimationValue() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1845372130")) {
            return ((Boolean) ipChange.ipc$dispatch("1845372130", new Object[]{this})).booleanValue();
        }
        String string = getProps().getString(v.TAK_ABILITY_SHOW_POP_ANIMATION, null);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        try {
            return Boolean.valueOf(string).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initBackgroundAndCorners(android.view.View r9) {
        /*
            r8 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.livesdk.wkit.widget.ModalWidget.$ipChange
            java.lang.String r1 = "-1557691364"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L17
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r8
            r2[r3] = r9
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            if (r9 != 0) goto L1a
            return
        L1a:
            com.youku.live.widgets.protocol.IProps r0 = r8.getProps()
            r1 = 0
            java.lang.String r2 = "modalBackgroundColor"
            java.lang.String r0 = r0.getString(r2, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L30
            int r0 = android.graphics.Color.parseColor(r0)     // Catch: java.lang.Exception -> L30
            goto L31
        L30:
            r0 = 0
        L31:
            r1 = 1097859072(0x41700000, float:15.0)
            int r1 = com.youku.live.livesdk.wkit.utils.DpUtil.dip2px(r1)
            com.youku.live.widgets.protocol.Orientation r2 = com.youku.live.widgets.WidgetSDKEngine.getOrientation()
            com.youku.live.widgets.protocol.Orientation r5 = com.youku.live.widgets.protocol.Orientation.ORIENTATION_PORTAIT
            java.lang.String r6 = "false"
            java.lang.String r7 = "true"
            if (r2 != r5) goto L5c
            com.youku.live.widgets.protocol.IProps r2 = r8.getProps()
            java.lang.String r5 = "disableBorderRadius"
            java.lang.String r2 = r2.getString(r5, r6)
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L54
            r1 = 0
        L54:
            android.graphics.drawable.GradientDrawable r0 = getRoundRectDrawable(r1, r3, r0, r3, r4)
            r9.setBackground(r0)
            goto L74
        L5c:
            com.youku.live.widgets.protocol.IProps r2 = r8.getProps()
            java.lang.String r5 = "disableLandBorderRadius"
            java.lang.String r2 = r2.getString(r5, r6)
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L6d
            r1 = 0
        L6d:
            android.graphics.drawable.GradientDrawable r0 = getRoundRectDrawable(r1, r4, r0, r3, r4)
            r9.setBackground(r0)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.livesdk.wkit.widget.ModalWidget.initBackgroundAndCorners(android.view.View):void");
    }

    private ContainerView initContainerView(Context context) {
        int doubleValue;
        int i;
        int i2;
        int i3;
        IpChange ipChange = $ipChange;
        int i4 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-330743826")) {
            return (ContainerView) ipChange.ipc$dispatch("-330743826", new Object[]{this, context});
        }
        ContainerView containerView = new ContainerView(context);
        containerView.setStandardWidth(getEngineInstance().getStandardWidth());
        String string = getProps().getString("width", null);
        String string2 = getProps().getString("height", null);
        String string3 = getProps().getString("landWidth", null);
        String string4 = getProps().getString("landHeight", null);
        if (!TextUtils.isEmpty(string)) {
            boolean endsWith = string.endsWith("%");
            try {
                if (endsWith) {
                    i3 = Integer.valueOf(string.substring(0, string.length() - 1)).intValue();
                } else {
                    i3 = (int) (Double.valueOf(string).doubleValue() + 0.5d);
                }
            } catch (Throwable unused) {
                i3 = 0;
            }
            containerView.setPortraitChildWidth(i3, endsWith);
        }
        if (!TextUtils.isEmpty(string2)) {
            boolean endsWith2 = string2.endsWith("%");
            try {
                if (endsWith2) {
                    i2 = Integer.valueOf(string2.substring(0, string2.length() - 1)).intValue();
                } else {
                    i2 = (int) (Double.valueOf(string2).doubleValue() + 0.5d);
                }
            } catch (Throwable unused2) {
                i2 = 0;
            }
            containerView.setPortraitChildHeight(i2, endsWith2);
        }
        if (!TextUtils.isEmpty(string3)) {
            boolean endsWith3 = string3.endsWith("%");
            try {
                if (endsWith3) {
                    i = Integer.valueOf(string3.substring(0, string3.length() - 1)).intValue();
                } else {
                    i = (int) (Double.valueOf(string3).doubleValue() + 0.5d);
                }
            } catch (Throwable unused3) {
                i = 0;
            }
            containerView.setLandscapeChildWidth(i, endsWith3);
        }
        if (!TextUtils.isEmpty(string4)) {
            boolean endsWith4 = string4.endsWith("%");
            try {
                if (endsWith4) {
                    doubleValue = Integer.valueOf(string4.substring(0, string4.length() - 1)).intValue();
                } else {
                    doubleValue = (int) (Double.valueOf(string4).doubleValue() + 0.5d);
                }
                i4 = doubleValue;
            } catch (Throwable unused4) {
            }
            containerView.setLandscapeChildHeight(i4, endsWith4);
        }
        return containerView;
    }

    private View initContentView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-991107959")) {
            return (View) ipChange.ipc$dispatch("-991107959", new Object[]{this, context});
        }
        FrameLayout frameLayout = new FrameLayout(context);
        String string = getProps().getString("url", null);
        String string2 = getProps().getString("type", null);
        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string)) {
            if ("weex".compareToIgnoreCase(string2) == 0) {
                WeexWidgetView weexWidgetView = new WeexWidgetView(context);
                weexWidgetView.bindEngineInstance(getEngineInstance());
                weexWidgetView.render(string, new HashMap(), "");
                frameLayout.addView(weexWidgetView, new FrameLayout.LayoutParams(-1, -1));
                this.mRenderView = weexWidgetView;
            } else if ("h5".compareToIgnoreCase(string2) == 0) {
                WebWidgetView webWidgetView = new WebWidgetView(context);
                webWidgetView.bindEngineInstance(getEngineInstance());
                webWidgetView.render(string);
                frameLayout.addView(webWidgetView, new FrameLayout.LayoutParams(-1, -1));
                this.mRenderView = webWidgetView;
            }
        }
        initBackgroundAndCorners(frameLayout);
        return frameLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View initMaskView(android.content.Context r7) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.livesdk.wkit.widget.ModalWidget.$ipChange
            java.lang.String r1 = "-945009072"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            if (r2 == 0) goto L1a
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r6
            r3 = 1
            r2[r3] = r7
            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
            android.view.View r7 = (android.view.View) r7
            return r7
        L1a:
            android.view.View r0 = new android.view.View
            r0.<init>(r7)
            com.youku.live.widgets.protocol.IProps r1 = r6.getProps()
            java.lang.String r2 = "mask"
            r4 = 0
            java.lang.String r1 = r1.getString(r2, r4)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L39
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L39
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L39
            goto L3a
        L39:
            r1 = 0
        L3a:
            com.youku.live.widgets.protocol.IProps r2 = r6.getProps()
            java.lang.String r5 = "maskClickClose"
            java.lang.String r2 = r2.getString(r5, r4)
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 != 0) goto L53
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L53
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L53
            goto L54
        L53:
            r2 = 0
        L54:
            if (r1 == 0) goto L79
            android.view.View r0 = new android.view.View
            r0.<init>(r7)
            com.youku.live.widgets.protocol.IProps r7 = r6.getProps()
            java.lang.String r1 = "backgroundColor"
            java.lang.String r7 = r7.getString(r1, r4)
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 != 0) goto L71
            int r3 = com.youku.live.livesdk.wkit.utils.ColorUtil.parseColor(r7)     // Catch: java.lang.Throwable -> L70
            goto L71
        L70:
        L71:
            r0.setBackgroundColor(r3)
            if (r2 == 0) goto L79
            r0.setOnClickListener(r6)
        L79:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.livesdk.wkit.widget.ModalWidget.initMaskView(android.content.Context):android.view.View");
    }

    private Animation makeAnimationWithFadeIn(final View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1866096790")) {
            return (Animation) ipChange.ipc$dispatch("1866096790", new Object[]{this, view});
        }
        if (view == null) {
            return null;
        }
        view.setVisibility(4);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.livesdk.wkit.widget.ModalWidget.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-181683370")) {
                    ipChange2.ipc$dispatch("-181683370", new Object[]{this, animation});
                    return;
                }
                View view2 = view;
                if (view2 != null) {
                    view2.clearAnimation();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1383089058")) {
                    ipChange2.ipc$dispatch("-1383089058", new Object[]{this, animation});
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-8859345")) {
                    ipChange2.ipc$dispatch("-8859345", new Object[]{this, animation});
                    return;
                }
                View view2 = view;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            }
        });
        view.setAnimation(alphaAnimation);
        return alphaAnimation;
    }

    private Animation makeAnimationWithFadeOut() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514747151")) {
            return (Animation) ipChange.ipc$dispatch("-1514747151", new Object[]{this});
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        return alphaAnimation;
    }

    private Animation makeAnimationWithTranslateIn(final View view) {
        TranslateAnimation translateAnimation;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "380996296")) {
            return (Animation) ipChange.ipc$dispatch("380996296", new Object[]{this, view});
        }
        if (view == null) {
            return null;
        }
        view.setVisibility(4);
        if (WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_PORTAIT) {
            translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        } else {
            translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        }
        translateAnimation.setDuration(300L);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.livesdk.wkit.widget.ModalWidget.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "511709335")) {
                    ipChange2.ipc$dispatch("511709335", new Object[]{this, animation});
                    return;
                }
                View view2 = view;
                if (view2 != null) {
                    view2.clearAnimation();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "981259133")) {
                    ipChange2.ipc$dispatch("981259133", new Object[]{this, animation});
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "621599280")) {
                    ipChange2.ipc$dispatch("621599280", new Object[]{this, animation});
                    return;
                }
                View view2 = view;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            }
        });
        view.setAnimation(translateAnimation);
        return translateAnimation;
    }

    private Animation makeAnimationWithTranslateOut() {
        TranslateAnimation translateAnimation;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "293764515")) {
            return (Animation) ipChange.ipc$dispatch("293764515", new Object[]{this});
        }
        if (WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_PORTAIT) {
            translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        } else {
            translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
        }
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeFromParent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "465067367")) {
            return ((Boolean) ipChange.ipc$dispatch("465067367", new Object[]{this})).booleanValue();
        }
        IWidget parent = getParent();
        if (parent != null) {
            hookWeexRelease();
            return parent.deleteChild(this);
        }
        return false;
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol.IWidget
    public boolean closeSelf() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "45205711")) {
            return ((Boolean) ipChange.ipc$dispatch("45205711", new Object[]{this})).booleanValue();
        }
        if (this.mSupportAnimation) {
            final Animation makeAnimationWithTranslateOut = makeAnimationWithTranslateOut();
            makeAnimationWithTranslateOut.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.livesdk.wkit.widget.ModalWidget.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2033105811")) {
                        ipChange2.ipc$dispatch("2033105811", new Object[]{this, animation});
                        return;
                    }
                    View view = ModalWidget.this.mContentView;
                    if (view != null) {
                        view.setVisibility(4);
                        view.clearAnimation();
                    }
                    ModalWidget.this.removeFromParent();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "113800961")) {
                        ipChange2.ipc$dispatch("113800961", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1900235220")) {
                        ipChange2.ipc$dispatch("-1900235220", new Object[]{this, animation});
                    }
                }
            });
            final Animation makeAnimationWithFadeOut = makeAnimationWithFadeOut();
            makeAnimationWithFadeOut.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.livesdk.wkit.widget.ModalWidget.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1568468780")) {
                        ipChange2.ipc$dispatch("-1568468780", new Object[]{this, animation});
                        return;
                    }
                    View view = ModalWidget.this.mMaskView;
                    if (view != null) {
                        view.setVisibility(4);
                        view.clearAnimation();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1816818144")) {
                        ipChange2.ipc$dispatch("-1816818144", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1269776595")) {
                        ipChange2.ipc$dispatch("-1269776595", new Object[]{this, animation});
                    }
                }
            });
            ContainerView containerView = this.mContainerView;
            if (containerView != null) {
                containerView.post(new Runnable() { // from class: com.youku.live.livesdk.wkit.widget.ModalWidget.4
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "427209652")) {
                            ipChange2.ipc$dispatch("427209652", new Object[]{this});
                            return;
                        }
                        View view = ModalWidget.this.mContentView;
                        if (view != null) {
                            view.startAnimation(makeAnimationWithTranslateOut);
                        }
                        View view2 = ModalWidget.this.mMaskView;
                        if (view2 != null) {
                            view2.startAnimation(makeAnimationWithFadeOut);
                        }
                    }
                });
            }
        } else {
            removeFromParent();
        }
        getEngineInstance().asyncPutData(MODAL_CLOSE, this.id);
        return true;
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public View initHostView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1581028876")) {
            return (View) ipChange.ipc$dispatch("1581028876", new Object[]{this, context});
        }
        this.mContainerView = initContainerView(context);
        this.mMaskView = initMaskView(context);
        this.mContentView = initContentView(context);
        this.mSupportAnimation = initAnimationValue();
        ContainerView containerView = this.mContainerView;
        View view = this.mContentView;
        View view2 = this.mMaskView;
        if (view2 != null) {
            containerView.addMaskView(view2);
        }
        if (view != null) {
            containerView.addContentView(view);
        }
        if (this.mSupportAnimation && containerView != null) {
            final Animation makeAnimationWithFadeIn = view2 != null ? makeAnimationWithFadeIn(view2) : null;
            final Animation makeAnimationWithTranslateIn = view != null ? makeAnimationWithTranslateIn(view) : null;
            containerView.post(new Runnable() { // from class: com.youku.live.livesdk.wkit.widget.ModalWidget.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1016750167")) {
                        ipChange2.ipc$dispatch("1016750167", new Object[]{this});
                        return;
                    }
                    Animation animation = makeAnimationWithTranslateIn;
                    if (animation != null) {
                        animation.startNow();
                    }
                    Animation animation2 = makeAnimationWithFadeIn;
                    if (animation2 != null) {
                        animation2.startNow();
                    }
                }
            });
        }
        return containerView;
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityBackPressedListener
    public boolean onActivityBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-125667258")) {
            return ((Boolean) ipChange.ipc$dispatch("-125667258", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityConfigurationChangedListener
    public void onActivityConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-54469471")) {
            ipChange.ipc$dispatch("-54469471", new Object[]{this, configuration});
        }
    }

    @Override // com.youku.live.widgets.protocol.ISystemEvent
    public void onActivityDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1887952163")) {
            ipChange.ipc$dispatch("1887952163", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityLowMemoryListener
    public void onActivityLowMemory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-98275384")) {
            ipChange.ipc$dispatch("-98275384", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener
    public void onActivityPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1452171353")) {
            ipChange.ipc$dispatch("-1452171353", new Object[]{this});
            return;
        }
        View view = this.mRenderView;
        if (view instanceof IActivityResumeStateChangedListener) {
            ((IActivityResumeStateChangedListener) view).onActivityPause();
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityRequestPermissionsResultListener
    public void onActivityRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "589044581")) {
            ipChange.ipc$dispatch("589044581", new Object[]{this, Integer.valueOf(i), strArr, iArr});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResultListener
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1796541805")) {
            ipChange.ipc$dispatch("1796541805", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        View view = this.mRenderView;
        if (view instanceof IActivityResultListener) {
            ((IActivityResultListener) view).onActivityResult(i, i2, intent);
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener
    public void onActivityResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-419852480")) {
            ipChange.ipc$dispatch("-419852480", new Object[]{this});
            return;
        }
        View view = this.mRenderView;
        if (view instanceof IActivityResumeStateChangedListener) {
            ((IActivityResumeStateChangedListener) view).onActivityResume();
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityStartStateChangedListener
    public void onActivityStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1409066565")) {
            ipChange.ipc$dispatch("-1409066565", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityStartStateChangedListener
    public void onActivityStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2045552971")) {
            ipChange.ipc$dispatch("2045552971", new Object[]{this});
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1176933524")) {
            ipChange.ipc$dispatch("-1176933524", new Object[]{this, view});
        } else {
            directCloseSelfDialog();
        }
    }

    @Override // com.youku.live.widgets.protocol.ISystemEvent
    public boolean systemEventFilter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "56105680")) {
            return ((Boolean) ipChange.ipc$dispatch("56105680", new Object[]{this})).booleanValue();
        }
        return false;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class ContainerView extends FrameLayout {
        private static transient /* synthetic */ IpChange $ipChange;
        private View mContentView;
        private int mLandscapeHeight;
        private boolean mLandscapeHeightPercent;
        private int mLandscapeWidth;
        private boolean mLandscapeWidthPercent;
        private View mMaskView;
        private int mPortraitHeight;
        private boolean mPortraitHeightPercent;
        private int mPortraitWidth;
        private boolean mPortraitWidthPercent;
        private int mStandardWidth;

        public ContainerView(@NonNull Context context) {
            super(context);
            this.mStandardWidth = FeatureFactory.PRIORITY_ABOVE_NORMAL;
            this.mPortraitWidth = 0;
            this.mPortraitWidthPercent = false;
            this.mPortraitHeight = 0;
            this.mPortraitHeightPercent = false;
            this.mLandscapeWidth = 0;
            this.mLandscapeWidthPercent = false;
            this.mLandscapeHeight = 0;
            this.mLandscapeHeightPercent = false;
        }

        public void addContentView(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1874835026")) {
                ipChange.ipc$dispatch("1874835026", new Object[]{this, view});
                return;
            }
            this.mContentView = view;
            if (view != null) {
                addView(view, new ViewGroup.LayoutParams(-2, -2));
            }
        }

        public void addMaskView(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1369362615")) {
                ipChange.ipc$dispatch("1369362615", new Object[]{this, view});
                return;
            }
            this.mMaskView = view;
            if (view != null) {
                addView(view, new ViewGroup.LayoutParams(-1, -1));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
            if (r0 != 3) goto L12;
         */
        @Override // android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
            /*
                r6 = this;
                com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.livesdk.wkit.widget.ModalWidget.ContainerView.$ipChange
                java.lang.String r1 = "1041282113"
                boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                r3 = 0
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L1e
                java.lang.Object[] r2 = new java.lang.Object[r4]
                r2[r3] = r6
                r2[r5] = r7
                java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r7 = r7.booleanValue()
                return r7
            L1e:
                int r0 = r7.getAction()
                if (r0 == 0) goto L34
                if (r0 == r5) goto L2c
                if (r0 == r4) goto L34
                r1 = 3
                if (r0 == r1) goto L2c
                goto L3b
            L2c:
                android.view.ViewParent r0 = r6.getParent()
                r0.requestDisallowInterceptTouchEvent(r3)
                goto L3b
            L34:
                android.view.ViewParent r0 = r6.getParent()
                r0.requestDisallowInterceptTouchEvent(r5)
            L3b:
                boolean r7 = super.dispatchTouchEvent(r7)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.youku.live.livesdk.wkit.widget.ModalWidget.ContainerView.dispatchTouchEvent(android.view.MotionEvent):boolean");
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "589086624")) {
                ipChange.ipc$dispatch("589086624", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
                return;
            }
            int childCount = getChildCount();
            int i10 = i3 - i;
            int i11 = i4 - i2;
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt.equals(this.mContentView)) {
                    if (WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_PORTAIT) {
                        if (this.mPortraitWidthPercent) {
                            i5 = (this.mPortraitWidth * i10) / 100;
                        } else {
                            i5 = (this.mPortraitWidth * i10) / this.mStandardWidth;
                        }
                        if (this.mPortraitHeightPercent) {
                            i6 = (this.mPortraitHeight * i11) / 100;
                        } else {
                            i6 = (this.mPortraitHeight * i10) / this.mStandardWidth;
                        }
                        i7 = (i10 - i5) / 2;
                        i8 = i7 + i5;
                        i9 = i11 - i6;
                    } else {
                        if (this.mLandscapeWidthPercent) {
                            i5 = (this.mLandscapeWidth * i10) / 100;
                        } else {
                            i5 = (this.mLandscapeWidth * i11) / this.mStandardWidth;
                        }
                        if (this.mLandscapeHeightPercent) {
                            i6 = (this.mLandscapeHeight * i11) / 100;
                        } else {
                            i6 = (this.mLandscapeHeight * i11) / this.mStandardWidth;
                        }
                        i7 = i10 - i5;
                        i8 = i7 + i5;
                        i9 = (i11 - i6) / 2;
                    }
                    int i13 = i6 + i9;
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = i5;
                        layoutParams.height = i6;
                        childAt.setLayoutParams(layoutParams);
                    }
                    childAt.layout(i7, i9, i8, i13);
                } else {
                    ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.width = -1;
                        layoutParams2.height = -1;
                        childAt.setLayoutParams(layoutParams2);
                    }
                    childAt.layout(0, 0, i10, i11);
                }
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int i3;
            int i4;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-694464274")) {
                ipChange.ipc$dispatch("-694464274", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            int childCount = getChildCount();
            setMeasuredDimension(size, size2);
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt.equals(this.mContentView)) {
                    if (WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_PORTAIT) {
                        if (this.mPortraitWidthPercent) {
                            i3 = (this.mPortraitWidth * size) / 100;
                        } else {
                            i3 = (this.mPortraitWidth * size) / this.mStandardWidth;
                        }
                        if (this.mPortraitHeightPercent) {
                            i4 = (this.mPortraitHeight * size2) / 100;
                        } else {
                            i4 = (this.mPortraitHeight * size) / this.mStandardWidth;
                        }
                        int i6 = (size - i3) / 2;
                    } else {
                        if (this.mLandscapeWidthPercent) {
                            i3 = (this.mLandscapeWidth * size) / 100;
                        } else {
                            i3 = (this.mLandscapeWidth * size2) / this.mStandardWidth;
                        }
                        if (this.mLandscapeHeightPercent) {
                            i4 = (this.mLandscapeHeight * size2) / 100;
                        } else {
                            i4 = (this.mLandscapeHeight * size2) / this.mStandardWidth;
                        }
                        int i7 = (size2 - i4) / 2;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
                } else {
                    childAt.measure(i, i2);
                }
            }
        }

        public void setLandscapeChildHeight(int i, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-230941452")) {
                ipChange.ipc$dispatch("-230941452", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
                return;
            }
            this.mLandscapeHeight = i;
            this.mLandscapeHeightPercent = z;
        }

        public void setLandscapeChildWidth(int i, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2027317653")) {
                ipChange.ipc$dispatch("-2027317653", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
                return;
            }
            this.mLandscapeWidth = i;
            this.mLandscapeWidthPercent = z;
        }

        public void setPortraitChildHeight(int i, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1454340952")) {
                ipChange.ipc$dispatch("-1454340952", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
                return;
            }
            this.mPortraitHeight = i;
            this.mPortraitHeightPercent = z;
        }

        public void setPortraitChildWidth(int i, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2066782153")) {
                ipChange.ipc$dispatch("-2066782153", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
                return;
            }
            this.mPortraitWidth = i;
            this.mPortraitWidthPercent = z;
        }

        public void setStandardWidth(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1470444051")) {
                ipChange.ipc$dispatch("-1470444051", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.mStandardWidth = i;
            }
        }

        public ContainerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mStandardWidth = FeatureFactory.PRIORITY_ABOVE_NORMAL;
            this.mPortraitWidth = 0;
            this.mPortraitWidthPercent = false;
            this.mPortraitHeight = 0;
            this.mPortraitHeightPercent = false;
            this.mLandscapeWidth = 0;
            this.mLandscapeWidthPercent = false;
            this.mLandscapeHeight = 0;
            this.mLandscapeHeightPercent = false;
        }

        public ContainerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.mStandardWidth = FeatureFactory.PRIORITY_ABOVE_NORMAL;
            this.mPortraitWidth = 0;
            this.mPortraitWidthPercent = false;
            this.mPortraitHeight = 0;
            this.mPortraitHeightPercent = false;
            this.mLandscapeWidth = 0;
            this.mLandscapeWidthPercent = false;
            this.mLandscapeHeight = 0;
            this.mLandscapeHeightPercent = false;
        }
    }
}
