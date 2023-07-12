package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.C2821a;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.sdk.m.s.C4293a;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.taobao.weex.ui.component.WXComponent;
import io.flutter.wpkbridge.U4WPKAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import tb.aw2;
import tb.k5;
import tb.s5;
import tb.t5;
import tb.u5;
import tb.u71;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.parser.s */
/* loaded from: classes17.dex */
public class C2929s {
    private static final JsonReader.C2911a a = JsonReader.C2911a.a("nm", "ind", "refId", C4293a.s, "parent", "sw", "sh", IRequestConst.SC, "ks", PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, "masksProperties", "shapes", "t", "ef", "sr", "st", WXComponent.PROP_FS_WRAP_CONTENT, "h", TbAuthConstants.IP, "op", U4WPKAdapter.KEY_TM, "cl", "hd");
    private static final JsonReader.C2911a b = JsonReader.C2911a.a("d", "a");
    private static final JsonReader.C2911a c = JsonReader.C2911a.a("nm");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.parser.s$a */
    /* loaded from: classes17.dex */
    public static /* synthetic */ class C2930a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            a = iArr;
            try {
                iArr[Layer.MatteType.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Layer a(C2821a c2821a) {
        Rect b2 = c2821a.b();
        return new Layer(Collections.emptyList(), c2821a, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new u5(), 0, 0, 0, 0.0f, 0.0f, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(b2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(b2), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false);
    }

    public static Layer b(JsonReader jsonReader, C2821a c2821a) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.e();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        Layer.LayerType layerType = null;
        String str = null;
        u5 u5Var = null;
        s5 s5Var = null;
        t5 t5Var = null;
        k5 k5Var = null;
        long j = -1;
        float f = 0.0f;
        float f2 = 0.0f;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        float f3 = 1.0f;
        float f4 = 0.0f;
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        long j2 = 0;
        String str2 = null;
        String str3 = "UNSET";
        while (jsonReader.j()) {
            switch (jsonReader.s(a)) {
                case 0:
                    str3 = jsonReader.o();
                    break;
                case 1:
                    j2 = jsonReader.m();
                    break;
                case 2:
                    str = jsonReader.o();
                    break;
                case 3:
                    int m = jsonReader.m();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (m >= layerType.ordinal()) {
                        break;
                    } else {
                        layerType = Layer.LayerType.values()[m];
                        break;
                    }
                case 4:
                    j = jsonReader.m();
                    break;
                case 5:
                    i = (int) (jsonReader.m() * aw2.e());
                    break;
                case 6:
                    i2 = (int) (jsonReader.m() * aw2.e());
                    break;
                case 7:
                    i3 = Color.parseColor(jsonReader.o());
                    break;
                case 8:
                    u5Var = C2893c.g(jsonReader, c2821a);
                    break;
                case 9:
                    int m2 = jsonReader.m();
                    if (m2 >= Layer.MatteType.values().length) {
                        c2821a.a("Unsupported matte type: " + m2);
                        break;
                    } else {
                        matteType2 = Layer.MatteType.values()[m2];
                        int i6 = C2930a.a[matteType2.ordinal()];
                        if (i6 == 1) {
                            c2821a.a("Unsupported matte type: Luma");
                        } else if (i6 == 2) {
                            c2821a.a("Unsupported matte type: Luma Inverted");
                        }
                        c2821a.q(1);
                        break;
                    }
                case 10:
                    jsonReader.c();
                    while (jsonReader.j()) {
                        arrayList3.add(C2932u.a(jsonReader, c2821a));
                    }
                    c2821a.q(arrayList3.size());
                    jsonReader.f();
                    break;
                case 11:
                    jsonReader.c();
                    while (jsonReader.j()) {
                        ContentModel a2 = C2901g.a(jsonReader, c2821a);
                        if (a2 != null) {
                            arrayList4.add(a2);
                        }
                    }
                    jsonReader.f();
                    break;
                case 12:
                    jsonReader.e();
                    while (jsonReader.j()) {
                        int s = jsonReader.s(b);
                        if (s == 0) {
                            s5Var = C2895d.d(jsonReader, c2821a);
                        } else if (s != 1) {
                            jsonReader.t();
                            jsonReader.u();
                        } else {
                            jsonReader.c();
                            if (jsonReader.j()) {
                                t5Var = C2891b.a(jsonReader, c2821a);
                            }
                            while (jsonReader.j()) {
                                jsonReader.u();
                            }
                            jsonReader.f();
                        }
                    }
                    jsonReader.g();
                    break;
                case 13:
                    jsonReader.c();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.j()) {
                        jsonReader.e();
                        while (jsonReader.j()) {
                            if (jsonReader.s(c) != 0) {
                                jsonReader.t();
                                jsonReader.u();
                            } else {
                                arrayList5.add(jsonReader.o());
                            }
                        }
                        jsonReader.g();
                    }
                    jsonReader.f();
                    c2821a.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f3 = (float) jsonReader.l();
                    break;
                case 15:
                    f4 = (float) jsonReader.l();
                    break;
                case 16:
                    i4 = (int) (jsonReader.m() * aw2.e());
                    break;
                case 17:
                    i5 = (int) (jsonReader.m() * aw2.e());
                    break;
                case 18:
                    f = (float) jsonReader.l();
                    break;
                case 19:
                    f2 = (float) jsonReader.l();
                    break;
                case 20:
                    k5Var = C2895d.f(jsonReader, c2821a, false);
                    break;
                case 21:
                    str2 = jsonReader.o();
                    break;
                case 22:
                    z = jsonReader.k();
                    break;
                default:
                    jsonReader.t();
                    jsonReader.u();
                    break;
            }
        }
        jsonReader.g();
        float f5 = f / f3;
        float f6 = f2 / f3;
        ArrayList arrayList6 = new ArrayList();
        if (f5 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new u71(c2821a, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f5)));
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f6 <= 0.0f) {
            f6 = c2821a.f();
        }
        arrayList2.add(new u71(c2821a, valueOf, valueOf, null, f5, Float.valueOf(f6)));
        arrayList2.add(new u71(c2821a, valueOf2, valueOf2, null, f6, Float.valueOf(Float.MAX_VALUE)));
        if (str3.endsWith(".ai") || BQCCameraParam.FOCUS_TYPE_AI.equals(str2)) {
            c2821a.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, c2821a, str3, j2, layerType, j, str, arrayList, u5Var, i, i2, i3, f3, f4, i4, i5, s5Var, t5Var, arrayList2, matteType2, k5Var, z);
    }
}
