package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.parser.s;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tb.am2;
import tb.ap0;
import tb.eg1;
import tb.f81;
import tb.h11;
import tb.hd1;
import tb.ic1;
import tb.kb1;
import tb.lc1;
import tb.s71;
import tb.zo0;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LottieDrawable extends Drawable implements Animatable, Drawable.Callback {
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private int alpha;
    private final LottieValueAnimator animator;
    private com.airbnb.lottie.a composition;
    @Nullable
    private com.airbnb.lottie.model.layer.b compositionLayer;
    private boolean enableMergePaths;
    @Nullable
    zo0 fontAssetDelegate;
    @Nullable
    private ap0 fontAssetManager;
    private boolean ignoreSystemAnimationsDisabled;
    @Nullable
    private ImageAssetDelegate imageAssetDelegate;
    @Nullable
    private h11 imageAssetManager;
    @Nullable
    private h11 imageAssetManagerOverride;
    @Nullable
    private String imageAssetsFolder;
    private boolean isApplyingOpacityToLayersEnabled;
    private boolean isDirty;
    private boolean isExtraScaleEnabled;
    private final ArrayList<LazyCompositionTask> lazyCompositionTasks;
    private final Matrix matrix = new Matrix();
    private boolean outlineMasksAndMattes;
    private boolean performanceTrackingEnabled;
    private final ValueAnimator.AnimatorUpdateListener progressUpdateListener;
    private boolean safeMode;
    private float scale;
    private boolean systemAnimationsEnabled;
    @Nullable
    am2 textDelegate;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface LazyCompositionTask {
        void run(com.airbnb.lottie.a aVar);
    }

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RepeatMode {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class a implements LazyCompositionTask {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(com.airbnb.lottie.a aVar) {
            LottieDrawable.this.setMinAndMaxFrame(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class b implements LazyCompositionTask {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;

        b(String str, String str2, boolean z) {
            this.a = str;
            this.b = str2;
            this.c = z;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(com.airbnb.lottie.a aVar) {
            LottieDrawable.this.setMinAndMaxFrame(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class c implements LazyCompositionTask {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        c(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(com.airbnb.lottie.a aVar) {
            LottieDrawable.this.setMinAndMaxFrame(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class d implements LazyCompositionTask {
        final /* synthetic */ float a;
        final /* synthetic */ float b;

        d(float f, float f2) {
            this.a = f;
            this.b = f2;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(com.airbnb.lottie.a aVar) {
            LottieDrawable.this.setMinAndMaxProgress(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class e implements LazyCompositionTask {
        final /* synthetic */ int a;

        e(int i) {
            this.a = i;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(com.airbnb.lottie.a aVar) {
            LottieDrawable.this.setFrame(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class f implements LazyCompositionTask {
        final /* synthetic */ float a;

        f(float f) {
            this.a = f;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(com.airbnb.lottie.a aVar) {
            LottieDrawable.this.setProgress(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class g implements LazyCompositionTask {
        final /* synthetic */ s71 a;
        final /* synthetic */ Object b;
        final /* synthetic */ lc1 c;

        g(s71 s71Var, Object obj, lc1 lc1Var) {
            this.a = s71Var;
            this.b = obj;
            this.c = lc1Var;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(com.airbnb.lottie.a aVar) {
            LottieDrawable.this.addValueCallback(this.a, (s71) this.b, (lc1<s71>) this.c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    class h<T> extends lc1<T> {
        final /* synthetic */ SimpleLottieValueCallback c;

        h(LottieDrawable lottieDrawable, SimpleLottieValueCallback simpleLottieValueCallback) {
            this.c = simpleLottieValueCallback;
        }

        @Override // tb.lc1
        public T a(ic1<T> ic1Var) {
            return (T) this.c.getValue(ic1Var);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (LottieDrawable.this.compositionLayer != null) {
                LottieDrawable.this.compositionLayer.B(LottieDrawable.this.animator.getAnimatedValueAbsolute());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class j implements LazyCompositionTask {
        j() {
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(com.airbnb.lottie.a aVar) {
            LottieDrawable.this.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class k implements LazyCompositionTask {
        k() {
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(com.airbnb.lottie.a aVar) {
            LottieDrawable.this.resumeAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class l implements LazyCompositionTask {
        final /* synthetic */ int a;

        l(int i) {
            this.a = i;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(com.airbnb.lottie.a aVar) {
            LottieDrawable.this.setMinFrame(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class m implements LazyCompositionTask {
        final /* synthetic */ float a;

        m(float f) {
            this.a = f;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(com.airbnb.lottie.a aVar) {
            LottieDrawable.this.setMinProgress(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class n implements LazyCompositionTask {
        final /* synthetic */ int a;

        n(int i) {
            this.a = i;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(com.airbnb.lottie.a aVar) {
            LottieDrawable.this.setMaxFrame(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class o implements LazyCompositionTask {
        final /* synthetic */ float a;

        o(float f) {
            this.a = f;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(com.airbnb.lottie.a aVar) {
            LottieDrawable.this.setMaxProgress(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class p implements LazyCompositionTask {
        final /* synthetic */ String a;

        p(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(com.airbnb.lottie.a aVar) {
            LottieDrawable.this.setMinFrame(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class q implements LazyCompositionTask {
        final /* synthetic */ String a;

        q(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(com.airbnb.lottie.a aVar) {
            LottieDrawable.this.setMaxFrame(this.a);
        }
    }

    public LottieDrawable() {
        LottieValueAnimator lottieValueAnimator = new LottieValueAnimator();
        this.animator = lottieValueAnimator;
        this.scale = 1.0f;
        this.systemAnimationsEnabled = true;
        this.ignoreSystemAnimationsDisabled = false;
        this.safeMode = false;
        this.lazyCompositionTasks = new ArrayList<>();
        i iVar = new i();
        this.progressUpdateListener = iVar;
        this.alpha = 255;
        this.isExtraScaleEnabled = true;
        this.isDirty = false;
        lottieValueAnimator.addUpdateListener(iVar);
    }

    private boolean animationsEnabled() {
        return this.systemAnimationsEnabled || this.ignoreSystemAnimationsDisabled;
    }

    private float aspectRatio(Rect rect) {
        return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect);
    }

    private boolean boundsMatchesCompositionAspectRatio() {
        com.airbnb.lottie.a aVar = this.composition;
        return aVar == null || getBounds().isEmpty() || aspectRatio(getBounds()) == aspectRatio(aVar.b());
    }

    private void buildCompositionLayer() {
        com.airbnb.lottie.model.layer.b bVar = new com.airbnb.lottie.model.layer.b(this, s.a(this.composition), this.composition.j(), this.composition);
        this.compositionLayer = bVar;
        if (this.outlineMasksAndMattes) {
            bVar.z(true);
        }
    }

    private void drawInternal(@NonNull Canvas canvas) {
        if (!boundsMatchesCompositionAspectRatio()) {
            drawWithNewAspectRatio(canvas);
        } else {
            drawWithOriginalAspectRatio(canvas);
        }
    }

    private void drawWithNewAspectRatio(Canvas canvas) {
        float f2;
        if (this.compositionLayer == null) {
            return;
        }
        int i2 = -1;
        Rect bounds = getBounds();
        float width = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds) / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.composition.b());
        float height = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds) / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.composition.b());
        if (this.isExtraScaleEnabled) {
            float min = Math.min(width, height);
            if (min < 1.0f) {
                f2 = 1.0f / min;
                width /= f2;
                height /= f2;
            } else {
                f2 = 1.0f;
            }
            if (f2 > 1.0f) {
                i2 = canvas.save();
                float width2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds) / 2.0f;
                float height2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds) / 2.0f;
                float f3 = width2 * min;
                float f4 = min * height2;
                canvas.translate(width2 - f3, height2 - f4);
                canvas.scale(f2, f2, f3, f4);
            }
        }
        this.matrix.reset();
        this.matrix.preScale(width, height);
        this.compositionLayer.draw(canvas, this.matrix, this.alpha);
        if (i2 > 0) {
            canvas.restoreToCount(i2);
        }
    }

    private void drawWithOriginalAspectRatio(Canvas canvas) {
        float f2;
        if (this.compositionLayer == null) {
            return;
        }
        float f3 = this.scale;
        float maxScale = getMaxScale(canvas);
        if (f3 > maxScale) {
            f2 = this.scale / maxScale;
        } else {
            maxScale = f3;
            f2 = 1.0f;
        }
        int i2 = -1;
        if (f2 > 1.0f) {
            i2 = canvas.save();
            float width = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.composition.b()) / 2.0f;
            float height = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.composition.b()) / 2.0f;
            float f4 = width * maxScale;
            float f5 = height * maxScale;
            canvas.translate((getScale() * width) - f4, (getScale() * height) - f5);
            canvas.scale(f2, f2, f4, f5);
        }
        this.matrix.reset();
        this.matrix.preScale(maxScale, maxScale);
        this.compositionLayer.draw(canvas, this.matrix, this.alpha);
        if (i2 > 0) {
            canvas.restoreToCount(i2);
        }
    }

    @Nullable
    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private ap0 getFontAssetManager() {
        if (getCallback() == null) {
            return null;
        }
        if (this.fontAssetManager == null) {
            this.fontAssetManager = new ap0(getCallback(), this.fontAssetDelegate);
        }
        return this.fontAssetManager;
    }

    private h11 getImageAssetManager() {
        h11 h11Var = this.imageAssetManagerOverride;
        if (h11Var != null) {
            return h11Var;
        }
        if (getCallback() == null) {
            return null;
        }
        h11 h11Var2 = this.imageAssetManager;
        if (h11Var2 != null && !h11Var2.b(getContext())) {
            this.imageAssetManager = null;
        }
        if (this.imageAssetManager == null) {
            this.imageAssetManager = new h11(getCallback(), this.imageAssetsFolder, this.imageAssetDelegate, this.composition.i());
        }
        return this.imageAssetManager;
    }

    private float getMaxScale(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.composition.b()), canvas.getHeight() / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.composition.b()));
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.animator.addListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.animator.addPauseListener(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.animator.addUpdateListener(animatorUpdateListener);
    }

    public <T> void addValueCallback(s71 s71Var, T t, lc1<T> lc1Var) {
        com.airbnb.lottie.model.layer.b bVar = this.compositionLayer;
        if (bVar == null) {
            this.lazyCompositionTasks.add(new g(s71Var, t, lc1Var));
            return;
        }
        boolean z = true;
        if (s71Var == s71.COMPOSITION) {
            bVar.addValueCallback(t, lc1Var);
        } else if (s71Var.d() != null) {
            s71Var.d().addValueCallback(t, lc1Var);
        } else {
            List<s71> resolveKeyPath = resolveKeyPath(s71Var);
            for (int i2 = 0; i2 < resolveKeyPath.size(); i2++) {
                resolveKeyPath.get(i2).d().addValueCallback(t, lc1Var);
            }
            z = true ^ resolveKeyPath.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t == LottieProperty.TIME_REMAP) {
                setProgress(getProgress());
            }
        }
    }

    public void cancelAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.cancel();
    }

    public void clearComposition() {
        if (this.animator.isRunning()) {
            this.animator.cancel();
        }
        this.composition = null;
        this.compositionLayer = null;
        this.imageAssetManager = null;
        this.animator.clearComposition();
        invalidateSelf();
    }

    public void disableExtraScaleModeInFitXY() {
        this.isExtraScaleEnabled = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.isDirty = false;
        f81.a("Drawable#draw");
        if (this.safeMode) {
            try {
                drawInternal(canvas);
            } catch (Throwable th) {
                kb1.b("Lottie crashed in draw!", th);
            }
        } else {
            drawInternal(canvas);
        }
        f81.b("Drawable#draw");
    }

    public boolean enableMergePathsForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    @MainThread
    public void endAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.endAnimation();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    public com.airbnb.lottie.a getComposition() {
        return this.composition;
    }

    public int getFrame() {
        return (int) this.animator.getFrame();
    }

    @Nullable
    public Bitmap getImageAsset(String str) {
        h11 imageAssetManager = getImageAssetManager();
        if (imageAssetManager != null) {
            return imageAssetManager.a(str);
        }
        return null;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.imageAssetsFolder;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        com.airbnb.lottie.a aVar = this.composition;
        if (aVar == null) {
            return -1;
        }
        return (int) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(aVar.b()) * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        com.airbnb.lottie.a aVar = this.composition;
        if (aVar == null) {
            return -1;
        }
        return (int) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(aVar.b()) * getScale());
    }

    public float getMaxFrame() {
        return this.animator.getMaxFrame();
    }

    public float getMinFrame() {
        return this.animator.getMinFrame();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Nullable
    public PerformanceTracker getPerformanceTracker() {
        com.airbnb.lottie.a aVar = this.composition;
        if (aVar != null) {
            return aVar.m();
        }
        return null;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.animator.getAnimatedValueAbsolute();
    }

    public int getRepeatCount() {
        return this.animator.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.animator.getRepeatMode();
    }

    public float getScale() {
        return this.scale;
    }

    public float getSpeed() {
        return this.animator.getSpeed();
    }

    @Nullable
    public am2 getTextDelegate() {
        return this.textDelegate;
    }

    @Nullable
    public Typeface getTypeface(String str, String str2) {
        ap0 fontAssetManager = getFontAssetManager();
        if (fontAssetManager != null) {
            return fontAssetManager.b(str, str2);
        }
        return null;
    }

    public boolean hasMasks() {
        com.airbnb.lottie.model.layer.b bVar = this.compositionLayer;
        return bVar != null && bVar.E();
    }

    public boolean hasMatte() {
        com.airbnb.lottie.model.layer.b bVar = this.compositionLayer;
        return bVar != null && bVar.F();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.isDirty) {
            return;
        }
        this.isDirty = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isAnimating() {
        LottieValueAnimator lottieValueAnimator = this.animator;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.isRunning();
    }

    public boolean isApplyingOpacityToLayersEnabled() {
        return this.isApplyingOpacityToLayersEnabled;
    }

    public boolean isLooping() {
        return this.animator.getRepeatCount() == -1;
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return isAnimating();
    }

    @Deprecated
    public void loop(boolean z) {
        this.animator.setRepeatCount(z ? -1 : 0);
    }

    public void pauseAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.pauseAnimation();
    }

    @MainThread
    public void playAnimation() {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new j());
            return;
        }
        if (animationsEnabled() || getRepeatCount() == 0) {
            this.animator.playAnimation();
        }
        if (animationsEnabled()) {
            return;
        }
        setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
        this.animator.endAnimation();
    }

    public void removeAllAnimatorListeners() {
        this.animator.removeAllListeners();
    }

    public void removeAllUpdateListeners() {
        this.animator.removeAllUpdateListeners();
        this.animator.addUpdateListener(this.progressUpdateListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.animator.removeListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.animator.removePauseListener(animatorPauseListener);
    }

    public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.animator.removeUpdateListener(animatorUpdateListener);
    }

    public List<s71> resolveKeyPath(s71 s71Var) {
        if (this.compositionLayer == null) {
            kb1.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.compositionLayer.resolveKeyPath(s71Var, 0, arrayList, new s71(new String[0]));
        return arrayList;
    }

    @MainThread
    public void resumeAnimation() {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new k());
            return;
        }
        if (animationsEnabled() || getRepeatCount() == 0) {
            this.animator.resumeAnimation();
        }
        if (animationsEnabled()) {
            return;
        }
        setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
        this.animator.endAnimation();
    }

    public void reverseAnimationSpeed() {
        this.animator.reverseAnimationSpeed();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.alpha = i2;
        invalidateSelf();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.isApplyingOpacityToLayersEnabled = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        kb1.c("Use addColorFilter instead.");
    }

    public boolean setComposition(com.airbnb.lottie.a aVar) {
        if (this.composition == aVar) {
            return false;
        }
        this.isDirty = false;
        clearComposition();
        this.composition = aVar;
        buildCompositionLayer();
        this.animator.setComposition(aVar);
        setProgress(this.animator.getAnimatedFraction());
        setScale(this.scale);
        Iterator it = new ArrayList(this.lazyCompositionTasks).iterator();
        while (it.hasNext()) {
            LazyCompositionTask lazyCompositionTask = (LazyCompositionTask) it.next();
            if (lazyCompositionTask != null) {
                lazyCompositionTask.run(aVar);
            }
            it.remove();
        }
        this.lazyCompositionTasks.clear();
        aVar.u(this.performanceTrackingEnabled);
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
            return true;
        }
        return true;
    }

    public void setFontAssetDelegate(zo0 zo0Var) {
        ap0 ap0Var = this.fontAssetManager;
        if (ap0Var != null) {
            ap0Var.c(zo0Var);
        }
    }

    public void setFrame(int i2) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new e(i2));
        } else {
            this.animator.setFrame(i2);
        }
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.ignoreSystemAnimationsDisabled = z;
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.imageAssetDelegate = imageAssetDelegate;
        h11 h11Var = this.imageAssetManager;
        if (h11Var != null) {
            h11Var.d(imageAssetDelegate);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    void setImageAssetManager(@Nullable h11 h11Var) {
        this.imageAssetManagerOverride = h11Var;
    }

    public void setImagesAssetsFolder(@Nullable String str) {
        this.imageAssetsFolder = str;
    }

    public void setMaxFrame(int i2) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new n(i2));
        } else {
            this.animator.setMaxFrame(i2 + 0.99f);
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        com.airbnb.lottie.a aVar = this.composition;
        if (aVar == null) {
            this.lazyCompositionTasks.add(new o(f2));
        } else {
            setMaxFrame((int) eg1.k(aVar.o(), this.composition.f(), f2));
        }
    }

    public void setMinAndMaxFrame(String str) {
        com.airbnb.lottie.a aVar = this.composition;
        if (aVar == null) {
            this.lazyCompositionTasks.add(new a(str));
            return;
        }
        hd1 k2 = aVar.k(str);
        if (k2 != null) {
            int i2 = (int) k2.b;
            setMinAndMaxFrame(i2, ((int) k2.c) + i2);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        com.airbnb.lottie.a aVar = this.composition;
        if (aVar == null) {
            this.lazyCompositionTasks.add(new d(f2, f3));
        } else {
            setMinAndMaxFrame((int) eg1.k(aVar.o(), this.composition.f(), f2), (int) eg1.k(this.composition.o(), this.composition.f(), f3));
        }
    }

    public void setMinFrame(int i2) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new l(i2));
        } else {
            this.animator.setMinFrame(i2);
        }
    }

    public void setMinProgress(float f2) {
        com.airbnb.lottie.a aVar = this.composition;
        if (aVar == null) {
            this.lazyCompositionTasks.add(new m(f2));
        } else {
            setMinFrame((int) eg1.k(aVar.o(), this.composition.f(), f2));
        }
    }

    public void setOutlineMasksAndMattes(boolean z) {
        if (this.outlineMasksAndMattes == z) {
            return;
        }
        this.outlineMasksAndMattes = z;
        com.airbnb.lottie.model.layer.b bVar = this.compositionLayer;
        if (bVar != null) {
            bVar.z(z);
        }
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.performanceTrackingEnabled = z;
        com.airbnb.lottie.a aVar = this.composition;
        if (aVar != null) {
            aVar.u(z);
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new f(f2));
            return;
        }
        f81.a("Drawable#setProgress");
        this.animator.setFrame(eg1.k(this.composition.o(), this.composition.f(), f2));
        f81.b("Drawable#setProgress");
    }

    public void setRepeatCount(int i2) {
        this.animator.setRepeatCount(i2);
    }

    public void setRepeatMode(int i2) {
        this.animator.setRepeatMode(i2);
    }

    public void setSafeMode(boolean z) {
        this.safeMode = z;
    }

    public void setScale(float f2) {
        this.scale = f2;
    }

    public void setSpeed(float f2) {
        this.animator.setSpeed(f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSystemAnimationsAreEnabled(Boolean bool) {
        this.systemAnimationsEnabled = bool.booleanValue();
    }

    public void setTextDelegate(am2 am2Var) {
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View) || ((View) callback).isInEditMode()) {
            return;
        }
        playAnimation();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        endAnimation();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        h11 imageAssetManager = getImageAssetManager();
        if (imageAssetManager == null) {
            kb1.c("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap e2 = imageAssetManager.e(str, bitmap);
        invalidateSelf();
        return e2;
    }

    public boolean useTextGlyphs() {
        return this.composition.c().size() > 0;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.enableMergePaths == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            kb1.c("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.enableMergePaths = z;
        if (this.composition != null) {
            buildCompositionLayer();
        }
    }

    public void setMaxFrame(String str) {
        com.airbnb.lottie.a aVar = this.composition;
        if (aVar == null) {
            this.lazyCompositionTasks.add(new q(str));
            return;
        }
        hd1 k2 = aVar.k(str);
        if (k2 != null) {
            setMaxFrame((int) (k2.b + k2.c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void setMinFrame(String str) {
        com.airbnb.lottie.a aVar = this.composition;
        if (aVar == null) {
            this.lazyCompositionTasks.add(new p(str));
            return;
        }
        hd1 k2 = aVar.k(str);
        if (k2 != null) {
            setMinFrame((int) k2.b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z) {
        com.airbnb.lottie.a aVar = this.composition;
        if (aVar == null) {
            this.lazyCompositionTasks.add(new b(str, str2, z));
            return;
        }
        hd1 k2 = aVar.k(str);
        if (k2 != null) {
            int i2 = (int) k2.b;
            hd1 k3 = this.composition.k(str2);
            if (k3 != null) {
                setMinAndMaxFrame(i2, (int) (k3.b + (z ? 1.0f : 0.0f)));
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public <T> void addValueCallback(s71 s71Var, T t, SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        addValueCallback(s71Var, (s71) t, (lc1<s71>) new h(this, simpleLottieValueCallback));
    }

    public void setMinAndMaxFrame(int i2, int i3) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new c(i2, i3));
        } else {
            this.animator.setMinAndMaxFrames(i2, i3 + 0.99f);
        }
    }
}
