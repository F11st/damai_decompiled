package org.android.agoo.assist.common;

import android.content.Context;
import org.android.agoo.assist.filter.Operator;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PhoneType {
    private final String msgSource;
    private final Operator operator;
    private final String tokenType;

    public PhoneType(String str, String str2, Operator operator) {
        this.msgSource = str;
        this.tokenType = str2;
        this.operator = operator;
    }

    public String getMsgSource() {
        return this.msgSource;
    }

    public Operator getOperator() {
        return this.operator;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public void init(Context context) {
        this.operator.init(context);
    }
}
