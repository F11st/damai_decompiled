package okhttp3;

import java.util.Collections;
import java.util.List;
import tb.go;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface CookieJar {
    public static final CookieJar NO_COOKIES = new a();

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    class a implements CookieJar {
        a() {
        }

        @Override // okhttp3.CookieJar
        public List<go> loadForRequest(m mVar) {
            return Collections.emptyList();
        }

        @Override // okhttp3.CookieJar
        public void saveFromResponse(m mVar, List<go> list) {
        }
    }

    List<go> loadForRequest(m mVar);

    void saveFromResponse(m mVar, List<go> list);
}
