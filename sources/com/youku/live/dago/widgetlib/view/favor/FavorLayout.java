package com.youku.live.dago.widgetlib.view.favor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class FavorLayout extends View implements IFavorHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int ADD_FAVOR = 321;
    private static final int ADD_FAVOR_LOOP = 231;
    private static final int FAVOR_DURATION = 3000;
    private static final int MAX_COUNT = 50;
    private static final int SHOW_FAKE_FAVOR = 123;
    private Interpolator acc;
    private Interpolator accdec;
    private Interpolator dce;
    private Interpolator[] interpolators;
    private Interpolator line;
    private int mCurrentIndex;
    private int mDrawableHeight;
    private int mDrawableWidth;
    private List<Drawable> mDrawables;
    private int mFavorDuration;
    private ArrayList<FavorObject> mFavorObjects;
    private WeakHandler mHandler;
    private int mHeight;
    private long mLastTimeMillis;
    private double mScaleFactor;
    private int mWidth;
    private Random random;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class AnimEndListener extends AnimatorListenerAdapter {
        private WeakReference<FavorLayout> mFavorLayout;
        private FavorObject target;

        public AnimEndListener(FavorLayout favorLayout, FavorObject favorObject) {
            this.mFavorLayout = new WeakReference<>(favorLayout);
            this.target = favorObject;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            FavorLayout favorLayout = this.mFavorLayout.get();
            if (favorLayout != null) {
                favorLayout.removeFavor(this.target);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class BezierListener implements ValueAnimator.AnimatorUpdateListener {
        private WeakReference<FavorLayout> mWeakRef;
        private FavorObject target;

        public BezierListener(FavorObject favorObject, FavorLayout favorLayout) {
            this.target = favorObject;
            this.mWeakRef = new WeakReference<>(favorLayout);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PointF pointF = (PointF) valueAnimator.getAnimatedValue();
            this.target.setX(pointF.x);
            this.target.setY(pointF.y);
            this.target.setAlpha(1.0f - valueAnimator.getAnimatedFraction());
            FavorLayout favorLayout = this.mWeakRef.get();
            if (favorLayout != null) {
                favorLayout.invalidate();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class FavorObject {
        private float alpha;
        private Drawable drawable;
        private float scaleX;
        private float scaleY;
        private float x;
        private float y;

        public float getAlpha() {
            return this.alpha;
        }

        public Drawable getDrawable() {
            return this.drawable;
        }

        public float getScaleX() {
            return this.scaleX;
        }

        public float getScaleY() {
            return this.scaleY;
        }

        public float getX() {
            return this.x;
        }

        public float getY() {
            return this.y;
        }

        public void setAlpha(float f) {
            this.alpha = f;
        }

        public void setDrawable(Drawable drawable) {
            this.drawable = drawable;
        }

        public void setScaleX(float f) {
            this.scaleX = f;
        }

        public void setScaleY(float f) {
            this.scaleY = f;
        }

        public void setX(float f) {
            this.x = f;
        }

        public void setY(float f) {
            this.y = f;
        }
    }

    public FavorLayout(Context context) {
        this(context, null);
    }

    private LayerDrawable createLayerDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1619628767")) {
            return (LayerDrawable) ipChange.ipc$dispatch("1619628767", new Object[]{this, drawable});
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(drawable.getIntrinsicHeight());
        shapeDrawable.setIntrinsicWidth(drawable.getIntrinsicWidth());
        shapeDrawable.getPaint().setColor(-1);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, drawable});
        layerDrawable.setLayerInset(0, 0, 0, 0, 0);
        layerDrawable.setLayerInset(1, 8, 8, 8, 8);
        return layerDrawable;
    }

    private Animator getAnimator(FavorObject favorObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2052240751")) {
            return (Animator) ipChange.ipc$dispatch("-2052240751", new Object[]{this, favorObject});
        }
        int i = this.mWidth / 2;
        AnimatorSet enterAnimtor = getEnterAnimtor(favorObject, i);
        ValueAnimator bezierValueAnimator = getBezierValueAnimator(favorObject, i);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(enterAnimtor, bezierValueAnimator);
        animatorSet.setInterpolator(this.accdec);
        animatorSet.setTarget(favorObject);
        return animatorSet;
    }

    private ValueAnimator getBezierValueAnimator(FavorObject favorObject, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-734892641")) {
            return (ValueAnimator) ipChange.ipc$dispatch("-734892641", new Object[]{this, favorObject, Integer.valueOf(i)});
        }
        float f = i;
        ValueAnimator ofObject = ValueAnimator.ofObject(new BezierEvaluator(getPointF(2), getPointF(1)), new PointF(f, (float) (this.mHeight - 10)), new PointF(f, 0.0f));
        ofObject.addUpdateListener(new BezierListener(favorObject, this));
        ofObject.setTarget(favorObject);
        ofObject.setDuration(this.mFavorDuration);
        return ofObject;
    }

    private PointF getBreakPointF(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "63790403")) {
            return (PointF) ipChange.ipc$dispatch("63790403", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        Random random = new Random();
        PointF pointF = new PointF();
        int measuredWidth = ((getMeasuredWidth() - getPaddingRight()) + getPaddingLeft()) / i;
        if (measuredWidth <= 0) {
            measuredWidth = 1;
        }
        pointF.x = random.nextInt(measuredWidth) + (getMeasuredWidth() / i2);
        int measuredHeight = ((getMeasuredHeight() - getPaddingBottom()) + getPaddingTop()) / i;
        pointF.y = random.nextInt(measuredHeight > 0 ? measuredHeight : 1) + (getMeasuredHeight() / i2);
        return pointF;
    }

    private AnimatorSet getEnterAnimtor(FavorObject favorObject, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1710426153")) {
            return (AnimatorSet) ipChange.ipc$dispatch("1710426153", new Object[]{this, favorObject, Integer.valueOf(i)});
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(favorObject, "alpha", 0.2f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(favorObject, "scaleX", 0.2f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(favorObject, "scaleY", 0.2f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setTarget(favorObject);
        return animatorSet;
    }

    private PointF getPointF(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-69422230")) {
            return (PointF) ipChange.ipc$dispatch("-69422230", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        PointF pointF = new PointF();
        pointF.x = i;
        pointF.y = i2;
        return pointF;
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1799078363")) {
            ipChange.ipc$dispatch("1799078363", new Object[]{this});
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.mDrawables = copyOnWriteArrayList;
        copyOnWriteArrayList.add(getResources().getDrawable(R.drawable.dago_pgc_ykl_like_favor_anim_1));
        this.mDrawables.add(getResources().getDrawable(R.drawable.dago_pgc_ykl_like_favor_anim_2));
        this.mDrawables.add(getResources().getDrawable(R.drawable.dago_pgc_ykl_like_favor_anim_3));
        int dimension = (int) getResources().getDimension(R.dimen.dago_pgc_ykl_like_favor_size);
        this.mDrawableWidth = dimension;
        this.mDrawableHeight = dimension;
        this.interpolators = r0;
        Interpolator[] interpolatorArr = {this.line, this.acc, this.dce, this.accdec};
        this.mFavorObjects = new ArrayList<>();
    }

    public void addFavor(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-237447706")) {
            ipChange.ipc$dispatch("-237447706", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mFavorObjects.size() >= 50) {
        } else {
            if (this.mCurrentIndex >= this.mDrawables.size()) {
                this.mCurrentIndex = 0;
            }
            int i = this.mCurrentIndex;
            if (i >= 0 && i < this.mDrawables.size()) {
                try {
                    Drawable drawable = this.mDrawables.get(this.mCurrentIndex);
                    if (drawable == null) {
                        this.mCurrentIndex++;
                        return;
                    }
                    FavorObject favorObject = new FavorObject();
                    favorObject.setDrawable(drawable.getConstantState().newDrawable());
                    this.mCurrentIndex++;
                    this.mFavorObjects.add(favorObject);
                    Animator animator = getAnimator(favorObject);
                    animator.addListener(new AnimEndListener(this, favorObject));
                    animator.start();
                    invalidate();
                } catch (Exception unused) {
                }
            }
        }
    }

    public void clearFavor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1090207450")) {
            ipChange.ipc$dispatch("1090207450", new Object[]{this});
            return;
        }
        WeakHandler weakHandler = this.mHandler;
        if (weakHandler != null) {
            weakHandler.removeCallbacksAndMessages(null);
        }
        ArrayList<FavorObject> arrayList = this.mFavorObjects;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1948934149")) {
            ipChange.ipc$dispatch("1948934149", new Object[]{this});
            return;
        }
        stopFakeFavor();
        ArrayList<FavorObject> arrayList = this.mFavorObjects;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public List<Drawable> getDrawables() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1427390235") ? (List) ipChange.ipc$dispatch("1427390235", new Object[]{this}) : this.mDrawables;
    }

    @Override // com.youku.live.dago.widgetlib.view.favor.IFavorHandler
    public void handleMessage(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "221151987")) {
            ipChange.ipc$dispatch("221151987", new Object[]{this, message});
            return;
        }
        int i = message.what;
        if (i != 123) {
            if (i == ADD_FAVOR_LOOP) {
                this.mHandler.sendEmptyMessageDelayed(ADD_FAVOR, 1000L);
            } else if (i != ADD_FAVOR) {
            } else {
                addFavor(false);
            }
        } else if (message.obj.equals(this.mHandler.toString())) {
            addFavor(2);
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.what = 123;
            obtainMessage.obj = this.mHandler.toString();
            this.mHandler.sendMessageDelayed(obtainMessage, 700L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1812622947")) {
            ipChange.ipc$dispatch("-1812622947", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        ArrayList<FavorObject> arrayList = this.mFavorObjects;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.mFavorObjects.size(); i++) {
            this.mFavorObjects.get(i).getDrawable().setAlpha((int) (this.mFavorObjects.get(i).getAlpha() * 255.0f));
            this.mFavorObjects.get(i).getDrawable().setBounds((int) (this.mFavorObjects.get(i).getX() - (((this.mDrawableWidth * this.mFavorObjects.get(i).getScaleX()) * this.mScaleFactor) / 2.0d)), (int) (this.mFavorObjects.get(i).getY() - (((this.mDrawableHeight * this.mFavorObjects.get(i).getScaleY()) * this.mScaleFactor) / 2.0d)), (int) (this.mFavorObjects.get(i).getX() + (((this.mDrawableWidth * this.mFavorObjects.get(i).getScaleX()) * this.mScaleFactor) / 2.0d)), (int) (this.mFavorObjects.get(i).getY() + (((this.mDrawableHeight * this.mFavorObjects.get(i).getScaleY()) * this.mScaleFactor) / 2.0d)));
            this.mFavorObjects.get(i).getDrawable().draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-120246976")) {
            ipChange.ipc$dispatch("-120246976", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
    }

    public void removeFavor(FavorObject favorObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1326309755")) {
            ipChange.ipc$dispatch("-1326309755", new Object[]{this, favorObject});
            return;
        }
        ArrayList<FavorObject> arrayList = this.mFavorObjects;
        if (arrayList != null) {
            arrayList.remove(favorObject);
        }
    }

    public void setDrawables(ArrayList<Drawable> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1295629298")) {
            ipChange.ipc$dispatch("1295629298", new Object[]{this, arrayList});
        } else if (arrayList == null || arrayList.size() <= 0) {
        } else {
            this.mDrawables = arrayList;
        }
    }

    public void setFavorDuration(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "994708776")) {
            ipChange.ipc$dispatch("994708776", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mFavorDuration = i;
        }
    }

    public void setFavorHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1649807173")) {
            ipChange.ipc$dispatch("-1649807173", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mDrawableHeight = i;
        }
    }

    public void setFavorWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1508435790")) {
            ipChange.ipc$dispatch("1508435790", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mDrawableWidth = i;
        }
    }

    public void setScaleFactor(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-860660182")) {
            ipChange.ipc$dispatch("-860660182", new Object[]{this, Double.valueOf(d)});
        } else {
            this.mScaleFactor = d;
        }
    }

    public void startFakeFavor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1969291876")) {
            ipChange.ipc$dispatch("1969291876", new Object[]{this});
            return;
        }
        if (this.mHandler == null) {
            this.mHandler = new WeakHandler(this);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = ADD_FAVOR;
        obtainMessage.obj = this.mHandler.toString();
        this.mHandler.sendMessage(obtainMessage);
    }

    public void stopFakeFavor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "546876248")) {
            ipChange.ipc$dispatch("546876248", new Object[]{this});
            return;
        }
        WeakHandler weakHandler = this.mHandler;
        if (weakHandler != null) {
            weakHandler.removeCallbacksAndMessages(null);
        }
        invalidate();
    }

    public FavorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FavorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.random = new Random();
        this.line = new LinearInterpolator();
        this.acc = new AccelerateInterpolator();
        this.dce = new DecelerateInterpolator();
        this.accdec = new AccelerateDecelerateInterpolator();
        this.mCurrentIndex = 0;
        this.mFavorDuration = 3000;
        this.mScaleFactor = 1.0d;
        this.mHandler = null;
        this.mLastTimeMillis = 0L;
        init();
    }

    private PointF getPointF(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1909790457")) {
            return (PointF) ipChange.ipc$dispatch("-1909790457", new Object[]{this, Integer.valueOf(i)});
        }
        PointF pointF = new PointF();
        Random random = this.random;
        int i2 = this.mWidth;
        if (i2 <= 0) {
            i2 = 1;
        }
        pointF.x = random.nextInt(i2);
        int i3 = this.mHeight;
        if (i3 - 100 > 0) {
            i3 -= 100;
        }
        pointF.y = this.random.nextInt(i3 > 0 ? i3 : 1) / i;
        return pointF;
    }

    public void addFavor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-237464043")) {
            ipChange.ipc$dispatch("-237464043", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int size = this.mDrawables.size();
        int i2 = size > 0 ? size : 1;
        if (i > 0) {
            if (i > i2) {
                i = i2;
            }
            int i3 = this.mFavorDuration / i;
            for (int i4 = 0; i4 < i; i4++) {
                if (this.mHandler == null) {
                    this.mHandler = new WeakHandler(this);
                }
                this.mHandler.sendEmptyMessageDelayed(ADD_FAVOR, i4 * i3);
            }
        }
    }
}
