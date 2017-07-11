package com.matthewvogee.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.matthewvogee.herome.Activities.MainActivity;
import com.matthewvogee.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerFragment.PickOnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowerFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button turtlePowerButton;
    private Button lightningButton;
    private Button flightButton;
    private Button websligningButton;
    private Button laserVisionButton;
    private Button superStrenghtButton;
    private Button showBackstoryButton;

    private PickOnFragmentInteractionListener mListener;

    public PickPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickPowerFragment newInstance(String param1, String param2) {
        PickPowerFragment fragment = new PickPowerFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pick_power, container, false);
        turtlePowerButton = view.findViewById(R.id.button_turtlePowers);
        lightningButton = view.findViewById(R.id.button_lightning);
        flightButton = view.findViewById(R.id.button_flight);
        websligningButton = view.findViewById(R.id.button_webSlinging);
        laserVisionButton = view.findViewById(R.id.button_laserVision);
        superStrenghtButton = view.findViewById(R.id.button_superStrength);
        showBackstoryButton = view.findViewById(R.id.button_showBackstory);

        showBackstoryButton.getBackground().setAlpha(128);
        showBackstoryButton.setEnabled(false);
        turtlePowerButton.setOnClickListener(this);
        lightningButton.setOnClickListener(this);
        flightButton.setOnClickListener(this);
        websligningButton.setOnClickListener(this);
        laserVisionButton.setOnClickListener(this);
        superStrenghtButton.setOnClickListener(this);
        showBackstoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadBackstoryFragment();
            }
        });
        return view;
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button)view;
        int leftDrawable = 0;
        MainActivity mainActivity = (MainActivity)getActivity();

        showBackstoryButton.setEnabled(true);
        showBackstoryButton.getBackground().setAlpha(255);
        turtlePowerButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtlepower_icon, 0, R.drawable.emptyimage, 0);
        lightningButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.thorshammer_icon, 0, R.drawable.emptyimage,0 );
        flightButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.supermancrest_icon, 0, R.drawable.emptyimage, 0);
        websligningButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spiderweb_icon, 0, R.drawable.emptyimage, 0);
        laserVisionButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laservision_icon, 0, R.drawable.emptyimage, 0);
        superStrenghtButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.superstrength_icon, 0, R.drawable.emptyimage, 0);
        if (btn == turtlePowerButton) {
            mainActivity.setType(MainActivity.powerType.TURTLEPOWERS);
            leftDrawable = R.drawable.turtlepower_icon;
        } else if (btn == lightningButton){
            mainActivity.setType(MainActivity.powerType.LIGHTNING);
            leftDrawable = R.drawable.thorshammer_icon;
        } else if (btn == flightButton) {
            mainActivity.setType(MainActivity.powerType.FLIGHT);
            leftDrawable = R.drawable.supermancrest_icon;
        } else if (btn == websligningButton) {
            mainActivity.setType(MainActivity.powerType.WEBSLINGING);
            leftDrawable = R.drawable.spiderweb_icon;
        } else if (btn == laserVisionButton) {
            mainActivity.setType(MainActivity.powerType.LASERVISION);
            leftDrawable = R.drawable.laservision_icon;
        } else if (btn == superStrenghtButton) {
            mainActivity.setType(MainActivity.powerType.SUPERSTRENGTH);
            leftDrawable = R.drawable.superstrength_icon;
        }
        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable, 0, R.drawable.item_selected_btn, 0);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onPickPowerFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickOnFragmentInteractionListener) {
            mListener = (PickOnFragmentInteractionListener) context;
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
    public interface PickOnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onPickPowerFragmentInteraction(Uri uri);
    }
}
