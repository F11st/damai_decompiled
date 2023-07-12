package com.ut.mini.behavior.expression;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class EkOperator extends BinaryOperator {
    @Override // com.ut.mini.behavior.expression.BinaryOperator
    public boolean apply(Object obj, Object obj2) {
        return obj != null;
    }

    @Override // com.ut.mini.behavior.expression.BinaryOperator
    public String getOperatorSymbol() {
        return "ek";
    }
}
