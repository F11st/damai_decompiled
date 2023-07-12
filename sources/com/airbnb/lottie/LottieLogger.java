package com.airbnb.lottie;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface LottieLogger {
    void debug(String str);

    void debug(String str, Throwable th);

    void error(String str, Throwable th);

    void warning(String str);

    void warning(String str, Throwable th);
}
