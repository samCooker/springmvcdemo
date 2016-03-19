package cn.com.cookie.common.reference;

/**
 * Created by Cookie on 2016/3/19.
 */
public enum AppValid {
    无效("0","invalid"),有效("1","valid");

    private String key;
    private String value;

    private AppValid(String key){
        this(key,null);
    }

    private AppValid(String key,String value){
        this.key = key;
        this.value = value;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return this.value==null?this.name():this.value;
    }

}
