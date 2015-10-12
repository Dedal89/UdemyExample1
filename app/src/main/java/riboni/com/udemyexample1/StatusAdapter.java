package riboni.com.udemyexample1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.parse.ParseObject;

import java.util.List;

/**
 * Created by Riboni1989 on 12/10/15.
 */
public class StatusAdapter extends ArrayAdapter<ParseObject> {
    protected Context mContext;
    protected List<ParseObject> mStatus;

    public StatusAdapter(Context context, List<ParseObject> status) {
        super(context, R.layout.homepagecustomlayout, status);
        this.mContext = context;
        this.mStatus = status;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.homepagecustomlayout,null);
            holder = new ViewHolder();
            holder.statusAuthor = (TextView) convertView.findViewById(R.id.usernameHP);
            holder.statusBody = (TextView) convertView.findViewById(R.id.statusHP);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ParseObject statusObject = mStatus.get(position);

        holder.statusAuthor.setText(statusObject.getString("author"));
        holder.statusBody.setText(statusObject.getString("status"));

        return convertView;
    }

    public static class ViewHolder {
        TextView statusAuthor;
        TextView statusBody;

    }

}
