package cn.damai.commonbusiness.tab.download;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.LruCache;
import cn.damai.commonbusiness.util.Utils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tb.dw2;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ImageDownLoader {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String e = dw2.f(ImageDownLoader.class);
    private File d;
    private LruCache<String, Bitmap> b = new a(this, ((int) Runtime.getRuntime().maxMemory()) / 8);
    private Hashtable<String, Integer> a = new Hashtable<>();
    private ExecutorService c = Executors.newFixedThreadPool(10);

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface AsyncImageLoaderListener {
        void onImageLoader(Bitmap bitmap);
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a extends LruCache<String, Bitmap> {
        private static transient /* synthetic */ IpChange $ipChange;

        a(ImageDownLoader imageDownLoader, int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "975745633") ? ((Integer) ipChange.ipc$dispatch("975745633", new Object[]{this, str, bitmap})).intValue() : (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class b extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        private AsyncImageLoaderListener a;

        public b(AsyncImageLoaderListener asyncImageLoaderListener) {
            this.a = asyncImageLoaderListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1584089626")) {
                ipChange.ipc$dispatch("1584089626", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            this.a.onImageLoader((Bitmap) message.obj);
        }
    }

    public ImageDownLoader(Context context) {
        this.d = dw2.a(context, "cache");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-662763377")) {
            ipChange.ipc$dispatch("-662763377", new Object[]{this, str, bitmap});
        } else if (i(str) != null || bitmap == null) {
        } else {
            this.b.put(str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0192 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x019c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x017a  */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap g(java.lang.String r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.commonbusiness.tab.download.ImageDownLoader.g(java.lang.String, int, int):android.graphics.Bitmap");
    }

    private Bitmap i(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-661038091") ? (Bitmap) ipChange.ipc$dispatch("-661038091", new Object[]{this, str}) : this.b.get(str);
    }

    public Bitmap h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1751876788")) {
            return (Bitmap) ipChange.ipc$dispatch("-1751876788", new Object[]{this, str});
        }
        String replaceAll = str.replaceAll("[^\\w]", "");
        if (i(str) != null) {
            return i(str);
        }
        if (!dw2.e(this.d, replaceAll) || dw2.c(new File(this.d, replaceAll)) <= 0) {
            return null;
        }
        Application a2 = mu0.a();
        Bitmap c = Utils.c(a2, this.d.getPath() + File.separator + replaceAll);
        f(str, c);
        return c;
    }

    public void j(final String str, final int i, final int i2, AsyncImageLoaderListener asyncImageLoaderListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "65852165")) {
            ipChange.ipc$dispatch("65852165", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), asyncImageLoaderListener});
            return;
        }
        String str2 = e;
        Log.i(str2, "download: " + str);
        final b bVar = new b(asyncImageLoaderListener);
        Runnable runnable = new Runnable() { // from class: cn.damai.commonbusiness.tab.download.ImageDownLoader.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1140338704")) {
                    ipChange2.ipc$dispatch("1140338704", new Object[]{this});
                    return;
                }
                Bitmap g = ImageDownLoader.this.g(str, i, i2);
                if (g == null) {
                    String str3 = ImageDownLoader.e;
                    Log.d(str3, "download failure: " + str);
                    return;
                }
                Message obtainMessage = bVar.obtainMessage();
                obtainMessage.obj = g;
                bVar.sendMessage(obtainMessage);
                ImageDownLoader.this.f(str, g);
                long c = dw2.c(ImageDownLoader.this.d);
                if (c > 10485760) {
                    String str4 = ImageDownLoader.e;
                    Log.i(str4, ImageDownLoader.this.d + " size has exceed limit." + c);
                    dw2.b(ImageDownLoader.this.d, false);
                    ImageDownLoader.this.a.clear();
                }
                dw2.g(ImageDownLoader.this.d, str.replaceAll("[^\\w]", ""), g);
            }
        };
        this.a.put(str, 0);
        this.c.execute(runnable);
    }
}
