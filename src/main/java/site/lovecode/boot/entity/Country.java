package site.lovecode.boot.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yang peng on 2016/9/29.
 */
@Entity
@Table(name="country")
@ApiModel
public class Country implements Serializable{

    @Id
    @GeneratedValue
    @ApiModelProperty(value = "群组的Id", required = true)
    private Integer id;

    @Column
    @ApiModelProperty(value = "群组的Id", required = true)
    private String countryname;


    @ApiModelProperty(value = "群组的Id", required = true)
    private String countrycode;


    @Column(name= "create_time")
    @JSONField(serialize=false)
    @ApiModelProperty(value="创建时间",required = true)
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Country{");
        sb.append("id=").append(id);
        sb.append(", countryname='").append(countryname).append('\'');
        sb.append(", countrycode='").append(countrycode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
