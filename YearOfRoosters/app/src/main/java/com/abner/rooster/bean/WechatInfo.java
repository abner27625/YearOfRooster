package com.abner.rooster.bean;

import java.io.Serializable;

/**
 * Created by heng on 2017/2/14.
 */

public class WechatInfo implements Serializable{

    /**
     * ret_msg :
     * data : {"auditingInfoCode":"J20170112110155214E6E","againState":1,"productTypeName":"公积金贷","info":{"d":{"createTime":"2017-02-15 10:41:35","infoKey":"还款","state":3,"infoValue":"还款成功"},"e":{"createTime":"2017-02-15 10:41:35","infoKey":"结清 ","state":1,"infoValue":"结清"},"b":{"createTime":"2017-01-15 00:29:39","infoKey":"签约","state":3,"infoValue":"签约成功"},"c":{"createTime":"2017-01-15 00:30:10","infoKey":"放款","state":3,"infoValue":"等待放款"},"a":{"createTime":"2017-01-12 16:48:28","infoKey":"信息审核 ","state":3,"infoValue":"审核通过"}}}
     * ret_code : 1
     */

    public String ret_msg;
    public DataBean data;
    public int ret_code;

    public static class DataBean {
        /**
         * auditingInfoCode : J20170112110155214E6E
         * againState : 1
         * productTypeName : 公积金贷
         * info : {"d":{"createTime":"2017-02-15 10:41:35","infoKey":"还款","state":3,"infoValue":"还款成功"},"e":{"createTime":"2017-02-15 10:41:35","infoKey":"结清 ","state":1,"infoValue":"结清"},"b":{"createTime":"2017-01-15 00:29:39","infoKey":"签约","state":3,"infoValue":"签约成功"},"c":{"createTime":"2017-01-15 00:30:10","infoKey":"放款","state":3,"infoValue":"等待放款"},"a":{"createTime":"2017-01-12 16:48:28","infoKey":"信息审核 ","state":3,"infoValue":"审核通过"}}
         */

        public String auditingInfoCode;
        public int againState;
        public String productTypeName;
        public InfoBean info;

        public static class InfoBean {
            /**
             * d : {"createTime":"2017-02-15 10:41:35","infoKey":"还款","state":3,"infoValue":"还款成功"}
             * e : {"createTime":"2017-02-15 10:41:35","infoKey":"结清 ","state":1,"infoValue":"结清"}
             * b : {"createTime":"2017-01-15 00:29:39","infoKey":"签约","state":3,"infoValue":"签约成功"}
             * c : {"createTime":"2017-01-15 00:30:10","infoKey":"放款","state":3,"infoValue":"等待放款"}
             * a : {"createTime":"2017-01-12 16:48:28","infoKey":"信息审核 ","state":3,"infoValue":"审核通过"}
             */

            public DBean d;
            public EBean e;
            public BBean b;
            public CBean c;
            public ABean a;

            public static class DBean {
                /**
                 * createTime : 2017-02-15 10:41:35
                 * infoKey : 还款
                 * state : 3
                 * infoValue : 还款成功
                 */

                public String createTime;
                public String infoKey;
                public int state;
                public String infoValue;
            }

            public static class EBean {
                /**
                 * createTime : 2017-02-15 10:41:35
                 * infoKey : 结清
                 * state : 1
                 * infoValue : 结清
                 */

                public String createTime;
                public String infoKey;
                public int state;
                public String infoValue;
            }

            public static class BBean {
                /**
                 * createTime : 2017-01-15 00:29:39
                 * infoKey : 签约
                 * state : 3
                 * infoValue : 签约成功
                 */

                public String createTime;
                public String infoKey;
                public int state;
                public String infoValue;
            }

            public static class CBean {
                /**
                 * createTime : 2017-01-15 00:30:10
                 * infoKey : 放款
                 * state : 3
                 * infoValue : 等待放款
                 */

                public String createTime;
                public String infoKey;
                public int state;
                public String infoValue;
            }

            public static class ABean {
                /**
                 * createTime : 2017-01-12 16:48:28
                 * infoKey : 信息审核
                 * state : 3
                 * infoValue : 审核通过
                 */

                public String createTime;
                public String infoKey;
                public int state;
                public String infoValue;
            }
        }
    }
}
