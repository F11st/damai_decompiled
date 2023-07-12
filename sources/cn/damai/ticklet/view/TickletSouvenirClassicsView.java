package cn.damai.ticklet.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.TicketSouvenirBean;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.view.DMAvatar;
import cn.damai.uikit.view.HoleCardView;
import cn.damai.uikit.view.LinearGradientView;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.py2;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletSouvenirClassicsView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private HoleCardView HoleCardView;
    private DMAvatar cb_user_icon;
    private TextView cb_user_name;
    private ImageView cb_vip_icon;
    private Context context;
    private View partent;
    float[] position;
    private TextView souvenir_address;
    private LinearGradientView souvenir_color_mask_bg;
    private TextView souvenir_damai_congratulation;
    private ImageView souvenir_defalut_mask_bg;
    private ImageView souvenir_divider;
    private TextView souvenir_line;
    private TextView souvenir_price_symbol;
    private ImageView souvenir_project_image;
    private TextView souvenir_project_name;
    private TextView souvenir_seat_no;
    private TextView souvenir_share_no;
    private TextView souvenir_ticket_total_num;
    private DMDigitTextView souvenir_ticklet_total_price;
    private TextView souvenir_time;
    private Bitmap usetBitmap;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1117349587")) {
                ipChange.ipc$dispatch("1117349587", new Object[]{this});
                return;
            }
            TickletSouvenirClassicsView.this.souvenir_divider.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            if (TickletSouvenirClassicsView.this.souvenir_divider.getBottom() == 0 || TickletSouvenirClassicsView.this.HoleCardView.getBottom() == 0) {
                return;
            }
            TickletSouvenirClassicsView.this.HoleCardView.setScallopPositionPercent((float) ((TickletSouvenirClassicsView.this.souvenir_divider.getBottom() * 100.0d) / TickletSouvenirClassicsView.this.HoleCardView.getBottom()));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "475881251")) {
                ipChange.ipc$dispatch("475881251", new Object[]{this, dVar});
            } else {
                TickletSouvenirClassicsView.this.defaultSet();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TicketSouvenirBean a;

        c(TicketSouvenirBean ticketSouvenirBean) {
            this.a = ticketSouvenirBean;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1580739192")) {
                ipChange.ipc$dispatch("1580739192", new Object[]{this, eVar});
            } else if (eVar == null || eVar.b == null) {
                TickletSouvenirClassicsView.this.defaultSet();
            } else {
                TickletSouvenirClassicsView.this.souvenir_project_image.setVisibility(0);
                TickletSouvenirClassicsView.this.souvenir_color_mask_bg.setVisibility(0);
                TickletSouvenirClassicsView.this.souvenir_project_image.setImageBitmap(eVar.b);
                TickletSouvenirClassicsView.this.souvenir_color_mask_bg.setColors(TickletSouvenirClassicsView.this.getColor(Color.parseColor(this.a.cardColor)));
                TickletSouvenirClassicsView.this.souvenir_color_mask_bg.setPosition(TickletSouvenirClassicsView.this.position);
                TickletSouvenirClassicsView.this.souvenir_defalut_mask_bg.setImageResource(R$drawable.ticklet_souvenir_black_bg);
                TickletSouvenirClassicsView.this.souvenir_share_no.setTextColor(Color.parseColor(this.a.cardColor));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class d implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1857511387")) {
                ipChange.ipc$dispatch("-1857511387", new Object[]{this, dVar});
            } else {
                TickletSouvenirClassicsView.this.cb_user_icon.setAvatar(R$drawable.mine_account_default);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class e implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "364585466")) {
                ipChange.ipc$dispatch("364585466", new Object[]{this, eVar});
            } else if (eVar == null || (bitmap = eVar.b) == null) {
                TickletSouvenirClassicsView.this.cb_user_icon.setAvatar(R$drawable.mine_account_default);
            } else {
                TickletSouvenirClassicsView.this.usetBitmap = bitmap;
                TickletSouvenirClassicsView.this.cb_user_icon.setAvatar(TickletSouvenirClassicsView.this.usetBitmap);
            }
        }
    }

    public TickletSouvenirClassicsView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void defaultSet() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1051527887")) {
            ipChange.ipc$dispatch("-1051527887", new Object[]{this});
            return;
        }
        this.souvenir_project_image.setVisibility(8);
        this.souvenir_color_mask_bg.setVisibility(8);
        this.souvenir_defalut_mask_bg.setImageResource(R$drawable.ticklet_souvenir_default_bg);
        this.souvenir_share_no.setTextColor(Color.parseColor("#9264FE"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getColor(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1071650138") ? (int[]) ipChange.ipc$dispatch("-1071650138", new Object[]{this, Integer.valueOf(i)}) : new int[]{i, py2.f().d(0.6f, i), py2.f().d(0.4f, i), py2.f().d(0.8f, i), i, i};
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "69339773")) {
            ipChange.ipc$dispatch("69339773", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_souvenir_classics_layout, this);
        this.partent = inflate;
        this.HoleCardView = (HoleCardView) inflate.findViewById(R$id.holecardView);
        this.souvenir_divider = (ImageView) this.partent.findViewById(R$id.souvenir_divider);
        this.souvenir_project_image = (ImageView) this.partent.findViewById(R$id.souvenir_project_image);
        this.souvenir_defalut_mask_bg = (ImageView) this.partent.findViewById(R$id.souvenir_defalut_mask_bg);
        this.souvenir_color_mask_bg = (LinearGradientView) this.partent.findViewById(R$id.souvenir_color_mask_bg);
        this.souvenir_share_no = (TextView) this.partent.findViewById(R$id.souvenir_share_no);
        this.souvenir_ticklet_total_price = (DMDigitTextView) this.partent.findViewById(R$id.souvenir_ticklet_total_price);
        this.souvenir_price_symbol = (TextView) this.partent.findViewById(R$id.souvenir_price_symbol);
        this.souvenir_ticket_total_num = (TextView) this.partent.findViewById(R$id.souvenir_ticket_total_num);
        this.souvenir_seat_no = (TextView) this.partent.findViewById(R$id.souvenir_seat_no);
        this.souvenir_time = (TextView) this.partent.findViewById(R$id.souvenir_time);
        this.souvenir_line = (TextView) this.partent.findViewById(R$id.souvenir_line);
        this.souvenir_address = (TextView) this.partent.findViewById(R$id.souvenir_address);
        this.souvenir_project_name = (TextView) this.partent.findViewById(R$id.souvenir_project_name);
        this.souvenir_damai_congratulation = (TextView) this.partent.findViewById(R$id.souvenir_damai_congratulation);
        this.cb_user_name = (TextView) this.partent.findViewById(R$id.cb_user_name);
        this.cb_user_icon = (DMAvatar) this.partent.findViewById(R$id.cb_user_icon);
        this.cb_vip_icon = (ImageView) this.partent.findViewById(R$id.cb_vip_icon);
        this.cb_user_icon.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_30x30);
        setListenerGlobal();
    }

    private void setListenerGlobal() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1332269055")) {
            ipChange.ipc$dispatch("1332269055", new Object[]{this});
        } else {
            this.souvenir_divider.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        }
    }

    public void setPriceShow(String str, int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1006301257")) {
            ipChange.ipc$dispatch("1006301257", new Object[]{this, str, Integer.valueOf(i), Boolean.valueOf(z)});
        } else if (!TextUtils.isEmpty(str)) {
            this.souvenir_ticklet_total_price.setVisibility(0);
            if (z) {
                this.souvenir_ticklet_total_price.setPadding(0, 0, 0, 0);
            } else {
                this.souvenir_ticklet_total_price.setPadding(0, t60.a(this.context, 4.0f), 0, 0);
            }
            this.souvenir_ticklet_total_price.setTextSize(1, i);
            this.souvenir_ticklet_total_price.setText(str);
        } else {
            this.souvenir_ticklet_total_price.setTextSize(1, 18.0f);
            this.souvenir_ticklet_total_price.setVisibility(8);
        }
    }

    public void setSeatShow(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1707931522")) {
            ipChange.ipc$dispatch("-1707931522", new Object[]{this, str});
        } else {
            this.souvenir_seat_no.setText(str);
        }
    }

    public void setUserInfo(String str, boolean z, boolean z2, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-360734927")) {
            ipChange.ipc$dispatch("-360734927", new Object[]{this, str, Boolean.valueOf(z), Boolean.valueOf(z2), str2});
            return;
        }
        if (z) {
            this.cb_user_icon.setAvatarCrownVisibility(8);
            this.cb_user_icon.setAvatarBorderVisibility(8);
            this.cb_user_icon.setAvatarYYmemberTagVisibility(8);
            this.cb_vip_icon.setVisibility(8);
            this.cb_user_icon.setAvatar(R$drawable.ticklet_circle_ffead8_bg);
            this.cb_user_name.setPadding(0, t60.a(this.context, 4.0f), 0, 0);
        } else {
            this.cb_user_name.setPadding(0, 0, 0, 0);
            Bitmap bitmap = this.usetBitmap;
            if (bitmap != null) {
                this.cb_user_icon.setAvatar(bitmap);
            } else {
                this.cb_user_icon.setAvatar(R$drawable.mine_account_default);
            }
            if (z2) {
                this.cb_vip_icon.setVisibility(0);
                this.cb_user_icon.setAvatarCrownVisibility(0);
                this.cb_user_icon.setAvatarBorderVisibility(0);
            } else {
                this.cb_vip_icon.setVisibility(8);
                this.cb_user_icon.setAvatarCrownVisibility(8);
                this.cb_user_icon.setAvatarBorderVisibility(8);
            }
            this.cb_user_icon.setYYMemberTagView(z2, str2);
        }
        this.cb_user_name.setText(str);
    }

    public void update(TicketSouvenirBean ticketSouvenirBean, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1806543127")) {
            ipChange.ipc$dispatch("-1806543127", new Object[]{this, ticketSouvenirBean, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else if (ticketSouvenirBean == null) {
        } else {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.souvenir_project_image.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            if (TextUtils.isEmpty(ticketSouvenirBean.cardColor)) {
                ticketSouvenirBean.cardColor = "#9264FE";
            }
            if (!TextUtils.isEmpty(ticketSouvenirBean.projectImage)) {
                cn.damai.common.image.a.b().e(ticketSouvenirBean.projectImage).n(new c(ticketSouvenirBean)).e(new b()).f();
            } else {
                defaultSet();
            }
            py2.F(this.souvenir_share_no, ticketSouvenirBean.shareNo);
            this.souvenir_ticklet_total_price.setVisibility(0);
            if (!TextUtils.isEmpty(ticketSouvenirBean.totalPrice)) {
                this.souvenir_ticklet_total_price.setText(ticketSouvenirBean.totalPrice);
            } else if (!TextUtils.isEmpty(ticketSouvenirBean.noPriceTxt)) {
                this.souvenir_ticklet_total_price.setText(ticketSouvenirBean.noPriceTxt);
            } else {
                this.souvenir_ticklet_total_price.setVisibility(8);
            }
            if (!TextUtils.isEmpty(ticketSouvenirBean.ticketNum)) {
                this.souvenir_ticket_total_num.setVisibility(0);
                this.souvenir_ticket_total_num.setText(this.context.getResources().getString(R$string.ticklet_ticket_total_num, ticketSouvenirBean.ticketNum));
            } else {
                this.souvenir_ticket_total_num.setVisibility(8);
            }
            py2.F(this.souvenir_seat_no, ticketSouvenirBean.allSeatText);
            int i4 = i / 2;
            this.souvenir_time.setMaxWidth(i4);
            this.souvenir_address.setMaxWidth(i4);
            if (!TextUtils.isEmpty(ticketSouvenirBean.beginTimeStr) && !TextUtils.isEmpty(ticketSouvenirBean.venueName)) {
                this.souvenir_line.setVisibility(0);
            } else {
                this.souvenir_line.setVisibility(8);
            }
            py2.F(this.souvenir_time, ticketSouvenirBean.beginTimeStr);
            py2.F(this.souvenir_address, ticketSouvenirBean.venueName);
            py2.F(this.souvenir_project_name, ticketSouvenirBean.projectName);
            py2.F(this.souvenir_damai_congratulation, ticketSouvenirBean.text);
            if (!TextUtils.isEmpty(ticketSouvenirBean.nickname)) {
                this.cb_user_name.setVisibility(0);
                this.cb_user_name.setText(ticketSouvenirBean.nickname);
            } else {
                this.cb_user_name.setVisibility(8);
            }
            if ("1".equals(ticketSouvenirBean.vip)) {
                this.cb_user_icon.setAvatarCrownVisibility(0);
                this.cb_user_icon.setAvatarBorderVisibility(0);
                py2.r(this.cb_vip_icon, ticketSouvenirBean.vipLevelIcon);
            } else {
                this.cb_vip_icon.setVisibility(8);
                this.cb_user_icon.setAvatarCrownVisibility(8);
                this.cb_user_icon.setAvatarBorderVisibility(8);
            }
            this.cb_user_icon.setYYMemberTagView("1".equals(ticketSouvenirBean.vip), ticketSouvenirBean.pfVipMemberLevel);
            if (!TextUtils.isEmpty(ticketSouvenirBean.userImageUrl)) {
                cn.damai.common.image.a.b().e(ticketSouvenirBean.userImageUrl).n(new e()).e(new d()).f();
            } else {
                this.cb_user_icon.setAvatar(R$drawable.mine_account_default);
            }
        }
    }

    public TickletSouvenirClassicsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletSouvenirClassicsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.usetBitmap = null;
        this.position = new float[]{0.0f, 0.12f, 0.3f, 0.54f, 0.67f, 1.0f};
        this.context = context;
        initView();
    }
}
