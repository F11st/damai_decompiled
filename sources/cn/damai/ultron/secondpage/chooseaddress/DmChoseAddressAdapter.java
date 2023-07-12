package cn.damai.ultron.secondpage.chooseaddress;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.address.bean.AddressBean;
import cn.damai.commonbusiness.address.ui.AddAddressActivity;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.ultron.R$color;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.R$string;
import cn.damai.ultron.utils.DmUltronChooseListenerImpl;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import mtopsdk.common.util.StringUtils;
import tb.lb0;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DmChoseAddressAdapter extends RecyclerView.Adapter<AddressViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<AddressBean> a;
    private Context b;
    private Boolean c = Boolean.TRUE;
    private int d = 0;
    private int e;
    private DmUltronChooseListenerImpl<AddressBean> f;
    private String g;
    boolean h;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class AddressViewHolder extends RecyclerView.ViewHolder {
        private View a;
        private DMIconFontTextView b;
        private TextView c;
        private TextView d;
        private TextView e;
        private DMIconFontTextView f;
        private View g;

        public AddressViewHolder(DmChoseAddressAdapter dmChoseAddressAdapter, View view) {
            super(view);
            this.a = view;
            this.b = (DMIconFontTextView) view.findViewById(R$id.icon_edit);
            this.c = (TextView) view.findViewById(R$id.text_name);
            this.d = (TextView) view.findViewById(R$id.text_phone);
            this.e = (TextView) view.findViewById(R$id.text_address);
            this.f = (DMIconFontTextView) view.findViewById(R$id.checkbox);
            this.g = view.findViewById(R$id.line);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class a extends ClickableSpan {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2036228445")) {
                ipChange.ipc$dispatch("-2036228445", new Object[]{this, view});
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1054692364")) {
                ipChange.ipc$dispatch("-1054692364", new Object[]{this, textPaint});
                return;
            }
            super.updateDrawState(textPaint);
            textPaint.setColor(DmChoseAddressAdapter.this.b.getResources().getColor(R$color.main_color));
            textPaint.setUnderlineText(false);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ AddressBean a;
        final /* synthetic */ int b;

        b(AddressBean addressBean, int i) {
            this.a = addressBean;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "75061924")) {
                ipChange.ipc$dispatch("75061924", new Object[]{this, view});
                return;
            }
            ((AddressBean) DmChoseAddressAdapter.this.a.get(DmChoseAddressAdapter.this.d)).setChecked(Boolean.FALSE);
            this.a.setChecked(Boolean.TRUE);
            DmChoseAddressAdapter.this.d = this.b;
            if (DmChoseAddressAdapter.this.f != null) {
                DmChoseAddressAdapter.this.f.chooseItemListener(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ AddressBean a;

        c(AddressBean addressBean) {
            this.a = addressBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2108615003")) {
                ipChange.ipc$dispatch("-2108615003", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(AddAddressActivity.KEY_OPERATION_ADDRESS, 2);
            bundle.putParcelable(AddAddressActivity.KEY_MODIFIED_ADDRESS_DATA, this.a);
            DMNav.from(DmChoseAddressAdapter.this.b).withExtras(bundle).forResult(40).toUri(NavUri.b("addaddress"));
        }
    }

    public DmChoseAddressAdapter(Context context, int i, DmUltronChooseListenerImpl<AddressBean> dmUltronChooseListenerImpl) {
        this.e = 0;
        this.b = context;
        this.e = i;
        this.f = dmUltronChooseListenerImpl;
    }

    public List<AddressBean> f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1331433543") ? (List) ipChange.ipc$dispatch("1331433543", new Object[]{this}) : this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(AddressViewHolder addressViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-586448115")) {
            ipChange.ipc$dispatch("-586448115", new Object[]{this, addressViewHolder, Integer.valueOf(i)});
            return;
        }
        AddressBean addressBean = this.a.get(i);
        addressViewHolder.c.setText(addressBean.getConsigneeName());
        addressViewHolder.d.setText(addressBean.getMobile());
        if (i != 0) {
            addressViewHolder.g.setVisibility(0);
        } else if (this.h) {
            addressViewHolder.g.setVisibility(8);
        } else {
            addressViewHolder.g.setVisibility(0);
        }
        if (this.e == 0) {
            if (StringUtils.isEmpty(this.g)) {
                if ("1".equals(addressBean.getIsDefault()) && this.c.booleanValue()) {
                    this.c = Boolean.FALSE;
                    this.d = i;
                    addressBean.setChecked(Boolean.TRUE);
                }
            } else if (this.g.equals(addressBean.getAddressId())) {
                this.d = i;
                addressBean.setChecked(Boolean.TRUE);
            }
        }
        if (!"1".equals(addressBean.getIsDefault())) {
            addressViewHolder.e.setText(lb0.a(addressBean));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[默认地址]");
            sb.append(" ");
            sb.append(lb0.a(addressBean));
            SpannableString spannableString = new SpannableString(sb.toString());
            if (sb.toString().contains("[默认地址]")) {
                int indexOf = sb.toString().indexOf("[默认地址]");
                spannableString.setSpan(new a(), indexOf, indexOf + 6, 17);
                addressViewHolder.e.setText(spannableString);
                addressViewHolder.e.setHighlightColor(0);
            }
        }
        if (addressBean.getChecked().booleanValue()) {
            addressViewHolder.f.setText(this.b.getString(R$string.iconfont_danxuanxuanzhong24));
            addressViewHolder.f.setTextColor(ContextCompat.getColor(this.b, R$color.color_FF2D79));
        } else {
            addressViewHolder.f.setText(this.b.getString(R$string.iconfont_danxuanweixuanzhong24));
            addressViewHolder.f.setTextColor(ContextCompat.getColor(this.b, R$color.color_999999));
        }
        addressViewHolder.a.setOnClickListener(new b(addressBean, i));
        addressViewHolder.b.setOnClickListener(new c(addressBean));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-747174318")) {
            return ((Integer) ipChange.ipc$dispatch("-747174318", new Object[]{this})).intValue();
        }
        List<AddressBean> list = this.a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public AddressViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1113535351") ? (AddressViewHolder) ipChange.ipc$dispatch("-1113535351", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new AddressViewHolder(this, LayoutInflater.from(this.b).inflate(R$layout.dm_chose_address_item, viewGroup, false));
    }

    public void i(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "306658458")) {
            ipChange.ipc$dispatch("306658458", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.h = z;
        }
    }

    public void j(List<AddressBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1415397477")) {
            ipChange.ipc$dispatch("1415397477", new Object[]{this, list});
        } else {
            this.a = list;
        }
    }

    public void k(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1224630249")) {
            ipChange.ipc$dispatch("-1224630249", new Object[]{this, str});
        } else {
            this.g = str;
        }
    }
}
