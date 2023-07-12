package tb;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class d83 {
    public static final ThreadLocal<Charset> a;

    /* compiled from: Taobao */
    /* renamed from: tb.d83$a */
    /* loaded from: classes10.dex */
    static class C9032a extends ThreadLocal<CharsetDecoder> {
        C9032a() {
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
    /* renamed from: tb.d83$b */
    /* loaded from: classes10.dex */
    static class C9033b extends ThreadLocal<Charset> {
        C9033b() {
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
        new C9032a();
        a = new C9033b();
        new ThreadLocal();
    }
}
