package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.FloatLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.view.GravityCompat;
import com.google.android.material.badge.BadgeDrawable;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class MotionLabel extends View implements FloatLayout {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    static String TAG = "MotionLabel";
    private boolean mAutoSize;
    private int mAutoSizeTextType;
    float mBackgroundPanX;
    float mBackgroundPanY;
    private float mBaseTextSize;
    private float mDeltaLeft;
    private float mFloatHeight;
    private float mFloatWidth;
    private String mFontFamily;
    private int mGravity;
    private Layout mLayout;
    boolean mNotBuilt;
    Matrix mOutlinePositionMatrix;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    TextPaint mPaint;
    Path mPath;
    RectF mRect;
    float mRotate;
    private float mRound;
    private float mRoundPercent;
    private int mStyleIndex;
    Paint mTempPaint;
    Rect mTempRect;
    private String mText;
    private Drawable mTextBackground;
    private Bitmap mTextBackgroundBitmap;
    private Rect mTextBounds;
    private int mTextFillColor;
    private int mTextOutlineColor;
    private float mTextOutlineThickness;
    private float mTextPanX;
    private float mTextPanY;
    private BitmapShader mTextShader;
    private Matrix mTextShaderMatrix;
    private float mTextSize;
    private int mTextureEffect;
    private float mTextureHeight;
    private float mTextureWidth;
    private CharSequence mTransformed;
    private int mTypefaceIndex;
    private boolean mUseOutline;
    ViewOutlineProvider mViewOutlineProvider;
    float mZoom;
    Paint paintCache;
    float paintTextSize;

    public MotionLabel(Context context) {
        super(context);
        this.mPaint = new TextPaint();
        this.mPath = new Path();
        this.mTextFillColor = 65535;
        this.mTextOutlineColor = 65535;
        this.mUseOutline = false;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mTextSize = 48.0f;
        this.mBaseTextSize = Float.NaN;
        this.mTextOutlineThickness = 0.0f;
        this.mText = "Hello World";
        this.mNotBuilt = true;
        this.mTextBounds = new Rect();
        this.mPaddingLeft = 1;
        this.mPaddingRight = 1;
        this.mPaddingTop = 1;
        this.mPaddingBottom = 1;
        this.mGravity = BadgeDrawable.TOP_START;
        this.mAutoSizeTextType = 0;
        this.mAutoSize = false;
        this.mTextureHeight = Float.NaN;
        this.mTextureWidth = Float.NaN;
        this.mTextPanX = 0.0f;
        this.mTextPanY = 0.0f;
        this.paintCache = new Paint();
        this.mTextureEffect = 0;
        this.mBackgroundPanX = Float.NaN;
        this.mBackgroundPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(context, null);
    }

    private void adjustTexture(float f, float f2, float f3, float f4) {
        if (this.mTextShaderMatrix == null) {
            return;
        }
        this.mFloatWidth = f3 - f;
        this.mFloatHeight = f4 - f2;
        updateShaderMatrix();
    }

    private float getHorizontalOffset() {
        float f = Float.isNaN(this.mBaseTextSize) ? 1.0f : this.mTextSize / this.mBaseTextSize;
        TextPaint textPaint = this.mPaint;
        String str = this.mText;
        return (((((Float.isNaN(this.mFloatWidth) ? getMeasuredWidth() : this.mFloatWidth) - getPaddingLeft()) - getPaddingRight()) - (f * textPaint.measureText(str, 0, str.length()))) * (this.mTextPanX + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f = Float.isNaN(this.mBaseTextSize) ? 1.0f : this.mTextSize / this.mBaseTextSize;
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        float measuredHeight = ((Float.isNaN(this.mFloatHeight) ? getMeasuredHeight() : this.mFloatHeight) - getPaddingTop()) - getPaddingBottom();
        float f2 = fontMetrics.descent;
        float f3 = fontMetrics.ascent;
        return (((measuredHeight - ((f2 - f3) * f)) * (1.0f - this.mTextPanY)) / 2.0f) - (f * f3);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setUpTheme(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLabel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.MotionLabel_android_text) {
                    setText(obtainStyledAttributes.getText(index));
                } else if (index == R.styleable.MotionLabel_android_fontFamily) {
                    this.mFontFamily = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MotionLabel_scaleFromTextSize) {
                    this.mBaseTextSize = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.mBaseTextSize);
                } else if (index == R.styleable.MotionLabel_android_textSize) {
                    this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.mTextSize);
                } else if (index == R.styleable.MotionLabel_android_textStyle) {
                    this.mStyleIndex = obtainStyledAttributes.getInt(index, this.mStyleIndex);
                } else if (index == R.styleable.MotionLabel_android_typeface) {
                    this.mTypefaceIndex = obtainStyledAttributes.getInt(index, this.mTypefaceIndex);
                } else if (index == R.styleable.MotionLabel_android_textColor) {
                    this.mTextFillColor = obtainStyledAttributes.getColor(index, this.mTextFillColor);
                } else if (index == R.styleable.MotionLabel_borderRound) {
                    float dimension = obtainStyledAttributes.getDimension(index, this.mRound);
                    this.mRound = dimension;
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(dimension);
                    }
                } else if (index == R.styleable.MotionLabel_borderRoundPercent) {
                    float f = obtainStyledAttributes.getFloat(index, this.mRoundPercent);
                    this.mRoundPercent = f;
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRoundPercent(f);
                    }
                } else if (index == R.styleable.MotionLabel_android_gravity) {
                    setGravity(obtainStyledAttributes.getInt(index, -1));
                } else if (index == R.styleable.MotionLabel_android_autoSizeTextType) {
                    this.mAutoSizeTextType = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.MotionLabel_textOutlineColor) {
                    this.mTextOutlineColor = obtainStyledAttributes.getInt(index, this.mTextOutlineColor);
                    this.mUseOutline = true;
                } else if (index == R.styleable.MotionLabel_textOutlineThickness) {
                    this.mTextOutlineThickness = obtainStyledAttributes.getDimension(index, this.mTextOutlineThickness);
                    this.mUseOutline = true;
                } else if (index == R.styleable.MotionLabel_textBackground) {
                    this.mTextBackground = obtainStyledAttributes.getDrawable(index);
                    this.mUseOutline = true;
                } else if (index == R.styleable.MotionLabel_textBackgroundPanX) {
                    this.mBackgroundPanX = obtainStyledAttributes.getFloat(index, this.mBackgroundPanX);
                } else if (index == R.styleable.MotionLabel_textBackgroundPanY) {
                    this.mBackgroundPanY = obtainStyledAttributes.getFloat(index, this.mBackgroundPanY);
                } else if (index == R.styleable.MotionLabel_textPanX) {
                    this.mTextPanX = obtainStyledAttributes.getFloat(index, this.mTextPanX);
                } else if (index == R.styleable.MotionLabel_textPanY) {
                    this.mTextPanY = obtainStyledAttributes.getFloat(index, this.mTextPanY);
                } else if (index == R.styleable.MotionLabel_textBackgroundRotate) {
                    this.mRotate = obtainStyledAttributes.getFloat(index, this.mRotate);
                } else if (index == R.styleable.MotionLabel_textBackgroundZoom) {
                    this.mZoom = obtainStyledAttributes.getFloat(index, this.mZoom);
                } else if (index == R.styleable.MotionLabel_textureHeight) {
                    this.mTextureHeight = obtainStyledAttributes.getDimension(index, this.mTextureHeight);
                } else if (index == R.styleable.MotionLabel_textureWidth) {
                    this.mTextureWidth = obtainStyledAttributes.getDimension(index, this.mTextureWidth);
                } else if (index == R.styleable.MotionLabel_textureEffect) {
                    this.mTextureEffect = obtainStyledAttributes.getInt(index, this.mTextureEffect);
                }
            }
            obtainStyledAttributes.recycle();
        }
        setupTexture();
        setupPath();
    }

    private void setTypefaceFromAttrs(String str, int i, int i2) {
        Typeface typeface;
        Typeface create;
        if (str != null) {
            typeface = Typeface.create(str, i2);
            if (typeface != null) {
                setTypeface(typeface);
                return;
            }
        } else {
            typeface = null;
        }
        if (i == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i == 2) {
            typeface = Typeface.SERIF;
        } else if (i == 3) {
            typeface = Typeface.MONOSPACE;
        }
        if (i2 > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i2);
            } else {
                create = Typeface.create(typeface, i2);
            }
            setTypeface(create);
            int i3 = (~(create != null ? create.getStyle() : 0)) & i2;
            this.mPaint.setFakeBoldText((i3 & 1) != 0);
            this.mPaint.setTextSkewX((i3 & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.mPaint.setFakeBoldText(false);
        this.mPaint.setTextSkewX(0.0f);
        setTypeface(typeface);
    }

    private void setUpTheme(Context context, @Nullable AttributeSet attributeSet) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true);
        TextPaint textPaint = this.mPaint;
        int i = typedValue.data;
        this.mTextFillColor = i;
        textPaint.setColor(i);
    }

    private void setupTexture() {
        if (this.mTextBackground != null) {
            this.mTextShaderMatrix = new Matrix();
            int intrinsicWidth = this.mTextBackground.getIntrinsicWidth();
            int intrinsicHeight = this.mTextBackground.getIntrinsicHeight();
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                intrinsicWidth = Float.isNaN(this.mTextureWidth) ? 128 : (int) this.mTextureWidth;
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                intrinsicHeight = Float.isNaN(this.mTextureHeight) ? 128 : (int) this.mTextureHeight;
            }
            if (this.mTextureEffect != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.mTextBackgroundBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.mTextBackgroundBitmap);
            this.mTextBackground.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.mTextBackground.setFilterBitmap(true);
            this.mTextBackground.draw(canvas);
            if (this.mTextureEffect != 0) {
                this.mTextBackgroundBitmap = blur(this.mTextBackgroundBitmap, 4);
            }
            Bitmap bitmap = this.mTextBackgroundBitmap;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.mTextShader = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    private void updateShaderMatrix() {
        float f = Float.isNaN(this.mBackgroundPanX) ? 0.0f : this.mBackgroundPanX;
        float f2 = Float.isNaN(this.mBackgroundPanY) ? 0.0f : this.mBackgroundPanY;
        float f3 = Float.isNaN(this.mZoom) ? 1.0f : this.mZoom;
        float f4 = Float.isNaN(this.mRotate) ? 0.0f : this.mRotate;
        this.mTextShaderMatrix.reset();
        float width = this.mTextBackgroundBitmap.getWidth();
        float height = this.mTextBackgroundBitmap.getHeight();
        float f5 = Float.isNaN(this.mTextureWidth) ? this.mFloatWidth : this.mTextureWidth;
        float f6 = Float.isNaN(this.mTextureHeight) ? this.mFloatHeight : this.mTextureHeight;
        float f7 = f3 * (width * f6 < height * f5 ? f5 / width : f6 / height);
        this.mTextShaderMatrix.postScale(f7, f7);
        float f8 = width * f7;
        float f9 = f5 - f8;
        float f10 = f7 * height;
        float f11 = f6 - f10;
        if (!Float.isNaN(this.mTextureHeight)) {
            f11 = this.mTextureHeight / 2.0f;
        }
        if (!Float.isNaN(this.mTextureWidth)) {
            f9 = this.mTextureWidth / 2.0f;
        }
        this.mTextShaderMatrix.postTranslate((((f * f9) + f5) - f8) * 0.5f, (((f2 * f11) + f6) - f10) * 0.5f);
        this.mTextShaderMatrix.postRotate(f4, f5 / 2.0f, f6 / 2.0f);
        this.mTextShader.setLocalMatrix(this.mTextShaderMatrix);
    }

    Bitmap blur(Bitmap bitmap, int i) {
        System.nanoTime();
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        for (int i2 = 0; i2 < i && width >= 32 && height >= 32; i2++) {
            width /= 2;
            height /= 2;
            createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, width, height, true);
        }
        return createScaledBitmap;
    }

    void buildShape(float f) {
        if (this.mUseOutline || f != 1.0f) {
            this.mPath.reset();
            String str = this.mText;
            int length = str.length();
            this.mPaint.getTextBounds(str, 0, length, this.mTextBounds);
            this.mPaint.getTextPath(str, 0, length, 0.0f, 0.0f, this.mPath);
            if (f != 1.0f) {
                Log.v(TAG, Debug.getLoc() + " scale " + f);
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                this.mPath.transform(matrix);
            }
            Rect rect = this.mTextBounds;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = getHeight();
            rectF.right = getWidth();
            this.mNotBuilt = false;
        }
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getScaleFromTextSize() {
        return this.mBaseTextSize;
    }

    public float getTextBackgroundPanX() {
        return this.mBackgroundPanX;
    }

    public float getTextBackgroundPanY() {
        return this.mBackgroundPanY;
    }

    public float getTextBackgroundRotate() {
        return this.mRotate;
    }

    public float getTextBackgroundZoom() {
        return this.mZoom;
    }

    public int getTextOutlineColor() {
        return this.mTextOutlineColor;
    }

    public float getTextPanX() {
        return this.mTextPanX;
    }

    public float getTextPanY() {
        return this.mTextPanY;
    }

    public float getTextureHeight() {
        return this.mTextureHeight;
    }

    public float getTextureWidth() {
        return this.mTextureWidth;
    }

    public Typeface getTypeface() {
        return this.mPaint.getTypeface();
    }

    @Override // android.view.View
    public void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
        boolean isNaN = Float.isNaN(this.mBaseTextSize);
        float f = isNaN ? 1.0f : this.mTextSize / this.mBaseTextSize;
        this.mFloatWidth = i3 - i;
        this.mFloatHeight = i4 - i2;
        if (this.mAutoSize) {
            if (this.mTempRect == null) {
                this.mTempPaint = new Paint();
                this.mTempRect = new Rect();
                this.mTempPaint.set(this.mPaint);
                this.paintTextSize = this.mTempPaint.getTextSize();
            }
            Paint paint = this.mTempPaint;
            String str = this.mText;
            paint.getTextBounds(str, 0, str.length(), this.mTempRect);
            int width = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mTempRect);
            int height = (int) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.mTempRect) * 1.3f);
            float f2 = (this.mFloatWidth - this.mPaddingRight) - this.mPaddingLeft;
            float f3 = (this.mFloatHeight - this.mPaddingBottom) - this.mPaddingTop;
            if (isNaN) {
                float f4 = width;
                float f5 = height;
                if (f4 * f3 > f5 * f2) {
                    this.mPaint.setTextSize((this.paintTextSize * f2) / f4);
                } else {
                    this.mPaint.setTextSize((this.paintTextSize * f3) / f5);
                }
            } else {
                float f6 = width;
                float f7 = height;
                f = f6 * f3 > f7 * f2 ? f2 / f6 : f3 / f7;
            }
        }
        if (this.mUseOutline || !isNaN) {
            adjustTexture(i, i2, i3, i4);
            buildShape(f);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f = Float.isNaN(this.mBaseTextSize) ? 1.0f : this.mTextSize / this.mBaseTextSize;
        super.onDraw(canvas);
        if (!this.mUseOutline && f == 1.0f) {
            canvas.drawText(this.mText, this.mDeltaLeft + this.mPaddingLeft + getHorizontalOffset(), this.mPaddingTop + getVerticalOffset(), this.mPaint);
            return;
        }
        if (this.mNotBuilt) {
            buildShape(f);
        }
        if (this.mOutlinePositionMatrix == null) {
            this.mOutlinePositionMatrix = new Matrix();
        }
        if (this.mUseOutline) {
            this.paintCache.set(this.mPaint);
            this.mOutlinePositionMatrix.reset();
            float horizontalOffset = this.mPaddingLeft + getHorizontalOffset();
            float verticalOffset = this.mPaddingTop + getVerticalOffset();
            this.mOutlinePositionMatrix.postTranslate(horizontalOffset, verticalOffset);
            this.mOutlinePositionMatrix.preScale(f, f);
            this.mPath.transform(this.mOutlinePositionMatrix);
            if (this.mTextShader != null) {
                this.mPaint.setFilterBitmap(true);
                this.mPaint.setShader(this.mTextShader);
            } else {
                this.mPaint.setColor(this.mTextFillColor);
            }
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
            canvas.drawPath(this.mPath, this.mPaint);
            if (this.mTextShader != null) {
                this.mPaint.setShader(null);
            }
            this.mPaint.setColor(this.mTextOutlineColor);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
            canvas.drawPath(this.mPath, this.mPaint);
            this.mOutlinePositionMatrix.reset();
            this.mOutlinePositionMatrix.postTranslate(-horizontalOffset, -verticalOffset);
            this.mPath.transform(this.mOutlinePositionMatrix);
            this.mPaint.set(this.paintCache);
            return;
        }
        float horizontalOffset2 = this.mPaddingLeft + getHorizontalOffset();
        float verticalOffset2 = this.mPaddingTop + getVerticalOffset();
        this.mOutlinePositionMatrix.reset();
        this.mOutlinePositionMatrix.preTranslate(horizontalOffset2, verticalOffset2);
        this.mPath.transform(this.mOutlinePositionMatrix);
        this.mPaint.setColor(this.mTextFillColor);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        canvas.drawPath(this.mPath, this.mPaint);
        this.mOutlinePositionMatrix.reset();
        this.mOutlinePositionMatrix.preTranslate(-horizontalOffset2, -verticalOffset2);
        this.mPath.transform(this.mOutlinePositionMatrix);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.mAutoSize = false;
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
        if (mode == 1073741824 && mode2 == 1073741824) {
            if (this.mAutoSizeTextType != 0) {
                this.mAutoSize = true;
            }
        } else {
            TextPaint textPaint = this.mPaint;
            String str = this.mText;
            textPaint.getTextBounds(str, 0, str.length(), this.mTextBounds);
            if (mode != 1073741824) {
                size = (int) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mTextBounds) + 0.99999f);
            }
            size += this.mPaddingLeft + this.mPaddingRight;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (this.mPaint.getFontMetricsInt(null) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.mPaddingTop + this.mPaddingBottom + fontMetricsInt;
            }
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i) {
        if ((i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 0) {
            i |= GravityCompat.START;
        }
        if ((i & 112) == 0) {
            i |= 48;
        }
        if (i != this.mGravity) {
            invalidate();
        }
        this.mGravity = i;
        int i2 = i & 112;
        if (i2 == 48) {
            this.mTextPanY = -1.0f;
        } else if (i2 != 80) {
            this.mTextPanY = 0.0f;
        } else {
            this.mTextPanY = 1.0f;
        }
        int i3 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i3 != 3) {
            if (i3 != 5) {
                if (i3 != 8388611) {
                    if (i3 != 8388613) {
                        this.mTextPanX = 0.0f;
                        return;
                    }
                }
            }
            this.mTextPanX = 1.0f;
            return;
        }
        this.mTextPanX = -1.0f;
    }

    @RequiresApi(21)
    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.mRound = f;
            float f2 = this.mRoundPercent;
            this.mRoundPercent = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.mRound != f;
        this.mRound = f;
        if (f != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.mViewOutlineProvider == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionLabel.2
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.mRound);
                        }
                    };
                    this.mViewOutlineProvider = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
            this.mPath.reset();
            Path path = this.mPath;
            RectF rectF = this.mRect;
            float f3 = this.mRound;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (!z || Build.VERSION.SDK_INT < 21) {
            return;
        }
        invalidateOutline();
    }

    @RequiresApi(21)
    public void setRoundPercent(float f) {
        boolean z = this.mRoundPercent != f;
        this.mRoundPercent = f;
        if (f != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.mViewOutlineProvider == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionLabel.1
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            int width = MotionLabel.this.getWidth();
                            int height = MotionLabel.this.getHeight();
                            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * MotionLabel.this.mRoundPercent) / 2.0f);
                        }
                    };
                    this.mViewOutlineProvider = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.mRoundPercent) / 2.0f;
            this.mRect.set(0.0f, 0.0f, width, height);
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (!z || Build.VERSION.SDK_INT < 21) {
            return;
        }
        invalidateOutline();
    }

    public void setScaleFromTextSize(float f) {
        this.mBaseTextSize = f;
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f) {
        this.mBackgroundPanX = f;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundPanY(float f) {
        this.mBackgroundPanY = f;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundRotate(float f) {
        this.mRotate = f;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundZoom(float f) {
        this.mZoom = f;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextFillColor(int i) {
        this.mTextFillColor = i;
        invalidate();
    }

    public void setTextOutlineColor(int i) {
        this.mTextOutlineColor = i;
        this.mUseOutline = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f) {
        this.mTextOutlineThickness = f;
        this.mUseOutline = true;
        if (Float.isNaN(f)) {
            this.mTextOutlineThickness = 1.0f;
            this.mUseOutline = false;
        }
        invalidate();
    }

    public void setTextPanX(float f) {
        this.mTextPanX = f;
        invalidate();
    }

    public void setTextPanY(float f) {
        this.mTextPanY = f;
        invalidate();
    }

    public void setTextSize(float f) {
        this.mTextSize = f;
        String str = TAG;
        Log.v(str, Debug.getLoc() + AltriaXLaunchTime.SPACE + f + " / " + this.mBaseTextSize);
        TextPaint textPaint = this.mPaint;
        if (!Float.isNaN(this.mBaseTextSize)) {
            f = this.mBaseTextSize;
        }
        textPaint.setTextSize(f);
        buildShape(Float.isNaN(this.mBaseTextSize) ? 1.0f : this.mTextSize / this.mBaseTextSize);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f) {
        this.mTextureHeight = f;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextureWidth(float f) {
        this.mTextureWidth = f;
        updateShaderMatrix();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (this.mPaint.getTypeface() != typeface) {
            this.mPaint.setTypeface(typeface);
            if (this.mLayout != null) {
                this.mLayout = null;
                requestLayout();
                invalidate();
            }
        }
    }

    void setupPath() {
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
        setTypefaceFromAttrs(this.mFontFamily, this.mTypefaceIndex, this.mStyleIndex);
        this.mPaint.setColor(this.mTextFillColor);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setFlags(128);
        setTextSize(this.mTextSize);
        this.mPaint.setAntiAlias(true);
    }

    @Override // androidx.constraintlayout.motion.widget.FloatLayout
    public void layout(float f, float f2, float f3, float f4) {
        int i = (int) (f + 0.5f);
        this.mDeltaLeft = f - i;
        int i2 = (int) (f3 + 0.5f);
        int i3 = i2 - i;
        int i4 = (int) (f4 + 0.5f);
        int i5 = (int) (0.5f + f2);
        int i6 = i4 - i5;
        float f5 = f3 - f;
        this.mFloatWidth = f5;
        float f6 = f4 - f2;
        this.mFloatHeight = f6;
        adjustTexture(f, f2, f3, f4);
        if (getMeasuredHeight() == i6 && getMeasuredWidth() == i3) {
            super.layout(i, i5, i2, i4);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
            super.layout(i, i5, i2, i4);
        }
        if (this.mAutoSize) {
            if (this.mTempRect == null) {
                this.mTempPaint = new Paint();
                this.mTempRect = new Rect();
                this.mTempPaint.set(this.mPaint);
                this.paintTextSize = this.mTempPaint.getTextSize();
            }
            this.mFloatWidth = f5;
            this.mFloatHeight = f6;
            Paint paint = this.mTempPaint;
            String str = this.mText;
            paint.getTextBounds(str, 0, str.length(), this.mTempRect);
            float height = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.mTempRect) * 1.3f;
            float f7 = (f5 - this.mPaddingRight) - this.mPaddingLeft;
            float f8 = (f6 - this.mPaddingBottom) - this.mPaddingTop;
            float width = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mTempRect);
            if (width * f8 > height * f7) {
                this.mPaint.setTextSize((this.paintTextSize * f7) / width);
            } else {
                this.mPaint.setTextSize((this.paintTextSize * f8) / height);
            }
            if (this.mUseOutline || !Float.isNaN(this.mBaseTextSize)) {
                buildShape(Float.isNaN(this.mBaseTextSize) ? 1.0f : this.mTextSize / this.mBaseTextSize);
            }
        }
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new TextPaint();
        this.mPath = new Path();
        this.mTextFillColor = 65535;
        this.mTextOutlineColor = 65535;
        this.mUseOutline = false;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mTextSize = 48.0f;
        this.mBaseTextSize = Float.NaN;
        this.mTextOutlineThickness = 0.0f;
        this.mText = "Hello World";
        this.mNotBuilt = true;
        this.mTextBounds = new Rect();
        this.mPaddingLeft = 1;
        this.mPaddingRight = 1;
        this.mPaddingTop = 1;
        this.mPaddingBottom = 1;
        this.mGravity = BadgeDrawable.TOP_START;
        this.mAutoSizeTextType = 0;
        this.mAutoSize = false;
        this.mTextureHeight = Float.NaN;
        this.mTextureWidth = Float.NaN;
        this.mTextPanX = 0.0f;
        this.mTextPanY = 0.0f;
        this.paintCache = new Paint();
        this.mTextureEffect = 0;
        this.mBackgroundPanX = Float.NaN;
        this.mBackgroundPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(context, attributeSet);
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new TextPaint();
        this.mPath = new Path();
        this.mTextFillColor = 65535;
        this.mTextOutlineColor = 65535;
        this.mUseOutline = false;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mTextSize = 48.0f;
        this.mBaseTextSize = Float.NaN;
        this.mTextOutlineThickness = 0.0f;
        this.mText = "Hello World";
        this.mNotBuilt = true;
        this.mTextBounds = new Rect();
        this.mPaddingLeft = 1;
        this.mPaddingRight = 1;
        this.mPaddingTop = 1;
        this.mPaddingBottom = 1;
        this.mGravity = BadgeDrawable.TOP_START;
        this.mAutoSizeTextType = 0;
        this.mAutoSize = false;
        this.mTextureHeight = Float.NaN;
        this.mTextureWidth = Float.NaN;
        this.mTextPanX = 0.0f;
        this.mTextPanY = 0.0f;
        this.paintCache = new Paint();
        this.mTextureEffect = 0;
        this.mBackgroundPanX = Float.NaN;
        this.mBackgroundPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(context, attributeSet);
    }
}
