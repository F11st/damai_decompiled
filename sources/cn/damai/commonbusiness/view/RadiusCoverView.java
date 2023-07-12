package cn.damai.commonbusiness.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RadiusCoverView extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    private int coverColor;
    private int leftBottomRadians;
    private int leftTopRadians;
    private int rightBottomRadians;
    private int rightTopRadians;

    public RadiusCoverView(Context context) {
        this(context, null, 0);
    }

    private Bitmap drawRect(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-221535180")) {
            return (Bitmap) ipChange.ipc$dispatch("-221535180", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(this.coverColor);
        int i3 = this.leftTopRadians;
        canvas.drawRect(new RectF(0.0f, 0.0f, i3, i3), paint);
        int height = getHeight();
        int i4 = this.leftBottomRadians;
        canvas.drawRect(new RectF(0.0f, height - i4, i4, getHeight()), paint);
        canvas.drawRect(new RectF(getWidth() - this.rightTopRadians, 0.0f, getWidth(), this.rightTopRadians), paint);
        canvas.drawRect(new RectF(getWidth() - this.rightBottomRadians, getHeight() - this.rightBottomRadians, getWidth(), getHeight()), paint);
        return createBitmap;
    }

    private Bitmap drawSector(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1494890674")) {
            return (Bitmap) ipChange.ipc$dispatch("1494890674", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-13244);
        int i3 = this.leftTopRadians;
        canvas.drawArc(new RectF(0.0f, 0.0f, i3 * 2, i3 * 2), 180.0f, 90.0f, true, paint);
        int height = getHeight();
        int i4 = this.leftBottomRadians;
        canvas.drawArc(new RectF(0.0f, height - (i4 * 2), i4 * 2, getHeight()), 90.0f, 90.0f, true, paint);
        canvas.drawArc(new RectF(getWidth() - (this.rightTopRadians * 2), 0.0f, getWidth(), this.rightTopRadians * 2), 270.0f, 90.0f, true, paint);
        canvas.drawArc(new RectF(getWidth() - (this.rightBottomRadians * 2), getHeight() - (this.rightBottomRadians * 2), getWidth(), getHeight()), 0.0f, 90.0f, true, paint);
        return createBitmap;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-279367830")) {
            ipChange.ipc$dispatch("-279367830", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setFilterBitmap(false);
        paint.setStyle(Paint.Style.FILL);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawBitmap(drawSector(getWidth(), getHeight()), 0.0f, 0.0f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        canvas.drawBitmap(drawRect(getWidth(), getHeight()), 0.0f, 0.0f, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    public void setCoverColor(@ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "240406437")) {
            ipChange.ipc$dispatch("240406437", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.coverColor = i;
        }
    }

    public void setRadians(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "103685262")) {
            ipChange.ipc$dispatch("103685262", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        this.leftTopRadians = i;
        this.rightTopRadians = i2;
        this.leftBottomRadians = i3;
        this.rightBottomRadians = i4;
    }

    public RadiusCoverView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RadiusCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.leftTopRadians = 30;
        this.leftBottomRadians = 30;
        this.rightTopRadians = 30;
        this.rightBottomRadians = 30;
        this.coverColor = -1381654;
    }
}
