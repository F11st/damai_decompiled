package com.youku.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YoukuRoundImageView extends ImageView {
    private Bitmap bitmap;
    private Rect bitmapRect;
    private Bitmap mDstB;
    private Paint paint;
    private PaintFlagsDrawFilter pdf;
    private PorterDuffXfermode xfermode;

    public YoukuRoundImageView(Context context) {
        super(context);
        this.bitmapRect = new Rect();
        this.pdf = new PaintFlagsDrawFilter(0, 3);
        this.paint = new Paint();
        this.mDstB = null;
        this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setFlags(1);
        this.paint.setAntiAlias(true);
        init();
    }

    private void init() {
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                setLayerType(1, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Bitmap makeDst(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(Color.parseColor("#ffffffff"));
        canvas.drawOval(new RectF(0.0f, 0.0f, i, i2), paint);
        return createBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.bitmap == null) {
            return;
        }
        if (this.mDstB == null) {
            this.mDstB = makeDst(getWidth(), getHeight());
        }
        this.bitmapRect.set(0, 0, getWidth(), getHeight());
        canvas.save();
        canvas.setDrawFilter(this.pdf);
        canvas.drawBitmap(this.mDstB, 0.0f, 0.0f, this.paint);
        this.paint.setXfermode(this.xfermode);
        canvas.drawBitmap(this.bitmap, (Rect) null, this.bitmapRect, this.paint);
        this.paint.setXfermode(null);
        canvas.restore();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            this.bitmap = ((BitmapDrawable) drawable).getBitmap();
        }
    }

    public YoukuRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bitmapRect = new Rect();
        this.pdf = new PaintFlagsDrawFilter(0, 3);
        this.paint = new Paint();
        this.mDstB = null;
        this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setFlags(1);
        this.paint.setAntiAlias(true);
        init();
    }

    public YoukuRoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bitmapRect = new Rect();
        this.pdf = new PaintFlagsDrawFilter(0, 3);
        this.paint = new Paint();
        this.mDstB = null;
        this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setFlags(1);
        this.paint.setAntiAlias(true);
        init();
    }
}
