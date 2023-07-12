package com.youku.gaiax.quickjs.adapter;

import com.youku.gaiax.quickjs.JSArray;
import com.youku.gaiax.quickjs.JSBoolean;
import com.youku.gaiax.quickjs.JSFunction;
import com.youku.gaiax.quickjs.JSNull;
import com.youku.gaiax.quickjs.JSNumber;
import com.youku.gaiax.quickjs.JSObject;
import com.youku.gaiax.quickjs.JSString;
import com.youku.gaiax.quickjs.JSUndefined;
import com.youku.gaiax.quickjs.JSValue;
import com.youku.gaiax.quickjs.Method;
import java.lang.reflect.Type;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class TypeAdapter<T> {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface Context {
        JSArray createJSArray();

        JSBoolean createJSBoolean(boolean z);

        JSFunction createJSFunction(Object obj, Method method);

        JSFunction createJSFunctionS(Class cls, Method method);

        JSObject createJSJsonObject(String str);

        JSNull createJSNull();

        JSNumber createJSNumber(double d);

        JSNumber createJSNumber(int i);

        JSNumber createJSNumber(long j);

        JSObject createJSObject();

        JSObject createJSObject(Object obj);

        JSString createJSString(String str);

        JSUndefined createJSUndefined();
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface Depot {
        <T> TypeAdapter<T> getAdapter(Type type);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface Factory {
        TypeAdapter<?> create(Depot depot, Type type);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static class NullableTypeAdapter<T> extends TypeAdapter<T> {
        private final TypeAdapter<T> delegate;

        NullableTypeAdapter(TypeAdapter<T> typeAdapter) {
            this.delegate = typeAdapter;
        }

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public T fromJSValue(Depot depot, Context context, JSValue jSValue) {
            if ((jSValue instanceof JSNull) || (jSValue instanceof JSUndefined)) {
                return null;
            }
            return this.delegate.fromJSValue(depot, context, jSValue);
        }

        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
        public JSValue toJSValue(Depot depot, Context context, T t) {
            if (t == null) {
                return context.createJSNull();
            }
            return this.delegate.toJSValue(depot, context, t);
        }
    }

    public abstract T fromJSValue(Depot depot, Context context, JSValue jSValue);

    public final TypeAdapter<T> nullable() {
        return new NullableTypeAdapter(this);
    }

    public abstract JSValue toJSValue(Depot depot, Context context, T t);
}
