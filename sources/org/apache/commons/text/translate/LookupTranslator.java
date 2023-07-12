package org.apache.commons.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LookupTranslator extends CharSequenceTranslator {
    private final int longest;
    private final Map<String, String> lookupMap;
    private final HashSet<Character> prefixSet;
    private final int shortest;

    public LookupTranslator(Map<CharSequence, CharSequence> map) {
        if (map != null) {
            this.lookupMap = new HashMap();
            this.prefixSet = new HashSet<>();
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            for (Map.Entry<CharSequence, CharSequence> entry : map.entrySet()) {
                this.lookupMap.put(entry.getKey().toString(), entry.getValue().toString());
                this.prefixSet.add(Character.valueOf(entry.getKey().charAt(0)));
                int length = entry.getKey().length();
                i = length < i ? length : i;
                if (length > i2) {
                    i2 = length;
                }
            }
            this.shortest = i;
            this.longest = i2;
            return;
        }
        throw new InvalidParameterException("lookupMap cannot be null");
    }

    @Override // org.apache.commons.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
        if (this.prefixSet.contains(Character.valueOf(charSequence.charAt(i)))) {
            int i2 = this.longest;
            if (i + i2 > charSequence.length()) {
                i2 = charSequence.length() - i;
            }
            while (i2 >= this.shortest) {
                String str = this.lookupMap.get(charSequence.subSequence(i, i + i2).toString());
                if (str != null) {
                    writer.write(str);
                    return i2;
                }
                i2--;
            }
            return 0;
        }
        return 0;
    }
}
