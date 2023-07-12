package com.youku.gaiax.quickjs.adapter;

import com.youku.gaiax.quickjs.JSArray;
import com.youku.gaiax.quickjs.JSValue;
import com.youku.gaiax.quickjs.Types;
import com.youku.gaiax.quickjs.adapter.TypeAdapter;
import java.lang.reflect.Array;
import java.lang.reflect.Type;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ArrayTypeAdapter extends TypeAdapter<Object> {
    public static final TypeAdapter.Factory FACTORY = new TypeAdapter.Factory() { // from class: com.youku.gaiax.quickjs.adapter.ArrayTypeAdapter.1
        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Factory
        public TypeAdapter<?> create(TypeAdapter.Depot depot, Type type) {
            Type arrayComponentType = Types.arrayComponentType(type);
            if (arrayComponentType == null) {
                return null;
            }
            return new ArrayTypeAdapter(Types.getRawType(arrayComponentType), depot.getAdapter(arrayComponentType)).nullable();
        }
    };
    private final TypeAdapter<Object> elementAdapter;
    private final Class<?> elementClass;

    @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
    public Object fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
        JSArray jSArray = (JSArray) jSValue.cast(JSArray.class);
        int length = jSArray.getLength();
        Object newInstance = Array.newInstance(this.elementClass, length);
        for (int i = 0; i < length; i++) {
            Array.set(newInstance, i, this.elementAdapter.fromJSValue(depot, context, jSArray.getProperty(i)));
        }
        return newInstance;
    }

    @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
    public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Object obj) {
        JSArray createJSArray = context.createJSArray();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            createJSArray.setProperty(i, this.elementAdapter.toJSValue(depot, context, Array.get(obj, i)));
        }
        return createJSArray;
    }

    private ArrayTypeAdapter(Class<?> cls, TypeAdapter<Object> typeAdapter) {
        this.elementClass = cls;
        this.elementAdapter = typeAdapter;
    }
}
