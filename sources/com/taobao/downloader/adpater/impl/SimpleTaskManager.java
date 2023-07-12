package com.taobao.downloader.adpater.impl;

import com.taobao.downloader.adpater.TaskManager;
import com.taobao.downloader.download.IDownloader;
import com.taobao.downloader.util.ThreadUtil;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tb.ad2;
import tb.id2;
import tb.kl2;
import tb.vg1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SimpleTaskManager implements TaskManager {
    private ConcurrentHashMap<Integer, IDownloader> a = new ConcurrentHashMap<>();

    @Override // com.taobao.downloader.adpater.TaskManager
    public void addTask(final List<id2> list, final kl2 kl2Var) {
        final IDownloader downloader = new ad2().getDownloader(kl2Var.c);
        this.a.put(Integer.valueOf(kl2Var.b), downloader);
        ThreadUtil.a(new Runnable() { // from class: com.taobao.downloader.adpater.impl.SimpleTaskManager.1
            @Override // java.lang.Runnable
            public void run() {
                for (id2 id2Var : list) {
                    downloader.download(id2Var, kl2Var.d);
                }
                SimpleTaskManager.this.a.remove(Integer.valueOf(kl2Var.b));
            }
        }, false);
    }

    @Override // com.taobao.downloader.adpater.TaskManager
    public void modifyTask(int i, int i2) {
        IDownloader iDownloader = this.a.get(Integer.valueOf(i));
        if (iDownloader != null) {
            if (1 == i2) {
                iDownloader.pause();
            } else if (2 == i2) {
                iDownloader.cancel();
            }
        }
    }

    @Override // com.taobao.downloader.adpater.TaskManager
    public void modifyTask(int i, vg1 vg1Var) {
        throw null;
    }
}
