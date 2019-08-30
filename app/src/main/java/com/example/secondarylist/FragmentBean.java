package com.example.secondarylist;

import java.util.ArrayList;
import java.util.List;

public class FragmentBean {

    private String code;

    private String message;

    private ObjectBean object;

    public static class ObjectBean {

        private OneBean oneBean;

        private List<OtherBean> otherBeanList;

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

        public OneBean getOneBean() {
            return oneBean;
        }

        public void setOneBean(OneBean oneBean) {
            this.oneBean = oneBean;
        }

        public List<OtherBean> getOtherBeanList() {
            if (otherBeanList == null) {
                return new ArrayList<>();
            }
            return otherBeanList;
        }

        public void setOtherBeanList(List<OtherBean> otherBeanList) {
            this.otherBeanList = otherBeanList;
        }
    }

    public String getCode() {
        return code == null ? "" : code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message == null ? "" : message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }
}
