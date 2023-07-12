package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.parser.C2931t;
import com.airbnb.lottie.parser.moshi.JsonReader;
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
import okio.C8844h;
import tb.aw2;
import tb.f81;
import tb.hc1;
import tb.jc1;
import tb.kb1;
import tb.kc1;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.b */
/* loaded from: classes17.dex */
public class C2861b {
    private static final Map<String, LottieTask<C2821a>> a = new HashMap();
    private static final byte[] b = {80, 75, 3, 4};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.b$a */
    /* loaded from: classes9.dex */
    public class C2862a implements LottieListener<C2821a> {
        final /* synthetic */ String a;

        C2862a(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(C2821a c2821a) {
            C2861b.a.remove(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.b$b */
    /* loaded from: classes9.dex */
    public class C2863b implements LottieListener<Throwable> {
        final /* synthetic */ String a;

        C2863b(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            C2861b.a.remove(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.b$c */
    /* loaded from: classes17.dex */
    public class CallableC2864c implements Callable<kc1<C2821a>> {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        CallableC2864c(Context context, String str, String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public kc1<C2821a> call() {
            kc1<C2821a> c = f81.d(this.a).c(this.b, this.c);
            if (this.c != null && c.b() != null) {
                hc1.b().c(this.c, c.b());
            }
            return c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.b$d */
    /* loaded from: classes17.dex */
    public class CallableC2865d implements Callable<kc1<C2821a>> {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        CallableC2865d(Context context, String str, String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public kc1<C2821a> call() {
            return C2861b.g(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.b$e */
    /* loaded from: classes17.dex */
    public class CallableC2866e implements Callable<kc1<C2821a>> {
        final /* synthetic */ WeakReference a;
        final /* synthetic */ Context b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;

        CallableC2866e(WeakReference weakReference, Context context, int i, String str) {
            this.a = weakReference;
            this.b = context;
            this.c = i;
            this.d = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public kc1<C2821a> call() {
            Context context = (Context) this.a.get();
            if (context == null) {
                context = this.b;
            }
            return C2861b.r(context, this.c, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.b$f */
    /* loaded from: classes17.dex */
    public class CallableC2867f implements Callable<kc1<C2821a>> {
        final /* synthetic */ InputStream a;
        final /* synthetic */ String b;

        CallableC2867f(InputStream inputStream, String str) {
            this.a = inputStream;
            this.b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public kc1<C2821a> call() {
            return C2861b.i(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.b$g */
    /* loaded from: classes17.dex */
    public class CallableC2868g implements Callable<kc1<C2821a>> {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        CallableC2868g(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public kc1<C2821a> call() {
            return C2861b.n(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.b$h */
    /* loaded from: classes17.dex */
    public class CallableC2869h implements Callable<kc1<C2821a>> {
        final /* synthetic */ C2821a a;

        CallableC2869h(C2821a c2821a) {
            this.a = c2821a;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public kc1<C2821a> call() {
            return new kc1<>(this.a);
        }
    }

    private static LottieTask<C2821a> b(@Nullable String str, Callable<kc1<C2821a>> callable) {
        C2821a a2 = str == null ? null : hc1.b().a(str);
        if (a2 != null) {
            return new LottieTask<>(new CallableC2869h(a2));
        }
        if (str != null) {
            Map<String, LottieTask<C2821a>> map = a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        LottieTask<C2821a> lottieTask = new LottieTask<>(callable);
        if (str != null) {
            lottieTask.f(new C2862a(str));
            lottieTask.e(new C2863b(str));
            a.put(str, lottieTask);
        }
        return lottieTask;
    }

    @Nullable
    private static jc1 c(C2821a c2821a, String str) {
        for (jc1 jc1Var : c2821a.i().values()) {
            if (jc1Var.b().equals(str)) {
                return jc1Var;
            }
        }
        return null;
    }

    public static LottieTask<C2821a> d(Context context, String str) {
        return e(context, str, "asset_" + str);
    }

    public static LottieTask<C2821a> e(Context context, String str, @Nullable String str2) {
        return b(str2, new CallableC2865d(context.getApplicationContext(), str, str2));
    }

    @WorkerThread
    public static kc1<C2821a> f(Context context, String str) {
        return g(context, str, "asset_" + str);
    }

    @WorkerThread
    public static kc1<C2821a> g(Context context, String str, @Nullable String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return i(context.getAssets().open(str), str2);
            }
            return u(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new kc1<>(e);
        }
    }

    public static LottieTask<C2821a> h(InputStream inputStream, @Nullable String str) {
        return b(str, new CallableC2867f(inputStream, str));
    }

    @WorkerThread
    public static kc1<C2821a> i(InputStream inputStream, @Nullable String str) {
        return j(inputStream, str, true);
    }

    @WorkerThread
    private static kc1<C2821a> j(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return k(JsonReader.p(C8844h.d(C8844h.k(inputStream))), str);
        } finally {
            if (z) {
                aw2.c(inputStream);
            }
        }
    }

    @WorkerThread
    public static kc1<C2821a> k(JsonReader jsonReader, @Nullable String str) {
        return l(jsonReader, str, true);
    }

    private static kc1<C2821a> l(JsonReader jsonReader, @Nullable String str, boolean z) {
        try {
            try {
                C2821a a2 = C2931t.a(jsonReader);
                if (str != null) {
                    hc1.b().c(str, a2);
                }
                kc1<C2821a> kc1Var = new kc1<>(a2);
                if (z) {
                    aw2.c(jsonReader);
                }
                return kc1Var;
            } catch (Exception e) {
                kc1<C2821a> kc1Var2 = new kc1<>(e);
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

    public static LottieTask<C2821a> m(String str, @Nullable String str2) {
        return b(str2, new CallableC2868g(str, str2));
    }

    @WorkerThread
    public static kc1<C2821a> n(String str, @Nullable String str2) {
        return k(JsonReader.p(C8844h.d(C8844h.k(new ByteArrayInputStream(str.getBytes())))), str2);
    }

    public static LottieTask<C2821a> o(Context context, @RawRes int i) {
        return p(context, i, y(context, i));
    }

    public static LottieTask<C2821a> p(Context context, @RawRes int i, @Nullable String str) {
        return b(str, new CallableC2866e(new WeakReference(context), context.getApplicationContext(), i, str));
    }

    @WorkerThread
    public static kc1<C2821a> q(Context context, @RawRes int i) {
        return r(context, i, y(context, i));
    }

    @WorkerThread
    public static kc1<C2821a> r(Context context, @RawRes int i, @Nullable String str) {
        try {
            BufferedSource d = C8844h.d(C8844h.k(context.getResources().openRawResource(i)));
            if (x(d).booleanValue()) {
                return u(new ZipInputStream(d.inputStream()), str);
            }
            return i(d.inputStream(), str);
        } catch (Resources.NotFoundException e) {
            return new kc1<>(e);
        }
    }

    public static LottieTask<C2821a> s(Context context, String str) {
        return t(context, str, "url_" + str);
    }

    public static LottieTask<C2821a> t(Context context, String str, @Nullable String str2) {
        return b(str2, new CallableC2864c(context, str, str2));
    }

    @WorkerThread
    public static kc1<C2821a> u(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return v(zipInputStream, str);
        } finally {
            aw2.c(zipInputStream);
        }
    }

    @WorkerThread
    private static kc1<C2821a> v(ZipInputStream zipInputStream, @Nullable String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            C2821a c2821a = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    c2821a = l(JsonReader.p(C8844h.d(C8844h.k(zipInputStream))), null, false).b();
                } else {
                    if (!name.contains(".png") && !name.contains(".webp") && !name.contains(".jpg") && !name.contains(".jpeg")) {
                        zipInputStream.closeEntry();
                    }
                    hashMap.put(name.split("/")[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (c2821a == null) {
                return new kc1<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                jc1 c = c(c2821a, (String) entry.getKey());
                if (c != null) {
                    c.f(aw2.l((Bitmap) entry.getValue(), c.e(), c.c()));
                }
            }
            for (Map.Entry<String, jc1> entry2 : c2821a.i().entrySet()) {
                if (entry2.getValue().a() == null) {
                    return new kc1<>(new IllegalStateException("There is no image for " + entry2.getValue().b()));
                }
            }
            if (str != null) {
                hc1.b().c(str, c2821a);
            }
            return new kc1<>(c2821a);
        } catch (IOException e) {
            return new kc1<>(e);
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
        } catch (Exception e) {
            kb1.b("Failed to check zip file header", e);
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
