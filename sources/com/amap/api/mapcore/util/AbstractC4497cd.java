package com.amap.api.mapcore.util;

import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
/* renamed from: com.amap.api.mapcore.util.cd */
/* loaded from: classes10.dex */
public abstract class AbstractC4497cd implements ch {
    protected int a;
    protected az b;

    public AbstractC4497cd(int i, az azVar) {
        this.a = i;
        this.b = azVar;
    }

    public boolean a(AbstractC4497cd abstractC4497cd) {
        return abstractC4497cd.b() == b();
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

    public void b(AbstractC4497cd abstractC4497cd) {
        bx.a(b() + " ==> " + abstractC4497cd.b() + "   " + getClass() + "==>" + abstractC4497cd.getClass());
    }

    public void a(int i) {
        bx.a("Wrong call fail()  State: " + b() + AltriaXLaunchTime.SPACE + getClass());
    }
}
