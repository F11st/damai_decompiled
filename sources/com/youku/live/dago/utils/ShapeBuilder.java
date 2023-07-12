package com.youku.live.dago.utils;

import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ShapeBuilder {
    private static transient /* synthetic */ IpChange $ipChange;
    private AttrContainer container;
    private GradientDrawable drawable = new GradientDrawable();
    private boolean isOperate;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class AttrContainer {
        private static transient /* synthetic */ IpChange $ipChange;
        public float botLeft;
        public float botRight;
        public int dashGap;
        public int dashWidth;
        public float gradientCenterX;
        public float gradientCenterY;
        public float gradientRadius;
        public int gradientType;
        public int height;
        public int solid;
        public int stokeColor;
        public int strokeWidth;
        public float topLeft;
        public float topRight;
        public int type;
        public int width;

        private AttrContainer() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRadius(float f, float f2, float f3, float f4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1870099458")) {
                ipChange.ipc$dispatch("1870099458", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
                return;
            }
            this.topLeft = f;
            this.topRight = f2;
            this.botLeft = f3;
            this.botRight = f4;
        }
    }

    private ShapeBuilder() {
        if (Build.VERSION.SDK_INT < 16) {
            this.container = new AttrContainer();
        }
    }

    public static void clearBg(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2008298462")) {
            ipChange.ipc$dispatch("-2008298462", new Object[]{view});
        } else {
            view.setBackgroundResource(0);
        }
    }

    public static ShapeBuilder create() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "275528102") ? (ShapeBuilder) ipChange.ipc$dispatch("275528102", new Object[0]) : new ShapeBuilder();
    }

    private ShapeBuilder gradientInit(GradientDrawable.Orientation orientation, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-393971425")) {
            return (ShapeBuilder) ipChange.ipc$dispatch("-393971425", new Object[]{this, orientation, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.drawable.setOrientation(orientation);
            this.drawable.setColors(new int[]{i, i2, i3});
        } else {
            this.isOperate = true;
            this.drawable = new GradientDrawable(orientation, new int[]{i, i2, i3});
        }
        return this;
    }

    private void operateMethod() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1523652605")) {
            ipChange.ipc$dispatch("1523652605", new Object[]{this});
            return;
        }
        AttrContainer attrContainer = this.container;
        if (attrContainer != null) {
            ShapeBuilder type = type(attrContainer.type);
            AttrContainer attrContainer2 = this.container;
            ShapeBuilder stroke = type.stroke(attrContainer2.strokeWidth, attrContainer2.stokeColor, attrContainer2.dashWidth, attrContainer2.dashGap);
            AttrContainer attrContainer3 = this.container;
            ShapeBuilder radius = stroke.radius(attrContainer3.topLeft, attrContainer3.topRight, attrContainer3.botLeft, attrContainer3.botRight);
            AttrContainer attrContainer4 = this.container;
            ShapeBuilder gradientType = radius.setSize(attrContainer4.width, attrContainer4.height).gradientType(this.container.gradientType);
            AttrContainer attrContainer5 = this.container;
            gradientType.gradientCenter(attrContainer5.gradientCenterX, attrContainer5.gradientCenterY).gradientRadius(this.container.gradientRadius);
            int i = this.container.solid;
            if (i != 0) {
                solid(i);
            }
        }
    }

    public void build(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1420799710")) {
            ipChange.ipc$dispatch("1420799710", new Object[]{this, view});
            return;
        }
        build();
        if (view == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(this.drawable);
        } else {
            view.setBackgroundDrawable(this.drawable);
        }
    }

    public ShapeBuilder gradient(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1010618233") ? (ShapeBuilder) ipChange.ipc$dispatch("-1010618233", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) : gradientInit(GradientDrawable.Orientation.TOP_BOTTOM, i, i2, i3);
    }

    public ShapeBuilder gradientCenter(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1373167823")) {
            return (ShapeBuilder) ipChange.ipc$dispatch("1373167823", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
        }
        this.drawable.setGradientCenter(f, f2);
        AttrContainer attrContainer = this.container;
        if (attrContainer != null) {
            attrContainer.gradientCenterX = f;
            attrContainer.gradientCenterY = f2;
        }
        return this;
    }

    public ShapeBuilder gradientRadius(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1973637992")) {
            return (ShapeBuilder) ipChange.ipc$dispatch("-1973637992", new Object[]{this, Float.valueOf(f)});
        }
        this.drawable.setGradientRadius(f);
        AttrContainer attrContainer = this.container;
        if (attrContainer != null) {
            attrContainer.gradientRadius = f;
        }
        return this;
    }

    public ShapeBuilder gradientType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-616661747")) {
            return (ShapeBuilder) ipChange.ipc$dispatch("-616661747", new Object[]{this, Integer.valueOf(i)});
        }
        this.drawable.setGradientType(i);
        AttrContainer attrContainer = this.container;
        if (attrContainer != null) {
            attrContainer.gradientType = i;
        }
        return this;
    }

    public ShapeBuilder radius(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1491140840")) {
            return (ShapeBuilder) ipChange.ipc$dispatch("1491140840", new Object[]{this, Float.valueOf(f)});
        }
        this.drawable.setCornerRadius(f);
        AttrContainer attrContainer = this.container;
        if (attrContainer != null) {
            attrContainer.setRadius(f, f, f, f);
        }
        return this;
    }

    public ShapeBuilder roundRadius(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "745759792")) {
            return (ShapeBuilder) ipChange.ipc$dispatch("745759792", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
        }
        this.drawable.setCornerRadii(new float[]{f, f, f2, f2, f4, f4, f3, f3});
        AttrContainer attrContainer = this.container;
        if (attrContainer != null) {
            attrContainer.setRadius(f, f2, f3, f4);
        }
        return this;
    }

    public ShapeBuilder setSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-228771821")) {
            return (ShapeBuilder) ipChange.ipc$dispatch("-228771821", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.drawable.setSize(i, i2);
        AttrContainer attrContainer = this.container;
        if (attrContainer != null) {
            attrContainer.width = i;
            attrContainer.height = i2;
        }
        return this;
    }

    public ShapeBuilder solid(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1486927686")) {
            return (ShapeBuilder) ipChange.ipc$dispatch("1486927686", new Object[]{this, Integer.valueOf(i)});
        }
        this.drawable.setColor(i);
        AttrContainer attrContainer = this.container;
        if (attrContainer != null) {
            attrContainer.solid = i;
        }
        return this;
    }

    public ShapeBuilder stroke(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1206428546")) {
            return (ShapeBuilder) ipChange.ipc$dispatch("1206428546", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.drawable.setStroke(i, i2);
        AttrContainer attrContainer = this.container;
        if (attrContainer != null) {
            attrContainer.strokeWidth = i;
            attrContainer.stokeColor = i2;
        }
        return this;
    }

    public ShapeBuilder type(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1080796509")) {
            return (ShapeBuilder) ipChange.ipc$dispatch("1080796509", new Object[]{this, Integer.valueOf(i)});
        }
        this.drawable.setShape(i);
        AttrContainer attrContainer = this.container;
        if (attrContainer != null) {
            attrContainer.type = i;
        }
        return this;
    }

    public ShapeBuilder gradient(GradientDrawable.Orientation orientation, int i, int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "513377010") ? (ShapeBuilder) ipChange.ipc$dispatch("513377010", new Object[]{this, orientation, Integer.valueOf(i), Integer.valueOf(i2)}) : gradientInit(orientation, i, i2);
    }

    public ShapeBuilder gradient(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1781297882")) {
            return (ShapeBuilder) ipChange.ipc$dispatch("1781297882", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        int i5 = i % 360;
        GradientDrawable.Orientation orientation = null;
        if (i5 == 0) {
            orientation = GradientDrawable.Orientation.LEFT_RIGHT;
        } else if (i5 == 45) {
            orientation = GradientDrawable.Orientation.BL_TR;
        } else if (i5 == 90) {
            orientation = GradientDrawable.Orientation.BOTTOM_TOP;
        } else if (i5 == 135) {
            orientation = GradientDrawable.Orientation.BR_TL;
        } else if (i5 == 180) {
            orientation = GradientDrawable.Orientation.RIGHT_LEFT;
        } else if (i5 == 225) {
            orientation = GradientDrawable.Orientation.TR_BL;
        } else if (i5 == 270) {
            orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        } else if (i5 == 315) {
            orientation = GradientDrawable.Orientation.TL_BR;
        }
        return gradient(orientation, i2, i3, i4);
    }

    @Deprecated
    public ShapeBuilder radius(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "198218940") ? (ShapeBuilder) ipChange.ipc$dispatch("198218940", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) : roundRadius(f, f2, f3, f4);
    }

    public GradientDrawable build() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "921455990")) {
            return (GradientDrawable) ipChange.ipc$dispatch("921455990", new Object[]{this});
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return this.drawable;
        }
        if (this.isOperate) {
            operateMethod();
        }
        return this.drawable;
    }

    public ShapeBuilder stroke(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1585439966")) {
            return (ShapeBuilder) ipChange.ipc$dispatch("-1585439966", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        this.drawable.setStroke(i, i2, i3, i4);
        AttrContainer attrContainer = this.container;
        if (attrContainer != null) {
            attrContainer.strokeWidth = i;
            attrContainer.stokeColor = i2;
            attrContainer.dashWidth = i3;
            attrContainer.dashGap = i4;
        }
        return this;
    }

    public ShapeBuilder gradientInit(GradientDrawable.Orientation orientation, int... iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "125343540")) {
            return (ShapeBuilder) ipChange.ipc$dispatch("125343540", new Object[]{this, orientation, iArr});
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.drawable.setOrientation(orientation);
            this.drawable.setColors(iArr);
        } else {
            this.isOperate = true;
            this.drawable = new GradientDrawable(orientation, iArr);
        }
        return this;
    }

    public ShapeBuilder gradient(GradientDrawable.Orientation orientation, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1780510159") ? (ShapeBuilder) ipChange.ipc$dispatch("1780510159", new Object[]{this, orientation, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) : gradientInit(orientation, i, i2, i3);
    }
}
