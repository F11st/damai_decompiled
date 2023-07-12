package com.google.zxing;

import java.util.Hashtable;
import tb.fa;
import tb.nc;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface Writer {
    nc encode(String str, fa faVar, int i, int i2) throws WriterException;

    nc encode(String str, fa faVar, int i, int i2, Hashtable hashtable) throws WriterException;
}
