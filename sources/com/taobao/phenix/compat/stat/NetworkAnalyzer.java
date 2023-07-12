package com.taobao.phenix.compat.stat;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface NetworkAnalyzer {
    boolean isCertificateException(Throwable th);

    boolean isConnectTimeoutException(Throwable th);

    boolean isIndifferentException(Throwable th);

    boolean isInvalidHostException(Throwable th);

    boolean isInvalidUrlException(Throwable th);

    boolean isNoNetworkException(Throwable th);

    boolean isReadTimeoutException(Throwable th);

    String keyOfCdnIpPort();

    String keyOfConnectType();

    String keyOfFirstData();

    String keyOfHitCdnCache();

    String keyOfResponseCode();

    String keyOfSendBefore();

    String keyOfServerRt();
}
