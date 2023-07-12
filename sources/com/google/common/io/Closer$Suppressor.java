package com.google.common.io;

import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;

/* compiled from: Taobao */
@VisibleForTesting
/* loaded from: classes10.dex */
interface Closer$Suppressor {
    void suppress(Closeable closeable, Throwable th, Throwable th2);
}
