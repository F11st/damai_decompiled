package com.uc.webview.export.internal.setup;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.utility.SetupTask;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.r */
/* loaded from: classes11.dex */
final class C7288r implements ValueCallback<SetupTask> {
    LinkedList<Pair<String, HashMap<String, String>>> a = new LinkedList<>();
    final /* synthetic */ ValueCallback b;
    final /* synthetic */ C7285o c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7288r(C7285o c7285o, ValueCallback valueCallback) {
        this.c = c7285o;
        this.b = valueCallback;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(SetupTask setupTask) {
        SetupTask setupTask2 = setupTask;
        if (setupTask2.getStat().second == null) {
            IWaStat.WaStat.stat((String) setupTask2.getStat().first);
            return;
        }
        this.a.add(setupTask2.getStat());
        boolean z = true;
        boolean z2 = UCSetupTask.getTotalLoadedUCM() != null;
        boolean z3 = z2 && UCSetupTask.getTotalLoadedUCM().coreType == 2;
        z = (!z2 || UCSetupTask.getTotalLoadedUCM().coreType == 2) ? false : false;
        if (!((String) setupTask2.getStat().first).equals(IWaStat.SETUP_TOTAL_EXCEPTION) && !z3 && !Log.enabled()) {
            if (z) {
                this.a.clear();
                return;
            }
            return;
        }
        Iterator<Pair<String, HashMap<String, String>>> it = this.a.iterator();
        while (it.hasNext()) {
            Pair<String, HashMap<String, String>> next = it.next();
            if (!"sdk_7z".equals(next.first) && !IWaStat.SETUP_TASK_VERIFY_DETAIL.equals(next.first)) {
                IWaStat.SETUP_TASK_VERIFY.equals(next.first);
            }
            ValueCallback valueCallback = this.b;
            if (valueCallback == null) {
                IWaStat.WaStat.statAKV(next);
            } else {
                setupTask2.mStat = next;
                valueCallback.onReceiveValue(setupTask2);
            }
        }
        this.a.clear();
    }
}
