package test.valeriano.mx.empaquetado.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import test.valeriano.mx.empaquetado.DetailActivity;
import test.valeriano.mx.empaquetado.R;
import test.valeriano.mx.empaquetado.adapter.AdapterItemList;
import test.valeriano.mx.empaquetado.model.ModelItem;

/**
 * Created by luis.valeriano on 18/06/2016.
 */
public class FragmentList extends Fragment{

    private ListView listView;
    private List<ModelItem> array = new ArrayList<>();
    private int counter;
    private boolean isWifi;
    public static final String CADENA_DE_CONTROL = "M";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list,container, false);
        listView = (ListView) view.findViewById(R.id.frmListItems);
        listView.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    AdapterItemList adapter= (AdapterItemList) parent.getAdapter();
                    ModelItem modelItem =adapter.getItem(position);
                    ModelItem modelItem2 = array.get(position);
                    Toast.makeText(getActivity(),modelItem2.item,Toast.LENGTH_SHORT).show();
                }
            }
        );
        final EditText mItemsText = (EditText) view.findViewById(R.id.frmItemText);
        view.findViewById(R.id.frmBtnAddItem).setOnClickListener(
            new View.OnClickListener() {


                public void onClick(View v) {
                    String itemData = mItemsText.getText().toString();
                    if (!TextUtils.isEmpty(itemData)) {
                        ModelItem item = new ModelItem();
                        item.item = itemData;
                        item.id = "Description más counter " + counter;
                        String usrInicial = itemData.toUpperCase().substring(0,1);
                        isWifi = (CADENA_DE_CONTROL.compareTo(usrInicial)<0)?true:false;

                        item.resourceId = isWifi ? R.drawable.ic_device_signal_wifi_4_bar : R.drawable.ic_action_settings_voice;
                        array.add(item);
                        listView.setAdapter(new AdapterItemList(getActivity(), array));
                        //isWifi = !isWifi;
                        counter++;
                        mItemsText.setText("");
                    } else {
                        Toast.makeText(getActivity(),R.string.empty_list,Toast.LENGTH_SHORT).show();

                    }
                }
            }
        );

        return view;
    }

}
