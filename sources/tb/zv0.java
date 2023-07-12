package tb;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class zv0 extends d50 {
    private static Pattern a = Pattern.compile("\\d+");

    @Override // com.taobao.slide.compare.ICompare
    public boolean equals(String str, String str2) {
        Matcher matcher = a.matcher(str2);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            arrayList.add(Integer.valueOf(Integer.parseInt(matcher.group())));
        }
        if (arrayList.size() == 3) {
            long g = nl.g(str) % ((Integer) arrayList.get(0)).intValue();
            return g >= ((long) ((Integer) arrayList.get(1)).intValue()) && g <= ((long) ((Integer) arrayList.get(2)).intValue());
        }
        throw new IllegalArgumentException("did_hash exp format is illegal");
    }
}
