package com.taobao.orange.candidate;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class IntCompare extends DefCandidateCompare {
    @Override // com.taobao.orange.candidate.DefCandidateCompare, com.taobao.orange.ICandidateCompare
    public boolean equals(String str, String str2) {
        return Integer.parseInt(str) == Integer.parseInt(str2);
    }

    @Override // com.taobao.orange.candidate.DefCandidateCompare, com.taobao.orange.ICandidateCompare
    public boolean equalsNot(String str, String str2) {
        return Integer.parseInt(str) != Integer.parseInt(str2);
    }

    @Override // com.taobao.orange.candidate.DefCandidateCompare, com.taobao.orange.ICandidateCompare
    public boolean greater(String str, String str2) {
        return Integer.parseInt(str) > Integer.parseInt(str2);
    }

    @Override // com.taobao.orange.candidate.DefCandidateCompare, com.taobao.orange.ICandidateCompare
    public boolean greaterEquals(String str, String str2) {
        return Integer.parseInt(str) >= Integer.parseInt(str2);
    }

    @Override // com.taobao.orange.candidate.DefCandidateCompare, com.taobao.orange.ICandidateCompare
    public boolean less(String str, String str2) {
        return Integer.parseInt(str) < Integer.parseInt(str2);
    }

    @Override // com.taobao.orange.candidate.DefCandidateCompare, com.taobao.orange.ICandidateCompare
    public boolean lessEquals(String str, String str2) {
        return Integer.parseInt(str) <= Integer.parseInt(str2);
    }
}
