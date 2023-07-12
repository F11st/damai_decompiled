package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.taobao.weex.ui.component.WXComponent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import tb.j5;
import tb.k5;
import tb.m5;
import tb.m80;
import tb.u71;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class h0 {
    private static JsonReader.a a = JsonReader.a.a("nm", com.huawei.hms.opendevice.c.a, WXComponent.PROP_FS_WRAP_CONTENT, "o", m80.LOWER_PREFIX, "lj", "ml", "hd", "d");
    private static final JsonReader.a b = JsonReader.a.a("n", "v");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static ShapeStroke a(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        char c;
        ArrayList arrayList = new ArrayList();
        String str = null;
        k5 k5Var = null;
        j5 j5Var = null;
        k5 k5Var2 = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f = 0.0f;
        boolean z = false;
        m5 m5Var = null;
        while (jsonReader.j()) {
            switch (jsonReader.s(a)) {
                case 0:
                    str = jsonReader.o();
                    break;
                case 1:
                    j5Var = d.c(jsonReader, aVar);
                    break;
                case 2:
                    k5Var2 = d.e(jsonReader, aVar);
                    break;
                case 3:
                    m5Var = d.h(jsonReader, aVar);
                    break;
                case 4:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.m() - 1];
                    break;
                case 5:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.m() - 1];
                    break;
                case 6:
                    f = (float) jsonReader.l();
                    break;
                case 7:
                    z = jsonReader.k();
                    break;
                case 8:
                    jsonReader.c();
                    while (jsonReader.j()) {
                        jsonReader.e();
                        String str2 = null;
                        k5 k5Var3 = null;
                        while (jsonReader.j()) {
                            int s = jsonReader.s(b);
                            if (s == 0) {
                                str2 = jsonReader.o();
                            } else if (s != 1) {
                                jsonReader.t();
                                jsonReader.u();
                            } else {
                                k5Var3 = d.e(jsonReader, aVar);
                            }
                        }
                        jsonReader.g();
                        str2.hashCode();
                        switch (str2.hashCode()) {
                            case 100:
                                if (str2.equals("d")) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 103:
                                if (str2.equals("g")) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 111:
                                if (str2.equals("o")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        switch (c) {
                            case 0:
                            case 1:
                                aVar.t(true);
                                arrayList.add(k5Var3);
                                break;
                            case 2:
                                k5Var = k5Var3;
                                break;
                        }
                    }
                    jsonReader.f();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                    break;
                default:
                    jsonReader.u();
                    break;
            }
        }
        if (m5Var == null) {
            m5Var = new m5(Collections.singletonList(new u71(100)));
        }
        return new ShapeStroke(str, k5Var, arrayList, j5Var, m5Var, k5Var2, lineCapType, lineJoinType, f, z);
    }
}
