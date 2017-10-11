package hk.ust.cse.comp107x.mygoogleplaces1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Adapter_places extends ArrayAdapter<PlaceModels> {

        public Adapter_places(@NonNull Context context, @NonNull PlaceModels[] objects) {
            super(context, 0, objects);
        }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.activity_place_models,parent,false);
        }
        PlaceModels placesModel = getItem(position);

        ImageView image = (ImageView) convertView.findViewById(R.id.imageView);
        Picasso.with(getContext()).load("https://maps.googleapis.com/maps/api/staticmap?center=0,0&zoom=1&size=100x100&key=AIzaSyBIAa0kYCBEtmt1xWbikqhmq5IzPW5NvXo" + placesModel.getFormat()).into(image);
        TextView mapType = (TextView) convertView.findViewById(R.id.textView);


        return convertView;
    }
}


}
