package com.matthewvogee.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.matthewvogee.herome.Activities.MainActivity;
import com.matthewvogee.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BackStoryFragment.StoryOnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BackStoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BackStoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView backStroy;
    private TextView superHeroName;
    private Button startOverBtn;
    private Button primaryPowerBtn;
    private Button secondaryPowerBtn;
    private ImageView superHeroIconImg;


    private StoryOnFragmentInteractionListener mListener;

    public BackStoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BackStoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BackStoryFragment newInstance(String param1, String param2) {
        BackStoryFragment fragment = new BackStoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_back_story, container, false);
        backStroy = view.findViewById(R.id.textView_storyText);
        superHeroName = view.findViewById(R.id.textView_superheroName);
        startOverBtn = view.findViewById(R.id.button_startOver);
        primaryPowerBtn = view.findViewById(R.id.button_primaryPowerDisplay);
        secondaryPowerBtn = view.findViewById(R.id.button_secondaryPower);
        superHeroIconImg = view.findViewById(R.id.imageView_superheroIcon);

        setPrimaryPower(primaryPowerBtn);
        setSecondaryPower(secondaryPowerBtn);
        secondaryPowerBtn.setEnabled(false);
        superHeroName.setText("PLACEHOLDER");
        backStroy.setText("placeholder backstory for this unknown superhero");
        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onBackStoryFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof StoryOnFragmentInteractionListener) {
            mListener = (StoryOnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface StoryOnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onBackStoryFragmentInteraction(Uri uri);
    }

    private void setPrimaryPower(Button primaryPowerBtn) {
        int leftSideImage = 0;
        String powerText = "";
        MainActivity mainActivity = (MainActivity)getActivity();

        primaryPowerBtn.setEnabled(false);
        if (mainActivity.getAcquired() == MainActivity.powersAcquired.ACCIDENT) {
            // decide between the accidental powers. placeholder to make sure its working below
            leftSideImage= R.drawable.spiderweb_icon;
            powerText = "Web Slinging";
        } else if (mainActivity.getAcquired() == MainActivity.powersAcquired.GENETICMUTATION) {
            leftSideImage = R.drawable.turtlepower_icon;
            powerText = "Turtle Power";
            // decide between the genetically mutated powers.
        } else if (mainActivity.getAcquired() == MainActivity.powersAcquired.BORNWITH) {
            // decide between the born with powers.
            leftSideImage = R.drawable.supermancrest_icon;
            powerText = "Flight";
        }
        primaryPowerBtn.setCompoundDrawablesWithIntrinsicBounds(leftSideImage, 0, R.drawable.emptyimage, 0);
        primaryPowerBtn.setText(powerText);
    }

    private void setSecondaryPower(Button secondaryPowerBtn) {
        MainActivity mainActivity = (MainActivity)getActivity();
        int leftSideImage = 0;
        String powerText = "";

        secondaryPowerBtn.setEnabled(false);
        if (mainActivity.getType() == MainActivity.powerType.FLIGHT) {
            powerText = "Flight";
            leftSideImage = R.drawable.supermancrest_icon;
        } else if (mainActivity.getType() == MainActivity.powerType.LASERVISION) {
            powerText = "Laser Vision";
            leftSideImage = R.drawable.laservision_icon;
        } else if (mainActivity.getType() == MainActivity.powerType.LIGHTNING) {
            powerText = "Lightning";
            leftSideImage = R.drawable.thorshammer_icon;
        } else if (mainActivity.getType() == MainActivity.powerType.TURTLEPOWERS) {
            powerText = "Turtle Power";
            leftSideImage = R.drawable.turtlepower_icon;
        } else if (mainActivity.getType() == MainActivity.powerType.WEBSLINGING) {
            powerText = "Web Slinging";
            leftSideImage = R.drawable.spiderweb_icon;
        } else if (mainActivity.getType() == MainActivity.powerType.SUPERSTRENGTH) {
            powerText = "Super Strength";
            leftSideImage = R.drawable.superstrength_icon;
        }
        secondaryPowerBtn.setCompoundDrawablesWithIntrinsicBounds(leftSideImage, 0, R.drawable.emptyimage, 0);
        secondaryPowerBtn.setText(powerText);
    }
}
