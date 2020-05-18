package com.example.demoapp;

import android.annotation.TargetApi;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    private boolean active;
    CheckBox checkBox;
    ListView list;
    Button btn;
    Fragment fragment;
  //  ArrayList <String> data=new ArrayList <>();
    String[] data={"soap", "sugar", "biscuit", "parle g", "Unibic", "Tide","India", "China", "australia", "Portugle", "America", "NewZealand" };
    String img[]={"R.drawable.apps","R.drawable.apps","R.drawable.apps","R.drawable.apps","R.drawable.apps","R.drawable.apps"};

    public BlankFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_blank, null);
        list = v.findViewById(R.id.list);
        btn = v.findViewById(R.id.chkbutton);
        //final ArrayAdapter <String> arrayAdapter;
        final ArrayAdapter <String> arrayAdapter = new ArrayAdapter <String>(getActivity(), R.layout.listview, R.id.listdata, data);
        list.setAdapter(arrayAdapter);

//   this.list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
//       this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i("tag", "onItemClick: " +position);
//                CheckedTextView v = (CheckedTextView) view;
//                boolean currentCheck = v.isChecked();
//                String user = (String) list.getItemAtPosition(position);
//              // arrayAdapter.setActive(!currentCheck);
//            }
        //       });
//        for(int i=0;i< data.length; i++ ) {
//            this.list.setItemChecked(i, arrayAdapter[i].isActive());
//        }
//        list.setAdapter(arrayAdapter);
//
////
//        list.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
//
//        list.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
//            @Override
//            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
//
//                mode.setTitle(""+list.getCheckedItemCount()+" items selected");
//
//            }
//
//            @Override
//            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
//                MenuInflater menuInflater = mode.getMenuInflater();
//                menuInflater.inflate(R.menu.menu_contextual_actionbar,menu);
//                return true;
//            }
//
//            @Override
//            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
//                return false;
//            }
//
//            @Override
//            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//                switch (item.getItemId()){
//
//                    case R.id.menu_delete:
//
////action on clicking contextual action bar menu item
//
//                        SparseBooleanArray checkedItems = list.getCheckedItemPositions();
//                        for(int i =0;i<checkedItems.size();i++){
//
//                            if(checkedItems.valueAt(i) == true){
//
//                                data.remove(i);
//
//                            }
//                        }
//                        arrayAdapter.notifyDataSetChanged();
//
//                        mode.finish();
//                }
//                return true;
//            }
//
//            @Override
//            public void onDestroyActionMode(ActionMode mode) {
//
//            }
//        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new PaymentFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
       // list.setItemChecked(2, true);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView <?> adpterView, View view, int position,
                                    long id) {

                int d = 0;


                for (int i = 0; i < list.getChildCount(); i++) {
                    if (position == i) {
                        d = d + 1;
                        list.getChildAt(i).setBackgroundColor(Color.BLUE);
                        btn.setText("Buy" + " " + d + " Items");
                    } else {
                        list.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
                }
            }
        });
        return v;

    }

    }



            // Inflate the layout for this fragment


