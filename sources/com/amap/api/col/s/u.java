package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class u extends b<String, Integer> {
    private Context k;
    private String l;

    public u(Context context, String str) {
        super(context, str);
        this.k = context;
        this.l = str;
    }

    private static Integer j() throws AMapException {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ Object a(String str) throws AMapException {
        return j();
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bk.f(this.k));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.l);
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.d() + "/nearby/data/delete";
    }
}
