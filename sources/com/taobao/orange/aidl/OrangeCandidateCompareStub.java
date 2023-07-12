package com.taobao.orange.aidl;

import android.os.RemoteException;
import android.text.TextUtils;
import com.taobao.orange.ICandidateCompare;
import com.taobao.orange.aidl.ParcelableCandidateCompare;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class OrangeCandidateCompareStub extends ParcelableCandidateCompare.Stub {
    private ICandidateCompare mCompare;

    public OrangeCandidateCompareStub(ICandidateCompare iCandidateCompare) {
        this.mCompare = iCandidateCompare;
    }

    @Override // com.taobao.orange.aidl.ParcelableCandidateCompare
    public boolean equals(String str, String str2) throws RemoteException {
        return this.mCompare.equals(str, str2);
    }

    @Override // com.taobao.orange.aidl.ParcelableCandidateCompare
    public boolean equalsNot(String str, String str2) throws RemoteException {
        return this.mCompare.equalsNot(str, str2);
    }

    @Override // com.taobao.orange.aidl.ParcelableCandidateCompare
    public boolean fuzzy(String str, String str2) throws RemoteException {
        return this.mCompare.fuzzy(str, str2);
    }

    @Override // com.taobao.orange.aidl.ParcelableCandidateCompare
    public boolean fuzzyNot(String str, String str2) throws RemoteException {
        return this.mCompare.fuzzyNot(str, str2);
    }

    public String getName() {
        String simpleName = this.mCompare.getClass().getSimpleName();
        return TextUtils.isEmpty(simpleName) ? this.mCompare.getClass().getName() : simpleName;
    }

    public Class getRealClass() {
        return this.mCompare.getClass();
    }

    @Override // com.taobao.orange.aidl.ParcelableCandidateCompare
    public boolean greater(String str, String str2) throws RemoteException {
        return this.mCompare.greater(str, str2);
    }

    @Override // com.taobao.orange.aidl.ParcelableCandidateCompare
    public boolean greaterEquals(String str, String str2) throws RemoteException {
        return this.mCompare.greaterEquals(str, str2);
    }

    @Override // com.taobao.orange.aidl.ParcelableCandidateCompare
    public boolean less(String str, String str2) throws RemoteException {
        return this.mCompare.less(str, str2);
    }

    @Override // com.taobao.orange.aidl.ParcelableCandidateCompare
    public boolean lessEquals(String str, String str2) throws RemoteException {
        return this.mCompare.lessEquals(str, str2);
    }
}
