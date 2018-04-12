package com.darly.darlyview.ui.grav;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.darly.darlyview.R;
import com.darly.darlyview.wedget.grav.GravView;

public class GravSampleFragment extends Fragment {
  public static final String KEY_LAYOUT = "KEY_LAYOUT";
  private int layout;
  GravView gravView;

  public static GravSampleFragment newInstance(int layout) {
    Bundle args = new Bundle();
    args.putInt(KEY_LAYOUT, layout);
    GravSampleFragment fragment = new GravSampleFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    layout = getArguments().getInt(KEY_LAYOUT);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View root = inflater.inflate(layout, container, false);
    gravView = (GravView) root.findViewById(R.id.grav);
    return root;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }


  @Override
  public void onDestroy() {
    super.onDestroy();
    gravView.stop();
  }
}
