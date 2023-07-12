package com.youku.middlewareservice.provider.info;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface EnvUrlProvider {
    String getDailyUrl();

    int getEnvType();

    String getOnlineUrl();

    String getPreUrl();

    String getUrl();

    boolean isDaily();

    boolean isOnline();

    boolean isPre();
}
