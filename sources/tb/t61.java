package tb;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class t61 {
    private final String a;

    private t61(@NotNull String str) {
        if (str == null) {
            a(5);
        }
        this.a = str;
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 3 || i == 6 || i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 6 || i == 7 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "classId";
                break;
            case 2:
            case 4:
                objArr[0] = "fqName";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            case 5:
            default:
                objArr[0] = "internalName";
                break;
        }
        if (i == 3) {
            objArr[1] = "byFqNameWithoutInnerClasses";
        } else if (i == 6) {
            objArr[1] = "getFqNameForClassNameWithoutDollars";
        } else if (i == 7) {
            objArr[1] = "getPackageFqName";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        } else {
            objArr[1] = "getInternalName";
        }
        switch (i) {
            case 1:
                objArr[2] = "byClassId";
                break;
            case 2:
            case 4:
                objArr[2] = "byFqNameWithoutInnerClasses";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                break;
            case 5:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "byInternalName";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 3 && i != 6 && i != 7 && i != 8) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static t61 b(@NotNull hj hjVar) {
        if (hjVar == null) {
            a(1);
        }
        hp0 h = hjVar.h();
        String replace = hjVar.i().b().replace('.', '$');
        if (h.d()) {
            return new t61(replace);
        }
        return new t61(h.b().replace('.', r10.DIR) + "/" + replace);
    }

    @NotNull
    public static t61 c(@NotNull hp0 hp0Var) {
        if (hp0Var == null) {
            a(2);
        }
        return new t61(hp0Var.b().replace('.', r10.DIR));
    }

    @NotNull
    public static t61 d(@NotNull String str) {
        if (str == null) {
            a(0);
        }
        return new t61(str);
    }

    @NotNull
    public hp0 e() {
        return new hp0(this.a.replace(r10.DIR, '.'));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t61.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((t61) obj).a);
    }

    @NotNull
    public String f() {
        String str = this.a;
        if (str == null) {
            a(8);
        }
        return str;
    }

    @NotNull
    public hp0 g() {
        int lastIndexOf = this.a.lastIndexOf("/");
        if (lastIndexOf == -1) {
            hp0 hp0Var = hp0.ROOT;
            if (hp0Var == null) {
                a(7);
            }
            return hp0Var;
        }
        return new hp0(this.a.substring(0, lastIndexOf).replace(r10.DIR, '.'));
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }
}
