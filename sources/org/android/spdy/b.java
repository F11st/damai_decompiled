package org.android.spdy;

import android.util.LruCache;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class b {
    private static b b = new b();
    private LruCache<ByteBuffer, String> a = new LruCache<>(128);

    private b() {
    }

    public static b b() {
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
