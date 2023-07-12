package com.alibaba.poplayer.layermanager;

import android.app.Activity;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface ICVMHolderAction {
    void acceptRequests(ArrayList<PopRequest> arrayList);

    void attach(Activity activity);

    void removeRequests(ArrayList<PopRequest> arrayList);

    void viewReadyNotify(PopRequest popRequest);
}
