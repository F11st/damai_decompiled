package com.taobao.phenix.cache.disk;

import android.content.Context;
import java.io.InputStream;
import tb.p22;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface DiskCache {
    @Deprecated
    public static final int EXTREME_HIGH_PRIORITY = 51;
    @Deprecated
    public static final int HIGH_PRIORITY = 34;
    @Deprecated
    public static final int MEDIUM_PRIORITY = 17;

    void clear();

    boolean close();

    p22 get(String str, int i);

    int[] getCatalogs(String str);

    long getLength(String str, int i);

    int getPriority();

    boolean isSupportCatalogs();

    void maxSize(int i);

    boolean open(Context context);

    boolean put(String str, int i, InputStream inputStream);

    boolean put(String str, int i, byte[] bArr, int i2, int i3);

    boolean remove(String str, int i);
}
