package com.taobao.alivfssdk.fresco.binaryresource;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface BinaryResource {
    InputStream openStream() throws IOException;

    byte[] read() throws IOException;

    long size();
}
