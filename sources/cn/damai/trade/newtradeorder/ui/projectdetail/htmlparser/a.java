package cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Hashtable;
import java.util.Locale;
import java.util.regex.Pattern;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int COLOR_NONE = 1;
    public static final String DAMAI_HEIGHT = "damai_height";
    public static final String DAMAI_WIDTH = "damai_width";
    private static final Hashtable<String, Integer> a;

    static {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        a = hashtable;
        hashtable.put("aqua", -16711681);
        hashtable.put("black", -16777216);
        hashtable.put("blue", -16776961);
        hashtable.put("darkgrey", -5658199);
        hashtable.put("fuchsia", -65281);
        hashtable.put("gray", -8355712);
        hashtable.put("grey", -8355712);
        hashtable.put("green", -16744448);
        hashtable.put("lightblue", -5383962);
        hashtable.put("lightgrey", -2894893);
        hashtable.put("lime", -16711936);
        hashtable.put("maroon", -8388608);
        hashtable.put("navy", -16777088);
        hashtable.put("olive", -8355840);
        hashtable.put("orange", -23296);
        hashtable.put("purple", -8388480);
        hashtable.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        hashtable.put("silver", -4144960);
        hashtable.put("teal", -16744320);
        hashtable.put("white", -1);
        hashtable.put("yellow", Integer.valueOf((int) InputDeviceCompat.SOURCE_ANY));
        hashtable.put("sienna", -6270419);
        hashtable.put("darkolivegreen", -11179217);
        hashtable.put("darkgreen", -16751616);
        hashtable.put("darkslateblue", -12042869);
        hashtable.put("indigo", -11861886);
        hashtable.put("darkslategray", -13676721);
        hashtable.put("darkred", -7667712);
        hashtable.put("darkorange", -29696);
        hashtable.put("slategray", -9404272);
        hashtable.put("dimgray", -9868951);
        hashtable.put("sandybrown", -744352);
        hashtable.put("yellowgreen", -5374161);
        hashtable.put("seagreen", -13726889);
        hashtable.put("mediumturquoise", -12004916);
        hashtable.put("royalblue", -12490271);
        hashtable.put("magenta", -65281);
        hashtable.put("cyan", -16711681);
        hashtable.put("deepskyblue", -16728065);
        hashtable.put("darkorchid", -6737204);
        hashtable.put("pink", -16181);
        hashtable.put("wheat", -663885);
        hashtable.put("lemonchiffon", -1331);
        hashtable.put("palegreen", -6751336);
        hashtable.put("paleturquoise", -5247250);
        hashtable.put("plum", -2252579);
    }

    private static int a(boolean z, String str, int i) {
        int j;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1641565370")) {
            return ((Integer) ipChange.ipc$dispatch("-1641565370", new Object[]{Boolean.valueOf(z), str, Integer.valueOf(i)})).intValue();
        }
        if (z) {
            j = j(str, i, "text-align", 15);
        } else {
            j = j(str, i, "align", 10);
        }
        if (j > 0) {
            while (j < str.length() && (str.charAt(j) < 'a' || str.charAt(j) > 'z')) {
                j++;
            }
            if (str.startsWith("right", j)) {
                return 2;
            }
            if (str.startsWith("center", j)) {
                return 1;
            }
            return str.startsWith("left", j) ? 0 : -1;
        }
        return -1;
    }

    private static String b(String str, int i, String str2) {
        int j;
        int indexOf;
        int indexOf2;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-326021970")) {
            return (String) ipChange.ipc$dispatch("-326021970", new Object[]{str, Integer.valueOf(i), str2});
        }
        if ((str.length() - i) - 4 >= str2.length() && (j = j(str, i, str2, str2.length() + 4)) >= 0 && (indexOf = str.indexOf("=", j)) >= 0 && (indexOf2 = str.indexOf("\"", indexOf)) >= 0 && (i2 = indexOf2 + 1) <= str.length() - 2) {
            while (i2 < str.length() - 2 && (str.charAt(i2) == ' ' || str.charAt(i2) == '\n')) {
                i2++;
            }
            int i3 = i2 + 1;
            while (i3 < str.length() - 1 && str.charAt(i3) != '\"' && str.charAt(i3) != ' ' && str.charAt(i3) != '\n') {
                i3++;
            }
            if (i3 <= str.length() - 1) {
                return str.substring(i2, i3);
            }
            return null;
        }
        return null;
    }

    private static int c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1509741417")) {
            return ((Integer) ipChange.ipc$dispatch("-1509741417", new Object[]{str})).intValue();
        }
        try {
            return Integer.parseInt(Pattern.compile("[^0-9]").matcher(str).replaceAll(""));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private static int d(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1331673051")) {
            return ((Integer) ipChange.ipc$dispatch("-1331673051", new Object[]{str, Integer.valueOf(i)})).intValue();
        }
        String b = b(str, i, "size");
        if (b != null && TextUtils.isDigitsOnly(b)) {
            return Integer.parseInt(b);
        }
        return -1;
    }

    private static int e(int i, int i2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1233204616")) {
            return ((Integer) ipChange.ipc$dispatch("-1233204616", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str})).intValue();
        }
        int i3 = i2 - i;
        if (i3 < 3) {
            return 1;
        }
        if (str.charAt(i) != '#') {
            Integer num = a.get(str.substring(i, i2).toLowerCase(Locale.US));
            if (num != null) {
                return num.intValue();
            }
            return 1;
        }
        if (i3 == 9) {
            i += 2;
        }
        if (i2 - i == 7) {
            return Integer.parseInt(str.substring(i + 1, i2), 16) | (-16777216);
        }
        return 1;
    }

    private static int f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "736671686")) {
            return ((Integer) ipChange.ipc$dispatch("736671686", new Object[]{str})).intValue();
        }
        return -1;
    }

    private static int g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2055697393")) {
            return ((Integer) ipChange.ipc$dispatch("2055697393", new Object[]{str})).intValue();
        }
        return -1;
    }

    public static int h(String str, String str2) {
        String substring;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1642521030")) {
            return ((Integer) ipChange.ipc$dispatch("1642521030", new Object[]{str, str2})).intValue();
        }
        if (str != null && str.contains(str2) && str.contains(";") && (substring = str.substring(str.indexOf(str2))) != null && substring.contains(";")) {
            return c(substring.substring(0, str.indexOf(";")));
        }
        return -1;
    }

    private static int i(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1494068241")) {
            return ((Integer) ipChange.ipc$dispatch("-1494068241", new Object[]{str, Integer.valueOf(i)})).intValue();
        }
        int j = j(str, i, "color", 10);
        if (j < 0) {
            return 1;
        }
        if (j > i + 5) {
            int i2 = j - 6;
            if (str.charAt(i2) == '-' || str.charAt(i2) == 'g') {
                return 1;
            }
        }
        while (j < str.length() - 3) {
            if (str.charAt(j) == '=') {
                while (j < str.length() - 3 && str.charAt(j) != '\"') {
                    j++;
                }
                if (str.charAt(j) == '\"') {
                    int i3 = j + 1;
                    int i4 = i3;
                    while (i4 < str.length() && str.charAt(i4) != '\"' && str.charAt(i4) != ' ' && str.charAt(i4) != '\n') {
                        i4++;
                    }
                    return e(i3, i4, str);
                }
                return -1;
            } else if (str.charAt(j) == ':') {
                int i5 = j + 1;
                while (i5 < str.length() - 3 && (str.charAt(i5) == ' ' || str.charAt(i5) == '\n')) {
                    i5++;
                }
                int i6 = i5 + 1;
                while (i6 < str.length() && str.charAt(i6) != ';' && str.charAt(i6) != ' ' && str.charAt(i6) != '\n' && str.charAt(i6) != '\"') {
                    i6++;
                }
                return e(i5, i6, str);
            } else if (str.charAt(j) == '\"') {
                return 1;
            } else {
                j++;
            }
        }
        return 1;
    }

    private static int j(String str, int i, String str2, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1810556857")) {
            return ((Integer) ipChange.ipc$dispatch("-1810556857", new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)})).intValue();
        }
        int length = str.length() - i;
        if (length < i2) {
            return -1;
        }
        int i3 = 0;
        while (i3 <= length - i2) {
            int i4 = 0;
            while (str.charAt(i3) == str2.charAt(i4)) {
                i4++;
                i3++;
                if (i4 == str2.length()) {
                    return i3;
                }
            }
            i3++;
        }
        return -1;
    }

    private static String k(String str, int i, String str2) {
        int indexOf;
        int indexOf2;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1111345089")) {
            return (String) ipChange.ipc$dispatch("-1111345089", new Object[]{str, Integer.valueOf(i), str2});
        }
        if (str.length() - i >= str2.length() && (indexOf = str.indexOf("=", i)) >= 0 && (indexOf2 = str.indexOf("\"", indexOf)) >= 0 && (i2 = indexOf2 + 1) <= str.length() - 2) {
            while (i2 < str.length() - 2 && (str.charAt(i2) == ' ' || str.charAt(i2) == '\n')) {
                i2++;
            }
            int i3 = i2 + 1;
            while (i3 < str.length() - 1 && str.charAt(i3) != '\"' && str.charAt(i3) != ' ' && str.charAt(i3) != '\n') {
                i3++;
            }
            if (i3 <= str.length() - 1) {
                return str.substring(i2, i3);
            }
            return null;
        }
        return null;
    }

    public static boolean l(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-879745646")) {
            return ((Boolean) ipChange.ipc$dispatch("-879745646", new Object[]{str})).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && str.contains(".")) {
            String substring = str.substring(str.lastIndexOf("."));
            if (!TextUtils.isEmpty(substring)) {
                String lowerCase = substring.toLowerCase();
                return lowerCase.contains("jpg") || lowerCase.contains("png");
            }
        }
        return false;
    }

    public static c.a m(int i, char[] cArr, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1135597283")) {
            return (c.a) ipChange.ipc$dispatch("-1135597283", new Object[]{Integer.valueOf(i), cArr, Integer.valueOf(i2)});
        }
        c.a aVar = new c.a();
        String str = new String(cArr, 0, i2);
        if (i == 1) {
            aVar.c = i(str, 0);
            aVar.d = d(str, 0);
        } else if (i == 14) {
            String b = b(str, 0, "href");
            aVar.b = b;
            if (b != null && b.contains("&")) {
                aVar.b = aVar.b.replace("&amp;", "&");
            }
        } else if (i != 15) {
            switch (i) {
                case 53:
                case 55:
                    aVar.g = a(false, str, 0);
                    break;
                case 54:
                    aVar.c = i(str, 0);
                    aVar.e = a(true, str, 0);
                    break;
                default:
                    switch (i) {
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                            aVar.c = i(str, 0);
                            aVar.e = a(true, str, 0);
                            break;
                    }
            }
        } else {
            String b2 = b(str, 0, "src");
            aVar.a = b2;
            if (b2 != null && b2.contains("&")) {
                aVar.a = aVar.a.replace("&amp;", "&");
            }
            aVar.g = a(false, str, 0);
            aVar.h = g(str);
            aVar.i = f(str);
            String str2 = aVar.a;
            if (str2 != null) {
                boolean l = l(str2);
                if (l) {
                    try {
                        if (str.contains("style")) {
                            String substring = str.substring(str.indexOf("style"));
                            aVar.j = h(substring, "damai_width:");
                            int h = h(substring, "damai_height:");
                            aVar.k = h;
                            if (aVar.j > 0 || h > 0) {
                                l = false;
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                if (l) {
                    try {
                        if (str.contains("damai_width") && str.contains("damai_height")) {
                            aVar.j = c(k(str.substring(str.indexOf("damai_width")), 0, "damai_width"));
                            aVar.k = c(k(str.substring(str.indexOf("damai_height")), 0, "damai_height"));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Log.d("AttrParser", aVar.j + jn1.MUL + aVar.k);
            }
        }
        return aVar;
    }
}
