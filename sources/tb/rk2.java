package tb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class rk2 extends Drawable {
    private static transient /* synthetic */ IpChange $ipChange;
    private int c;
    private Paint b = new Paint(1);
    private Rect e = new Rect();
    private int d = m62.a(mu0.a(), 4.0f);
    private Bitmap a = BitmapFactory.decodeResource(mu0.a().getResources(), R$drawable.icon_tab_indicator_1);

    public rk2(int i) {
        this.c = m62.a(mu0.a(), i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "920846174")) {
            ipChange.ipc$dispatch("920846174", new Object[]{this, canvas});
            return;
        }
        try {
            this.e.set(getBounds());
            if (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.e) <= 0) {
                Rect rect = this.e;
                rect.top = rect.bottom - this.d;
            }
            if (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.e) > this.c) {
                float width = (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.e) - this.c) / 2.0f;
                Rect rect2 = this.e;
                rect2.left = (int) (rect2.left + width);
                rect2.right = (int) (rect2.right - width);
            }
            canvas.drawBitmap(this.a, (Rect) null, this.e, this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1803271977")) {
            return ((Integer) ipChange.ipc$dispatch("1803271977", new Object[]{this})).intValue();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1797494740")) {
            ipChange.ipc$dispatch("1797494740", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1627649686")) {
            ipChange.ipc$dispatch("-1627649686", new Object[]{this, colorFilter});
        }
    }
}
