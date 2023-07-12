package com.youku.a;

import android.content.Context;
import com.youku.alixplayer.IAlixPlayer;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a {
    private static volatile a a;
    private Context b;
    private c c;

    private a(Context context) {
        this.b = context;
        c cVar = new c(context);
        this.c = cVar;
        cVar.a();
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    public IAlixPlayer a(String str) {
        c cVar = this.c;
        if (cVar == null) {
            return null;
        }
        return cVar.a(str);
    }

    public String a() {
        c cVar = this.c;
        return cVar == null ? "" : cVar.b();
    }

    public void a(IAlixPlayer iAlixPlayer) {
        c cVar = this.c;
        if (cVar == null) {
            return;
        }
        cVar.a(iAlixPlayer);
    }

    public void b(String str) {
        c cVar = this.c;
        if (cVar == null) {
            return;
        }
        cVar.b(str);
    }

    public IAlixPlayer c(String str) {
        c cVar = this.c;
        if (cVar == null) {
            return null;
        }
        return cVar.c(str);
    }
}
