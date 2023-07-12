package tb;

import android.os.AsyncTask;
import com.taobao.update.adapter.ThreadExecutor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class r6 implements ThreadExecutor {

    /* compiled from: Taobao */
    /* renamed from: tb.r6$a */
    /* loaded from: classes11.dex */
    class AsyncTaskC9644a extends AsyncTask<Void, Void, Integer> {
        final /* synthetic */ Runnable a;

        AsyncTaskC9644a(r6 r6Var, Runnable runnable) {
            this.a = runnable;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(Void... voidArr) {
            this.a.run();
            return 0;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.r6$b */
    /* loaded from: classes11.dex */
    class AsyncTaskC9645b extends AsyncTask<Void, Void, Integer> {
        final /* synthetic */ int a;
        final /* synthetic */ Runnable b;

        AsyncTaskC9645b(r6 r6Var, int i, Runnable runnable) {
            this.a = i;
            this.b = runnable;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(Void... voidArr) {
            try {
                Thread.sleep(this.a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.b.run();
            return 0;
        }
    }

    @Override // com.taobao.update.adapter.ThreadExecutor
    public void delayExecute(Runnable runnable, int i) {
        new AsyncTaskC9645b(this, i, runnable).execute(new Void[0]);
    }

    @Override // com.taobao.update.adapter.ThreadExecutor
    public void execute(Runnable runnable) {
        new AsyncTaskC9644a(this, runnable).execute(new Void[0]);
    }
}
