package kotlin.text;

/* compiled from: Taobao */
/* renamed from: kotlin.text.c */
/* loaded from: classes3.dex */
class C8591c extends C8590b {
    public static final boolean d(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (z) {
            char upperCase = Character.toUpperCase(c);
            char upperCase2 = Character.toUpperCase(c2);
            return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
        }
        return false;
    }
}
