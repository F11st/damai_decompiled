package com.alibaba.pictures.moimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.taobao.phenix.animate.AnimatedFramesBuffer;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import com.taobao.phenix.intf.event.IPhenixListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.jg1;
import tb.jn1;
import tb.k50;
import tb.lg1;
import tb.mg1;
import tb.nh0;
import tb.oe;
import tb.tc0;
import tb.ui2;
import tb.ur1;
import tb.wr1;
import tb.wt2;
import tb.xj;
import tb.xr1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class MoImageDownloader {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private static final Lazy d;
    private String a;
    private IBitmapTransform b;
    private final Context c;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        @JvmStatic
        @NotNull
        public final MoImageDownloader a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-806652464") ? (MoImageDownloader) ipChange.ipc$dispatch("-806652464", new Object[]{this}) : new MoImageDownloader(null, null);
        }

        @JvmStatic
        @NotNull
        public final MoImageDownloader b(@Nullable Context context) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1055933428") ? (MoImageDownloader) ipChange.ipc$dispatch("1055933428", new Object[]{this, context}) : new MoImageDownloader(context, null);
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class b implements DownloadImgListener<Drawable> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DownloadImgListener a;

        b(DownloadImgListener downloadImgListener) {
            this.a = downloadImgListener;
        }

        @Override // com.alibaba.pictures.moimage.DownloadImgListener
        /* renamed from: a */
        public void onDownloaded(@Nullable String str, @NotNull Drawable drawable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1873258792")) {
                ipChange.ipc$dispatch("-1873258792", new Object[]{this, str, drawable});
                return;
            }
            b41.i(drawable, "sourceDrawable");
            if (drawable instanceof AnimatedImageDrawable) {
                Bitmap bitmap = null;
                try {
                    com.alibaba.pictures.utils.a aVar = com.alibaba.pictures.utils.a.INSTANCE;
                    Object a = aVar.b(AnimatedFramesBuffer.class, "newCachedEntityAt", Integer.TYPE).a((AnimatedFramesBuffer) aVar.c(AnimatedImageDrawable.class, "mAnimatedFramesBuffer").b(AnimatedFramesBuffer.class).a(drawable), 0);
                    if (a instanceof AnimatedFramesBuffer.CachedEntity) {
                        bitmap = (Bitmap) aVar.c(AnimatedFramesBuffer.CachedEntity.class, "bitmap").b(Bitmap.class).a(a);
                    }
                } catch (Exception e) {
                    lg1 lg1Var = lg1.INSTANCE;
                    lg1Var.c("AnimatedImageDrawable " + e.getMessage());
                }
                if (bitmap != null) {
                    DownloadImgListener downloadImgListener = this.a;
                    if (downloadImgListener != null) {
                        downloadImgListener.onDownloaded(str, bitmap);
                        return;
                    }
                    return;
                }
                DownloadImgListener downloadImgListener2 = this.a;
                if (downloadImgListener2 != null) {
                    downloadImgListener2.onFail(new MoImageLoadException("bitmap == null,can't convert to a bitmap,please check it!"), "downloadImageAsBitmap fail!");
                    wt2 wt2Var = wt2.INSTANCE;
                }
            } else if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap2 = ((BitmapDrawable) drawable).getBitmap();
                if (bitmap2 != null) {
                    DownloadImgListener downloadImgListener3 = this.a;
                    if (downloadImgListener3 != null) {
                        downloadImgListener3.onDownloaded(str, bitmap2);
                        return;
                    }
                    return;
                }
                DownloadImgListener downloadImgListener4 = this.a;
                if (downloadImgListener4 != null) {
                    downloadImgListener4.onFail(new MoImageLoadException("bitmap == null,can't convert to a bitmap,please check it!"), "downloadImageAsBitmap fail!");
                    wt2 wt2Var2 = wt2.INSTANCE;
                }
            } else if (drawable instanceof Animatable) {
                DownloadImgListener downloadImgListener5 = this.a;
                if (downloadImgListener5 != null) {
                    downloadImgListener5.onFail(new MoImageLoadException("this is a Animatable resource,can't convert to a bitmap,please check it!"), "downloadImageAsBitmap fail!");
                }
            } else {
                Bitmap d = jg1.d(jg1.INSTANCE, drawable, null, null, 6, null);
                if (d != null) {
                    DownloadImgListener downloadImgListener6 = this.a;
                    if (downloadImgListener6 != null) {
                        downloadImgListener6.onDownloaded(str, d);
                        return;
                    }
                    return;
                }
                DownloadImgListener downloadImgListener7 = this.a;
                if (downloadImgListener7 != null) {
                    downloadImgListener7.onFail(new MoImageLoadException("this is a " + drawable + ",can't convert to a bitmap,please check it!"), "downloadImageAsBitmap fail!");
                    wt2 wt2Var3 = wt2.INSTANCE;
                }
            }
        }

        @Override // com.alibaba.pictures.moimage.DownloadImgListener
        public void onFail(@NotNull MoImageLoadException moImageLoadException, @Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "210478841")) {
                ipChange.ipc$dispatch("210478841", new Object[]{this, moImageLoadException, str});
                return;
            }
            b41.i(moImageLoadException, "exception");
            DownloadImgListener downloadImgListener = this.a;
            if (downloadImgListener != null) {
                downloadImgListener.onFail(moImageLoadException, str);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class c<T extends xr1> implements IPhenixListener<nh0> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DownloadImgListener b;

        c(DownloadImgListener downloadImgListener) {
            MoImageDownloader.this = r1;
            this.b = downloadImgListener;
        }

        @Override // com.taobao.phenix.intf.event.IPhenixListener
        /* renamed from: a */
        public final boolean onHappen(nh0 nh0Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1015628098")) {
                return ((Boolean) ipChange.ipc$dispatch("-1015628098", new Object[]{this, nh0Var})).booleanValue();
            }
            MoImageLoadException moImageLoadException = new MoImageLoadException("Phenix load fail");
            moImageLoadException.setTag(nh0Var);
            DownloadImgListener downloadImgListener = this.b;
            if (downloadImgListener != null) {
                StringBuilder sb = new StringBuilder();
                b41.h(nh0Var, AdvanceSetting.NETWORK_TYPE);
                sb.append(nh0Var.e());
                sb.append(jn1.CONDITION_IF_MIDDLE);
                sb.append(MoImageDownloader.this.a);
                downloadImgListener.onFail(moImageLoadException, sb.toString());
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class d<T extends xr1> implements IPhenixListener<ui2> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DownloadImgListener b;

        d(DownloadImgListener downloadImgListener) {
            MoImageDownloader.this = r1;
            this.b = downloadImgListener;
        }

        @Override // com.taobao.phenix.intf.event.IPhenixListener
        /* renamed from: a */
        public final boolean onHappen(ui2 ui2Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1417167715")) {
                return ((Boolean) ipChange.ipc$dispatch("1417167715", new Object[]{this, ui2Var})).booleanValue();
            }
            b41.h(ui2Var, AdvanceSetting.NETWORK_TYPE);
            BitmapDrawable f = ui2Var.f();
            if (f != null) {
                DownloadImgListener downloadImgListener = this.b;
                if (downloadImgListener != null) {
                    downloadImgListener.onDownloaded(MoImageDownloader.this.a, f);
                }
            } else {
                DownloadImgListener downloadImgListener2 = this.b;
                if (downloadImgListener2 != null) {
                    downloadImgListener2.onFail(new MoImageLoadException("drawable == null!"), "image load success！but the drawable == null！ ");
                    wt2 wt2Var = wt2.INSTANCE;
                }
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class e<T extends xr1> implements IPhenixListener<xr1> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DownloadImgListener a;

        e(DownloadImgListener downloadImgListener) {
            this.a = downloadImgListener;
        }

        @Override // com.taobao.phenix.intf.event.IPhenixListener
        public final boolean onHappen(xr1 xr1Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-491857662")) {
                return ((Boolean) ipChange.ipc$dispatch("-491857662", new Object[]{this, xr1Var})).booleanValue();
            }
            DownloadImgListener downloadImgListener = this.a;
            if (downloadImgListener != null) {
                downloadImgListener.onFail(new MoImageLoadException("process cancel..."), "image load success！but the drawable == null！ ");
            }
            return true;
        }
    }

    static {
        Lazy b2;
        b2 = kotlin.b.b(new Function0<ExecutorService>() { // from class: com.alibaba.pictures.moimage.MoImageDownloader$Companion$executorService$2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // kotlin.jvm.functions.Function0
            public final ExecutorService invoke() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-510870357") ? (ExecutorService) ipChange.ipc$dispatch("-510870357", new Object[]{this}) : Executors.newFixedThreadPool(6);
            }
        });
        d = b2;
    }

    private MoImageDownloader(Context context) {
        this.c = context;
    }

    public static /* synthetic */ MoImageDownloader g(MoImageDownloader moImageDownloader, String str, Integer num, Integer num2, int i, Object obj) {
        if ((i & 2) != 0) {
            num = -1;
        }
        if ((i & 4) != 0) {
            num2 = -1;
        }
        return moImageDownloader.f(str, num, num2);
    }

    public final File h(String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1143322203")) {
            return (File) ipChange.ipc$dispatch("-1143322203", new Object[]{this, str});
        }
        Context context = this.c;
        if (context == null) {
            context = mg1.INSTANCE.c();
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (!z && context != null) {
            try {
                URLConnection openConnection = new URL(str).openConnection();
                if (openConnection != null) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(10000);
                    if (httpURLConnection.getResponseCode() == 200) {
                        File createTempFile = File.createTempFile("mo_download", "png", b41.d("mounted", Environment.getExternalStorageState()) ? context.getExternalCacheDir() : context.getCacheDir());
                        InputStream inputStream = httpURLConnection.getInputStream();
                        if (inputStream != null) {
                            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                            try {
                                oe.a(inputStream, fileOutputStream, 32768);
                                xj.a(fileOutputStream, null);
                                xj.a(inputStream, null);
                            } finally {
                            }
                        }
                        return createTempFile;
                    }
                    throw new MoImageLoadException("responseCode != 200");
                }
                throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
            } catch (Exception e2) {
                lg1 lg1Var = lg1.INSTANCE;
                lg1Var.c("MoImageDownloader:downloadImageAsFile" + e2);
                throw new MoImageLoadException(e2);
            }
        }
        throw new MoImageLoadException("fullUrl.isNullOrEmpty||context==null");
    }

    @JvmStatic
    @NotNull
    public static final MoImageDownloader i(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "809172076") ? (MoImageDownloader) ipChange.ipc$dispatch("809172076", new Object[]{context}) : Companion.b(context);
    }

    public final void c(@Nullable DownloadImgListener<Bitmap> downloadImgListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "443355810")) {
            ipChange.ipc$dispatch("443355810", new Object[]{this, downloadImgListener});
        } else {
            d(new b(downloadImgListener));
        }
    }

    public final void d(@Nullable DownloadImgListener<Drawable> downloadImgListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-839447725")) {
            ipChange.ipc$dispatch("-839447725", new Object[]{this, downloadImgListener});
            return;
        }
        String str = this.a;
        if ((str == null || str.length() == 0) && downloadImgListener != null) {
            MoImageLoadException moImageLoadException = new MoImageLoadException("url.isNullOrEmpty!");
            downloadImgListener.onFail(moImageLoadException, "downloadImageAsBitmap fail:" + this.a);
        }
        ur1 o = ur1.o();
        Context context = this.c;
        if (context != null) {
            o.z(context);
        }
        wr1 i = o.s(this.a).m(new c(downloadImgListener)).Q(new d(downloadImgListener)).i(new e(downloadImgListener));
        IBitmapTransform iBitmapTransform = this.b;
        if (iBitmapTransform != null) {
            i.h(new tc0(iBitmapTransform));
        }
        i.n();
    }

    @JvmOverloads
    @NotNull
    public final MoImageDownloader e(@Nullable String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2064482000") ? (MoImageDownloader) ipChange.ipc$dispatch("-2064482000", new Object[]{this, str}) : g(this, str, null, null, 6, null);
    }

    @JvmOverloads
    @NotNull
    public final MoImageDownloader f(@Nullable String str, @Nullable Integer num, @Nullable Integer num2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-400060656")) {
            return (MoImageDownloader) ipChange.ipc$dispatch("-400060656", new Object[]{this, str, num, num2});
        }
        if (str != null) {
            jg1 jg1Var = jg1.INSTANCE;
            if (!jg1Var.g(str)) {
                this.a = jg1Var.b(str, num, num2, null, null);
                return this;
            }
        }
        this.a = str;
        return this;
    }

    public /* synthetic */ MoImageDownloader(Context context, k50 k50Var) {
        this(context);
    }
}
