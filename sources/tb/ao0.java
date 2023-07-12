package tb;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import io.flutter.embedding.android.FlutterEngineProvider;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ao0 {
    private final String a;
    private final String b;
    private final String[] c;
    private final boolean d;
    private FlutterEngineProvider e;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b {
        private String a = "/";
        private String b = lu2.MAIN;
        private boolean c = false;
        private String[] d;
        private FlutterEngineProvider e;

        public ao0 f() {
            return new ao0(this);
        }

        public b g(String[] strArr) {
            this.d = strArr;
            return this;
        }
    }

    public static ao0 a() {
        return new b().f();
    }

    public String b() {
        return this.b;
    }

    public FlutterEngineProvider c() {
        return this.e;
    }

    public String d() {
        return this.a;
    }

    public String[] e() {
        return this.c;
    }

    public boolean f() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.ARRAY_START);
        String[] strArr = this.c;
        if (strArr != null && strArr.length != 0) {
            int i = 0;
            while (true) {
                sb.append(String.valueOf(this.c[i]));
                if (i == this.c.length - 1) {
                    break;
                }
                sb.append(AVFSCacheConstants.COMMA_SEP);
                i++;
            }
            sb.append(jn1.ARRAY_END);
        } else {
            sb.append(jn1.ARRAY_END);
        }
        return "initialRoute:" + this.a + ", dartEntrypoint:" + this.b + ", shouldOverrideBackForegroundEvent:" + this.d + ", shellArgs:" + sb.toString();
    }

    private ao0(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.d;
        this.d = bVar.c;
        this.e = bVar.e;
    }
}
