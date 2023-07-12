package tb;

import android.os.AsyncTask;
import com.taobao.android.dinamic.expression.parser.resolver.C6330e;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class b7 extends v0 {

    /* compiled from: Taobao */
    /* renamed from: tb.b7$a */
    /* loaded from: classes11.dex */
    class AsyncTaskC8954a extends AsyncTask<Void, Void, Void> {
        AsyncTaskC8954a(b7 b7Var) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            c7.a().c();
            return null;
        }
    }

    public b7() {
        new AsyncTaskC8954a(this).execute(new Void[0]);
    }

    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, v80 v80Var) {
        Object obj;
        if (list != null) {
            try {
                if (list.size() != 0) {
                    Object obj2 = list.get(0);
                    if (obj2 != null) {
                        StringTokenizer stringTokenizer = new StringTokenizer(obj2.toString(), " .[]", false);
                        if (stringTokenizer.hasMoreTokens()) {
                            obj = c7.a().c();
                            while (stringTokenizer.hasMoreTokens()) {
                                obj = C6330e.a(obj, stringTokenizer.nextToken());
                            }
                            return (obj != null && list.size() > 1) ? list.get(1) : obj;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        return obj;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                v80Var.e().b().a(p80.ERROR_CODE_TEMPLATE_PARSER_EXCEPTION, "AppStyleParser parse error");
            }
        }
        return null;
    }
}
