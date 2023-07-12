package com.alibaba.poplayerconsole.view;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;
import com.alibaba.poplayerconsole.R$id;
import com.alibaba.poplayerconsole.R$layout;
import com.alibaba.poplayerconsole.a;
import com.alibaba.poplayerconsole.lib.Window;
import java.lang.ref.WeakReference;
import tb.gw2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class GeekView extends ScrollView implements View.OnClickListener, ILogView {
    private boolean mIsTrackMode;
    private Button mTrackBtn;

    public GeekView(Context context) {
        super(context);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R$layout.console_tools, (ViewGroup) this, true);
        Button button = (Button) findViewById(R$id.track_pick_btn);
        this.mTrackBtn = button;
        button.setOnClickListener(this);
        this.mTrackBtn.setText(String.valueOf(R$layout.console_body));
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public void destoryView() {
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public String getTitle() {
        return "Plus";
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public View getView() {
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.track_pick_btn) {
            try {
                this.mIsTrackMode = !this.mIsTrackMode;
                Activity activity = (Activity) gw2.a((WeakReference) a.d().get("page").b);
                if (activity == null) {
                    Toast.makeText(getContext().getApplicationContext(), "Current Activity is null", 0).show();
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) ((ViewGroup) activity.getWindow().findViewById(16908290)).getParent().getParent();
                if (viewGroup.getParent() instanceof ScalpelFrameLayout) {
                    ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                    View childAt = viewGroup2.getChildAt(0);
                    viewGroup2.removeAllViews();
                    ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
                    viewGroup3.removeView(viewGroup2);
                    viewGroup3.addView(childAt, 0);
                    return;
                }
                ScalpelFrameLayout scalpelFrameLayout = new ScalpelFrameLayout(activity);
                scalpelFrameLayout.setBackgroundColor(1157562368);
                ViewGroup viewGroup4 = (ViewGroup) viewGroup.getParent();
                viewGroup4.removeView(viewGroup);
                scalpelFrameLayout.addView(viewGroup);
                viewGroup4.addView(scalpelFrameLayout, 0);
                scalpelFrameLayout.setLayerInteractionEnabled(true);
            } catch (Exception e) {
                Log.e("PopLayer", "trigger.error", e);
            }
        }
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public void update(Window window) throws Throwable {
    }
}
