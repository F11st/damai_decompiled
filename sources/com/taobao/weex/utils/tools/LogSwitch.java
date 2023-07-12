package com.taobao.weex.utils.tools;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LogSwitch {
    private int a = 4;
    private int b = 2;
    private int c = 1;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private boolean g = true;

    public int getLog_switch() {
        return this.d;
    }

    public void setLog_switch() {
        if (this.e) {
            this.d |= this.a;
        }
        if (this.f) {
            this.d |= this.b;
        }
        if (this.g) {
            this.d |= this.c;
        }
    }
}
