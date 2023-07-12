package tb;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import com.airbnb.lottie.network.C2886b;
import com.airbnb.lottie.network.C2887c;
import com.airbnb.lottie.network.C2888d;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import java.io.File;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes9.dex */
public class f81 {
    public static final String TAG = "LOTTIE";
    public static boolean a;
    private static boolean b;
    private static String[] c;
    private static long[] d;
    private static int e;
    private static int f;
    private static LottieNetworkFetcher g;
    private static LottieNetworkCacheProvider h;
    private static volatile C2888d i;
    private static volatile C2887c j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.f81$a */
    /* loaded from: classes9.dex */
    public class C9130a implements LottieNetworkCacheProvider {
        final /* synthetic */ Context a;

        C9130a(Context context) {
            this.a = context;
        }

        @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
        @NonNull
        public File getCacheDir() {
            return new File(this.a.getCacheDir(), "lottie_network_cache");
        }
    }

    public static void a(String str) {
        if (b) {
            int i2 = e;
            if (i2 == 20) {
                f++;
                return;
            }
            c[i2] = str;
            d[i2] = System.nanoTime();
            TraceCompat.beginSection(str);
            e++;
        }
    }

    public static float b(String str) {
        int i2 = f;
        if (i2 > 0) {
            f = i2 - 1;
            return 0.0f;
        } else if (b) {
            int i3 = e - 1;
            e = i3;
            if (i3 != -1) {
                if (str.equals(c[i3])) {
                    TraceCompat.endSection();
                    return ((float) (System.nanoTime() - d[e])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + c[e] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else {
            return 0.0f;
        }
    }

    @NonNull
    public static C2887c c(@NonNull Context context) {
        C2887c c2887c = j;
        if (c2887c == null) {
            synchronized (C2887c.class) {
                c2887c = j;
                if (c2887c == null) {
                    LottieNetworkCacheProvider lottieNetworkCacheProvider = h;
                    if (lottieNetworkCacheProvider == null) {
                        lottieNetworkCacheProvider = new C9130a(context);
                    }
                    c2887c = new C2887c(lottieNetworkCacheProvider);
                    j = c2887c;
                }
            }
        }
        return c2887c;
    }

    @NonNull
    public static C2888d d(@NonNull Context context) {
        C2888d c2888d = i;
        if (c2888d == null) {
            synchronized (C2888d.class) {
                c2888d = i;
                if (c2888d == null) {
                    C2887c c2 = c(context);
                    LottieNetworkFetcher lottieNetworkFetcher = g;
                    if (lottieNetworkFetcher == null) {
                        lottieNetworkFetcher = new C2886b();
                    }
                    c2888d = new C2888d(c2, lottieNetworkFetcher);
                    i = c2888d;
                }
            }
        }
        return c2888d;
    }
}
