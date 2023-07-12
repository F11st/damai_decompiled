package com.taobao.uikit.extend.feature.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.taobao.uikit.feature.view.IGetBitmap;
import com.taobao.uikit.utils.UIKITLog;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import tb.m12;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DrawableProxy extends Drawable implements IGetBitmap {
    private TUrlImageView mBindView;
    private boolean mIsRecovering = false;
    protected BitmapDrawable mRealDrawable;

    private DrawableProxy(BitmapDrawable bitmapDrawable) {
        this.mRealDrawable = bitmapDrawable;
    }

    public static DrawableProxy obtain(BitmapDrawable bitmapDrawable) {
        return new DrawableProxy(bitmapDrawable);
    }

    private void tryDowngrade2Passable() {
        BitmapDrawable bitmapDrawable = this.mRealDrawable;
        if (bitmapDrawable instanceof m12) {
            ((m12) bitmapDrawable).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DrawableProxy bindHostView(TUrlImageView tUrlImageView) {
        this.mBindView = tUrlImageView;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (recover()) {
            TUrlImageView tUrlImageView = this.mBindView;
            UIKITLog.i(TUrlImageView.LOG_TAG, "recover on draw, width=%d, height=%d, id=%s, url=%s", Integer.valueOf(canvas.getWidth()), Integer.valueOf(canvas.getHeight()), tUrlImageView, tUrlImageView.getLoadingUrl());
            return;
        }
        BitmapDrawable bitmapDrawable = this.mRealDrawable;
        if (bitmapDrawable != null) {
            bitmapDrawable.setChangingConfigurations(getChangingConfigurations());
            this.mRealDrawable.setBounds(getBounds());
            this.mRealDrawable.setCallback(getCallback());
            this.mRealDrawable.draw(canvas);
            this.mRealDrawable.setCallback(null);
        }
    }

    @Override // com.taobao.uikit.feature.view.IGetBitmap
    public Bitmap getBitmap() {
        if (this.mRealDrawable == null) {
            return null;
        }
        tryDowngrade2Passable();
        return this.mRealDrawable.getBitmap();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        BitmapDrawable bitmapDrawable = this.mRealDrawable;
        if (bitmapDrawable != null) {
            return bitmapDrawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        BitmapDrawable bitmapDrawable = this.mRealDrawable;
        if (bitmapDrawable != null) {
            return bitmapDrawable.getIntrinsicHeight();
        }
        return super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        BitmapDrawable bitmapDrawable = this.mRealDrawable;
        if (bitmapDrawable != null) {
            return bitmapDrawable.getIntrinsicWidth();
        }
        return super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        BitmapDrawable bitmapDrawable = this.mRealDrawable;
        if (bitmapDrawable != null) {
            return bitmapDrawable.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        BitmapDrawable bitmapDrawable = this.mRealDrawable;
        if (bitmapDrawable != null) {
            return bitmapDrawable.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        BitmapDrawable bitmapDrawable = this.mRealDrawable;
        if (bitmapDrawable != null) {
            return bitmapDrawable.getOpacity();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        BitmapDrawable bitmapDrawable = this.mRealDrawable;
        if (bitmapDrawable != null) {
            return bitmapDrawable.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable getRealDrawable(boolean z) {
        if (!z) {
            tryDowngrade2Passable();
        }
        return this.mRealDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        BitmapDrawable bitmapDrawable = this.mRealDrawable;
        if (bitmapDrawable != null) {
            return bitmapDrawable.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        BitmapDrawable bitmapDrawable = this.mRealDrawable;
        if (bitmapDrawable != null) {
            bitmapDrawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isContentDifferent(Drawable drawable) {
        return drawable instanceof DrawableProxy ? this.mRealDrawable != ((DrawableProxy) drawable).mRealDrawable : this != drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        BitmapDrawable bitmapDrawable = this.mRealDrawable;
        if (bitmapDrawable != null) {
            return bitmapDrawable.isStateful();
        }
        return super.isStateful();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean recover() {
        BitmapDrawable bitmapDrawable;
        TUrlImageView tUrlImageView;
        if (this.mIsRecovering || (((bitmapDrawable = this.mRealDrawable) != null && (bitmapDrawable.getBitmap() == null || !this.mRealDrawable.getBitmap().isRecycled())) || (tUrlImageView = this.mBindView) == null)) {
            return false;
        }
        this.mIsRecovering = true;
        tUrlImageView.reload();
        return true;
    }

    public synchronized boolean release() {
        BitmapDrawable bitmapDrawable = this.mRealDrawable;
        if (bitmapDrawable == null) {
            return false;
        }
        if (bitmapDrawable instanceof m12) {
            ((m12) bitmapDrawable).b();
        }
        this.mRealDrawable = null;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        BitmapDrawable bitmapDrawable = this.mRealDrawable;
        if (bitmapDrawable != null) {
            bitmapDrawable.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        BitmapDrawable bitmapDrawable = this.mRealDrawable;
        if (bitmapDrawable != null) {
            bitmapDrawable.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        BitmapDrawable bitmapDrawable = this.mRealDrawable;
        if (bitmapDrawable != null) {
            bitmapDrawable.setDither(z);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        BitmapDrawable bitmapDrawable = this.mRealDrawable;
        if (bitmapDrawable != null) {
            bitmapDrawable.setFilterBitmap(z);
            invalidateSelf();
        }
    }

    public String toString() {
        return "DrawableProxy@" + Integer.toHexString(hashCode());
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, PorterDuff.Mode mode) {
        BitmapDrawable bitmapDrawable = this.mRealDrawable;
        if (bitmapDrawable != null) {
            bitmapDrawable.setColorFilter(i, mode);
        }
    }
}
