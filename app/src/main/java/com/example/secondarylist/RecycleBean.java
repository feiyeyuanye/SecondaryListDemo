package com.example.secondarylist;



public class RecycleBean {

    private boolean isGroup;

    private String isType;

    private OneBean oneBean;

    private OtherBean otherBeanList;

    public RecycleBean(boolean isGroup) {
        this.isGroup=isGroup;
    }

    public static class OneBean {
        private String strOne;

        public String getStrOne() {
            return strOne == null ? "" : strOne;
        }

        public void setStrOne(String strOne) {
            this.strOne = strOne;
        }
    }

    public static class OtherBean {
      private String strOther;

        public String getStrOther() {
            return strOther == null ? "" : strOther;
        }

        public void setStrOther(String strOther) {
            this.strOther = strOther;
        }
    }

    public boolean isGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }

    public String getIsType() {
        return isType == null ? "" : isType;
    }

    public void setIsType(String isType) {
        this.isType = isType;
    }

    public OneBean getOneBean() {
        return oneBean;
    }

    public void setOneBean(OneBean oneBean) {
        this.oneBean = oneBean;
    }

    public OtherBean getOtherBeanList() {
        return otherBeanList;
    }

    public void setOtherBeanList(OtherBean otherBeanList) {
        this.otherBeanList = otherBeanList;
    }
}
