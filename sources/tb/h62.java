package tb;

import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.phenix.loader.LocalSchemeHandler;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class h62 {
    public static final int LOCAL_URI = 32;
    public static final int NETWORK_URI = 1;
    public final int a;
    public String b;
    public String c;
    public String d = "";
    public int e;
    public int f;
    public boolean g;
    public String h;
    public int i;
    public String j;
    public int k;
    public int l;
    public boolean m;

    public h62(int i) {
        this.a = i;
    }

    private static boolean b(String str, int i) {
        char charAt;
        int i2 = i + 1;
        return i2 >= str.length() || (charAt = str.charAt(i2)) == '.' || charAt == '_';
    }

    public static h62 d(@NonNull String str) {
        h62 j = j(str);
        return (j == null && (j = e(str)) == null && (j = l(str)) == null && (j = f(str)) == null && (j = i(str)) == null) ? h(str) : j;
    }

    private static h62 e(@NonNull String str) {
        if (str.startsWith("asset://")) {
            h62 h62Var = new h62(34);
            h62Var.b = str;
            h62Var.h = str.substring(8);
            h62Var.d = g(str);
            return h62Var;
        }
        return null;
    }

    private static h62 f(@NonNull String str) {
        int indexOf;
        if (!str.startsWith("data:image/") || (indexOf = str.indexOf(";base64,", 11)) <= 0 || indexOf >= 17) {
            return null;
        }
        h62 h62Var = new h62(40);
        int i = indexOf + 8;
        h62Var.j = str.substring(i);
        h62Var.b = str.substring(0, i) + "hash=" + Integer.toHexString(h62Var.j.hashCode());
        StringBuilder sb = new StringBuilder();
        sb.append('.');
        sb.append(str.substring(11, indexOf));
        h62Var.d = sb.toString();
        return h62Var;
    }

    private static String g(@NonNull String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf > 0 ? str.substring(lastIndexOf) : "";
    }

    private static h62 h(@NonNull String str) {
        int indexOf;
        h62 h62Var = new h62(1);
        h62Var.b = str;
        int length = str.length();
        int indexOf2 = str.indexOf(63);
        if (indexOf2 < 0) {
            indexOf2 = length;
        }
        int lastIndexOf = str.lastIndexOf(47, indexOf2 - 1);
        if (lastIndexOf >= 0 && lastIndexOf < length - 1) {
            String substring = str.substring(lastIndexOf + 1, indexOf2);
            h62Var.d = g(substring);
            if (!m(substring, h62Var) && !k(str, lastIndexOf, substring, h62Var) && (indexOf = str.indexOf("//gw.alicdn.com")) >= 0 && indexOf <= 6) {
                if (substring.endsWith("_.webp")) {
                    h62Var.b = substring.substring(0, substring.length() - 6);
                } else {
                    h62Var.b = substring;
                }
                h62Var.f = 10000;
                h62Var.e = 10000;
                h62Var.g = true;
            }
            if (!TextUtils.isEmpty(h62Var.b)) {
                int lastIndexOf2 = h62Var.b.lastIndexOf(47);
                if (lastIndexOf2 > 0) {
                    h62Var.c = h62Var.b.substring(lastIndexOf2 + 1);
                } else {
                    h62Var.c = h62Var.b;
                }
            }
        }
        return h62Var;
    }

    private static h62 i(@NonNull String str) {
        List<LocalSchemeHandler> i = ur1.o().i();
        if (i != null) {
            int i2 = 0;
            for (LocalSchemeHandler localSchemeHandler : i) {
                if (localSchemeHandler.isSupported(str)) {
                    h62 h62Var = new h62(48);
                    h62Var.k = i2;
                    h62Var.b = str;
                    return h62Var;
                }
                i2++;
            }
            return null;
        }
        return null;
    }

    private static h62 j(@NonNull String str) {
        boolean startsWith = str.startsWith("file:///");
        if (!startsWith && (str.length() <= 1 || str.charAt(0) != '/' || str.charAt(1) == '/')) {
            if (str.startsWith("content://")) {
                h62 h62Var = new h62(33);
                h62Var.h = str;
                h62Var.b = str;
                return h62Var;
            }
            return null;
        }
        h62 h62Var2 = new h62(33);
        h62Var2.d = g(str);
        if (startsWith) {
            h62Var2.h = str.substring(7);
        } else {
            h62Var2.h = str;
        }
        h62Var2.b = h62Var2.h;
        return h62Var2;
    }

    private static boolean k(String str, int i, String str2, h62 h62Var) {
        int lastIndexOf = str2.lastIndexOf(64);
        int i2 = 0;
        if (lastIndexOf >= 0 && str2.indexOf(45, lastIndexOf) <= 0 && str2.indexOf(124, lastIndexOf) <= 0 && str2.indexOf("_2e", lastIndexOf) <= 0) {
            int n = n(str2, lastIndexOf, 'w');
            h62Var.e = n;
            if (n != 0) {
                int n2 = n(str2, lastIndexOf, 'h');
                h62Var.f = n2;
                if (n2 != 0 && h62Var.e == n2) {
                    h62Var.g = true;
                    int indexOf = str.indexOf(WVUtils.URL_SEPARATOR);
                    if (indexOf > 0 && str.charAt(indexOf - 1) == ':') {
                        i2 = indexOf;
                    }
                    h62Var.b = str.substring(i2, i + lastIndexOf + 1);
                    return true;
                }
            }
        }
        return false;
    }

    private static h62 l(@NonNull String str) {
        if (str.startsWith("res://")) {
            try {
                int parseInt = Integer.parseInt(str.substring(6));
                h62 h62Var = new h62(36);
                h62Var.i = parseInt;
                h62Var.b = str;
                return h62Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    private static boolean m(String str, h62 h62Var) {
        int indexOf = str.indexOf(95);
        if (indexOf < 0) {
            return false;
        }
        int indexOf2 = str.indexOf(120, indexOf);
        int length = str.length();
        while (indexOf2 > indexOf) {
            h62Var.e = o(str, indexOf2, false, indexOf);
            int o = o(str, indexOf2, true, length);
            h62Var.f = o;
            int i = h62Var.e;
            if (i > 0 && i == o) {
                int length2 = String.valueOf(o).length();
                int i2 = indexOf2 + length2;
                int i3 = i2 + 2;
                if (i3 >= str.length() || str.charAt(i2 + 1) != 'x' || str.charAt(i3) != 'z') {
                    h62Var.g = true;
                    int i4 = (indexOf2 - length2) - 1;
                    if (i4 > 0) {
                        h62Var.b = str.substring(0, i4);
                    }
                }
                return true;
            } else if ((i > 0 && o == 10000) || (o > 0 && i == 10000)) {
                return true;
            } else {
                h62Var.f = 0;
                h62Var.e = 0;
                indexOf = indexOf2 + 1;
                indexOf2 = str.indexOf(120, indexOf);
            }
        }
        return false;
    }

    private static int n(String str, int i, char c) {
        int o;
        int indexOf = str.indexOf(c, i);
        while (indexOf > i) {
            if (b(str, indexOf) && (o = o(str, indexOf, false, i)) != 0) {
                return o;
            }
            i = indexOf + 1;
            indexOf = str.indexOf(c, i);
        }
        return 0;
    }

    private static int o(String str, int i, boolean z, int i2) {
        int charAt;
        int i3 = 0;
        if (i < 0) {
            return 0;
        }
        if (!z) {
            int i4 = i - 1;
            int i5 = 0;
            while (i4 > i2) {
                int charAt2 = str.charAt(i4) - '0';
                if (charAt2 < 0 || charAt2 > 9) {
                    break;
                }
                i5 += charAt2 * ((int) Math.pow(10.0d, i3));
                i4--;
                i3++;
            }
            return i5;
        }
        while (true) {
            i++;
            if (i >= i2 || str.charAt(i) - '0' < 0 || charAt > 9) {
                return i3;
            }
            i3 = (i3 * 10) + charAt;
        }
    }

    public static String p(String str) {
        return "asset://" + str;
    }

    public static String q(String str) {
        return "file://" + str;
    }

    public static String r(int i) {
        return "res://" + i;
    }

    public boolean a() {
        return (this.a & 32) > 0;
    }

    public boolean c() {
        return (this.a & 32) == 0;
    }

    public String toString() {
        return "type=" + this.a + ", baseName=" + this.b + ", extension=" + this.d + ", width=" + this.e + ", height=" + this.f + ", cdnSize=" + this.g + ", path=" + this.h + ", resId=" + this.i + ", base64=" + this.j;
    }
}
