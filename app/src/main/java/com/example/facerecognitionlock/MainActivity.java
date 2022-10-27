package com.example.facerecognitionlock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;


import com.google.firebase.auth.FirebaseAuth;

/*public class MainActivity extends AppCompatActivity {

private FirebaseAuth mFirebaseAuth;


@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

mFirebaseAuth = FirebaseAuth.getInstance();

Button btn_logout = findViewById(R.id.btn_logout);
btn_logout.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view)
{
mFirebaseAuth.signOut();

Intent intent = new Intent(MainActivity.this, LoginActivity.class);
startActivity(intent);

finish();
}
});

//탈퇴처리
// mFirebaseAuth.getCurrentUser().delete();
}
}*/



public class MainActivity extends FragmentActivity {

    TabLayout tabs;

    Fragment_Lock fragment1;
    Fragment_userManagement fragment2;
    Fragment_visitors fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment_Lock();
        fragment2 = new Fragment_userManagement();
        fragment3 = new Fragment_visitors();

        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragment1).commit();

        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("도어락 제어"));
        tabs.addTab(tabs.newTab().setText("사용자 목록"));
        tabs.addTab(tabs.newTab().setText("출입기록"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selected = null;
                if(position == 0)
                    selected = fragment1;
                else if(position == 1)
                    selected = fragment2;
                else if(position == 2)
                    selected = fragment3;
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}