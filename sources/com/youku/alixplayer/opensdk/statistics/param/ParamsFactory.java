package com.youku.alixplayer.opensdk.statistics.param;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ParamsFactory {
    private ParamsFactory() {
    }

    public static IParams createParams(int i, String str) {
        if (i == 1021 || i == 8002) {
            return new CustomParams(str, ";", "=");
        }
        if (i != 80001) {
            return new CustomParams(str, "&", "=");
        }
        return new UriParams(str);
    }
}
