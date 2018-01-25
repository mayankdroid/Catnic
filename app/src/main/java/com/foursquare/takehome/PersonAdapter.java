package com.foursquare.takehome;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


public final class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    private List<Person> visitors ;
    private WeakReference<Context> contextWeakReference ;


    public PersonAdapter(Context context , List<Person> visitors){
        this.visitors = visitors ;
        this.contextWeakReference = new WeakReference<Context>(context) ;
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder{
        public TextView visitorName , visitorTime ;

        public PersonViewHolder(View visitorView) {
            super(visitorView);
            visitorName = itemView.findViewById(R.id.visitor_name);
            visitorTime = itemView.findViewById(R.id.visitor_time);
        }
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View visitorView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.visitors_info, parent, false);

        return new PersonViewHolder(visitorView);

    }



    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        Person person =  visitors.get(position);
        holder.visitorName.setText(person.getName());
        Resources res = contextWeakReference.get().getResources();
        String startTime = Utils.getTime(person.getArriveTime());
        String endTime = Utils.getTime(person.getLeaveTime());
        String timeInterval = res.getString(R.string.timestamp, startTime, endTime);
        holder.visitorTime.setText(timeInterval);
    }

    @Override
    public int getItemCount() {
        return visitors.size();
    }
}
