package com.youku.a;

/* compiled from: Taobao */
/* renamed from: com.youku.a.e */
/* loaded from: classes.dex */
public class C7796e {
    private String[] a;
    private int b = 0;
    private int c = 0;
    private int d;
    private InterfaceC7797f e;

    public C7796e(InterfaceC7797f interfaceC7797f, int i) {
        this.e = interfaceC7797f;
        this.d = i;
        this.a = new String[i];
    }

    public void a(String str) {
        int i;
        for (int i2 = 0; i2 < this.c; i2++) {
            if (this.a[i2].equals(str)) {
                int i3 = i2;
                while (true) {
                    i = this.c;
                    if (i3 >= i - 1) {
                        break;
                    }
                    String[] strArr = this.a;
                    int i4 = i3 + 1;
                    strArr[i3] = strArr[i4];
                    i3 = i4;
                }
                this.c = i - 1;
                this.b--;
            }
        }
    }
}
