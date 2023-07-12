package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.h;
import tb.kb1;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class MergePaths implements ContentModel {
    private final String a;
    private final MergePathsMode b;
    private final boolean c;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode forId(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return MERGE;
                            }
                            return EXCLUDE_INTERSECTIONS;
                        }
                        return INTERSECT;
                    }
                    return SUBTRACT;
                }
                return ADD;
            }
            return MERGE;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z) {
        this.a = str;
        this.b = mergePathsMode;
        this.c = z;
    }

    public MergePathsMode a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public boolean c() {
        return this.c;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar) {
        if (!lottieDrawable.enableMergePathsForKitKatAndAbove()) {
            kb1.c("Animation contains merge paths but they are disabled.");
            return null;
        }
        return new h(this);
    }

    public String toString() {
        return "MergePaths{mode=" + this.b + '}';
    }
}
