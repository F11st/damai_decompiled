package com.youku.gaiax.quickjs.adapter;

import com.youku.gaiax.quickjs.JSFunction;
import com.youku.gaiax.quickjs.JSValue;
import com.youku.gaiax.quickjs.adapter.TypeAdapter;
import java.lang.reflect.Type;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class JSFunctionAdapter {
    public static final TypeAdapter.Factory FACTORY = new TypeAdapter.Factory() { // from class: com.youku.gaiax.quickjs.adapter.JSFunctionAdapter.1
        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Factory
        public TypeAdapter<?> create(TypeAdapter.Depot depot, Type type) {
            if (type == JSFunction.class) {
                return JSFunctionAdapter.JS_FUNCTION_TYPE_ADAPTER;
            }
            return null;
        }
    };
    private static final TypeAdapter<JSFunction> JS_FUNCTION_TYPE_ADAPTER = new TypeAdapter<JSFunction>() { // from class: com.youku.gaiax.quickjs.adapter.JSFunctionAdapter.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public JSFunction fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return (JSFunction) jSValue.cast(JSFunction.class);
        }

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public JSFunction toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSFunction jSFunction) {
            Objects.requireNonNull(jSFunction, "value == null");
            return jSFunction;
        }
    };
}
