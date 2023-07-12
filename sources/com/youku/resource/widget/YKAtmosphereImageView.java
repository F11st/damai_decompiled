package com.youku.resource.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.resource.R;
import com.youku.style.IStyle;
import com.youku.style.StyleVisitor;
import java.util.Map;
import tb.h62;
import tb.nh0;
import tb.ui2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKAtmosphereImageView extends TUrlImageView implements IStyle {
    protected boolean colorOnly;
    protected int defaultColor;
    protected int defaultImage;
    private ViewTreeObserver.OnGlobalLayoutListener listener;
    private ColorDrawable mColorDrawable;
    protected boolean mForceLoadUrl;
    private int mHeight;
    private int mStyleBgColor;
    private int mWidth;

    public YKAtmosphereImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.colorOnly = false;
        this.defaultImage = R.C8072drawable.yk_top_bg_layer;
        this.mForceLoadUrl = false;
        this.mStyleBgColor = 0;
        initView(context, attributeSet, i);
    }

    public void destoryView() {
        this.mColorDrawable = null;
    }

    protected void display(String str) {
        if (!TextUtils.equals(getImageUrl(), str) || this.mForceLoadUrl) {
            int i = this.mStyleBgColor;
            if (i != 0) {
                setAtmosphereColor(i);
            } else {
                setImageUrl(null);
            }
            setImageUrl(str);
            succListener(new IPhenixListener<ui2>() { // from class: com.youku.resource.widget.YKAtmosphereImageView.2
                @Override // com.taobao.phenix.intf.event.IPhenixListener
                public boolean onHappen(ui2 ui2Var) {
                    if (ui2Var != null) {
                        if (ui2Var.f() != null && !ui2Var.i()) {
                            YKAtmosphereImageView.this.reScale(ui2Var.f());
                            YKAtmosphereImageView.this.mForceLoadUrl = false;
                        } else if (ui2Var.f() != null) {
                            YKAtmosphereImageView.this.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        }
                    }
                    return false;
                }
            });
            failListener(new IPhenixListener<nh0>() { // from class: com.youku.resource.widget.YKAtmosphereImageView.3
                @Override // com.taobao.phenix.intf.event.IPhenixListener
                public boolean onHappen(nh0 nh0Var) {
                    if (YKAtmosphereImageView.this.mStyleBgColor != 0) {
                        YKAtmosphereImageView yKAtmosphereImageView = YKAtmosphereImageView.this;
                        yKAtmosphereImageView.setAtmosphereColor(yKAtmosphereImageView.mStyleBgColor);
                        return false;
                    }
                    YKAtmosphereImageView yKAtmosphereImageView2 = YKAtmosphereImageView.this;
                    if (yKAtmosphereImageView2.defaultImage == 0 || yKAtmosphereImageView2.getResources() == null) {
                        YKAtmosphereImageView.this.mColorDrawable.setColor(YKAtmosphereImageView.this.defaultColor);
                        YKAtmosphereImageView yKAtmosphereImageView3 = YKAtmosphereImageView.this;
                        yKAtmosphereImageView3.setPlaceHoldForeground(yKAtmosphereImageView3.mColorDrawable);
                        YKAtmosphereImageView.this.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    } else {
                        YKAtmosphereImageView yKAtmosphereImageView4 = YKAtmosphereImageView.this;
                        yKAtmosphereImageView4.setPlaceHoldForeground(yKAtmosphereImageView4.getResources().getDrawable(YKAtmosphereImageView.this.defaultImage));
                        YKAtmosphereImageView.this.setScaleType(ImageView.ScaleType.FIT_XY);
                    }
                    YKAtmosphereImageView.this.setImageUrl(null);
                    return false;
                }
            });
        }
    }

    protected void initView(Context context, AttributeSet attributeSet, int i) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.YKAtmosphereImageView, i, 0);
            try {
                this.defaultColor = obtainStyledAttributes.getColor(R.styleable.YKAtmosphereImageView_default_color, context.getResources().getColor(R.C8071color.ykn_deep_black_gradient_top_point));
                boolean z = obtainStyledAttributes.getBoolean(R.styleable.YKAtmosphereImageView_color_only, false);
                this.colorOnly = z;
                if (z) {
                    this.defaultImage = 0;
                } else {
                    this.defaultImage = obtainStyledAttributes.getResourceId(R.styleable.YKAtmosphereImageView_default_image, R.C8072drawable.yk_top_bg_layer);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.mColorDrawable = new ColorDrawable();
        initViewSize(context);
        setAutoRelease(false);
        restoreToDefault();
    }

    protected void initViewSize(Context context) {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.youku.resource.widget.YKAtmosphereImageView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                YKAtmosphereImageView yKAtmosphereImageView = YKAtmosphereImageView.this;
                yKAtmosphereImageView.mWidth = yKAtmosphereImageView.getWidth();
                YKAtmosphereImageView yKAtmosphereImageView2 = YKAtmosphereImageView.this;
                yKAtmosphereImageView2.mHeight = yKAtmosphereImageView2.getHeight();
                if (Build.VERSION.SDK_INT >= 16) {
                    YKAtmosphereImageView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    YKAtmosphereImageView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.uikit.feature.view.TImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void reScale(BitmapDrawable bitmapDrawable) {
        Matrix matrix = new Matrix();
        int intrinsicWidth = bitmapDrawable.getIntrinsicWidth();
        int intrinsicHeight = bitmapDrawable.getIntrinsicHeight();
        int height = getHeight() == 0 ? this.mHeight : getHeight();
        float width = (getWidth() == 0 ? this.mWidth : getWidth()) / intrinsicWidth;
        matrix.setScale(width, width);
        float f = intrinsicHeight * width;
        float f2 = height;
        if (f >= f2) {
            matrix.postTranslate(0.0f, f2 - f);
            setScaleType(ImageView.ScaleType.MATRIX);
            setImageMatrix(matrix);
            return;
        }
        setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override // com.youku.style.IStyle
    public void resetStyle() {
        setAtmosphereUrl(null);
    }

    public void restoreToDefault() {
        if (this.defaultImage != 0 && getResources() != null) {
            if (TextUtils.equals(getImageUrl(), h62.r(this.defaultImage))) {
                return;
            }
            setPlaceHoldForeground(getResources().getDrawable(this.defaultImage));
            setImageUrl(null);
            setScaleType(ImageView.ScaleType.FIT_XY);
            succListener(null);
            failListener(null);
            return;
        }
        setAtmosphereColor(this.defaultColor);
    }

    public void setAtmosphereColor(int i) {
        ColorDrawable colorDrawable = this.mColorDrawable;
        if (colorDrawable != null) {
            if (colorDrawable.getColor() != i) {
                this.mColorDrawable.setColor(i);
            }
            setPlaceHoldForeground(this.mColorDrawable);
            setImageUrl(null);
            setScaleType(ImageView.ScaleType.CENTER_CROP);
            succListener(null);
            failListener(null);
        }
    }

    public void setAtmosphereLocalFile(String str) {
        display(h62.q(str));
    }

    public void setAtmosphereUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            restoreToDefault();
        } else {
            display(str);
        }
    }

    public void setColorOnly(boolean z) {
        this.colorOnly = z;
    }

    public void setDefaultColor(int i) {
        this.defaultColor = i;
    }

    public void setDefaultImage(int i) {
        this.defaultImage = i;
    }

    public void setForceLoadUrl(boolean z) {
        this.mForceLoadUrl = z;
    }

    @Override // com.youku.style.IStyle
    public void setStyle(Map map) {
        StyleVisitor styleVisitor = new StyleVisitor(map);
        if (map != null) {
            if (styleVisitor.isSkin()) {
                if (styleVisitor.hasStyleStringValue("home_nav_bg_l.png")) {
                    setAtmosphereLocalFile(styleVisitor.getStyleStringValue("home_nav_bg_l.png"));
                    return;
                } else if (styleVisitor.hasStyleStringValue("navBgColor")) {
                    setAtmosphereColor(styleVisitor.getStyleColor("navBgColor"));
                    return;
                } else {
                    setAtmosphereUrl(null);
                    return;
                }
            }
            if (styleVisitor.hasStyleStringValue("navBgColor")) {
                this.mStyleBgColor = styleVisitor.getStyleColor("navBgColor");
            } else {
                this.mStyleBgColor = 0;
            }
            if (styleVisitor.hasStyleStringValue(IStyle.NAV_BG_URL_IMG)) {
                setAtmosphereUrl(styleVisitor.getStyleStringValue(IStyle.NAV_BG_URL_IMG));
            } else if (styleVisitor.hasStyleStringValue("navBgColor")) {
                setAtmosphereColor(styleVisitor.getStyleColor("navBgColor"));
            } else {
                setAtmosphereUrl(null);
            }
        }
    }

    public YKAtmosphereImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.colorOnly = false;
        this.defaultImage = R.C8072drawable.yk_top_bg_layer;
        this.mForceLoadUrl = false;
        this.mStyleBgColor = 0;
        initView(context, attributeSet, 0);
    }

    public YKAtmosphereImageView(Context context) {
        super(context);
        this.colorOnly = false;
        this.defaultImage = R.C8072drawable.yk_top_bg_layer;
        this.mForceLoadUrl = false;
        this.mStyleBgColor = 0;
        initView(context, null, 0);
    }
}
