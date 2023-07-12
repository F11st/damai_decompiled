package okhttp3;

import java.util.Collections;
import java.util.List;
import tb.go;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface CookieJar {
    public static final CookieJar NO_COOKIES = new C8731a();

    /* compiled from: Taobao */
    /* renamed from: okhttp3.CookieJar$a */
    /* loaded from: classes2.dex */
    class C8731a implements CookieJar {
        C8731a() {
        }

        @Override // okhttp3.CookieJar
        public List<go> loadForRequest(C8818m c8818m) {
            return Collections.emptyList();
        }

        @Override // okhttp3.CookieJar
        public void saveFromResponse(C8818m c8818m, List<go> list) {
        }
    }

    List<go> loadForRequest(C8818m c8818m);

    void saveFromResponse(C8818m c8818m, List<go> list);
}
