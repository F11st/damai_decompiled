package org.apache.commons.text.similarity;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class RegexTokenizer implements Tokenizer<CharSequence> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.text.similarity.Tokenizer
    public CharSequence[] tokenize(CharSequence charSequence) {
        Validate.isTrue(StringUtils.isNotBlank(charSequence), "Invalid text", new Object[0]);
        Matcher matcher = Pattern.compile("(\\w)+").matcher(charSequence.toString());
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            arrayList.add(matcher.group(0));
        }
        return (CharSequence[]) arrayList.toArray(new String[0]);
    }
}
