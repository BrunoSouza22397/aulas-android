package bruno.souza.exarrayadapterdog.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import bruno.souza.exarrayadapterdog.R;
import bruno.souza.exarrayadapterdog.model.Dog;

public class DogAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<Dog> dogs;
    private LayoutInflater inflater;

    public DogAdapter(Context context, ArrayList<Dog> dogs) {
        this.context = context;
        this.dogs = dogs;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dogs.size();
    }

    @Override
    public Dog getItem(int position) {
        return dogs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
            convertView = inflater.inflate(R.layout.line_dog, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Dog d = getItem(position);

        holder.tvRace.setText("Raça: "+d.getRace());
        holder.tvAge.setText("Idade: "+d.getAge());
        holder.tvRealAge.setText("Idade Real: "+d.calcDogAge());

        return convertView;
    }
    static class ViewHolder{
        private TextView tvRace;
        private TextView tvAge;
        private TextView tvRealAge;

        public ViewHolder(View v) {
            this.tvRace = v.findViewById(R.id.ld_tv_race);
            this.tvAge = v.findViewById(R.id.ld_tv_age);
            this.tvRealAge = v.findViewById(R.id.ld_tv_real_age);
        }
    }
}
