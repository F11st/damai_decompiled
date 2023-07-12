package com.taobao.phenix.compat.alivfs;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface AlivfsVerifyListener {
    long getCurrentTime();

    boolean isExpectedTime(long j);

    boolean isTTLDomain(String str);
}
