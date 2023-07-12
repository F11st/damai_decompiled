package tb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fh2 extends d50 {
    @Override // com.taobao.slide.compare.ICompare
    public boolean equals(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    @Override // tb.d50, com.taobao.slide.compare.ICompare
    public boolean equalsNot(String str, String str2) {
        if (str == null) {
            return str2 != null;
        }
        return !str.equals(str2);
    }

    @Override // tb.d50, com.taobao.slide.compare.ICompare
    public boolean fuzzy(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return str.startsWith(str2);
    }

    @Override // tb.d50, com.taobao.slide.compare.ICompare
    public boolean fuzzyNot(String str, String str2) {
        if (str == null || str2 == null) {
            return true;
        }
        return !str.startsWith(str2);
    }
}
