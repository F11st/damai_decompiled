package tb;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.alime.IAliMeCouponFaq;
import com.alibaba.pictures.bricks.alime.OnAliMeListener;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import com.alibaba.pictures.bricks.bean.CouponOrderInfoBean;
import com.alibaba.pictures.bricks.coupon.order.bean.GaiaXBean;
import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;
import com.alibaba.pictures.bricks.coupon.view.OnFagActionListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class lh0 implements OnFagActionListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Context a;
    @Nullable
    private BricksBaseFragment b;

    /* compiled from: Taobao */
    /* renamed from: tb.lh0$a */
    /* loaded from: classes7.dex */
    public static final class C9411a implements OnAliMeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C9411a() {
        }

        @Override // com.alibaba.pictures.bricks.alime.OnAliMeListener
        public void onAliMeOpenFail() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "870920698")) {
                ipChange.ipc$dispatch("870920698", new Object[]{this});
                return;
            }
            BricksBaseFragment a = lh0.this.a();
            if (a != null) {
                a.hideLoadingDialog();
            }
        }

        @Override // com.alibaba.pictures.bricks.alime.OnAliMeListener
        public void onAliMeOpenSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "203116367")) {
                ipChange.ipc$dispatch("203116367", new Object[]{this});
                return;
            }
            BricksBaseFragment a = lh0.this.a();
            if (a != null) {
                a.hideLoadingDialog();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.lh0$b */
    /* loaded from: classes7.dex */
    public static final class C9412b implements OnAliMeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C9412b() {
        }

        @Override // com.alibaba.pictures.bricks.alime.OnAliMeListener
        public void onAliMeOpenFail() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1838688559")) {
                ipChange.ipc$dispatch("-1838688559", new Object[]{this});
                return;
            }
            BricksBaseFragment a = lh0.this.a();
            if (a != null) {
                a.hideLoadingDialog();
            }
        }

        @Override // com.alibaba.pictures.bricks.alime.OnAliMeListener
        public void onAliMeOpenSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2144069400")) {
                ipChange.ipc$dispatch("2144069400", new Object[]{this});
                return;
            }
            BricksBaseFragment a = lh0.this.a();
            if (a != null) {
                a.hideLoadingDialog();
            }
        }
    }

    public lh0(@NotNull Context context, @Nullable BricksBaseFragment bricksBaseFragment) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = context;
        this.b = bricksBaseFragment;
    }

    @Nullable
    public final BricksBaseFragment a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "304048558") ? (BricksBaseFragment) ipChange.ipc$dispatch("304048558", new Object[]{this}) : this.b;
    }

    @Override // com.alibaba.pictures.bricks.coupon.view.OnFagActionListener
    public void onFagAllClick(@NotNull OrderDetail orderDetail) {
        String orderId;
        String itemId;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1131323297")) {
            ipChange.ipc$dispatch("-1131323297", new Object[]{this, orderDetail});
            return;
        }
        b41.i(orderDetail, "order");
        CouponOrderInfoBean orderInfoVO = orderDetail.getOrderInfoVO();
        if (orderInfoVO == null || (orderId = orderInfoVO.getOrderId()) == null || (itemId = orderDetail.getItemId()) == null) {
            return;
        }
        BricksBaseFragment bricksBaseFragment = this.b;
        if (bricksBaseFragment != null) {
            bricksBaseFragment.showLoadingDialog(new String[0]);
        }
        IAliMeCouponFaq a = p4.INSTANCE.a();
        if (a != null) {
            a.openAliMe4Fag(this.a, itemId, orderId, new C9411a());
        }
    }

    @Override // com.alibaba.pictures.bricks.coupon.view.OnFagActionListener
    public void onItemClick(@NotNull View view, @NotNull String str, @NotNull OrderDetail orderDetail, int i) {
        JSONObject data;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1506698870")) {
            ipChange.ipc$dispatch("-1506698870", new Object[]{this, view, str, orderDetail, Integer.valueOf(i)});
            return;
        }
        b41.i(view, "itemView");
        b41.i(str, "question");
        b41.i(orderDetail, "order");
        qo1 qo1Var = qo1.INSTANCE;
        String itemId = orderDetail.getItemId();
        CouponOrderInfoBean orderInfoVO = orderDetail.getOrderInfoVO();
        qo1Var.p(view, itemId, orderInfoVO != null ? orderInfoVO.getOrderId() : null, str, i);
        String itemId2 = orderDetail.getItemId();
        if (itemId2 == null || itemId2.length() == 0) {
            GaiaXBean validGaiaXBean = orderDetail.getValidGaiaXBean("damai_script_order_detail_header");
            itemId2 = (validGaiaXBean == null || (data = validGaiaXBean.getData()) == null) ? null : data.getString("itemId");
        }
        String str2 = itemId2;
        CouponOrderInfoBean orderInfoVO2 = orderDetail.getOrderInfoVO();
        String orderId = orderInfoVO2 != null ? orderInfoVO2.getOrderId() : null;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        if (orderId != null && orderId.length() != 0) {
            z = false;
        }
        if (z) {
            return;
        }
        BricksBaseFragment bricksBaseFragment = this.b;
        if (bricksBaseFragment != null) {
            bricksBaseFragment.showLoadingDialog(new String[0]);
        }
        IAliMeCouponFaq a = p4.INSTANCE.a();
        if (a != null) {
            Context context = this.a;
            b41.f(str2);
            a.openAliMe4SingleFaq(context, str2, orderId, str, new C9412b());
        }
    }

    @Override // com.alibaba.pictures.bricks.coupon.view.OnFagActionListener
    public void onItemExpose(@NotNull View view, @NotNull String str, @Nullable OrderDetail orderDetail, int i) {
        CouponOrderInfoBean orderInfoVO;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "725618176")) {
            ipChange.ipc$dispatch("725618176", new Object[]{this, view, str, orderDetail, Integer.valueOf(i)});
            return;
        }
        b41.i(view, "itemView");
        b41.i(str, "question");
        qo1.INSTANCE.e(view, orderDetail != null ? orderDetail.getItemId() : null, (orderDetail == null || (orderInfoVO = orderDetail.getOrderInfoVO()) == null) ? null : orderInfoVO.getOrderId(), str, i);
    }
}
