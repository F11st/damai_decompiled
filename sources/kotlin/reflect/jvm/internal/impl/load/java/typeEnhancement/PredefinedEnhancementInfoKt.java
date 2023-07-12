package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.eu1;
import tb.gn1;
import tb.kh1;
import tb.s51;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class PredefinedEnhancementInfoKt {
    @NotNull
    private static final s51 a = new s51(NullabilityQualifier.NULLABLE, null, false, false, 8, null);
    @NotNull
    private static final s51 b;
    @NotNull
    private static final s51 c;
    @NotNull
    private static final Map<String, eu1> d;

    static {
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        b = new s51(nullabilityQualifier, null, false, false, 8, null);
        c = new s51(nullabilityQualifier, null, true, false, 8, null);
        final SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        final String h = signatureBuildingComponents.h("Object");
        final String g = signatureBuildingComponents.g("Predicate");
        final String g2 = signatureBuildingComponents.g("Function");
        final String g3 = signatureBuildingComponents.g("Consumer");
        final String g4 = signatureBuildingComponents.g("BiFunction");
        final String g5 = signatureBuildingComponents.g("BiConsumer");
        final String g6 = signatureBuildingComponents.g("UnaryOperator");
        final String i = signatureBuildingComponents.i("stream/Stream");
        final String i2 = signatureBuildingComponents.i("Optional");
        a aVar = new a();
        new a.C0418a(aVar, signatureBuildingComponents.i("Iterator")).a("forEachRemaining", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                b41.i(c0419a, "$this$function");
                String str = g3;
                s51Var = PredefinedEnhancementInfoKt.b;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                c0419a.c(str, s51Var, s51Var2);
            }
        });
        new a.C0418a(aVar, signatureBuildingComponents.h("Iterable")).a("spliterator", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                b41.i(c0419a, "$this$function");
                String i3 = SignatureBuildingComponents.this.i("Spliterator");
                s51Var = PredefinedEnhancementInfoKt.b;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                c0419a.d(i3, s51Var, s51Var2);
            }
        });
        a.C0418a c0418a = new a.C0418a(aVar, signatureBuildingComponents.i("Collection"));
        c0418a.a("removeIf", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                b41.i(c0419a, "$this$function");
                String str = g;
                s51Var = PredefinedEnhancementInfoKt.b;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                c0419a.c(str, s51Var, s51Var2);
                c0419a.e(JvmPrimitiveType.BOOLEAN);
            }
        });
        c0418a.a(kh1.RESOURCE_STREAM, new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                b41.i(c0419a, "$this$function");
                String str = i;
                s51Var = PredefinedEnhancementInfoKt.b;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                c0419a.d(str, s51Var, s51Var2);
            }
        });
        c0418a.a("parallelStream", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                b41.i(c0419a, "$this$function");
                String str = i;
                s51Var = PredefinedEnhancementInfoKt.b;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                c0419a.d(str, s51Var, s51Var2);
            }
        });
        new a.C0418a(aVar, signatureBuildingComponents.i("List")).a("replaceAll", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                b41.i(c0419a, "$this$function");
                String str = g6;
                s51Var = PredefinedEnhancementInfoKt.b;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                c0419a.c(str, s51Var, s51Var2);
            }
        });
        a.C0418a c0418a2 = new a.C0418a(aVar, signatureBuildingComponents.i("Map"));
        c0418a2.a("forEach", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                s51 s51Var3;
                b41.i(c0419a, "$this$function");
                String str = g5;
                s51Var = PredefinedEnhancementInfoKt.b;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                s51Var3 = PredefinedEnhancementInfoKt.b;
                c0419a.c(str, s51Var, s51Var2, s51Var3);
            }
        });
        c0418a2.a("putIfAbsent", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                s51 s51Var3;
                b41.i(c0419a, "$this$function");
                String str = h;
                s51Var = PredefinedEnhancementInfoKt.b;
                c0419a.c(str, s51Var);
                String str2 = h;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                c0419a.c(str2, s51Var2);
                String str3 = h;
                s51Var3 = PredefinedEnhancementInfoKt.a;
                c0419a.d(str3, s51Var3);
            }
        });
        c0418a2.a("replace", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                s51 s51Var3;
                b41.i(c0419a, "$this$function");
                String str = h;
                s51Var = PredefinedEnhancementInfoKt.b;
                c0419a.c(str, s51Var);
                String str2 = h;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                c0419a.c(str2, s51Var2);
                String str3 = h;
                s51Var3 = PredefinedEnhancementInfoKt.a;
                c0419a.d(str3, s51Var3);
            }
        });
        c0418a2.a("replace", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                s51 s51Var3;
                b41.i(c0419a, "$this$function");
                String str = h;
                s51Var = PredefinedEnhancementInfoKt.b;
                c0419a.c(str, s51Var);
                String str2 = h;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                c0419a.c(str2, s51Var2);
                String str3 = h;
                s51Var3 = PredefinedEnhancementInfoKt.b;
                c0419a.c(str3, s51Var3);
                c0419a.e(JvmPrimitiveType.BOOLEAN);
            }
        });
        c0418a2.a("replaceAll", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                s51 s51Var3;
                s51 s51Var4;
                b41.i(c0419a, "$this$function");
                String str = g4;
                s51Var = PredefinedEnhancementInfoKt.b;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                s51Var3 = PredefinedEnhancementInfoKt.b;
                s51Var4 = PredefinedEnhancementInfoKt.b;
                c0419a.c(str, s51Var, s51Var2, s51Var3, s51Var4);
            }
        });
        c0418a2.a("compute", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$6
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                s51 s51Var3;
                s51 s51Var4;
                s51 s51Var5;
                s51 s51Var6;
                b41.i(c0419a, "$this$function");
                String str = h;
                s51Var = PredefinedEnhancementInfoKt.b;
                c0419a.c(str, s51Var);
                String str2 = g4;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                s51Var3 = PredefinedEnhancementInfoKt.b;
                s51Var4 = PredefinedEnhancementInfoKt.a;
                s51Var5 = PredefinedEnhancementInfoKt.a;
                c0419a.c(str2, s51Var2, s51Var3, s51Var4, s51Var5);
                String str3 = h;
                s51Var6 = PredefinedEnhancementInfoKt.a;
                c0419a.d(str3, s51Var6);
            }
        });
        c0418a2.a("computeIfAbsent", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$7
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                s51 s51Var3;
                s51 s51Var4;
                s51 s51Var5;
                b41.i(c0419a, "$this$function");
                String str = h;
                s51Var = PredefinedEnhancementInfoKt.b;
                c0419a.c(str, s51Var);
                String str2 = g2;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                s51Var3 = PredefinedEnhancementInfoKt.b;
                s51Var4 = PredefinedEnhancementInfoKt.b;
                c0419a.c(str2, s51Var2, s51Var3, s51Var4);
                String str3 = h;
                s51Var5 = PredefinedEnhancementInfoKt.b;
                c0419a.d(str3, s51Var5);
            }
        });
        c0418a2.a("computeIfPresent", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$8
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                s51 s51Var3;
                s51 s51Var4;
                s51 s51Var5;
                s51 s51Var6;
                b41.i(c0419a, "$this$function");
                String str = h;
                s51Var = PredefinedEnhancementInfoKt.b;
                c0419a.c(str, s51Var);
                String str2 = g4;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                s51Var3 = PredefinedEnhancementInfoKt.b;
                s51Var4 = PredefinedEnhancementInfoKt.c;
                s51Var5 = PredefinedEnhancementInfoKt.a;
                c0419a.c(str2, s51Var2, s51Var3, s51Var4, s51Var5);
                String str3 = h;
                s51Var6 = PredefinedEnhancementInfoKt.a;
                c0419a.d(str3, s51Var6);
            }
        });
        c0418a2.a("merge", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$9
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                s51 s51Var3;
                s51 s51Var4;
                s51 s51Var5;
                s51 s51Var6;
                s51 s51Var7;
                b41.i(c0419a, "$this$function");
                String str = h;
                s51Var = PredefinedEnhancementInfoKt.b;
                c0419a.c(str, s51Var);
                String str2 = h;
                s51Var2 = PredefinedEnhancementInfoKt.c;
                c0419a.c(str2, s51Var2);
                String str3 = g4;
                s51Var3 = PredefinedEnhancementInfoKt.b;
                s51Var4 = PredefinedEnhancementInfoKt.c;
                s51Var5 = PredefinedEnhancementInfoKt.c;
                s51Var6 = PredefinedEnhancementInfoKt.a;
                c0419a.c(str3, s51Var3, s51Var4, s51Var5, s51Var6);
                String str4 = h;
                s51Var7 = PredefinedEnhancementInfoKt.a;
                c0419a.d(str4, s51Var7);
            }
        });
        a.C0418a c0418a3 = new a.C0418a(aVar, i2);
        c0418a3.a(DXRecyclerLayout.LOAD_MORE_EMPTY, new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                b41.i(c0419a, "$this$function");
                String str = i2;
                s51Var = PredefinedEnhancementInfoKt.b;
                s51Var2 = PredefinedEnhancementInfoKt.c;
                c0419a.d(str, s51Var, s51Var2);
            }
        });
        c0418a3.a("of", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                s51 s51Var3;
                b41.i(c0419a, "$this$function");
                String str = h;
                s51Var = PredefinedEnhancementInfoKt.c;
                c0419a.c(str, s51Var);
                String str2 = i2;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                s51Var3 = PredefinedEnhancementInfoKt.c;
                c0419a.d(str2, s51Var2, s51Var3);
            }
        });
        c0418a3.a("ofNullable", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                s51 s51Var3;
                b41.i(c0419a, "$this$function");
                String str = h;
                s51Var = PredefinedEnhancementInfoKt.a;
                c0419a.c(str, s51Var);
                String str2 = i2;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                s51Var3 = PredefinedEnhancementInfoKt.c;
                c0419a.d(str2, s51Var2, s51Var3);
            }
        });
        c0418a3.a(gn1.TYPE_OPEN_URL_METHOD_GET, new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                b41.i(c0419a, "$this$function");
                String str = h;
                s51Var = PredefinedEnhancementInfoKt.c;
                c0419a.d(str, s51Var);
            }
        });
        c0418a3.a("ifPresent", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                b41.i(c0419a, "$this$function");
                String str = g3;
                s51Var = PredefinedEnhancementInfoKt.b;
                s51Var2 = PredefinedEnhancementInfoKt.c;
                c0419a.c(str, s51Var, s51Var2);
            }
        });
        new a.C0418a(aVar, signatureBuildingComponents.h("ref/Reference")).a(gn1.TYPE_OPEN_URL_METHOD_GET, new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$7$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                b41.i(c0419a, "$this$function");
                String str = h;
                s51Var = PredefinedEnhancementInfoKt.a;
                c0419a.d(str, s51Var);
            }
        });
        new a.C0418a(aVar, g).a("test", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$8$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                b41.i(c0419a, "$this$function");
                String str = h;
                s51Var = PredefinedEnhancementInfoKt.b;
                c0419a.c(str, s51Var);
                c0419a.e(JvmPrimitiveType.BOOLEAN);
            }
        });
        new a.C0418a(aVar, signatureBuildingComponents.g("BiPredicate")).a("test", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$9$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                b41.i(c0419a, "$this$function");
                String str = h;
                s51Var = PredefinedEnhancementInfoKt.b;
                c0419a.c(str, s51Var);
                String str2 = h;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                c0419a.c(str2, s51Var2);
                c0419a.e(JvmPrimitiveType.BOOLEAN);
            }
        });
        new a.C0418a(aVar, g3).a("accept", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$10$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                b41.i(c0419a, "$this$function");
                String str = h;
                s51Var = PredefinedEnhancementInfoKt.b;
                c0419a.c(str, s51Var);
            }
        });
        new a.C0418a(aVar, g5).a("accept", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$11$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                b41.i(c0419a, "$this$function");
                String str = h;
                s51Var = PredefinedEnhancementInfoKt.b;
                c0419a.c(str, s51Var);
                String str2 = h;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                c0419a.c(str2, s51Var2);
            }
        });
        new a.C0418a(aVar, g2).a("apply", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$12$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                b41.i(c0419a, "$this$function");
                String str = h;
                s51Var = PredefinedEnhancementInfoKt.b;
                c0419a.c(str, s51Var);
                String str2 = h;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                c0419a.d(str2, s51Var2);
            }
        });
        new a.C0418a(aVar, g4).a("apply", new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$13$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                s51 s51Var2;
                s51 s51Var3;
                b41.i(c0419a, "$this$function");
                String str = h;
                s51Var = PredefinedEnhancementInfoKt.b;
                c0419a.c(str, s51Var);
                String str2 = h;
                s51Var2 = PredefinedEnhancementInfoKt.b;
                c0419a.c(str2, s51Var2);
                String str3 = h;
                s51Var3 = PredefinedEnhancementInfoKt.b;
                c0419a.d(str3, s51Var3);
            }
        });
        new a.C0418a(aVar, signatureBuildingComponents.g("Supplier")).a(gn1.TYPE_OPEN_URL_METHOD_GET, new Function1<a.C0418a.C0419a, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$14$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(a.C0418a.C0419a c0419a) {
                invoke2(c0419a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C0418a.C0419a c0419a) {
                s51 s51Var;
                b41.i(c0419a, "$this$function");
                String str = h;
                s51Var = PredefinedEnhancementInfoKt.b;
                c0419a.d(str, s51Var);
            }
        });
        d = aVar.b();
    }

    @NotNull
    public static final Map<String, eu1> d() {
        return d;
    }
}
