package kotlin.reflect.jvm.internal.impl.resolve;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.collections.C8212k;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.wt2;
import tb.yd2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class OverridingUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <H> Collection<H> a(@NotNull Collection<? extends H> collection, @NotNull Function1<? super H, ? extends CallableDescriptor> function1) {
        b41.i(collection, "<this>");
        b41.i(function1, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        yd2 a = yd2.Companion.a();
        while (!linkedList.isEmpty()) {
            Object P = C8212k.P(linkedList);
            final yd2 a2 = yd2.Companion.a();
            Collection<? super H> q = OverridingUtil.q(P, linkedList, function1, new Function1<H, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(Object obj) {
                    invoke2((OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1<H>) obj);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(H h) {
                    yd2<H> yd2Var = a2;
                    b41.h(h, AdvanceSetting.NETWORK_TYPE);
                    yd2Var.add(h);
                }
            });
            b41.h(q, "val conflictedHandles = …nflictedHandles.add(it) }");
            if (q.size() == 1 && a2.isEmpty()) {
                Object p0 = C8212k.p0(q);
                b41.h(p0, "overridableGroup.single()");
                a.add(p0);
            } else {
                Object obj = (Object) OverridingUtil.M(q, function1);
                b41.h(obj, "selectMostSpecificMember…roup, descriptorByHandle)");
                CallableDescriptor invoke = function1.invoke(obj);
                for (Object obj2 : q) {
                    b41.h(obj2, AdvanceSetting.NETWORK_TYPE);
                    if (!OverridingUtil.C(invoke, function1.invoke(obj2))) {
                        a2.add(obj2);
                    }
                }
                if (!a2.isEmpty()) {
                    a.addAll(a2);
                }
                a.add(obj);
            }
        }
        return a;
    }
}
