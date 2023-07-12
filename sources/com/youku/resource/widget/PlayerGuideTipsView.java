package com.youku.resource.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.youku.motioncurvex.MotionCurveXOvershootInterpolator;
import com.youku.motioncurvex.MotionCurveXStandardInterpolator;
import com.youku.resource.R;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayerGuideTipsView extends FrameLayout {
    public static final int ANIM_DURATION_ALPHA = 230;
    private final int ANIM_DURATION_SCALE;
    private final float ANIM_SCALE_INIT_VALUE;
    private final float ANIM_SCALE_OVERSHOT_VALUE;
    private final int SIZE_MARGIN_HORIZONTAL;
    private final float SIZE_TRIANGLE_BOTTOM_EDGE;
    private final float SIZE_TRIANGLE_BOTTOM_OVERLAP;
    private final int SIZE_TRIANGLE_HORIZONTAL_MARGIN;
    private final float SIZE_TRIANGLE_TOP_EDGE;
    private final float SIZE_TRIANGLE_TOP_OVERLAP;
    private View mAnimView;
    private ViewGroup mHolderView;
    private Paint mPaint;
    private TextView mTipsView;
    private Bitmap mTriangleBottom;
    private Bitmap mTriangleTop;
    private GuideTipsType mType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.resource.widget.PlayerGuideTipsView$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType;

        static {
            int[] iArr = new int[GuideTipsType.values().length];
            $SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType = iArr;
            try {
                iArr[GuideTipsType.BOTTOM_RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType[GuideTipsType.BOTTOM_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType[GuideTipsType.BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType[GuideTipsType.TOP_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType[GuideTipsType.TOP_CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType[GuideTipsType.TOP_LEFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum GuideTipsType {
        BOTTOM_RIGHT,
        BOTTOM_CENTER,
        BOTTOM_LEFT,
        TOP_RIGHT,
        TOP_CENTER,
        TOP_LEFT
    }

    public PlayerGuideTipsView(Context context) {
        super(context);
        this.SIZE_TRIANGLE_HORIZONTAL_MARGIN = 25;
        this.SIZE_TRIANGLE_TOP_OVERLAP = 2.0f;
        this.SIZE_TRIANGLE_BOTTOM_OVERLAP = 5.0f;
        this.SIZE_TRIANGLE_TOP_EDGE = 5.0f;
        this.SIZE_TRIANGLE_BOTTOM_EDGE = 10.0f;
        this.SIZE_MARGIN_HORIZONTAL = 20;
        this.ANIM_DURATION_SCALE = 400;
        this.ANIM_SCALE_INIT_VALUE = 0.4f;
        this.ANIM_SCALE_OVERSHOT_VALUE = 1.13f;
        this.mType = GuideTipsType.BOTTOM_RIGHT;
        initView();
    }

    public static int dp2px(Context context, float f) {
        if (context == null) {
            return 0;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void drawBottomTriangle(Canvas canvas, int i) {
        int height = (getHeight() - this.mTriangleBottom.getHeight()) - dp2px(getContext(), 5.0f);
        Log.d("helen", "drawBottomTriangle:" + dp2px(getContext(), 5.0f));
        canvas.drawBitmap(this.mTriangleBottom, new Rect(0, 0, this.mTriangleBottom.getWidth(), this.mTriangleBottom.getHeight()), new Rect(i, height, this.mTriangleBottom.getWidth() + i, this.mTriangleBottom.getHeight() + height), this.mPaint);
    }

    private void drawTopTriangle(Canvas canvas, int i) {
        Rect rect = new Rect(0, 0, this.mTriangleTop.getWidth(), this.mTriangleTop.getHeight());
        int dp2px = dp2px(getContext(), 2.0f);
        canvas.drawBitmap(this.mTriangleTop, rect, new Rect(i, dp2px, this.mTriangleTop.getWidth() + i, this.mTriangleTop.getHeight() + dp2px), this.mPaint);
    }

    private void drawTriangle(Canvas canvas) {
        switch (AnonymousClass2.$SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType[this.mType.ordinal()]) {
            case 1:
                drawTopTriangle(canvas, dp2px(getContext(), 25.0f));
                return;
            case 2:
                drawTopTriangle(canvas, (getWidth() - this.mTriangleBottom.getWidth()) / 2);
                return;
            case 3:
                drawTopTriangle(canvas, (getWidth() - this.mTriangleBottom.getWidth()) - dp2px(getContext(), 25.0f));
                return;
            case 4:
                drawBottomTriangle(canvas, dp2px(getContext(), 25.0f));
                return;
            case 5:
                drawBottomTriangle(canvas, (getWidth() - this.mTriangleBottom.getWidth()) / 2);
                return;
            case 6:
                drawBottomTriangle(canvas, (getWidth() - this.mTriangleBottom.getWidth()) - dp2px(getContext(), 25.0f));
                return;
            default:
                return;
        }
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.C8074layout.resource_yk_guide_tips_layout, this);
        this.mHolderView = (ViewGroup) findViewById(R.id.v_tips_root_holder);
        this.mAnimView = findViewById(R.id.v_anim_bg);
        this.mTipsView = (TextView) findViewById(R.id.tv_tips);
        this.mHolderView.bringChildToFront(findViewById(R.id.ll_tips_holder));
        this.mTriangleTop = BitmapFactory.decodeResource(getResources(), R.C8072drawable.yk_guide_tips_triangle_top);
        this.mTriangleBottom = BitmapFactory.decodeResource(getResources(), R.C8072drawable.yk_guide_tips_triangle_bottom);
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        setTipsType(GuideTipsType.TOP_RIGHT);
    }

    private void updateMargin(int i, int i2, int i3, int i4) {
        ViewGroup viewGroup = this.mHolderView;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setPadding(i, i2, i3, i4);
        this.mHolderView.setClipToPadding(false);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        boolean drawChild = super.drawChild(canvas, view, j);
        drawTriangle(canvas);
        canvas.restoreToCount(saveLayer);
        return drawChild;
    }

    public int getBottomTriangleHorizon2Edge() {
        int dp2px = dp2px(getContext(), 25.0f);
        Bitmap bitmap = this.mTriangleBottom;
        return dp2px + (bitmap == null ? 0 : bitmap.getWidth() / 2);
    }

    public int getTopTriangleHorizontal2Edge() {
        int dp2px = dp2px(getContext(), 25.0f);
        Bitmap bitmap = this.mTriangleTop;
        return dp2px + (bitmap == null ? 0 : bitmap.getWidth() / 2);
    }

    public int getTriangleBottomEdge() {
        return dp2px(getContext(), 10.0f);
    }

    public int getTriangleTopEdge() {
        return dp2px(getContext(), 5.0f);
    }

    public void hide() {
        if (getVisibility() == 8) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.yk_amin_guide_tips_alpha_hide);
        loadAnimation.setFillAfter(false);
        setVisibility(8);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.resource.widget.PlayerGuideTipsView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Log.w("helen", "onAnimationEnd:" + this);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        startAnimation(loadAnimation);
    }

    public void setTipsText(String str) {
        this.mTipsView.setText(str);
    }

    public void setTipsType(GuideTipsType guideTipsType) {
        this.mType = guideTipsType;
        switch (AnonymousClass2.$SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType[guideTipsType.ordinal()]) {
            case 1:
                updateMargin(0, this.mTriangleTop.getHeight(), dp2px(getContext(), 20.0f), 0);
                return;
            case 2:
                int height = this.mTriangleTop.getHeight();
                int dp2px = dp2px(getContext(), 20.0f);
                updateMargin(dp2px, height, dp2px, 0);
                return;
            case 3:
                updateMargin(dp2px(getContext(), 20.0f), this.mTriangleTop.getHeight(), 0, 0);
                return;
            case 4:
                updateMargin(0, 0, dp2px(getContext(), 20.0f), this.mTriangleBottom.getHeight());
                return;
            case 5:
                int height2 = this.mTriangleBottom.getHeight();
                int dp2px2 = dp2px(getContext(), 20.0f);
                updateMargin(dp2px2, 0, dp2px2, height2);
                return;
            case 6:
                updateMargin(dp2px(getContext(), 20.0f), 0, 0, this.mTriangleBottom.getHeight());
                return;
            default:
                return;
        }
    }

    public void show() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        switch (AnonymousClass2.$SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType[this.mType.ordinal()]) {
            case 1:
            case 4:
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.4f, 1.0f, 1.0f, 1.0f, 1, 0.0f, 1, 1.0f);
                scaleAnimation.setDuration(400L);
                scaleAnimation.setInterpolator(new MotionCurveXOvershootInterpolator());
                this.mAnimView.startAnimation(scaleAnimation);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(230L);
                alphaAnimation.setInterpolator(new MotionCurveXStandardInterpolator());
                startAnimation(alphaAnimation);
                return;
            case 2:
            case 5:
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.4f, 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, 1.0f);
                scaleAnimation2.setDuration(400L);
                scaleAnimation2.setInterpolator(new MotionCurveXOvershootInterpolator());
                this.mAnimView.startAnimation(scaleAnimation2);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setDuration(230L);
                alphaAnimation2.setInterpolator(new MotionCurveXStandardInterpolator());
                startAnimation(alphaAnimation2);
                return;
            case 3:
            case 6:
                ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.4f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 1.0f);
                scaleAnimation3.setDuration(400L);
                scaleAnimation3.setInterpolator(new MotionCurveXOvershootInterpolator());
                this.mAnimView.startAnimation(scaleAnimation3);
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation3.setDuration(230L);
                alphaAnimation3.setInterpolator(new MotionCurveXStandardInterpolator());
                startAnimation(alphaAnimation3);
                return;
            default:
                return;
        }
    }

    public PlayerGuideTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.SIZE_TRIANGLE_HORIZONTAL_MARGIN = 25;
        this.SIZE_TRIANGLE_TOP_OVERLAP = 2.0f;
        this.SIZE_TRIANGLE_BOTTOM_OVERLAP = 5.0f;
        this.SIZE_TRIANGLE_TOP_EDGE = 5.0f;
        this.SIZE_TRIANGLE_BOTTOM_EDGE = 10.0f;
        this.SIZE_MARGIN_HORIZONTAL = 20;
        this.ANIM_DURATION_SCALE = 400;
        this.ANIM_SCALE_INIT_VALUE = 0.4f;
        this.ANIM_SCALE_OVERSHOT_VALUE = 1.13f;
        this.mType = GuideTipsType.BOTTOM_RIGHT;
        initView();
    }

    public PlayerGuideTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.SIZE_TRIANGLE_HORIZONTAL_MARGIN = 25;
        this.SIZE_TRIANGLE_TOP_OVERLAP = 2.0f;
        this.SIZE_TRIANGLE_BOTTOM_OVERLAP = 5.0f;
        this.SIZE_TRIANGLE_TOP_EDGE = 5.0f;
        this.SIZE_TRIANGLE_BOTTOM_EDGE = 10.0f;
        this.SIZE_MARGIN_HORIZONTAL = 20;
        this.ANIM_DURATION_SCALE = 400;
        this.ANIM_SCALE_INIT_VALUE = 0.4f;
        this.ANIM_SCALE_OVERSHOT_VALUE = 1.13f;
        this.mType = GuideTipsType.BOTTOM_RIGHT;
        initView();
    }
}
