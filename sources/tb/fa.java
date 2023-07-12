package tb;

import java.util.Hashtable;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class fa {
    private final String a;
    private static final Hashtable b = new Hashtable();
    public static final fa QR_CODE = new fa("QR_CODE");
    public static final fa DATA_MATRIX = new fa("DATA_MATRIX");
    public static final fa UPC_E = new fa("UPC_E");
    public static final fa UPC_A = new fa("UPC_A");
    public static final fa EAN_8 = new fa("EAN_8");
    public static final fa EAN_13 = new fa("EAN_13");
    public static final fa UPC_EAN_EXTENSION = new fa("UPC_EAN_EXTENSION");
    public static final fa CODE_128 = new fa("CODE_128");
    public static final fa CODE_39 = new fa("CODE_39");
    public static final fa CODE_93 = new fa("CODE_93");
    public static final fa CODABAR = new fa("CODABAR");
    public static final fa ITF = new fa("ITF");
    public static final fa RSS14 = new fa("RSS14");
    public static final fa PDF417 = new fa("PDF417");
    public static final fa RSS_EXPANDED = new fa("RSS_EXPANDED");

    private fa(String str) {
        this.a = str;
        b.put(str, this);
    }

    public static fa valueOf(String str) {
        if (str != null && str.length() != 0) {
            fa faVar = (fa) b.get(str);
            if (faVar != null) {
                return faVar;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        return this.a;
    }
}
