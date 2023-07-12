package cn.damai.uikit.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class LinearGradientView extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    private int[] colors;
    private float[] position;
    private Shader.TileMode tile;
    private float x0;
    private float x1;
    private float y0;
    private float y1;

    public LinearGradientView(Context context) {
        super(context);
        this.colors = new int[]{0, 0, 0};
        this.position = null;
        this.x0 = 0.0f;
        this.y0 = 0.0f;
        this.x1 = 0.0f;
        this.y1 = -1.0f;
        this.tile = Shader.TileMode.CLAMP;
    }

    public void init(float f, float f2, float f3, float f4, @NonNull @ColorInt int[] iArr, @Nullable float[] fArr, @NonNull Shader.TileMode tileMode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-320711331")) {
            ipChange.ipc$dispatch("-320711331", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), iArr, fArr, tileMode});
            return;
        }
        this.colors = iArr;
        this.position = fArr;
        this.x0 = f;
        this.y0 = f2;
        this.x1 = f3;
        this.y1 = f4;
        this.tile = tileMode;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-543160265")) {
            ipChange.ipc$dispatch("-543160265", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (this.y1 == -1.0f) {
            this.y1 = getMeasuredHeight();
        }
        Paint paint = new Paint();
        paint.setShader(new LinearGradient(this.x0, this.y0, this.x1, this.y1, this.colors, this.position, this.tile));
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), paint);
    }

    public void setColors(int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "767292789")) {
            ipChange.ipc$dispatch("767292789", new Object[]{this, iArr});
        } else {
            this.colors = iArr;
        }
    }

    public void setEndX(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "159571686")) {
            ipChange.ipc$dispatch("159571686", new Object[]{this, Float.valueOf(f)});
        } else {
            this.x1 = f;
        }
    }

    public void setEndY(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "160495207")) {
            ipChange.ipc$dispatch("160495207", new Object[]{this, Float.valueOf(f)});
        } else {
            this.y1 = f;
        }
    }

    public void setPosition(float[] fArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "135076249")) {
            ipChange.ipc$dispatch("135076249", new Object[]{this, fArr});
        } else {
            this.position = fArr;
        }
    }

    public void setStartX(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "877744191")) {
            ipChange.ipc$dispatch("877744191", new Object[]{this, Float.valueOf(f)});
        } else {
            this.x0 = f;
        }
    }

    public void setStartY(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "878667712")) {
            ipChange.ipc$dispatch("878667712", new Object[]{this, Float.valueOf(f)});
        } else {
            this.y0 = f;
        }
    }

    public void setTile(Shader.TileMode tileMode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1362327148")) {
            ipChange.ipc$dispatch("1362327148", new Object[]{this, tileMode});
        } else {
            this.tile = tileMode;
        }
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.colors = new int[]{0, 0, 0};
        this.position = null;
        this.x0 = 0.0f;
        this.y0 = 0.0f;
        this.x1 = 0.0f;
        this.y1 = -1.0f;
        this.tile = Shader.TileMode.CLAMP;
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.colors = new int[]{0, 0, 0};
        this.position = null;
        this.x0 = 0.0f;
        this.y0 = 0.0f;
        this.x1 = 0.0f;
        this.y1 = -1.0f;
        this.tile = Shader.TileMode.CLAMP;
    }
}
