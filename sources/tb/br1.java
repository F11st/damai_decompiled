package tb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class br1 extends hq1 {
    protected static final Region n = new Region();
    protected static final Region o = new Region(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected List<Path> b;
    protected List<Integer> c;
    protected int d = 1;
    protected int e = 1;
    protected int f = 0;
    protected int g = 0;
    protected int h;
    protected int i;
    protected List<Path> j;
    protected List<String> k;
    private Bitmap l;
    private boolean m;

    private void b(int i, int i2) {
        Bitmap bitmap = this.l;
        if (bitmap != null && i == bitmap.getWidth() && i2 == this.l.getHeight()) {
            return;
        }
        this.l = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.m = true;
    }

    private void c(Canvas canvas) {
        canvas.translate(-this.f, -this.g);
        if (this.b != null) {
            for (int i = 0; i < this.b.size(); i++) {
                List<Integer> list = this.c;
                if (list != null && i < list.size()) {
                    this.a.setColor(this.c.get(i).intValue());
                }
                canvas.drawPath(this.b.get(i), this.a);
            }
        }
    }

    protected void d() {
        Integer num;
        Integer num2;
        Integer num3;
        List<Path> list = this.b;
        Integer num4 = null;
        if (list != null) {
            Integer num5 = null;
            num2 = null;
            num3 = null;
            for (Path path : list) {
                Region region = n;
                region.setPath(path, o);
                Rect bounds = region.getBounds();
                num4 = Integer.valueOf(Math.min(num4 == null ? bounds.top : num4.intValue(), bounds.top));
                num5 = Integer.valueOf(Math.min(num5 == null ? bounds.left : num5.intValue(), bounds.left));
                num2 = Integer.valueOf(Math.max(num2 == null ? bounds.right : num2.intValue(), bounds.right));
                num3 = Integer.valueOf(Math.max(num3 == null ? bounds.bottom : num3.intValue(), bounds.bottom));
            }
            num = num4;
            num4 = num5;
        } else {
            num = null;
            num2 = null;
            num3 = null;
        }
        this.f = num4 == null ? 0 : num4.intValue();
        this.g = num == null ? 0 : num.intValue();
        this.d = num2 == null ? 0 : num2.intValue() - this.f;
        int intValue = num3 != null ? num3.intValue() - this.g : 0;
        this.e = intValue;
        if (this.h == 0) {
            this.h = this.d;
        }
        if (this.i == 0) {
            this.i = intValue;
        }
        Rect bounds2 = getBounds();
        int i = bounds2.left;
        int i2 = bounds2.top;
        super.setBounds(i, i2, this.d + i, this.e + i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int width = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds);
        int height = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds);
        if (this.a.getAlpha() == 255) {
            canvas.save();
            canvas.translate(bounds.left - this.f, bounds.top - this.g);
            if (this.b != null) {
                for (int i = 0; i < this.b.size(); i++) {
                    List<Integer> list = this.c;
                    if (list != null && i < list.size()) {
                        this.a.setColor(this.c.get(i).intValue());
                    }
                    canvas.drawPath(this.b.get(i), this.a);
                }
                this.a.setAlpha(255);
            }
            canvas.restore();
            return;
        }
        b(width, height);
        if (this.m) {
            this.l.eraseColor(0);
            c(new Canvas(this.l));
            this.m = false;
        }
        canvas.drawBitmap(this.l, bounds.left, bounds.top, this.a);
    }

    public void e(int... iArr) {
        this.c = new ArrayList();
        for (int i : iArr) {
            this.c.add(Integer.valueOf(i));
        }
    }

    public void f(String... strArr) {
        this.i = 0;
        this.h = 0;
        this.k = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        this.b = arrayList;
        for (String str : strArr) {
            this.k.add(str);
            this.j.add(ar1.d(str));
        }
        d();
    }

    public void g(int i) {
        Rect bounds = getBounds();
        float height = (i * 1.0f) / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds);
        setBounds((int) (bounds.left * height), (int) (bounds.top * height), (int) (bounds.right * height), (int) (bounds.bottom * height));
    }

    public void h(int i) {
        Rect bounds = getBounds();
        float width = (i * 1.0f) / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds);
        setBounds((int) (bounds.left * width), (int) (bounds.top * width), (int) (bounds.right * width), (int) (bounds.bottom * width));
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        List<Path> list = this.j;
        if (list != null && list.size() > 0 && (i5 != this.d || i6 != this.e)) {
            this.b = ar1.h((i5 * 1.0f) / this.h, (i6 * 1.0f) / this.i, this.j, this.k);
            d();
            return;
        }
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(@NonNull Rect rect) {
        setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }
}
