package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;
import com.youku.gaiax.quickjs.JSRuntime;
import com.youku.gaiax.quickjs.adapter.ArrayTypeAdapter;
import com.youku.gaiax.quickjs.adapter.InterfaceTypeAdapter;
import com.youku.gaiax.quickjs.adapter.JSFunctionAdapter;
import com.youku.gaiax.quickjs.adapter.JSValueAdapter;
import com.youku.gaiax.quickjs.adapter.StandardTypeAdapters;
import com.youku.gaiax.quickjs.adapter.TypeAdapter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public class QuickJS implements TypeAdapter.Depot {
    private static final List<TypeAdapter.Factory> BUILT_IN_FACTORIES;
    private final Map<Type, TypeAdapter<?>> adapterCache;
    private final List<TypeAdapter.Factory> factories;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Builder {
        private final List<TypeAdapter.Factory> factories = new ArrayList();

        public QuickJS build() {
            return new QuickJS(this);
        }

        public <T> Builder registerTypeAdapter(final Type type, final TypeAdapter<T> typeAdapter) {
            return registerTypeAdapterFactory(new TypeAdapter.Factory() { // from class: com.youku.gaiax.quickjs.QuickJS.Builder.1
                @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Factory
                public TypeAdapter<?> create(TypeAdapter.Depot depot, Type type2) {
                    if (Types.equals(type, type2)) {
                        return typeAdapter;
                    }
                    return null;
                }
            });
        }

        public Builder registerTypeAdapterFactory(TypeAdapter.Factory factory) {
            this.factories.add(factory);
            return this;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(4);
        BUILT_IN_FACTORIES = arrayList;
        arrayList.add(StandardTypeAdapters.FACTORY);
        arrayList.add(JSValueAdapter.FACTORY);
        arrayList.add(ArrayTypeAdapter.FACTORY);
        arrayList.add(InterfaceTypeAdapter.FACTORY);
        arrayList.add(JSFunctionAdapter.FACTORY);
        System.loadLibrary("quickjs");
        System.loadLibrary("gaiaxjs");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createContext(long j);

    static native long createRuntime();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArray(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArrayBufferB(long j, byte[] bArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArrayBufferC(long j, char[] cArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArrayBufferD(long j, double[] dArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArrayBufferF(long j, float[] fArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArrayBufferI(long j, int[] iArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArrayBufferJ(long j, long[] jArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArrayBufferS(long j, short[] sArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArrayBufferZ(long j, boolean[] zArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueBoolean(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueFloat64(long j, double d);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueFunction(long j, JSContext jSContext, Object obj, String str, String str2, Type type, Type[] typeArr, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueFunctionS(long j, JSContext jSContext, String str, String str2, String str3, Type type, Type[] typeArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueInt(long j, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueJavaObject(long j, Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueJson(long j, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueNull(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueObject(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long[] createValuePromise(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueString(long j, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueUndefined(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean defineValueProperty(long j, long j2, int i, long j3, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean defineValueProperty(long j, long j2, String str, long j3, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void destroyContext(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void destroyRuntime(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void destroyValue(long j, long j2);

    public static native void dupValue(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long evaluate(long j, String str, String str2, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int executePendingJob(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void freeValue(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native JSException getException(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long getGlobalObject(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean getValueBoolean(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native double getValueFloat64(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int getValueInt(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native Object getValueJavaObject(long j, long j2);

    static native String getValueJsonString(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long getValueProperty(long j, long j2, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long getValueProperty(long j, long j2, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native String getValueString(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int getValueTag(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void initModuleBridge(long j, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void initModuleOs(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void initModuleStd(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void initStdHandlers(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long invokeValueFunction(long j, long j2, long j3, long[] jArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean isValueArray(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean isValueArrayBuffer(long j, long j2);

    public static native boolean isValueFunction(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setPromiseRejectionHandler(long j, JSRuntime.PromiseRejectionHandler promiseRejectionHandler);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setRuntimeInterruptHandler(long j, JSRuntime.InterruptHandler interruptHandler);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setRuntimeMallocLimit(long j, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setRuntimeMaxStackSize(long j, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setValueProperty(long j, long j2, int i, long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setValueProperty(long j, long j2, String str, long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean[] toBooleanArray(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native byte[] toByteArray(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native char[] toCharArray(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native double[] toDoubleArray(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native float[] toFloatArray(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int[] toIntArray(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long[] toLongArray(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native short[] toShortArray(long j, long j2);

    public JSRuntime createJSRuntime() {
        long createRuntime = createRuntime();
        if (createRuntime != 0) {
            return new JSRuntime(createRuntime, this);
        }
        throw new IllegalStateException("Cannot create JSRuntime instance");
    }

    @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Depot
    public <T> TypeAdapter<T> getAdapter(Type type) {
        Type removeSubtypeWildcard = Types.removeSubtypeWildcard(Types.canonicalize(type));
        TypeAdapter<T> typeAdapter = (TypeAdapter<T>) this.adapterCache.get(removeSubtypeWildcard);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        int size = this.factories.size();
        for (int i = 0; i < size; i++) {
            TypeAdapter<T> typeAdapter2 = (TypeAdapter<T>) this.factories.get(i).create(this, removeSubtypeWildcard);
            if (typeAdapter2 != null) {
                this.adapterCache.put(removeSubtypeWildcard, typeAdapter2);
                return typeAdapter2;
            }
        }
        throw new IllegalArgumentException("Can't find TypeAdapter for " + type);
    }

    private QuickJS(Builder builder) {
        int size = builder.factories.size();
        List<TypeAdapter.Factory> list = BUILT_IN_FACTORIES;
        ArrayList arrayList = new ArrayList(size + list.size());
        arrayList.addAll(builder.factories);
        arrayList.addAll(list);
        this.factories = Collections.unmodifiableList(arrayList);
        this.adapterCache = new ConcurrentHashMap();
    }
}
