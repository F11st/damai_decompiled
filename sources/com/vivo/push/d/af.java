package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.vivo.push.AbstractC7496o;
import com.vivo.push.C7481e;
import com.vivo.push.b.C7433u;
import com.vivo.push.b.C7436x;
import com.vivo.push.util.C7512e;
import com.vivo.push.util.C7523p;
import com.vivo.push.util.C7533z;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class af extends AbstractC7480z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public af(AbstractC7496o abstractC7496o) {
        super(abstractC7496o);
    }

    @Override // com.vivo.push.AbstractRunnableC7491l
    protected final void a(AbstractC7496o abstractC7496o) {
        C7433u c7433u = (C7433u) abstractC7496o;
        if (C7481e.a().g() && !a(C7533z.c(this.a), c7433u.e(), c7433u.i())) {
            C7523p.d("OnUndoMsgTask", " vertify msg is error ");
            C7436x c7436x = new C7436x(1021L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(c7433u.f()));
            Context context = this.a;
            String b = C7533z.b(context, context.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            c7436x.a(hashMap);
            C7481e.a().a(c7436x);
            return;
        }
        boolean repealNotifyById = NotifyAdapterUtil.repealNotifyById(this.a, c7433u.d());
        C7523p.d("OnUndoMsgTask", "undo message " + c7433u.d() + AVFSCacheConstants.COMMA_SEP + repealNotifyById);
        if (repealNotifyById) {
            Context context2 = this.a;
            C7523p.b(context2, "回收client通知成功, 上报埋点 1031, messageId = " + c7433u.d());
            C7512e.a(this.a, c7433u.d(), 1031L);
            return;
        }
        C7523p.d("OnUndoMsgTask", "undo message fail，messageId = " + c7433u.d());
        Context context3 = this.a;
        C7523p.c(context3, "回收client通知失败，messageId = " + c7433u.d());
    }
}
