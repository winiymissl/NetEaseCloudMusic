package com.example.neteasecloudmusic.logic.network.entities;

/**
 * @Author winiymissl
 * @Date 2023-11-04 18:55
 * @Version 1.0
 */
public class LoginResult {
    public class QrcodeKeyResult extends BaseResult {
        QrcodeKeyBean data;

        public QrcodeKeyBean getBean() {
            return data;
        }


        public void setBean(QrcodeKeyBean bean) {
            this.data = bean;
        }
    }

    public class QrcodeValueResult extends BaseResult {
        QrcodeValueBean data;

        public QrcodeValueBean getBean() {
            return data;
        }

        public void setBean(QrcodeValueBean bean) {
            this.data = bean;
        }
    }

    public class QrcodeKeyBean {
        String key;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    public class QrcodeValueBean {
        String qrurl;
        String qrimg;

        public String getQrurl() {
            return qrurl;
        }

        public void setQrurl(String qrurl) {
            this.qrurl = qrurl;
        }

        public String getQrimg() {
            return qrimg;
        }

        public void setQrimg(String qrimg) {
            this.qrimg = qrimg;
        }
    }

    public class QrcodeAuthResult extends BaseResult {
        String cookie;

        public String getCookie() {
            return cookie;
        }

        public void setCookie(String cookie) {
            this.cookie = cookie;
        }
    }


}
