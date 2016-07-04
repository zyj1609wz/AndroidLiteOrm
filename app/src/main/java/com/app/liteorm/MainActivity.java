package com.app.liteorm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TestModel testModel = new TestModel() ;
        testModel.setId( 1001 ) ;
        testModel.setName( "jack" ) ;
        testModel.setPassword( "123456" ) ;
        testModel.setLogin( true );

        TestModel testMode2 = new TestModel() ;
        testMode2.setId( 1002 ) ;
        testMode2.setName( "jack2" ) ;
        testMode2.setPassword( "123456" ) ;
        testMode2.setLogin( false );

        final List<TestModel> list = new ArrayList<>() ;
        list.add( testModel ) ;
        list.add( testMode2 ) ;


        //插入一条数据
        DatabaseManager.getInstance().insert( testModel ) ;

        //插入一个集合
        DatabaseManager.getInstance().insertAll( list ) ;

        //查询所有
        List<TestModel> queryList = DatabaseManager.getInstance().getQueryAll( TestModel.class ) ;

        //删除一个数据
        findViewById( R.id.delete_object ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseManager.getInstance().delete( testModel );
            }
        });

        //删除一个集合
        findViewById( R.id.delete_database ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseManager.getInstance().deleteList( list );
            }
        });

        //删除一个表
        findViewById( R.id.delete_table ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseManager.getInstance().delete( TestModel.class );
            }
        });

        //删除整个数据库
        findViewById( R.id.delete_database ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseManager.getInstance().deleteDatabase();
            }
        });
    }
}
