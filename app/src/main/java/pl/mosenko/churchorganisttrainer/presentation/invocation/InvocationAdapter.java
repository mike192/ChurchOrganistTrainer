package pl.mosenko.churchorganisttrainer.presentation.invocation;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.mosenko.churchorganisttrainer.R;

/**
 * Created by syk on 16.12.17.
 */

public class InvocationAdapter extends RecyclerView.Adapter<InvocationAdapter.InvocationViewHolder> {

    private List<InvocationModel> invocationModels;
    private OnItemClickListener onItemClickListener;

    @Override
    public InvocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.invocation_item, parent, false);
        return new InvocationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(InvocationViewHolder holder, int position) {
        holder.bindData(invocationModels.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return invocationModels != null ? invocationModels.size() : 0;
    }

    public void setInvocationModels(@NonNull List<InvocationModel> invocationModels) {
        this.invocationModels = invocationModels;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(@NonNull OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    interface OnItemClickListener {
        void onItemClick(InvocationModel invocationModel);
    }

    static class InvocationViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.invocationNameTV)
        protected TextView invocationNameTV;

        @BindView(R.id.successfulResponsePercentageTV)
        protected TextView successfulResponsePercentageTV;

        public InvocationViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @SuppressLint("DefaultLocale")
        void bindData(InvocationModel invocationModel, OnItemClickListener onItemClickListener) {
            invocationNameTV.setText(invocationModel.getInvocationName());
            successfulResponsePercentageTV.setText(invocationModel.getSuccessfulResponsesPercentage());
            itemView.setOnClickListener(view -> {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(invocationModel);
                }
            });
        }
    }
}
