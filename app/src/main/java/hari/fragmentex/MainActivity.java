package hari.fragmentex;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FrameLayout fragment_fl;
    private Button attach_btn, replace_one_with_two,remove_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment_fl = (FrameLayout) findViewById(R.id.fragment_fl);

        attach_btn = (Button) findViewById(R.id.attach_one);
        attach_btn.setOnClickListener(this);

        replace_one_with_two = (Button) findViewById(R.id.replace_one_with_two);
        replace_one_with_two.setOnClickListener(this);

        remove_one = (Button) findViewById(R.id.remove_one);
        remove_one.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (id) {
            case R.id.attach_one:
                FragmentOne fragmentOne = new FragmentOne();
                fragmentTransaction.add(R.id.fragment_fl, fragmentOne, "FragmentOne");
                break;
            case R.id.replace_one_with_two:
                FragmentTwo fragmentTwo = new FragmentTwo();
                fragmentTransaction.replace(R.id.fragment_fl, fragmentTwo, "FragmentTwo");
                break;
            case R.id.remove_one:
                FragmentOne fragment = (FragmentOne) fragmentManager.findFragmentByTag("FragmentOne");
                if (fragment != null)
                    fragmentTransaction.remove(fragment);
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
    }
}
