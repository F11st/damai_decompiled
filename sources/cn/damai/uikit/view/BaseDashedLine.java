package cn.damai.uikit.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class BaseDashedLine extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    protected int mDashColor;
    protected a mDashEffect;
    protected Paint mPaint;
    protected float mStrokeWidth;

    public BaseDashedLine(Context context) {
        super(context);
        initParent();
    }

    private void initAttr(AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1310016126")) {
            ipChange.ipc$dispatch("-1310016126", new Object[]{this, attributeSet});
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.DashedLine);
        this.mDashColor = obtainStyledAttributes.getColor(R$styleable.DashedLine_dashColor, 0);
        this.mStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DashedLine_strokeW, 0);
        this.mDashEffect = new a(this, obtainStyledAttributes.getDimensionPixelSize(R$styleable.DashedLine_dashWidth, 1), obtainStyledAttributes.getDimensionPixelSize(R$styleable.DashedLine_dashGap, 0));
        initAttr(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    protected abstract void initAttr(TypedArray typedArray);

    protected void initParent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-454325325")) {
            ipChange.ipc$dispatch("-454325325", new Object[]{this});
            return;
        }
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-305327237")) {
            ipChange.ipc$dispatch("-305327237", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        this.mPaint.setColor(this.mDashColor);
        this.mPaint.setPathEffect(this.mDashEffect.a());
        onDrawDash(canvas, this.mPaint, this.mStrokeWidth);
    }

    protected abstract void onDrawDash(Canvas canvas, Paint paint, float f);

    public void setDashColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1314652165")) {
            ipChange.ipc$dispatch("1314652165", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mDashColor = i;
        }
    }

    public void setDashEffect(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1734716776")) {
            ipChange.ipc$dispatch("-1734716776", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            this.mDashEffect.b(i, i2);
        }
    }

    public void setStrokeWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "885811074")) {
            ipChange.ipc$dispatch("885811074", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mStrokeWidth = i;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a {
        private static transient /* synthetic */ IpChange $ipChange;
        protected int a;
        protected int b;
        protected int c;
        protected DashPathEffect d;

        public a(BaseDashedLine baseDashedLine, int i, int i2) {
            b(i, i2);
        }

        public DashPathEffect a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1582806218") ? (DashPathEffect) ipChange.ipc$dispatch("1582806218", new Object[]{this}) : this.d;
        }

        public void b(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-610073735")) {
                ipChange.ipc$dispatch("-610073735", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            this.a = i;
            this.b = i2;
            this.d = new DashPathEffect(new float[]{i, i2}, 0.0f);
        }

        public void c(int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1732387158")) {
                ipChange.ipc$dispatch("-1732387158", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                return;
            }
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = new DashPathEffect(new float[]{i, i2}, i3);
        }

        public a(BaseDashedLine baseDashedLine, int i, int i2, int i3) {
            c(i, i2, i3);
        }
    }

    public void setDashEffect(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2058384235")) {
            ipChange.ipc$dispatch("2058384235", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else {
            this.mDashEffect.c(i, i2, i3);
        }
    }

    public BaseDashedLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initAttr(attributeSet);
        initParent();
    }
}
