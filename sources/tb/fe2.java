package tb;

import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fe2 {
    private static final jh2 a = new jh2();
    private static String b = null;

    public static void a(ge2 ge2Var) {
        String antiTransfer = a.antiTransfer(ge2Var);
        if (TextUtils.equals(antiTransfer, b)) {
            return;
        }
        b = antiTransfer;
        b(antiTransfer);
    }

    private static void b(String str) {
        File c = oi0.c();
        if (c == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                c.delete();
                return;
            }
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(c));
                    try {
                        bufferedWriter2.write(str, 0, str.length());
                        yj.a(bufferedWriter2);
                    } catch (Exception e) {
                        e = e;
                        bufferedWriter = bufferedWriter2;
                        ob1.e(e);
                        yj.a(bufferedWriter);
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        yj.a(bufferedWriter);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th3) {
            ob1.e(th3);
        }
    }
}
