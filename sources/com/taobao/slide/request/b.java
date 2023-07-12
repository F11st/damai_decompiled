package com.taobao.slide.request;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.slide.core.SlideException;
import java.util.Map;
import tb.oc1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class b<T> {
    public static boolean d;
    protected Context a;
    protected String b;
    protected String c;

    public b(Context context, String str, String str2) {
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    protected abstract String a() throws Throwable;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Map<String, String> b();

    /* JADX INFO: Access modifiers changed from: protected */
    public String c() {
        return null;
    }

    protected abstract T d(String str);

    public T e() throws SlideException {
        try {
            String a = a();
            if (!TextUtils.isEmpty(a)) {
                if (!TextUtils.isEmpty(this.c) && !this.c.equals(oc1.d(a))) {
                    throw new SlideException(1012, "md5 is not matched");
                }
                return d(a);
            }
            throw new SlideException(1011, "result is empty");
        } catch (Throwable th) {
            throw new SlideException(1010, th);
        }
    }
}
