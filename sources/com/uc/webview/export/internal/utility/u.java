package com.uc.webview.export.internal.utility;

import com.uc.webview.export.internal.setup.bt;
import java.io.File;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class u implements Comparator<bt> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(bt btVar, bt btVar2) {
        int i = ((new File((String) btVar2.coreImplModule.first).lastModified() - new File((String) btVar.coreImplModule.first).lastModified()) > 0L ? 1 : ((new File((String) btVar2.coreImplModule.first).lastModified() - new File((String) btVar.coreImplModule.first).lastModified()) == 0L ? 0 : -1));
        if (i > 0) {
            return 1;
        }
        return i == 0 ? 0 : -1;
    }
}
