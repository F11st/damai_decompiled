package com.taobao.weex.ui.component.list.template;

import android.os.AsyncTask;
import android.os.Looper;
import android.os.MessageQueue;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.ui.component.list.WXCell;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AsyncCellLoadTask extends AsyncTask<Void, Void, Void> {
    private WXCell source;
    private String template;
    private WXRecyclerTemplateList templateList;

    public AsyncCellLoadTask(String str, WXCell wXCell, WXRecyclerTemplateList wXRecyclerTemplateList) {
        this.template = str;
        this.source = wXCell;
        this.templateList = wXRecyclerTemplateList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDestory() {
        if (this.source.getInstance() == null || this.source.getInstance().isDestroy()) {
            return true;
        }
        return this.templateList.isDestoryed();
    }

    public void startTask() {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Void doInBackground(Void... voidArr) {
        TemplateCache templateCache = this.templateList.getTemplatesCache().get(this.template);
        if (templateCache != null && templateCache.cells != null) {
            while (templateCache.cells.size() < this.templateList.getTemplateCacheSize()) {
                System.currentTimeMillis();
                WXCell wXCell = (WXCell) this.templateList.copyComponentFromSourceCell(this.source);
                WXEnvironment.isOpenDebugLog();
                if (wXCell == null || isDestory()) {
                    return null;
                }
                templateCache.cells.add(wXCell);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Void r4) {
        final TemplateCache templateCache;
        if (isDestory() || (templateCache = this.templateList.getTemplatesCache().get(this.template)) == null) {
            return;
        }
        ConcurrentLinkedQueue<WXCell> concurrentLinkedQueue = templateCache.cells;
        if (concurrentLinkedQueue != null && concurrentLinkedQueue.size() != 0) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.taobao.weex.ui.component.list.template.AsyncCellLoadTask.1
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    if (AsyncCellLoadTask.this.isDestory()) {
                        return false;
                    }
                    Iterator<WXCell> it = templateCache.cells.iterator();
                    while (it.hasNext()) {
                        WXCell next = it.next();
                        if (next.isLazy()) {
                            WXRecyclerTemplateList unused = AsyncCellLoadTask.this.templateList;
                            WXRecyclerTemplateList.doCreateCellViewBindData(next, AsyncCellLoadTask.this.template, true);
                            return it.hasNext();
                        }
                    }
                    return false;
                }
            });
            templateCache.isLoadIng = false;
            return;
        }
        templateCache.isLoadIng = false;
    }
}
