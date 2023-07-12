package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.t;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import tb.aw2;
import tb.f81;
import tb.hc1;
import tb.jc1;
import tb.kb1;
import tb.kc1;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class b {
    private static final Map<String, LottieTask<com.airbnb.lottie.a>> a = new HashMap();
    private static final byte[] b = {80, 75, 3, 4};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class a implements LottieListener<com.airbnb.lottie.a> {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(com.airbnb.lottie.a aVar) {
            b.a.remove(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0101b implements LottieListener<Throwable> {
        final /* synthetic */ String a;

        C0101b(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            b.a.remove(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class c implements Callable<kc1<com.airbnb.lottie.a>> {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        c(Context context, String str, String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public kc1<com.airbnb.lottie.a> call() {
            kc1<com.airbnb.lottie.a> c = f81.d(this.a).c(this.b, this.c);
            if (this.c != null && c.b() != null) {
                hc1.b().c(this.c, c.b());
            }
            return c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class d implements Callable<kc1<com.airbnb.lottie.a>> {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        d(Context context, String str, String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public kc1<com.airbnb.lottie.a> call() {
            return b.g(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class e implements Callable<kc1<com.airbnb.lottie.a>> {
        final /* synthetic */ WeakReference a;
        final /* synthetic */ Context b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;

        e(WeakReference weakReference, Context context, int i, String str) {
            this.a = weakReference;
            this.b = context;
            this.c = i;
            this.d = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public kc1<com.airbnb.lottie.a> call() {
            Context context = (Context) this.a.get();
            if (context == null) {
                context = this.b;
            }
            return b.r(context, this.c, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class f implements Callable<kc1<com.airbnb.lottie.a>> {
        final /* synthetic */ InputStream a;
        final /* synthetic */ String b;

        f(InputStream inputStream, String str) {
            this.a = inputStream;
            this.b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public kc1<com.airbnb.lottie.a> call() {
            return b.i(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class g implements Callable<kc1<com.airbnb.lottie.a>> {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        g(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public kc1<com.airbnb.lottie.a> call() {
            return b.n(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class h implements Callable<kc1<com.airbnb.lottie.a>> {
        final /* synthetic */ com.airbnb.lottie.a a;

        h(com.airbnb.lottie.a aVar) {
            this.a = aVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public kc1<com.airbnb.lottie.a> call() {
            return new kc1<>(this.a);
        }
    }

    private static LottieTask<com.airbnb.lottie.a> b(@Nullable String str, Callable<kc1<com.airbnb.lottie.a>> callable) {
        com.airbnb.lottie.a a2 = str == null ? null : hc1.b().a(str);
        if (a2 != null) {
            return new LottieTask<>(new h(a2));
        }
        if (str != null) {
            Map<String, LottieTask<com.airbnb.lottie.a>> map = a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        LottieTask<com.airbnb.lottie.a> lottieTask = new LottieTask<>(callable);
        if (str != null) {
            lottieTask.f(new a(str));
            lottieTask.e(new C0101b(str));
            a.put(str, lottieTask);
        }
        return lottieTask;
    }

    @Nullable
    private static jc1 c(com.airbnb.lottie.a aVar, String str) {
        for (jc1 jc1Var : aVar.i().values()) {
            if (jc1Var.b().equals(str)) {
                return jc1Var;
            }
        }
        return null;
    }

    public static LottieTask<com.airbnb.lottie.a> d(Context context, String str) {
        return e(context, str, "asset_" + str);
    }

    public static LottieTask<com.airbnb.lottie.a> e(Context context, String str, @Nullable String str2) {
        return b(str2, new d(context.getApplicationContext(), str, str2));
    }

    @WorkerThread
    public static kc1<com.airbnb.lottie.a> f(Context context, String str) {
        return g(context, str, "asset_" + str);
    }

    @WorkerThread
    public static kc1<com.airbnb.lottie.a> g(Context context, String str, @Nullable String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return i(context.getAssets().open(str), str2);
            }
            return u(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e2) {
            return new kc1<>(e2);
        }
    }

    public static LottieTask<com.airbnb.lottie.a> h(InputStream inputStream, @Nullable String str) {
        return b(str, new f(inputStream, str));
    }

    @WorkerThread
    public static kc1<com.airbnb.lottie.a> i(InputStream inputStream, @Nullable String str) {
        return j(inputStream, str, true);
    }

    @WorkerThread
    private static kc1<com.airbnb.lottie.a> j(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return k(JsonReader.p(okio.h.d(okio.h.k(inputStream))), str);
        } finally {
            if (z) {
                aw2.c(inputStream);
            }
        }
    }

    @WorkerThread
    public static kc1<com.airbnb.lottie.a> k(JsonReader jsonReader, @Nullable String str) {
        return l(jsonReader, str, true);
    }

    private static kc1<com.airbnb.lottie.a> l(JsonReader jsonReader, @Nullable String str, boolean z) {
        try {
            try {
                com.airbnb.lottie.a a2 = t.a(jsonReader);
                if (str != null) {
                    hc1.b().c(str, a2);
                }
                kc1<com.airbnb.lottie.a> kc1Var = new kc1<>(a2);
                if (z) {
                    aw2.c(jsonReader);
                }
                return kc1Var;
            } catch (Exception e2) {
                kc1<com.airbnb.lottie.a> kc1Var2 = new kc1<>(e2);
                if (z) {
                    aw2.c(jsonReader);
                }
                return kc1Var2;
            }
        } catch (Throwable th) {
            if (z) {
                aw2.c(jsonReader);
            }
            throw th;
        }
    }

    public static LottieTask<com.airbnb.lottie.a> m(String str, @Nullable String str2) {
        return b(str2, new g(str, str2));
    }

    @WorkerThread
    public static kc1<com.airbnb.lottie.a> n(String str, @Nullable String str2) {
        return k(JsonReader.p(okio.h.d(okio.h.k(new ByteArrayInputStream(str.getBytes())))), str2);
    }

    public static LottieTask<com.airbnb.lottie.a> o(Context context, @RawRes int i) {
        return p(context, i, y(context, i));
    }

    public static LottieTask<com.airbnb.lottie.a> p(Context context, @RawRes int i, @Nullable String str) {
        return b(str, new e(new WeakReference(context), context.getApplicationContext(), i, str));
    }

    @WorkerThread
    public static kc1<com.airbnb.lottie.a> q(Context context, @RawRes int i) {
        return r(context, i, y(context, i));
    }

    @WorkerThread
    public static kc1<com.airbnb.lottie.a> r(Context context, @RawRes int i, @Nullable String str) {
        try {
            BufferedSource d2 = okio.h.d(okio.h.k(context.getResources().openRawResource(i)));
            if (x(d2).booleanValue()) {
                return u(new ZipInputStream(d2.inputStream()), str);
            }
            return i(d2.inputStream(), str);
        } catch (Resources.NotFoundException e2) {
            return new kc1<>(e2);
        }
    }

    public static LottieTask<com.airbnb.lottie.a> s(Context context, String str) {
        return t(context, str, "url_" + str);
    }

    public static LottieTask<com.airbnb.lottie.a> t(Context context, String str, @Nullable String str2) {
        return b(str2, new c(context, str, str2));
    }

    @WorkerThread
    public static kc1<com.airbnb.lottie.a> u(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return v(zipInputStream, str);
        } finally {
            aw2.c(zipInputStream);
        }
    }

    @WorkerThread
    private static kc1<com.airbnb.lottie.a> v(ZipInputStream zipInputStream, @Nullable String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            com.airbnb.lottie.a aVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    aVar = l(JsonReader.p(okio.h.d(okio.h.k(zipInputStream))), null, false).b();
                } else {
                    if (!name.contains(".png") && !name.contains(".webp") && !name.contains(".jpg") && !name.contains(".jpeg")) {
                        zipInputStream.closeEntry();
                    }
                    hashMap.put(name.split("/")[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (aVar == null) {
                return new kc1<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                jc1 c2 = c(aVar, (String) entry.getKey());
                if (c2 != null) {
                    c2.f(aw2.l((Bitmap) entry.getValue(), c2.e(), c2.c()));
                }
            }
            for (Map.Entry<String, jc1> entry2 : aVar.i().entrySet()) {
                if (entry2.getValue().a() == null) {
                    return new kc1<>(new IllegalStateException("There is no image for " + entry2.getValue().b()));
                }
            }
            if (str != null) {
                hc1.b().c(str, aVar);
            }
            return new kc1<>(aVar);
        } catch (IOException e2) {
            return new kc1<>(e2);
        }
    }

    private static boolean w(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static Boolean x(BufferedSource bufferedSource) {
        try {
            BufferedSource peek = bufferedSource.peek();
            for (byte b2 : b) {
                if (peek.readByte() != b2) {
                    return Boolean.FALSE;
                }
            }
            peek.close();
            return Boolean.TRUE;
        } catch (Exception e2) {
            kb1.b("Failed to check zip file header", e2);
            return Boolean.FALSE;
        }
    }

    private static String y(Context context, @RawRes int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(w(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }
}
