package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
class v {
    private static final JsonReader.a a = JsonReader.a.a("nm", "mm", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MergePaths a(JsonReader jsonReader) throws IOException {
        String str = null;
        MergePaths.MergePathsMode mergePathsMode = null;
        boolean z = false;
        while (jsonReader.j()) {
            int s = jsonReader.s(a);
            if (s == 0) {
                str = jsonReader.o();
            } else if (s == 1) {
                mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.m());
            } else if (s != 2) {
                jsonReader.t();
                jsonReader.u();
            } else {
                z = jsonReader.k();
            }
        }
        return new MergePaths(str, mergePathsMode, z);
    }
}
