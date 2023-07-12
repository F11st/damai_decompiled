package com.youku.live.dago.widgetlib.interactive.gift.view.Particle;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers.AccelerationInitializer;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers.ParticleInitializer;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers.RotationInitializer;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers.RotationSpeedInitializer;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers.ScaleInitializer;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers.SpeedModuleAndRangeInitializer;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers.SpeeddByComponentsInitializer;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.modifiers.AlphaModifier;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.modifiers.ParticleModifier;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ParticleSystem {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static long TIMER_TASK_INTERVAL = 33;
    private int mActivatedParticles;
    private final ArrayList<C7945Particle> mActiveParticles;
    private ValueAnimator mAnimator;
    private long mCurrentTime;
    private float mDpToPxScale;
    private ParticleField mDrawingView;
    private int mEmitterXMax;
    private int mEmitterXMin;
    private int mEmitterYMax;
    private int mEmitterYMin;
    private long mEmittingTime;
    private List<ParticleInitializer> mInitializers;
    private int mMaxParticles;
    private List<ParticleModifier> mModifiers;
    private int[] mParentLocation;
    private ViewGroup mParentView;
    private ArrayList<C7945Particle> mParticles;
    private float mParticlesPerMillisecond;
    private Random mRandom;
    private long mTimeToLive;
    private Timer mTimer;
    private final ParticleTimerTask mTimerTask;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class ParticleTimerTask extends TimerTask {
        private static transient /* synthetic */ IpChange $ipChange;
        private final WeakReference<ParticleSystem> mPs;

        public ParticleTimerTask(ParticleSystem particleSystem) {
            this.mPs = new WeakReference<>(particleSystem);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1962205115")) {
                ipChange.ipc$dispatch("-1962205115", new Object[]{this});
            } else if (this.mPs.get() != null) {
                ParticleSystem particleSystem = this.mPs.get();
                particleSystem.onUpdate(particleSystem.mCurrentTime);
                particleSystem.mCurrentTime += ParticleSystem.TIMER_TASK_INTERVAL;
            }
        }
    }

    private ParticleSystem(ViewGroup viewGroup, int i, long j) {
        this.mActiveParticles = new ArrayList<>();
        this.mCurrentTime = 0L;
        this.mTimerTask = new ParticleTimerTask(this);
        this.mRandom = new Random();
        this.mParentLocation = new int[2];
        setParentViewGroup(viewGroup);
        this.mModifiers = new ArrayList();
        this.mInitializers = new ArrayList();
        this.mMaxParticles = i;
        this.mParticles = new ArrayList<>();
        this.mTimeToLive = j;
        this.mDpToPxScale = viewGroup.getContext().getResources().getDisplayMetrics().xdpi / 160.0f;
    }

    private void activateParticle(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-584135037")) {
            ipChange.ipc$dispatch("-584135037", new Object[]{this, Long.valueOf(j)});
            return;
        }
        C7945Particle remove = this.mParticles.remove(0);
        remove.init();
        for (int i = 0; i < this.mInitializers.size(); i++) {
            this.mInitializers.get(i).initParticle(remove, this.mRandom);
        }
        remove.configure(this.mTimeToLive, getFromRange(this.mEmitterXMin, this.mEmitterXMax), getFromRange(this.mEmitterYMin, this.mEmitterYMax));
        remove.activate(j, this.mModifiers);
        this.mActiveParticles.add(remove);
        this.mActivatedParticles++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanupAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1838679642")) {
            ipChange.ipc$dispatch("1838679642", new Object[]{this});
            return;
        }
        this.mParentView.removeView(this.mDrawingView);
        this.mDrawingView = null;
        this.mParentView.postInvalidate();
        this.mParticles.addAll(this.mActiveParticles);
    }

    private void configureEmitter(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-618474286")) {
            ipChange.ipc$dispatch("-618474286", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int[] iArr = this.mParentLocation;
        int i3 = i - iArr[0];
        this.mEmitterXMin = i3;
        this.mEmitterXMax = i3;
        int i4 = i2 - iArr[1];
        this.mEmitterYMin = i4;
        this.mEmitterYMax = i4;
    }

    private int getFromRange(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2048983312")) {
            return ((Integer) ipChange.ipc$dispatch("2048983312", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }
        if (i == i2) {
            return i;
        }
        if (i < i2) {
            return this.mRandom.nextInt(i2 - i) + i;
        }
        return this.mRandom.nextInt(i - i2) + i2;
    }

    private boolean hasGravity(int i, int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "240581482") ? ((Boolean) ipChange.ipc$dispatch("240581482", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue() : (i & i2) == i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdate(long j) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-763333390")) {
            ipChange.ipc$dispatch("-763333390", new Object[]{this, Long.valueOf(j)});
            return;
        }
        while (true) {
            long j2 = this.mEmittingTime;
            if (((j2 <= 0 || j >= j2) && j2 != -1) || this.mParticles.isEmpty() || this.mActivatedParticles >= this.mParticlesPerMillisecond * ((float) j)) {
                break;
            }
            activateParticle(j);
        }
        synchronized (this.mActiveParticles) {
            while (i < this.mActiveParticles.size()) {
                if (!this.mActiveParticles.get(i).update(j)) {
                    i--;
                    this.mParticles.add(this.mActiveParticles.remove(i));
                }
                i++;
            }
        }
        this.mDrawingView.postInvalidate();
    }

    public static void setFPS(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "350579531")) {
            ipChange.ipc$dispatch("350579531", new Object[]{Double.valueOf(d)});
        } else {
            TIMER_TASK_INTERVAL = Math.round(1000.0d / d);
        }
    }

    private void startAnimator(Interpolator interpolator, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1573710746")) {
            ipChange.ipc$dispatch("-1573710746", new Object[]{this, interpolator, Long.valueOf(j)});
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) j);
        this.mAnimator = ofInt;
        ofInt.setDuration(j);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.Particle.ParticleSystem.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1335005665")) {
                    ipChange2.ipc$dispatch("-1335005665", new Object[]{this, valueAnimator});
                } else {
                    ParticleSystem.this.onUpdate(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.mAnimator.addListener(new Animator.AnimatorListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.Particle.ParticleSystem.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1979808288")) {
                    ipChange2.ipc$dispatch("-1979808288", new Object[]{this, animator});
                } else {
                    ParticleSystem.this.cleanupAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1499758257")) {
                    ipChange2.ipc$dispatch("-1499758257", new Object[]{this, animator});
                } else {
                    ParticleSystem.this.cleanupAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "333767327")) {
                    ipChange2.ipc$dispatch("333767327", new Object[]{this, animator});
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "396924648")) {
                    ipChange2.ipc$dispatch("396924648", new Object[]{this, animator});
                }
            }
        });
        this.mAnimator.setInterpolator(interpolator);
        this.mAnimator.start();
    }

    private void startEmitting(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "434072022")) {
            ipChange.ipc$dispatch("434072022", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mActivatedParticles = 0;
        this.mParticlesPerMillisecond = i / 1000.0f;
        ParticleField particleField = new ParticleField(this.mParentView.getContext());
        this.mDrawingView = particleField;
        this.mParentView.addView(particleField);
        this.mEmittingTime = -1L;
        this.mDrawingView.setParticles(this.mActiveParticles);
        updateParticlesBeforeStartTime(i);
        Timer timer = new Timer();
        this.mTimer = timer;
        timer.schedule(this.mTimerTask, 0L, TIMER_TASK_INTERVAL);
    }

    private void updateParticlesBeforeStartTime(int i) {
        IpChange ipChange = $ipChange;
        int i2 = 1;
        if (AndroidInstantRuntime.support(ipChange, "-857955723")) {
            ipChange.ipc$dispatch("-857955723", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 0) {
        } else {
            long j = this.mCurrentTime;
            long j2 = (j / 1000) / i;
            if (j2 == 0) {
                return;
            }
            long j3 = j / j2;
            while (true) {
                long j4 = i2;
                if (j4 > j2) {
                    return;
                }
                onUpdate((j4 * j3) + 1);
                i2++;
            }
        }
    }

    public ParticleSystem addInitializer(ParticleInitializer particleInitializer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1331588138")) {
            return (ParticleSystem) ipChange.ipc$dispatch("-1331588138", new Object[]{this, particleInitializer});
        }
        if (particleInitializer != null) {
            this.mInitializers.add(particleInitializer);
        }
        return this;
    }

    public ParticleSystem addModifier(ParticleModifier particleModifier) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1495424923")) {
            return (ParticleSystem) ipChange.ipc$dispatch("-1495424923", new Object[]{this, particleModifier});
        }
        this.mModifiers.add(particleModifier);
        return this;
    }

    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "997567776")) {
            ipChange.ipc$dispatch("997567776", new Object[]{this});
            return;
        }
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer.purge();
            cleanupAnimation();
        }
    }

    public float dpToPx(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1572086235") ? ((Float) ipChange.ipc$dispatch("-1572086235", new Object[]{this, Float.valueOf(f)})).floatValue() : f * this.mDpToPxScale;
    }

    public void emit(View view, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-725906261")) {
            ipChange.ipc$dispatch("-725906261", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            emitWithGravity(view, 17, i, i2);
        }
    }

    public void emitWithGravity(View view, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1586413556")) {
            ipChange.ipc$dispatch("-1586413556", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        configureEmitter(view, i);
        startEmitting(i2, i3);
    }

    public void oneShot(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "815222689")) {
            ipChange.ipc$dispatch("815222689", new Object[]{this, view, Integer.valueOf(i)});
        } else {
            oneShot(view, i, new LinearInterpolator());
        }
    }

    public ParticleSystem setAcceleration(float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-198798043")) {
            return (ParticleSystem) ipChange.ipc$dispatch("-198798043", new Object[]{this, Float.valueOf(f), Integer.valueOf(i)});
        }
        this.mInitializers.add(new AccelerationInitializer(f, f, i, i));
        return this;
    }

    public ParticleSystem setAccelerationModuleAndAndAngleRange(float f, float f2, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1035153228")) {
            return (ParticleSystem) ipChange.ipc$dispatch("1035153228", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.mInitializers.add(new AccelerationInitializer(dpToPx(f), dpToPx(f2), i, i2));
        return this;
    }

    public ParticleSystem setFadeOut(long j, Interpolator interpolator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-109811905")) {
            return (ParticleSystem) ipChange.ipc$dispatch("-109811905", new Object[]{this, Long.valueOf(j), interpolator});
        }
        List<ParticleModifier> list = this.mModifiers;
        long j2 = this.mTimeToLive;
        list.add(new AlphaModifier(255, 0, j2 - j, j2, interpolator));
        return this;
    }

    public ParticleSystem setInitialRotationRange(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-796418009")) {
            return (ParticleSystem) ipChange.ipc$dispatch("-796418009", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.mInitializers.add(new RotationInitializer(i, i2));
        return this;
    }

    public ParticleSystem setParentViewGroup(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1038085057")) {
            return (ParticleSystem) ipChange.ipc$dispatch("-1038085057", new Object[]{this, viewGroup});
        }
        this.mParentView = viewGroup;
        if (viewGroup != null) {
            viewGroup.getLocationInWindow(this.mParentLocation);
        }
        return this;
    }

    public ParticleSystem setRotationSpeed(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "445224961")) {
            return (ParticleSystem) ipChange.ipc$dispatch("445224961", new Object[]{this, Float.valueOf(f)});
        }
        this.mInitializers.add(new RotationSpeedInitializer(f, f));
        return this;
    }

    public ParticleSystem setRotationSpeedRange(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "996782926")) {
            return (ParticleSystem) ipChange.ipc$dispatch("996782926", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
        }
        this.mInitializers.add(new RotationSpeedInitializer(f, f2));
        return this;
    }

    public ParticleSystem setScaleRange(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1141297297")) {
            return (ParticleSystem) ipChange.ipc$dispatch("-1141297297", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
        }
        this.mInitializers.add(new ScaleInitializer(f, f2));
        return this;
    }

    public ParticleSystem setSpeedByComponentsRange(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1879252121")) {
            return (ParticleSystem) ipChange.ipc$dispatch("1879252121", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
        }
        this.mInitializers.add(new SpeeddByComponentsInitializer(dpToPx(f), dpToPx(f2), dpToPx(f3), dpToPx(f4)));
        return this;
    }

    public ParticleSystem setSpeedModuleAndAngleRange(float f, float f2, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-223976204")) {
            return (ParticleSystem) ipChange.ipc$dispatch("-223976204", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)});
        }
        while (i2 < i) {
            i2 += 360;
        }
        this.mInitializers.add(new SpeedModuleAndRangeInitializer(dpToPx(f), dpToPx(f2), i, i2));
        return this;
    }

    public ParticleSystem setSpeedRange(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "407810732")) {
            return (ParticleSystem) ipChange.ipc$dispatch("407810732", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
        }
        this.mInitializers.add(new SpeedModuleAndRangeInitializer(dpToPx(f), dpToPx(f2), 0, 360));
        return this;
    }

    public ParticleSystem setStartTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-502188949")) {
            return (ParticleSystem) ipChange.ipc$dispatch("-502188949", new Object[]{this, Long.valueOf(j)});
        }
        this.mCurrentTime = j;
        return this;
    }

    public void stopEmitting() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1319967703")) {
            ipChange.ipc$dispatch("1319967703", new Object[]{this});
        } else {
            this.mEmittingTime = this.mCurrentTime;
        }
    }

    public void updateEmitPoint(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "3243228")) {
            ipChange.ipc$dispatch("3243228", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            configureEmitter(i, i2);
        }
    }

    public void emit(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "807866712")) {
            ipChange.ipc$dispatch("807866712", new Object[]{this, view, Integer.valueOf(i)});
        } else {
            emitWithGravity(view, 17, i);
        }
    }

    public void oneShot(View view, int i, Interpolator interpolator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "20980260")) {
            ipChange.ipc$dispatch("20980260", new Object[]{this, view, Integer.valueOf(i), interpolator});
            return;
        }
        configureEmitter(view, 17);
        this.mActivatedParticles = 0;
        this.mEmittingTime = this.mTimeToLive;
        for (int i2 = 0; i2 < i && i2 < this.mMaxParticles; i2++) {
            activateParticle(0L);
        }
        ParticleField particleField = new ParticleField(this.mParentView.getContext());
        this.mDrawingView = particleField;
        this.mParentView.addView(particleField);
        this.mDrawingView.setParticles(this.mActiveParticles);
        startAnimator(interpolator, this.mTimeToLive);
    }

    public ParticleSystem setFadeOut(float f, long j, Interpolator interpolator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-435040405")) {
            return (ParticleSystem) ipChange.ipc$dispatch("-435040405", new Object[]{this, Float.valueOf(f), Long.valueOf(j), interpolator});
        }
        int round = Math.round(f * 255.0f);
        List<ParticleModifier> list = this.mModifiers;
        long j2 = this.mTimeToLive;
        list.add(new AlphaModifier(round, 0, j2 - j, j2, interpolator));
        return this;
    }

    public void updateEmitPoint(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-323728915")) {
            ipChange.ipc$dispatch("-323728915", new Object[]{this, view, Integer.valueOf(i)});
        } else {
            configureEmitter(view, i);
        }
    }

    public void emit(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-35581017")) {
            ipChange.ipc$dispatch("-35581017", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        configureEmitter(i, i2);
        startEmitting(i3, i4);
    }

    public void emitWithGravity(View view, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-466817577")) {
            ipChange.ipc$dispatch("-466817577", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        configureEmitter(view, i);
        startEmitting(i2);
    }

    public ParticleSystem setFadeOut(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1108122226") ? (ParticleSystem) ipChange.ipc$dispatch("-1108122226", new Object[]{this, Long.valueOf(j)}) : setFadeOut(j, new LinearInterpolator());
    }

    private void configureEmitter(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-698888093")) {
            ipChange.ipc$dispatch("-698888093", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (hasGravity(i, 3)) {
            int i2 = iArr[0] - this.mParentLocation[0];
            this.mEmitterXMin = i2;
            this.mEmitterXMax = i2;
        } else if (hasGravity(i, 5)) {
            int width = (iArr[0] + view.getWidth()) - this.mParentLocation[0];
            this.mEmitterXMin = width;
            this.mEmitterXMax = width;
        } else if (hasGravity(i, 1)) {
            int width2 = (iArr[0] + (view.getWidth() / 2)) - this.mParentLocation[0];
            this.mEmitterXMin = width2;
            this.mEmitterXMax = width2;
        } else {
            this.mEmitterXMin = iArr[0] - this.mParentLocation[0];
            this.mEmitterXMax = (iArr[0] + view.getWidth()) - this.mParentLocation[0];
        }
        if (hasGravity(i, 48)) {
            int i3 = iArr[1] - this.mParentLocation[1];
            this.mEmitterYMin = i3;
            this.mEmitterYMax = i3;
        } else if (hasGravity(i, 80)) {
            int height = (iArr[1] + view.getHeight()) - this.mParentLocation[1];
            this.mEmitterYMin = height;
            this.mEmitterYMax = height;
        } else if (hasGravity(i, 16)) {
            int height2 = (iArr[1] + (view.getHeight() / 2)) - this.mParentLocation[1];
            this.mEmitterYMin = height2;
            this.mEmitterYMax = height2;
        } else {
            this.mEmitterYMin = iArr[1] - this.mParentLocation[1];
            this.mEmitterYMax = (iArr[1] + view.getHeight()) - this.mParentLocation[1];
        }
    }

    public void emit(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "553040604")) {
            ipChange.ipc$dispatch("553040604", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        configureEmitter(i, i2);
        startEmitting(i3);
    }

    private void startEmitting(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "571360237")) {
            ipChange.ipc$dispatch("571360237", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mActivatedParticles = 0;
        this.mParticlesPerMillisecond = i / 1000.0f;
        ParticleField particleField = new ParticleField(this.mParentView.getContext());
        this.mDrawingView = particleField;
        this.mParentView.addView(particleField);
        this.mDrawingView.setParticles(this.mActiveParticles);
        updateParticlesBeforeStartTime(i);
        long j = i2;
        this.mEmittingTime = j;
        startAnimator(new LinearInterpolator(), j + this.mTimeToLive);
    }

    public ParticleSystem(ViewGroup viewGroup, int i, Drawable drawable, long j) {
        this(viewGroup, i, j);
        Bitmap createBitmap;
        int i2 = 0;
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            while (i2 < this.mMaxParticles) {
                this.mParticles.add(new AnimatedParticle(animationDrawable));
                i2++;
            }
            return;
        }
        if (drawable instanceof BitmapDrawable) {
            createBitmap = ((BitmapDrawable) drawable).getBitmap();
        } else {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        }
        while (i2 < this.mMaxParticles) {
            this.mParticles.add(new C7945Particle(createBitmap));
            i2++;
        }
    }

    public ParticleSystem(Activity activity, int i, int i2, long j) {
        this(activity, i, activity.getResources().getDrawable(i2), j, 16908290);
    }

    public ParticleSystem(Activity activity, int i, int i2, long j, int i3) {
        this(activity, i, activity.getResources().getDrawable(i2), j, i3);
    }

    public ParticleSystem(Activity activity, int i, Drawable drawable, long j) {
        this(activity, i, drawable, j, 16908290);
    }

    public ParticleSystem(Activity activity, int i, Drawable drawable, long j, int i2) {
        this((ViewGroup) activity.findViewById(i2), i, drawable, j);
    }

    public ParticleSystem(Activity activity, int i, Bitmap bitmap, long j) {
        this(activity, i, bitmap, j, 16908290);
    }

    public ParticleSystem(Activity activity, int i, Bitmap bitmap, long j, int i2) {
        this((ViewGroup) activity.findViewById(i2), i, j);
        for (int i3 = 0; i3 < this.mMaxParticles; i3++) {
            this.mParticles.add(new C7945Particle(bitmap));
        }
    }

    public ParticleSystem(Activity activity, int i, AnimationDrawable animationDrawable, long j) {
        this(activity, i, animationDrawable, j, 16908290);
    }

    public ParticleSystem(Activity activity, int i, AnimationDrawable animationDrawable, long j, int i2) {
        this((ViewGroup) activity.findViewById(i2), i, j);
        for (int i3 = 0; i3 < this.mMaxParticles; i3++) {
            this.mParticles.add(new AnimatedParticle(animationDrawable));
        }
    }
}
