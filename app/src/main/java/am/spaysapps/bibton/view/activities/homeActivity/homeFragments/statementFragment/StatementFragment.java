package am.spaysapps.bibton.view.activities.homeActivity.homeFragments.statementFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.List;
import javax.inject.Inject;
import am.spaysapps.bibton.Bibton;
import am.spaysapps.bibton.R;
import am.spaysapps.bibton.adapters.StatementFragmentAdapter;
import am.spaysapps.bibton.model.getTransactionList.TransactionFilterRequestModel;
import am.spaysapps.bibton.model.getTransactionList.TransactionResponse;
import am.spaysapps.bibton.presenter.StatementFragmentPresenter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class StatementFragment extends Fragment implements IStatementFragment {
    private View mainView;
    private ConstraintLayout constraint_from;
    private ConstraintLayout calendarView;
    private CalendarView calendar;
    private ConstraintLayout constraint_to;
    private TextView text_data_from;
    private TextView text_data_to;
    private RecyclerView recycler_view_statement_fragment;
    private RecyclerView.LayoutManager recycler_view_manager;
    @Inject
    StatementFragmentPresenter mPresenter;
    private TransactionFilterRequestModel transactionFilterRequestModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.statement_fragmen_layout, container, false);
        Bibton.getInstance().getAuthorizationComponent().inject(this);
        mPresenter.onViewCreated(this);
        transactionFilterRequestModel = new TransactionFilterRequestModel();

        mPresenter.getTransactionList(transactionFilterRequestModel);
        mPresenter.getTransactionList();

        init();
        handleClicksFromTO();
        return mainView;
    }

    private void init() {
        recycler_view_statement_fragment = mainView.findViewById(R.id.recycler_view_statement_fragment);
        recycler_view_manager = new LinearLayoutManager(getContext());
        recycler_view_statement_fragment.setLayoutManager(recycler_view_manager);

        constraint_from = mainView.findViewById(R.id.constraint_from);
        calendarView = mainView.findViewById(R.id.calendar_view_constraint);
        calendar = mainView.findViewById(R.id.calendar);
        constraint_to = mainView.findViewById(R.id.constraint_to);
        text_data_from = mainView.findViewById(R.id.text_view_data_from);
        text_data_to = mainView.findViewById(R.id.text_view_data_to);
    }


    private String starteDate;
    private String endDate;

    private void handleClicksFromTO() {

        constraint_from.setOnClickListener(v -> {
            calendarView.setVisibility(View.VISIBLE);
            calendar.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
                calendarView.setVisibility(View.GONE);

                starteDate = year + "-" + month + "-" + dayOfMonth;

                text_data_from.setText(starteDate);

                transactionFilterRequestModel.setStart_date(year + "-" + month + "-" + dayOfMonth);

                mPresenter.getTransactionList(transactionFilterRequestModel);

            });
        });
        constraint_to.setOnClickListener(v -> {
            calendarView.setVisibility(View.VISIBLE);

            calendar.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
                calendarView.setVisibility(View.GONE);

                endDate = year + "-" + month + "-" + dayOfMonth;

                text_data_to.setText(endDate);

                transactionFilterRequestModel.setEnd_date(year + "-" + month + "-" + dayOfMonth);

                mPresenter.getTransactionList(transactionFilterRequestModel);


            });
        });
        calendarView.setOnClickListener(v -> calendarView.setVisibility(View.INVISIBLE));

    }

    @Override
    public void getFilteredTransactionList(List<TransactionResponse> transactionResponses) {

    }

    @Override
    public void getTransactionList(List<TransactionResponse> transactionResponses) {
        StatementFragmentAdapter statementFragmentAdapter = new StatementFragmentAdapter(getContext(), transactionResponses);
        recycler_view_statement_fragment.setAdapter(statementFragmentAdapter);
    }

    @Override
    public void onError(String errorMessage) {

    }

    @Override
    public void showServerError() {

    }

    @Override
    public void showNetworkError() {

    }
}
