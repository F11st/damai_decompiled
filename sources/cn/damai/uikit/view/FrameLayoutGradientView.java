package cn.damai.uikit.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FrameLayoutGradientView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private int[] colors;
    Context context;
    private float[] position;
    private Shader.TileMode tile;
    private float x0;
    private float x1;
    private float y0;
    private float y1;

    public FrameLayoutGradientView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "756869249")) {
            ipChange.ipc$dispatch("756869249", new Object[]{this, canvas});
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
        if (AndroidInstantRuntime.support(ipChange, "743464639")) {
            ipChange.ipc$dispatch("743464639", new Object[]{this, iArr});
        } else {
            this.colors = iArr;
        }
    }

    public void setEndX(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1047131684")) {
            ipChange.ipc$dispatch("-1047131684", new Object[]{this, Float.valueOf(f)});
        } else {
            this.x1 = f;
        }
    }

    public void setEndY(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1046208163")) {
            ipChange.ipc$dispatch("-1046208163", new Object[]{this, Float.valueOf(f)});
        } else {
            this.y1 = f;
        }
    }

    public void setPosition(float[] fArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1288939421")) {
            ipChange.ipc$dispatch("-1288939421", new Object[]{this, fArr});
        } else {
            this.position = fArr;
        }
    }

    public void setStartX(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "876975541")) {
            ipChange.ipc$dispatch("876975541", new Object[]{this, Float.valueOf(f)});
        } else {
            this.x0 = f;
        }
    }

    public void setStartY(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "877899062")) {
            ipChange.ipc$dispatch("877899062", new Object[]{this, Float.valueOf(f)});
        } else {
            this.y0 = f;
        }
    }

    public void setTile(Shader.TileMode tileMode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "439616054")) {
            ipChange.ipc$dispatch("439616054", new Object[]{this, tileMode});
        } else {
            this.tile = tileMode;
        }
    }

    public FrameLayoutGradientView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrameLayoutGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.colors = new int[]{0, 0, 0};
        this.position = null;
        this.x0 = 0.0f;
        this.y0 = 0.0f;
        this.x1 = 0.0f;
        this.y1 = -1.0f;
        this.tile = Shader.TileMode.CLAMP;
        this.context = context;
        setWillNotDraw(false);
    }
}
