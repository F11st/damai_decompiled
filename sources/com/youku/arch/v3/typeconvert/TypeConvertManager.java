package com.youku.arch.v3.typeconvert;

import android.util.SparseArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.Node;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004J\"\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006R,\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/youku/arch/v3/typeconvert/TypeConvertManager;", "", "", "type", "Lcom/youku/arch/v3/typeconvert/ITypeConvertRule;", "Lcom/youku/arch/v3/core/Node;", "Lcom/alibaba/fastjson/JSONObject;", "typeConvertRule", "Ltb/wt2;", "addTypeConvert", "node", "jsonObject", "convertType", "Landroid/util/SparseArray;", "sparseArray", "Landroid/util/SparseArray;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TypeConvertManager {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final TypeConvertManager INSTANCE = new TypeConvertManager();
    @NotNull
    private static SparseArray<ITypeConvertRule<Node, JSONObject>> sparseArray = new SparseArray<>();

    private TypeConvertManager() {
    }

    public final void addTypeConvert(int i, @NotNull ITypeConvertRule<Node, JSONObject> iTypeConvertRule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "323122959")) {
            ipChange.ipc$dispatch("323122959", new Object[]{this, Integer.valueOf(i), iTypeConvertRule});
            return;
        }
        b41.i(iTypeConvertRule, "typeConvertRule");
        sparseArray.put(i, iTypeConvertRule);
    }

    public final int convertType(int i, @Nullable Node node, @Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-959970727")) {
            return ((Integer) ipChange.ipc$dispatch("-959970727", new Object[]{this, Integer.valueOf(i), node, jSONObject})).intValue();
        }
        if (sparseArray.get(i) != null) {
            ITypeConvertRule<Node, JSONObject> iTypeConvertRule = sparseArray.get(i);
            b41.f(iTypeConvertRule);
            if (iTypeConvertRule.isConvert(node, jSONObject)) {
                ITypeConvertRule<Node, JSONObject> iTypeConvertRule2 = sparseArray.get(i);
                b41.f(iTypeConvertRule2);
                return iTypeConvertRule2.convertType(node, jSONObject);
            }
            return i;
        }
        return i;
    }
}
