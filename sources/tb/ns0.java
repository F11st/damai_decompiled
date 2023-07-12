package tb;

import com.alipay.sdk.m.k.C4226b;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class ns0 {
    @NotNull
    private final String a;
    @NotNull
    private final String b;
    private final int c;
    @NotNull
    private final String d;
    @NotNull
    private final String e;
    @NotNull
    private final String f;
    @NotNull
    private final String g;
    @NotNull
    private String h;

    public ns0(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        b41.i(str, "id");
        b41.i(str2, C4226b.l);
        b41.i(str3, "layer");
        b41.i(str4, "css");
        b41.i(str5, "dataBind");
        b41.i(str6, "js");
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = "";
    }

    @NotNull
    public final String a() {
        return this.b;
    }

    @NotNull
    public final String b() {
        return this.e;
    }

    @NotNull
    public final String c() {
        return this.f;
    }

    @NotNull
    public final String d() {
        return this.a;
    }

    @NotNull
    public final String e() {
        return this.g;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (b41.d(ns0.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.alibaba.gaiax.template.GXTemplate");
            ns0 ns0Var = (ns0) obj;
            return b41.d(this.a, ns0Var.a) && b41.d(this.b, ns0Var.b) && this.c == ns0Var.c;
        }
        return false;
    }

    @NotNull
    public final String f() {
        return this.d;
    }

    @NotNull
    public final String g() {
        return this.h;
    }

    public final int h() {
        return this.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c;
    }

    public final void i(@NotNull String str) {
        b41.i(str, "<set-?>");
        this.h = str;
    }
}
