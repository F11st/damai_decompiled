package com.squareup.okhttp;

import java.io.IOException;
import java.net.Proxy;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface Authenticator {
    Request authenticate(Proxy proxy, Response response) throws IOException;

    Request authenticateProxy(Proxy proxy, Response response) throws IOException;
}
