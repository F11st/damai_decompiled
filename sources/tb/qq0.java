package tb;

import com.alibaba.fastjson.JSONObject;
import java.util.Objects;
import kotlin.text.C8600k;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class qq0 {
    @NotNull
    public static final C9614a Companion = new C9614a(null);
    @NotNull
    private static final qq0 g = new qq0();
    @NotNull
    private StringBuilder a = new StringBuilder();
    @NotNull
    private String b = "";
    @NotNull
    private StringBuilder c = new StringBuilder();
    @NotNull
    private StringBuilder d = new StringBuilder();
    @NotNull
    private final JSONObject e = new JSONObject();
    private int f;

    /* compiled from: Taobao */
    /* renamed from: tb.qq0$a */
    /* loaded from: classes6.dex */
    public static final class C9614a {
        private C9614a() {
        }

        public /* synthetic */ C9614a(k50 k50Var) {
            this();
        }

        @NotNull
        public final qq0 a() {
            return qq0.g;
        }
    }

    private final void b(JSONObject jSONObject, char c) {
        int i = this.f;
        if (i == 0) {
            d(c);
        } else if (i == 1) {
            c(jSONObject, c);
        } else if (i != 2) {
        } else {
            f(c);
        }
    }

    private final void c(JSONObject jSONObject, char c) {
        if (c == ':') {
            this.f = 2;
        } else if (c == '}') {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putAll(this.e);
            jSONObject.put((JSONObject) this.b, (String) jSONObject2);
            this.e.clear();
            this.f = 0;
        } else {
            this.c.append(c);
        }
    }

    private final void d(char c) {
        CharSequence M0;
        if ('{' == c) {
            this.f = 1;
            String sb = this.a.toString();
            b41.h(sb, "selectorName.toString()");
            M0 = StringsKt__StringsKt.M0(sb);
            String obj = M0.toString();
            Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
            String substring = obj.substring(1);
            b41.h(substring, "(this as java.lang.String).substring(startIndex)");
            this.b = substring;
            C8600k.f(this.a);
            return;
        }
        this.a.append(c);
    }

    private final void f(char c) {
        CharSequence M0;
        CharSequence M02;
        if (';' == c) {
            JSONObject jSONObject = this.e;
            String sb = this.c.toString();
            b41.h(sb, "propertyName.toString()");
            M0 = StringsKt__StringsKt.M0(sb);
            String obj = M0.toString();
            String sb2 = this.d.toString();
            b41.h(sb2, "valueName.toString()");
            M02 = StringsKt__StringsKt.M0(sb2);
            jSONObject.put((JSONObject) obj, M02.toString());
            C8600k.f(this.c);
            C8600k.f(this.d);
            this.f = 1;
            return;
        }
        this.d.append(c);
    }

    @NotNull
    public final JSONObject e(@NotNull String str) {
        b41.i(str, "css");
        JSONObject jSONObject = new JSONObject();
        int length = str.length() - 1;
        if (length >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                b(jSONObject, str.charAt(i));
                if (i2 > length) {
                    break;
                }
                i = i2;
            }
        }
        return jSONObject;
    }
}
