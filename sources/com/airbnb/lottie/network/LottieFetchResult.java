package com.airbnb.lottie.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface LottieFetchResult extends Closeable {
    @NonNull
    InputStream bodyByteStream() throws IOException;

    @Nullable
    String contentType();

    @Nullable
    String error();

    boolean isSuccessful();
}
