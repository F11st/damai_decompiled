package cn.damai.commonbusiness.photoselect.photoview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class PhotoView extends ImageView {
    private static transient /* synthetic */ IpChange $ipChange;
    private PhotoViewAttacher attacher;
    private ImageView.ScaleType pendingScaleType;

    public PhotoView(Context context) {
        this(context, null);
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1294805150")) {
            ipChange.ipc$dispatch("-1294805150", new Object[]{this});
            return;
        }
        this.attacher = new PhotoViewAttacher(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.pendingScaleType;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.pendingScaleType = null;
        }
    }

    public PhotoViewAttacher getAttacher() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1649161530") ? (PhotoViewAttacher) ipChange.ipc$dispatch("1649161530", new Object[]{this}) : this.attacher;
    }

    public void getDisplayMatrix(Matrix matrix) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-80646761")) {
            ipChange.ipc$dispatch("-80646761", new Object[]{this, matrix});
        } else {
            this.attacher.D(matrix);
        }
    }

    public RectF getDisplayRect() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1406577541") ? (RectF) ipChange.ipc$dispatch("1406577541", new Object[]{this}) : this.attacher.E();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-916794568") ? (Matrix) ipChange.ipc$dispatch("-916794568", new Object[]{this}) : this.attacher.H();
    }

    public float getMaximumScale() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-313387320") ? ((Float) ipChange.ipc$dispatch("-313387320", new Object[]{this})).floatValue() : this.attacher.K();
    }

    public float getMediumScale() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "129348643") ? ((Float) ipChange.ipc$dispatch("129348643", new Object[]{this})).floatValue() : this.attacher.L();
    }

    public float getMinimumScale() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1423826250") ? ((Float) ipChange.ipc$dispatch("-1423826250", new Object[]{this})).floatValue() : this.attacher.M();
    }

    public float getScale() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1585215538") ? ((Float) ipChange.ipc$dispatch("-1585215538", new Object[]{this})).floatValue() : this.attacher.N();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1394995924") ? (ImageView.ScaleType) ipChange.ipc$dispatch("-1394995924", new Object[]{this}) : this.attacher.O();
    }

    public void getSuppMatrix(Matrix matrix) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1349027581")) {
            ipChange.ipc$dispatch("1349027581", new Object[]{this, matrix});
        } else {
            this.attacher.P(matrix);
        }
    }

    @Deprecated
    public boolean isZoomEnabled() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-296719816") ? ((Boolean) ipChange.ipc$dispatch("-296719816", new Object[]{this})).booleanValue() : this.attacher.R();
    }

    public boolean isZoomable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1159369121") ? ((Boolean) ipChange.ipc$dispatch("-1159369121", new Object[]{this})).booleanValue() : this.attacher.S();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "27117577")) {
            ipChange.ipc$dispatch("27117577", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.attacher.U(z);
        }
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "507928079") ? ((Boolean) ipChange.ipc$dispatch("507928079", new Object[]{this, matrix})).booleanValue() : this.attacher.V(matrix);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-124448981")) {
            return ((Boolean) ipChange.ipc$dispatch("-124448981", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})).booleanValue();
        }
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.attacher.t0();
        }
        return frame;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1587995809")) {
            ipChange.ipc$dispatch("-1587995809", new Object[]{this, drawable});
            return;
        }
        super.setImageDrawable(drawable);
        PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.t0();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-448480232")) {
            ipChange.ipc$dispatch("-448480232", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.setImageResource(i);
        PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.t0();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-84919422")) {
            ipChange.ipc$dispatch("-84919422", new Object[]{this, uri});
            return;
        }
        super.setImageURI(uri);
        PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.t0();
        }
    }

    public void setMaximumScale(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1626194164")) {
            ipChange.ipc$dispatch("1626194164", new Object[]{this, Float.valueOf(f)});
        } else {
            this.attacher.X(f);
        }
    }

    public void setMediumScale(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "634901345")) {
            ipChange.ipc$dispatch("634901345", new Object[]{this, Float.valueOf(f)});
        } else {
            this.attacher.Y(f);
        }
    }

    public void setMinimumScale(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1562325702")) {
            ipChange.ipc$dispatch("1562325702", new Object[]{this, Float.valueOf(f)});
        } else {
            this.attacher.Z(f);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "175889666")) {
            ipChange.ipc$dispatch("175889666", new Object[]{this, onClickListener});
        } else {
            this.attacher.a0(onClickListener);
        }
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1266138892")) {
            ipChange.ipc$dispatch("-1266138892", new Object[]{this, onDoubleTapListener});
        } else {
            this.attacher.b0(onDoubleTapListener);
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1297835646")) {
            ipChange.ipc$dispatch("-1297835646", new Object[]{this, onLongClickListener});
        } else {
            this.attacher.c0(onLongClickListener);
        }
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-319283927")) {
            ipChange.ipc$dispatch("-319283927", new Object[]{this, onMatrixChangedListener});
        } else {
            this.attacher.d0(onMatrixChangedListener);
        }
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1141096047")) {
            ipChange.ipc$dispatch("1141096047", new Object[]{this, onOutsidePhotoTapListener});
        } else {
            this.attacher.e0(onOutsidePhotoTapListener);
        }
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-889593285")) {
            ipChange.ipc$dispatch("-889593285", new Object[]{this, onPhotoTapListener});
        } else {
            this.attacher.f0(onPhotoTapListener);
        }
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1079858677")) {
            ipChange.ipc$dispatch("1079858677", new Object[]{this, onScaleChangedListener});
        } else {
            this.attacher.g0(onScaleChangedListener);
        }
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "968873263")) {
            ipChange.ipc$dispatch("968873263", new Object[]{this, onSingleFlingListener});
        } else {
            this.attacher.h0(onSingleFlingListener);
        }
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "6373227")) {
            ipChange.ipc$dispatch("6373227", new Object[]{this, onViewDragListener});
        } else {
            this.attacher.i0(onViewDragListener);
        }
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1235412079")) {
            ipChange.ipc$dispatch("1235412079", new Object[]{this, onViewTapListener});
        } else {
            this.attacher.j0(onViewTapListener);
        }
    }

    public void setRotationBy(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2030829409")) {
            ipChange.ipc$dispatch("-2030829409", new Object[]{this, Float.valueOf(f)});
        } else {
            this.attacher.k0(f);
        }
    }

    public void setRotationTo(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1524739901")) {
            ipChange.ipc$dispatch("-1524739901", new Object[]{this, Float.valueOf(f)});
        } else {
            this.attacher.l0(f);
        }
    }

    public void setScale(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-348021738")) {
            ipChange.ipc$dispatch("-348021738", new Object[]{this, Float.valueOf(f)});
        } else {
            this.attacher.m0(f);
        }
    }

    public void setScaleLevels(float f, float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1321843547")) {
            ipChange.ipc$dispatch("-1321843547", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)});
        } else {
            this.attacher.p0(f, f2, f3);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "909811242")) {
            ipChange.ipc$dispatch("909811242", new Object[]{this, scaleType});
            return;
        }
        PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher == null) {
            this.pendingScaleType = scaleType;
        } else {
            photoViewAttacher.q0(scaleType);
        }
    }

    public boolean setSuppMatrix(Matrix matrix) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-404059379") ? ((Boolean) ipChange.ipc$dispatch("-404059379", new Object[]{this, matrix})).booleanValue() : this.attacher.V(matrix);
    }

    public void setZoomTransitionDuration(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-98687831")) {
            ipChange.ipc$dispatch("-98687831", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.attacher.r0(i);
        }
    }

    public void setZoomable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-911852885")) {
            ipChange.ipc$dispatch("-911852885", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.attacher.s0(z);
        }
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setScale(float f, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2096273790")) {
            ipChange.ipc$dispatch("2096273790", new Object[]{this, Float.valueOf(f), Boolean.valueOf(z)});
        } else {
            this.attacher.o0(f, z);
        }
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "161849086")) {
            ipChange.ipc$dispatch("161849086", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)});
        } else {
            this.attacher.n0(f, f2, f3, z);
        }
    }

    @TargetApi(21)
    public PhotoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }
}
