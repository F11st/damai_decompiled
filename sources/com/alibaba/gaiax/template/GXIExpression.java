package com.alibaba.gaiax.template;

import com.alibaba.fastjson.JSON;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0001H&J\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/template/GXIExpression;", "", DXTraceUtil.TYPE_EXPRESSION_STRING, "Lcom/alibaba/fastjson/JSON;", "templateData", "value", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public interface GXIExpression {

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.template.GXIExpression$a */
    /* loaded from: classes6.dex */
    public static final class C3398a {
        public static /* synthetic */ Object a(GXIExpression gXIExpression, JSON json, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    json = null;
                }
                return gXIExpression.value(json);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: value");
        }
    }

    @NotNull
    Object expression();

    @Nullable
    Object value(@Nullable JSON json);
}
