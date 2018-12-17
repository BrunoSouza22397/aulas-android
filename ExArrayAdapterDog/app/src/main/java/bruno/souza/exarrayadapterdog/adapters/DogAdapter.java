package bruno.souza.exarrayadapterdog.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;

import bruno.souza.exarrayadapterdog.R;
import bruno.souza.exarrayadapterdog.model.Dog;

public class DogAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Dog> dogs;
    private static ClickListener clickListener;

    public DogAdapter(Context context, ArrayList<Dog> dogs) {
        this.context = context;
        this.dogs = dogs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.line_dog, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder hold = (ViewHolder) holder;
        Dog dog = dogs.get(position);

        hold.tvRace.setText("Raça: "+dog.getRace());
        hold.tvAge.setText("Idade: "+dog.getAge());
        hold.tvRealAge.setText("Idade Real: "+dog.calcDogAge());
    }

    @Override
    public int getItemCount() {
        return dogs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        final TextView tvRace;
        final TextView tvAge;
        final TextView tvRealAge;

        public ViewHolder(View v) {
            super(v);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            tvRace = v.findViewById(R.id.ld_tv_race);
            tvAge = v.findViewById(R.id.ld_tv_age);
            tvRealAge = v.findViewById(R.id.ld_tv_real_age);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(v, getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(v, getAdapterPosition());
            return true;
        }
    }
    public void setOnItemClickListener(ClickListener clickListener){
        DogAdapter.clickListener = clickListener;
    }
    public interface ClickListener{
        void onItemClick(View v, int position);
        void onItemLongClick(View v, int position);
    }
}
