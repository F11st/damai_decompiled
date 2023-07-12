package com.google.zxing;

import java.util.Hashtable;
import tb.dc;
import tb.f32;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface Reader {
    f32 decode(dc dcVar) throws NotFoundException, ChecksumException, FormatException;

    f32 decode(dc dcVar, Hashtable hashtable) throws NotFoundException, ChecksumException, FormatException;

    void reset();
}
