package com.alibaba.pictures.bricks.util.htmlparser;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.bricks.util.htmlparser.DefaultImageGetter;
import com.alibaba.pictures.bricks.util.htmlparser.callback.ImageGetter;
import com.alibaba.pictures.bricks.util.htmlparser.callback.ImageGetterCallBack;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a01;
import tb.b41;
import tb.k50;
import tb.r10;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class DefaultImageGetter implements ImageGetter {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private static final String f = DefaultImageGetter.class.getSimpleName();
    @Nullable
    private static Set<BitmapWorkerTask> g = new HashSet();
    @Nullable
    private static ExecutorService h;
    private final int a;
    @NotNull
    private final Context b;
    @Nullable
    private final b c;
    private final int d;
    @NotNull
    private final String e;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class BitmapWorkerTask implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private final ImageGetterCallBack callBack;
        private final int end;
        @NotNull
        private final String imageUrl;
        private boolean isCancel;
        private final int start;
        final /* synthetic */ DefaultImageGetter this$0;

        public BitmapWorkerTask(@NotNull DefaultImageGetter defaultImageGetter, String str, int i, @NotNull int i2, ImageGetterCallBack imageGetterCallBack) {
            b41.i(str, "imageUrl");
            b41.i(imageGetterCallBack, "callBack");
            this.this$0 = defaultImageGetter;
            this.imageUrl = str;
            this.start = i;
            this.end = i2;
            this.callBack = imageGetterCallBack;
        }

        public final void cancel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1615243960")) {
                ipChange.ipc$dispatch("1615243960", new Object[]{this});
            } else {
                this.isCancel = true;
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(3:(4:(2:34|(2:36|(2:38|(1:40)(9:41|(1:43)|44|45|46|47|48|49|50))))|48|49|50)|46|47) */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00fc, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00fd, code lost:
            r1 = r0;
            r0 = r1;
         */
        /* JADX WARN: Removed duplicated region for block: B:104:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0140  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0145 A[Catch: IOException -> 0x0110, TRY_ENTER, TryCatch #3 {IOException -> 0x0110, blocks: (B:68:0x0145, B:70:0x014a, B:46:0x010c, B:49:0x0112), top: B:90:0x001f }] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x014a A[Catch: IOException -> 0x0110, TRY_LEAVE, TryCatch #3 {IOException -> 0x0110, blocks: (B:68:0x0145, B:70:0x014a, B:46:0x010c, B:49:0x0112), top: B:90:0x001f }] */
        /* JADX WARN: Removed duplicated region for block: B:73:0x015b A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0172  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x017f A[Catch: IOException -> 0x017b, TRY_LEAVE, TryCatch #11 {IOException -> 0x017b, blocks: (B:80:0x0177, B:84:0x017f), top: B:98:0x0177 }] */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0177 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 391
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.util.htmlparser.DefaultImageGetter.BitmapWorkerTask.run():void");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        private final int b(BitmapFactory.Options options, int i) {
            IpChange ipChange = $ipChange;
            int i2 = 1;
            if (AndroidInstantRuntime.support(ipChange, "-602999518")) {
                return ((Integer) ipChange.ipc$dispatch("-602999518", new Object[]{this, options, Integer.valueOf(i)})).intValue();
            }
            int i3 = options.outWidth;
            if (i3 > i) {
                while ((i3 / 2) / i2 >= i) {
                    i2 *= 2;
                }
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bitmap d(Bitmap bitmap, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1745386438")) {
                return (Bitmap) ipChange.ipc$dispatch("1745386438", new Object[]{this, bitmap, Integer.valueOf(i)});
            }
            if (bitmap == null) {
                return null;
            }
            return Bitmap.createScaledBitmap(bitmap, i, (int) (((i * 1.0f) / bitmap.getWidth()) * bitmap.getHeight()), false);
        }

        @Nullable
        public final Bitmap c(@Nullable InputStream inputStream, boolean z, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1923007095")) {
                return (Bitmap) ipChange.ipc$dispatch("-1923007095", new Object[]{this, inputStream, Boolean.valueOf(z), Integer.valueOf(i)});
            }
            if (inputStream == null) {
                return null;
            }
            if (z) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStream, null, options);
                options.inSampleSize = b(options, i);
                options.inJustDecodeBounds = false;
                return d(BitmapFactory.decodeStream(inputStream, null, options), i);
            }
            return d(BitmapFactory.decodeStream(inputStream), i);
        }
    }

    static {
        if (h == null) {
            h = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        }
    }

    public DefaultImageGetter(@Nullable String str, int i, @NotNull Context context) {
        boolean p;
        b41.i(context, "mContext");
        this.a = i;
        this.b = context;
        this.d = (int) (a01.Companion.a() * 2.5f);
        if (str == null) {
            str = "";
        } else {
            p = o.p(str, "/", false, 2, null);
            if (!p) {
                str = str + r10.DIR;
            }
        }
        this.e = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(DefaultImageGetter defaultImageGetter, ImageGetterCallBack imageGetterCallBack, String str, int i, int i2, SuccessEvent successEvent) {
        Drawable drawable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-276506914")) {
            ipChange.ipc$dispatch("-276506914", new Object[]{defaultImageGetter, imageGetterCallBack, str, Integer.valueOf(i), Integer.valueOf(i2), successEvent});
            return;
        }
        b41.i(defaultImageGetter, "this$0");
        if (successEvent == null || (drawable = successEvent.drawable) == null) {
            return;
        }
        imageGetterCallBack.onImageReady(str, i, i2, defaultImageGetter.h(str, defaultImageGetter.i(drawable)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "829268426")) {
            ipChange.ipc$dispatch("829268426", new Object[]{failEvent});
        }
    }

    private final Drawable l(String str) {
        boolean F;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1071620073")) {
            return (Drawable) ipChange.ipc$dispatch("-1071620073", new Object[]{this, str});
        }
        ColorDrawable colorDrawable = new ColorDrawable(-3355444);
        if (str != null) {
            if (!(str.length() == 0)) {
                F = o.F(str, "/smiley", false, 2, null);
                if (F) {
                    int i = this.d;
                    colorDrawable.setBounds(0, 0, i, i);
                } else {
                    int i2 = this.a;
                    colorDrawable.setBounds(0, 0, i2, i2 / 2);
                }
                return colorDrawable;
            }
        }
        colorDrawable.setBounds(0, 0, 120, 120);
        return colorDrawable;
    }

    @Override // com.alibaba.pictures.bricks.util.htmlparser.callback.ImageGetter
    public void getDrawable(@Nullable final String str, final int i, final int i2, @Nullable final ImageGetterCallBack imageGetterCallBack) {
        boolean F;
        boolean F2;
        boolean F3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1895517284")) {
            ipChange.ipc$dispatch("-1895517284", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), imageGetterCallBack});
        } else if (imageGetterCallBack == null || TextUtils.isEmpty(str) || b41.d("null", str) || b41.d("NULL", str)) {
        } else {
            b41.f(str);
            F = o.F(str, "smiley/", false, 2, null);
            if (F) {
                try {
                    imageGetterCallBack.onImageReady(str, i, i2, h(str, Companion.c(this.b.getAssets().open(str), false, this.d)));
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
            F2 = o.F(str, "http://", false, 2, null);
            if (!F2) {
                F3 = o.F(str, "https://", false, 2, null);
                if (!F3) {
                    return;
                }
            }
            ImageLoaderProviderProxy.getProxy().load(str, R$drawable.bricks_shape_rect_corners_6_solid_ffffff, new IImageSuccListener() { // from class: tb.v50
                @Override // com.alient.oneservice.image.IImageSuccListener
                public final void onSuccess(SuccessEvent successEvent) {
                    DefaultImageGetter.j(DefaultImageGetter.this, imageGetterCallBack, str, i, i2, successEvent);
                }
            }, new IImageFailListener() { // from class: tb.u50
                @Override // com.alient.oneservice.image.IImageFailListener
                public final void onFail(FailEvent failEvent) {
                    DefaultImageGetter.k(failEvent);
                }
            });
        }
    }

    @NotNull
    public final Drawable h(@Nullable String str, @Nullable Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1835853620")) {
            return (Drawable) ipChange.ipc$dispatch("-1835853620", new Object[]{this, str, bitmap});
        }
        if (bitmap == null) {
            return l(str);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.b.getResources(), bitmap);
        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        return bitmapDrawable;
    }

    @Nullable
    public final Bitmap i(@Nullable Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1080639536")) {
            return (Bitmap) ipChange.ipc$dispatch("1080639536", new Object[]{this, drawable});
        }
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        if (createBitmap != null) {
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
        }
        return createBitmap;
    }
}
