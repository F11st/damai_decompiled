package com.alibaba.gaiax.render.view.container.slider;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.render.view.GXIContainer;
import com.alibaba.gaiax.render.view.GXIRelease;
import com.alibaba.gaiax.render.view.GXIRootView;
import com.alibaba.gaiax.render.view.GXIRoundCorner;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alibaba.gaiax.render.view.GXIViewVisibleChange;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.youku.arch.v3.core.Constants;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cs0;
import tb.hs0;
import tb.is0;
import tb.k50;
import tb.kr0;
import tb.lz1;
import tb.os0;
import tb.wt2;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002GHB\u0011\b\u0016\u0012\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010BB\u001b\b\u0016\u0012\u0006\u0010@\u001a\u00020?\u0012\b\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0004\bA\u0010EJ\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017J\u0012\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011J\u0010\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0016J \u0010%\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010$\u001a\u00020#2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010&\u001a\u00020\bH\u0016J\u0010\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020\bH\u0014J\b\u0010+\u001a\u00020\bH\u0014R\u0016\u0010,\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R$\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006I"}, d2 = {"Lcom/alibaba/gaiax/render/view/container/slider/GXSliderView;", "Landroid/widget/FrameLayout;", "Lcom/alibaba/gaiax/render/view/GXIContainer;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "Lcom/alibaba/gaiax/render/view/GXIRootView;", "Lcom/alibaba/gaiax/render/view/GXIRoundCorner;", "Lcom/alibaba/gaiax/render/view/GXIRelease;", "Lcom/alibaba/gaiax/render/view/GXIViewVisibleChange;", "Ltb/wt2;", "initView", "initViewPager", "initIndicator", "Lcom/alibaba/gaiax/render/view/container/slider/GXSliderBaseIndicatorView;", "createIndicatorView", "updateView", "startTimer", "stopTimer", "Ltb/is0;", Constants.CONFIG, "setConfig", "Lcom/alibaba/fastjson/JSONObject;", "data", "onBindData", "", "size", "setPageSize", "Ltb/os0;", "gxContext", "setTemplateContext", "getTemplateContext", "getConfig", "", BQCCameraParam.FOCUS_AREA_RADIUS, "setRoundCornerRadius", "borderColor", "", Constants.Name.BORDER_WIDTH, "setRoundCornerBorder", "release", "", "visible", "onVisibleChanged", "onAttachedToWindow", "onDetachedFromWindow", "isAttached", "Z", "Lcom/alibaba/gaiax/render/view/container/slider/GXViewPager;", "viewPager", "Lcom/alibaba/gaiax/render/view/container/slider/GXViewPager;", "getViewPager", "()Lcom/alibaba/gaiax/render/view/container/slider/GXViewPager;", "setViewPager", "(Lcom/alibaba/gaiax/render/view/container/slider/GXViewPager;)V", "indicatorView", "Lcom/alibaba/gaiax/render/view/container/slider/GXSliderBaseIndicatorView;", Constants.Name.PAGE_SIZE, "I", "Ljava/util/Timer;", "timer", "Ljava/util/Timer;", "Ljava/util/TimerTask;", "timerTask", "Ljava/util/TimerTask;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "a", "IndicatorPosition", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public final class GXSliderView extends FrameLayout implements GXIContainer, GXIRelease, GXIRootView, GXIRoundCorner, GXIViewBindData, GXIViewVisibleChange {
    @NotNull
    public static final C3374a Companion = new C3374a(null);
    private static int SHOWN_VIEW_COUNT;
    @Nullable
    private is0 config;
    @Nullable
    private os0 gxTemplateContext;
    @Nullable
    private GXSliderBaseIndicatorView indicatorView;
    private boolean isAttached;
    private int pageSize;
    @Nullable
    private Timer timer;
    @Nullable
    private TimerTask timerTask;
    @Nullable
    private GXViewPager viewPager;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/alibaba/gaiax/render/view/container/slider/GXSliderView$IndicatorPosition;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "TOP_LEFT", "TOP_CENTER", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_CENTER", "BOTTOM_RIGHT", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes6.dex */
    public enum IndicatorPosition {
        TOP_LEFT("top-left"),
        TOP_CENTER("top-center"),
        TOP_RIGHT("top-right"),
        BOTTOM_LEFT("bottom-left"),
        BOTTOM_CENTER("bottom-center"),
        BOTTOM_RIGHT("bottom-right");
        
        @NotNull
        public static final C3373a Companion = new C3373a(null);
        @NotNull
        private final String value;

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.render.view.container.slider.GXSliderView$IndicatorPosition$a */
        /* loaded from: classes6.dex */
        public static final class C3373a {
            private C3373a() {
            }

            public /* synthetic */ C3373a(k50 k50Var) {
                this();
            }

            @NotNull
            public final IndicatorPosition a(@Nullable String str) {
                IndicatorPosition indicatorPosition = IndicatorPosition.TOP_LEFT;
                if (b41.d(str, indicatorPosition.getValue())) {
                    return indicatorPosition;
                }
                IndicatorPosition indicatorPosition2 = IndicatorPosition.TOP_CENTER;
                if (b41.d(str, indicatorPosition2.getValue())) {
                    return indicatorPosition2;
                }
                IndicatorPosition indicatorPosition3 = IndicatorPosition.TOP_RIGHT;
                if (b41.d(str, indicatorPosition3.getValue())) {
                    return indicatorPosition3;
                }
                IndicatorPosition indicatorPosition4 = IndicatorPosition.BOTTOM_LEFT;
                if (b41.d(str, indicatorPosition4.getValue())) {
                    return indicatorPosition4;
                }
                IndicatorPosition indicatorPosition5 = IndicatorPosition.BOTTOM_CENTER;
                return b41.d(str, indicatorPosition5.getValue()) ? indicatorPosition5 : IndicatorPosition.BOTTOM_RIGHT;
            }
        }

        IndicatorPosition(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.render.view.container.slider.GXSliderView$a */
    /* loaded from: classes6.dex */
    public static final class C3374a {
        private C3374a() {
        }

        public /* synthetic */ C3374a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.render.view.container.slider.GXSliderView$b */
    /* loaded from: classes6.dex */
    public /* synthetic */ class C3375b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IndicatorPosition.values().length];
            iArr[IndicatorPosition.TOP_LEFT.ordinal()] = 1;
            iArr[IndicatorPosition.TOP_CENTER.ordinal()] = 2;
            iArr[IndicatorPosition.TOP_RIGHT.ordinal()] = 3;
            iArr[IndicatorPosition.BOTTOM_LEFT.ordinal()] = 4;
            iArr[IndicatorPosition.BOTTOM_CENTER.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.render.view.container.slider.GXSliderView$c */
    /* loaded from: classes6.dex */
    public static final class View$OnTouchListenerC3376c implements View.OnTouchListener {
        View$OnTouchListenerC3376c() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                GXSliderView.this.stopTimer();
                return false;
            } else if (action == 1) {
                GXSliderView.this.startTimer();
                return false;
            } else if (action != 2) {
                return false;
            } else {
                GXSliderView.this.stopTimer();
                return false;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.render.view.container.slider.GXSliderView$d */
    /* loaded from: classes6.dex */
    public static final class C3377d extends ViewOutlineProvider {
        final /* synthetic */ float b;

        C3377d(float f) {
            this.b = f;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            b41.i(view, "view");
            b41.i(outline, com.taobao.android.launcher.common.Constants.PARAMETER_OUTLINE);
            if (GXSliderView.this.getAlpha() >= 0.0f) {
                outline.setAlpha(GXSliderView.this.getAlpha());
            }
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXSliderView(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        initView();
    }

    private final GXSliderBaseIndicatorView createIndicatorView() {
        String c;
        is0 is0Var = this.config;
        if (is0Var != null && (c = is0Var.c()) != null) {
            try {
                Object newInstance = Class.forName(c).getConstructor(Context.class).newInstance(getContext());
                GXSliderBaseIndicatorView gXSliderBaseIndicatorView = newInstance instanceof GXSliderBaseIndicatorView ? (GXSliderBaseIndicatorView) newInstance : null;
                if (gXSliderBaseIndicatorView != null) {
                    return gXSliderBaseIndicatorView;
                }
            } catch (Exception e) {
                e.printStackTrace();
                wt2 wt2Var = wt2.INSTANCE;
            }
        }
        Context context = getContext();
        b41.h(context, WPKFactory.INIT_KEY_CONTEXT);
        return new GXSliderDefaultIndicatorView(context);
    }

    private final void initIndicator() {
        lz1<hs0> e;
        View view = this.indicatorView;
        if (view != null) {
            removeView(view);
        }
        this.indicatorView = createIndicatorView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        is0 is0Var = this.config;
        if (is0Var != null && (e = is0Var.e()) != null) {
            layoutParams.leftMargin = e.c().d();
            layoutParams.topMargin = e.d().d();
            layoutParams.rightMargin = e.b().d();
            layoutParams.bottomMargin = e.a().d();
        }
        is0 is0Var2 = this.config;
        IndicatorPosition g = is0Var2 == null ? null : is0Var2.g();
        int i = g == null ? -1 : C3375b.$EnumSwitchMapping$0[g.ordinal()];
        if (i == 1) {
            layoutParams.gravity = 51;
        } else if (i == 2) {
            layoutParams.gravity = 49;
        } else if (i == 3) {
            layoutParams.gravity = 53;
        } else if (i == 4) {
            layoutParams.gravity = 83;
        } else if (i != 5) {
            layoutParams.gravity = 85;
        } else {
            layoutParams.gravity = 81;
        }
        addView(this.indicatorView, layoutParams);
    }

    private final void initView() {
        initViewPager();
    }

    private final void initViewPager() {
        Context context = getContext();
        b41.h(context, WPKFactory.INIT_KEY_CONTEXT);
        GXViewPager gXViewPager = new GXViewPager(context);
        this.viewPager = gXViewPager;
        gXViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.alibaba.gaiax.render.view.container.slider.GXSliderView$initViewPager$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
                r0 = r3.a.indicatorView;
             */
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPageSelected(int r4) {
                /*
                    r3 = this;
                    com.alibaba.gaiax.render.view.container.slider.GXSliderView r0 = com.alibaba.gaiax.render.view.container.slider.GXSliderView.this
                    tb.is0 r0 = com.alibaba.gaiax.render.view.container.slider.GXSliderView.access$getConfig$p(r0)
                    r1 = 0
                    r2 = 1
                    if (r0 != 0) goto Lb
                    goto L12
                Lb:
                    boolean r0 = r0.a()
                    if (r0 != r2) goto L12
                    r1 = 1
                L12:
                    if (r1 == 0) goto L27
                    com.alibaba.gaiax.render.view.container.slider.GXSliderView r0 = com.alibaba.gaiax.render.view.container.slider.GXSliderView.this
                    com.alibaba.gaiax.render.view.container.slider.GXSliderBaseIndicatorView r0 = com.alibaba.gaiax.render.view.container.slider.GXSliderView.access$getIndicatorView$p(r0)
                    if (r0 != 0) goto L1d
                    goto L27
                L1d:
                    com.alibaba.gaiax.render.view.container.slider.GXSliderView r1 = com.alibaba.gaiax.render.view.container.slider.GXSliderView.this
                    int r1 = com.alibaba.gaiax.render.view.container.slider.GXSliderView.access$getPageSize$p(r1)
                    int r4 = r4 % r1
                    r0.updateSelectedIndex(r4)
                L27:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alibaba.gaiax.render.view.container.slider.GXSliderView$initViewPager$1.onPageSelected(int):void");
            }
        });
        GXViewPager gXViewPager2 = this.viewPager;
        if (gXViewPager2 != null) {
            gXViewPager2.setOnTouchListener(new View$OnTouchListenerC3376c());
        }
        addView(this.viewPager, new FrameLayout.LayoutParams(-1, -1));
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("GXSliderView initViewPager this=" + this + " viewPager=" + this.viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startTimer() {
        stopTimer();
        is0 is0Var = this.config;
        if (is0Var != null) {
            long o = is0Var.o();
            if (o > 0) {
                this.timer = new Timer();
                TimerTask timerTask = new TimerTask() { // from class: com.alibaba.gaiax.render.view.container.slider.GXSliderView$startTimer$1$1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        PagerAdapter adapter;
                        Timer timer;
                        TimerTask timerTask2;
                        kr0 kr0Var = kr0.INSTANCE;
                        if (kr0Var.b()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("GXSliderView timerTask this=");
                            sb.append(GXSliderView.this);
                            sb.append(" viewPager=");
                            sb.append(GXSliderView.this.getViewPager());
                            sb.append(" timer=");
                            timer = GXSliderView.this.timer;
                            sb.append(timer);
                            sb.append(" timerTask=");
                            timerTask2 = GXSliderView.this.timerTask;
                            sb.append(timerTask2);
                            kr0Var.a(sb.toString());
                        }
                        GXViewPager viewPager = GXSliderView.this.getViewPager();
                        if (viewPager == null) {
                            return;
                        }
                        final int currentItem = viewPager.getCurrentItem();
                        final GXSliderView gXSliderView = GXSliderView.this;
                        GXViewPager viewPager2 = gXSliderView.getViewPager();
                        if (viewPager2 == null || (adapter = viewPager2.getAdapter()) == null) {
                            return;
                        }
                        final int count = adapter.getCount();
                        GXViewPager viewPager3 = gXSliderView.getViewPager();
                        if (viewPager3 == null) {
                            return;
                        }
                        viewPager3.post(new Runnable() { // from class: com.alibaba.gaiax.render.view.container.slider.GXSliderView$startTimer$1$1$run$1$1$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                GXViewPager viewPager4 = GXSliderView.this.getViewPager();
                                if (viewPager4 == null) {
                                    return;
                                }
                                viewPager4.setCurrentItem((currentItem + 1) % count, true);
                            }
                        });
                    }
                };
                this.timerTask = timerTask;
                Timer timer = this.timer;
                if (timer != null) {
                    timer.schedule(timerTask, o, o);
                }
            }
        }
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("GXSliderView startTimer this=" + this + " viewPager=" + this.viewPager + " timer=" + this.timer + " timerTask=" + this.timerTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopTimer() {
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("GXSliderView stopTimer this=" + this + " viewPager=" + this.viewPager + " timer=" + this.timer + " timerTask=" + this.timerTask);
        }
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        TimerTask timerTask = this.timerTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.timer = null;
        this.timerTask = null;
    }

    private final void updateView() {
        PagerAdapter adapter;
        is0 is0Var = this.config;
        if (is0Var == null) {
            return;
        }
        int q = is0Var.q();
        GXViewPager viewPager = getViewPager();
        if (viewPager == null || (adapter = viewPager.getAdapter()) == null) {
            return;
        }
        if (q >= 0 && q < adapter.getCount()) {
            GXViewPager viewPager2 = getViewPager();
            if (viewPager2 != null) {
                viewPager2.setCurrentItem(q, false);
            }
            GXSliderBaseIndicatorView gXSliderBaseIndicatorView = this.indicatorView;
            if (gXSliderBaseIndicatorView == null) {
                return;
            }
            gXSliderBaseIndicatorView.updateSelectedIndex(q);
        }
    }

    @Nullable
    public final is0 getConfig() {
        return this.config;
    }

    @Override // com.alibaba.gaiax.render.view.GXIRootView
    @Nullable
    public os0 getTemplateContext() {
        return this.gxTemplateContext;
    }

    @Nullable
    public final GXViewPager getViewPager() {
        return this.viewPager;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        this.isAttached = true;
        super.onAttachedToWindow();
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("GXSliderView onAttachedToWindow this=" + this + " viewPager=" + this.viewPager);
        }
        if (SHOWN_VIEW_COUNT <= 0) {
            SHOWN_VIEW_COUNT = 0;
            SHOWN_VIEW_COUNT = 0 + 1;
            startTimer();
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(@Nullable JSONObject jSONObject) {
        PagerAdapter adapter;
        GXViewPager gXViewPager = this.viewPager;
        if (gXViewPager == null || (adapter = gXViewPager.getAdapter()) == null) {
            return;
        }
        adapter.notifyDataSetChanged();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.isAttached = false;
        super.onDetachedFromWindow();
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("GXSliderView onDetachedFromWindow this=" + this + " viewPager=" + this.viewPager);
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onResetData() {
        GXIViewBindData.C3361a.a(this);
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewVisibleChange
    public void onVisibleChanged(boolean z) {
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("GXSliderView onVisibleChanged this=" + this + " viewPager=" + this.viewPager + " visible=" + z + " isAttached=" + this.isAttached);
        }
        if (this.isAttached) {
            if (z) {
                startTimer();
            } else {
                stopTimer();
            }
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIRelease
    public void release() {
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("GXSliderView release this=" + this + " viewPager=" + this.viewPager);
        }
        this.indicatorView = null;
        stopTimer();
        int i = SHOWN_VIEW_COUNT;
        if (i > 0) {
            SHOWN_VIEW_COUNT = i - 1;
        }
    }

    public final void setConfig(@Nullable is0 is0Var) {
        this.config = is0Var;
        boolean z = false;
        if (is0Var != null && is0Var.a()) {
            z = true;
        }
        if (z) {
            initIndicator();
            GXSliderBaseIndicatorView gXSliderBaseIndicatorView = this.indicatorView;
            if (gXSliderBaseIndicatorView == null) {
                return;
            }
            gXSliderBaseIndicatorView.setIndicatorColor(Integer.valueOf(is0Var.i().c(getContext())), Integer.valueOf(is0Var.k().c(getContext())));
        }
    }

    public final void setPageSize(int i) {
        this.pageSize = i;
        GXSliderBaseIndicatorView gXSliderBaseIndicatorView = this.indicatorView;
        if (gXSliderBaseIndicatorView == null) {
            return;
        }
        gXSliderBaseIndicatorView.setIndicatorCount(i);
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerBorder(int i, float f, @NotNull float[] fArr) {
        b41.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        if (Build.VERSION.SDK_INT < 23 || fArr.length != 8) {
            return;
        }
        if (getForeground() == null) {
            cs0 cs0Var = new cs0();
            cs0Var.setShape(0);
            cs0Var.setCornerRadii(fArr);
            cs0Var.setStroke((int) f, i);
            setForeground(cs0Var);
        } else if (getForeground() instanceof GradientDrawable) {
            Drawable foreground = getForeground();
            Objects.requireNonNull(foreground, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable gradientDrawable = (GradientDrawable) foreground;
            gradientDrawable.setStroke((int) f, i);
            gradientDrawable.setCornerRadii(fArr);
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerRadius(@NotNull float[] fArr) {
        b41.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        if (fArr.length == 8) {
            float f = fArr[0];
            float f2 = fArr[2];
            float f3 = fArr[4];
            float f4 = fArr[6];
            if (Build.VERSION.SDK_INT >= 21) {
                if (f == f2) {
                    if (f2 == f3) {
                        if ((f3 == f4) && f > 0.0f) {
                            setClipToOutline(true);
                            setOutlineProvider(new C3377d(f));
                            return;
                        }
                    }
                }
                setClipToOutline(false);
                setOutlineProvider(null);
            }
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIRootView
    public void setTemplateContext(@Nullable os0 os0Var) {
        this.gxTemplateContext = os0Var;
    }

    public final void setViewPager(@Nullable GXViewPager gXViewPager) {
        this.viewPager = gXViewPager;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXSliderView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        initView();
    }
}
