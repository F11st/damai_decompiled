package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class hj {
    private final hp0 a;
    private final hp0 b;
    private final boolean c;

    public hj(@NotNull hp0 hp0Var, @NotNull hp0 hp0Var2, boolean z) {
        if (hp0Var == null) {
            a(1);
        }
        if (hp0Var2 == null) {
            a(2);
        }
        this.a = hp0Var;
        this.b = hp0Var2;
        this.c = z;
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? 2 : 3];
        switch (i) {
            case 1:
            case 3:
                objArr[0] = "packageFqName";
                break;
            case 2:
                objArr[0] = "relativeClassName";
                break;
            case 4:
                objArr[0] = "topLevelName";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 10:
                objArr[0] = "segment";
                break;
            case 11:
            case 12:
                objArr[0] = "string";
                break;
            default:
                objArr[0] = "topLevelFqName";
                break;
        }
        if (i == 5) {
            objArr[1] = "getPackageFqName";
        } else if (i == 6) {
            objArr[1] = "getRelativeClassName";
        } else if (i == 7) {
            objArr[1] = "getShortClassName";
        } else if (i == 9) {
            objArr[1] = "asSingleFqName";
        } else if (i == 13 || i == 14) {
            objArr[1] = "asString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                break;
            case 8:
                objArr[2] = "createNestedClassId";
                break;
            case 10:
                objArr[2] = "startsWith";
                break;
            case 11:
            case 12:
                objArr[2] = "fromString";
                break;
            default:
                objArr[2] = "topLevel";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 5 && i != 6 && i != 7 && i != 9 && i != 13 && i != 14) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static hj e(@NotNull String str) {
        if (str == null) {
            a(11);
        }
        return f(str, false);
    }

    @NotNull
    public static hj f(@NotNull String str, boolean z) {
        String str2;
        if (str == null) {
            a(12);
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf == -1) {
            str2 = "";
        } else {
            String replace = str.substring(0, lastIndexOf).replace(r10.DIR, '.');
            str = str.substring(lastIndexOf + 1);
            str2 = replace;
        }
        return new hj(new hp0(str2), new hp0(str), z);
    }

    @NotNull
    public static hj m(@NotNull hp0 hp0Var) {
        if (hp0Var == null) {
            a(0);
        }
        return new hj(hp0Var.e(), hp0Var.g());
    }

    @NotNull
    public hp0 b() {
        if (this.a.d()) {
            hp0 hp0Var = this.b;
            if (hp0Var == null) {
                a(9);
            }
            return hp0Var;
        }
        return new hp0(this.a.b() + "." + this.b.b());
    }

    @NotNull
    public String c() {
        if (this.a.d()) {
            String b = this.b.b();
            if (b == null) {
                a(13);
            }
            return b;
        }
        String str = this.a.b().replace('.', r10.DIR) + "/" + this.b.b();
        if (str == null) {
            a(14);
        }
        return str;
    }

    @NotNull
    public hj d(@NotNull ni1 ni1Var) {
        if (ni1Var == null) {
            a(8);
        }
        return new hj(h(), this.b.c(ni1Var), this.c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || hj.class != obj.getClass()) {
            return false;
        }
        hj hjVar = (hj) obj;
        return this.a.equals(hjVar.a) && this.b.equals(hjVar.b) && this.c == hjVar.c;
    }

    @Nullable
    public hj g() {
        hp0 e = this.b.e();
        if (e.d()) {
            return null;
        }
        return new hj(h(), e, this.c);
    }

    @NotNull
    public hp0 h() {
        hp0 hp0Var = this.a;
        if (hp0Var == null) {
            a(5);
        }
        return hp0Var;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Boolean.valueOf(this.c).hashCode();
    }

    @NotNull
    public hp0 i() {
        hp0 hp0Var = this.b;
        if (hp0Var == null) {
            a(6);
        }
        return hp0Var;
    }

    @NotNull
    public ni1 j() {
        ni1 g = this.b.g();
        if (g == null) {
            a(7);
        }
        return g;
    }

    public boolean k() {
        return this.c;
    }

    public boolean l() {
        return !this.b.e().d();
    }

    public String toString() {
        if (this.a.d()) {
            return "/" + c();
        }
        return c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public hj(@NotNull hp0 hp0Var, @NotNull ni1 ni1Var) {
        this(hp0Var, hp0.k(ni1Var), false);
        if (hp0Var == null) {
            a(3);
        }
        if (ni1Var == null) {
            a(4);
        }
    }
}
