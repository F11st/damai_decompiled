package com.youku.a;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class e {
    private String[] a;
    private int b = 0;
    private int c = 0;
    private int d;
    private f e;

    public e(f fVar, int i) {
        this.e = fVar;
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
