package org.apache.commons.text.similarity;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface EditDistance<R> extends SimilarityScore<R> {
    @Override // org.apache.commons.text.similarity.SimilarityScore
    R apply(CharSequence charSequence, CharSequence charSequence2);
}
