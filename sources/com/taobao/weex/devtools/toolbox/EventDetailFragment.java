package com.taobao.weex.devtools.toolbox;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.ali.user.open.core.util.ParamsConstants;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.ITracingAdapter;
import com.taobao.weex.devtools.adapter.WXTracingAdapter;
import com.taobao.weex.inspector.R$id;
import com.taobao.weex.inspector.R$layout;
import com.taobao.weex.utils.WXViewUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jn1;
import tb.wz2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class EventDetailFragment extends Fragment {
    private TextView eventName;
    private TextView eventPayload;
    private wz2.a rootEvent;
    private View rootView;
    private LinearLayout subEvents;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class EventView extends FrameLayout {
        TextView desc;
        TextView duration;
        View indicator;

        public EventView(@NonNull Context context) {
            super(context);
            init();
        }

        private void init() {
            this.indicator = new View(getContext());
            this.desc = new TextView(getContext());
            TextView textView = new TextView(getContext());
            this.duration = textView;
            textView.setGravity(5);
            addView(this.indicator);
            addView(this.desc);
            addView(this.duration);
        }
    }

    public static EventDetailFragment getFragment(int i, int i2) {
        EventDetailFragment eventDetailFragment = new EventDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("instanceId", i);
        bundle.putInt(ParamsConstants.Key.PARAM_TRACE_ID, i2);
        eventDetailFragment.setArguments(bundle);
        return eventDetailFragment;
    }

    private void instantiationViews() {
        this.eventName = (TextView) this.rootView.findViewById(R$id.event_name);
        this.subEvents = (LinearLayout) this.rootView.findViewById(R$id.sub_events);
        TextView textView = (TextView) this.rootView.findViewById(R$id.event_payload);
        this.eventPayload = textView;
        textView.setTypeface(Typeface.MONOSPACE);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = getArguments().getInt("instanceId");
        int i2 = getArguments().getInt(ParamsConstants.Key.PARAM_TRACE_ID);
        ITracingAdapter z = WXSDKManager.v().z();
        if (z != null && (z instanceof WXTracingAdapter)) {
            this.rootEvent = ((WXTracingAdapter) z).getTraceEventByInstanceId(i).m.get(i2);
        }
        this.rootView = layoutInflater.inflate(R$layout.fragment_event_detail, viewGroup, false);
        instantiationViews();
        this.eventName.setText(this.rootEvent.a);
        for (int i3 = 0; i3 < this.rootEvent.m.size(); i3++) {
            wz2.a valueAt = this.rootEvent.m.valueAt(i3);
            if (!"DomExecute".equals(valueAt.a) && !"UIExecute".equals(valueAt.a)) {
                EventView eventView = new EventView(getContext());
                eventView.desc.setText(valueAt.a);
                this.subEvents.addView(eventView);
                long j = valueAt.e;
                wz2.a aVar = this.rootEvent;
                int screenWidth = (int) (((j - aVar.e) / aVar.l) * (WXViewUtils.getScreenWidth(getContext()) - WXViewUtils.dip2px(8.0f)));
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) eventView.indicator.getLayoutParams();
                marginLayoutParams.width = ((int) ((valueAt.l / this.rootEvent.l) * WXViewUtils.getScreenWidth(getContext()))) + WXViewUtils.dip2px(2.0f);
                marginLayoutParams.height = -1;
                marginLayoutParams.leftMargin = screenWidth - WXViewUtils.dip2px(2.0f);
                marginLayoutParams.bottomMargin = 1;
                if ("DOMThread".equals(valueAt.b)) {
                    eventView.indicator.setBackgroundColor(Color.parseColor("#84A6E8"));
                } else if ("UIThread".equals(valueAt.b)) {
                    eventView.indicator.setBackgroundColor(Color.parseColor("#83B86E"));
                } else {
                    eventView.indicator.setBackgroundColor(-16711681);
                }
                eventView.indicator.setLayoutParams(marginLayoutParams);
                TextView textView = eventView.duration;
                textView.setText(valueAt.l + " ms");
            }
        }
        String str = this.rootEvent.n;
        if (str != null) {
            try {
                if (str.startsWith(jn1.BLOCK_START_STR)) {
                    JSONObject jSONObject = new JSONObject(this.rootEvent.n);
                    this.rootEvent.n = jSONObject.toString(2);
                } else if (this.rootEvent.n.startsWith(jn1.ARRAY_START_STR)) {
                    JSONArray jSONArray = new JSONArray(this.rootEvent.n);
                    this.rootEvent.n = jSONArray.toString(2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.eventPayload.setText(this.rootEvent.n);
        }
        return this.rootView;
    }
}
