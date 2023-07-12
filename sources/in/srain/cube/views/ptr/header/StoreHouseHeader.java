package in.srain.cube.views.ptr.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import java.util.ArrayList;
import tb.rx1;
import tb.sx1;
import tb.wg2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class StoreHouseHeader extends View implements PtrUIHandler {
    private AniController mAniController;
    private float mBarDarkAlpha;
    private int mDrawZoneHeight;
    private int mDrawZoneWidth;
    private int mDropHeight;
    private float mFromAlpha;
    private int mHorizontalRandomness;
    private float mInternalAnimationFactor;
    private boolean mIsInLoading;
    public ArrayList<StoreHouseBarItem> mItemList;
    private int mLineWidth;
    private int mLoadingAniDuration;
    private int mLoadingAniItemDuration;
    private int mLoadingAniSegDuration;
    private int mOffsetX;
    private int mOffsetY;
    private float mProgress;
    private float mScale;
    private int mTextColor;
    private float mToAlpha;
    private Transformation mTransformation;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class AniController implements Runnable {
        private int mCountPerSeg;
        private int mInterval;
        private boolean mRunning;
        private int mSegCount;
        private int mTick;

        private AniController() {
            this.mTick = 0;
            this.mCountPerSeg = 0;
            this.mSegCount = 0;
            this.mInterval = 0;
            this.mRunning = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void start() {
            this.mRunning = true;
            this.mTick = 0;
            this.mInterval = StoreHouseHeader.this.mLoadingAniDuration / StoreHouseHeader.this.mItemList.size();
            this.mCountPerSeg = StoreHouseHeader.this.mLoadingAniSegDuration / this.mInterval;
            this.mSegCount = (StoreHouseHeader.this.mItemList.size() / this.mCountPerSeg) + 1;
            run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stop() {
            this.mRunning = false;
            StoreHouseHeader.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.mTick % this.mCountPerSeg;
            for (int i2 = 0; i2 < this.mSegCount; i2++) {
                int i3 = (this.mCountPerSeg * i2) + i;
                if (i3 <= this.mTick) {
                    StoreHouseBarItem storeHouseBarItem = StoreHouseHeader.this.mItemList.get(i3 % StoreHouseHeader.this.mItemList.size());
                    storeHouseBarItem.setFillAfter(false);
                    storeHouseBarItem.setFillEnabled(true);
                    storeHouseBarItem.setFillBefore(false);
                    storeHouseBarItem.setDuration(StoreHouseHeader.this.mLoadingAniItemDuration);
                    storeHouseBarItem.start(StoreHouseHeader.this.mFromAlpha, StoreHouseHeader.this.mToAlpha);
                }
            }
            this.mTick++;
            if (this.mRunning) {
                StoreHouseHeader.this.postDelayed(this, this.mInterval);
            }
        }
    }

    public StoreHouseHeader(Context context) {
        super(context);
        this.mItemList = new ArrayList<>();
        this.mLineWidth = -1;
        this.mScale = 1.0f;
        this.mDropHeight = -1;
        this.mInternalAnimationFactor = 0.7f;
        this.mHorizontalRandomness = -1;
        this.mProgress = 0.0f;
        this.mDrawZoneWidth = 0;
        this.mDrawZoneHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBarDarkAlpha = 0.4f;
        this.mFromAlpha = 1.0f;
        this.mToAlpha = 0.4f;
        this.mLoadingAniDuration = 1000;
        this.mLoadingAniSegDuration = 1000;
        this.mLoadingAniItemDuration = 400;
        this.mTransformation = new Transformation();
        this.mIsInLoading = false;
        this.mAniController = new AniController();
        this.mTextColor = -1;
        initView();
    }

    private void beginLoading() {
        this.mIsInLoading = true;
        this.mAniController.start();
        invalidate();
    }

    private int getBottomOffset() {
        return getPaddingBottom() + sx1.a(10.0f);
    }

    private int getTopOffset() {
        return getPaddingTop() + sx1.a(10.0f);
    }

    private void initView() {
        sx1.b(getContext());
        this.mLineWidth = sx1.a(1.0f);
        this.mDropHeight = sx1.a(40.0f);
        this.mHorizontalRandomness = sx1.a / 2;
    }

    private void loadFinish() {
        this.mIsInLoading = false;
        this.mAniController.stop();
    }

    private void setProgress(float f) {
        this.mProgress = f;
    }

    public int getLoadingAniDuration() {
        return this.mLoadingAniDuration;
    }

    public float getScale() {
        return this.mScale;
    }

    public void initWithPointList(ArrayList<float[]> arrayList) {
        boolean z = this.mItemList.size() > 0;
        this.mItemList.clear();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < arrayList.size(); i++) {
            float[] fArr = arrayList.get(i);
            PointF pointF = new PointF(sx1.a(fArr[0]) * this.mScale, sx1.a(fArr[1]) * this.mScale);
            PointF pointF2 = new PointF(sx1.a(fArr[2]) * this.mScale, sx1.a(fArr[3]) * this.mScale);
            f = Math.max(Math.max(f, pointF.x), pointF2.x);
            f2 = Math.max(Math.max(f2, pointF.y), pointF2.y);
            StoreHouseBarItem storeHouseBarItem = new StoreHouseBarItem(i, pointF, pointF2, this.mTextColor, this.mLineWidth);
            storeHouseBarItem.resetPosition(this.mHorizontalRandomness);
            this.mItemList.add(storeHouseBarItem);
        }
        this.mDrawZoneWidth = (int) Math.ceil(f);
        this.mDrawZoneHeight = (int) Math.ceil(f2);
        if (z) {
            requestLayout();
        }
    }

    public void initWithString(String str) {
        initWithString(str, 25);
    }

    public void initWithStringArray(int i) {
        String[] stringArray = getResources().getStringArray(i);
        ArrayList<float[]> arrayList = new ArrayList<>();
        for (String str : stringArray) {
            String[] split = str.split(",");
            float[] fArr = new float[4];
            for (int i2 = 0; i2 < 4; i2++) {
                fArr[i2] = Float.parseFloat(split[i2]);
            }
            arrayList.add(fArr);
        }
        initWithPointList(arrayList);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.mProgress;
        int save = canvas.save();
        int size = this.mItemList.size();
        for (int i = 0; i < size; i++) {
            canvas.save();
            StoreHouseBarItem storeHouseBarItem = this.mItemList.get(i);
            PointF pointF = storeHouseBarItem.midPoint;
            float f2 = this.mOffsetX + pointF.x;
            float f3 = this.mOffsetY + pointF.y;
            if (this.mIsInLoading) {
                storeHouseBarItem.getTransformation(getDrawingTime(), this.mTransformation);
                canvas.translate(f2, f3);
            } else if (f == 0.0f) {
                storeHouseBarItem.resetPosition(this.mHorizontalRandomness);
            } else {
                float f4 = this.mInternalAnimationFactor;
                float f5 = ((1.0f - f4) * i) / size;
                float f6 = (1.0f - f4) - f5;
                if (f != 1.0f && f < 1.0f - f6) {
                    float min = f > f5 ? Math.min(1.0f, (f - f5) / f4) : 0.0f;
                    float f7 = 1.0f - min;
                    float f8 = f2 + (storeHouseBarItem.translationX * f7);
                    float f9 = f3 + ((-this.mDropHeight) * f7);
                    Matrix matrix = new Matrix();
                    matrix.postRotate(360.0f * min);
                    matrix.postScale(min, min);
                    matrix.postTranslate(f8, f9);
                    storeHouseBarItem.setAlpha(this.mBarDarkAlpha * min);
                    canvas.concat(matrix);
                } else {
                    canvas.translate(f2, f3);
                    storeHouseBarItem.setAlpha(this.mBarDarkAlpha);
                }
            }
            storeHouseBarItem.draw(canvas);
            canvas.restore();
        }
        if (this.mIsInLoading) {
            invalidate();
        }
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getTopOffset() + this.mDrawZoneHeight + getBottomOffset(), 1073741824));
        this.mOffsetX = (getMeasuredWidth() - this.mDrawZoneWidth) / 2;
        this.mOffsetY = getTopOffset();
        this.mDropHeight = getTopOffset();
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, rx1 rx1Var) {
        setProgress(Math.min(1.0f, rx1Var.c()));
        invalidate();
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshBegin(PtrFrameLayout ptrFrameLayout) {
        beginLoading();
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshComplete(PtrFrameLayout ptrFrameLayout) {
        loadFinish();
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshPrepare(PtrFrameLayout ptrFrameLayout) {
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIReset(PtrFrameLayout ptrFrameLayout) {
        loadFinish();
        for (int i = 0; i < this.mItemList.size(); i++) {
            this.mItemList.get(i).resetPosition(this.mHorizontalRandomness);
        }
    }

    public StoreHouseHeader setDropHeight(int i) {
        this.mDropHeight = i;
        return this;
    }

    public StoreHouseHeader setLineWidth(int i) {
        this.mLineWidth = i;
        for (int i2 = 0; i2 < this.mItemList.size(); i2++) {
            this.mItemList.get(i2).setLineWidth(i);
        }
        return this;
    }

    public void setLoadingAniDuration(int i) {
        this.mLoadingAniDuration = i;
        this.mLoadingAniSegDuration = i;
    }

    public void setScale(float f) {
        this.mScale = f;
    }

    public StoreHouseHeader setTextColor(int i) {
        this.mTextColor = i;
        for (int i2 = 0; i2 < this.mItemList.size(); i2++) {
            this.mItemList.get(i2).setColor(i);
        }
        return this;
    }

    public void initWithString(String str, int i) {
        initWithPointList(wg2.b(str, i * 0.01f, 14));
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemList = new ArrayList<>();
        this.mLineWidth = -1;
        this.mScale = 1.0f;
        this.mDropHeight = -1;
        this.mInternalAnimationFactor = 0.7f;
        this.mHorizontalRandomness = -1;
        this.mProgress = 0.0f;
        this.mDrawZoneWidth = 0;
        this.mDrawZoneHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBarDarkAlpha = 0.4f;
        this.mFromAlpha = 1.0f;
        this.mToAlpha = 0.4f;
        this.mLoadingAniDuration = 1000;
        this.mLoadingAniSegDuration = 1000;
        this.mLoadingAniItemDuration = 400;
        this.mTransformation = new Transformation();
        this.mIsInLoading = false;
        this.mAniController = new AniController();
        this.mTextColor = -1;
        initView();
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mItemList = new ArrayList<>();
        this.mLineWidth = -1;
        this.mScale = 1.0f;
        this.mDropHeight = -1;
        this.mInternalAnimationFactor = 0.7f;
        this.mHorizontalRandomness = -1;
        this.mProgress = 0.0f;
        this.mDrawZoneWidth = 0;
        this.mDrawZoneHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBarDarkAlpha = 0.4f;
        this.mFromAlpha = 1.0f;
        this.mToAlpha = 0.4f;
        this.mLoadingAniDuration = 1000;
        this.mLoadingAniSegDuration = 1000;
        this.mLoadingAniItemDuration = 400;
        this.mTransformation = new Transformation();
        this.mIsInLoading = false;
        this.mAniController = new AniController();
        this.mTextColor = -1;
        initView();
    }
}
