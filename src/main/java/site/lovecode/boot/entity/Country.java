package site.lovecode.boot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

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

    @Column
    @ApiModelProperty(value = "群组的Id", required = true)
    private String countrycode;


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
