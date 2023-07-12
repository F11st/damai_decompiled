package com.alibaba.appmonitor.pool;

import com.alibaba.fastjson.JSONArray;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ReuseJSONArray extends JSONArray implements Reusable {
    private static final long serialVersionUID = -4243576223670082606L;

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void clean() {
        Iterator<Object> it = iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof Reusable) {
                C3316a.a().offer((Reusable) next);
            }
        }
        super.clear();
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void fill(Object... objArr) {
    }
}
