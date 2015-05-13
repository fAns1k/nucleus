package nucleus.example.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nucleus.example.R;
import nucleus.example.logging.LoggingFragment;
import nucleus.example.logging.LoggingPresenter;
import nucleus.factory.RequiresPresenter;

@RequiresPresenter(LoggingPresenter.class)
public class ItemFragment extends LoggingFragment<MainPresenter> {

    private static final String TEXT_KEY = "text";

    TextView textView;
    String text;

    public ItemFragment() {
    }

    public ItemFragment(String text) {
        this.text = text;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null)
            text = bundle.getString(TEXT_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(TEXT_KEY, text);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView)view.findViewById(android.R.id.text1);
        textView.setText(text);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replace(new MainFragment());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        textView = null;
    }
}
