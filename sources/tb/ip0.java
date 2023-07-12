package tb;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ip0 {
    private static final ni1 e = ni1.i("<root>");
    private static final Pattern f = Pattern.compile("\\.");
    private static final Function1<String, ni1> g = new a();
    @NotNull
    private final String a;
    private transient hp0 b;
    private transient ip0 c;
    private transient ni1 d;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class a implements Function1<String, ni1> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public ni1 invoke(String str) {
            return ni1.e(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ip0(@NotNull String str, @NotNull hp0 hp0Var) {
        if (str == null) {
            a(0);
        }
        if (hp0Var == null) {
            a(1);
        }
        this.a = str;
        this.b = hp0Var;
    }

    private static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 15:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                i2 = 2;
                break;
            case 9:
            case 15:
            case 16:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        if (i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = "name";
                    break;
                case 15:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 9:
            case 15:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case 15:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                throw new IllegalStateException(format);
            case 9:
            case 15:
            case 16:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    private void d() {
        int lastIndexOf = this.a.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            this.d = ni1.e(this.a.substring(lastIndexOf + 1));
            this.c = new ip0(this.a.substring(0, lastIndexOf));
            return;
        }
        this.d = ni1.e(this.a);
        this.c = hp0.ROOT.j();
    }

    @NotNull
    public static ip0 m(@NotNull ni1 ni1Var) {
        if (ni1Var == null) {
            a(16);
        }
        return new ip0(ni1Var.b(), hp0.ROOT.j(), ni1Var);
    }

    @NotNull
    public String b() {
        String str = this.a;
        if (str == null) {
            a(4);
        }
        return str;
    }

    @NotNull
    public ip0 c(@NotNull ni1 ni1Var) {
        String str;
        if (ni1Var == null) {
            a(9);
        }
        if (e()) {
            str = ni1Var.b();
        } else {
            str = this.a + "." + ni1Var.b();
        }
        return new ip0(str, this, ni1Var);
    }

    public boolean e() {
        return this.a.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ip0) && this.a.equals(((ip0) obj).a);
    }

    public boolean f() {
        return this.b != null || b().indexOf(60) < 0;
    }

    @NotNull
    public ip0 g() {
        ip0 ip0Var = this.c;
        if (ip0Var != null) {
            if (ip0Var == null) {
                a(7);
            }
            return ip0Var;
        } else if (!e()) {
            d();
            ip0 ip0Var2 = this.c;
            if (ip0Var2 == null) {
                a(8);
            }
            return ip0Var2;
        } else {
            throw new IllegalStateException("root");
        }
    }

    @NotNull
    public List<ni1> h() {
        List<ni1> emptyList = e() ? Collections.emptyList() : kotlin.collections.e.J(f.split(this.a), g);
        if (emptyList == null) {
            a(14);
        }
        return emptyList;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @NotNull
    public ni1 i() {
        ni1 ni1Var = this.d;
        if (ni1Var != null) {
            if (ni1Var == null) {
                a(10);
            }
            return ni1Var;
        } else if (!e()) {
            d();
            ni1 ni1Var2 = this.d;
            if (ni1Var2 == null) {
                a(11);
            }
            return ni1Var2;
        } else {
            throw new IllegalStateException("root");
        }
    }

    @NotNull
    public ni1 j() {
        if (e()) {
            ni1 ni1Var = e;
            if (ni1Var == null) {
                a(12);
            }
            return ni1Var;
        }
        ni1 i = i();
        if (i == null) {
            a(13);
        }
        return i;
    }

    public boolean k(@NotNull ni1 ni1Var) {
        if (ni1Var == null) {
            a(15);
        }
        if (e()) {
            return false;
        }
        int indexOf = this.a.indexOf(46);
        String str = this.a;
        String b = ni1Var.b();
        if (indexOf == -1) {
            indexOf = this.a.length();
        }
        return str.regionMatches(0, b, 0, indexOf);
    }

    @NotNull
    public hp0 l() {
        hp0 hp0Var = this.b;
        if (hp0Var != null) {
            if (hp0Var == null) {
                a(5);
            }
            return hp0Var;
        }
        hp0 hp0Var2 = new hp0(this);
        this.b = hp0Var2;
        return hp0Var2;
    }

    @NotNull
    public String toString() {
        String b = e() ? e.b() : this.a;
        if (b == null) {
            a(17);
        }
        return b;
    }

    public ip0(@NotNull String str) {
        if (str == null) {
            a(2);
        }
        this.a = str;
    }

    private ip0(@NotNull String str, ip0 ip0Var, ni1 ni1Var) {
        if (str == null) {
            a(3);
        }
        this.a = str;
        this.c = ip0Var;
        this.d = ni1Var;
    }
}
