package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class fb extends ScrollView {
    public static final String a = fb.class.getSimpleName();
    int b;
    private Context c;
    private LinearLayout d;
    private int e;
    private List<String> f;
    private int g;
    private int h;
    private Bitmap i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private Runnable p;
    private int q;
    private a r;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface a {
        void a(int i);
    }

    public fb(Context context) {
        super(context);
        this.e = 0;
        this.g = -1;
        this.i = null;
        this.j = Color.parseColor("#eeffffff");
        this.k = Color.parseColor("#44383838");
        this.l = 4;
        this.m = 1;
        this.b = 1;
        this.q = 50;
        a(context);
    }

    @Override // android.widget.ScrollView
    public void fling(int i) {
        super.fling(i / 3);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        a(i2);
        if (i2 > i4) {
            this.g = 1;
        } else {
            this.g = 0;
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.h = i;
        try {
            setBackgroundDrawable(null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            a();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.j = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.h == 0) {
            try {
                WindowManager windowManager = (WindowManager) this.c.getSystemService(tb.v.ATTACH_MODE_WINDOW);
                if (windowManager != null) {
                    this.h = windowManager.getDefaultDisplay().getWidth();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        super.setBackgroundDrawable(new Drawable() { // from class: com.amap.api.mapcore.util.fb.2
            private void a(Canvas canvas) {
                canvas.drawColor(fb.this.j);
            }

            private void b(Canvas canvas) {
                Paint paint = new Paint();
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                rect.left = 0;
                rect.top = 0;
                rect.right = fb.this.i.getWidth() + 0;
                rect.bottom = fb.this.i.getHeight() + 0;
                rect2.left = 0;
                rect2.top = fb.this.f()[0];
                rect2.right = fb.this.h + 0;
                rect2.bottom = fb.this.f()[1];
                canvas.drawBitmap(fb.this.i, rect, rect2, paint);
            }

            private void c(Canvas canvas) {
                Paint paint = new Paint();
                Rect clipBounds = canvas.getClipBounds();
                paint.setColor(fb.this.k);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(fb.this.l);
                canvas.drawRect(clipBounds, paint);
            }

            @Override // android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                try {
                    a(canvas);
                    b(canvas);
                    c(canvas);
                } catch (Throwable unused) {
                }
            }

            @Override // android.graphics.drawable.Drawable
            public int getOpacity() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable
            public void setAlpha(int i) {
            }

            @Override // android.graphics.drawable.Drawable
            public void setColorFilter(ColorFilter colorFilter) {
            }
        });
    }

    private TextView b(String str) {
        TextView textView = new TextView(this.c);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 16.0f);
        textView.setText(str);
        textView.setGravity(17);
        textView.getPaint().setFakeBoldText(true);
        int a2 = a(this.c, 8.0f);
        int a3 = a(this.c, 6.0f);
        textView.setPadding(a2, a3, a2, a3);
        if (this.e == 0) {
            this.e = a(textView);
            this.d.setLayoutParams(new FrameLayout.LayoutParams(-2, this.e * this.n));
            setLayoutParams(new LinearLayout.LayoutParams(-2, this.e * this.n));
        }
        return textView;
    }

    private void e() {
        List<String> list = this.f;
        if (list == null || list.size() == 0) {
            return;
        }
        this.d.removeAllViews();
        this.n = (this.m * 2) + 1;
        for (int size = this.f.size() - 1; size >= 0; size--) {
            this.d.addView(b(this.f.get(size)));
        }
        a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] f() {
        int i = this.e;
        int i2 = this.m;
        return new int[]{i * i2, i * (i2 + 1)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        a aVar = this.r;
        if (aVar != null) {
            try {
                aVar.a(c());
            } catch (Throwable unused) {
            }
        }
    }

    public int c() {
        List<String> list = this.f;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return Math.min(this.f.size() - (this.m * 2), Math.max(0, ((this.f.size() - 1) - this.b) - this.m));
    }

    public boolean d() {
        return getVisibility() == 0;
    }

    private void a(Context context) {
        this.c = context;
        setVerticalScrollBarEnabled(false);
        try {
            if (this.i == null) {
                InputStream open = ek.a(context).open("map_indoor_select.png");
                this.i = BitmapFactory.decodeStream(open);
                open.close();
            }
        } catch (Throwable unused) {
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.d = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.d);
        this.p = new Runnable() { // from class: com.amap.api.mapcore.util.fb.1
            @Override // java.lang.Runnable
            public void run() {
                if (fb.this.o - fb.this.getScrollY() == 0) {
                    if (fb.this.e == 0) {
                        return;
                    }
                    final int i = fb.this.o % fb.this.e;
                    final int i2 = fb.this.o / fb.this.e;
                    if (i != 0) {
                        if (i > fb.this.e / 2) {
                            fb.this.post(new Runnable() { // from class: com.amap.api.mapcore.util.fb.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    fb fbVar = fb.this;
                                    fbVar.smoothScrollTo(0, (fbVar.o - i) + fb.this.e);
                                    fb fbVar2 = fb.this;
                                    fbVar2.b = i2 + fbVar2.m + 1;
                                    fb.this.g();
                                }
                            });
                            return;
                        } else {
                            fb.this.post(new Runnable() { // from class: com.amap.api.mapcore.util.fb.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    fb fbVar = fb.this;
                                    fbVar.smoothScrollTo(0, fbVar.o - i);
                                    fb fbVar2 = fb.this;
                                    fbVar2.b = i2 + fbVar2.m;
                                    fb.this.g();
                                }
                            });
                            return;
                        }
                    }
                    fb fbVar = fb.this;
                    fbVar.b = i2 + fbVar.m;
                    fb.this.g();
                    return;
                }
                fb fbVar2 = fb.this;
                fbVar2.o = fbVar2.getScrollY();
                fb fbVar3 = fb.this;
                fbVar3.postDelayed(fbVar3.p, fb.this.q);
            }
        };
    }

    public void a() {
        this.o = getScrollY();
        postDelayed(this.p, this.q);
    }

    private void a(int i) {
        int i2 = this.e;
        if (i2 == 0) {
            return;
        }
        int i3 = this.m;
        int i4 = (i / i2) + i3;
        int i5 = i % i2;
        int i6 = i / i2;
        if (i5 == 0) {
            i4 = i6 + i3;
        } else if (i5 > i2 / 2) {
            i4 = i6 + i3 + 1;
        }
        int childCount = this.d.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            TextView textView = (TextView) this.d.getChildAt(i7);
            if (textView == null) {
                return;
            }
            if (i4 == i7) {
                textView.setTextColor(Color.parseColor("#0288ce"));
            } else {
                textView.setTextColor(Color.parseColor("#bbbbbb"));
            }
        }
    }

    public void b() {
        Bitmap bitmap = this.i;
        if (bitmap != null && !bitmap.isRecycled()) {
            eq.b(this.i);
            this.i = null;
        }
        if (this.r != null) {
            this.r = null;
        }
    }

    public static void b(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public void a(String[] strArr) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.clear();
        for (String str : strArr) {
            this.f.add(str);
        }
        for (int i = 0; i < this.m; i++) {
            this.f.add(0, "");
            this.f.add("");
        }
        e();
    }

    public void a(String str) {
        List<String> list = this.f;
        if (list == null || list.size() == 0) {
            return;
        }
        int indexOf = this.f.indexOf(str);
        int size = this.f.size();
        int i = this.m;
        final int i2 = ((size - i) - 1) - indexOf;
        this.b = i + i2;
        post(new Runnable() { // from class: com.amap.api.mapcore.util.fb.3
            @Override // java.lang.Runnable
            public void run() {
                fb fbVar = fb.this;
                fbVar.smoothScrollTo(0, i2 * fbVar.e);
            }
        });
    }

    public void a(a aVar) {
        this.r = aVar;
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(View view) {
        b(view);
        return view.getMeasuredHeight();
    }

    public void a(boolean z) {
        setVisibility(z ? 0 : 8);
    }
}
