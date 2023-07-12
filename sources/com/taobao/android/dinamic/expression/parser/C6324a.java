package com.taobao.android.dinamic.expression.parser;

import android.text.TextUtils;
import com.taobao.android.dinamic.exception.DinamicException;
import java.util.HashMap;
import java.util.Map;
import tb.af0;
import tb.b7;
import tb.d5;
import tb.f31;
import tb.fq2;
import tb.g31;
import tb.gq2;
import tb.h31;
import tb.hc0;
import tb.hh2;
import tb.ic0;
import tb.j31;
import tb.jc0;
import tb.k31;
import tb.kl1;
import tb.lc0;
import tb.ld1;
import tb.lh2;
import tb.m80;
import tb.mc0;
import tb.mn1;
import tb.n80;
import tb.oh2;
import tb.pj0;
import tb.qh2;
import tb.t80;
import tb.u80;
import tb.v0;
import tb.vd0;
import tb.xt0;
import tb.y81;
import tb.z80;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamic.expression.parser.a */
/* loaded from: classes12.dex */
public class C6324a {
    private static Map<String, v0> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("data", new t80());
        a.put(m80.CONSTANT_PREFIX, new n80());
        a.put(m80.SUBDATA_PREFIX, new z80());
        a.put(m80.APP_STYLE, new b7());
        a.put(m80.AND_PREFIX, new d5());
        a.put(m80.EQUAL_PREFIX, new af0());
        a.put("len", new y81());
        a.put(m80.NOT_PREFIX, new kl1());
        a.put(m80.ELSE_PREFIX, new vd0());
        a.put(m80.MATCH_PREFIX, new ld1());
        a.put(m80.LOWER_PREFIX, new lh2());
        a.put("uc", new qh2());
        a.put(m80.CONCAT_PREFIX, new hh2());
        a.put(m80.TRIPLE_PREFIX, new gq2());
        a.put(m80.SUBSTR_PREFIX, new oh2());
        a.put(m80.FIND_PREFIX, new pj0());
        a.put(m80.AGET_PREFIX, new xt0());
        a.put(m80.DGET_PREFIX, new xt0());
        a.put(m80.OR_PREFIX, new mn1());
        a.put(m80.TRIM_PREFIX, new fq2());
        a.put(m80.FLOAT_LITTER_PREFIX, new lc0());
        a.put(m80.FLOAT_LITTER_EQUAL_PREFIX, new mc0());
        a.put(m80.FLOAT_BIGGER_EQUAL_PREFIX, new jc0());
        a.put(m80.FLOAT_BIGGER_PREFIX, new ic0());
        a.put(m80.FLOAT_EQUAL, new hc0());
        a.put(m80.INT_BIGGER_EQUAL_PREFIX, new h31());
        a.put(m80.INT_BIGGER_PREFIX, new g31());
        a.put(m80.INT_LITTER_EQUAL_PREFIX, new k31());
        a.put(m80.INT_LITTER_PREFIX, new j31());
        a.put(m80.INT_EQUAL, new f31());
        a.put(m80.SIZE_BY_FACTOR, new C6325b());
        a.put(m80.IS_ELDER, new u80());
    }

    public static boolean a(String str) {
        return a.containsKey(str);
    }

    public static DinamicDataParser b(String str) {
        return a.get(str);
    }

    public static void c(String str, v0 v0Var) throws DinamicException {
        if (!TextUtils.isEmpty(str) && v0Var != null) {
            if (a.get(str) == null) {
                a.put(str, v0Var);
                return;
            }
            throw new DinamicException("registerParser failed, parser already register by current identify:" + str);
        }
        throw new DinamicException("prefix or parser is null");
    }
}
