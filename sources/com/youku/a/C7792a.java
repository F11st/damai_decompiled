package com.youku.a;

import android.content.Context;
import com.youku.alixplayer.IAlixPlayer;

/* compiled from: Taobao */
/* renamed from: com.youku.a.a */
/* loaded from: classes.dex */
public class C7792a {
    private static volatile C7792a a;
    private Context b;
    private C7794c c;

    private C7792a(Context context) {
        this.b = context;
        C7794c c7794c = new C7794c(context);
        this.c = c7794c;
        c7794c.a();
    }

    public static C7792a a(Context context) {
        if (a == null) {
            synchronized (C7792a.class) {
                if (a == null) {
                    a = new C7792a(context);
                }
            }
        }
        return a;
    }

    public IAlixPlayer a(String str) {
        C7794c c7794c = this.c;
        if (c7794c == null) {
            return null;
        }
        return c7794c.a(str);
    }

    public String a() {
        C7794c c7794c = this.c;
        return c7794c == null ? "" : c7794c.b();
    }

    public void a(IAlixPlayer iAlixPlayer) {
        C7794c c7794c = this.c;
        if (c7794c == null) {
            return;
        }
        c7794c.a(iAlixPlayer);
    }

    public void b(String str) {
        C7794c c7794c = this.c;
        if (c7794c == null) {
            return;
        }
        c7794c.b(str);
    }

    public IAlixPlayer c(String str) {
        C7794c c7794c = this.c;
        if (c7794c == null) {
            return null;
        }
        return c7794c.c(str);
    }
}
