package org.android.spdy;

import android.util.LruCache;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* renamed from: org.android.spdy.b */
/* loaded from: classes2.dex */
class C8878b {
    private static C8878b b = new C8878b();
    private LruCache<ByteBuffer, String> a = new LruCache<>(128);

    private C8878b() {
    }

    public static C8878b b() {
        return b;
    }

    public String a(ByteBuffer byteBuffer) {
        String str = this.a.get(byteBuffer);
        if (str != null) {
            return str;
        }
        try {
            str = new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit() - byteBuffer.position(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.a.put(byteBuffer, str);
        return str;
    }
}
