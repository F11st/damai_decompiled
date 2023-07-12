package tb;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.media.SoundPool;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.ImageView;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.SVGAVideoShapeEntity;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import tb.l42;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class r42 extends l42 {
    private int c;
    private int d;
    private final Paint e;
    private final Path f;
    private final Path g;
    private final Matrix h;
    private final Matrix i;
    private final HashMap<String, Bitmap> j;
    private final HashMap<SVGAVideoShapeEntity, Path> k;
    private final float[] l;
    @NotNull
    private final t42 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r42(@NotNull SVGAVideoEntity sVGAVideoEntity, @NotNull t42 t42Var) {
        super(sVGAVideoEntity);
        b41.j(sVGAVideoEntity, "videoItem");
        b41.j(t42Var, "dynamicItem");
        this.m = t42Var;
        this.e = new Paint();
        this.f = new Path();
        this.g = new Path();
        this.h = new Matrix();
        this.i = new Matrix();
        this.j = new HashMap<>();
        this.k = new HashMap<>();
        this.l = new float[16];
    }

    private final void f(l42.a aVar, Canvas canvas, int i) {
        Function2<Canvas, Integer, Boolean> function2;
        String b = aVar.b();
        if (b == null || (function2 = this.m.a().get(b)) == null) {
            return;
        }
        o(aVar.a().e());
        canvas.save();
        canvas.concat(this.i);
        function2.invoke(canvas, Integer.valueOf(i));
        canvas.restore();
    }

    private final void g(l42.a aVar, Canvas canvas) {
        String b = aVar.b();
        if (b != null) {
            Boolean bool = this.m.b().get(b);
            if (bool != null) {
                b41.e(bool, AdvanceSetting.NETWORK_TYPE);
                if (!bool.booleanValue()) {
                    bool = null;
                }
                if (bool != null) {
                    return;
                }
            }
            Bitmap bitmap = this.m.c().get(b);
            if (bitmap == null) {
                bitmap = c().e().get(b);
            }
            if (bitmap != null) {
                o(aVar.a().e());
                this.e.reset();
                this.e.setAntiAlias(c().a());
                this.e.setFilterBitmap(c().a());
                this.e.setAlpha((int) (aVar.a().a() * 255));
                if (aVar.a().c() != null) {
                    v42 c = aVar.a().c();
                    if (c == null) {
                        return;
                    }
                    canvas.save();
                    this.f.reset();
                    c.a(this.f);
                    this.f.transform(this.i);
                    canvas.clipPath(this.f);
                    this.i.preScale((float) (aVar.a().b().b() / bitmap.getWidth()), (float) (aVar.a().b().b() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, this.i, this.e);
                    canvas.restore();
                } else {
                    this.i.preScale((float) (aVar.a().b().b() / bitmap.getWidth()), (float) (aVar.a().b().b() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, this.i, this.e);
                }
                j(canvas, bitmap, aVar);
            }
        }
    }

    private final void h(l42.a aVar, Canvas canvas) {
        int a;
        o(aVar.a().e());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : aVar.a().d()) {
            sVGAVideoShapeEntity.a();
            if (sVGAVideoShapeEntity.b() != null) {
                this.e.reset();
                this.e.setAntiAlias(c().a());
                double d = 255;
                this.e.setAlpha((int) (aVar.a().a() * d));
                if (!this.k.containsKey(sVGAVideoShapeEntity)) {
                    Path path = new Path();
                    path.set(sVGAVideoShapeEntity.b());
                    this.k.put(sVGAVideoShapeEntity, path);
                }
                this.f.reset();
                this.f.addPath(new Path(this.k.get(sVGAVideoShapeEntity)));
                this.h.reset();
                Matrix d2 = sVGAVideoShapeEntity.d();
                if (d2 != null) {
                    this.h.postConcat(d2);
                }
                this.h.postConcat(this.i);
                this.f.transform(this.h);
                SVGAVideoShapeEntity.a c = sVGAVideoShapeEntity.c();
                if (c != null && (a = c.a()) != 0) {
                    this.e.setColor(a);
                    this.e.setAlpha(Math.min(255, Math.max(0, (int) (aVar.a().a() * d))));
                    if (aVar.a().c() != null) {
                        canvas.save();
                    }
                    v42 c2 = aVar.a().c();
                    if (c2 != null) {
                        this.g.reset();
                        c2.a(this.g);
                        this.g.transform(this.i);
                        canvas.clipPath(this.g);
                    }
                    canvas.drawPath(this.f, this.e);
                    if (aVar.a().c() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a c3 = sVGAVideoShapeEntity.c();
                if (c3 != null && c3.g() > 0) {
                    n(sVGAVideoShapeEntity);
                    if (aVar.a().c() != null) {
                        canvas.save();
                    }
                    v42 c4 = aVar.a().c();
                    if (c4 != null) {
                        this.g.reset();
                        c4.a(this.g);
                        this.g.transform(this.i);
                        canvas.clipPath(this.g);
                    }
                    canvas.drawPath(this.f, this.e);
                    if (aVar.a().c() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final void i(l42.a aVar, Canvas canvas, int i) {
        g(aVar, canvas);
        h(aVar, canvas);
        f(aVar, canvas, i);
    }

    private final void j(Canvas canvas, Bitmap bitmap, l42.a aVar) {
        TextPaint textPaint;
        if (this.m.g()) {
            this.j.clear();
            this.m.i(false);
        }
        String b = aVar.b();
        if (b != null) {
            Bitmap bitmap2 = null;
            String str = this.m.e().get(b);
            if (str != null && (textPaint = this.m.f().get(b)) != null && (bitmap2 = this.j.get(b)) == null) {
                bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmap2);
                textPaint.setAntiAlias(true);
                Rect rect = new Rect();
                textPaint.getTextBounds(str, 0, str.length(), rect);
                canvas2.drawText(str, (float) ((bitmap.getWidth() - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect)) / 2.0d), (((bitmap.getHeight() + 0) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                HashMap<String, Bitmap> hashMap = this.j;
                if (bitmap2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                }
                hashMap.put(b, bitmap2);
            }
            StaticLayout staticLayout = this.m.d().get(b);
            if (staticLayout != null && (bitmap2 = this.j.get(b)) == null) {
                staticLayout.getPaint().setAntiAlias(true);
                StaticLayout staticLayout2 = new StaticLayout(staticLayout.getText(), 0, staticLayout.getText().length(), staticLayout.getPaint(), bitmap.getWidth(), staticLayout.getAlignment(), staticLayout.getSpacingMultiplier(), staticLayout.getSpacingAdd(), false);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas3 = new Canvas(createBitmap);
                canvas3.translate(0.0f, (bitmap.getHeight() - staticLayout2.getHeight()) / 2);
                staticLayout2.draw(canvas3);
                HashMap<String, Bitmap> hashMap2 = this.j;
                if (createBitmap == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                }
                hashMap2.put(b, createBitmap);
                bitmap2 = createBitmap;
            }
            if (bitmap2 != null) {
                this.e.reset();
                this.e.setAntiAlias(c().a());
                if (aVar.a().c() != null) {
                    v42 c = aVar.a().c();
                    if (c != null) {
                        canvas.save();
                        canvas.concat(this.i);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                        this.e.setShader(new BitmapShader(bitmap2, tileMode, tileMode));
                        this.f.reset();
                        c.a(this.f);
                        canvas.drawPath(this.f, this.e);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                this.e.setFilterBitmap(c().a());
                canvas.drawBitmap(bitmap2, this.i, this.e);
            }
        }
    }

    private final void k(int i) {
        SoundPool f;
        Integer c;
        for (q42 q42Var : c().b()) {
            if (q42Var.d() == i && (f = c().f()) != null && (c = q42Var.c()) != null) {
                q42Var.e(Integer.valueOf(f.play(c.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (q42Var.a() <= i) {
                Integer b = q42Var.b();
                if (b != null) {
                    int intValue = b.intValue();
                    SoundPool f2 = c().f();
                    if (f2 != null) {
                        f2.stop(intValue);
                    }
                }
                q42Var.e(null);
            }
        }
    }

    private final float l() {
        float a;
        float f;
        this.i.getValues(this.l);
        float[] fArr = this.l;
        if (fArr[0] == 0.0f) {
            return 0.0f;
        }
        double d = fArr[0];
        double d2 = fArr[3];
        double d3 = fArr[1];
        double d4 = fArr[4];
        if (d * d4 == d2 * d3) {
            return 0.0f;
        }
        double sqrt = Math.sqrt((d * d) + (d2 * d2));
        double d5 = d / sqrt;
        double d6 = d2 / sqrt;
        double d7 = (d5 * d3) + (d6 * d4);
        double d8 = d3 - (d5 * d7);
        double d9 = d4 - (d7 * d6);
        double sqrt2 = Math.sqrt((d8 * d8) + (d9 * d9));
        if (d5 * (d9 / sqrt2) < d6 * (d8 / sqrt2)) {
            sqrt = -sqrt;
        }
        if (b().b()) {
            a = b().a();
            f = (float) sqrt;
        } else {
            a = b().a();
            f = (float) sqrt2;
        }
        return a / Math.abs(f);
    }

    private final void m(Canvas canvas) {
        if (this.c != canvas.getWidth() || this.d != canvas.getHeight()) {
            this.k.clear();
        }
        this.c = canvas.getWidth();
        this.d = canvas.getHeight();
    }

    private final void n(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
        SVGAVideoShapeEntity.a c;
        float[] c2;
        String d;
        boolean q;
        boolean q2;
        boolean q3;
        String b;
        boolean q4;
        boolean q5;
        boolean q6;
        this.e.reset();
        this.e.setAntiAlias(c().a());
        this.e.setStyle(Paint.Style.STROKE);
        SVGAVideoShapeEntity.a c3 = sVGAVideoShapeEntity.c();
        if (c3 != null) {
            this.e.setColor(c3.f());
        }
        float l = l();
        SVGAVideoShapeEntity.a c4 = sVGAVideoShapeEntity.c();
        if (c4 != null) {
            this.e.setStrokeWidth(c4.g() * l);
        }
        SVGAVideoShapeEntity.a c5 = sVGAVideoShapeEntity.c();
        if (c5 != null && (b = c5.b()) != null) {
            q4 = kotlin.text.o.q(b, "butt", true);
            if (q4) {
                this.e.setStrokeCap(Paint.Cap.BUTT);
            } else {
                q5 = kotlin.text.o.q(b, "round", true);
                if (q5) {
                    this.e.setStrokeCap(Paint.Cap.ROUND);
                } else {
                    q6 = kotlin.text.o.q(b, "square", true);
                    if (q6) {
                        this.e.setStrokeCap(Paint.Cap.SQUARE);
                    }
                }
            }
        }
        SVGAVideoShapeEntity.a c6 = sVGAVideoShapeEntity.c();
        if (c6 != null && (d = c6.d()) != null) {
            q = kotlin.text.o.q(d, "miter", true);
            if (q) {
                this.e.setStrokeJoin(Paint.Join.MITER);
            } else {
                q2 = kotlin.text.o.q(d, "round", true);
                if (q2) {
                    this.e.setStrokeJoin(Paint.Join.ROUND);
                } else {
                    q3 = kotlin.text.o.q(d, "bevel", true);
                    if (q3) {
                        this.e.setStrokeJoin(Paint.Join.BEVEL);
                    }
                }
            }
        }
        if (sVGAVideoShapeEntity.c() != null) {
            this.e.setStrokeMiter(c.e() * l);
        }
        SVGAVideoShapeEntity.a c7 = sVGAVideoShapeEntity.c();
        if (c7 == null || (c2 = c7.c()) == null || c2.length != 3) {
            return;
        }
        float f = 0;
        if (c2[0] > f || c2[1] > f) {
            Paint paint = this.e;
            float[] fArr = new float[2];
            fArr[0] = (c2[0] >= 1.0f ? c2[0] : 1.0f) * l;
            fArr[1] = (c2[1] >= 0.1f ? c2[1] : 0.1f) * l;
            paint.setPathEffect(new DashPathEffect(fArr, c2[2] * l));
        }
    }

    private final void o(Matrix matrix) {
        this.i.reset();
        this.i.postScale(b().c(), b().d());
        this.i.postTranslate(b().e(), b().f());
        this.i.preConcat(matrix);
    }

    @Override // tb.l42
    public void a(@NotNull Canvas canvas, int i, @NotNull ImageView.ScaleType scaleType) {
        b41.j(canvas, "canvas");
        b41.j(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        m(canvas);
        for (l42.a aVar : e(i)) {
            i(aVar, canvas, i);
        }
        k(i);
    }
}
