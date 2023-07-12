package com.alibaba.android.bindingx.plugin.android;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.android.bindingx.core.PlatformManager;
import com.alibaba.android.bindingx.core.WeakRunnable;
import com.alibaba.android.bindingx.core.internal.o;
import com.taobao.weex.common.Constants;
import com.taobao.weex.devtools.inspector.elements.W3CStyleConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.bb1;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class NativeViewUpdateService {
    private static final Map<String, INativeViewUpdater> a;
    private static final LayoutUpdater b = new LayoutUpdater();
    private static final b c = new b();
    private static final List<String> d = Arrays.asList("width", "height", W3CStyleConstants.MARGIN_LEFT, W3CStyleConstants.MARGIN_RIGHT, W3CStyleConstants.MARGIN_TOP, W3CStyleConstants.MARGIN_BOTTOM, W3CStyleConstants.PADDING_LEFT, W3CStyleConstants.PADDING_RIGHT, W3CStyleConstants.PADDING_TOP, W3CStyleConstants.PADDING_BOTTOM);
    private static final Handler e = new Handler(Looper.getMainLooper());

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static final class BackgroundUpdater implements INativeViewUpdater {
        private BackgroundUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
            if (obj instanceof Integer) {
                final int intValue = ((Integer) obj).intValue();
                NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.BackgroundUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Drawable background = view.getBackground();
                        if (background == null) {
                            view.setBackgroundColor(intValue);
                        } else if (background instanceof ColorDrawable) {
                            ((ColorDrawable) background).setColor(intValue);
                        }
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static final class ColorUpdater implements INativeViewUpdater {
        private ColorUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
            if (obj instanceof Integer) {
                final int intValue = ((Integer) obj).intValue();
                NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.ColorUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        View view2 = view;
                        if (view2 instanceof TextView) {
                            ((TextView) view2).setTextColor(intValue);
                        }
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static final class ContentOffsetXUpdater implements INativeViewUpdater {
        private ContentOffsetXUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull Object obj, @NonNull final PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
            if (obj instanceof Double) {
                final double doubleValue = ((Double) obj).doubleValue();
                NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.ContentOffsetXUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        view.setScrollX((int) NativeViewUpdateService.g(doubleValue, iDeviceResolutionTranslator));
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static final class ContentOffsetYUpdater implements INativeViewUpdater {
        private ContentOffsetYUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull Object obj, @NonNull final PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
            if (obj instanceof Double) {
                final double doubleValue = ((Double) obj).doubleValue();
                NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.ContentOffsetYUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        view.setScrollY((int) NativeViewUpdateService.g(doubleValue, iDeviceResolutionTranslator));
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static final class LayoutUpdater implements INativeViewUpdater {
        private String a;

        private LayoutUpdater() {
        }

        void a(String str) {
            this.a = str;
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
            if (!(obj instanceof Double) || TextUtils.isEmpty(this.a)) {
                return;
            }
            final int g = (int) NativeViewUpdateService.g(((Double) obj).doubleValue(), iDeviceResolutionTranslator);
            String str2 = this.a;
            str2.hashCode();
            char c = 65535;
            switch (str2.hashCode()) {
                case -1502084711:
                    if (str2.equals(W3CStyleConstants.PADDING_TOP)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1221029593:
                    if (str2.equals("height")) {
                        c = 1;
                        break;
                    }
                    break;
                case -887955139:
                    if (str2.equals(W3CStyleConstants.MARGIN_RIGHT)) {
                        c = 2;
                        break;
                    }
                    break;
                case -396426912:
                    if (str2.equals(W3CStyleConstants.PADDING_RIGHT)) {
                        c = 3;
                        break;
                    }
                    break;
                case 113126854:
                    if (str2.equals("width")) {
                        c = 4;
                        break;
                    }
                    break;
                case 143541095:
                    if (str2.equals(W3CStyleConstants.PADDING_BOTTOM)) {
                        c = 5;
                        break;
                    }
                    break;
                case 679766083:
                    if (str2.equals(W3CStyleConstants.PADDING_LEFT)) {
                        c = 6;
                        break;
                    }
                    break;
                case 941004998:
                    if (str2.equals(W3CStyleConstants.MARGIN_LEFT)) {
                        c = 7;
                        break;
                    }
                    break;
                case 1970025654:
                    if (str2.equals(W3CStyleConstants.MARGIN_TOP)) {
                        c = '\b';
                        break;
                    }
                    break;
                case 2086035242:
                    if (str2.equals(W3CStyleConstants.MARGIN_BOTTOM)) {
                        c = '\t';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.9
                        @Override // java.lang.Runnable
                        public void run() {
                            View view2 = view;
                            view2.setPadding(view2.getPaddingLeft(), g, view.getPaddingRight(), view.getPaddingBottom());
                        }
                    });
                    break;
                case 1:
                    NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            layoutParams.height = g;
                            view.setLayoutParams(layoutParams);
                        }
                    });
                    break;
                case 2:
                    NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.4
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = g;
                                view.setLayoutParams(layoutParams);
                                return;
                            }
                            bb1.b("set margin right failed");
                        }
                    });
                    break;
                case 3:
                    NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.8
                        @Override // java.lang.Runnable
                        public void run() {
                            View view2 = view;
                            view2.setPadding(view2.getPaddingLeft(), view.getPaddingTop(), g, view.getPaddingBottom());
                        }
                    });
                    break;
                case 4:
                    NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            layoutParams.width = g;
                            view.setLayoutParams(layoutParams);
                        }
                    });
                    break;
                case 5:
                    NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.10
                        @Override // java.lang.Runnable
                        public void run() {
                            View view2 = view;
                            view2.setPadding(view2.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), g);
                        }
                    });
                    break;
                case 6:
                    NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.7
                        @Override // java.lang.Runnable
                        public void run() {
                            View view2 = view;
                            view2.setPadding(g, view2.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
                        }
                    });
                    break;
                case 7:
                    NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.3
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = g;
                                view.setLayoutParams(layoutParams);
                                return;
                            }
                            bb1.b("set margin left failed");
                        }
                    });
                    break;
                case '\b':
                    NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.5
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = g;
                                view.setLayoutParams(layoutParams);
                                return;
                            }
                            bb1.b("set margin top failed");
                        }
                    });
                    break;
                case '\t':
                    NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.LayoutUpdater.6
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = g;
                                view.setLayoutParams(layoutParams);
                                return;
                            }
                            bb1.b("set margin bottom failed");
                        }
                    });
                    break;
            }
            this.a = null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static final class OpacityUpdater implements INativeViewUpdater {
        private OpacityUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
            if (obj instanceof Double) {
                final float doubleValue = (float) ((Double) obj).doubleValue();
                NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.OpacityUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        view.setAlpha(doubleValue);
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static final class RotateUpdater implements INativeViewUpdater {
        private RotateUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull final Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull final Map<String, Object> map) {
            if (obj instanceof Double) {
                NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.RotateUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int k = o.k(view.getContext(), NativeViewUpdateService.f(map, Constants.Name.PERSPECTIVE));
                        Pair<Float, Float> l = o.l(o.h(map, Constants.Name.TRANSFORM_ORIGIN), view);
                        if (k != 0) {
                            view.setCameraDistance(k);
                        }
                        if (l != null) {
                            view.setPivotX(((Float) l.first).floatValue());
                            view.setPivotY(((Float) l.second).floatValue());
                        }
                        view.setRotation((float) ((Double) obj).doubleValue());
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static final class RotateXUpdater implements INativeViewUpdater {
        private RotateXUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull final Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull final Map<String, Object> map) {
            if (obj instanceof Double) {
                NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.RotateXUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int k = o.k(view.getContext(), NativeViewUpdateService.f(map, Constants.Name.PERSPECTIVE));
                        Pair<Float, Float> l = o.l(o.h(map, Constants.Name.TRANSFORM_ORIGIN), view);
                        if (k != 0) {
                            view.setCameraDistance(k);
                        }
                        if (l != null) {
                            view.setPivotX(((Float) l.first).floatValue());
                            view.setPivotY(((Float) l.second).floatValue());
                        }
                        view.setRotationX((float) ((Double) obj).doubleValue());
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static final class RotateYUpdater implements INativeViewUpdater {
        private RotateYUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull final Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull final Map<String, Object> map) {
            if (obj instanceof Double) {
                NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.RotateYUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int k = o.k(view.getContext(), NativeViewUpdateService.f(map, Constants.Name.PERSPECTIVE));
                        Pair<Float, Float> l = o.l(o.h(map, Constants.Name.TRANSFORM_ORIGIN), view);
                        if (k != 0) {
                            view.setCameraDistance(k);
                        }
                        if (l != null) {
                            view.setPivotX(((Float) l.first).floatValue());
                            view.setPivotY(((Float) l.second).floatValue());
                        }
                        view.setRotationY((float) ((Double) obj).doubleValue());
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static final class ScaleUpdater implements INativeViewUpdater {
        private ScaleUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull final Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull final Map<String, Object> map) {
            NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.ScaleUpdater.1
                @Override // java.lang.Runnable
                public void run() {
                    Pair<Float, Float> l = o.l(o.h(map, Constants.Name.TRANSFORM_ORIGIN), view);
                    if (l != null) {
                        view.setPivotX(((Float) l.first).floatValue());
                        view.setPivotY(((Float) l.second).floatValue());
                    }
                    Object obj2 = obj;
                    if (obj2 instanceof Double) {
                        float doubleValue = (float) ((Double) obj2).doubleValue();
                        view.setScaleX(doubleValue);
                        view.setScaleY(doubleValue);
                    } else if (obj2 instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) obj2;
                        if (arrayList.size() >= 2 && (arrayList.get(0) instanceof Double) && (arrayList.get(1) instanceof Double)) {
                            double doubleValue2 = ((Double) arrayList.get(0)).doubleValue();
                            double doubleValue3 = ((Double) arrayList.get(1)).doubleValue();
                            view.setScaleX((float) doubleValue2);
                            view.setScaleY((float) doubleValue3);
                        }
                    }
                }
            });
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static final class ScaleXUpdater implements INativeViewUpdater {
        private ScaleXUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull final Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull final Map<String, Object> map) {
            if (obj instanceof Double) {
                NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.ScaleXUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Pair<Float, Float> l = o.l(o.h(map, Constants.Name.TRANSFORM_ORIGIN), view);
                        if (l != null) {
                            view.setPivotX(((Float) l.first).floatValue());
                            view.setPivotY(((Float) l.second).floatValue());
                        }
                        view.setScaleX((float) ((Double) obj).doubleValue());
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static final class ScaleYUpdater implements INativeViewUpdater {
        private ScaleYUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull final Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull final Map<String, Object> map) {
            if (obj instanceof Double) {
                NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.ScaleYUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Pair<Float, Float> l = o.l(o.h(map, Constants.Name.TRANSFORM_ORIGIN), view);
                        if (l != null) {
                            view.setPivotX(((Float) l.first).floatValue());
                            view.setPivotY(((Float) l.second).floatValue());
                        }
                        view.setScaleY((float) ((Double) obj).doubleValue());
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static final class TranslateUpdater implements INativeViewUpdater {
        private TranslateUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull Object obj, @NonNull final PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
            if (obj instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) obj;
                if (arrayList.size() >= 2 && (arrayList.get(0) instanceof Double) && (arrayList.get(1) instanceof Double)) {
                    final double doubleValue = ((Double) arrayList.get(0)).doubleValue();
                    final double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
                    NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.TranslateUpdater.1
                        @Override // java.lang.Runnable
                        public void run() {
                            view.setTranslationX((float) NativeViewUpdateService.g(doubleValue, iDeviceResolutionTranslator));
                            view.setTranslationY((float) NativeViewUpdateService.g(doubleValue2, iDeviceResolutionTranslator));
                        }
                    });
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static final class TranslateXUpdater implements INativeViewUpdater {
        private TranslateXUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull Object obj, @NonNull final PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
            if (obj instanceof Double) {
                final double doubleValue = ((Double) obj).doubleValue();
                NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.TranslateXUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        view.setTranslationX((float) NativeViewUpdateService.g(doubleValue, iDeviceResolutionTranslator));
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static final class TranslateYUpdater implements INativeViewUpdater {
        private TranslateYUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull final View view, @NonNull String str, @NonNull Object obj, @NonNull final PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
            if (obj instanceof Double) {
                final double doubleValue = ((Double) obj).doubleValue();
                NativeViewUpdateService.h(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService.TranslateYUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        view.setTranslationY((float) NativeViewUpdateService.g(doubleValue, iDeviceResolutionTranslator));
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static final class b implements INativeViewUpdater {
        private b() {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
        public void update(@NonNull View view, @NonNull String str, @NonNull Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("opacity", new OpacityUpdater());
        hashMap.put("transform.translate", new TranslateUpdater());
        hashMap.put("transform.translateX", new TranslateXUpdater());
        hashMap.put("transform.translateY", new TranslateYUpdater());
        hashMap.put("transform.scale", new ScaleUpdater());
        hashMap.put("transform.scaleX", new ScaleXUpdater());
        hashMap.put("transform.scaleY", new ScaleYUpdater());
        hashMap.put("transform.rotate", new RotateUpdater());
        hashMap.put("transform.rotateZ", new RotateUpdater());
        hashMap.put("transform.rotateX", new RotateXUpdater());
        hashMap.put("transform.rotateY", new RotateYUpdater());
        hashMap.put("background-color", new BackgroundUpdater());
        hashMap.put("color", new ColorUpdater());
        hashMap.put("scroll.contentOffsetX", new ContentOffsetXUpdater());
        hashMap.put("scroll.contentOffsetY", new ContentOffsetYUpdater());
    }

    public static void d() {
        e.removeCallbacksAndMessages(null);
    }

    @NonNull
    public static INativeViewUpdater e(@NonNull String str) {
        INativeViewUpdater iNativeViewUpdater = a.get(str);
        if (iNativeViewUpdater != null) {
            return iNativeViewUpdater;
        }
        if (d.contains(str)) {
            LayoutUpdater layoutUpdater = b;
            layoutUpdater.a(str);
            return layoutUpdater;
        }
        bb1.b("unknown property [" + str + jn1.ARRAY_END_STR);
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(Map<String, Object> map, String str) {
        Object obj;
        if (map == null || TextUtils.isEmpty(str) || (obj = map.get(str)) == null) {
            return 0;
        }
        if (obj instanceof String) {
            return Integer.parseInt((String) obj);
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double g(double d2, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator) {
        return iDeviceResolutionTranslator.webToNative(d2, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            e.post(new WeakRunnable(runnable));
        }
    }
}
