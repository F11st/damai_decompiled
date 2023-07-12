package com.alibaba.security.biometrics.sensor.b;

import android.text.TextUtils;
import com.alibaba.security.biometrics.sensor.C3790a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.biometrics.sensor.b.a */
/* loaded from: classes8.dex */
public final class C3796a {
    private static final String c = "11111111111";
    private static final int d = 500;
    private static final int e = 100;
    private static final int f = 2000;
    private static final int g = 10000;
    private static final int h = 200;
    private static final int i = 300;
    private static final int j = 0;
    private static final int k = 2000;
    private static final int l = 0;
    private static final int[] m = {1, 4, 9, 2, 10, 5, 6, 13, 8, 3, 11};
    public int a;
    public int b;
    private String n;
    private int o;

    public C3796a(HashMap<String, String> hashMap) {
        try {
            this.n = hashMap.get(C3790a.b);
            this.o = Integer.parseInt(hashMap.get(C3790a.c));
            this.a = Integer.parseInt(hashMap.get(C3790a.d));
            this.b = Integer.parseInt(hashMap.get(C3790a.e));
        } catch (Exception unused) {
        }
    }

    private int b() {
        int i2 = this.o;
        if (i2 > 10000 || i2 <= 200) {
            this.o = 500;
        }
        return this.o;
    }

    private int c() {
        int i2 = this.a;
        if (i2 > 300 || i2 <= 0) {
            this.a = 100;
        }
        return this.a;
    }

    private int d() {
        int i2 = this.b;
        if (i2 > 2000 || i2 <= 0) {
            this.b = 2000;
        }
        return this.b;
    }

    public final List<Integer> a() {
        if (a(this.n)) {
            this.n = c;
        }
        ArrayList arrayList = new ArrayList();
        char[] charArray = this.n.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (charArray[i2] == '1') {
                arrayList.add(Integer.valueOf(m[i2]));
            }
        }
        return arrayList;
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        char[] charArray = str.toCharArray();
        if (charArray.length != 11) {
            return true;
        }
        for (char c2 : charArray) {
            if (c2 != '1' && c2 != '0') {
                return true;
            }
        }
        return false;
    }
}
