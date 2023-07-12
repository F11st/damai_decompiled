package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.taobao.weex.ui.component.WXComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.w;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.j51;
import tb.ni1;
import tb.ty1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ClassDeclaredMemberIndex implements DeclaredMemberIndex {
    @NotNull
    private final JavaClass a;
    @NotNull
    private final Function1<JavaMember, Boolean> b;
    @NotNull
    private final Function1<JavaMethod, Boolean> c;
    @NotNull
    private final Map<ni1, List<JavaMethod>> d;
    @NotNull
    private final Map<ni1, JavaField> e;
    @NotNull
    private final Map<ni1, JavaRecordComponent> f;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassDeclaredMemberIndex(@NotNull JavaClass javaClass, @NotNull Function1<? super JavaMember, Boolean> function1) {
        Sequence I;
        Sequence o;
        Sequence I2;
        Sequence o2;
        int q;
        int e;
        int a;
        b41.i(javaClass, "jClass");
        b41.i(function1, "memberFilter");
        this.a = javaClass;
        this.b = function1;
        Function1<JavaMethod, Boolean> function12 = new Function1<JavaMethod, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex$methodFilter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull JavaMethod javaMethod) {
                Function1 function13;
                b41.i(javaMethod, WXComponent.PROP_FS_MATCH_PARENT);
                function13 = ClassDeclaredMemberIndex.this.b;
                return Boolean.valueOf(((Boolean) function13.invoke(javaMethod)).booleanValue() && !j51.c(javaMethod));
            }
        };
        this.c = function12;
        I = CollectionsKt___CollectionsKt.I(javaClass.getMethods());
        o = SequencesKt___SequencesKt.o(I, function12);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : o) {
            ni1 name = ((JavaMethod) obj).getName();
            Object obj2 = linkedHashMap.get(name);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(name, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.d = linkedHashMap;
        I2 = CollectionsKt___CollectionsKt.I(this.a.getFields());
        o2 = SequencesKt___SequencesKt.o(I2, this.b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj3 : o2) {
            linkedHashMap2.put(((JavaField) obj3).getName(), obj3);
        }
        this.e = linkedHashMap2;
        Collection<JavaRecordComponent> recordComponents = this.a.getRecordComponents();
        Function1<JavaMember, Boolean> function13 = this.b;
        ArrayList arrayList = new ArrayList();
        for (Object obj4 : recordComponents) {
            if (((Boolean) function13.invoke(obj4)).booleanValue()) {
                arrayList.add(obj4);
            }
        }
        q = n.q(arrayList, 10);
        e = w.e(q);
        a = ty1.a(e, 16);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(a);
        for (Object obj5 : arrayList) {
            linkedHashMap3.put(((JavaRecordComponent) obj5).getName(), obj5);
        }
        this.f = linkedHashMap3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @Nullable
    public JavaField findFieldByName(@NotNull ni1 ni1Var) {
        b41.i(ni1Var, "name");
        return this.e.get(ni1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @NotNull
    public Collection<JavaMethod> findMethodsByName(@NotNull ni1 ni1Var) {
        List g;
        b41.i(ni1Var, "name");
        List<JavaMethod> list = this.d.get(ni1Var);
        if (list == null) {
            g = m.g();
            return g;
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @Nullable
    public JavaRecordComponent findRecordComponentByName(@NotNull ni1 ni1Var) {
        b41.i(ni1Var, "name");
        return this.f.get(ni1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @NotNull
    public Set<ni1> getFieldNames() {
        Sequence I;
        Sequence<JavaField> o;
        I = CollectionsKt___CollectionsKt.I(this.a.getFields());
        o = SequencesKt___SequencesKt.o(I, this.b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaField javaField : o) {
            linkedHashSet.add(javaField.getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @NotNull
    public Set<ni1> getMethodNames() {
        Sequence I;
        Sequence<JavaMethod> o;
        I = CollectionsKt___CollectionsKt.I(this.a.getMethods());
        o = SequencesKt___SequencesKt.o(I, this.c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaMethod javaMethod : o) {
            linkedHashSet.add(javaMethod.getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @NotNull
    public Set<ni1> getRecordComponentNames() {
        return this.f.keySet();
    }
}
