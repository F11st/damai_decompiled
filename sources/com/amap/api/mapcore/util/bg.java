package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class bg {
    private Context a;

    public bg(Context context) {
        this.a = context;
    }

    private boolean b(az azVar) {
        if (azVar != null) {
            String pinyin = azVar.getPinyin();
            boolean a = a(pinyin, this.a, "vmap/");
            if (pinyin.equals("quanguogaiyaotu")) {
                pinyin = "quanguo";
            }
            boolean z = true;
            boolean z2 = a(pinyin, this.a, "map/") || a;
            if (!b(bx.c(azVar.getUrl()), this.a, "map/") && !z2) {
                z = false;
            }
            if (z) {
                azVar.i();
                return z;
            }
            azVar.h();
        }
        return false;
    }

    public void a(az azVar) {
        b(azVar);
    }

    private boolean a(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String b = eq.b(context);
        try {
            File file = new File(b + str2 + str + ".dat");
            if (file.exists() && !bx.b(file)) {
                bx.a("deleteDownload delete some thing wrong!");
                return false;
            }
            try {
                bx.b(b + str2);
                bx.b(str, context);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private boolean b(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String a = eq.a(context);
        try {
            File file = new File(a + str2 + str);
            if (file.exists() && !bx.b(file)) {
                bx.a("deleteDownload delete some thing wrong!");
                return false;
            }
            try {
                bx.b(a + str2);
                bx.b(str, context);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }
}
