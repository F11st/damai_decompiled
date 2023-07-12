package com.taobao.accs.utl;

import tb.g4;
import tb.wo;
import tb.x6;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AppMonitorAdapter {
    public static void commitAlarmFail(String str, String str2, String str3, String str4, String str5) {
        g4 g4Var = new g4();
        g4Var.e = str;
        g4Var.f = str2;
        g4Var.b = str3;
        g4Var.c = str4;
        g4Var.d = str5;
        g4Var.a = false;
        x6.b().commitAlarm(g4Var);
    }

    public static void commitAlarmSuccess(String str, String str2, String str3) {
        g4 g4Var = new g4();
        g4Var.e = str;
        g4Var.f = str2;
        g4Var.b = str3;
        g4Var.a = true;
        x6.b().commitAlarm(g4Var);
    }

    public static void commitCount(String str, String str2, String str3, double d) {
        wo woVar = new wo();
        woVar.c = str;
        woVar.d = str2;
        woVar.a = str3;
        woVar.b = d;
        x6.b().commitCount(woVar);
    }
}
