package site.lovecode.boot.util;

/**
 * Created by yang peng on 2016/9/30.
 */
public class ApiResponse<T> {


    private Integer code;


    private String error;


    private T date;


    public void setDate(T date) {
        this.date = date;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getDate() {
        return date;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiResponse{");
        sb.append("code=").append(code);
        sb.append(", error='").append(error).append('\'');
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }
}
