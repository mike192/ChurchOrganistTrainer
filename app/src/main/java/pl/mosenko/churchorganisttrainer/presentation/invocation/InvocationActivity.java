package pl.mosenko.churchorganisttrainer.presentation.invocation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import pl.mosenko.churchorganisttrainer.R;

public class InvocationActivity extends AppCompatActivity implements InvocationContract.View {

    @Inject
    InvocationContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
