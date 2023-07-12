package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.u */
/* loaded from: classes10.dex */
public final class C4460u extends AbstractC4379b<String, Integer> {
    private Context k;
    private String l;

    public C4460u(Context context, String str) {
        super(context, str);
        this.k = context;
        this.l = str;
    }

    private static Integer j() throws AMapException {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    public final /* synthetic */ Object a(String str) throws AMapException {
        return j();
    }

    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
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
        return C4434h.d() + "/nearby/data/delete";
    }
}
