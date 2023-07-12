package com.ut.mini.behavior.expression;

import com.alibaba.analytics.utils.Logger;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ExpressionUtils {
    private static final String TAG = "ExpressionUtils";
    private static final Number ZERO = new Integer(0);

    private ExpressionUtils() {
    }

    public static boolean applyNumberRelationalOperator(Object obj, Object obj2, NumberRelationalOperator numberRelationalOperator) throws ExpressionException {
        if (isBigDecimal(obj2)) {
            return numberRelationalOperator.apply((BigDecimal) coerceToPrimitiveNumber(obj, BigDecimal.class), (BigDecimal) coerceToPrimitiveNumber(obj2, BigDecimal.class));
        }
        if (isFloatingPointType(obj2)) {
            return numberRelationalOperator.apply(coerceToPrimitiveNumber(obj, Double.class).doubleValue(), coerceToPrimitiveNumber(obj2, Double.class).doubleValue());
        }
        if (isBigInteger(obj2)) {
            return numberRelationalOperator.apply((BigInteger) coerceToPrimitiveNumber(obj, BigInteger.class), (BigInteger) coerceToPrimitiveNumber(obj2, BigInteger.class));
        }
        if (isIntegerType(obj2)) {
            return numberRelationalOperator.apply(coerceToPrimitiveNumber(obj, Double.class).doubleValue(), coerceToPrimitiveNumber(obj2, Double.class).doubleValue());
        }
        return false;
    }

    public static boolean applyRelationalOperator(Object obj, Object obj2, NumberRelationalOperator numberRelationalOperator) throws ExpressionException {
        if (isBigDecimal(obj)) {
            return numberRelationalOperator.apply((BigDecimal) coerceToPrimitiveNumber(obj, BigDecimal.class), (BigDecimal) coerceToPrimitiveNumber(obj2, BigDecimal.class));
        }
        if (isFloatingPointType(obj)) {
            return numberRelationalOperator.apply(coerceToPrimitiveNumber(obj, Double.class).doubleValue(), coerceToPrimitiveNumber(obj2, Double.class).doubleValue());
        }
        if (isBigInteger(obj)) {
            return numberRelationalOperator.apply((BigInteger) coerceToPrimitiveNumber(obj, BigInteger.class), (BigInteger) coerceToPrimitiveNumber(obj2, BigInteger.class));
        }
        if (isIntegerType(obj)) {
            return numberRelationalOperator.apply(coerceToPrimitiveNumber(obj, Long.class).longValue(), coerceToPrimitiveNumber(obj2, Long.class).longValue());
        }
        if (obj instanceof String) {
            return numberRelationalOperator.apply(coerceToString(obj), coerceToString(obj2));
        }
        if (obj instanceof Comparable) {
            try {
                int compareTo = ((Comparable) obj).compareTo(obj2);
                return numberRelationalOperator.apply(compareTo, -compareTo);
            } catch (Exception e) {
                Logger.u(TAG, e, new Object[0]);
                return false;
            }
        } else if (obj2 instanceof Comparable) {
            try {
                int compareTo2 = ((Comparable) obj2).compareTo(obj);
                return numberRelationalOperator.apply(-compareTo2, compareTo2);
            } catch (Exception e2) {
                Logger.u(TAG, e2, new Object[0]);
                return false;
            }
        } else {
            Logger.v(TAG, "不支持的类型 OperatorSymbol", numberRelationalOperator.getOperatorSymbol(), "leftClass", obj.getClass().getName(), "rightClass", obj2.getClass().getName());
            return false;
        }
    }

    public static Object coerce(Object obj, Class cls) throws ExpressionException {
        if (cls == String.class) {
            return coerceToString(obj);
        }
        if (isNumberClass(cls)) {
            return coerceToPrimitiveNumber(obj, cls);
        }
        if (cls != Character.class && cls != Character.TYPE) {
            if (cls != Boolean.class && cls != Boolean.TYPE) {
                throw new ExpressionException("不支持的类型");
            }
            return coerceToBoolean(obj);
        }
        return coerceToCharacter(obj);
    }

    public static Boolean coerceToBoolean(Object obj) throws ExpressionException {
        if (obj != null && !"".equals(obj)) {
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            if (obj instanceof String) {
                try {
                    return Boolean.valueOf((String) obj);
                } catch (Exception unused) {
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static Character coerceToCharacter(Object obj) throws ExpressionException {
        if (obj != null && !"".equals(obj)) {
            if (obj instanceof Character) {
                return (Character) obj;
            }
            if (obj instanceof Boolean) {
                return new Character((char) 0);
            }
            if (obj instanceof Number) {
                return new Character((char) ((Number) obj).shortValue());
            }
            if (obj instanceof String) {
                return new Character(((String) obj).charAt(0));
            }
            return new Character((char) 0);
        }
        return new Character((char) 0);
    }

    public static Number coerceToPrimitiveNumber(Object obj, Class cls) throws ExpressionException {
        if (obj != null && !"".equals(obj)) {
            if (obj instanceof Character) {
                return coerceToPrimitiveNumber((Number) new Short((short) ((Character) obj).charValue()), cls);
            }
            if (obj instanceof Boolean) {
                return coerceToPrimitiveNumber(ZERO, cls);
            }
            if (obj.getClass() == cls) {
                return (Number) obj;
            }
            if (obj instanceof Number) {
                return coerceToPrimitiveNumber((Number) obj, cls);
            }
            if (obj instanceof String) {
                try {
                    return coerceToPrimitiveNumber((String) obj, cls);
                } catch (Exception e) {
                    Logger.u(TAG, e, new Object[0]);
                    return coerceToPrimitiveNumber(ZERO, cls);
                }
            }
            Logger.v(TAG, "不支持的类型，valueClass", obj.getClass().getName());
            return coerceToPrimitiveNumber((Number) 0, cls);
        }
        return coerceToPrimitiveNumber(ZERO, cls);
    }

    public static String coerceToString(Object obj) throws ExpressionException {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        try {
            return obj.toString();
        } catch (Exception e) {
            Logger.u(TAG, e, new Object[0]);
            return "";
        }
    }

    public static boolean isBigDecimal(Object obj) {
        return obj instanceof BigDecimal;
    }

    public static boolean isBigInteger(Object obj) {
        return obj instanceof BigInteger;
    }

    public static boolean isFloatingPointType(Object obj) {
        return obj != null && isFloatingPointType((Class) obj.getClass());
    }

    public static boolean isIntegerType(Object obj) {
        return obj != null && isIntegerType((Class) obj.getClass());
    }

    private static boolean isNumberClass(Class cls) {
        return cls == Byte.class || cls == Byte.TYPE || cls == Short.class || cls == Short.TYPE || cls == Integer.class || cls == Integer.TYPE || cls == Long.class || cls == Long.TYPE || cls == Float.class || cls == Float.TYPE || cls == Double.class || cls == Double.TYPE || cls == BigInteger.class || cls == BigDecimal.class;
    }

    public static boolean isFloatingPointType(Class cls) {
        return cls == Float.class || cls == Float.TYPE || cls == Double.class || cls == Double.TYPE;
    }

    public static boolean isIntegerType(Class cls) {
        return cls == Byte.class || cls == Byte.TYPE || cls == Short.class || cls == Short.TYPE || cls == Character.class || cls == Character.TYPE || cls == Integer.class || cls == Integer.TYPE || cls == Long.class || cls == Long.TYPE;
    }

    static Number coerceToPrimitiveNumber(Number number, Class cls) throws ExpressionException {
        if (cls != Byte.class && cls != Byte.TYPE) {
            if (cls != Short.class && cls != Short.TYPE) {
                if (cls != Integer.class && cls != Integer.TYPE) {
                    if (cls != Long.class && cls != Long.TYPE) {
                        if (cls != Float.class && cls != Float.TYPE) {
                            if (cls != Double.class && cls != Double.TYPE) {
                                if (cls == BigInteger.class) {
                                    if (number instanceof BigDecimal) {
                                        return ((BigDecimal) number).toBigInteger();
                                    }
                                    return BigInteger.valueOf(number.longValue());
                                } else if (cls == BigDecimal.class) {
                                    if (number instanceof BigInteger) {
                                        return new BigDecimal((BigInteger) number);
                                    }
                                    return new BigDecimal(number.doubleValue());
                                } else {
                                    return new Integer(0);
                                }
                            }
                            return Double.valueOf(number.doubleValue());
                        }
                        return Float.valueOf(number.floatValue());
                    }
                    return Long.valueOf(number.longValue());
                }
                return Integer.valueOf(number.intValue());
            }
            return Short.valueOf(number.shortValue());
        }
        return Byte.valueOf(number.byteValue());
    }

    static Number coerceToPrimitiveNumber(String str, Class cls) throws ExpressionException {
        if (cls != Byte.class && cls != Byte.TYPE) {
            if (cls != Short.class && cls != Short.TYPE) {
                if (cls != Integer.class && cls != Integer.TYPE) {
                    if (cls != Long.class && cls != Long.TYPE) {
                        if (cls != Float.class && cls != Float.TYPE) {
                            if (cls != Double.class && cls != Double.TYPE) {
                                if (cls == BigInteger.class) {
                                    return new BigInteger(str);
                                }
                                if (cls == BigDecimal.class) {
                                    return new BigDecimal(str);
                                }
                                return new Integer(0);
                            }
                            return Double.valueOf(str);
                        }
                        return Float.valueOf(str);
                    }
                    return Long.valueOf(str);
                }
                return Integer.valueOf(str);
            }
            return Short.valueOf(str);
        }
        return Byte.valueOf(str);
    }
}
