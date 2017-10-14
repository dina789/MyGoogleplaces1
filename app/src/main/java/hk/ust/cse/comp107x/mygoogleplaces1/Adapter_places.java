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

import hk.ust.cse.comp107x.mygoogleplaces1.models.PlaceModels;

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
        //Picasso.with(context).load(src).into(imageView );
        Picasso.with(getContext()).load("maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=CnRtAAAATLZNl354RwP_9UKbQ_5Psy40texXePv4oAlgP4qNEkdIrkyse7rPXYGd9D_Uj1rVsQdWT4oRz4QrYAJNpFX7rzqqMlZw2h2E2y5IKMUZ7ouD_SlcHxYq1yL4KbKUv3qtWgTK0A6QbGh87GB3sscrHRIQiG2RrmU_jF4tENr9wGS_YxoUSSDrYjWmrNfeEHSGSc3FyhNLlBU&key=AIzaSyB3eBGcB57xsUEM9zrpblxU-KvEhEKE1EA" + placesModel.getFormat()).into(image);
        TextView mapType = (TextView) convertView.findViewById(R.id.textView);
        //"http://maps.google.com/maps/api/staticmap?center=" + latEiffelTower + "," + lngEiffelTower + "&zoom=15&size=200x200&sensor=true";


        return convertView;
    }
}



