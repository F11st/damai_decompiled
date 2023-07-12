package tb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.util.DMRGBUtil;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.pexode.PexodeOptions;
import com.taobao.phenix.bitmap.BitmapProcessor;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class lr implements BitmapProcessor {
    private static transient /* synthetic */ IpChange $ipChange;
    int a;
    int b;
    int c;
    int d;
    boolean e;

    public lr(Context context, boolean z, boolean z2) {
        this.e = z;
        this.a = DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics()) - (ScreenUtil.dip2px(context, 21.0f) * 2);
        this.d = ScreenUtil.dip2px(context, 12.0f);
        if (z2) {
            this.b = ScreenUtil.dip2px(context, 136.0f);
        } else {
            this.b = ScreenUtil.dip2px(context, 112.0f);
        }
        if (z) {
            this.c = ScreenUtil.dip2px(context, 150.0f);
        } else {
            this.c = ScreenUtil.dip2px(context, 180.0f);
        }
    }

    public static int a(float f, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1110499063") ? ((Integer) ipChange.ipc$dispatch("1110499063", new Object[]{Float.valueOf(f), Integer.valueOf(i)})).intValue() : (Math.min(255, Math.max(0, (int) (f * 255.0f))) << 24) + (i & 16777215);
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    public String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1614214981") ? (String) ipChange.ipc$dispatch("1614214981", new Object[]{this}) : "id";
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    public Bitmap process(@NonNull String str, @NonNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NonNull Bitmap bitmap) {
        int i;
        int i2;
        LinearGradient linearGradient;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-228817566")) {
            return (Bitmap) ipChange.ipc$dispatch("-228817566", new Object[]{this, str, bitmapSupplier, bitmap});
        }
        Bitmap bitmap2 = bitmapSupplier.get(this.a, this.b, bitmap.getConfig() != null ? bitmap.getConfig() : PexodeOptions.CONFIG);
        Canvas canvas = new Canvas(bitmap2);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.c / width;
        float f2 = height;
        int i3 = (int) (f2 * f);
        int i4 = this.b;
        if (i3 > i4) {
            i = (int) ((f2 - (i4 / f)) / 2.0f);
            height -= i;
        } else {
            i = 0;
        }
        Paint paint = new Paint(1);
        int f3 = DMRGBUtil.f(bitmap);
        paint.setColor(f3);
        RectF rectF = new RectF(0.0f, 0.0f, this.a, this.b);
        int i5 = this.d;
        canvas.drawRoundRect(rectF, i5, i5, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paint.setFilterBitmap(true);
        Rect rect = new Rect(0, i, width, height);
        int i6 = this.a;
        canvas.drawBitmap(bitmap, rect, new Rect(i6 - this.c, 0, i6, this.b), paint);
        float f4 = (i2 - this.c) / this.a;
        if (this.e) {
            linearGradient = new LinearGradient(0.0f, 0.0f, this.a, 0.0f, new int[]{f3, f3, a(0.4f, f3)}, new float[]{0.0f, f4, 1.0f}, Shader.TileMode.CLAMP);
        } else {
            linearGradient = new LinearGradient(0.0f, 0.0f, this.a, 0.0f, new int[]{f3, f3, a(0.3f, f3)}, new float[]{0.0f, f4, 1.0f}, Shader.TileMode.CLAMP);
        }
        paint.setXfermode(null);
        paint.setShader(linearGradient);
        RectF rectF2 = new RectF(0.0f, 0.0f, this.a, this.b);
        int i7 = this.d;
        canvas.drawRoundRect(rectF2, i7, i7, paint);
        return bitmap2;
    }
}
