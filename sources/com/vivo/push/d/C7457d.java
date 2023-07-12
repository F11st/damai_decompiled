package com.vivo.push.d;

import android.text.TextUtils;
import com.vivo.push.AbstractC7496o;
import com.vivo.push.C7481e;
import com.vivo.push.C7492m;
import com.vivo.push.b.C7421i;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.d */
/* loaded from: classes11.dex */
public final class C7457d extends AbstractC7480z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C7457d(AbstractC7496o abstractC7496o) {
        super(abstractC7496o);
    }

    @Override // com.vivo.push.AbstractRunnableC7491l
    protected final void a(AbstractC7496o abstractC7496o) {
        C7421i c7421i = (C7421i) abstractC7496o;
        String e = c7421i.e();
        C7481e.a().a(c7421i.g(), c7421i.h(), e);
        if (TextUtils.isEmpty(c7421i.g()) && !TextUtils.isEmpty(e)) {
            C7481e.a().a(e);
        }
        C7492m.b(new RunnableC7458e(this, e, c7421i));
    }
}
