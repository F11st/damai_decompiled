package tb;

import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import kotlin.collections.C8207h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class eq0 {
    @NotNull
    public static final eq0 INSTANCE = new eq0();

    private eq0() {
    }

    private final int a(byte[] bArr) {
        return (bArr[0] & 255) | ((bArr[1] & 255) << 8);
    }

    private final C9107a d(File file) {
        C9107a c9107a = new C9107a(null, null, null, null, 15, null);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            int length = (int) file.length();
            if (fileInputStream.read(new byte[100], 0, 100) <= 0) {
                xj.a(fileInputStream, null);
                return null;
            }
            int i = length - 100;
            while (i > 0) {
                byte[] bArr = new byte[4];
                int read = fileInputStream.read(bArr, 0, 4);
                eq0 eq0Var = INSTANCE;
                int a = eq0Var.a(bArr);
                int i2 = i - read;
                byte[] bArr2 = new byte[a];
                int read2 = fileInputStream.read(bArr2, 0, a);
                Charset forName = Charset.forName("UTF-8");
                b41.h(forName, "forName(\"UTF-8\")");
                String str = new String(bArr2, forName);
                int i3 = i2 - read2;
                byte[] bArr3 = new byte[4];
                int read3 = fileInputStream.read(bArr3, 0, 4);
                int a2 = eq0Var.a(bArr3);
                int i4 = i3 - read3;
                byte[] bArr4 = new byte[a2];
                int read4 = fileInputStream.read(bArr4, 0, a2);
                Charset forName2 = Charset.forName("UTF-8");
                b41.h(forName2, "forName(\"UTF-8\")");
                String str2 = new String(bArr4, forName2);
                i = i4 - read4;
                switch (str.hashCode()) {
                    case -1510940545:
                        if (!str.equals("index.databinding")) {
                            break;
                        } else {
                            c9107a.f(str2);
                            break;
                        }
                    case -808658201:
                        if (!str.equals("index.css")) {
                            break;
                        } else {
                            c9107a.e(str2);
                            break;
                        }
                    case 112461797:
                        if (!str.equals("index.js")) {
                            break;
                        } else {
                            c9107a.g(str2);
                            break;
                        }
                    case 701608068:
                        if (!str.equals("index.json")) {
                            break;
                        } else {
                            c9107a.h(str2);
                            break;
                        }
                }
            }
            wt2 wt2Var = wt2.INSTANCE;
            xj.a(fileInputStream, null);
            return c9107a;
        } finally {
        }
    }

    private final C9107a e(byte[] bArr) {
        byte[] g;
        byte[] g2;
        byte[] g3;
        byte[] g4;
        byte[] g5;
        C9107a c9107a = new C9107a(null, null, null, null, 15, null);
        int length = bArr.length;
        int i = 100;
        g = C8207h.g(bArr, 0, 100);
        if (g.length <= 0) {
            return null;
        }
        int i2 = length - 100;
        while (i2 > 0) {
            g2 = C8207h.g(bArr, i, i + 4);
            int length2 = g2.length;
            int i3 = i + length2;
            int i4 = i2 - length2;
            g3 = C8207h.g(bArr, i3, a(g2) + i3);
            int length3 = g3.length;
            Charset forName = Charset.forName("UTF-8");
            b41.h(forName, "forName(\"UTF-8\")");
            String str = new String(g3, forName);
            int i5 = i3 + length3;
            int i6 = i4 - length3;
            g4 = C8207h.g(bArr, i5, i5 + 4);
            int length4 = g4.length;
            int i7 = i5 + length4;
            int i8 = i6 - length4;
            g5 = C8207h.g(bArr, i7, a(g4) + i7);
            int length5 = g5.length;
            Charset forName2 = Charset.forName("UTF-8");
            b41.h(forName2, "forName(\"UTF-8\")");
            String str2 = new String(g5, forName2);
            i = i7 + length5;
            i2 = i8 - length5;
            switch (str.hashCode()) {
                case -1510940545:
                    if (!str.equals("index.databinding")) {
                        break;
                    } else {
                        c9107a.f(str2);
                        break;
                    }
                case -808658201:
                    if (!str.equals("index.css")) {
                        break;
                    } else {
                        c9107a.e(str2);
                        break;
                    }
                case 112461797:
                    if (!str.equals("index.js")) {
                        break;
                    } else {
                        c9107a.g(str2);
                        break;
                    }
                case 701608068:
                    if (!str.equals("index.json")) {
                        break;
                    } else {
                        c9107a.h(str2);
                        break;
                    }
            }
        }
        return c9107a;
    }

    @NotNull
    public final JSONObject b(@NotNull File file) {
        b41.i(file, "binFile");
        JSONObject jSONObject = new JSONObject();
        C9107a d = d(file);
        if (d != null) {
            jSONObject.put((JSONObject) "layer", d.d());
            jSONObject.put((JSONObject) "databinding", d.b());
            jSONObject.put((JSONObject) "css", d.a());
            jSONObject.put((JSONObject) "js", d.c());
        }
        return jSONObject;
    }

    @NotNull
    public final JSONObject c(@NotNull byte[] bArr) {
        b41.i(bArr, "bytes");
        JSONObject jSONObject = new JSONObject();
        C9107a e = e(bArr);
        if (e != null) {
            jSONObject.put((JSONObject) "layer", e.d());
            jSONObject.put((JSONObject) "databinding", e.b());
            jSONObject.put((JSONObject) "css", e.a());
            jSONObject.put((JSONObject) "js", e.c());
        }
        return jSONObject;
    }

    /* compiled from: Taobao */
    /* renamed from: tb.eq0$a */
    /* loaded from: classes6.dex */
    public static final class C9107a {
        @NotNull
        private String a;
        @NotNull
        private String b;
        @NotNull
        private String c;
        @NotNull
        private String d;

        public C9107a() {
            this(null, null, null, null, 15, null);
        }

        public C9107a(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            b41.i(str, "layer");
            b41.i(str2, "databinding");
            b41.i(str3, "css");
            b41.i(str4, "js");
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        @NotNull
        public final String a() {
            return this.c;
        }

        @NotNull
        public final String b() {
            return this.b;
        }

        @NotNull
        public final String c() {
            return this.d;
        }

        @NotNull
        public final String d() {
            return this.a;
        }

        public final void e(@NotNull String str) {
            b41.i(str, "<set-?>");
            this.c = str;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C9107a) {
                C9107a c9107a = (C9107a) obj;
                return b41.d(this.a, c9107a.a) && b41.d(this.b, c9107a.b) && b41.d(this.c, c9107a.c) && b41.d(this.d, c9107a.d);
            }
            return false;
        }

        public final void f(@NotNull String str) {
            b41.i(str, "<set-?>");
            this.b = str;
        }

        public final void g(@NotNull String str) {
            b41.i(str, "<set-?>");
            this.d = str;
        }

        public final void h(@NotNull String str) {
            b41.i(str, "<set-?>");
            this.a = str;
        }

        public int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        @NotNull
        public String toString() {
            return "GXBinaryData(layer=" + this.a + ", databinding=" + this.b + ", css=" + this.c + ", js=" + this.d + ')';
        }

        public /* synthetic */ C9107a(String str, String str2, String str3, String str4, int i, k50 k50Var) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
        }
    }
}
