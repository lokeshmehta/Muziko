package com.muziko.fragments.Intro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.muziko.R;


public class Intro3 extends android.support.v4.app.Fragment {

	public Intro3() {
		// Required empty public constructor
	}

	public static Intro3 newInstance() {
		return new Intro3();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
		}

	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_intro, container, false);

        ImageView introIcon = rootView.findViewById(R.id.introIcon);

        TextView introText = rootView.findViewById(R.id.introText);
        TextView introExplain = rootView.findViewById(R.id.introExplain);

		introIcon.setImageResource(R.drawable.intro3);
		introText.setText(R.string.cutter);
		introExplain.setText(R.string.cutter_desc);

		return rootView;
	}


}
