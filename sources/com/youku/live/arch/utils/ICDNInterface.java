package com.youku.live.arch.utils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface ICDNInterface {
    String blurUrl(String str);

    String blurUrl(String str, int i, int i2);

    String blurWithSize(String str, int i, int i2, int i3, int i4);

    String decideUrl(String str, int i, int i2);

    String decideUrl(String str, int i, int i2, boolean z);

    boolean isOSSDomain(String str);

    boolean isTFSDomain(String str);
}
