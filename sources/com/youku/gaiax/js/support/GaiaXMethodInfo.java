package com.youku.gaiax.js.support;

import com.alibaba.fastjson.JSONArray;
import com.youku.gaiax.js.api.IGaiaXModuleMethod;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0010\u0018\u00002\u00020\u0001:\u0003%&'B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b#\u0010$J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0019\u0010\n\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R,\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0013\u0010\"\u001a\u00020\u001f8F@\u0006¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006("}, d2 = {"Lcom/youku/gaiax/js/support/GaiaXMethodInfo;", "Lcom/youku/gaiax/js/api/IGaiaXModuleMethod;", "", "obj", "Lcom/alibaba/fastjson/JSONArray;", "args", "invoke", "Ltb/wt2;", "convertArgsToArguments", "", "id", "J", "getId", "()J", "Ljava/lang/reflect/Method;", "rawMethod", "Ljava/lang/reflect/Method;", "getRawMethod", "()Ljava/lang/reflect/Method;", "Lcom/youku/gaiax/js/support/GaiaXMethod;", "method", "Lcom/youku/gaiax/js/support/GaiaXMethod;", "getMethod", "()Lcom/youku/gaiax/js/support/GaiaXMethod;", "", "arguments", "[Ljava/lang/Object;", "getArguments", "()[Ljava/lang/Object;", "setArguments", "([Ljava/lang/Object;)V", "", "getName", "()Ljava/lang/String;", "name", "<init>", "(JLjava/lang/reflect/Method;)V", "GaiaXAsyncMethodInfo", "GaiaXPromiseMethodInfo", "GaiaXSyncMethodInfo", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class GaiaXMethodInfo implements IGaiaXModuleMethod {
    @Nullable
    private Object[] arguments;
    private final long id;
    @NotNull
    private final GaiaXMethod method;
    @NotNull
    private final Method rawMethod;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/youku/gaiax/js/support/GaiaXMethodInfo$GaiaXAsyncMethodInfo;", "Lcom/youku/gaiax/js/support/GaiaXMethodInfo;", "", "id", "Ljava/lang/reflect/Method;", "method", "<init>", "(JLjava/lang/reflect/Method;)V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GaiaXAsyncMethodInfo extends GaiaXMethodInfo {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GaiaXAsyncMethodInfo(long j, @NotNull Method method) {
            super(j, method);
            b41.i(method, "method");
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/youku/gaiax/js/support/GaiaXMethodInfo$GaiaXPromiseMethodInfo;", "Lcom/youku/gaiax/js/support/GaiaXMethodInfo;", "", "id", "Ljava/lang/reflect/Method;", "method", "<init>", "(JLjava/lang/reflect/Method;)V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GaiaXPromiseMethodInfo extends GaiaXMethodInfo {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GaiaXPromiseMethodInfo(long j, @NotNull Method method) {
            super(j, method);
            b41.i(method, "method");
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/youku/gaiax/js/support/GaiaXMethodInfo$GaiaXSyncMethodInfo;", "Lcom/youku/gaiax/js/support/GaiaXMethodInfo;", "", "id", "Ljava/lang/reflect/Method;", "method", "<init>", "(JLjava/lang/reflect/Method;)V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GaiaXSyncMethodInfo extends GaiaXMethodInfo {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GaiaXSyncMethodInfo(long j, @NotNull Method method) {
            super(j, method);
            b41.i(method, "method");
        }
    }

    public GaiaXMethodInfo(long j, @NotNull Method method) {
        b41.i(method, "rawMethod");
        this.id = j;
        this.rawMethod = method;
        method.setAccessible(true);
        GaiaXMethod create = GaiaXMethod.create(method.getReturnType(), method);
        b41.h(create, "create(rawMethod.returnType, rawMethod)");
        this.method = create;
    }

    @Override // com.youku.gaiax.js.api.IGaiaXModuleMethod
    public void convertArgsToArguments(@NotNull JSONArray jSONArray) {
        Object[] objArr;
        b41.i(jSONArray, "args");
        if (jSONArray.size() == this.method.parameterTypes.length) {
            ArrayList arrayList = new ArrayList();
            Type[] typeArr = this.method.parameterTypes;
            b41.h(typeArr, "method.parameterTypes");
            int length = typeArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                Type type = typeArr[i];
                int i3 = i2 + 1;
                Object obj = jSONArray.get(i2);
                JSDataConvert jSDataConvert = JSDataConvert.INSTANCE;
                b41.h(type, "valueType");
                arrayList.add(jSDataConvert.convertToJavaValue(type, obj));
                i++;
                i2 = i3;
            }
            objArr = arrayList.toArray(new Object[0]);
            Objects.requireNonNull(objArr, "null cannot be cast to non-null type kotlin.Array<T>");
        } else {
            objArr = new Object[0];
        }
        this.arguments = objArr;
    }

    @Nullable
    public final Object[] getArguments() {
        return this.arguments;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final GaiaXMethod getMethod() {
        return this.method;
    }

    @NotNull
    public final String getName() {
        String name = this.rawMethod.getName();
        b41.h(name, "rawMethod.name");
        return name;
    }

    @NotNull
    public final Method getRawMethod() {
        return this.rawMethod;
    }

    @Override // com.youku.gaiax.js.api.IGaiaXModuleMethod
    @Nullable
    public Object invoke(@NotNull Object obj, @NotNull JSONArray jSONArray) {
        b41.i(obj, "obj");
        b41.i(jSONArray, "args");
        convertArgsToArguments(jSONArray);
        Method method = this.rawMethod;
        Object[] objArr = this.arguments;
        b41.f(objArr);
        return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    public final void setArguments(@Nullable Object[] objArr) {
        this.arguments = objArr;
    }
}
