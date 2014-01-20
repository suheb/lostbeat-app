package com.lostbeatlive;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;

public class LoginFragment extends Fragment {
	private ScrollView scrollview;
	private Animation fadeinanim;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	View rootView=inflater.inflate(R.layout.fragment_login, container, false);
    	scrollview = (ScrollView) rootView.findViewById(R.id.scrollView1);
    	
    	fadeinanim = AnimationUtils.loadAnimation(getActivity(), R.anim.fadeinanim);
    	
    	scrollview.startAnimation(fadeinanim);
    	
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
}
