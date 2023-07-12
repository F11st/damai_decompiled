package com.ut.mini.behavior.expression;

import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class NumberRelationalOperator extends BinaryOperator {
    public abstract boolean apply(double d, double d2);

    public abstract boolean apply(long j, long j2);

    @Override // com.ut.mini.behavior.expression.BinaryOperator
    public boolean apply(Object obj, Object obj2) throws ExpressionException {
        return ExpressionUtils.applyNumberRelationalOperator(obj, obj2, this);
    }

    public abstract boolean apply(String str, String str2);

    public abstract boolean apply(BigDecimal bigDecimal, BigDecimal bigDecimal2);

    public abstract boolean apply(BigInteger bigInteger, BigInteger bigInteger2);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isEqual(int i) {
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isGreater(int i) {
        return i > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLess(int i) {
        return i < 0;
    }
}
