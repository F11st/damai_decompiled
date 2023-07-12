package com.taobao.weex.devtools.toolbox;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.ITracingAdapter;
import com.taobao.weex.devtools.adapter.WXTracingAdapter;
import com.taobao.weex.inspector.R$id;
import com.taobao.weex.inspector.R$layout;
import com.taobao.weex.ui.component.WXComponent;
import tb.jn1;
import tb.wz2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class EventOverviewFragment extends Fragment {
    private RecyclerView list;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class ItemHolder extends RecyclerView.ViewHolder {
        public TextView actionDuration;
        public TextView actionName;
        public TextView compRef;
        public TextView compType;
        public View duration;
        public ImageView info;
        public LinearLayout infoContent;
        public TextView viewType;

        public ItemHolder(View view) {
            super(view);
            this.actionName = (TextView) view.findViewById(R$id.action_name);
            this.compRef = (TextView) view.findViewById(R$id.comp_ref);
            this.duration = view.findViewById(R$id.duration);
            this.infoContent = (LinearLayout) view.findViewById(R$id.info_content);
            this.actionDuration = (TextView) view.findViewById(R$id.action_duration);
            this.viewType = (TextView) view.findViewById(R$id.view_type);
            this.compType = (TextView) view.findViewById(R$id.comp_type);
            this.info = (ImageView) view.findViewById(R$id.info);
        }

        public int getItemWidth() {
            return this.infoContent.getMeasuredWidth() - 200;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private class PerfListAdapter extends RecyclerView.Adapter<ItemHolder> {
        private wz2.a rootEvent;

        public PerfListAdapter(wz2.a aVar) {
            this.rootEvent = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.rootEvent.m.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(final ItemHolder itemHolder, int i) {
            final wz2.a valueAt = this.rootEvent.m.valueAt(i);
            itemHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.taobao.weex.devtools.toolbox.EventOverviewFragment.PerfListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (valueAt.m == null) {
                        return;
                    }
                    EventOverviewFragment.this.getActivity().getSupportFragmentManager().beginTransaction().replace(R$id.fragment_container, EventDetailFragment.getFragment(PerfListAdapter.this.rootEvent.d, valueAt.d)).addToBackStack(EventDetailFragment.class.getSimpleName()).commitAllowingStateLoss();
                }
            });
            if (valueAt.m == null) {
                itemHolder.info.setVisibility(4);
            } else {
                itemHolder.info.setVisibility(0);
            }
            long j = valueAt.e;
            wz2.a aVar = this.rootEvent;
            if (j < aVar.e) {
                aVar.e = j;
            }
            itemHolder.actionName.setText(valueAt.a);
            TextView textView = itemHolder.actionDuration;
            textView.setText(valueAt.l + " ms");
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) itemHolder.duration.getLayoutParams();
            itemHolder.itemView.post(new Runnable() { // from class: com.taobao.weex.devtools.toolbox.EventOverviewFragment.PerfListAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
                    marginLayoutParams2.width = (int) ((valueAt.l / PerfListAdapter.this.rootEvent.l) * itemHolder.getItemWidth());
                    marginLayoutParams2.leftMargin = (int) (((valueAt.e - PerfListAdapter.this.rootEvent.e) / PerfListAdapter.this.rootEvent.l) * itemHolder.getItemWidth());
                    itemHolder.duration.setLayoutParams(marginLayoutParams2);
                }
            });
            if (valueAt.g != null) {
                WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(valueAt.f, valueAt.g);
                if (wXComponent != null) {
                    String componentType = wXComponent.getComponentType();
                    TextView textView2 = itemHolder.compType;
                    textView2.setText(jn1.L + componentType + "/>");
                    if (wXComponent.getRealView() != null) {
                        itemHolder.viewType.setText(wXComponent.getRealView().getClass().getSimpleName());
                    }
                    if (wXComponent.isLazy()) {
                        itemHolder.compType.append(" @lazy");
                    }
                    TextView textView3 = itemHolder.compRef;
                    textView3.setText("Ref: " + wXComponent.getRef());
                    return;
                }
                return;
            }
            itemHolder.compType.setText("-");
            itemHolder.viewType.setText("-");
            itemHolder.compRef.setText("-");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_trace_event_item, viewGroup, false));
        }
    }

    public static EventOverviewFragment getInstance(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("instanceId", i);
        EventOverviewFragment eventOverviewFragment = new EventOverviewFragment();
        eventOverviewFragment.setArguments(bundle);
        return eventOverviewFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R$layout.fragment_event_overview, viewGroup, false);
        int i = getArguments().getInt("instanceId", -1);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R$id.perf_list);
        this.list = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ITracingAdapter z = WXSDKManager.v().z();
        if (z != null && (z instanceof WXTracingAdapter) && i != -1) {
            this.list.setAdapter(new PerfListAdapter(((WXTracingAdapter) z).getTraceEventByInstanceId(i)));
        }
        return inflate;
    }
}
