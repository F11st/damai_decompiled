package org.apache.commons.text.similarity;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class Counter {
    private Counter() {
    }

    public static Map<CharSequence, Integer> of(CharSequence[] charSequenceArr) {
        HashMap hashMap = new HashMap();
        for (CharSequence charSequence : charSequenceArr) {
            if (hashMap.containsKey(charSequence)) {
                hashMap.put(charSequence, Integer.valueOf(((Integer) hashMap.get(charSequence)).intValue() + 1));
            } else {
                hashMap.put(charSequence, 1);
            }
        }
        return hashMap;
    }
}
