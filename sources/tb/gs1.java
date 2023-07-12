package tb;

import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.google.vr.sdk.proto.nano.Phone;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class gs1 {
    private static final String a = "gs1";
    private static final List<a> b = Arrays.asList(new a("Micromax", null, "4560MMX", null, 217, 217), new a("HTC", "endeavoru", "HTC One X", null, 312, 312), new a("samsung", null, "SM-G920P", null, 575, 575), new a("samsung", null, "SM-G930", null, 581, 580), new a("samsung", null, "SM-G9300", null, 581, 580), new a("samsung", null, "SM-G930A", null, 581, 580), new a("samsung", null, "SM-G930F", null, 581, 580), new a("samsung", null, "SM-G930P", null, 581, 580), new a("samsung", null, "SM-G930R4", null, 581, 580), new a("samsung", null, "SM-G930T", null, 581, 580), new a("samsung", null, "SM-G930V", null, 581, 580), new a("samsung", null, "SM-G930W8", null, 581, 580), new a("samsung", null, "SM-N915FY", null, 541, 541), new a("samsung", null, "SM-N915A", null, 541, 541), new a("samsung", null, "SM-N915T", null, 541, 541), new a("samsung", null, "SM-N915K", null, 541, 541), new a("samsung", null, "SM-N915T", null, 541, 541), new a("samsung", null, "SM-N915G", null, 541, 541), new a("samsung", null, "SM-N915D", null, 541, 541), new a("BLU", "BLU", "Studio 5.0 HD LTE", "qcom", 294, 294), new a("OnePlus", "A0001", "A0001", "bacon", 401, 401), new a("THL", "THL", "thl 5000", "mt6592", 441, 441));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        String a;
        String b;
        String c;
        String d;
        int e;
        int f;

        a(String str, String str2, String str3, String str4, int i, int i2) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = i;
            this.f = i2;
        }

        boolean a(String str, String str2, String str3, String str4) {
            String str5 = this.a;
            if (str5 == null || str5.equals(str)) {
                String str6 = this.b;
                if (str6 == null || str6.equals(str2)) {
                    String str7 = this.c;
                    if (str7 == null || str7.equals(str3)) {
                        String str8 = this.d;
                        return str8 == null || str8.equals(str4);
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    public static Phone.PhoneParams a() {
        Phone.PhoneParams phoneParams = new Phone.PhoneParams();
        if (b(b, Build.getMANUFACTURER(), android.os.Build.DEVICE, Build.getMODEL(), android.os.Build.HARDWARE, phoneParams)) {
            return phoneParams;
        }
        return null;
    }

    static boolean b(List<a> list, String str, String str2, String str3, String str4, Phone.PhoneParams phoneParams) {
        for (a aVar : list) {
            if (aVar.a(str, str2, str3, str4)) {
                Log.d(a, String.format("Found override: {MANUFACTURER=%s, DEVICE=%s, MODEL=%s, HARDWARE=%s} : x_ppi=%d, y_ppi=%d", aVar.a, aVar.b, aVar.c, aVar.d, Integer.valueOf(aVar.e), Integer.valueOf(aVar.f)));
                phoneParams.setXPpi(aVar.e);
                phoneParams.setYPpi(aVar.f);
                return true;
            }
        }
        return false;
    }
}
