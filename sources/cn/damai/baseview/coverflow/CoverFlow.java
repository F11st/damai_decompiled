package cn.damai.baseview.coverflow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.Gallery;
import android.widget.ImageView;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CoverFlow extends Gallery {
    private static transient /* synthetic */ IpChange $ipChange;
    private float imageHeight;
    private float imageReflectionRatio;
    private float imageWidth;
    private final Camera mCamera;
    private int mCoveflowCenter;
    private int mMaxRotationAngle;
    private int mMaxZoom;
    private float reflectionGap;
    private boolean withReflection;

    public CoverFlow(Context context) {
        super(context);
        this.mCamera = new Camera();
        this.mMaxRotationAngle = 1;
        this.mMaxZoom = -120;
        setStaticTransformationsEnabled(true);
    }

    private int getCenterOfCoverflow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2094671734") ? ((Integer) ipChange.ipc$dispatch("-2094671734", new Object[]{this})).intValue() : (((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingLeft();
    }

    private static int getCenterOfView(View view) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-314073988") ? ((Integer) ipChange.ipc$dispatch("-314073988", new Object[]{view})).intValue() : view.getLeft() + (view.getWidth() / 2);
    }

    private void parseAttributes(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1896775404")) {
            ipChange.ipc$dispatch("1896775404", new Object[]{this, context, attributeSet});
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoverFlow);
        try {
            this.imageWidth = obtainStyledAttributes.getDimension(R$styleable.CoverFlow_imageWidth, 480.0f);
            this.imageHeight = obtainStyledAttributes.getDimension(R$styleable.CoverFlow_imageHeight, 320.0f);
            this.withReflection = obtainStyledAttributes.getBoolean(R$styleable.CoverFlow_withReflection, false);
            this.imageReflectionRatio = obtainStyledAttributes.getFloat(R$styleable.CoverFlow_imageReflectionRatio, 0.2f);
            this.reflectionGap = obtainStyledAttributes.getDimension(R$styleable.CoverFlow_reflectionGap, 4.0f);
            setSpacing(-30);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void transformImageBitmap(ImageView imageView, Transformation transformation, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1022014422")) {
            ipChange.ipc$dispatch("1022014422", new Object[]{this, imageView, transformation, Integer.valueOf(i)});
            return;
        }
        this.mCamera.save();
        Matrix matrix = transformation.getMatrix();
        int i2 = imageView.getLayoutParams().height;
        int i3 = imageView.getLayoutParams().width;
        int abs = Math.abs(i);
        this.mCamera.translate(0.0f, 0.0f, 100.0f);
        if (abs < this.mMaxRotationAngle) {
            this.mCamera.translate(0.0f, 0.0f, (float) (this.mMaxZoom + (abs * 1.5d)));
        }
        this.mCamera.rotateY(i);
        this.mCamera.getMatrix(matrix);
        float f = i3 / 2.0f;
        float f2 = i2 / 2.0f;
        matrix.preTranslate(-f, -f2);
        matrix.postTranslate(f, f2);
        this.mCamera.restore();
    }

    @Override // android.widget.Gallery, android.view.ViewGroup
    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-521785326")) {
            return ((Boolean) ipChange.ipc$dispatch("-521785326", new Object[]{this, view, transformation})).booleanValue();
        }
        int centerOfView = getCenterOfView(view);
        int width = view.getWidth();
        transformation.clear();
        transformation.setTransformationType(2);
        int i = this.mCoveflowCenter;
        if (centerOfView != i) {
            Math.abs((int) (((i - centerOfView) / width) * this.mMaxRotationAngle));
        }
        return true;
    }

    public float getImageHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1552824450") ? ((Float) ipChange.ipc$dispatch("-1552824450", new Object[]{this})).floatValue() : this.imageHeight;
    }

    public float getImageReflectionRatio() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1055157723") ? ((Float) ipChange.ipc$dispatch("-1055157723", new Object[]{this})).floatValue() : this.imageReflectionRatio;
    }

    public float getImageWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1108662591") ? ((Float) ipChange.ipc$dispatch("1108662591", new Object[]{this})).floatValue() : this.imageWidth;
    }

    public int getMaxRotationAngle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-140030980") ? ((Integer) ipChange.ipc$dispatch("-140030980", new Object[]{this})).intValue() : this.mMaxRotationAngle;
    }

    public int getMaxZoom() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1329313812") ? ((Integer) ipChange.ipc$dispatch("-1329313812", new Object[]{this})).intValue() : this.mMaxZoom;
    }

    public float getReflectionGap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-157568043") ? ((Float) ipChange.ipc$dispatch("-157568043", new Object[]{this})).floatValue() : this.reflectionGap;
    }

    public boolean isWithReflection() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1509882941") ? ((Boolean) ipChange.ipc$dispatch("-1509882941", new Object[]{this})).booleanValue() : this.withReflection;
    }

    @Override // android.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2081473441")) {
            return ((Boolean) ipChange.ipc$dispatch("2081473441", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
        }
        return true;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "566573116")) {
            ipChange.ipc$dispatch("566573116", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        this.mCoveflowCenter = getCenterOfCoverflow();
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setImageHeight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "27143014")) {
            ipChange.ipc$dispatch("27143014", new Object[]{this, Float.valueOf(f)});
        } else {
            this.imageHeight = f;
        }
    }

    public void setImageReflectionRatio(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "304342327")) {
            ipChange.ipc$dispatch("304342327", new Object[]{this, Float.valueOf(f)});
        } else {
            this.imageReflectionRatio = f;
        }
    }

    public void setImageWidth(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-931323811")) {
            ipChange.ipc$dispatch("-931323811", new Object[]{this, Float.valueOf(f)});
        } else {
            this.imageWidth = f;
        }
    }

    public void setMaxRotationAngle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2006308646")) {
            ipChange.ipc$dispatch("2006308646", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mMaxRotationAngle = i;
        }
    }

    public void setMaxZoom(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-30761570")) {
            ipChange.ipc$dispatch("-30761570", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mMaxZoom = i;
        }
    }

    public void setReflectionGap(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1200538385")) {
            ipChange.ipc$dispatch("-1200538385", new Object[]{this, Float.valueOf(f)});
        } else {
            this.reflectionGap = f;
        }
    }

    public void setWithReflection(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-866447017")) {
            ipChange.ipc$dispatch("-866447017", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.withReflection = z;
        }
    }

    public CoverFlow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842864);
    }

    public CoverFlow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCamera = new Camera();
        this.mMaxRotationAngle = 1;
        this.mMaxZoom = -120;
        parseAttributes(context, attributeSet);
        setStaticTransformationsEnabled(true);
    }
}
