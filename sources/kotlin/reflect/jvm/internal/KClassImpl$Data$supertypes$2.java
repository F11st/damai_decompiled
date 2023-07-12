package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.d70;
import tb.fd2;
import tb.kk;
import tb.z71;
import tb.zv2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KClassImpl$Data$supertypes$2 extends Lambda implements Function0<List<? extends KTypeImpl>> {
    final /* synthetic */ KClassImpl.Data this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$supertypes$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends KTypeImpl> invoke() {
        boolean z;
        TypeConstructor typeConstructor = this.this$0.n().getTypeConstructor();
        b41.h(typeConstructor, "descriptor.typeConstructor");
        Collection<z71> supertypes = typeConstructor.getSupertypes();
        b41.h(supertypes, "descriptor.typeConstructor.supertypes");
        ArrayList<KTypeImpl> arrayList = new ArrayList(supertypes.size());
        for (final z71 z71Var : supertypes) {
            b41.h(z71Var, "kotlinType");
            arrayList.add(new KTypeImpl(z71Var, new Function0<Type>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$supertypes$2$$special$$inlined$mapTo$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Type invoke() {
                    int B;
                    ClassifierDescriptor declarationDescriptor = z71.this.c().getDeclarationDescriptor();
                    if (declarationDescriptor instanceof ClassDescriptor) {
                        Class<?> p = zv2.p((ClassDescriptor) declarationDescriptor);
                        if (p != null) {
                            if (b41.d(KClassImpl.this.getJClass().getSuperclass(), p)) {
                                Type genericSuperclass = KClassImpl.this.getJClass().getGenericSuperclass();
                                b41.h(genericSuperclass, "jClass.genericSuperclass");
                                return genericSuperclass;
                            }
                            Class<?>[] interfaces = KClassImpl.this.getJClass().getInterfaces();
                            b41.h(interfaces, "jClass.interfaces");
                            B = ArraysKt___ArraysKt.B(interfaces, p);
                            if (B >= 0) {
                                Type type = KClassImpl.this.getJClass().getGenericInterfaces()[B];
                                b41.h(type, "jClass.genericInterfaces[index]");
                                return type;
                            }
                            throw new KotlinReflectionInternalError("No superclass of " + this.this$0 + " in Java reflection for " + declarationDescriptor);
                        }
                        throw new KotlinReflectionInternalError("Unsupported superclass of " + this.this$0 + ": " + declarationDescriptor);
                    }
                    throw new KotlinReflectionInternalError("Supertype not a class: " + declarationDescriptor);
                }
            }));
        }
        if (!b.s0(this.this$0.n())) {
            boolean z2 = false;
            if (!arrayList.isEmpty()) {
                for (KTypeImpl kTypeImpl : arrayList) {
                    ClassDescriptor e = d70.e(kTypeImpl.c());
                    b41.h(e, "DescriptorUtils.getClassDescriptorForType(it.type)");
                    ClassKind kind = e.getKind();
                    b41.h(kind, "DescriptorUtils.getClass…ptorForType(it.type).kind");
                    if (kind == ClassKind.INTERFACE || kind == ClassKind.ANNOTATION_CLASS) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        break;
                    }
                }
            }
            z2 = true;
            if (z2) {
                fd2 i = DescriptorUtilsKt.g(this.this$0.n()).i();
                b41.h(i, "descriptor.builtIns.anyType");
                arrayList.add(new KTypeImpl(i, new Function0<Type>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$supertypes$2.3
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Type invoke() {
                        return Object.class;
                    }
                }));
            }
        }
        return kk.c(arrayList);
    }
}
