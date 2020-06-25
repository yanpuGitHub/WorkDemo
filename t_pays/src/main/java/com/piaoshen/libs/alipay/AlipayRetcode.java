package com.piaoshen.libs.alipay;

import dc.android.common.BridgeRetcode;

/**
 * @author senrsl
 * @ClassName: AlipayRetcode
 * @Package: com.piaoshen.libs.alipay
 * @CreateTime: 2019/8/15 8:00 PM
 */
class AlipayRetcode extends BridgeRetcode {

    static final String ALIPAY_RESULT_STATUS_KEY = "resultStatus";
    static final String ALIPAY_RESULT_KEY = "result";
    static final String ALIPAY_MEMO_KEY = "memo";

    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
    static final String ALIPAY_SUCCESS_9000 = "9000";
    // “8000”代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
    static final String ALIPAY_SUCCESS_8000 = "8000";
    static final String ALIPAY_CANCEL_6001 = "6001";

}
