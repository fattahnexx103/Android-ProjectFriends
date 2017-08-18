package views.AboutViews;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import restappss.neehad.projectfriends.R;

public class AboutListHeaderViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.simple_header_textView)
    TextView headerText;

    public AboutListHeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void populate(String header){
        headerText.setText(header);
    }
}
