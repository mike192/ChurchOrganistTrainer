package pl.mosenko.churchorganisttrainer.presentation.invocation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.mosenko.churchorganisttrainer.R;
import pl.mosenko.churchorganisttrainer.presentation.common.view.BaseViewFragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InvocationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InvocationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InvocationFragment extends BaseViewFragment<InvocationContract.Presenter> implements InvocationContract.View {
    private OnFragmentInteractionListener mListener;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.invocationsRecyclerView)
    RecyclerView invocationsRecyclerView;

    @Inject
    InvocationPresenter invocationPresenter;
    @Inject
    InvocationAdapter invocationAdapter;

    public InvocationFragment() {
    }

    public static InvocationFragment newInstance() {
        return new InvocationFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_invocation, container, false);
        ButterKnife.bind(this, view);
        setupRecyclerView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadInvocations();
    }

    private void loadInvocations() {
        presenter.getInvocations();
    }

    @Override
    public void showInvocationList(List<InvocationModel> invocationModels) {
        invocationAdapter.setInvocationModels(invocationModels);
    }

    private void setupRecyclerView() {
        invocationAdapter.setOnItemClickListener(this::onInvocationItemClick);
        invocationsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        invocationsRecyclerView.setAdapter(invocationAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroy();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }

    }

    private void onInvocationItemClick(InvocationModel invocationModel) {
        Toast.makeText(getContext(), "onInvocationItemClick", Toast.LENGTH_SHORT).show();
        //TODO go to game mode
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
