package com.example.neteasecloudmusic.logic.network.entities;

import java.io.Serializable;

/**
 * @Author winiymissl
 * @Date 2023-11-04 18:55
 * @Version 1.0
 */
public class LoginResult {
    public class QrcodeKeyResult extends BaseResult {
        QrcodeKeyBean data;

        public QrcodeKeyBean getData() {
            return data;
        }


        public void setData(QrcodeKeyBean data) {
            this.data = data;
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
        String unikey;

        public String getUnikey() {
            return unikey;
        }

        public void setUnikey(String key) {
            this.unikey = unikey;
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

        @Override
        public boolean resultOk() {
            return 803 == code;
        }

        public String getCookie() {
            return cookie;
        }

        public void setCookie(String cookie) {
            this.cookie = cookie;
        }
    }

    public class AccountInfoResult extends BaseResult {
        AccountBean account;
        ProfileBean profile;

        public AccountBean getAccount() {
            return account;
        }

        public void setAccount(AccountBean account) {
            this.account = account;
        }

        public ProfileBean getProfile() {
            return profile;
        }

        public void setProfile(ProfileBean profile) {
            this.profile = profile;
        }
    }

    public class AccountBean {
        @Override
        public String toString() {
            return "AccountBean{" + "id=" + id + ", userName='" + userName + '\'' + ", type=" + type + ", status=" + status + ", whitelistAuthority=" + whitelistAuthority + ", createTime=" + createTime + ", tokenVersion=" + tokenVersion + ", ban=" + ban + ", baoyueVersion=" + baoyueVersion + ", donateVersion=" + donateVersion + ", vipType=" + vipType + ", viptypeVersion=" + viptypeVersion + ", anonimousUser=" + anonimousUser + '}';
        }

        long id;
        String userName;
        int type;
        int status;
        int whitelistAuthority;
        long createTime;
        int tokenVersion;
        int ban;
        int baoyueVersion;
        int donateVersion;
        int vipType;
        double viptypeVersion;
        boolean anonimousUser;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getWhitelistAuthority() {
            return whitelistAuthority;
        }

        public void setWhitelistAuthority(int whitelistAuthority) {
            this.whitelistAuthority = whitelistAuthority;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getTokenVersion() {
            return tokenVersion;
        }

        public void setTokenVersion(int tokenVersion) {
            this.tokenVersion = tokenVersion;
        }

        public int getBan() {
            return ban;
        }

        public void setBan(int ban) {
            this.ban = ban;
        }

        public int getBaoyueVersion() {
            return baoyueVersion;
        }

        public void setBaoyueVersion(int baoyueVersion) {
            this.baoyueVersion = baoyueVersion;
        }

        public int getDonateVersion() {
            return donateVersion;
        }

        public void setDonateVersion(int donateVersion) {
            this.donateVersion = donateVersion;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public double getViptypeVersion() {
            return viptypeVersion;
        }

        public void setViptypeVersion(double viptypeVersion) {
            this.viptypeVersion = viptypeVersion;
        }

        public boolean isAnonimousUser() {
            return anonimousUser;
        }

        public void setAnonimousUser(boolean anonimousUser) {
            this.anonimousUser = anonimousUser;
        }


    }

    public class ProfileBean {
        @Override
        public String toString() {
            return "ProfileBean{" + "followed=" + followed + ", userId=" + userId + ", defaultAvatar=" + defaultAvatar + ", avatarUrl='" + avatarUrl + '\'' + ", nickname='" + nickname + '\'' + ", birthday=" + birthday + ", province=" + province + ", accountStatus=" + accountStatus + ", vipType=" + vipType + ", gender=" + gender + ", djStatus=" + djStatus + ", mutual=" + mutual + ", authStatus=" + authStatus + ", backgroundImgId=" + backgroundImgId + ", userType=" + userType + ", city=" + city + ", backgroundUrl='" + backgroundUrl + '\'' + ", followeds=" + followeds + ", follows=" + follows + ", eventCount=" + eventCount + ", playlistCount=" + playlistCount + ", playlistBeSubscribedCount=" + playlistBeSubscribedCount + '}';
        }

        boolean followed;
        long userId;
        boolean defaultAvatar;
        String avatarUrl;
        String nickname;
        long birthday;
        int province;
        int accountStatus;
        int vipType;
        int gender;
        int djStatus;
        boolean mutual;
        int authStatus;
        long backgroundImgId;
        int userType;
        int city;
        String backgroundUrl;
        int followeds;
        int follows;
        int eventCount;
        int playlistCount;
        int playlistBeSubscribedCount;

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public boolean isDefaultAvatar() {
            return defaultAvatar;
        }

        public void setDefaultAvatar(boolean defaultAvatar) {
            this.defaultAvatar = defaultAvatar;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public int getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(int accountStatus) {
            this.accountStatus = accountStatus;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
        }

        public boolean isMutual() {
            return mutual;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public int getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(int authStatus) {
            this.authStatus = authStatus;
        }

        public long getBackgroundImgId() {
            return backgroundImgId;
        }

        public void setBackgroundImgId(long backgroundImgId) {
            this.backgroundImgId = backgroundImgId;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public String getBackgroundUrl() {
            return backgroundUrl;
        }

        public void setBackgroundUrl(String backgroundUrl) {
            this.backgroundUrl = backgroundUrl;
        }

        public int getFolloweds() {
            return followeds;
        }

        public void setFolloweds(int followeds) {
            this.followeds = followeds;
        }

        public int getFollows() {
            return follows;
        }

        public void setFollows(int follows) {
            this.follows = follows;
        }

        public int getEventCount() {
            return eventCount;
        }

        public void setEventCount(int eventCount) {
            this.eventCount = eventCount;
        }

        public int getPlaylistCount() {
            return playlistCount;
        }

        public void setPlaylistCount(int playlistCount) {
            this.playlistCount = playlistCount;
        }

        public int getPlaylistBeSubscribedCount() {
            return playlistBeSubscribedCount;
        }

        public void setPlaylistBeSubscribedCount(int playlistBeSubscribedCount) {
            this.playlistBeSubscribedCount = playlistBeSubscribedCount;
        }
    }
}
