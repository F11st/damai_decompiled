package com.youku.gaiax.quickjs.adapter;

import com.youku.gaiax.quickjs.JSFunction;
import com.youku.gaiax.quickjs.JSObject;
import com.youku.gaiax.quickjs.JSValue;
import com.youku.gaiax.quickjs.Method;
import com.youku.gaiax.quickjs.Types;
import com.youku.gaiax.quickjs.adapter.TypeAdapter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class InterfaceTypeAdapter extends TypeAdapter<Object> {
    public static final TypeAdapter.Factory FACTORY = new TypeAdapter.Factory() { // from class: com.youku.gaiax.quickjs.adapter.InterfaceTypeAdapter.1
        @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Factory
        public TypeAdapter<?> create(TypeAdapter.Depot depot, Type type) {
            Map<String, Method> interfaceMethods = InterfaceTypeAdapter.getInterfaceMethods(type);
            if (interfaceMethods == null) {
                return null;
            }
            return new InterfaceTypeAdapter(Types.getRawType(type), interfaceMethods).nullable();
        }
    };
    private static final JSValueHolderTag JS_VALUE_HOLDER_TAG = new JSValueHolderTag();
    private final Map<String, Method> methods;
    private final Class<?> rawType;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private interface JSValueHolder {
        JSValue getJSValue(JSValueHolderTag jSValueHolderTag);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static class JSValueHolderTag {
        private JSValueHolderTag() {
        }
    }

    static Map<String, Method> getInterfaceMethods(Type type) {
        java.lang.reflect.Method[] methods;
        Class<?> rawType = Types.getRawType(type);
        if (rawType.isInterface()) {
            HashMap hashMap = new HashMap();
            for (java.lang.reflect.Method method : rawType.getMethods()) {
                Type resolve = Types.resolve(type, rawType, method.getGenericReturnType());
                if (resolve instanceof TypeVariable) {
                    return null;
                }
                String name = method.getName();
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                int length = genericParameterTypes.length;
                Type[] typeArr = new Type[length];
                for (int i = 0; i < length; i++) {
                    typeArr[i] = Types.resolve(type, rawType, genericParameterTypes[i]);
                    if (typeArr[i] instanceof TypeVariable) {
                        return null;
                    }
                }
                Method method2 = (Method) hashMap.get(name);
                if (method2 != null) {
                    if (!Arrays.equals(method2.parameterTypes, typeArr)) {
                        return null;
                    }
                    if (!resolve.equals(method2.returnType)) {
                        if (Types.getRawType(resolve).isAssignableFrom(Types.getRawType(method2.returnType))) {
                        }
                    }
                }
                hashMap.put(name, new Method(resolve, name, typeArr));
            }
            return hashMap;
        }
        return null;
    }

    @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
    public Object fromJSValue(final TypeAdapter.Depot depot, final TypeAdapter.Context context, final JSValue jSValue) {
        final JSObject jSObject = (JSObject) jSValue.cast(JSObject.class);
        Object javaObject = jSObject.getJavaObject();
        return this.rawType.isInstance(javaObject) ? javaObject : Proxy.newProxyInstance(this.rawType.getClassLoader(), new Class[]{this.rawType, JSValueHolder.class}, new InvocationHandler() { // from class: com.youku.gaiax.quickjs.adapter.InterfaceTypeAdapter.2
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, java.lang.reflect.Method method, Object[] objArr) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (objArr != null && objArr.length == 1 && objArr[0] == InterfaceTypeAdapter.JS_VALUE_HOLDER_TAG) {
                    return jSValue;
                }
                String name = method.getName();
                Method method2 = (Method) InterfaceTypeAdapter.this.methods.get(name);
                if (method2 != null) {
                    int length = objArr != null ? objArr.length : 0;
                    if (length == method2.parameterTypes.length) {
                        JSValue[] jSValueArr = new JSValue[length];
                        for (int i = 0; i < length; i++) {
                            jSValueArr[i] = depot.getAdapter(method2.parameterTypes[i]).toJSValue(depot, context, objArr[i]);
                        }
                        return depot.getAdapter(method2.returnType).fromJSValue(depot, context, ((JSFunction) jSObject.getProperty(name).cast(JSFunction.class)).invoke(jSObject, jSValueArr));
                    }
                    throw new IllegalStateException("Parameter number doesn't match: " + name);
                }
                throw new NoSuchMethodException("Can't find method: " + name);
            }
        });
    }

    @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter
    public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Object obj) {
        if (obj instanceof JSValueHolder) {
            return ((JSValueHolder) obj).getJSValue(JS_VALUE_HOLDER_TAG);
        }
        JSObject createJSObject = context.createJSObject(obj);
        for (Method method : this.methods.values()) {
            createJSObject.setProperty(method.name, context.createJSFunction(obj, method));
        }
        return createJSObject;
    }

    private InterfaceTypeAdapter(Class<?> cls, Map<String, Method> map) {
        this.rawType = cls;
        this.methods = map;
    }
}
