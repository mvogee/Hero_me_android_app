package com.matthewvogee.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
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

        setPrimaryPower();
        setSecondaryPower();
        setSuperHero();
        secondaryPowerBtn.setEnabled(false);
        backStroy.setText("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo" +
                "ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient" +
                "montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu," +
                "pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel," +
                "aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a," +
                "venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer" +
                "tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend.");

        startOverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.backToMainScreen();
            }
        });
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

    private void setPrimaryPower() {
        int leftSideImage = 0;
        String powerText = "";
        MainActivity mainActivity = (MainActivity)getActivity();

        this.primaryPowerBtn.setEnabled(false);
        if (mainActivity.getAcquired() == MainActivity.powersAcquired.ACCIDENT) {
            // decide between the accidental powers. placeholder to make sure its working below
            leftSideImage= R.drawable.spiderweb_icon;
            powerText = "Web Slinging";
        } else if (mainActivity.getAcquired() == MainActivity.powersAcquired.GENETICMUTATION) {
            leftSideImage = R.drawable.turtlepower_icon;
            powerText = "Turtle Power";
        } else if (mainActivity.getAcquired() == MainActivity.powersAcquired.BORNWITH) {
            leftSideImage = R.drawable.supermancrest_icon;
            powerText = "Flight";
        }
        this.primaryPowerBtn.setCompoundDrawablesWithIntrinsicBounds(leftSideImage, 0, R.drawable.emptyimage, 0);
        this.primaryPowerBtn.setText(powerText);
    }

    private void setSecondaryPower() {
        MainActivity mainActivity = (MainActivity)getActivity();
        int leftSideImage = 0;
        String powerText = "";

        this.secondaryPowerBtn.setEnabled(false);
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
        this.secondaryPowerBtn.setCompoundDrawablesWithIntrinsicBounds(leftSideImage, 0, R.drawable.emptyimage, 0);
        this.secondaryPowerBtn.setText(powerText);
    }

    private void setSuperHero() {
        String superHeroName = "";
        String primaryPower = "";
        int leftSideImage = 0;
        MainActivity mainActivity = (MainActivity) getActivity();

        if (mainActivity.getType() == MainActivity.powerType.FLIGHT) {
            leftSideImage = R.drawable.supermancrest_icon;
            if (mainActivity.getAcquired() == MainActivity.powersAcquired.ACCIDENT) {
                superHeroName = "JOE DOE";
            } else if (mainActivity.getAcquired() == MainActivity.powersAcquired.GENETICMUTATION) {
                superHeroName = "HUMANTORCH";
            } else if (mainActivity.getAcquired() == MainActivity.powersAcquired.BORNWITH) {
                superHeroName = "SUPERMAN";
            }
        } else if (mainActivity.getType() == MainActivity.powerType.LASERVISION) {
            leftSideImage = R.drawable.laservision_icon;
            if (mainActivity.getAcquired() == MainActivity.powersAcquired.ACCIDENT) {
                superHeroName = "JOE BOE";
            } else if (mainActivity.getAcquired() == MainActivity.powersAcquired.GENETICMUTATION) {
                superHeroName = "CHRONOS";
            } else if (mainActivity.getAcquired() == MainActivity.powersAcquired.BORNWITH) {
                superHeroName = "CYCLOPS";
            }
        } else if (mainActivity.getType() == MainActivity.powerType.LIGHTNING) {
            if (mainActivity.getAcquired() == MainActivity.powersAcquired.ACCIDENT) {
                leftSideImage = R.drawable.lightning_icon;
                superHeroName = "JOE WOE";
            } else if (mainActivity.getAcquired() == MainActivity.powersAcquired.GENETICMUTATION) {
                leftSideImage = R.drawable.lightning_icon;
                superHeroName = "STORM";
            } else if (mainActivity.getAcquired() == MainActivity.powersAcquired.BORNWITH) {
                leftSideImage = R.drawable.thorshammer_icon;
                superHeroName = "THOR";
            }
        } else if (mainActivity.getType() == MainActivity.powerType.TURTLEPOWERS) {
            leftSideImage = R.drawable.turtlepower_icon;
            if (mainActivity.getAcquired() == MainActivity.powersAcquired.ACCIDENT) {
                superHeroName = "NINJA TURTLE 1";
            } else if (mainActivity.getAcquired() == MainActivity.powersAcquired.GENETICMUTATION) {
                superHeroName = "NINJA TURTLE 2";
            } else if (mainActivity.getAcquired() == MainActivity.powersAcquired.BORNWITH) {
                superHeroName = "NINJA TURTLE 3";
            }
        } else if (mainActivity.getType() == MainActivity.powerType.WEBSLINGING) {
            leftSideImage = R.drawable.spiderweb_icon;
            if (mainActivity.getAcquired() == MainActivity.powersAcquired.ACCIDENT) {
                superHeroName = "SPOODERMAN";
            } else if (mainActivity.getAcquired() == MainActivity.powersAcquired.GENETICMUTATION) {
                superHeroName = "SPIDER MAN";
            } else if (mainActivity.getAcquired() == MainActivity.powersAcquired.BORNWITH) {
                superHeroName = "SPIDER PIG";
            }
        } else if (mainActivity.getType() == MainActivity.powerType.SUPERSTRENGTH) {
            leftSideImage = R.drawable.superstrength_icon;
            if (mainActivity.getAcquired() == MainActivity.powersAcquired.ACCIDENT) {
                superHeroName = "HULK";
            } else if (mainActivity.getAcquired() == MainActivity.powersAcquired.GENETICMUTATION) {
                superHeroName = "CAPTAIN AMERICA";
            } else if (mainActivity.getAcquired() == MainActivity.powersAcquired.BORNWITH) {
                leftSideImage = R.drawable.supermancrest_icon;
                superHeroName = "SUPERMAN";
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.superHeroIconImg.setImageDrawable(getResources().getDrawable(leftSideImage, getActivity().getTheme()));
        }
        this.superHeroName.setText(superHeroName);
    }
}
