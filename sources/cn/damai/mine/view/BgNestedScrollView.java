package cn.damai.mine.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class BgNestedScrollView extends NestedScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    private Rect drawRect;
    private Paint mPaint;

    public BgNestedScrollView(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-928225868")) {
            ipChange.ipc$dispatch("-928225868", new Object[]{this, canvas});
            return;
        }
        int width = getWidth();
        int height = getHeight();
        if (height > 20) {
            this.drawRect.set(0, 20, width, height);
            canvas.drawRect(this.drawRect, this.mPaint);
        }
    }

    public BgNestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BgNestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drawRect = new Rect();
        this.mPaint = new Paint(1);
        setWillNotDraw(false);
        this.mPaint.setColor(Color.parseColor("#F5F5F5"));
        this.mPaint.setStyle(Paint.Style.FILL);
    }
}
