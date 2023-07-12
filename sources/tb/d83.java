package tb;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class d83 {
    public static final ThreadLocal<Charset> a;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a extends ThreadLocal<CharsetDecoder> {
        a() {
        }

        private static CharsetDecoder a() {
            return Charset.forName("UTF-8").newDecoder();
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ CharsetDecoder initialValue() {
            return a();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class b extends ThreadLocal<Charset> {
        b() {
        }

        private static Charset a() {
            return Charset.forName("UTF-8");
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ Charset initialValue() {
            return a();
        }
    }

    static {
        new a();
        a = new b();
        new ThreadLocal();
    }
}
