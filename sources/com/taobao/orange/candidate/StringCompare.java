package com.taobao.orange.candidate;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class StringCompare extends DefCandidateCompare {
    @Override // com.taobao.orange.candidate.DefCandidateCompare, com.taobao.orange.ICandidateCompare
    public boolean equals(String str, String str2) {
        return str.equals(str2);
    }

    @Override // com.taobao.orange.candidate.DefCandidateCompare, com.taobao.orange.ICandidateCompare
    public boolean equalsNot(String str, String str2) {
        return !str.equals(str2);
    }

    @Override // com.taobao.orange.candidate.DefCandidateCompare, com.taobao.orange.ICandidateCompare
    public boolean fuzzy(String str, String str2) {
        return str.startsWith(str2);
    }

    @Override // com.taobao.orange.candidate.DefCandidateCompare, com.taobao.orange.ICandidateCompare
    public boolean fuzzyNot(String str, String str2) {
        return !str.startsWith(str2);
    }
}
