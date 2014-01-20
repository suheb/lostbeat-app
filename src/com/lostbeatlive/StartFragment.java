package com.lostbeatlive;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StartFragment extends Fragment {
	private Button button1, button2;
	private Animation fadeinanim, fadeinanim_login, fadeinanim_signup, fadeout;
	private ImageView fingerprintIV;
	private TextView your_music, your_id;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_start, container, false);
        button1 = (Button) rootView.findViewById(R.id.button1);
        button2 = (Button) rootView.findViewById(R.id.button2);
        fingerprintIV = (ImageView) rootView.findViewById(R.id.musician_fp_IV);
        your_music = (TextView) rootView.findViewById(R.id.your_music);
        your_id = (TextView) rootView.findViewById(R.id.your_id);
        
        fadeinanim = AnimationUtils.loadAnimation(getActivity(), R.anim.fadeinanim);
        fadeinanim_login = AnimationUtils.loadAnimation(getActivity(), R.anim.fadeinanim_login);
        fadeinanim_signup = AnimationUtils.loadAnimation(getActivity(), R.anim.fadeinanim_signup);
        
        button1.startAnimation(fadeinanim_login);
        button2.startAnimation(fadeinanim_signup);
        
        your_music.startAnimation(fadeinanim);
        your_id.startAnimation(fadeinanim);
        fingerprintIV.startAnimation(fadeinanim);
        return rootView;
    }
    
    public void onDestroyView(){
    	super.onDestroyView();
    	fadeout = AnimationUtils.loadAnimation(getActivity(), R.anim.fadeout);
        
        button1.startAnimation(fadeout);
        button2.startAnimation(fadeout);
        your_music.startAnimation(fadeout);
        your_id.startAnimation(fadeout);
    	
    }
}
