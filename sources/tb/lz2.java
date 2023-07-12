package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.alibaba.aliweex.R$id;
import com.alibaba.aliweex.R$string;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class lz2 {
    private Context a;
    private View b;
    private View.OnClickListener c;
    private TextView d;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (lz2.this.c != null) {
                lz2.this.c.onClick(view);
            }
        }
    }

    public lz2(Context context, View view) {
        this.a = context;
        this.b = ((ViewStub) view.findViewById(R$id.wx_fragment_error)).inflate();
        this.d = (TextView) view.findViewById(R$id.wa_common_error_text);
    }

    private String c(int i) {
        return this.a.getResources().getString(i);
    }

    private void e(String str) {
        TextView textView = this.d;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public void b() {
        this.b = null;
    }

    public void d() {
        View view = this.b;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        View view = this.b;
        if (view != null) {
            this.c = onClickListener;
            view.setClickable(true);
            this.b.setOnClickListener(new a());
        }
    }

    public void g(String str) {
        if (this.b == null || this.a == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = c(R$string.weex_common_error_data);
        }
        e(str);
        this.b.setVisibility(0);
    }
}
