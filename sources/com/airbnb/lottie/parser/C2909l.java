package com.airbnb.lottie.parser;

import android.graphics.Color;
import androidx.annotation.IntRange;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import tb.eg1;
import tb.qu0;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.parser.l */
/* loaded from: classes9.dex */
public class C2909l implements ValueParser<qu0> {
    private int a;

    public C2909l(int i) {
        this.a = i;
    }

    private void a(qu0 qu0Var, List<Float> list) {
        int i = this.a * 4;
        if (list.size() <= i) {
            return;
        }
        int size = (list.size() - i) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i2 = 0;
        while (i < list.size()) {
            if (i % 2 == 0) {
                dArr[i2] = list.get(i).floatValue();
            } else {
                dArr2[i2] = list.get(i).floatValue();
                i2++;
            }
            i++;
        }
        for (int i3 = 0; i3 < qu0Var.c(); i3++) {
            int i4 = qu0Var.a()[i3];
            qu0Var.a()[i3] = Color.argb(b(qu0Var.b()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
        }
    }

    @IntRange(from = 0, to = 255)
    private int b(double d, double[] dArr, double[] dArr2) {
        double d2;
        int i = 1;
        while (true) {
            if (i < dArr.length) {
                int i2 = i - 1;
                double d3 = dArr[i2];
                double d4 = dArr[i];
                if (dArr[i] >= d) {
                    d2 = eg1.j(dArr2[i2], dArr2[i], eg1.b((d - d3) / (d4 - d3), 0.0d, 1.0d));
                    break;
                }
                i++;
            } else {
                d2 = dArr2[dArr2.length - 1];
                break;
            }
        }
        return (int) (d2 * 255.0d);
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: c */
    public qu0 parse(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.q() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.c();
        }
        while (jsonReader.j()) {
            arrayList.add(Float.valueOf((float) jsonReader.l()));
        }
        if (z) {
            jsonReader.f();
        }
        if (this.a == -1) {
            this.a = arrayList.size() / 4;
        }
        int i = this.a;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.a * 4; i4++) {
            int i5 = i4 / 4;
            double floatValue = arrayList.get(i4).floatValue();
            int i6 = i4 % 4;
            if (i6 == 0) {
                if (i5 > 0) {
                    float f2 = (float) floatValue;
                    if (fArr[i5 - 1] >= f2) {
                        fArr[i5] = f2 + 0.01f;
                    }
                }
                fArr[i5] = (float) floatValue;
            } else if (i6 == 1) {
                i2 = (int) (floatValue * 255.0d);
            } else if (i6 == 2) {
                i3 = (int) (floatValue * 255.0d);
            } else if (i6 == 3) {
                iArr[i5] = Color.argb(255, i2, i3, (int) (floatValue * 255.0d));
            }
        }
        qu0 qu0Var = new qu0(fArr, iArr);
        a(qu0Var, arrayList);
        return qu0Var;
    }
}
