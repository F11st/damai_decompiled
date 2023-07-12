package org.apache.commons.text.similarity;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CosineDistance implements EditDistance<Double> {
    private final Tokenizer<CharSequence> tokenizer = new RegexTokenizer();
    private final CosineSimilarity cosineSimilarity = new CosineSimilarity();

    @Override // org.apache.commons.text.similarity.EditDistance, org.apache.commons.text.similarity.SimilarityScore
    public Double apply(CharSequence charSequence, CharSequence charSequence2) {
        return Double.valueOf(1.0d - this.cosineSimilarity.cosineSimilarity(Counter.of(this.tokenizer.tokenize(charSequence)), Counter.of(this.tokenizer.tokenize(charSequence2))).doubleValue());
    }
}
