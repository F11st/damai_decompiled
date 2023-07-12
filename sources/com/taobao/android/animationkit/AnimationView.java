package com.taobao.android.animationkit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.CheckResult;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.ImageAssetDelegate;
import com.taobao.orange.OrangeConfig;
import com.taobao.weex.common.Constants;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jc1;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class AnimationView extends FrameLayout {
    public static final int ANIM_KEY_DECISION_SLICE = 1;
    public static final int ANIM_KEY_FRAMEWORK_SLICE = 2;
    private static final int ANIM_KEY_UNKNOW = 0;
    public static final int ANIM_KEY_VOICE_THINKING = 3;
    private static final String TAG = "AnimationView";
    private JSONObject animationJson;
    private String animationName;
    private boolean autoPlay;
    private final Map<String, Bitmap> bitmapCache;
    private BitmapFetcher bitmapFetcher;
    private String lastAnimResFolder;
    private boolean loop;
    private long loopDelay;
    private LoopRunnable loopRunnable;
    private GuardedLottieAnimationView lottieAnimationView;
    private boolean pausedOrCanceled;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public @interface AnimationKey {
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface BitmapFetcher {
        Bitmap fetchBitmap(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static class LoopRunnable implements Runnable {
        WeakReference<AnimationView> ref;

        public LoopRunnable(AnimationView animationView) {
            this.ref = null;
            this.ref = new WeakReference<>(animationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AnimationView animationView = this.ref.get();
            if (animationView != null) {
                animationView.playAnimationWithoutCheck();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.animationkit.AnimationView$a */
    /* loaded from: classes4.dex */
    public class C6307a implements ImageAssetDelegate {
        C6307a() {
        }

        @Override // com.airbnb.lottie.ImageAssetDelegate
        public Bitmap fetchBitmap(jc1 jc1Var) {
            return AnimationView.this.bitmapFetcher.fetchBitmap(jc1Var.b());
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.animationkit.AnimationView$b */
    /* loaded from: classes4.dex */
    class C6308b implements FileFilter {
        C6308b(AnimationView animationView) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().endsWith(".json");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.animationkit.AnimationView$c */
    /* loaded from: classes4.dex */
    class C6309c implements BitmapFetcher {
        C6309c() {
        }

        @Override // com.taobao.android.animationkit.AnimationView.BitmapFetcher
        public Bitmap fetchBitmap(String str) {
            return (Bitmap) AnimationView.this.bitmapCache.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.animationkit.AnimationView$d */
    /* loaded from: classes4.dex */
    public static class C6310d extends AnimatorListenerAdapter {
        WeakReference<AnimationView> a;

        public C6310d(AnimationView animationView) {
            this.a = null;
            this.a = new WeakReference<>(animationView);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            AnimationView animationView = this.a.get();
            if (animationView != null) {
                animationView.pausedOrCanceled = true;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AnimationView animationView = this.a.get();
            if (animationView != null) {
                animationView.onLottieAnimationEnd();
            }
        }
    }

    public AnimationView(Context context) {
        this(context, null);
    }

    private boolean checkAnimationEnable(String str) {
        String str2;
        try {
            str2 = OrangeConfig.getInstance().getConfig("animation_kit_switch", str, "true");
        } catch (Exception e) {
            e.printStackTrace();
            str2 = "true";
        }
        boolean equals = "true".equals(str2);
        if (equals) {
            setVisibility(0);
            this.lottieAnimationView.setVisibility(0);
        } else {
            setVisibility(8);
            this.lottieAnimationView.setVisibility(8);
        }
        return equals;
    }

    private void init(AttributeSet attributeSet) {
        GuardedLottieAnimationView guardedLottieAnimationView = new GuardedLottieAnimationView(getContext());
        this.lottieAnimationView = guardedLottieAnimationView;
        addView(guardedLottieAnimationView);
        this.loopRunnable = new LoopRunnable(this);
        this.lottieAnimationView.addAnimatorListener(new C6310d(this));
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.AnimationView);
        loop(obtainStyledAttributes.getBoolean(R$styleable.AnimationView_ak_loop, false));
        setupAnimKey(obtainStyledAttributes.getInt(R$styleable.AnimationView_ak_animKey, 0));
        String string = obtainStyledAttributes.getString(R$styleable.AnimationView_ak_jsonFilePath);
        String string2 = obtainStyledAttributes.getString(R$styleable.AnimationView_ak_imageAssetsFolder);
        if (!TextUtils.isEmpty(string)) {
            setAnimation(string);
        }
        if (!TextUtils.isEmpty(string2)) {
            setImageAssetsFolder(string2);
        }
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.AnimationView_ak_autoPlay, true);
        this.autoPlay = z;
        if (z) {
            setupAutoPlay();
            playAnimation();
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLottieAnimationEnd() {
        if (!this.loop || this.pausedOrCanceled) {
            return;
        }
        postDelayed(this.loopRunnable, this.loopDelay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAnimationWithoutCheck() {
        this.lottieAnimationView.playAnimation();
        this.pausedOrCanceled = false;
    }

    private void resumeReverseAnimation() {
        this.pausedOrCanceled = false;
    }

    private void setupAnimKey(@AnimationKey int i) {
        if (i == 1) {
            if (checkAnimationEnable("decision_slice")) {
                setAnimation("decision_slice/decision_slice.json");
                setImageAssetsFolder("decision_slice/images");
                this.animationName = "decision_slice";
            }
        } else if (i != 2) {
            if (i == 3 && checkAnimationEnable("voice_thinking")) {
                setAnimation("voice_thinking/voice_thinking.json");
                setImageAssetsFolder("voice_thinking/images");
                this.animationName = "voice_thinking";
            }
        } else if (checkAnimationEnable("framework_slice")) {
            setAnimation("framework_slice/framework_slice.json");
            setImageAssetsFolder("framework_slice/images");
            this.animationName = "framework_slice";
        }
    }

    private void setupAutoPlay() {
        try {
            Field declaredField = this.lottieAnimationView.getClass().getDeclaredField(Constants.Name.AUTO_PLAY);
            declaredField.setAccessible(true);
            declaredField.set(this.lottieAnimationView, Boolean.valueOf(this.autoPlay));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieAnimationView.addAnimatorListener(animatorListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieAnimationView.addAnimatorUpdateListener(animatorUpdateListener);
    }

    public void cancelAnimation() {
        this.lottieAnimationView.cancelAnimation();
        this.pausedOrCanceled = true;
    }

    public long getDuration() {
        return this.lottieAnimationView.getDuration();
    }

    public float getProgress() {
        return this.lottieAnimationView.getProgress();
    }

    public boolean isAnimating() {
        return this.lottieAnimationView.isAnimating();
    }

    public void loop(boolean z) {
        this.loop = z;
    }

    public void pauseAnimation() {
        this.pausedOrCanceled = true;
        this.lottieAnimationView.pauseAnimation();
    }

    public void playAnimation() {
        if (!TextUtils.isEmpty(this.animationName)) {
            if (checkAnimationEnable(this.animationName)) {
                this.lottieAnimationView.playAnimation();
                this.pausedOrCanceled = false;
            }
        } else if (this.animationJson != null) {
            this.lottieAnimationView.playAnimation();
            this.pausedOrCanceled = false;
        }
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieAnimationView.removeAnimatorListener(animatorListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieAnimationView.removeUpdateListener(animatorUpdateListener);
    }

    public void resumeAnimation() {
        this.lottieAnimationView.resumeAnimation();
        this.pausedOrCanceled = false;
    }

    public void reverseAnimation() {
    }

    @CheckResult
    public boolean setAnimResFolder(String str) {
        File[] listFiles;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(this.lastAnimResFolder)) {
                return true;
            }
            String str2 = File.separator;
            if (str.endsWith(str2)) {
                File file = new File(str);
                if (file.isDirectory()) {
                    File[] listFiles2 = file.listFiles(new C6308b(this));
                    if (listFiles2.length > 0) {
                        FileInputStream fileInputStream = null;
                        try {
                            try {
                                try {
                                    FileInputStream fileInputStream2 = new FileInputStream(listFiles2[0]);
                                    try {
                                        byte[] bArr = new byte[fileInputStream2.available()];
                                        fileInputStream2.read(bArr);
                                        JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                                        String str3 = str + "images" + str2;
                                        File file2 = new File(str3);
                                        if (file2.exists() && file2.isDirectory()) {
                                            this.bitmapCache.clear();
                                            for (File file3 : new File(str3).listFiles()) {
                                                this.bitmapCache.put(file3.getName(), BitmapFactory.decodeFile(file3.getPath()));
                                            }
                                            setBitmapFetcher(new C6309c());
                                        }
                                        setAnimation(jSONObject);
                                        this.lastAnimResFolder = str;
                                        try {
                                            fileInputStream2.close();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        return true;
                                    } catch (FileNotFoundException e2) {
                                        e = e2;
                                        fileInputStream = fileInputStream2;
                                        e.printStackTrace();
                                        if (fileInputStream != null) {
                                            fileInputStream.close();
                                        }
                                        return false;
                                    } catch (UnsupportedEncodingException e3) {
                                        e = e3;
                                        fileInputStream = fileInputStream2;
                                        e.printStackTrace();
                                        if (fileInputStream != null) {
                                            fileInputStream.close();
                                        }
                                        return false;
                                    } catch (IOException e4) {
                                        e = e4;
                                        fileInputStream = fileInputStream2;
                                        e.printStackTrace();
                                        if (fileInputStream != null) {
                                            fileInputStream.close();
                                        }
                                        return false;
                                    } catch (JSONException e5) {
                                        e = e5;
                                        fileInputStream = fileInputStream2;
                                        e.printStackTrace();
                                        if (fileInputStream != null) {
                                            fileInputStream.close();
                                        }
                                        return false;
                                    } catch (Throwable th) {
                                        th = th;
                                        fileInputStream = fileInputStream2;
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (IOException e6) {
                                                e6.printStackTrace();
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (FileNotFoundException e7) {
                                    e = e7;
                                } catch (UnsupportedEncodingException e8) {
                                    e = e8;
                                } catch (IOException e9) {
                                    e = e9;
                                } catch (JSONException e10) {
                                    e = e10;
                                }
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void setAnimation(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.animationName = str;
        this.lottieAnimationView.setAnimation(str);
    }

    public void setAnimationKey(@AnimationKey int i) {
        setupAnimKey(i);
    }

    public void setAutoPlay(boolean z) {
        this.autoPlay = z;
        setupAutoPlay();
    }

    public void setBitmapFetcher(BitmapFetcher bitmapFetcher) {
        this.bitmapFetcher = bitmapFetcher;
        if (bitmapFetcher == null) {
            this.lottieAnimationView.setImageAssetDelegate(null);
        } else {
            this.lottieAnimationView.setImageAssetDelegate(new C6307a());
        }
    }

    public void setHardwareEnable(boolean z) {
        if (this.lottieAnimationView.isHardwareAccelerated() && z) {
            this.lottieAnimationView.setLayerType(2, null);
        } else {
            this.lottieAnimationView.setLayerType(1, null);
        }
    }

    public void setImageAssetsFolder(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.lottieAnimationView.setImageAssetsFolder(str);
    }

    public void setLoopDelay(long j) {
        if (j < 0) {
            j = 0;
        }
        this.loopDelay = j;
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.lottieAnimationView.setProgress(f);
    }

    public AnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.autoPlay = true;
        this.animationName = "";
        this.animationJson = null;
        this.pausedOrCanceled = false;
        this.bitmapCache = new HashMap();
        this.loopDelay = 0L;
        init(attributeSet);
    }

    public void setAnimation(JSONObject jSONObject) {
        this.animationJson = jSONObject;
        this.lottieAnimationView.setAnimation(jSONObject);
    }
}
