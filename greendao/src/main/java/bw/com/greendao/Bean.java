package bw.com.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

/**
 * Time:2019/11/5
 * Author:周盟棋
 * Description:
 */
@Entity
public class Bean {
    @Id
    private Long id;
    public String name = "";
    public String phone = "";
}
