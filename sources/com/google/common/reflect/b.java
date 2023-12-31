package com.google.common.reflect;

import com.google.common.annotations.Beta;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/* compiled from: Taobao */
@Beta
/* loaded from: classes10.dex */
public abstract class b<T, R> extends com.google.common.reflect.a implements GenericDeclaration {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a<T> extends b<T, T> {
        final Constructor<?> c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Constructor<?> constructor) {
            super(constructor);
            this.c = constructor;
        }

        private boolean c() {
            Class<?> declaringClass = this.c.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            Method enclosingMethod = declaringClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                return !Modifier.isStatic(enclosingMethod.getModifiers());
            }
            return (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Type[] b() {
            Type[] genericParameterTypes = this.c.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !c()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.c.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable<Class<? super T>>[] typeParameters = getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] typeParameters2 = this.c.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[typeParameters.length + typeParameters2.length];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.reflect.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0240b<T> extends b<T, Object> {
        final Method c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0240b(Method method) {
            super(method);
            this.c = method;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            return this.c.getTypeParameters();
        }
    }

    <M extends AccessibleObject & Member> b(M m) {
        super(m);
    }

    @Override // com.google.common.reflect.a, java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) super.getDeclaringClass();
    }
}
