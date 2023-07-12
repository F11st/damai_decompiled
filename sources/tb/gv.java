package tb;

import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class gv extends com.taobao.android.dinamicx.expression.parser.a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_PARSER_DMADAPTIVEHEIGHT = -1525552786972270296L;

    private int a(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "858466887")) {
            return ((Integer) ipChange.ipc$dispatch("858466887", new Object[]{this, context, str})).intValue();
        }
        try {
        } catch (Exception e) {
            cb1.b("DXDataParserDMAdaptiveHeight", e.getMessage());
        }
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.endsWith("ap")) {
            return z00.b(context, Integer.parseInt(str.replace("ap", "")));
        }
        if (str.endsWith(d90.DIMEN_SUFFIX_NP)) {
            return z00.c(context, Integer.parseInt(str.replace(d90.DIMEN_SUFFIX_NP, "")));
        }
        return 0;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1369700938")) {
            return ipChange.ipc$dispatch("1369700938", new Object[]{this, objArr, dXRuntimeContext});
        }
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[0];
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return obj;
            }
            int a = a(dXRuntimeContext.getContext(), str);
            cb1.b("DXDataParserDMAdaptiveHeight", "realHeight = " + a + d90.DIMEN_SUFFIX_NP);
            int c = t60.c(dXRuntimeContext.getContext(), a);
            cb1.b("DXDataParserDMAdaptiveHeight", "adaptiveHeightPx = " + c + "px");
            int e = t60.e(dXRuntimeContext.getContext(), (float) c);
            cb1.b("DXDataParserDMAdaptiveHeight", "adaptiveHeightNp = " + e + d90.DIMEN_SUFFIX_NP);
            return e + d90.DIMEN_SUFFIX_NP;
        }
        return obj;
    }
}
