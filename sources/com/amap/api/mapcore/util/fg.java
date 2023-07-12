package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.io.File;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class fg extends View {
    private Bitmap a;
    private Bitmap b;
    private Bitmap c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Bitmap g;
    private Paint h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private Context t;
    private boolean u;
    private float v;
    private float w;
    private boolean x;
    private boolean y;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x00d8 -> B:42:0x00f8). Please submit an issue!!! */
    public fg(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        InputStream inputStream;
        this.h = new Paint();
        this.i = false;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 10;
        this.n = 0;
        this.o = 0;
        this.p = 10;
        this.q = 8;
        this.r = false;
        this.s = false;
        this.u = true;
        this.v = 0.0f;
        this.w = 0.0f;
        this.x = true;
        this.y = false;
        InputStream inputStream2 = null;
        try {
            try {
                this.t = context.getApplicationContext();
                InputStream open = ek.a(context).open("ap.data");
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(open);
                    this.f = decodeStream;
                    this.a = eq.a(decodeStream, C4614m.a);
                    open.close();
                    inputStream2 = ek.a(context).open("ap1.data");
                    Bitmap decodeStream2 = BitmapFactory.decodeStream(inputStream2);
                    this.g = decodeStream2;
                    this.b = eq.a(decodeStream2, C4614m.a);
                    inputStream2.close();
                    this.k = this.b.getWidth();
                    this.j = this.b.getHeight();
                    this.h.setAntiAlias(true);
                    this.h.setColor(-16777216);
                    this.h.setStyle(Paint.Style.STROKE);
                    AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME = context.getFilesDir() + "/icon_web_day.data";
                    AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME = context.getFilesDir() + "/icon_web_night.data";
                    ep.a().a(new Runnable() { // from class: com.amap.api.mapcore.util.fg.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fg.this.a(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME, 0);
                            fg.this.a(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME, 1);
                            if ("".equals(eg.a(fg.this.t, "amap_web_logo", "md5_day", ""))) {
                                if (fg.this.c == null || fg.this.d == null) {
                                    eg.a(fg.this.t, "amap_web_logo", "md5_day", (Object) "f3a1627fe912c49ecdcd4ab92a5d6bc8");
                                    eg.a(fg.this.t, "amap_web_logo", "md5_night", (Object) "61733cf36c9727db08c2ef727490c036");
                                    return;
                                }
                                eg.a(fg.this.t, "amap_web_logo", "md5_day", (Object) gk.a(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME));
                                String a = gk.a(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME);
                                if (!"".equals(a)) {
                                    eg.a(fg.this.t, "amap_web_logo", "md5_night", (Object) a);
                                }
                                fg.this.d(true);
                            }
                        }
                    });
                    try {
                        open.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    inputStream2.close();
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    inputStream2 = open;
                    try {
                        hd.c(th, "WaterMarkerView", "create");
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Throwable th4) {
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th6) {
                                th6.printStackTrace();
                            }
                        }
                        throw th4;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                inputStream = null;
            }
        } catch (Throwable th8) {
            th8.printStackTrace();
        }
    }

    private void f() {
        int i = this.o;
        if (i == 0) {
            h();
        } else if (i == 2) {
            g();
        }
        this.m = this.p;
        int height = (getHeight() - this.q) - this.j;
        this.n = height;
        if (this.m < 0) {
            this.m = 0;
        }
        if (height < 0) {
            this.n = 0;
        }
    }

    private void g() {
        if (this.x) {
            this.p = (int) (getWidth() * this.v);
        } else {
            this.p = (int) ((getWidth() * this.v) - this.k);
        }
        this.q = (int) (getHeight() * this.w);
    }

    private void h() {
        int i = this.l;
        if (i == 1) {
            this.p = (getWidth() - this.k) / 2;
        } else if (i == 2) {
            this.p = (getWidth() - this.k) - 10;
        } else {
            this.p = 10;
        }
        this.q = 8;
    }

    public float d(int i) {
        float f;
        if (this.u) {
            if (i != 0) {
                if (i == 1) {
                    f = this.v;
                } else if (i != 2) {
                    return 0.0f;
                } else {
                    f = this.w;
                }
                return 1.0f - f;
            }
            return this.v;
        }
        return 0.0f;
    }

    public boolean e() {
        return this.i;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        try {
            if (!this.u || getWidth() == 0 || getHeight() == 0 || this.b == null) {
                return;
            }
            if (!this.r) {
                f();
                this.r = true;
            }
            canvas.drawBitmap(b(), this.m, this.n, this.h);
        } catch (Throwable th) {
            hd.c(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }

    public void a() {
        try {
            Bitmap bitmap = this.a;
            if (bitmap != null) {
                eq.b(bitmap);
                this.a = null;
            }
            Bitmap bitmap2 = this.b;
            if (bitmap2 != null) {
                eq.b(bitmap2);
                this.b = null;
            }
            this.a = null;
            this.b = null;
            Bitmap bitmap3 = this.f;
            if (bitmap3 != null) {
                eq.b(bitmap3);
                this.f = null;
            }
            Bitmap bitmap4 = this.g;
            if (bitmap4 != null) {
                eq.b(bitmap4);
                this.g = null;
            }
            Bitmap bitmap5 = this.c;
            if (bitmap5 != null) {
                eq.b(bitmap5);
            }
            this.c = null;
            Bitmap bitmap6 = this.d;
            if (bitmap6 != null) {
                eq.b(bitmap6);
            }
            this.d = null;
            Bitmap bitmap7 = this.e;
            if (bitmap7 != null) {
                bitmap7.recycle();
            }
            this.h = null;
        } catch (Throwable th) {
            hd.c(th, "WaterMarkerView", "destory");
            th.printStackTrace();
        }
    }

    public Bitmap b() {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        return (!this.y || (bitmap3 = this.e) == null) ? this.i ? (!this.s || (bitmap2 = this.d) == null) ? this.b : bitmap2 : (!this.s || (bitmap = this.c) == null) ? this.a : bitmap : bitmap3;
    }

    public Point c() {
        return new Point(this.m, this.n - 2);
    }

    public void c(int i) {
        this.o = 1;
        this.p = i;
        d();
    }

    public void d() {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        f();
        postInvalidate();
    }

    public void c(boolean z) {
        this.u = z;
    }

    public void d(boolean z) {
        if (this.u && this.s != z) {
            this.s = z;
            if (z) {
                if (this.i) {
                    Bitmap bitmap = this.d;
                    if (bitmap != null) {
                        this.k = bitmap.getWidth();
                        this.j = this.d.getHeight();
                        return;
                    }
                    return;
                }
                Bitmap bitmap2 = this.c;
                if (bitmap2 != null) {
                    this.k = bitmap2.getWidth();
                    this.j = this.c.getHeight();
                    return;
                }
                return;
            }
            this.k = this.a.getWidth();
            this.j = this.a.getHeight();
        }
    }

    public void b(int i) {
        this.o = 1;
        this.q = i;
        d();
    }

    public void b(boolean z) {
        if (this.u) {
            this.y = z;
            if (z) {
                Bitmap bitmap = this.e;
                if (bitmap != null) {
                    this.k = bitmap.getWidth();
                    this.j = this.e.getHeight();
                    return;
                }
                return;
            }
            this.k = this.a.getWidth();
            this.j = this.a.getHeight();
        }
    }

    public void a(boolean z) {
        if (this.u) {
            try {
                this.i = z;
                if (z) {
                    this.h.setColor(-1);
                } else {
                    this.h.setColor(-16777216);
                }
            } catch (Throwable th) {
                hd.c(th, "WaterMarkerView", "changeBitmap");
                th.printStackTrace();
            }
        }
    }

    public void a(int i) {
        this.o = 0;
        this.l = i;
        d();
    }

    public void a(int i, float f) {
        if (this.u) {
            this.o = 2;
            float max = Math.max(0.0f, Math.min(f, 1.0f));
            if (i == 0) {
                this.v = max;
                this.x = true;
            } else if (i == 1) {
                this.v = 1.0f - max;
                this.x = false;
            } else if (i == 2) {
                this.w = 1.0f - max;
            }
            d();
        }
    }

    public void a(String str, int i) {
        try {
            if (this.u && new File(str).exists()) {
                if (i == 0) {
                    Bitmap bitmap = this.c;
                    Bitmap decodeFile = BitmapFactory.decodeFile(str);
                    this.f = decodeFile;
                    this.c = eq.a(decodeFile, C4614m.a);
                    if (bitmap != null && !bitmap.isRecycled()) {
                        eq.b(bitmap);
                    }
                } else if (i == 1) {
                    Bitmap bitmap2 = this.d;
                    Bitmap decodeFile2 = BitmapFactory.decodeFile(str);
                    this.f = decodeFile2;
                    this.d = eq.a(decodeFile2, C4614m.a);
                    if (bitmap2 != null && !bitmap2.isRecycled()) {
                        eq.b(bitmap2);
                    }
                }
            }
        } catch (Throwable th) {
            hd.c(th, "WaterMarkerView", "create");
            th.printStackTrace();
        }
    }
}
