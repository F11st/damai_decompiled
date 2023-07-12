package tb;

import com.alipay.ma.util.StringEncodeUtils;
import java.util.Hashtable;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class gi extends pd0 {
    private static Hashtable b;
    private static Hashtable c;

    private gi(int i, String str) {
        super(i);
    }

    private static void b(int i, String str) {
        gi giVar = new gi(i, str);
        b.put(new Integer(i), giVar);
        c.put(str, giVar);
    }

    private static void c(int i, String[] strArr) {
        gi giVar = new gi(i, strArr[0]);
        b.put(new Integer(i), giVar);
        for (String str : strArr) {
            c.put(str, giVar);
        }
    }

    public static gi d(String str) {
        if (c == null) {
            e();
        }
        return (gi) c.get(str);
    }

    private static void e() {
        b = new Hashtable(29);
        c = new Hashtable(29);
        b(0, "Cp437");
        c(1, new String[]{StringEncodeUtils.ISO88591, "ISO-8859-1"});
        b(2, "Cp437");
        c(3, new String[]{StringEncodeUtils.ISO88591, "ISO-8859-1"});
        b(4, "ISO8859_2");
        b(5, "ISO8859_3");
        b(6, "ISO8859_4");
        b(7, "ISO8859_5");
        b(8, "ISO8859_6");
        b(9, "ISO8859_7");
        b(10, "ISO8859_8");
        b(11, "ISO8859_9");
        b(12, "ISO8859_10");
        b(13, "ISO8859_11");
        b(15, "ISO8859_13");
        b(16, "ISO8859_14");
        b(17, "ISO8859_15");
        b(18, "ISO8859_16");
        c(20, new String[]{"SJIS", "Shift_JIS"});
    }
}
