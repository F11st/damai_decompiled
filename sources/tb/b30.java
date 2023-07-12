package tb;

import com.ali.ha.datahub.BizSubscriber;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class b30 {
    private BizSubscriber a;

    /* compiled from: Taobao */
    /* renamed from: tb.b30$b */
    /* loaded from: classes9.dex */
    private static final class C8947b {
        public static final b30 sInstance = new b30();
    }

    /* compiled from: Taobao */
    /* renamed from: tb.b30$c */
    /* loaded from: classes9.dex */
    private static class C8948c {
        private BizSubscriber a;

        private C8948c(BizSubscriber bizSubscriber) {
            this.a = bizSubscriber;
        }
    }

    public static final b30 a() {
        return C8947b.sInstance;
    }

    private HashMap<String, String> d(HashMap<String, String> hashMap) {
        if (c30.a) {
            if (hashMap == null) {
                return null;
            }
            try {
                return new HashMap<>(hashMap);
            } catch (Exception unused) {
                return new HashMap<>();
            }
        }
        return hashMap;
    }

    public void b(BizSubscriber bizSubscriber) {
        if (this.a == null) {
            this.a = bizSubscriber;
            new C8948c(bizSubscriber);
        }
    }

    public void c(String str, HashMap<String, String> hashMap) {
        BizSubscriber bizSubscriber = this.a;
        if (bizSubscriber == null) {
            return;
        }
        bizSubscriber.pub(str, d(hashMap));
    }

    private b30() {
    }
}
