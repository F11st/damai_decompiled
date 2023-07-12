package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ChangeBounds extends Transition {
    private boolean mReparent;
    private boolean mResizeClip;
    private int[] mTempLocation;
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final String[] sTransitionProperties = {PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
    private static final Property<Drawable, PointF> DRAWABLE_ORIGIN_PROPERTY = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") { // from class: androidx.transition.ChangeBounds.1
        private Rect mBounds = new Rect();

        @Override // android.util.Property
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.mBounds);
            Rect rect = this.mBounds;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.mBounds);
            this.mBounds.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.mBounds);
        }
    };
    private static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, "topLeft") { // from class: androidx.transition.ChangeBounds.2
        @Override // android.util.Property
        public PointF get(ViewBounds viewBounds) {
            return null;
        }

        @Override // android.util.Property
        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.setTopLeft(pointF);
        }
    };
    private static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, "bottomRight") { // from class: androidx.transition.ChangeBounds.3
        @Override // android.util.Property
        public PointF get(ViewBounds viewBounds) {
            return null;
        }

        @Override // android.util.Property
        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.setBottomRight(pointF);
        }
    };
    private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, "bottomRight") { // from class: androidx.transition.ChangeBounds.4
        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            ViewUtils.setLeftTopRightBottom(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, "topLeft") { // from class: androidx.transition.ChangeBounds.5
        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            ViewUtils.setLeftTopRightBottom(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    private static final Property<View, PointF> POSITION_PROPERTY = new Property<View, PointF>(PointF.class, "position") { // from class: androidx.transition.ChangeBounds.6
        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            ViewUtils.setLeftTopRightBottom(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };
    private static RectEvaluator sRectEvaluator = new RectEvaluator();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class ViewBounds {
        private int mBottom;
        private int mBottomRightCalls;
        private int mLeft;
        private int mRight;
        private int mTop;
        private int mTopLeftCalls;
        private View mView;

        ViewBounds(View view) {
            this.mView = view;
        }

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }

        void setBottomRight(PointF pointF) {
            this.mRight = Math.round(pointF.x);
            this.mBottom = Math.round(pointF.y);
            int i = this.mBottomRightCalls + 1;
            this.mBottomRightCalls = i;
            if (this.mTopLeftCalls == i) {
                setLeftTopRightBottom();
            }
        }

        void setTopLeft(PointF pointF) {
            this.mLeft = Math.round(pointF.x);
            this.mTop = Math.round(pointF.y);
            int i = this.mTopLeftCalls + 1;
            this.mTopLeftCalls = i;
            if (i == this.mBottomRightCalls) {
                setLeftTopRightBottom();
            }
        }
    }

    public ChangeBounds() {
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (!ViewCompat.isLaidOut(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        transitionValues.values.put(PROPNAME_BOUNDS, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
        if (this.mReparent) {
            transitionValues.view.getLocationInWindow(this.mTempLocation);
            transitionValues.values.put(PROPNAME_WINDOW_X, Integer.valueOf(this.mTempLocation[0]));
            transitionValues.values.put(PROPNAME_WINDOW_Y, Integer.valueOf(this.mTempLocation[1]));
        }
        if (this.mResizeClip) {
            transitionValues.values.put(PROPNAME_CLIP, ViewCompat.getClipBounds(view));
        }
    }

    private boolean parentMatches(View view, View view2) {
        if (this.mReparent) {
            TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
            if (matchedTransitionValues == null) {
                if (view == view2) {
                    return true;
                }
            } else if (view2 == matchedTransitionValues.view) {
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull final ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        int i;
        final View view;
        int i2;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator mergeAnimators;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues.values;
        Map<String, Object> map2 = transitionValues2.values;
        ViewGroup viewGroup2 = (ViewGroup) map.get(PROPNAME_PARENT);
        ViewGroup viewGroup3 = (ViewGroup) map2.get(PROPNAME_PARENT);
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        final View view2 = transitionValues2.view;
        if (parentMatches(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) transitionValues.values.get(PROPNAME_BOUNDS);
            Rect rect3 = (Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
            int i3 = rect2.left;
            final int i4 = rect3.left;
            int i5 = rect2.top;
            final int i6 = rect3.top;
            int i7 = rect2.right;
            final int i8 = rect3.right;
            int i9 = rect2.bottom;
            final int i10 = rect3.bottom;
            int i11 = i7 - i3;
            int i12 = i9 - i5;
            int i13 = i8 - i4;
            int i14 = i10 - i6;
            Rect rect4 = (Rect) transitionValues.values.get(PROPNAME_CLIP);
            final Rect rect5 = (Rect) transitionValues2.values.get(PROPNAME_CLIP);
            if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
                i = 0;
            } else {
                i = (i3 == i4 && i5 == i6) ? 0 : 1;
                if (i7 != i8 || i9 != i10) {
                    i++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i++;
            }
            if (i > 0) {
                if (!this.mResizeClip) {
                    view = view2;
                    ViewUtils.setLeftTopRightBottom(view, i3, i5, i7, i9);
                    if (i == 2) {
                        if (i11 == i13 && i12 == i14) {
                            mergeAnimators = ObjectAnimatorUtils.ofPointF(view, POSITION_PROPERTY, getPathMotion().getPath(i3, i5, i4, i6));
                        } else {
                            ViewBounds viewBounds = new ViewBounds(view);
                            ObjectAnimator ofPointF = ObjectAnimatorUtils.ofPointF(viewBounds, TOP_LEFT_PROPERTY, getPathMotion().getPath(i3, i5, i4, i6));
                            ObjectAnimator ofPointF2 = ObjectAnimatorUtils.ofPointF(viewBounds, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath(i7, i9, i8, i10));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(ofPointF, ofPointF2);
                            animatorSet.addListener(new AnimatorListenerAdapter(viewBounds) { // from class: androidx.transition.ChangeBounds.7
                                private ViewBounds mViewBounds;
                                final /* synthetic */ ViewBounds val$viewBounds;

                                {
                                    this.val$viewBounds = viewBounds;
                                    this.mViewBounds = viewBounds;
                                }
                            });
                            mergeAnimators = animatorSet;
                        }
                    } else if (i3 == i4 && i5 == i6) {
                        mergeAnimators = ObjectAnimatorUtils.ofPointF(view, BOTTOM_RIGHT_ONLY_PROPERTY, getPathMotion().getPath(i7, i9, i8, i10));
                    } else {
                        mergeAnimators = ObjectAnimatorUtils.ofPointF(view, TOP_LEFT_ONLY_PROPERTY, getPathMotion().getPath(i3, i5, i4, i6));
                    }
                } else {
                    view = view2;
                    ViewUtils.setLeftTopRightBottom(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                    ObjectAnimator ofPointF3 = (i3 == i4 && i5 == i6) ? null : ObjectAnimatorUtils.ofPointF(view, POSITION_PROPERTY, getPathMotion().getPath(i3, i5, i4, i6));
                    if (rect4 == null) {
                        i2 = 0;
                        rect = new Rect(0, 0, i11, i12);
                    } else {
                        i2 = 0;
                        rect = rect4;
                    }
                    Rect rect6 = rect5 == null ? new Rect(i2, i2, i13, i14) : rect5;
                    if (rect.equals(rect6)) {
                        objectAnimator = null;
                    } else {
                        ViewCompat.setClipBounds(view, rect);
                        RectEvaluator rectEvaluator = sRectEvaluator;
                        Object[] objArr = new Object[2];
                        objArr[i2] = rect;
                        objArr[1] = rect6;
                        ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", rectEvaluator, objArr);
                        ofObject.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.8
                            private boolean mIsCanceled;

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator) {
                                this.mIsCanceled = true;
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (this.mIsCanceled) {
                                    return;
                                }
                                ViewCompat.setClipBounds(view, rect5);
                                ViewUtils.setLeftTopRightBottom(view, i4, i6, i8, i10);
                            }
                        });
                        objectAnimator = ofObject;
                    }
                    mergeAnimators = TransitionUtils.mergeAnimators(ofPointF3, objectAnimator);
                }
                if (view.getParent() instanceof ViewGroup) {
                    final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    ViewGroupUtils.suppressLayout(viewGroup4, true);
                    addListener(new TransitionListenerAdapter() { // from class: androidx.transition.ChangeBounds.9
                        boolean mCanceled = false;

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionCancel(@NonNull Transition transition) {
                            ViewGroupUtils.suppressLayout(viewGroup4, false);
                            this.mCanceled = true;
                        }

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionEnd(@NonNull Transition transition) {
                            if (!this.mCanceled) {
                                ViewGroupUtils.suppressLayout(viewGroup4, false);
                            }
                            transition.removeListener(this);
                        }

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionPause(@NonNull Transition transition) {
                            ViewGroupUtils.suppressLayout(viewGroup4, false);
                        }

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionResume(@NonNull Transition transition) {
                            ViewGroupUtils.suppressLayout(viewGroup4, true);
                        }
                    });
                }
                return mergeAnimators;
            }
            return null;
        }
        int intValue = ((Integer) transitionValues.values.get(PROPNAME_WINDOW_X)).intValue();
        int intValue2 = ((Integer) transitionValues.values.get(PROPNAME_WINDOW_Y)).intValue();
        int intValue3 = ((Integer) transitionValues2.values.get(PROPNAME_WINDOW_X)).intValue();
        int intValue4 = ((Integer) transitionValues2.values.get(PROPNAME_WINDOW_Y)).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.mTempLocation);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        final BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        final float transitionAlpha = ViewUtils.getTransitionAlpha(view2);
        ViewUtils.setTransitionAlpha(view2, 0.0f);
        ViewUtils.getOverlay(viewGroup).add(bitmapDrawable);
        PathMotion pathMotion = getPathMotion();
        int[] iArr = this.mTempLocation;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, pathMotion.getPath(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewUtils.getOverlay(viewGroup).remove(bitmapDrawable);
                ViewUtils.setTransitionAlpha(view2, transitionAlpha);
            }
        });
        return ofPropertyValuesHolder;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setResizeClip(boolean z) {
        this.mResizeClip = z;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_BOUNDS);
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        setResizeClip(namedBoolean);
    }
}
