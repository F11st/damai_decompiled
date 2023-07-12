package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.AbstractC7496o;
import com.vivo.push.C7410a;
import com.vivo.push.util.C7523p;
import java.util.HashMap;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b.x */
/* loaded from: classes11.dex */
public final class C7436x extends AbstractC7496o {
    private HashMap<String, String> a;
    private long b;

    public C7436x() {
        super(2012);
    }

    public final void a(HashMap<String, String> hashMap) {
        this.a = hashMap;
    }

    @Override // com.vivo.push.AbstractC7496o
    public final void c(C7410a c7410a) {
        c7410a.a("ReporterCommand.EXTRA_PARAMS", this.a);
        c7410a.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
    }

    @Override // com.vivo.push.AbstractC7496o
    public final void d(C7410a c7410a) {
        this.a = (HashMap) c7410a.d("ReporterCommand.EXTRA_PARAMS");
        this.b = c7410a.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
    }

    @Override // com.vivo.push.AbstractC7496o
    public final String toString() {
        return "ReporterCommand（" + this.b + jn1.BRACKET_END_STR;
    }

    public C7436x(long j) {
        this();
        this.b = j;
    }

    public final void d() {
        if (this.a == null) {
            C7523p.d("ReporterCommand", "reportParams is empty");
            return;
        }
        StringBuilder sb = new StringBuilder("report message reportType:");
        sb.append(this.b);
        sb.append(",msgId:");
        String str = this.a.get("messageID");
        if (TextUtils.isEmpty(str)) {
            str = this.a.get("message_id");
        }
        sb.append(str);
        C7523p.d("ReporterCommand", sb.toString());
    }
}
