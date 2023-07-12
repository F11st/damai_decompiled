package com.squareup.okhttp.internal.http;

import java.io.IOException;
import okio.Sink;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface CacheRequest {
    void abort();

    Sink body() throws IOException;
}
