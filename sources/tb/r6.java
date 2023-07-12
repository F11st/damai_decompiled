package tb;

import android.os.AsyncTask;
import com.taobao.update.adapter.ThreadExecutor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class r6 implements ThreadExecutor {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a extends AsyncTask<Void, Void, Integer> {
        final /* synthetic */ Runnable a;

        a(r6 r6Var, Runnable runnable) {
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
    /* loaded from: classes11.dex */
    class b extends AsyncTask<Void, Void, Integer> {
        final /* synthetic */ int a;
        final /* synthetic */ Runnable b;

        b(r6 r6Var, int i, Runnable runnable) {
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
        new b(this, i, runnable).execute(new Void[0]);
    }

    @Override // com.taobao.update.adapter.ThreadExecutor
    public void execute(Runnable runnable) {
        new a(this, runnable).execute(new Void[0]);
    }
}
