package com.youku.danmaku.engine.danmaku.model.android;

import android.annotation.SuppressLint;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import com.youku.danmaku.engine.danmaku.model.AbsDisplayer;
import com.youku.danmaku.engine.danmaku.model.AlphaValue;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuEngineContext;
import com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer;
import com.youku.danmaku.engine.danmaku.model.android.stuffer.SimpleTextCacheStuffer;
import com.youku.danmaku.engine.danmaku.model.style.BaseExtraStyle;
import com.youku.danmaku.engine.danmaku.util.Log;
import com.youku.danmaku.plugin.DanmakuPluginManager;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AndroidDisplayer extends AbsDisplayer<Canvas, Typeface> {
    public Canvas canvas;
    private int height;
    private IDanmakuSettingPlugin mDanmakuSettingPlugin;
    private float mDanmakuSpacing;
    private int width;
    private Camera camera = new Camera();
    private Matrix matrix = new Matrix();
    private final DisplayConfig mDisplayConfig = new DisplayConfig();
    private BaseCacheStuffer sStuffer = new SimpleTextCacheStuffer();
    private float density = 1.0f;
    private int densityDpi = 160;
    private float scaledDensity = 1.0f;
    private int mSlopPixel = 0;
    private boolean mIsHardwareAccelerated = true;
    private int mMaximumBitmapWidth = 2048;
    private int mMaximumBitmapHeight = 2048;

    private void calcPaintWH(BaseDanmaku baseDanmaku, TextPaint textPaint, boolean z) {
        this.sStuffer.measure(baseDanmaku, textPaint, z, this.mDisplayConfig);
        setDanmakuPaintWidthAndHeight(baseDanmaku, baseDanmaku.paintWidth, baseDanmaku.paintHeight);
    }

    private float getLineHeight() {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null) {
            return iDanmakuSettingPlugin.getLineHeight();
        }
        return 24.0f * DanmakuEngineContext.getDensity();
    }

    private float getLineSpace() {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null) {
            return iDanmakuSettingPlugin.getLineSpace();
        }
        return 6.0f * DanmakuEngineContext.getDensity();
    }

    @SuppressLint({"NewApi"})
    private static final int getMaximumBitmapHeight(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 14) {
            return canvas.getMaximumBitmapHeight();
        }
        return canvas.getHeight();
    }

    @SuppressLint({"NewApi"})
    private static final int getMaximumBitmapWidth(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 14) {
            return canvas.getMaximumBitmapWidth();
        }
        return canvas.getWidth();
    }

    private synchronized TextPaint getPaint(BaseDanmaku baseDanmaku, boolean z) {
        return this.mDisplayConfig.getPaint(baseDanmaku, z);
    }

    private void resetPaintAlpha(Paint paint) {
        int alpha = paint.getAlpha();
        int i = AlphaValue.MAX;
        if (alpha != i) {
            paint.setAlpha(i);
        }
    }

    private void restoreCanvas(Canvas canvas) {
        canvas.restore();
    }

    private int saveCanvas(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2) {
        this.camera.save();
        this.camera.rotateY(-baseDanmaku.rotationY);
        this.camera.rotateZ(-baseDanmaku.rotationZ);
        this.camera.getMatrix(this.matrix);
        this.matrix.preTranslate(-f, -f2);
        this.matrix.postTranslate(f, f2);
        this.camera.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    private void setDanmakuPaintWidthAndHeight(BaseDanmaku baseDanmaku, float f, float f2) {
        if (baseDanmaku.mExtraStyle == null) {
            float lineSpace = f2 + getLineSpace();
            if (baseDanmaku.borderColor != 0 || baseDanmaku.ykHasBorder) {
                f = f + (this.mDisplayConfig.BORDER_WIDTH * 2.0f) + getLineHeight();
            }
            baseDanmaku.paintWidth = f + getStrokeWidth();
            baseDanmaku.paintHeight = lineSpace;
        }
    }

    private void update(Canvas canvas) {
        this.canvas = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.mIsHardwareAccelerated) {
                this.mMaximumBitmapWidth = getMaximumBitmapWidth(canvas);
                this.mMaximumBitmapHeight = getMaximumBitmapHeight(canvas);
            }
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.AbsDisplayer
    public void clearTextHeightCache() {
        this.sStuffer.clearCaches();
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public int draw(BaseDanmaku baseDanmaku) {
        Paint paint;
        boolean z;
        BaseExtraStyle baseExtraStyle;
        boolean z2;
        boolean z3;
        float top = baseDanmaku.getTop() + this.mDisplayConfig.mALlMarginTop;
        float left = baseDanmaku.getLeft();
        if (this.canvas != null) {
            Paint paint2 = null;
            int i = 1;
            if (baseDanmaku.getType() != 7) {
                paint = null;
                z = false;
            } else if (baseDanmaku.alpha == AlphaValue.TRANSPARENT) {
                return 0;
            } else {
                if (baseDanmaku.rotationZ == 0.0f && baseDanmaku.rotationY == 0.0f) {
                    z3 = false;
                } else {
                    saveCanvas(baseDanmaku, this.canvas, left, top);
                    z3 = true;
                }
                if (baseDanmaku.alpha != AlphaValue.MAX) {
                    paint2 = this.mDisplayConfig.ALPHA_PAINT;
                    paint2.setAlpha(baseDanmaku.alpha);
                }
                paint = paint2;
                z = z3;
            }
            if (paint == null || paint.getAlpha() != AlphaValue.TRANSPARENT) {
                if (baseDanmaku.mExtraStyle != null) {
                    top += baseExtraStyle.getTopPadding();
                    z2 = baseDanmaku.mExtraStyle.isAniImage();
                } else {
                    z2 = false;
                }
                if (!(z2 ? false : this.sStuffer.drawCache(baseDanmaku, this.canvas, left, top, paint))) {
                    if (paint != null) {
                        Log.e("cacheDrawn" + paint.getAlpha());
                        this.mDisplayConfig.PAINT.setAlpha(paint.getAlpha());
                        this.mDisplayConfig.PAINT_DUPLICATE.setAlpha(paint.getAlpha());
                    }
                    drawDanmaku(baseDanmaku, this.canvas, left, top, false);
                    i = 2;
                }
                if (z) {
                    restoreCanvas(this.canvas);
                }
                return i;
            }
            return 0;
        }
        return 0;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.AbsDisplayer
    public BaseCacheStuffer getCacheStuffer() {
        return this.sStuffer;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.AbsDisplayer, com.youku.danmaku.engine.danmaku.model.IDisplayer
    public IDanmakuSettingPlugin getDanmakuSettingPlugin() {
        return this.mDanmakuSettingPlugin;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public float getDensity() {
        return this.density;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public int getDensityDpi() {
        return this.densityDpi;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public int getHeight() {
        return this.height;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public int getMaximumCacheHeight() {
        return this.mMaximumBitmapHeight;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public int getMaximumCacheWidth() {
        return this.mMaximumBitmapWidth;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public float getScaledDensity() {
        return this.scaledDensity;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public int getSlopPixel() {
        return this.mSlopPixel;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public float getSpacing() {
        return 0.0f;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public float getStrokeWidth() {
        return this.mDisplayConfig.getStrokeWidth();
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public int getWidth() {
        return this.width;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.AbsDisplayer, com.youku.danmaku.engine.danmaku.model.IDisplayer
    public boolean isHardwareAccelerated() {
        return this.mIsHardwareAccelerated;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public void measure(BaseDanmaku baseDanmaku, boolean z) {
        TextPaint paint = getPaint(baseDanmaku, z);
        DisplayConfig displayConfig = this.mDisplayConfig;
        if (displayConfig.HAS_STROKE) {
            displayConfig.applyPaintConfig(baseDanmaku, paint, true);
        }
        calcPaintWH(baseDanmaku, paint, z);
        DisplayConfig displayConfig2 = this.mDisplayConfig;
        if (displayConfig2.HAS_STROKE) {
            displayConfig2.applyPaintConfig(baseDanmaku, paint, false);
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public void recycle(BaseDanmaku baseDanmaku) {
        BaseCacheStuffer baseCacheStuffer = this.sStuffer;
        if (baseCacheStuffer != null) {
            baseCacheStuffer.releaseResource(baseDanmaku);
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public void resetSlopPixel(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.mSlopPixel = (int) max;
        if (f > 1.0f) {
            this.mSlopPixel = (int) (max * f);
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.AbsDisplayer
    public void setAllmargin(float f) {
        this.mDisplayConfig.mALlMarginTop = f;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.AbsDisplayer
    public void setCacheStuffer(BaseCacheStuffer baseCacheStuffer) {
        if (baseCacheStuffer != this.sStuffer) {
            this.sStuffer = baseCacheStuffer;
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.AbsDisplayer, com.youku.danmaku.engine.danmaku.model.IDisplayer
    public void setDanmakuPlugin(DanmakuPluginManager danmakuPluginManager) {
        if (danmakuPluginManager != null) {
            IDanmakuSettingPlugin danmakuSettingPlugin = danmakuPluginManager.getDanmakuSettingPlugin();
            this.mDanmakuSettingPlugin = danmakuSettingPlugin;
            this.mDisplayConfig.setDanmakuSettingPlugin(danmakuSettingPlugin);
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public void setDanmakuStyle(int i, float[] fArr) {
        if (i != -1) {
            if (i == 0) {
                DisplayConfig displayConfig = this.mDisplayConfig;
                displayConfig.CONFIG_HAS_SHADOW = false;
                displayConfig.CONFIG_HAS_STROKE = false;
                displayConfig.CONFIG_HAS_PROJECTION = false;
                return;
            } else if (i == 1) {
                DisplayConfig displayConfig2 = this.mDisplayConfig;
                displayConfig2.CONFIG_HAS_SHADOW = true;
                displayConfig2.CONFIG_HAS_STROKE = false;
                displayConfig2.CONFIG_HAS_PROJECTION = false;
                setShadowRadius(fArr[0]);
                return;
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                DisplayConfig displayConfig3 = this.mDisplayConfig;
                displayConfig3.CONFIG_HAS_SHADOW = false;
                displayConfig3.CONFIG_HAS_STROKE = false;
                displayConfig3.CONFIG_HAS_PROJECTION = true;
                setProjectionConfig(fArr[0], fArr[1], (int) fArr[2]);
                return;
            }
        }
        DisplayConfig displayConfig4 = this.mDisplayConfig;
        displayConfig4.CONFIG_HAS_SHADOW = false;
        displayConfig4.CONFIG_HAS_STROKE = true;
        displayConfig4.CONFIG_HAS_PROJECTION = false;
        setPaintStrokeWidth(fArr[0]);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public void setDensities(float f, int i, float f2) {
        this.density = f;
        this.mDanmakuSpacing = f * 10.0f;
        if (Log.isDebug()) {
            Log.d("AndroidDisplayer", "mDanmakuSpacing=" + this.mDanmakuSpacing);
        }
        this.densityDpi = i;
        this.scaledDensity = f2;
        DisplayConfig displayConfig = this.mDisplayConfig;
        displayConfig.getClass();
        displayConfig.mBorderRadius = (i / 160.0f) * 6.0f;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.AbsDisplayer
    public void setFakeBoldText(boolean z) {
        this.mDisplayConfig.setFakeBoldText(z);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public void setHardwareAccelerated(boolean z) {
        this.mIsHardwareAccelerated = z;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.AbsDisplayer
    public void setPaintStrokeWidth(float f) {
        this.mDisplayConfig.setPaintStrokeWidth(f);
    }

    public void setProjectionConfig(float f, float f2, int i) {
        this.mDisplayConfig.setProjectionConfig(f, f2, i);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.AbsDisplayer
    public void setScaleTextSizeFactor(float f) {
        this.mDisplayConfig.setScaleTextSizeFactor(f);
    }

    public void setShadowRadius(float f) {
        this.mDisplayConfig.setShadowRadius(f);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.AbsDisplayer
    public void setTransparency(int i) {
        this.mDisplayConfig.setTransparency(i);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.AbsDisplayer
    public void drawDanmaku(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, boolean z) {
        BaseCacheStuffer baseCacheStuffer = this.sStuffer;
        if (baseCacheStuffer != null) {
            baseCacheStuffer.drawDanmaku(baseDanmaku, canvas, f, f2, z, this.mDisplayConfig);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.youku.danmaku.engine.danmaku.model.AbsDisplayer
    public Canvas getExtraData() {
        return this.canvas;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.AbsDisplayer
    public void setExtraData(Canvas canvas) {
        update(canvas);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.AbsDisplayer
    public void setIconPaintTypeFace(Typeface typeface) {
        this.mDisplayConfig.setIconPaintTypeFace(typeface);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.AbsDisplayer
    public void setTypeFace(Typeface typeface) {
        this.mDisplayConfig.setTypeFace(typeface);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class DisplayConfig {
        private Paint ALPHA_PAINT;
        private Paint BG_GRADIENTPAINT1;
        private Paint BG_GRADIENTPAINT2;
        private Paint BG_PAINT;
        private Paint BORDER_PAINT;
        public Paint LIKE_BG_PAINT;
        private TextPaint LIKE_PAINT;
        private TextPaint LIKE_PAINT_DUPLICATE;
        public TextPaint PAINT;
        public TextPaint PAINT_DUPLICATE;
        public TextPaint PAINT_ICON;
        public TextPaint PAINT_ICON_TEXT;
        public TextPaint STROKE_PAINT;
        public TextPaint STROKE_PAINT_DUPLICATE;
        public Paint TRAIN_BG_PAINT;
        private Paint UNDERLINE_PAINT;
        private Paint YK_BORDER_DUPLICATE;
        private Paint YK_BORDER_PAINT;
        private boolean isTranslucent;
        private Paint mBorderPaint1;
        private Paint mBorderPaint2;
        public float mBorderRadius;
        private IDanmakuSettingPlugin mDanmakuSettingPlugin;
        final int BORDER_RADIUS = 6;
        public int UNDERLINE_HEIGHT = 4;
        public float BORDER_WIDTH = 2.0f;
        private float SHADOW_RADIUS = 4.0f;
        public float STROKE_WIDTH = 0.5f;
        public float sProjectionOffsetX = 1.0f;
        public float sProjectionOffsetY = 1.0f;
        int sProjectionAlpha = 204;
        boolean CONFIG_HAS_SHADOW = false;
        public boolean HAS_SHADOW = false;
        boolean CONFIG_HAS_STROKE = true;
        public boolean HAS_STROKE = true;
        boolean CONFIG_HAS_PROJECTION = false;
        public boolean HAS_PROJECTION = false;
        boolean CONFIG_ANTI_ALIAS = true;
        private boolean ANTI_ALIAS = true;
        private int transparency = AlphaValue.MAX;
        private float mALlMarginTop = 0.0f;

        public DisplayConfig() {
            TextPaint textPaint = new TextPaint();
            this.PAINT = textPaint;
            textPaint.setStyle(Paint.Style.FILL);
            this.PAINT.setTypeface(Typeface.defaultFromStyle(1));
            this.PAINT.setAntiAlias(true);
            this.PAINT_DUPLICATE = new TextPaint(this.PAINT);
            TextPaint textPaint2 = new TextPaint();
            this.STROKE_PAINT = textPaint2;
            textPaint2.setStyle(Paint.Style.STROKE);
            this.STROKE_PAINT.setStrokeWidth(this.STROKE_WIDTH);
            this.STROKE_PAINT.setTypeface(Typeface.defaultFromStyle(1));
            this.STROKE_PAINT.setAntiAlias(true);
            this.STROKE_PAINT_DUPLICATE = new TextPaint(this.PAINT);
            TextPaint textPaint3 = new TextPaint();
            this.LIKE_PAINT = textPaint3;
            textPaint3.setAntiAlias(true);
            this.LIKE_PAINT_DUPLICATE = new TextPaint(this.LIKE_PAINT);
            this.ALPHA_PAINT = new Paint();
            Paint paint = new Paint();
            this.UNDERLINE_PAINT = paint;
            paint.setStrokeWidth(this.UNDERLINE_HEIGHT);
            this.UNDERLINE_PAINT.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.BORDER_PAINT = paint2;
            paint2.setStyle(Paint.Style.STROKE);
            this.BORDER_PAINT.setStrokeWidth(this.BORDER_WIDTH);
            this.BORDER_PAINT.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.YK_BORDER_PAINT = paint3;
            paint3.setStyle(Paint.Style.STROKE);
            this.YK_BORDER_PAINT.setStrokeWidth(this.BORDER_WIDTH);
            this.YK_BORDER_PAINT.setAntiAlias(true);
            this.YK_BORDER_DUPLICATE = new Paint(this.YK_BORDER_PAINT);
            Paint paint4 = new Paint();
            this.BG_PAINT = paint4;
            paint4.setStyle(Paint.Style.FILL);
            this.BG_PAINT.setAntiAlias(true);
            Paint paint5 = new Paint();
            this.BG_GRADIENTPAINT1 = paint5;
            paint5.setStyle(Paint.Style.FILL);
            this.BG_GRADIENTPAINT1.setAntiAlias(true);
            Paint paint6 = new Paint();
            this.BG_GRADIENTPAINT2 = paint6;
            paint6.setStyle(Paint.Style.FILL);
            this.BG_GRADIENTPAINT2.setAntiAlias(true);
            TextPaint textPaint4 = new TextPaint(1);
            this.PAINT_ICON = textPaint4;
            textPaint4.setTextAlign(Paint.Align.CENTER);
            this.PAINT_ICON.setAntiAlias(true);
            TextPaint textPaint5 = new TextPaint(this.PAINT);
            this.PAINT_ICON_TEXT = textPaint5;
            textPaint5.setAntiAlias(true);
            this.PAINT_ICON_TEXT.setAntiAlias(true);
            this.LIKE_BG_PAINT = new Paint();
            this.BG_PAINT.setStyle(Paint.Style.FILL);
            this.LIKE_BG_PAINT.setAntiAlias(true);
            Paint paint7 = new Paint();
            this.TRAIN_BG_PAINT = paint7;
            paint7.setAntiAlias(true);
            Paint paint8 = new Paint();
            this.mBorderPaint1 = paint8;
            paint8.setStyle(Paint.Style.STROKE);
            this.mBorderPaint1.setAntiAlias(true);
            Paint paint9 = new Paint();
            this.mBorderPaint2 = paint9;
            paint9.setStyle(Paint.Style.STROKE);
            this.mBorderPaint2.setAntiAlias(true);
        }

        private float getTextSize() {
            IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
            if (iDanmakuSettingPlugin != null) {
                return iDanmakuSettingPlugin.getTextSize();
            }
            return DanmakuEngineContext.getDensity() * 18.0f;
        }

        public synchronized void applyPaintConfig(BaseDanmaku baseDanmaku, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStrokeWidth(this.STROKE_WIDTH);
                    paint.setStyle(this.HAS_PROJECTION ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(baseDanmaku.textShadowColor & 16777215);
                    paint.setStrokeJoin(Paint.Join.BEVEL);
                    paint.setAlpha(this.HAS_PROJECTION ? (int) (this.sProjectionAlpha * (this.transparency / AlphaValue.MAX)) : this.transparency);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
                    if (iDanmakuSettingPlugin != null && iDanmakuSettingPlugin.enableColorFilter()) {
                        paint.setColor(16777215);
                    } else {
                        paint.setColor(baseDanmaku.textColor & 16777215);
                    }
                    paint.setAlpha(this.transparency);
                }
            } else if (z) {
                paint.setStyle(this.HAS_PROJECTION ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(baseDanmaku.textShadowColor & 16777215);
                paint.setStrokeWidth(this.STROKE_WIDTH);
                paint.setStrokeJoin(Paint.Join.BEVEL);
                paint.setAlpha(this.HAS_PROJECTION ? this.sProjectionAlpha : AlphaValue.MAX);
            } else {
                paint.setStyle(Paint.Style.FILL);
                IDanmakuSettingPlugin iDanmakuSettingPlugin2 = this.mDanmakuSettingPlugin;
                if (iDanmakuSettingPlugin2 != null && iDanmakuSettingPlugin2.enableColorFilter()) {
                    paint.setColor(16777215);
                } else {
                    paint.setColor(baseDanmaku.textColor & 16777215);
                }
                paint.setAlpha(AlphaValue.MAX);
            }
        }

        public void definePaintParams(boolean z) {
            this.HAS_STROKE = this.CONFIG_HAS_STROKE;
            this.HAS_SHADOW = this.CONFIG_HAS_SHADOW;
            this.HAS_PROJECTION = this.CONFIG_HAS_PROJECTION;
            this.ANTI_ALIAS = z && this.CONFIG_ANTI_ALIAS;
        }

        public Paint getAvatarBorderPaint(boolean z) {
            if (z) {
                Paint paint = this.mBorderPaint2;
                paint.set(this.mBorderPaint1);
                return paint;
            }
            return this.mBorderPaint1;
        }

        public Paint getBgPaint() {
            return this.BG_PAINT;
        }

        public Paint getBorderPaint(BaseDanmaku baseDanmaku) {
            IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
            if (iDanmakuSettingPlugin != null && iDanmakuSettingPlugin.enableColorFilter()) {
                this.BORDER_PAINT.setColor(16777215);
            } else {
                this.BORDER_PAINT.setColor(baseDanmaku.borderColor & 16777215);
            }
            this.BORDER_PAINT.setAlpha(getTransparency());
            return this.BORDER_PAINT;
        }

        public IDanmakuSettingPlugin getDanmakuSettingPlugin() {
            return this.mDanmakuSettingPlugin;
        }

        public Paint getGradientPaint(boolean z) {
            Paint paint;
            if (z) {
                paint = this.BG_GRADIENTPAINT2;
                paint.set(this.BG_GRADIENTPAINT1);
            } else {
                paint = this.BG_GRADIENTPAINT1;
            }
            paint.setAntiAlias(this.ANTI_ALIAS);
            return paint;
        }

        public TextPaint getLikePaint(BaseDanmaku baseDanmaku, boolean z) {
            TextPaint textPaint;
            int i;
            if (z) {
                textPaint = this.LIKE_PAINT_DUPLICATE;
                textPaint.set(this.LIKE_PAINT);
            } else {
                textPaint = this.LIKE_PAINT;
            }
            if (this.HAS_SHADOW) {
                float f = this.SHADOW_RADIUS;
                if (f > 0.0f && (i = baseDanmaku.textShadowColor) != 0) {
                    textPaint.setShadowLayer(f, 0.0f, 0.0f, i);
                    return textPaint;
                }
            }
            textPaint.clearShadowLayer();
            return textPaint;
        }

        public synchronized TextPaint getPaint(BaseDanmaku baseDanmaku, boolean z) {
            TextPaint textPaint;
            int i;
            if (z) {
                textPaint = this.PAINT_DUPLICATE;
                textPaint.set(this.PAINT);
            } else {
                textPaint = this.PAINT;
            }
            textPaint.setTextSize(getTextSize());
            if (this.HAS_SHADOW) {
                float f = this.SHADOW_RADIUS;
                if (f > 0.0f && (i = baseDanmaku.textShadowColor) != 0) {
                    textPaint.setShadowLayer(f, 0.0f, 0.0f, i);
                    textPaint.setAntiAlias(this.ANTI_ALIAS);
                }
            }
            textPaint.clearShadowLayer();
            textPaint.setAntiAlias(this.ANTI_ALIAS);
            return textPaint;
        }

        public TextPaint getStrokePaint(BaseDanmaku baseDanmaku, boolean z) {
            TextPaint textPaint;
            int i;
            if (z) {
                textPaint = this.STROKE_PAINT_DUPLICATE;
                textPaint.set(this.STROKE_PAINT);
            } else {
                textPaint = this.STROKE_PAINT;
            }
            textPaint.setTextSize(getTextSize());
            if (this.HAS_SHADOW) {
                float f = this.SHADOW_RADIUS;
                if (f > 0.0f && (i = baseDanmaku.textShadowColor) != 0) {
                    textPaint.setShadowLayer(f, 0.0f, 0.0f, i);
                    textPaint.setAntiAlias(this.ANTI_ALIAS);
                    return textPaint;
                }
            }
            textPaint.clearShadowLayer();
            textPaint.setAntiAlias(this.ANTI_ALIAS);
            return textPaint;
        }

        public float getStrokeWidth() {
            boolean z = this.HAS_SHADOW;
            if (z && this.HAS_STROKE) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (z) {
                return this.SHADOW_RADIUS;
            }
            if (this.HAS_STROKE) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public Paint getTrainBg() {
            return this.TRAIN_BG_PAINT;
        }

        public int getTransparency() {
            if (this.isTranslucent) {
                return this.transparency;
            }
            return AlphaValue.MAX;
        }

        public Paint getUnderlinePaint(BaseDanmaku baseDanmaku) {
            this.UNDERLINE_PAINT.setColor(baseDanmaku.underlineColor);
            return this.UNDERLINE_PAINT;
        }

        public Paint getYKBorderPaint(BaseDanmaku baseDanmaku, boolean z) {
            Paint paint;
            if (z) {
                paint = this.YK_BORDER_DUPLICATE;
                paint.set(this.YK_BORDER_PAINT);
            } else {
                paint = this.YK_BORDER_PAINT;
            }
            IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
            if (iDanmakuSettingPlugin != null && iDanmakuSettingPlugin.enableColorFilter()) {
                paint.setColor(16777215);
            } else {
                paint.setColor(baseDanmaku.textColor & 16777215);
            }
            paint.setAlpha(getTransparency());
            return paint;
        }

        public boolean hasStroke(BaseDanmaku baseDanmaku) {
            return (this.HAS_STROKE || this.HAS_PROJECTION) && this.STROKE_WIDTH > 0.0f && baseDanmaku.textShadowColor != 0;
        }

        public void setDanmakuSettingPlugin(IDanmakuSettingPlugin iDanmakuSettingPlugin) {
            this.mDanmakuSettingPlugin = iDanmakuSettingPlugin;
        }

        public void setFakeBoldText(boolean z) {
            this.PAINT.setFakeBoldText(z);
        }

        public void setIconPaintTypeFace(Typeface typeface) {
            TextPaint textPaint = this.PAINT_ICON;
            if (textPaint == null || typeface == null) {
                return;
            }
            textPaint.setTypeface(typeface);
            Log.d(Log.SETTING_TAG, "load icon font success");
        }

        public void setPaintStrokeWidth(float f) {
            this.PAINT.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void setProjectionConfig(float f, float f2, int i) {
            if (this.sProjectionOffsetX == f && this.sProjectionOffsetY == f2 && this.sProjectionAlpha == i) {
                return;
            }
            if (f <= 1.0f) {
                f = 1.0f;
            }
            this.sProjectionOffsetX = f;
            if (f2 <= 1.0f) {
                f2 = 1.0f;
            }
            this.sProjectionOffsetY = f2;
            if (i < 0) {
                i = 0;
            } else if (i > 255) {
                i = 255;
            }
            this.sProjectionAlpha = i;
        }

        public void setScaleTextSizeFactor(float f) {
        }

        public void setShadowRadius(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setTransparency(int i) {
            this.isTranslucent = i != AlphaValue.MAX;
            this.transparency = i;
        }

        public void setTypeFace(Typeface typeface) {
            TextPaint textPaint = this.PAINT;
            if (textPaint != null) {
                textPaint.setTypeface(typeface);
            }
        }

        public TextPaint getPaint(BaseDanmaku baseDanmaku) {
            return getPaint(baseDanmaku, false);
        }
    }
}
