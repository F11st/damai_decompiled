package tb;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a20 {
    private int a;

    public int a() {
        return this.a;
    }

    public boolean b(String str, int i, C9787ut c9787ut) {
        boolean z;
        if (c9787ut.j(i)) {
            z = true;
        } else {
            z = false;
            Log.e("UiCodeLoader_TMTEST", "seekBy error:" + i);
        }
        this.a = c9787ut.c();
        return z;
    }
}
