package com.squareup.okhttp;

import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface Callback {
    void onFailure(Request request, IOException iOException);

    void onResponse(Response response) throws IOException;
}
