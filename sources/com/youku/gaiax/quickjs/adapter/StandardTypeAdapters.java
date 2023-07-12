package com.youku.gaiax.quickjs.adapter;

import com.youku.gaiax.quickjs.JSBoolean;
import com.youku.gaiax.quickjs.JSDataException;
import com.youku.gaiax.quickjs.JSNull;
import com.youku.gaiax.quickjs.JSNumber;
import com.youku.gaiax.quickjs.JSString;
import com.youku.gaiax.quickjs.JSUndefined;
import com.youku.gaiax.quickjs.JSValue;
import com.youku.gaiax.quickjs.adapter.TypeAdapter;
import java.lang.reflect.Type;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class StandardTypeAdapters {
    public static final TypeAdapter.Factory FACTORY = new TypeAdapter.Factory() { // from class: com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.1
        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Factory
        public TypeAdapter<?> create(TypeAdapter.Depot depot, Type type) {
            if (type == Void.TYPE) {
                return StandardTypeAdapters.VOID_TYPE_ADAPTER;
            }
            if (type == Boolean.TYPE) {
                return StandardTypeAdapters.BOOLEAN_TYPE_ADAPTER;
            }
            if (type == Byte.TYPE) {
                return StandardTypeAdapters.BYTE_TYPE_ADAPTER;
            }
            if (type == Character.TYPE) {
                return StandardTypeAdapters.CHARACTER_TYPE_ADAPTER;
            }
            if (type == Short.TYPE) {
                return StandardTypeAdapters.SHORT_TYPE_ADAPTER;
            }
            if (type == Integer.TYPE) {
                return StandardTypeAdapters.INTEGER_TYPE_ADAPTER;
            }
            if (type == Long.TYPE) {
                return StandardTypeAdapters.LONG_TYPE_ADAPTER;
            }
            if (type == Float.TYPE) {
                return StandardTypeAdapters.FLOAT_TYPE_ADAPTER;
            }
            if (type == Double.TYPE) {
                return StandardTypeAdapters.DOUBLE_TYPE_ADAPTER;
            }
            if (type == Void.class) {
                return StandardTypeAdapters.VOID_TYPE_ADAPTER;
            }
            if (type == Boolean.class) {
                return StandardTypeAdapters.BOOLEAN_TYPE_ADAPTER.nullable();
            }
            if (type == Byte.class) {
                return StandardTypeAdapters.BYTE_TYPE_ADAPTER.nullable();
            }
            if (type == Character.class) {
                return StandardTypeAdapters.CHARACTER_TYPE_ADAPTER.nullable();
            }
            if (type == Short.class) {
                return StandardTypeAdapters.SHORT_TYPE_ADAPTER.nullable();
            }
            if (type == Integer.class) {
                return StandardTypeAdapters.INTEGER_TYPE_ADAPTER.nullable();
            }
            if (type == Long.class) {
                return StandardTypeAdapters.LONG_TYPE_ADAPTER.nullable();
            }
            if (type == Float.class) {
                return StandardTypeAdapters.FLOAT_TYPE_ADAPTER.nullable();
            }
            if (type == Double.class) {
                return StandardTypeAdapters.DOUBLE_TYPE_ADAPTER.nullable();
            }
            if (type == String.class) {
                return StandardTypeAdapters.STRING_TYPE_ADAPTER.nullable();
            }
            return null;
        }
    };
    private static final TypeAdapter<Void> VOID_TYPE_ADAPTER = new TypeAdapter<Void>() { // from class: com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.2
        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public Void fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            if ((jSValue instanceof JSNull) || (jSValue instanceof JSUndefined)) {
                return null;
            }
            throw new JSDataException("excepted: JSNull or JSUndefined, actual: " + jSValue.getClass().getSimpleName());
        }

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Void r3) {
            return context.createJSNull();
        }
    };
    private static final TypeAdapter<Boolean> BOOLEAN_TYPE_ADAPTER = new TypeAdapter<Boolean>() { // from class: com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.3
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public Boolean fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Boolean.valueOf(((JSBoolean) jSValue.cast(JSBoolean.class)).getBoolean());
        }

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Boolean bool) {
            return context.createJSBoolean(bool.booleanValue());
        }
    };
    private static final TypeAdapter<Byte> BYTE_TYPE_ADAPTER = new TypeAdapter<Byte>() { // from class: com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.4
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public Byte fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Byte.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getByte());
        }

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Byte b) {
            return context.createJSNumber((int) b.byteValue());
        }
    };
    private static final TypeAdapter<Character> CHARACTER_TYPE_ADAPTER = new TypeAdapter<Character>() { // from class: com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.5
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public Character fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            String string = ((JSString) jSValue.cast(JSString.class)).getString();
            if (string.length() == 1) {
                return Character.valueOf(string.charAt(0));
            }
            throw new JSDataException("Can't treat \"" + string + "\" as char");
        }

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Character ch) {
            return context.createJSString(ch.toString());
        }
    };
    private static final TypeAdapter<Short> SHORT_TYPE_ADAPTER = new TypeAdapter<Short>() { // from class: com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.6
        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public Short fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Short.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getShort());
        }

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Short sh) {
            return context.createJSNumber((int) sh.shortValue());
        }
    };
    private static final TypeAdapter<Integer> INTEGER_TYPE_ADAPTER = new TypeAdapter<Integer>() { // from class: com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.7
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public Integer fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Integer.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getInt());
        }

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Integer num) {
            return context.createJSNumber(num.intValue());
        }
    };
    private static final TypeAdapter<Long> LONG_TYPE_ADAPTER = new TypeAdapter<Long>() { // from class: com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.8
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public Long fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Long.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getLong());
        }

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Long l) {
            return context.createJSNumber(l.longValue());
        }
    };
    private static final TypeAdapter<Float> FLOAT_TYPE_ADAPTER = new TypeAdapter<Float>() { // from class: com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.9
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public Float fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Float.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getFloat());
        }

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Float f) {
            return context.createJSNumber(f.floatValue());
        }
    };
    private static final TypeAdapter<Double> DOUBLE_TYPE_ADAPTER = new TypeAdapter<Double>() { // from class: com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.10
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public Double fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Double.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getDouble());
        }

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Double d) {
            return context.createJSNumber(d.doubleValue());
        }
    };
    private static final TypeAdapter<String> STRING_TYPE_ADAPTER = new TypeAdapter<String>() { // from class: com.youku.gaiax.quickjs.adapter.StandardTypeAdapters.11
        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public String fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return ((JSString) jSValue.cast(JSString.class)).getString();
        }

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, String str) {
            return context.createJSString(str);
        }
    };
}
