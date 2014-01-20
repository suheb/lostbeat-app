package com.lostbeatlive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;

public class LoginActivity extends FragmentActivity {
	private FragmentManager fragmentManager;
	private Fragment fragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		// Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.loginFragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            fragment = new StartFragment();
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
					.add(R.id.loginFragment_container, fragment).commit();
        }
             
        
	}

	public void changeLoginFragment(View v){
		fragment = new LoginFragment();
		fragmentManager.beginTransaction()
				.setCustomAnimations(R.anim.loginfadeinanim, R.anim.abc_fade_out, R.anim.fadeinanim, R.anim.abc_fade_out)
				.replace(R.id.loginFragment_container, fragment).addToBackStack(null).commit();
	}
	
	public void startMainActivity(View v){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

}
