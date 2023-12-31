package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.e0;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ni1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface DeclaredMemberIndex {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a implements DeclaredMemberIndex {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        @NotNull
        /* renamed from: a */
        public List<JavaMethod> findMethodsByName(@NotNull ni1 ni1Var) {
            List<JavaMethod> g;
            b41.i(ni1Var, "name");
            g = m.g();
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        @Nullable
        public JavaField findFieldByName(@NotNull ni1 ni1Var) {
            b41.i(ni1Var, "name");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        @Nullable
        public JavaRecordComponent findRecordComponentByName(@NotNull ni1 ni1Var) {
            b41.i(ni1Var, "name");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        @NotNull
        public Set<ni1> getFieldNames() {
            Set<ni1> d;
            d = e0.d();
            return d;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        @NotNull
        public Set<ni1> getMethodNames() {
            Set<ni1> d;
            d = e0.d();
            return d;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        @NotNull
        public Set<ni1> getRecordComponentNames() {
            Set<ni1> d;
            d = e0.d();
            return d;
        }
    }

    @Nullable
    JavaField findFieldByName(@NotNull ni1 ni1Var);

    @NotNull
    Collection<JavaMethod> findMethodsByName(@NotNull ni1 ni1Var);

    @Nullable
    JavaRecordComponent findRecordComponentByName(@NotNull ni1 ni1Var);

    @NotNull
    Set<ni1> getFieldNames();

    @NotNull
    Set<ni1> getMethodNames();

    @NotNull
    Set<ni1> getRecordComponentNames();
}
