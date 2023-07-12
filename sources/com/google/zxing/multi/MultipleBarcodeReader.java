package com.google.zxing.multi;

import com.google.zxing.NotFoundException;
import java.util.Hashtable;
import tb.dc;
import tb.f32;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface MultipleBarcodeReader {
    f32[] decodeMultiple(dc dcVar) throws NotFoundException;

    f32[] decodeMultiple(dc dcVar, Hashtable hashtable) throws NotFoundException;
}
