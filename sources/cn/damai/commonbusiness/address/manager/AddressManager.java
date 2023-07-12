package cn.damai.commonbusiness.address.manager;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.address.bean.AddressListBean;
import cn.damai.commonbusiness.address.net.AddressListRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class AddressManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private static AddressManager a;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.manager.AddressManager$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass2 extends DMMtopRequestListener<AddressListBean> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ AddressListener val$addressListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Class cls, AddressListener addressListener) {
            super(cls);
            this.val$addressListener = addressListener;
        }

        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
        public void onFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1442029639")) {
                ipChange.ipc$dispatch("-1442029639", new Object[]{this, str, str2});
                return;
            }
            AddressListener addressListener = this.val$addressListener;
            if (addressListener != null) {
                addressListener.onAddressListFail(str, str2);
            }
        }

        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
        public void onSuccess(AddressListBean addressListBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-10174804")) {
                ipChange.ipc$dispatch("-10174804", new Object[]{this, addressListBean});
                return;
            }
            AddressListener addressListener = this.val$addressListener;
            if (addressListener != null) {
                addressListener.onAddressListSuccess(addressListBean);
            }
        }
    }

    public static synchronized AddressManager b() {
        synchronized (AddressManager.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-380884165")) {
                return (AddressManager) ipChange.ipc$dispatch("-380884165", new Object[0]);
            }
            if (a == null) {
                a = new AddressManager();
            }
            return a;
        }
    }

    public void a(String str, final AddressListener addressListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1692567875")) {
            ipChange.ipc$dispatch("-1692567875", new Object[]{this, str, addressListener});
            return;
        }
        AddressListRequest addressListRequest = new AddressListRequest();
        addressListRequest.loginKey = str;
        addressListRequest.request(new DMMtopRequestListener<AddressListBean>(AddressListBean.class) { // from class: cn.damai.commonbusiness.address.manager.AddressManager.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1434270280")) {
                    ipChange2.ipc$dispatch("-1434270280", new Object[]{this, str2, str3});
                    return;
                }
                AddressListener addressListener2 = addressListener;
                if (addressListener2 != null) {
                    addressListener2.onAddressListFail(str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(AddressListBean addressListBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-964403699")) {
                    ipChange2.ipc$dispatch("-964403699", new Object[]{this, addressListBean});
                    return;
                }
                AddressListener addressListener2 = addressListener;
                if (addressListener2 != null) {
                    addressListener2.onAddressListSuccess(addressListBean);
                }
            }
        });
    }
}
