package com.youku.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baseproject.ui.R$drawable;
import com.baseproject.ui.R$id;
import com.baseproject.ui.R$styleable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ExpandableTextView extends LinearLayout implements View.OnClickListener {
    private static final float DEFAULT_ANIM_ALPHA_START = 0.7f;
    private static final int DEFAULT_ANIM_DURATION = 300;
    private static final int MAX_COLLAPSED_LINES = 8;
    private static final String TAG = "ExpandableTextView";
    private float mAnimAlphaStart;
    private boolean mAnimating;
    private int mAnimationDuration;
    protected ImageButton mButton;
    private Drawable mCollapseDrawable;
    private boolean mCollapsed;
    private int mCollapsedHeight;
    private SparseBooleanArray mCollapsedStatus;
    private Drawable mExpandDrawable;
    private int mMarginBetweenTxtAndBottom;
    private int mMaxCollapsedLines;
    private int mPosition;
    private boolean mRelayout;
    private int mTextHeightWithMaxLines;
    protected TextView mTv;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    protected class ExpandCollapseAnimation extends Animation {
        private final int mEndHeight;
        private final int mStartHeight;
        private final View mTargetView;

        public ExpandCollapseAnimation(View view, int i, int i2) {
            this.mTargetView = view;
            this.mStartHeight = i;
            this.mEndHeight = i2;
            setDuration(ExpandableTextView.this.mAnimationDuration);
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            int i = this.mEndHeight;
            int i2 = this.mStartHeight;
            int i3 = (int) (((i - i2) * f) + i2);
            ExpandableTextView expandableTextView = ExpandableTextView.this;
            expandableTextView.mTv.setMaxHeight(i3 - expandableTextView.mMarginBetweenTxtAndBottom);
            if (Float.compare(ExpandableTextView.this.mAnimAlphaStart, 1.0f) != 0) {
                ExpandableTextView expandableTextView2 = ExpandableTextView.this;
                ExpandableTextView.applyAlphaAnimation(expandableTextView2.mTv, expandableTextView2.mAnimAlphaStart + (f * (1.0f - ExpandableTextView.this.mAnimAlphaStart)));
            }
            this.mTargetView.getLayoutParams().height = i3;
            this.mTargetView.requestLayout();
        }

        @Override // android.view.animation.Animation
        public void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.mCollapsed = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public static void applyAlphaAnimation(View view, float f) {
        if (isPostHoneycomb()) {
            view.setAlpha(f);
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f);
        alphaAnimation.setDuration(0L);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    private void findViews() {
        TextView textView = (TextView) findViewById(R$id.expandable_text);
        this.mTv = textView;
        textView.setOnClickListener(this);
        ImageButton imageButton = (ImageButton) findViewById(R$id.expand_collapse);
        this.mButton = imageButton;
        imageButton.setImageDrawable(this.mCollapsed ? this.mExpandDrawable : this.mCollapseDrawable);
        this.mButton.setOnClickListener(this);
    }

    private static int getRealTextViewHeight(TextView textView) {
        return textView.getLayout().getLineTop(textView.getLineCount()) + textView.getCompoundPaddingTop() + textView.getCompoundPaddingBottom();
    }

    private void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ExpandableTextView);
        this.mMaxCollapsedLines = obtainStyledAttributes.getInt(R$styleable.ExpandableTextView_maxCollapsedLines, 8);
        this.mAnimationDuration = obtainStyledAttributes.getInt(R$styleable.ExpandableTextView_animDuration, 300);
        this.mAnimAlphaStart = obtainStyledAttributes.getFloat(R$styleable.ExpandableTextView_animAlphaStart, 0.7f);
        this.mExpandDrawable = obtainStyledAttributes.getDrawable(R$styleable.ExpandableTextView_expandDrawable);
        this.mCollapseDrawable = obtainStyledAttributes.getDrawable(R$styleable.ExpandableTextView_collapseDrawable);
        if (this.mExpandDrawable == null) {
            this.mExpandDrawable = getResources().getDrawable(R$drawable.ic_expand_small_holo_light);
        }
        if (this.mCollapseDrawable == null) {
            this.mCollapseDrawable = getResources().getDrawable(R$drawable.ic_collapse_small_holo_light);
        }
        obtainStyledAttributes.recycle();
    }

    private static boolean isPostHoneycomb() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public CharSequence getText() {
        TextView textView = this.mTv;
        return textView == null ? "" : textView.getText();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RotateAnimation rotateAnimation;
        ExpandCollapseAnimation expandCollapseAnimation;
        if (this.mButton.getVisibility() != 0) {
            return;
        }
        boolean z = !this.mCollapsed;
        this.mCollapsed = z;
        SparseBooleanArray sparseBooleanArray = this.mCollapsedStatus;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.put(this.mPosition, z);
        }
        this.mAnimating = true;
        if (this.mCollapsed) {
            rotateAnimation = new RotateAnimation(180.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            expandCollapseAnimation = new ExpandCollapseAnimation(this, getHeight(), this.mCollapsedHeight);
        } else {
            rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            expandCollapseAnimation = new ExpandCollapseAnimation(this, getHeight(), (getHeight() + this.mTextHeightWithMaxLines) - this.mTv.getHeight());
        }
        expandCollapseAnimation.setFillAfter(true);
        expandCollapseAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.widget.ExpandableTextView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ExpandableTextView.this.clearAnimation();
                ExpandableTextView.this.mAnimating = false;
                if (ExpandableTextView.this.mCollapsed) {
                    ExpandableTextView expandableTextView = ExpandableTextView.this;
                    expandableTextView.mTv.setMaxLines(expandableTextView.mMaxCollapsedLines);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                ExpandableTextView expandableTextView = ExpandableTextView.this;
                ExpandableTextView.applyAlphaAnimation(expandableTextView.mTv, expandableTextView.mAnimAlphaStart);
            }
        });
        clearAnimation();
        startAnimation(expandCollapseAnimation);
        rotateAnimation.setDuration(300L);
        rotateAnimation.setFillAfter(true);
        this.mButton.setAnimation(rotateAnimation);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        findViews();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mAnimating;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mRelayout && getVisibility() != 8) {
            this.mRelayout = false;
            this.mButton.setVisibility(8);
            this.mTv.setMaxLines(Integer.MAX_VALUE);
            this.mTv.setEllipsize(TextUtils.TruncateAt.END);
            super.onMeasure(i, i2);
            if (this.mTv.getLineCount() <= this.mMaxCollapsedLines) {
                return;
            }
            this.mTextHeightWithMaxLines = getRealTextViewHeight(this.mTv);
            if (this.mCollapsed) {
                this.mTv.setMaxLines(this.mMaxCollapsedLines);
                this.mTv.setEllipsize(TextUtils.TruncateAt.END);
            }
            this.mButton.setVisibility(0);
            super.onMeasure(i, i2);
            if (this.mCollapsed) {
                this.mTv.post(new Runnable() { // from class: com.youku.widget.ExpandableTextView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ExpandableTextView expandableTextView = ExpandableTextView.this;
                        expandableTextView.mMarginBetweenTxtAndBottom = expandableTextView.getHeight() - ExpandableTextView.this.mTv.getHeight();
                    }
                });
                this.mCollapsedHeight = getMeasuredHeight();
                return;
            }
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setText(CharSequence charSequence) {
        this.mRelayout = true;
        this.mTv.setText(charSequence);
        setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCollapsed = true;
        init(attributeSet);
    }

    public void setText(CharSequence charSequence, SparseBooleanArray sparseBooleanArray, int i) {
        this.mCollapsedStatus = sparseBooleanArray;
        this.mPosition = i;
        boolean z = sparseBooleanArray.get(i, true);
        clearAnimation();
        this.mCollapsed = z;
        this.mButton.setImageDrawable(z ? this.mExpandDrawable : this.mCollapseDrawable);
        setText(charSequence);
        getLayoutParams().height = -2;
        requestLayout();
    }

    @TargetApi(11)
    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCollapsed = true;
        init(attributeSet);
    }
}
