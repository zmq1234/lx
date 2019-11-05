package bw.com.greendao2;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Time:2019/11/5
 * Author:周盟棋
 * Description:
 */
@Entity
public class GreenBean {
    @Id(autoincrement = true)
    private Long id;
    public String name="";
    public String phone="";
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1314300347)
    public GreenBean(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
    @Generated(hash = 1002137420)
    public GreenBean() {
    }
}
