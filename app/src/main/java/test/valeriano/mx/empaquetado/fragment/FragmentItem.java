package test.valeriano.mx.empaquetado.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.valeriano.mx.empaquetado.R;

/**
 * Created by luis.valeriano on 18/06/2016.
 */
public class FragmentItem extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item,container,false);
        return view;
    }
}
