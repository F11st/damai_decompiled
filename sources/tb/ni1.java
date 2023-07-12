package tb;

import com.taobao.weex.ui.view.gesture.WXGestureType;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ni1 implements Comparable<ni1> {
    @NotNull
    private final String a;
    private final boolean b;

    private ni1(@NotNull String str, boolean z) {
        if (str == null) {
            a(0);
        }
        this.a = str;
        this.b = z;
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2 || i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4) ? 2 : 3];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i == 1) {
            objArr[1] = "asString";
        } else if (i == 2) {
            objArr[1] = "getIdentifier";
        } else if (i == 3 || i == 4) {
            objArr[1] = "asStringStripSpecialMarkers";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                objArr[2] = WXGestureType.GestureInfo.POINTER_ID;
                break;
            case 6:
                objArr[2] = "isValidIdentifier";
                break;
            case 7:
                objArr[2] = "special";
                break;
            case 8:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static ni1 e(@NotNull String str) {
        if (str == null) {
            a(8);
        }
        if (str.startsWith(jn1.L)) {
            return i(str);
        }
        return f(str);
    }

    @NotNull
    public static ni1 f(@NotNull String str) {
        if (str == null) {
            a(5);
        }
        return new ni1(str, false);
    }

    public static boolean h(@NotNull String str) {
        if (str == null) {
            a(6);
        }
        if (str.isEmpty() || str.startsWith(jn1.L)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '.' || charAt == '/' || charAt == '\\') {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static ni1 i(@NotNull String str) {
        if (str == null) {
            a(7);
        }
        if (str.startsWith(jn1.L)) {
            return new ni1(str, true);
        }
        throw new IllegalArgumentException("special name must start with '<': " + str);
    }

    @NotNull
    public String b() {
        String str = this.a;
        if (str == null) {
            a(1);
        }
        return str;
    }

    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(ni1 ni1Var) {
        return this.a.compareTo(ni1Var.a);
    }

    @NotNull
    public String d() {
        if (!this.b) {
            String b = b();
            if (b == null) {
                a(2);
            }
            return b;
        }
        throw new IllegalStateException("not identifier: " + this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ni1) {
            ni1 ni1Var = (ni1) obj;
            return this.b == ni1Var.b && this.a.equals(ni1Var.a);
        }
        return false;
    }

    public boolean g() {
        return this.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + (this.b ? 1 : 0);
    }

    public String toString() {
        return this.a;
    }
}
