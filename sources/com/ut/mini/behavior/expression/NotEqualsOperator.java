package com.ut.mini.behavior.expression;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class NotEqualsOperator extends EqualsOperator {
    @Override // com.ut.mini.behavior.expression.EqualsOperator, com.ut.mini.behavior.expression.BinaryOperator
    public boolean apply(Object obj, Object obj2) {
        return !super.apply(obj, obj2);
    }

    @Override // com.ut.mini.behavior.expression.EqualsOperator, com.ut.mini.behavior.expression.BinaryOperator
    public String getOperatorSymbol() {
        return "!eq";
    }
}
