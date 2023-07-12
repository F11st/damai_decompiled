package tb;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
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
    private static volatile com.airbnb.lottie.network.d i;
    private static volatile com.airbnb.lottie.network.c j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class a implements LottieNetworkCacheProvider {
        final /* synthetic */ Context a;

        a(Context context) {
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
    public static com.airbnb.lottie.network.c c(@NonNull Context context) {
        com.airbnb.lottie.network.c cVar = j;
        if (cVar == null) {
            synchronized (com.airbnb.lottie.network.c.class) {
                cVar = j;
                if (cVar == null) {
                    LottieNetworkCacheProvider lottieNetworkCacheProvider = h;
                    if (lottieNetworkCacheProvider == null) {
                        lottieNetworkCacheProvider = new a(context);
                    }
                    cVar = new com.airbnb.lottie.network.c(lottieNetworkCacheProvider);
                    j = cVar;
                }
            }
        }
        return cVar;
    }

    @NonNull
    public static com.airbnb.lottie.network.d d(@NonNull Context context) {
        com.airbnb.lottie.network.d dVar = i;
        if (dVar == null) {
            synchronized (com.airbnb.lottie.network.d.class) {
                dVar = i;
                if (dVar == null) {
                    com.airbnb.lottie.network.c c2 = c(context);
                    LottieNetworkFetcher lottieNetworkFetcher = g;
                    if (lottieNetworkFetcher == null) {
                        lottieNetworkFetcher = new com.airbnb.lottie.network.b();
                    }
                    dVar = new com.airbnb.lottie.network.d(c2, lottieNetworkFetcher);
                    i = dVar;
                }
            }
        }
        return dVar;
    }
}
