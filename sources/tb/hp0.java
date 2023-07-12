package tb;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class hp0 {
    public static final hp0 ROOT = new hp0("");
    @NotNull
    private final ip0 a;
    private transient hp0 b;

    public hp0(@NotNull String str) {
        if (str == null) {
            a(1);
        }
        this.a = new ip0(str, this);
    }

    private static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                i2 = 2;
                break;
            case 8:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "fqName";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 12:
                objArr[0] = "segment";
                break;
            case 13:
                objArr[0] = "shortName";
                break;
            default:
                objArr[0] = "names";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
                objArr[1] = "toUnsafe";
                break;
            case 6:
            case 7:
                objArr[1] = "parent";
                break;
            case 8:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 9:
                objArr[1] = "shortName";
                break;
            case 10:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 11:
                objArr[1] = "pathSegments";
                break;
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[2] = "<init>";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                break;
            case 8:
                objArr[2] = "child";
                break;
            case 12:
                objArr[2] = "startsWith";
                break;
            case 13:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "fromSegments";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                throw new IllegalStateException(format);
            case 8:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @NotNull
    public static hp0 k(@NotNull ni1 ni1Var) {
        if (ni1Var == null) {
            a(13);
        }
        return new hp0(ip0.m(ni1Var));
    }

    @NotNull
    public String b() {
        String b = this.a.b();
        if (b == null) {
            a(4);
        }
        return b;
    }

    @NotNull
    public hp0 c(@NotNull ni1 ni1Var) {
        if (ni1Var == null) {
            a(8);
        }
        return new hp0(this.a.c(ni1Var), this);
    }

    public boolean d() {
        return this.a.e();
    }

    @NotNull
    public hp0 e() {
        hp0 hp0Var = this.b;
        if (hp0Var != null) {
            if (hp0Var == null) {
                a(6);
            }
            return hp0Var;
        } else if (!d()) {
            hp0 hp0Var2 = new hp0(this.a.g());
            this.b = hp0Var2;
            return hp0Var2;
        } else {
            throw new IllegalStateException("root");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof hp0) && this.a.equals(((hp0) obj).a);
    }

    @NotNull
    public List<ni1> f() {
        List<ni1> h = this.a.h();
        if (h == null) {
            a(11);
        }
        return h;
    }

    @NotNull
    public ni1 g() {
        ni1 i = this.a.i();
        if (i == null) {
            a(9);
        }
        return i;
    }

    @NotNull
    public ni1 h() {
        ni1 j = this.a.j();
        if (j == null) {
            a(10);
        }
        return j;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean i(@NotNull ni1 ni1Var) {
        if (ni1Var == null) {
            a(12);
        }
        return this.a.k(ni1Var);
    }

    @NotNull
    public ip0 j() {
        ip0 ip0Var = this.a;
        if (ip0Var == null) {
            a(5);
        }
        return ip0Var;
    }

    public String toString() {
        return this.a.toString();
    }

    public hp0(@NotNull ip0 ip0Var) {
        if (ip0Var == null) {
            a(2);
        }
        this.a = ip0Var;
    }

    private hp0(@NotNull ip0 ip0Var, hp0 hp0Var) {
        if (ip0Var == null) {
            a(3);
        }
        this.a = ip0Var;
        this.b = hp0Var;
    }
}
