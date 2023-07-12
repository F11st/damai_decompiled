package com.airbnb.lottie.network;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;
import tb.kb1;
import tb.kc1;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class d {
    @NonNull
    private final c a;
    @NonNull
    private final LottieNetworkFetcher b;

    public d(@NonNull c cVar, @NonNull LottieNetworkFetcher lottieNetworkFetcher) {
        this.a = cVar;
        this.b = lottieNetworkFetcher;
    }

    @Nullable
    @WorkerThread
    private com.airbnb.lottie.a a(@NonNull String str, @Nullable String str2) {
        Pair<FileExtension, InputStream> a;
        kc1<com.airbnb.lottie.a> i;
        if (str2 == null || (a = this.a.a(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) a.first;
        InputStream inputStream = (InputStream) a.second;
        if (fileExtension == FileExtension.ZIP) {
            i = com.airbnb.lottie.b.u(new ZipInputStream(inputStream), str);
        } else {
            i = com.airbnb.lottie.b.i(inputStream, str);
        }
        if (i.b() != null) {
            return i.b();
        }
        return null;
    }

    @NonNull
    @WorkerThread
    private kc1<com.airbnb.lottie.a> b(@NonNull String str, @Nullable String str2) {
        kb1.a("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                LottieFetchResult fetchSync = this.b.fetchSync(str);
                if (fetchSync.isSuccessful()) {
                    kc1<com.airbnb.lottie.a> d = d(str, fetchSync.bodyByteStream(), fetchSync.contentType(), str2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Completed fetch from network. Success: ");
                    sb.append(d.b() != null);
                    kb1.a(sb.toString());
                    try {
                        fetchSync.close();
                    } catch (IOException e) {
                        kb1.d("LottieFetchResult close failed ", e);
                    }
                    return d;
                }
                kc1<com.airbnb.lottie.a> kc1Var = new kc1<>(new IllegalArgumentException(fetchSync.error()));
                try {
                    fetchSync.close();
                } catch (IOException e2) {
                    kb1.d("LottieFetchResult close failed ", e2);
                }
                return kc1Var;
            } catch (Exception e3) {
                kc1<com.airbnb.lottie.a> kc1Var2 = new kc1<>(e3);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e4) {
                        kb1.d("LottieFetchResult close failed ", e4);
                    }
                }
                return kc1Var2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e5) {
                    kb1.d("LottieFetchResult close failed ", e5);
                }
            }
            throw th;
        }
    }

    @NonNull
    private kc1<com.airbnb.lottie.a> d(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2, @Nullable String str3) throws IOException {
        FileExtension fileExtension;
        kc1<com.airbnb.lottie.a> f;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (!str2.contains("application/zip") && !str.split("\\?")[0].endsWith(".lottie")) {
            kb1.a("Received json response.");
            fileExtension = FileExtension.JSON;
            f = e(str, inputStream, str3);
        } else {
            kb1.a("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            f = f(str, inputStream, str3);
        }
        if (str3 != null && f.b() != null) {
            this.a.e(str, fileExtension);
        }
        return f;
    }

    @NonNull
    private kc1<com.airbnb.lottie.a> e(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return com.airbnb.lottie.b.i(inputStream, null);
        }
        return com.airbnb.lottie.b.i(new FileInputStream(new File(this.a.f(str, inputStream, FileExtension.JSON).getAbsolutePath())), str);
    }

    @NonNull
    private kc1<com.airbnb.lottie.a> f(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return com.airbnb.lottie.b.u(new ZipInputStream(inputStream), null);
        }
        return com.airbnb.lottie.b.u(new ZipInputStream(new FileInputStream(this.a.f(str, inputStream, FileExtension.ZIP))), str);
    }

    @NonNull
    @WorkerThread
    public kc1<com.airbnb.lottie.a> c(@NonNull String str, @Nullable String str2) {
        com.airbnb.lottie.a a = a(str, str2);
        if (a != null) {
            return new kc1<>(a);
        }
        kb1.a("Animation for " + str + " not found in cache. Fetching from network.");
        return b(str, str2);
    }
}
