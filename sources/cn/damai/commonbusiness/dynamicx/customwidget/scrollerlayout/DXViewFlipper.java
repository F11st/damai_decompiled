package cn.damai.commonbusiness.dynamicx.customwidget.scrollerlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.dynamicx.customwidget.temp.DMUpMarqueeView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.m62;
import tb.mu0;
import tb.t41;
import tb.yq;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DXViewFlipper extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMUpMarqueeView marqueeView;
    private int width;

    public DXViewFlipper(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "721460345")) {
            ipChange.ipc$dispatch("721460345", new Object[]{this});
            return;
        }
        this.width = m62.a(mu0.a(), 20.0f);
        DMUpMarqueeView dMUpMarqueeView = (DMUpMarqueeView) LayoutInflater.from(getContext()).inflate(R$layout.layout_mult_artist, (ViewGroup) null);
        this.marqueeView = dMUpMarqueeView;
        addView(dMUpMarqueeView);
    }

    private void loadHead(String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1820336180")) {
            ipChange.ipc$dispatch("-1820336180", new Object[]{this, str, imageView});
            return;
        }
        a h = a.b().h(mu0.a());
        int i = this.width;
        DMImageCreator f = h.f(str, i, i);
        int i2 = R$drawable.uikit_user_default_icon_trans_white;
        f.i(i2).c(i2).k(new yq()).g(imageView);
    }

    public void createView(JSONArray jSONArray) {
        View createView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1350986229")) {
            ipChange.ipc$dispatch("1350986229", new Object[]{this, jSONArray});
            return;
        }
        int b = t41.b(jSONArray);
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        for (int i = 0; i < b; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null && (createView = createView(jSONObject)) != null) {
                arrayList.add(createView);
            }
        }
        this.marqueeView.setItems(arrayList);
    }

    public void setAnimateTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-286946206")) {
            ipChange.ipc$dispatch("-286946206", new Object[]{this, Long.valueOf(j)});
            return;
        }
        DMUpMarqueeView dMUpMarqueeView = this.marqueeView;
        if (dMUpMarqueeView != null) {
            if (j <= 0) {
                j = 500;
            }
            dMUpMarqueeView.setAnimationDuration(j);
        }
    }

    public void setInterval(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1161969042")) {
            ipChange.ipc$dispatch("-1161969042", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        DMUpMarqueeView dMUpMarqueeView = this.marqueeView;
        if (dMUpMarqueeView != null) {
            if (i <= 0) {
                i = 3000;
            }
            dMUpMarqueeView.setFlipInterval(i);
        }
    }

    public DXViewFlipper(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public DXViewFlipper(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private View createView(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1182011717")) {
            return (View) ipChange.ipc$dispatch("1182011717", new Object[]{this, jSONObject});
        }
        if (jSONObject == null) {
            return null;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.homepage_video_item_artist, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R$id.user_head_single_name);
        if (jSONObject.containsKey("name")) {
            textView.setText(jSONObject.getString("name"));
        }
        ImageView imageView = (ImageView) inflate.findViewById(R$id.user_head_single);
        if (jSONObject.containsKey("headPic")) {
            loadHead(jSONObject.getString("headPic"), imageView);
        }
        return inflate;
    }
}
