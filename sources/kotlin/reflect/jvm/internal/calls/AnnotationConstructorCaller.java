package kotlin.reflect.jvm.internal.calls;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.C8215n;
import kotlin.collections.C8226x;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class AnnotationConstructorCaller implements Caller {
    @NotNull
    private final List<Type> a;
    private final List<Class<?>> b;
    private final List<Object> c;
    private final Class<?> d;
    private final List<String> e;
    private final CallMode f;
    private final List<Method> g;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "", "<init>", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public enum CallMode {
        CALL_BY_NAME,
        POSITIONAL_CALL
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "", "<init>", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public enum Origin {
        JAVA,
        KOTLIN
    }

    public AnnotationConstructorCaller(@NotNull Class<?> cls, @NotNull List<String> list, @NotNull CallMode callMode, @NotNull Origin origin, @NotNull List<Method> list2) {
        int q;
        int q2;
        int q3;
        List j0;
        b41.i(cls, "jClass");
        b41.i(list, "parameterNames");
        b41.i(callMode, "callMode");
        b41.i(origin, "origin");
        b41.i(list2, "methods");
        this.d = cls;
        this.e = list;
        this.f = callMode;
        this.g = list2;
        q = C8215n.q(list2, 10);
        ArrayList arrayList = new ArrayList(q);
        for (Method method : list2) {
            arrayList.add(method.getGenericReturnType());
        }
        this.a = arrayList;
        List<Method> list3 = this.g;
        q2 = C8215n.q(list3, 10);
        ArrayList arrayList2 = new ArrayList(q2);
        for (Method method2 : list3) {
            Class<?> returnType = method2.getReturnType();
            b41.h(returnType, AdvanceSetting.NETWORK_TYPE);
            Class<?> g = ReflectClassUtilKt.g(returnType);
            if (g != null) {
                returnType = g;
            }
            arrayList2.add(returnType);
        }
        this.b = arrayList2;
        List<Method> list4 = this.g;
        q3 = C8215n.q(list4, 10);
        ArrayList arrayList3 = new ArrayList(q3);
        for (Method method3 : list4) {
            arrayList3.add(method3.getDefaultValue());
        }
        this.c = arrayList3;
        if (this.f == CallMode.POSITIONAL_CALL && origin == Origin.JAVA) {
            j0 = CollectionsKt___CollectionsKt.j0(this.e, "value");
            if (!j0.isEmpty()) {
                throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
            }
        }
    }

    public void a(@NotNull Object[] objArr) {
        b41.i(objArr, "args");
        Caller.C8265a.a(this, objArr);
    }

    @Nullable
    public Void b() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @Nullable
    public Object call(@NotNull Object[] objArr) {
        List H0;
        Map r;
        b41.i(objArr, "args");
        a(objArr);
        ArrayList arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object obj = objArr[i];
            int i3 = i2 + 1;
            Object f = (obj == null && this.f == CallMode.CALL_BY_NAME) ? this.c.get(i2) : AnnotationConstructorCallerKt.f(obj, this.b.get(i2));
            if (f == null) {
                AnnotationConstructorCallerKt.e(i2, this.e.get(i2), this.b.get(i2));
                throw null;
            }
            arrayList.add(f);
            i++;
            i2 = i3;
        }
        Class<?> cls = this.d;
        H0 = CollectionsKt___CollectionsKt.H0(this.e, arrayList);
        r = C8226x.r(H0);
        return AnnotationConstructorCallerKt.c(cls, r, this.g);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public /* bridge */ /* synthetic */ Member getMember() {
        return (Member) b();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public List<Type> getParameterTypes() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public Type getReturnType() {
        return this.d;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AnnotationConstructorCaller(java.lang.Class r7, java.util.List r8, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.CallMode r9, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.Origin r10, java.util.List r11, int r12, tb.k50 r13) {
        /*
            r6 = this;
            r12 = r12 & 16
            if (r12 == 0) goto L2a
            java.util.ArrayList r11 = new java.util.ArrayList
            r12 = 10
            int r12 = kotlin.collections.C8212k.q(r8, r12)
            r11.<init>(r12)
            java.util.Iterator r12 = r8.iterator()
        L13:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L2a
            java.lang.Object r13 = r12.next()
            java.lang.String r13 = (java.lang.String) r13
            r0 = 0
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.reflect.Method r13 = r7.getDeclaredMethod(r13, r0)
            r11.add(r13)
            goto L13
        L2a:
            r5 = r11
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.<init>(java.lang.Class, java.util.List, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$CallMode, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$Origin, java.util.List, int, tb.k50):void");
    }
}
