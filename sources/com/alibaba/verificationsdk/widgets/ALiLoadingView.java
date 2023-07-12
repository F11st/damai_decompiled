package com.alibaba.verificationsdk.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ALiLoadingView extends View {
    private final int ROTATE_STEP;
    private boolean mClockwise;
    private Context mContext;
    private Bitmap mForeBitmap;
    private int mHeight;
    private boolean mIsAnimation;
    private Matrix mMatrix;
    private PaintFlagsDrawFilter mPaintFlagsDrawFilter;
    private int mType;
    private int mWidth;
    private int rotate;

    public ALiLoadingView(Context context) {
        super(context);
        this.ROTATE_STEP = 10;
        this.mMatrix = new Matrix();
        this.mClockwise = true;
        this.mType = 0;
        this.mContext = context;
        init();
    }

    private int getResID() {
        int i = this.mType;
        if (i != 0) {
            if (i != 1) {
                return getResources().getIdentifier("ali_vsdk_shadu_icon_dengdai", "drawable", this.mContext.getPackageName());
            }
            return getResources().getIdentifier("ali_vsdk_button_icon_dengdai", "drawable", this.mContext.getPackageName());
        }
        return getResources().getIdentifier("ali_vsdk_shadu_icon_dengdai", "drawable", this.mContext.getPackageName());
    }

    private static Object getResourceId(Context context, String str, String str2) {
        Class<?>[] classes;
        Field[] fields;
        try {
            for (Class<?> cls : Class.forName(context.getPackageName() + ".R").getClasses()) {
                if (cls.getSimpleName().equals(str2)) {
                    for (Field field : cls.getFields()) {
                        String name = field.getName();
                        if (name.equals(str)) {
                            System.out.println(name);
                            return field.get(null);
                        }
                    }
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getStyleable(Context context, String str) {
        return ((Integer) getResourceId(context, str, "styleable")).intValue();
    }

    public static int[] getStyleableArray(Context context, String str) {
        return (int[]) getResourceId(context, str, "styleable");
    }

    private void init() {
        this.mPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, 3);
        this.mForeBitmap = ((BitmapDrawable) this.mContext.getResources().getDrawable(getResID())).getBitmap();
        invalidate();
    }

    protected void onDeAttachedToWindow() {
        stopRotationAnimation();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mForeBitmap.isRecycled() && this.mIsAnimation) {
            init();
        }
        if (this.mForeBitmap.isRecycled()) {
            return;
        }
        this.mMatrix.setRotate(this.rotate, this.mForeBitmap.getWidth() / 2, this.mForeBitmap.getHeight() / 2);
        canvas.setDrawFilter(this.mPaintFlagsDrawFilter);
        canvas.drawBitmap(this.mForeBitmap, this.mMatrix, null);
        if (this.mIsAnimation) {
            int i = this.rotate;
            int i2 = i + 10 > 360 ? 0 : i + 10;
            this.rotate = i2;
            if (!this.mClockwise) {
                i2 = -i2;
            }
            this.rotate = i2;
            postInvalidate();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = this.mForeBitmap.getWidth();
        int height = this.mForeBitmap.getHeight();
        this.mHeight = height;
        setMeasuredDimension(this.mWidth, height);
    }

    public void startRotationAnimation() {
        this.mIsAnimation = true;
        invalidate();
    }

    public void stopRotationAnimation() {
        this.mIsAnimation = false;
    }

    public ALiLoadingView(Context context, int i) {
        super(context);
        this.ROTATE_STEP = 10;
        this.mMatrix = new Matrix();
        this.mClockwise = true;
        this.mType = 0;
        this.mContext = context;
        this.mType = i;
        init();
    }

    public ALiLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ROTATE_STEP = 10;
        this.mMatrix = new Matrix();
        this.mClockwise = true;
        this.mType = 0;
        this.mContext = context;
        this.mType = 0;
        init();
    }
}
