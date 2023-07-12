package com.ut.mini.behavior.expression;

import java.math.BigDecimal;
import java.math.BigInteger;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class NumberEqualsOperator extends BinaryOperator {
    @Override // com.ut.mini.behavior.expression.BinaryOperator
    public boolean apply(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        if (ExpressionUtils.isBigDecimal(obj2)) {
            return ((BigDecimal) ExpressionUtils.coerceToPrimitiveNumber(obj, BigDecimal.class)).equals((BigDecimal) ExpressionUtils.coerceToPrimitiveNumber(obj2, BigDecimal.class));
        }
        if (ExpressionUtils.isFloatingPointType(obj2)) {
            return ExpressionUtils.coerceToPrimitiveNumber(obj, Double.class).doubleValue() == ExpressionUtils.coerceToPrimitiveNumber(obj2, Double.class).doubleValue();
        } else if (ExpressionUtils.isBigInteger(obj2)) {
            return ((BigInteger) ExpressionUtils.coerceToPrimitiveNumber(obj, BigInteger.class)).equals((BigInteger) ExpressionUtils.coerceToPrimitiveNumber(obj2, BigInteger.class));
        } else {
            return ExpressionUtils.isIntegerType(obj2) && ExpressionUtils.coerceToPrimitiveNumber(obj, Long.class).longValue() == ExpressionUtils.coerceToPrimitiveNumber(obj2, Long.class).longValue();
        }
    }

    @Override // com.ut.mini.behavior.expression.BinaryOperator
    public String getOperatorSymbol() {
        return jn1.EQUAL2;
    }
}
