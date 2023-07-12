package cn.damai.user.crop;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.opengl.GLES10;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.user.crop.Crop;
import cn.damai.user.crop.ImageViewTouchBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;
import tb.jn1;
import tb.sa1;
import tb.u32;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class CropImageActivity extends MonitoredActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Handler b = new Handler();
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private Uri i;
    private Uri j;
    private boolean k;
    private int l;
    private u32 m;
    private CropImageView n;
    private HighlightView o;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class Cropper {
        private static transient /* synthetic */ IpChange $ipChange;

        private Cropper() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            int i;
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-520007659")) {
                ipChange.ipc$dispatch("-520007659", new Object[]{this});
            } else if (CropImageActivity.this.m == null) {
            } else {
                HighlightView highlightView = new HighlightView(CropImageActivity.this.n);
                int e = CropImageActivity.this.m.e();
                int b = CropImageActivity.this.m.b();
                Rect rect = new Rect(0, 0, e, b);
                int min = (Math.min(e, b) * 4) / 5;
                if (CropImageActivity.this.c == 0 || CropImageActivity.this.d == 0) {
                    i = min;
                } else if (CropImageActivity.this.c > CropImageActivity.this.d) {
                    i = (CropImageActivity.this.d * min) / CropImageActivity.this.c;
                } else {
                    i = min;
                    min = (CropImageActivity.this.c * min) / CropImageActivity.this.d;
                }
                int i2 = (e - min) / 2;
                int i3 = (b - i) / 2;
                highlightView.s(CropImageActivity.this.n.getUnrotatedMatrix(), rect, new RectF(i2, i3, i2 + min, i3 + i), (CropImageActivity.this.c == 0 || CropImageActivity.this.d == 0) ? false : false);
                CropImageActivity.this.n.add(highlightView);
            }
        }

        public void b() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "690660434")) {
                ipChange.ipc$dispatch("690660434", new Object[]{this});
            } else {
                CropImageActivity.this.b.post(new Runnable() { // from class: cn.damai.user.crop.CropImageActivity.Cropper.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "221746768")) {
                            ipChange2.ipc$dispatch("221746768", new Object[]{this});
                            return;
                        }
                        Cropper.this.c();
                        CropImageActivity.this.n.invalidate();
                        if (CropImageActivity.this.n.highlightViews.size() == 1) {
                            CropImageActivity cropImageActivity = CropImageActivity.this;
                            cropImageActivity.o = cropImageActivity.n.highlightViews.get(0);
                            CropImageActivity.this.o.q(true);
                        }
                    }
                });
            }
        }

        /* synthetic */ Cropper(CropImageActivity cropImageActivity, a aVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class a implements ImageViewTouchBase.Recycler {
        private static transient /* synthetic */ IpChange $ipChange;

        a(CropImageActivity cropImageActivity) {
        }

        @Override // cn.damai.user.crop.ImageViewTouchBase.Recycler
        public void recycle(Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1275230691")) {
                ipChange.ipc$dispatch("-1275230691", new Object[]{this, bitmap});
                return;
            }
            bitmap.recycle();
            System.gc();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1308419032")) {
                ipChange.ipc$dispatch("1308419032", new Object[]{this, view});
                return;
            }
            CropImageActivity.this.setResult(0);
            CropImageActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-875257895")) {
                ipChange.ipc$dispatch("-875257895", new Object[]{this, view});
            } else {
                CropImageActivity.this.s();
            }
        }
    }

    private int l(Uri uri) throws IOException {
        InputStream openInputStream;
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "-1257429207")) {
            return ((Integer) ipChange.ipc$dispatch("-1257429207", new Object[]{this, uri})).intValue();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        try {
            openInputStream = getContentResolver().openInputStream(uri);
        } catch (Throwable th) {
            th = th;
        }
        try {
            BitmapFactory.decodeStream(openInputStream, null, options);
            CropUtil.a(openInputStream);
            int o = o();
            while (true) {
                if (options.outHeight / i <= o && options.outWidth / i <= o) {
                    return i;
                }
                i <<= 1;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = openInputStream;
            CropUtil.a(inputStream);
            throw th;
        }
    }

    private void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-287995994")) {
            ipChange.ipc$dispatch("-287995994", new Object[]{this});
            return;
        }
        this.n.clear();
        u32 u32Var = this.m;
        if (u32Var != null) {
            u32Var.g();
        }
        System.gc();
    }

    private Bitmap n(Rect rect, int i, int i2) {
        OutOfMemoryError outOfMemoryError;
        Bitmap bitmap;
        IOException iOException;
        Rect rect2 = rect;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1854386832")) {
            return (Bitmap) ipChange.ipc$dispatch("1854386832", new Object[]{this, rect2, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        m();
        InputStream inputStream = null;
        try {
            try {
                InputStream openInputStream = getContentResolver().openInputStream(this.i);
                try {
                    BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(openInputStream, false);
                    int width = newInstance.getWidth();
                    int height = newInstance.getHeight();
                    if (this.g != 0) {
                        Matrix matrix = new Matrix();
                        matrix.setRotate(-this.g);
                        RectF rectF = new RectF();
                        matrix.mapRect(rectF, new RectF(rect2));
                        rectF.offset(rectF.left < 0.0f ? width : 0.0f, rectF.top < 0.0f ? height : 0.0f);
                        rect2 = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    }
                    Rect rect3 = rect2;
                    try {
                        Bitmap decodeRegion = newInstance.decodeRegion(rect3, new BitmapFactory.Options());
                        if (decodeRegion != null && (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect3) > i || com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect3) > i2)) {
                            Matrix matrix2 = new Matrix();
                            matrix2.postScale(i / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect3), i2 / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect3));
                            decodeRegion = Bitmap.createBitmap(decodeRegion, 0, 0, decodeRegion.getWidth(), decodeRegion.getHeight(), matrix2, true);
                        }
                        CropUtil.a(openInputStream);
                        return decodeRegion;
                    } catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException("Rectangle " + rect3 + " is outside of the image (" + width + "," + height + "," + this.g + jn1.BRACKET_END_STR, e);
                    }
                } catch (IOException e2) {
                    iOException = e2;
                    bitmap = null;
                    inputStream = openInputStream;
                    sa1.a("Error cropping image: " + iOException.getMessage(), iOException);
                    v(iOException);
                    CropUtil.a(inputStream);
                    return bitmap;
                } catch (OutOfMemoryError e3) {
                    outOfMemoryError = e3;
                    bitmap = null;
                    inputStream = openInputStream;
                    sa1.a("OOM cropping image: " + outOfMemoryError.getMessage(), outOfMemoryError);
                    v(outOfMemoryError);
                    CropUtil.a(inputStream);
                    return bitmap;
                } catch (Throwable th) {
                    th = th;
                    inputStream = openInputStream;
                    CropUtil.a(inputStream);
                    throw th;
                }
            } catch (IOException e4) {
                iOException = e4;
                bitmap = null;
            } catch (OutOfMemoryError e5) {
                outOfMemoryError = e5;
                bitmap = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private int o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1404526634")) {
            return ((Integer) ipChange.ipc$dispatch("-1404526634", new Object[]{this})).intValue();
        }
        int p = p();
        if (p == 0) {
            return 2048;
        }
        return Math.min(p, 4096);
    }

    private int p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-748885610")) {
            return ((Integer) ipChange.ipc$dispatch("-748885610", new Object[]{this})).intValue();
        }
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        return iArr[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.Closeable] */
    private void r() {
        Throwable th;
        InputStream inputStream;
        OutOfMemoryError e;
        IOException e2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1150609395")) {
            ipChange.ipc$dispatch("-1150609395", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.c = extras.getInt("aspect_x");
            this.d = extras.getInt("aspect_y");
            this.e = extras.getInt(Crop.Extra.MAX_X);
            this.f = extras.getInt(Crop.Extra.MAX_Y);
            this.h = extras.getBoolean(Crop.Extra.AS_PNG, false);
            this.j = (Uri) extras.getParcelable("output");
        }
        Uri data = intent.getData();
        this.i = data;
        if (data != null) {
            ContentResolver contentResolver = getContentResolver();
            ?? r1 = this.i;
            this.g = CropUtil.c(CropUtil.d(this, contentResolver, r1));
            try {
                try {
                    this.l = l(this.i);
                    inputStream = getContentResolver().openInputStream(this.i);
                } catch (IOException e3) {
                    inputStream = null;
                    e2 = e3;
                } catch (OutOfMemoryError e4) {
                    inputStream = null;
                    e = e4;
                } catch (Throwable th2) {
                    r1 = 0;
                    th = th2;
                    CropUtil.a(r1);
                    throw th;
                }
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.l;
                    this.m = new u32(BitmapFactory.decodeStream(inputStream, null, options), this.g);
                    r1 = inputStream;
                } catch (IOException e5) {
                    e2 = e5;
                    sa1.a("Error reading image: " + e2.getMessage(), e2);
                    v(e2);
                    r1 = inputStream;
                    CropUtil.a(r1);
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    sa1.a("OOM reading image: " + e.getMessage(), e);
                    v(e);
                    r1 = inputStream;
                    CropUtil.a(r1);
                }
                CropUtil.a(r1);
            } catch (Throwable th3) {
                th = th3;
                CropUtil.a(r1);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1461099866")) {
            ipChange.ipc$dispatch("-1461099866", new Object[]{this});
            return;
        }
        HighlightView highlightView = this.o;
        if (highlightView == null || this.k) {
            return;
        }
        this.k = true;
        Rect i2 = highlightView.i(this.l);
        int width = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(i2);
        int height = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(i2);
        int i3 = this.e;
        if (i3 > 0 && (i = this.f) > 0 && (width > i3 || height > i)) {
            float f = width / height;
            if (i3 / i > f) {
                width = (int) ((i * f) + 0.5f);
                height = i;
            } else {
                height = (int) ((i3 / f) + 0.5f);
                width = i3;
            }
        }
        try {
            Bitmap n = n(i2, width, height);
            if (n != null) {
                this.n.setImageRotateBitmapResetBase(new u32(n, this.g), true);
                this.n.center();
                this.n.highlightViews.clear();
            }
            t(n);
        } catch (IllegalArgumentException e) {
            v(e);
            finish();
        }
    }

    private void t(final Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "271624987")) {
            ipChange.ipc$dispatch("271624987", new Object[]{this, bitmap});
        } else if (bitmap != null) {
            CropUtil.g(this, null, "保存中", new Runnable() { // from class: cn.damai.user.crop.CropImageActivity.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-528161227")) {
                        ipChange2.ipc$dispatch("-528161227", new Object[]{this});
                    } else {
                        CropImageActivity.this.u(bitmap);
                    }
                }
            }, this.b);
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "217672403")) {
            ipChange.ipc$dispatch("217672403", new Object[]{this, bitmap});
            return;
        }
        if (this.j != null) {
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = getContentResolver().openOutputStream(this.j);
                    if (outputStream != null) {
                        bitmap.compress(this.h ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, 90, outputStream);
                    }
                } catch (IOException e) {
                    v(e);
                    sa1.a("Cannot open file: " + this.j, e);
                }
                CropUtil.b(CropUtil.d(this, getContentResolver(), this.i), CropUtil.d(this, getContentResolver(), this.j));
                w(this.j);
            } finally {
                CropUtil.a(outputStream);
            }
        }
        this.b.post(new Runnable() { // from class: cn.damai.user.crop.CropImageActivity.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-724674732")) {
                    ipChange2.ipc$dispatch("-724674732", new Object[]{this});
                    return;
                }
                CropImageActivity.this.n.clear();
                bitmap.recycle();
            }
        });
        finish();
    }

    private void v(Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1008524332")) {
            ipChange.ipc$dispatch("1008524332", new Object[]{this, th});
        } else {
            setResult(404, new Intent().putExtra("error", th));
        }
    }

    private void w(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2066921637")) {
            ipChange.ipc$dispatch("-2066921637", new Object[]{this, uri});
        } else {
            setResult(-1, new Intent().putExtra("output", uri));
        }
    }

    private void x() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2088389064")) {
            ipChange.ipc$dispatch("2088389064", new Object[]{this});
            return;
        }
        setContentView(R$layout.activity_crop_image);
        CropImageView cropImageView = (CropImageView) findViewById(R$id.crop_image);
        this.n = cropImageView;
        cropImageView.context = this;
        cropImageView.setRecycler(new a(this));
        findViewById(R$id.btn_cancel).setOnClickListener(new b());
        findViewById(R$id.btn_done).setOnClickListener(new c());
    }

    @TargetApi(19)
    private void y() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1182056865")) {
            ipChange.ipc$dispatch("-1182056865", new Object[]{this});
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            requestWindowFeature(1);
            if (i >= 19) {
                getWindow().clearFlags(ConfigReporter.BIT_GETTER_IMP);
            }
        }
    }

    private void z() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2001332801")) {
            ipChange.ipc$dispatch("-2001332801", new Object[]{this});
        } else if (isFinishing()) {
        } else {
            this.n.setImageRotateBitmapResetBase(this.m, true);
            CropUtil.g(this, null, "稍等片刻", new Runnable() { // from class: cn.damai.user.crop.CropImageActivity.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-331647722")) {
                        ipChange2.ipc$dispatch("-331647722", new Object[]{this});
                        return;
                    }
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    CropImageActivity.this.b.post(new Runnable() { // from class: cn.damai.user.crop.CropImageActivity.4.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "755386153")) {
                                ipChange3.ipc$dispatch("755386153", new Object[]{this});
                                return;
                            }
                            if (CropImageActivity.this.n.getScale() == 1.0f) {
                                CropImageActivity.this.n.center();
                            }
                            countDownLatch.countDown();
                        }
                    });
                    try {
                        countDownLatch.await();
                        new Cropper(CropImageActivity.this, null).b();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, this.b);
        }
    }

    @Override // cn.damai.user.crop.MonitoredActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "731831126")) {
            ipChange.ipc$dispatch("731831126", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        y();
        x();
        r();
        if (this.m == null) {
            finish();
        } else {
            z();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.user.crop.MonitoredActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1895570966")) {
            ipChange.ipc$dispatch("1895570966", new Object[]{this});
            return;
        }
        super.onDestroy();
        u32 u32Var = this.m;
        if (u32Var != null) {
            u32Var.g();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "758248686")) {
            return ((Boolean) ipChange.ipc$dispatch("758248686", new Object[]{this})).booleanValue();
        }
        return false;
    }

    public boolean q() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-127258855") ? ((Boolean) ipChange.ipc$dispatch("-127258855", new Object[]{this})).booleanValue() : this.k;
    }
}
