package tb;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class vx2 extends Drawable {
    private static transient /* synthetic */ IpChange $ipChange;
    private RectF a = new RectF();
    private Paint b = new Paint(1);
    private Paint c = new Paint(1);
    private TextPaint d = new TextPaint(1);
    private int e;
    private int f;
    private LinearGradient g;
    private int h;
    private int i;

    public vx2() {
        this.b.setStyle(Paint.Style.FILL);
        this.e = l62.a(mu0.a(), 62.0f);
        this.f = l62.a(mu0.a(), 26.0f);
        this.d.setColor(-1);
        this.d.setTextSize(l62.a(mu0.a(), 10.0f));
        this.d.setTextAlign(Paint.Align.CENTER);
        this.c.setColor(Color.parseColor("#33000000"));
        this.c.setStyle(Paint.Style.FILL);
    }

    private void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-451631237")) {
            ipChange.ipc$dispatch("-451631237", new Object[]{this});
            return;
        }
        Rect bounds = getBounds();
        if (this.g == null || this.h != com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds) || this.i != com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds)) {
            this.g = new LinearGradient(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds), 0.0f, 0.0f, 0.0f, Color.parseColor(in2.DETAIL_PAGE_DEFAULT_COLOR), Color.parseColor("#BAD5FF"), Shader.TileMode.CLAMP);
        }
        this.h = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds);
        this.i = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1751732224")) {
            ipChange.ipc$dispatch("-1751732224", new Object[]{this, canvas});
            return;
        }
        try {
            Rect bounds = getBounds();
            this.a.set(bounds);
            a();
            LinearGradient linearGradient = this.g;
            if (linearGradient != null) {
                this.b.setShader(linearGradient);
                canvas.drawRect(this.a, this.b);
            }
            this.a.set(0.0f, 0.0f, this.e, this.f);
            this.a.offset((com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds) - this.a.width()) / 2.0f, (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds) - this.a.height()) / 2.0f);
            float f = this.f / 2.0f;
            canvas.drawRoundRect(this.a, f, f, this.c);
            canvas.drawText("视频处理中", com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds) / 2.0f, (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds) / 2.0f) + (((-this.d.ascent()) - this.c.descent()) / 2.0f), this.d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1032741433")) {
            return ((Integer) ipChange.ipc$dispatch("-1032741433", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-926388874")) {
            ipChange.ipc$dispatch("-926388874", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1757462664")) {
            ipChange.ipc$dispatch("1757462664", new Object[]{this, colorFilter});
        }
    }
}
