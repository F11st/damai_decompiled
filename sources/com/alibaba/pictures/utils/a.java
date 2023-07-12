package com.alibaba.pictures.utils;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.lg1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class a {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a INSTANCE = new a();

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0156a<C, T> {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private Field a;

        public C0156a(@Nullable Class<C> cls, @Nullable String str) {
            Field field = null;
            if (cls != null) {
                try {
                    try {
                        if (!TextUtils.isEmpty(str) && (field = cls.getDeclaredField(str)) != null) {
                            field.setAccessible(true);
                        }
                    } catch (NoSuchFieldException e) {
                        lg1.INSTANCE.d("Hack", e.getMessage());
                    }
                } finally {
                    this.a = field;
                }
            }
        }

        @Nullable
        public final T a(C c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1259242842")) {
                return (T) ipChange.ipc$dispatch("-1259242842", new Object[]{this, c});
            }
            try {
                Field field = this.a;
                if (field != null) {
                    b41.f(field);
                    return (T) field.get(c);
                }
                return null;
            } catch (IllegalAccessException e) {
                lg1.INSTANCE.d("Hack", e.getMessage());
                return null;
            }
        }

        @NotNull
        public final <T2> C0156a<C, T2> b(@NotNull Class<T2> cls) throws HackHandleException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "667943116")) {
                return (C0156a) ipChange.ipc$dispatch("667943116", new Object[]{this, cls});
            }
            b41.i(cls, "type");
            Field field = this.a;
            if (field != null) {
                b41.f(field);
                if (!cls.isAssignableFrom(field.getType())) {
                    a aVar = a.INSTANCE;
                    aVar.d(new HackHandleException(new ClassCastException(this.a + " is not of type " + cls)));
                }
            }
            return this;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class b {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private Method a;

        public b(@Nullable Class<?> cls, @Nullable String str, @NotNull Class<?>[] clsArr) {
            b41.i(clsArr, "argTypes");
            Method method = null;
            if (cls == null) {
                this.a = null;
                return;
            }
            if (str != null) {
                try {
                    try {
                        method = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
                    } catch (NoSuchMethodException e) {
                        HackHandleException hackHandleException = new HackHandleException(e);
                        hackHandleException.setHackedClass(cls);
                        hackHandleException.setHackedMethodName(str);
                        a.INSTANCE.d(hackHandleException);
                    }
                } catch (Throwable th) {
                    this.a = method;
                    throw th;
                }
            }
            if (method != null) {
                method.setAccessible(true);
            }
            this.a = method;
        }

        @Nullable
        public final Object a(@Nullable Object obj, @NotNull Object... objArr) throws IllegalArgumentException, InvocationTargetException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-769899314")) {
                return ipChange.ipc$dispatch("-769899314", new Object[]{this, obj, objArr});
            }
            b41.i(objArr, "args");
            try {
                Method method = this.a;
                b41.f(method);
                return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(HackHandleException hackHandleException) throws HackHandleException {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1632915789")) {
            throw hackHandleException;
        }
        ipChange.ipc$dispatch("-1632915789", new Object[]{this, hackHandleException});
    }

    @NotNull
    public final b b(@Nullable Class<?> cls, @Nullable String str, @NotNull Class<?>... clsArr) throws HackHandleException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1041902232")) {
            return (b) ipChange.ipc$dispatch("-1041902232", new Object[]{this, cls, str, clsArr});
        }
        b41.i(clsArr, "argTypes");
        return new b(cls, str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
    }

    @NotNull
    public final <C> C0156a<C, Object> c(@Nullable Class<C> cls, @Nullable String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "702730641") ? (C0156a) ipChange.ipc$dispatch("702730641", new Object[]{this, cls, str}) : new C0156a<>(cls, str);
    }
}
