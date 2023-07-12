package cn.damai.uikit.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import cn.damai.uikit.view.BaseDashedLine;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DashedCircleLine extends BaseDashedLine {
    private static transient /* synthetic */ IpChange $ipChange;
    private RectF mRectF;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.DashedCircleLine$a */
    /* loaded from: classes8.dex */
    public class C2581a extends BaseDashedLine.C2567a {
        private static transient /* synthetic */ IpChange $ipChange;

        public C2581a(DashedCircleLine dashedCircleLine, int i, int i2, int i3) {
            super(dashedCircleLine, i, i2, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(int i, int i2, float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-192364407")) {
                ipChange.ipc$dispatch("-192364407", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)});
                return;
            }
            float min = (float) ((Math.min(i, i2) - f) * 3.141592653589793d);
            float round = min / Math.round(min / (this.b + this.a));
            int i3 = this.a;
            int i4 = this.b;
            this.d = new DashPathEffect(new float[]{(i3 * round) / (i4 + i3), (round * i4) / (i4 + i3)}, this.c);
        }
    }

    public DashedCircleLine(Context context) {
        super(context);
        this.mRectF = new RectF();
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-223266052")) {
            ipChange.ipc$dispatch("-223266052", new Object[]{this});
        }
    }

    @Override // cn.damai.uikit.view.BaseDashedLine
    protected void initAttr(TypedArray typedArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585671418")) {
            ipChange.ipc$dispatch("-585671418", new Object[]{this, typedArray});
            return;
        }
        BaseDashedLine.C2567a c2567a = this.mDashEffect;
        this.mDashEffect = new C2581a(this, c2567a.a, c2567a.b, c2567a.c);
    }

    @Override // cn.damai.uikit.view.BaseDashedLine
    protected void onDrawDash(Canvas canvas, Paint paint, float f) {
        int width;
        int height;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1072305021")) {
            ipChange.ipc$dispatch("1072305021", new Object[]{this, canvas, paint, Float.valueOf(f)});
            return;
        }
        int min = Math.min(getWidth(), getHeight());
        if (f < 0.0f) {
            f = 0.0f;
        } else {
            float f2 = min;
            if (f * 2.0f > f2) {
                f = f2 / 2.0f;
            }
        }
        paint.setStrokeWidth(f);
        float f3 = f / 2.0f;
        RectF rectF = this.mRectF;
        rectF.top = ((height - min) / 2.0f) + f3;
        rectF.left = ((width - min) / 2.0f) + f3;
        rectF.bottom = ((height + min) / 2.0f) - f3;
        rectF.right = ((width + min) / 2.0f) - f3;
        canvas.drawOval(rectF, paint);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-436445953")) {
            ipChange.ipc$dispatch("-436445953", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int min = Math.min(size, size2);
        float f = this.mStrokeWidth;
        if (f < 0.0f) {
            f = 0.0f;
        } else {
            float f2 = min;
            if (f * 2.0f > f2) {
                f = f2 / 2.0f;
            }
        }
        ((C2581a) this.mDashEffect).e(size, size2, f);
    }

    public DashedCircleLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRectF = new RectF();
        init();
    }
}
