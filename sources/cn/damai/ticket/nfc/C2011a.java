package cn.damai.ticket.nfc;

import android.content.Intent;
import android.nfc.Tag;
import android.nfc.tech.NfcV;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.IOException;
import tb.pk1;
import tb.qd0;
import tb.vk2;

/* compiled from: Taobao */
/* renamed from: cn.damai.ticket.nfc.a */
/* loaded from: classes16.dex */
public class C2011a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "a";

    public static String a(String str, String str2, NfcV nfcV) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-688598164")) {
            return (String) ipChange.ipc$dispatch("-688598164", new Object[]{str, str2, nfcV});
        }
        if (nfcV == null) {
            Log.e(TAG, "authenticate - nfcV is null.");
            return null;
        }
        String str3 = TAG;
        Log.d(str3, "random challenge data: " + str2);
        String str4 = qd0.CMD_AUTH_PREFIX + str + "000000" + str2;
        byte[] d = vk2.d(str4);
        Log.d(str3, "authentication request => " + str4);
        String a = vk2.a(nfcV.transceive(d));
        Log.d(str3, "authentication response <= " + a);
        if (!a.startsWith(qd0.RESP_AUTH_RESULT_PREFIX)) {
            Log.e(str3, "auth response command is wrong: " + a);
            return null;
        }
        String f = vk2.f(a.substring(4));
        Log.d(str3, "cipher tex: " + f);
        Log.d(str3, "authentication result:  failed");
        return f;
    }

    public static String b(String str, NfcV nfcV) throws IOException {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1555658047")) {
            return (String) ipChange.ipc$dispatch("1555658047", new Object[]{str, nfcV});
        }
        if (nfcV == null) {
            Log.e(TAG, "getSid - nfcV is null.");
            return null;
        }
        try {
            str2 = vk2.a(nfcV.transceive(vk2.d(qd0.CMD_READ_PREFIX + str + "0F")));
        } catch (Exception e) {
            e.printStackTrace();
            str2 = null;
        }
        String str3 = TAG;
        Log.d(str3, "read block0F response: " + str2);
        if (str2 != null && str2.startsWith("00")) {
            if (str2.length() >= 12) {
                String f = vk2.f(str2.substring(2, 12));
                Log.d(str3, "sid: " + f);
                return f;
            }
            Log.d(str3, "sid length < 12 ");
            return null;
        }
        Log.e(str3, "read dara error..");
        return null;
    }

    public static String c(String str, NfcV nfcV) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-619022050")) {
            return (String) ipChange.ipc$dispatch("-619022050", new Object[]{str, nfcV});
        }
        if (nfcV == null) {
            Log.e(TAG, "getTid - nfcV is null.");
            return null;
        }
        String str2 = qd0.CMD_READ_PREFIX + str + "38";
        String a = vk2.a(nfcV.transceive(vk2.d(str2)));
        String a2 = vk2.a(nfcV.transceive(vk2.d(qd0.CMD_READ_PREFIX + str + "39")));
        if (a.startsWith("00") && a2.startsWith("00")) {
            String f = vk2.f(a2.substring(10) + a.substring(2));
            String str3 = TAG;
            Log.d(str3, "read block 38 response <= " + a);
            Log.d(str3, "read block 39 response <= " + a2);
            Log.d(str3, "get tid <= " + f);
            return f;
        }
        Log.e(TAG, "read data error..");
        return null;
    }

    public static String d(NfcV nfcV) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "311908915")) {
            return (String) ipChange.ipc$dispatch("311908915", new Object[]{nfcV});
        }
        if (nfcV == null) {
            Log.e(TAG, "getUid - nfcV is null.");
            return null;
        }
        byte[] a = qd0.a();
        String str = TAG;
        Log.d(str, "get uid request => 260100");
        nfcV.connect();
        String a2 = vk2.a(nfcV.transceive(a));
        if (a2.startsWith("0000")) {
            String substring = a2.substring(4);
            Log.i(str, "get uid response <= " + substring);
            return substring;
        }
        Log.e(str, "get UID failed.");
        return null;
    }

    @NonNull
    public static C2012b e(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "741774914")) {
            return (C2012b) ipChange.ipc$dispatch("741774914", new Object[]{intent});
        }
        C2012b c2012b = new C2012b();
        NfcV nfcV = null;
        Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
        if (tag == null) {
            c2012b.a = false;
            c2012b.b = "tag is null";
            c2012b.c = 1;
            return c2012b;
        }
        String[] techList = tag.getTechList();
        if (techList == null) {
            c2012b.a = false;
            c2012b.c = 2;
            c2012b.b = "not support this tech";
            return c2012b;
        }
        boolean z = false;
        for (String str : techList) {
            Log.i(TAG, "tag tech: " + str);
            if (str.contains("NfcV")) {
                z = true;
            }
        }
        try {
            if (z) {
                try {
                    NfcV nfcV2 = NfcV.get(tag);
                    String d = d(nfcV2);
                    if (TextUtils.isEmpty(d)) {
                        c2012b.a = false;
                        c2012b.c = 3;
                        c2012b.b = "read uId/sId/tId error";
                        if (nfcV2 != null) {
                            try {
                                nfcV2.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        return c2012b;
                    }
                    String b = b(d, nfcV2);
                    String c = c(d, nfcV2);
                    if (!TextUtils.isEmpty(d) && !TextUtils.isEmpty(b) && !TextUtils.isEmpty(c)) {
                        String e2 = vk2.e(20);
                        String a = a(d, e2, nfcV2);
                        pk1 pk1Var = new pk1();
                        pk1Var.j(d);
                        pk1Var.h(b);
                        pk1Var.i(c);
                        pk1Var.f(e2);
                        pk1Var.g(a);
                        c2012b.a = true;
                        c2012b.d = pk1Var;
                    } else {
                        c2012b.a = false;
                        c2012b.c = 3;
                        c2012b.b = "read uId/sId/tId error";
                    }
                    if (nfcV2 != null) {
                        try {
                            nfcV2.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    return c2012b;
                } catch (Exception unused) {
                    c2012b.a = false;
                    c2012b.b = "read nfc tag error";
                    c2012b.c = 4;
                    if (0 != 0) {
                        try {
                            nfcV.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    return c2012b;
                }
            }
            c2012b.a = false;
            c2012b.b = "not support nfc v";
            c2012b.c = 5;
            return c2012b;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    nfcV.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }
}
