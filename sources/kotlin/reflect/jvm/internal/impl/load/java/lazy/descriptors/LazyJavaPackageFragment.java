package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.hj;
import tb.hp0;
import tb.hq2;
import tb.jp1;
import tb.q81;
import tb.r81;
import tb.t61;
import tb.tg2;
import tb.w71;
import tb.x71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class LazyJavaPackageFragment extends jp1 {
    static final /* synthetic */ KProperty<Object>[] n = {a12.i(new PropertyReference1Impl(a12.b(LazyJavaPackageFragment.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), a12.i(new PropertyReference1Impl(a12.b(LazyJavaPackageFragment.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    @NotNull
    private final JavaPackage g;
    @NotNull
    private final r81 h;
    @NotNull
    private final NotNullLazyValue i;
    @NotNull
    private final JvmPackageScope j;
    @NotNull
    private final NotNullLazyValue<List<hp0>> k;
    @NotNull
    private final Annotations l;
    @NotNull
    private final NotNullLazyValue m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment(@NotNull r81 r81Var, @NotNull JavaPackage javaPackage) {
        super(r81Var.d(), javaPackage.getFqName());
        List g;
        b41.i(r81Var, "outerContext");
        b41.i(javaPackage, "jPackage");
        this.g = javaPackage;
        r81 d = ContextKt.d(r81Var, this, null, 0, 6, null);
        this.h = d;
        this.i = d.e().createLazyValue(new Function0<Map<String, ? extends KotlinJvmBinaryClass>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$binaryClasses$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, ? extends KotlinJvmBinaryClass> invoke() {
                r81 r81Var2;
                Map<String, ? extends KotlinJvmBinaryClass> r;
                r81 r81Var3;
                r81Var2 = LazyJavaPackageFragment.this.h;
                PackagePartProvider o = r81Var2.a().o();
                String b = LazyJavaPackageFragment.this.getFqName().b();
                b41.h(b, "fqName.asString()");
                List<String> findPackageParts = o.findPackageParts(b);
                LazyJavaPackageFragment lazyJavaPackageFragment = LazyJavaPackageFragment.this;
                ArrayList arrayList = new ArrayList();
                for (String str : findPackageParts) {
                    hj m = hj.m(t61.d(str).e());
                    b41.h(m, "topLevel(JvmClassName.by…velClassMaybeWithDollars)");
                    r81Var3 = lazyJavaPackageFragment.h;
                    KotlinJvmBinaryClass b2 = w71.b(r81Var3.a().j(), m);
                    Pair a = b2 == null ? null : hq2.a(str, b2);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                r = x.r(arrayList);
                return r;
            }
        });
        this.j = new JvmPackageScope(d, javaPackage, this);
        StorageManager e = d.e();
        Function0<List<? extends hp0>> function0 = new Function0<List<? extends hp0>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$subPackages$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends hp0> invoke() {
                JavaPackage javaPackage2;
                int q;
                javaPackage2 = LazyJavaPackageFragment.this.g;
                Collection<JavaPackage> subPackages = javaPackage2.getSubPackages();
                q = n.q(subPackages, 10);
                ArrayList arrayList = new ArrayList(q);
                for (JavaPackage javaPackage3 : subPackages) {
                    arrayList.add(javaPackage3.getFqName());
                }
                return arrayList;
            }
        };
        g = m.g();
        this.k = e.createRecursionTolerantLazyValue(function0, g);
        this.l = d.a().i().b() ? Annotations.Companion.b() : q81.a(d, javaPackage);
        this.m = d.e().createLazyValue(new Function0<HashMap<t61, t61>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$partToFacade$2

            /* compiled from: Taobao */
            /* loaded from: classes3.dex */
            public /* synthetic */ class a {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[KotlinClassHeader.Kind.values().length];
                    iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 1;
                    iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 2;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<t61, t61> invoke() {
                HashMap<t61, t61> hashMap = new HashMap<>();
                for (Map.Entry<String, KotlinJvmBinaryClass> entry : LazyJavaPackageFragment.this.g().entrySet()) {
                    t61 d2 = t61.d(entry.getKey());
                    b41.h(d2, "byInternalName(partInternalName)");
                    KotlinClassHeader classHeader = entry.getValue().getClassHeader();
                    int i = a.$EnumSwitchMapping$0[classHeader.c().ordinal()];
                    if (i == 1) {
                        String e2 = classHeader.e();
                        if (e2 != null) {
                            t61 d3 = t61.d(e2);
                            b41.h(d3, "byInternalName(header.mu…: continue@kotlinClasses)");
                            hashMap.put(d2, d3);
                        }
                    } else if (i == 2) {
                        hashMap.put(d2, d2);
                    }
                }
                return hashMap;
            }
        });
    }

    @Nullable
    public final ClassDescriptor f(@NotNull JavaClass javaClass) {
        b41.i(javaClass, "jClass");
        return this.j.c().H(javaClass);
    }

    @NotNull
    public final Map<String, KotlinJvmBinaryClass> g() {
        return (Map) tg2.a(this.i, this, n[0]);
    }

    @Override // tb.y5, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return this.l;
    }

    @Override // tb.jp1, tb.u40, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    @NotNull
    public SourceElement getSource() {
        return new x71(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    @NotNull
    /* renamed from: h */
    public JvmPackageScope getMemberScope() {
        return this.j;
    }

    @NotNull
    public final List<hp0> i() {
        return this.k.invoke();
    }

    @Override // tb.jp1, tb.t40
    @NotNull
    public String toString() {
        return "Lazy Java package fragment: " + getFqName() + " of module " + this.h.a().m();
    }
}
