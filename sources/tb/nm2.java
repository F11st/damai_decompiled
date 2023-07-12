package tb;

import android.os.AsyncTask;
import com.taobao.update.adapter.ThreadExecutor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class nm2 implements ThreadExecutor {

    /* compiled from: Taobao */
    /* renamed from: tb.nm2$a */
    /* loaded from: classes11.dex */
    class AsyncTaskC9476a extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ Runnable a;

        AsyncTaskC9476a(nm2 nm2Var, Runnable runnable) {
            this.a = runnable;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            this.a.run();
            return null;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.nm2$b */
    /* loaded from: classes11.dex */
    class AsyncTaskC9477b extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ int a;
        final /* synthetic */ Runnable b;

        AsyncTaskC9477b(nm2 nm2Var, int i, Runnable runnable) {
            this.a = i;
            this.b = runnable;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            try {
                Thread.sleep(this.a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.b.run();
            return null;
        }
    }

    @Override // com.taobao.update.adapter.ThreadExecutor
    public void delayExecute(Runnable runnable, int i) {
        new AsyncTaskC9477b(this, i, runnable).execute(new Void[0]);
    }

    @Override // com.taobao.update.adapter.ThreadExecutor
    public void execute(Runnable runnable) {
        new AsyncTaskC9476a(this, runnable).execute(new Void[0]);
    }
}
