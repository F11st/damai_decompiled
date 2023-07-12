package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSON;
import com.taobao.analysis.v3.FalcoGlobalTracer;
import com.taobao.analysis.v3.FalcoTracer;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamicx.DXGlobalCenter;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.PrefetchListener;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.a90;
import tb.du;
import tb.m11;
import tb.nz;
import tb.ry;
import tb.w00;
import tb.wt;
import tb.y00;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXImageWidgetNode extends DXWidgetNode implements PrefetchListener {
    public static final int DX_IMAGEVIEW_FILTERTYPE_GRAY = 1;
    public static final int DX_IMAGEVIEW_FILTERTYPE_NONE = 0;
    public static final String HEIGHT_LIMIT = "heightLimit";
    public static final int OPT_TYPE_DEFAULT = 0;
    public static final int OPT_TYPE_ORIGINAL = 1;
    public static final int OPT_TYPE_WEBP = 2;
    public static final String TAG = "DXImageWidgetNode";
    public static final String WIDTH_LIMIT = "widthLimit";
    static LruCache<String, Double> t = new LruCache<>(1024);
    static LruCache<String, Integer> u = new LruCache<>(100);
    private String a;
    private int b;
    private Drawable c;
    private String e;
    private String f;
    private Drawable g;
    private boolean h;
    private String k;
    private int n;
    private int o;
    private String p;
    private boolean q;
    private double d = -1.0d;
    private boolean i = true;
    private boolean j = true;
    private boolean l = false;
    private int m = 0;
    private double r = 0.5d;
    private int s = 0;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface DOWNLOAD_TYPE {
    }

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface FILTER_TYPE {
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface ImageLoadListener {
        boolean onHappen(d dVar);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements ImageLoadListener {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.taobao.android.dinamicx.widget.DXImageWidgetNode.ImageLoadListener
        public boolean onHappen(d dVar) {
            throw null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new DXImageWidgetNode();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class c {
        public int[] a;
        public int b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        public boolean h;
        private boolean i;
        private double j;
        private int k;
        private Map<String, String> l;
        private Map<String, String> m;
        public boolean n;

        public Map<String, String> k() {
            return this.l;
        }

        public boolean l() {
            return this.f;
        }

        public boolean m() {
            return this.h;
        }

        public void n(String str, String str2) {
            if (this.l == null) {
                this.l = new ConcurrentHashMap();
            }
            this.l.put(str, str2);
        }

        public void o(Map<String, String> map) {
            this.m = map;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class d {
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class e extends AsyncTask<Void, Void, Drawable> {
        private String a;
        private WeakReference<ImageView> b;
        private Context c;

        public e(ImageView imageView, String str) {
            this.b = new WeakReference<>(imageView);
            this.a = str;
            this.c = imageView.getContext().getApplicationContext();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Drawable doInBackground(Void... voidArr) {
            return b();
        }

        @Nullable
        public Drawable b() {
            Drawable drawable;
            int d = DXImageWidgetNode.d(this.c, this.a);
            if (d == 0) {
                return null;
            }
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    drawable = this.c.getDrawable(d);
                } else {
                    drawable = this.c.getResources().getDrawable(d);
                }
                return drawable;
            } catch (Exception e) {
                Log.e(DXImageWidgetNode.TAG, "Get layout parser exception", e);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onPostExecute(Drawable drawable) {
            ImageView imageView = this.b.get();
            if (imageView == null) {
                return;
            }
            if (this.a.equals((String) imageView.getTag(a90.TAG_CURRENT_IMAGE_NAME))) {
                imageView.setImageDrawable(drawable);
                imageView.setTag(a90.TAG_IMAGE_NAME, this.a);
            }
        }
    }

    public DXImageWidgetNode() {
        this.cornerRadius = -1;
        this.cornerRadiusLeftBottom = -1;
        this.cornerRadiusRightBottom = -1;
        this.cornerRadiusRightTop = -1;
        this.cornerRadiusLeftTop = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0021 A[Catch: all -> 0x00b7, TryCatch #0 {all -> 0x00b7, blocks: (B:3:0x0009, B:5:0x000f, B:7:0x0013, B:9:0x0017, B:15:0x0021, B:17:0x0027, B:19:0x002f, B:22:0x0037, B:24:0x003d, B:26:0x0047, B:28:0x004e, B:30:0x0054, B:32:0x005b, B:34:0x0067, B:38:0x008c, B:37:0x006e, B:31:0x0057, B:27:0x004a, B:20:0x0032, B:21:0x0035, B:39:0x00b4), top: B:47:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b4 A[Catch: all -> 0x00b7, TRY_LEAVE, TryCatch #0 {all -> 0x00b7, blocks: (B:3:0x0009, B:5:0x000f, B:7:0x0013, B:9:0x0017, B:15:0x0021, B:17:0x0027, B:19:0x002f, B:22:0x0037, B:24:0x003d, B:26:0x0047, B:28:0x004e, B:30:0x0054, B:32:0x005b, B:34:0x0067, B:38:0x008c, B:37:0x006e, B:31:0x0057, B:27:0x004a, B:20:0x0032, B:21:0x0035, B:39:0x00b4), top: B:47:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.taobao.android.dinamicx.widget.DXImageWidgetNode.c b(boolean r12) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.widget.DXImageWidgetNode.b(boolean):com.taobao.android.dinamicx.widget.DXImageWidgetNode$c");
    }

    public static int d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        Integer num = u.get(str);
        if (num == null) {
            try {
                num = Integer.valueOf(context.getResources().getIdentifier(str, "drawable", context.getPackageName()));
                u.put(str, num);
            } catch (Exception unused) {
                return 0;
            }
        }
        return num.intValue();
    }

    private void g(ImageView imageView, c cVar) {
        if (cVar == null || imageView == null) {
            return;
        }
        int i = R$id.dx_imageview_renderview_timestamp_key;
        boolean z = imageView.getTag(i) != null;
        long currentTimeMillis = System.currentTimeMillis();
        imageView.setTag(i, Long.valueOf(currentTimeMillis));
        cVar.n("DXImageViewOnCreateTimestampKey", String.valueOf(imageView.getTag(R$id.dx_imageview_createview_timestamp_key)));
        cVar.n("DXImageViewOnRenderTimestampKey", String.valueOf(currentTimeMillis));
        cVar.n("DXImageViewIsReuseKey", String.valueOf(z));
        cVar.n("DXImageViewRenderTypeKey", String.valueOf(getDXRuntimeContext().getRenderType()));
        cVar.n("DXImageViewIsMainKey", String.valueOf(Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()));
        if (DinamicXEngine.x()) {
            nz.b("DXImageOption", JSON.toJSONString(cVar.k()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c a() {
        c cVar = new c();
        getDXRuntimeContext().getConfig().g();
        getDXRuntimeContext().getConfig().f();
        cVar.k = this.m;
        int i = this.layoutWidth;
        if (i == -2 && this.layoutHeight != -2) {
            cVar.g = true;
        } else if (i != -2 && this.layoutHeight == -2) {
            cVar.g = true;
        }
        return cVar;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new DXImageWidgetNode();
    }

    public double c() {
        return this.d;
    }

    public String e() {
        return this.a;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    protected boolean extraHandleDark() {
        return !TextUtils.isEmpty(this.p) || this.q;
    }

    boolean f() {
        return this.o > 0 && this.n > 0;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        if (-2989625047271068027L == j || -273786109416499313L == j) {
            return 1;
        }
        if (-699001992808524026L == j || -7195088064603432654L == j) {
            return 0;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    protected void h(ImageView imageView, int i) {
        if (i == 0) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else if (i == 1) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else if (i != 2) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    protected void i(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }

    protected void j(ImageView imageView, String str) {
        if (str == null) {
            imageView.setImageDrawable(null);
            imageView.setTag(a90.TAG_IMAGE_NAME, null);
            return;
        }
        int i = a90.TAG_IMAGE_NAME;
        if (str.equals((String) imageView.getTag(i))) {
            return;
        }
        e eVar = new e(imageView, str);
        if (this.i) {
            imageView.setTag(a90.TAG_CURRENT_IMAGE_NAME, str);
            y00.q(eVar, new Void[0]);
            return;
        }
        imageView.setImageDrawable(eVar.b());
        imageView.setTag(i, str);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof DXImageWidgetNode) {
            DXImageWidgetNode dXImageWidgetNode = (DXImageWidgetNode) dXWidgetNode;
            this.d = dXImageWidgetNode.d;
            this.e = dXImageWidgetNode.e;
            this.a = dXImageWidgetNode.a;
            this.b = dXImageWidgetNode.b;
            this.c = dXImageWidgetNode.c;
            this.h = dXImageWidgetNode.h;
            this.j = dXImageWidgetNode.j;
            this.i = dXImageWidgetNode.i;
            this.f = dXImageWidgetNode.f;
            this.g = dXImageWidgetNode.g;
            this.l = dXImageWidgetNode.l;
            this.m = dXImageWidgetNode.m;
            this.p = dXImageWidgetNode.p;
            this.r = dXImageWidgetNode.r;
            this.q = dXImageWidgetNode.q;
            this.s = dXImageWidgetNode.s;
            this.o = dXImageWidgetNode.o;
            this.n = dXImageWidgetNode.n;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IDXWebImageInterface f = DXGlobalCenter.f(getDXRuntimeContext());
        ImageView imageView = f == null ? new ImageView(context) : f.buildView(context);
        imageView.setTag(R$id.dx_imageview_createview_timestamp_key, Long.valueOf(System.currentTimeMillis()));
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        int i3;
        int max;
        int i4;
        int a2 = DXWidgetNode.DXMeasureSpec.a(i);
        int a3 = DXWidgetNode.DXMeasureSpec.a(i2);
        int i5 = 0;
        boolean z = a2 != 1073741824;
        boolean z2 = a3 != 1073741824;
        if (!z && !z2) {
            i4 = DXWidgetNode.DXMeasureSpec.b(i);
            max = DXWidgetNode.DXMeasureSpec.b(i2);
        } else {
            double d2 = this.d;
            if (d2 <= 0.0d) {
                if (!TextUtils.isEmpty(this.a)) {
                    Double d3 = t.get(this.a);
                    if (d3 != null) {
                        d2 = d3.doubleValue();
                    }
                } else {
                    Drawable drawable = this.c;
                    if (drawable != null) {
                        int intrinsicWidth = drawable.getIntrinsicWidth();
                        int intrinsicHeight = this.c.getIntrinsicHeight();
                        if (intrinsicHeight > 0) {
                            d2 = intrinsicWidth / intrinsicHeight;
                        }
                    }
                }
            }
            if (!z || z2) {
                if (!z && z2) {
                    int size = View.MeasureSpec.getSize(i);
                    if (d2 > 0.0d) {
                        i5 = size;
                        i3 = (int) (size / d2);
                    } else {
                        i5 = size;
                    }
                }
                i3 = 0;
            } else {
                i3 = View.MeasureSpec.getSize(i2);
                if (d2 > 0.0d) {
                    i5 = (int) (i3 * d2);
                }
            }
            int max2 = Math.max(i5, getSuggestedMinimumWidth());
            max = Math.max(i3, getSuggestedMinimumHeight());
            i4 = max2;
        }
        setMeasuredDimension(DXWidgetNode.resolveSize(i4, i), DXWidgetNode.resolveSize(max, i2));
    }

    @Override // com.taobao.android.dinamicx.PrefetchListener
    public void onPrefetchSuccess() {
        if (wt.v0()) {
            b(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        ImageView imageView = (ImageView) view;
        int[] iArr = null;
        c b2 = (f() && this.k == null) ? b(false) : null;
        if (b2 == null) {
            b2 = a();
        }
        b2.n = this.k != null;
        h(imageView, this.b);
        m11.b(imageView, this.s);
        String str = this.k;
        if (str == null) {
            if (needHandleDark()) {
                if (!TextUtils.isEmpty(this.p)) {
                    str = this.p;
                } else {
                    str = this.a;
                }
            } else {
                str = this.a;
            }
        }
        try {
            FalcoTracer falcoTracer = FalcoGlobalTracer.get();
            if (falcoTracer != null && getDXRuntimeContext().getOpenTracerSpan() != null) {
                b2.o(falcoTracer.injectContextToMap(getDXRuntimeContext().getOpenTracerSpan().context()));
            }
        } catch (Throwable th) {
            ry.b(th);
        }
        if (!TextUtils.isEmpty(str)) {
            b2.h = true;
            if (getMeasuredHeight() == 0 || getMeasuredWidth() == 0) {
                new a(str);
            }
        } else {
            Drawable drawable = this.c;
            if (drawable != null) {
                i(imageView, drawable);
            } else if (!TextUtils.isEmpty(this.e)) {
                j(imageView, this.e);
            } else {
                imageView.setImageDrawable(null);
                b2.h = true;
            }
        }
        if (b2.h) {
            b2.b = d(context, this.f);
        }
        if (this.needSetBackground) {
            int tryFetchDarkModeColor = tryFetchDarkModeColor("borderColor", 2, this.borderColor);
            this.borderColor = tryFetchDarkModeColor;
            if (tryFetchDarkModeColor != 0) {
                b2.d = true;
            }
            if (this.borderWidth > 0) {
                b2.e = true;
            }
            int i = this.cornerRadius;
            if (i > 0) {
                iArr = new int[]{i, i, i, i};
            } else if (this.cornerRadiusLeftTop > 0 || this.cornerRadiusRightTop > 0 || this.cornerRadiusLeftBottom > 0 || this.cornerRadiusRightBottom > 0 || b2.d || b2.e) {
                iArr = new int[]{this.cornerRadiusLeftTop, this.cornerRadiusRightTop, this.cornerRadiusRightBottom, this.cornerRadiusLeftBottom};
            }
            if (iArr != null) {
                b2.a = iArr;
                b2.f = true;
            }
        }
        if (getDXRuntimeContext().getEngineContext() != null && getDXRuntimeContext().getEngineContext().b() != null && this.j) {
            getDXRuntimeContext().getEngineContext().b().o();
        }
        b2.c = this.l;
        b2.j = this.r;
        b2.i = this.q;
        IDXWebImageInterface f = DXGlobalCenter.f(getDXRuntimeContext());
        if (f == null) {
            return;
        }
        try {
            g(imageView, b2);
        } catch (Throwable th2) {
            nz.d(TAG, "setImagePerformanceOption", th2);
            ry.b(th2);
        }
        f.setImage(imageView, str, b2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j, double d2) {
        if (7594222789952419722L == j) {
            this.d = d2;
        } else if (j == 1360906811535693304L) {
            this.r = d2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (1015096712691932083L == j) {
            this.b = i;
            return;
        }
        if (1166125168016292427L == j) {
            this.h = i == 1;
        } else if (-2989625047271068027L == j) {
            this.j = i == 1;
        } else if (-273786109416499313L == j) {
            this.i = i == 1;
        } else if (j == w00.DXRICHTEXT_FORCEORIGINAL) {
            this.l = i != 0;
        } else if (j == -699001992808524026L) {
            this.m = i;
        } else if (j == 3833148244587386529L) {
            this.n = i;
        } else if (j == -5982835989037571513L) {
            this.o = i;
        } else if (j == -6984348415839913320L) {
            this.q = i != 0;
        } else if (j == -7195088064603432654L) {
            this.s = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetObjAttribute(long j, Object obj) {
        if (18039699017736L == j) {
            if (obj instanceof Drawable) {
                this.c = (Drawable) obj;
            }
        } else if (5980555813819279758L == j && (obj instanceof Drawable)) {
            this.g = (Drawable) obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (j == 6852849553340606541L) {
            this.p = str;
        } else if (du.DXDMCOLORFRAMELAYOUT_IMAGEURL == j) {
            this.k = null;
            this.a = str;
        } else if (8842287408427345805L == j) {
            this.e = str;
        } else if (5362226530917353491L == j) {
            this.f = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void setBackground(View view) {
        if (this.needSetBackground) {
            view.setBackgroundColor(tryFetchDarkModeColor("backGroundColor", 1, this.backGroundColor));
        }
    }
}
