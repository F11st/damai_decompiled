package com.taobao.application.common.impl;

import com.taobao.application.common.IPageListener;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class PageListenerGroup implements IPageListener, IListenerGroup<IPageListener> {
    private ArrayList<IPageListener> a = new ArrayList<>();

    private void c(Runnable runnable) {
        a.g().h(runnable);
    }

    @Override // com.taobao.application.common.impl.IListenerGroup
    /* renamed from: b */
    public void addListener(final IPageListener iPageListener) {
        if (iPageListener != null) {
            c(new Runnable() { // from class: com.taobao.application.common.impl.PageListenerGroup.2
                @Override // java.lang.Runnable
                public void run() {
                    if (PageListenerGroup.this.a.contains(iPageListener)) {
                        return;
                    }
                    PageListenerGroup.this.a.add(iPageListener);
                }
            });
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.taobao.application.common.impl.IListenerGroup
    /* renamed from: d */
    public void removeListener(final IPageListener iPageListener) {
        if (iPageListener != null) {
            c(new Runnable() { // from class: com.taobao.application.common.impl.PageListenerGroup.3
                @Override // java.lang.Runnable
                public void run() {
                    PageListenerGroup.this.a.remove(iPageListener);
                }
            });
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.taobao.application.common.IPageListener
    public void onPageChanged(final String str, final int i, final long j) {
        c(new Runnable() { // from class: com.taobao.application.common.impl.PageListenerGroup.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = PageListenerGroup.this.a.iterator();
                while (it.hasNext()) {
                    ((IPageListener) it.next()).onPageChanged(str, i, j);
                }
            }
        });
    }
}
