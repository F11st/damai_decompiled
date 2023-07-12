package cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.ImageGetter;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.ImageGetterCallBack;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DefaultImageGetter implements ImageGetter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String f = "DefaultImageGetter";
    private static Set<BitmapWorkerTask> g = new HashSet();
    private static ExecutorService h;
    private Context a;
    private e b;
    private int c;
    private final int d = (int) (HtmlView.h * 2.5f);
    private String e;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class BitmapWorkerTask implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private ImageGetterCallBack callBack;
        private int end;
        private String imageUrl;
        private boolean isCancel;
        private int start;

        public BitmapWorkerTask(String str, int i, int i2, ImageGetterCallBack imageGetterCallBack) {
            this.imageUrl = str;
            this.start = i;
            this.end = i2;
            this.callBack = imageGetterCallBack;
        }

        public void cancel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "868736188")) {
                ipChange.ipc$dispatch("868736188", new Object[]{this});
            } else {
                this.isCancel = true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:77:0x0161  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x016e A[Catch: IOException -> 0x016a, TRY_LEAVE, TryCatch #7 {IOException -> 0x016a, blocks: (B:79:0x0166, B:83:0x016e), top: B:94:0x0166 }] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0166 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 374
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.DefaultImageGetter.BitmapWorkerTask.run():void");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageGetterCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;

        a(ImageGetterCallBack imageGetterCallBack, String str, int i, int i2) {
            this.a = imageGetterCallBack;
            this.b = str;
            this.c = i;
            this.d = i2;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "195558006")) {
                ipChange.ipc$dispatch("195558006", new Object[]{this, eVar});
            } else if (eVar == null || (drawable = eVar.a) == null) {
            } else {
                Bitmap j = DefaultImageGetter.this.j(drawable);
                ImageGetterCallBack imageGetterCallBack = this.a;
                String str = this.b;
                imageGetterCallBack.onImageReady(str, this.c, this.d, DefaultImageGetter.this.g(str, j));
            }
        }
    }

    static {
        if (h == null) {
            h = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        }
    }

    public DefaultImageGetter(String str, int i, Context context) {
        this.a = context;
        this.c = i;
        if (str == null) {
            str = "";
        } else if (!str.endsWith("/")) {
            str = str + "/";
        }
        this.e = str;
    }

    private static int h(BitmapFactory.Options options, int i) {
        IpChange ipChange = $ipChange;
        int i2 = 1;
        if (AndroidInstantRuntime.support(ipChange, "-1211792490")) {
            return ((Integer) ipChange.ipc$dispatch("-1211792490", new Object[]{options, Integer.valueOf(i)})).intValue();
        }
        int i3 = options.outWidth;
        if (i3 > i) {
            while ((i3 / 2) / i2 >= i) {
                i2 *= 2;
            }
        }
        return i2;
    }

    public static Bitmap i(InputStream inputStream, boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "836191381")) {
            return (Bitmap) ipChange.ipc$dispatch("836191381", new Object[]{inputStream, Boolean.valueOf(z), Integer.valueOf(i)});
        }
        if (inputStream == null) {
            return null;
        }
        if (z) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, null, options);
            options.inSampleSize = h(options, i);
            options.inJustDecodeBounds = false;
            return l(BitmapFactory.decodeStream(inputStream, null, options), i);
        }
        return l(BitmapFactory.decodeStream(inputStream), i);
    }

    private Drawable k(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-425616357")) {
            return (Drawable) ipChange.ipc$dispatch("-425616357", new Object[]{this, str});
        }
        ColorDrawable colorDrawable = new ColorDrawable(-3355444);
        if (str != null && !str.isEmpty()) {
            if (str.startsWith("/smiley")) {
                int i = this.d;
                colorDrawable.setBounds(0, 0, i, i);
            } else {
                int i2 = this.c;
                colorDrawable.setBounds(0, 0, i2, i2 / 2);
            }
        } else {
            colorDrawable.setBounds(0, 0, 120, 120);
        }
        return colorDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap l(Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "617369298")) {
            return (Bitmap) ipChange.ipc$dispatch("617369298", new Object[]{bitmap, Integer.valueOf(i)});
        }
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, i, (int) (((i * 1.0f) / bitmap.getWidth()) * bitmap.getHeight()), false);
    }

    public Drawable g(String str, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-387872560")) {
            return (Drawable) ipChange.ipc$dispatch("-387872560", new Object[]{this, str, bitmap});
        }
        if (bitmap == null) {
            return k(str);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.a.getResources(), bitmap);
        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        return bitmapDrawable;
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.ImageGetter
    public void getDrawable(String str, int i, int i2, ImageGetterCallBack imageGetterCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1400138878")) {
            ipChange.ipc$dispatch("-1400138878", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), imageGetterCallBack});
        } else if (imageGetterCallBack == null || TextUtils.isEmpty(str) || "null".equals(str) || "NULL".equals(str)) {
        } else {
            if (str.startsWith("smiley/")) {
                try {
                    imageGetterCallBack.onImageReady(str, i, i2, g(str, i(this.a.getAssets().open(str), false, this.d)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (str.startsWith("http://") || str.startsWith("https://")) {
                cn.damai.common.image.a.b().c(str).k(new DMRoundedCornersBitmapProcessor(5, 0)).n(new a(imageGetterCallBack, str, i, i2)).f();
            }
        }
    }

    public Bitmap j(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-491698004")) {
            return (Bitmap) ipChange.ipc$dispatch("-491698004", new Object[]{this, drawable});
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
