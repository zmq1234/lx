package bw.com.greendao2;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private SQLiteDatabase sqLiteDatabase;
    private DaoMaster.DevOpenHelper devOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData() {

        initGreendao();
    }

    /**
     * 初始化greendao数据
     */
    private void initGreendao() {


        devOpenHelper = new DaoMaster.DevOpenHelper(this, "wdmall.db", null);
        sqLiteDatabase = devOpenHelper.getWritableDatabase();

        daoMaster = new DaoMaster(sqLiteDatabase);
        daoSession = daoMaster.newSession();

    }


    public void query(View view) {

        List<GreenBean> userEntities = daoSession.loadAll(GreenBean.class);
        System.out.println("size:"+userEntities.size());
        System.out.println("name:"+userEntities.get(0).name);

    }

    GreenBean userEntity;
    public void update(View view) {
        userEntity.name ="sdddfdfdf";
        daoSession.update(userEntity);

    }

    public void delete(View view) {

        daoSession.delete(userEntity);
    }

    public void add(View view) {

        userEntity = new GreenBean();
        userEntity.name = "kson";
        userEntity.phone = "100";
        daoSession.insert(userEntity);

    }
}