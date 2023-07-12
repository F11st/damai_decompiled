package org.android.agoo.assist.filter;

import android.content.Context;
import android.content.Intent;
import org.android.agoo.assist.AssistCallback;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class Operator {
    private static final String TAG = "Operator";
    public static Operator empty = new Operator() { // from class: org.android.agoo.assist.filter.Operator.1
        @Override // org.android.agoo.assist.filter.Operator
        public void onPayload(String str) {
        }

        @Override // org.android.agoo.assist.filter.Operator
        public void onRegister(AssistCallback assistCallback) {
        }

        @Override // org.android.agoo.assist.filter.Operator
        public void onToken(String str) {
        }

        @Override // org.android.agoo.assist.filter.Operator
        public String parseMsgFromIntent(Intent intent) {
            return null;
        }
    };
    protected Context context;

    public void init(Context context) {
        this.context = context.getApplicationContext();
    }

    @Deprecated
    public abstract void onPayload(String str);

    public abstract void onRegister(AssistCallback assistCallback);

    @Deprecated
    public abstract void onToken(String str);

    public abstract String parseMsgFromIntent(Intent intent);
}
