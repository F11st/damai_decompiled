package com.amap.api.mapcore.util;

import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class cd implements ch {
    protected int a;
    protected az b;

    public cd(int i, az azVar) {
        this.a = i;
        this.b = azVar;
    }

    public boolean a(cd cdVar) {
        return cdVar.b() == b();
    }

    public int b() {
        return this.a;
    }

    public void c() {
        bx.a("Wrong call start()  State: " + b() + AltriaXLaunchTime.SPACE + getClass());
    }

    public void d() {
        bx.a("Wrong call continueDownload()  State: " + b() + AltriaXLaunchTime.SPACE + getClass());
    }

    public void e() {
        bx.a("Wrong call pause()  State: " + b() + AltriaXLaunchTime.SPACE + getClass());
    }

    public void f() {
        bx.a("Wrong call hasNew()  State: " + b() + AltriaXLaunchTime.SPACE + getClass());
    }

    public void g() {
        bx.a("Wrong call complete()  State: " + b() + AltriaXLaunchTime.SPACE + getClass());
    }

    public void a() {
        bx.a("Wrong call delete()  State: " + b() + AltriaXLaunchTime.SPACE + getClass());
    }

    public void b(cd cdVar) {
        bx.a(b() + " ==> " + cdVar.b() + "   " + getClass() + "==>" + cdVar.getClass());
    }

    public void a(int i) {
        bx.a("Wrong call fail()  State: " + b() + AltriaXLaunchTime.SPACE + getClass());
    }
}
