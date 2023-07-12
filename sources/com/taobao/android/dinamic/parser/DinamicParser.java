package com.taobao.android.dinamic.parser;

import com.taobao.android.dinamic.C6312a;
import com.taobao.android.dinamic.C6313b;
import com.taobao.android.dinamic.log.DinamicLog;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import org.xmlpull.v1.XmlPullParser;
import tb.iy2;
import tb.j22;
import tb.k42;
import tb.mi0;
import tb.p8;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DinamicParser {
    private static j22 a = new j22();
    private static mi0 b = new mi0();
    private static k42 c = new k42();
    private static p8 d = new p8();

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamic.parser.DinamicParser$1  reason: invalid class name */
    /* loaded from: classes12.dex */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ long val$consumingTime;
        final /* synthetic */ boolean val$isSuccess;
        final /* synthetic */ String val$module;
        final /* synthetic */ DinamicTemplate val$template;

        AnonymousClass1(String str, DinamicTemplate dinamicTemplate, long j, boolean z) {
            this.val$module = str;
            this.val$template = dinamicTemplate;
            this.val$consumingTime = j;
            this.val$isSuccess = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C6313b.e()) {
                DinamicLog.a(C6313b.TAG, "module=" + this.val$module + "read File=" + this.val$template + (((float) this.val$consumingTime) / 1000000.0d));
            }
            C6312a.h().d();
            throw null;
        }
    }

    public static XmlPullParser a(String str, DinamicTemplate dinamicTemplate, iy2 iy2Var) {
        XmlPullParser openXmlResourceParser = (C6313b.e() && c.c(dinamicTemplate)) ? c.openXmlResourceParser(str, dinamicTemplate, iy2Var) : null;
        long nanoTime = System.nanoTime();
        if (!dinamicTemplate.isPreset()) {
            XmlPullParser openXmlResourceParser2 = b.openXmlResourceParser(str, dinamicTemplate, iy2Var);
            b(str, dinamicTemplate, openXmlResourceParser2 != null, System.nanoTime() - nanoTime);
            return openXmlResourceParser2;
        }
        if (openXmlResourceParser == null) {
            openXmlResourceParser = a.openXmlResourceParser(str, dinamicTemplate, iy2Var);
        }
        if (openXmlResourceParser == null) {
            openXmlResourceParser = d.openXmlResourceParser(str, dinamicTemplate, iy2Var);
        }
        b(str, dinamicTemplate, openXmlResourceParser != null, System.nanoTime() - nanoTime);
        return openXmlResourceParser;
    }

    private static void b(String str, DinamicTemplate dinamicTemplate, boolean z, long j) {
        C6312a.h().d();
    }
}
