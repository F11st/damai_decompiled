package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.tencent.connect.auth.b */
/* loaded from: classes11.dex */
public class C7046b {
    public static C7046b a = null;
    static final /* synthetic */ boolean d = true;
    private static int e;
    public HashMap<String, C7047a> b = new HashMap<>();
    public final String c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* compiled from: Taobao */
    /* renamed from: com.tencent.connect.auth.b$a */
    /* loaded from: classes11.dex */
    public static class C7047a {
        public IUiListener a;
        public DialogC7041a b;
        public String c;
    }

    public static C7046b a() {
        if (a == null) {
            a = new C7046b();
        }
        return a;
    }

    public static int b() {
        int i = e + 1;
        e = i;
        return i;
    }

    public String c() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ceil; i++) {
            stringBuffer.append(charArray[(int) (Math.random() * length)]);
        }
        return stringBuffer.toString();
    }

    public String a(C7047a c7047a) {
        int b = b();
        try {
            HashMap<String, C7047a> hashMap = this.b;
            hashMap.put("" + b, c7047a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + b;
    }
}
