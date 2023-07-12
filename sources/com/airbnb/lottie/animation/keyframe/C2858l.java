package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.DocumentData;
import java.util.List;
import tb.u71;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.animation.keyframe.l */
/* loaded from: classes9.dex */
public class C2858l extends AbstractC2851e<DocumentData> {
    public C2858l(List<u71<DocumentData>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: p */
    public DocumentData i(u71<DocumentData> u71Var, float f) {
        DocumentData documentData;
        if (f == 1.0f && (documentData = u71Var.c) != null) {
            return documentData;
        }
        return u71Var.b;
    }
}
