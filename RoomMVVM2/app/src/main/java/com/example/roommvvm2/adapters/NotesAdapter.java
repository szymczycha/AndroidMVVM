package com.example.roommvvm2.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.roommvvm2.databinding.GridviewitemBinding;
import com.example.roommvvm2.viewmodel.NotesViewModel;

public class NotesAdapter extends BaseAdapter {
    private NotesViewModel notesViewModel;
    private LayoutInflater layoutInflater;
    private final String TAG = "XXX";

    public NotesAdapter(NotesViewModel notesViewModel){
        this.notesViewModel = notesViewModel;
    }

    @Override
    public int getCount(){
        return notesViewModel.getObservedNotes().getValue().size();//count listy notatek
    }

    @Override
    public Object getItem(int i){
        return notesViewModel.getObservedNotes().getValue().get(i); //i-ta notatka
    }

    @Override
    public long getItemId(int i){
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View root = convertView;

        GridviewitemBinding binding;
        Log.d(TAG, "getView: " + position);
        if(root == null) {
            if(layoutInflater == null){
                layoutInflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            binding = GridviewitemBinding.inflate(layoutInflater, viewGroup, false);
            root = binding.getRoot();

            root.setTag(binding);
            Log.d(TAG, "getView: " + root);
        }else{
            binding = (GridviewitemBinding) root.getTag();

        }
        binding.deleteButton.setOnClickListener(v->{
            notesViewModel.deleteNote(notesViewModel.getObservedNotes().getValue().get(position));
        });

        binding.setNote(notesViewModel.getObservedNotes().getValue().get(position));

        return root;
    }
}
