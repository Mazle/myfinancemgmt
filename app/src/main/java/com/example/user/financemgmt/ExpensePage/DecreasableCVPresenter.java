package com.example.user.financemgmt.ExpensePage;

import com.example.user.financemgmt.DAO.DriverDao;
import com.example.user.financemgmt.DataModel.Decreasable;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by Palibin
 */

public class DecreasableCVPresenter extends FinanceCVPresenter<Decreasable> {
    protected ArrayList<Decreasable> model; //Тип данных: Usage или CashSource
    protected WeakReference<ExpenseCV> view; // Вьюшка, на которую мы подписывамся
    int selectedItem;


    public void bindView (ExpenseCV view) {
        this.view = new WeakReference<ExpenseCV>(view);
    }

    public void setModel(ArrayList<Decreasable> model){
        this.model = model;
    }

    public void onItemClicked(int position) {
        selectedItem = position;
        view.get().selectView();

    }

    @Override
    public void updateView(int position) {
        view.updateName(getItemName(position));
        view.updateCashAmount(Long.toString(getItemCash(position)));
    }


    public String getItemName(int position) {
        return ((Decreasable) DriverDao.getDecreasableList().get(position)).getName();
    }

    public long getItemCash(int position) {
        return ((Decreasable) DriverDao.getDecreasableList().get(position)).getCashAmount();
    }

    public int getModelSize() {
        return DriverDao.getDecreasableList().size();
    }

    @Override
    public void onBindViewHolder(int position) {
        updateView(position);
    }
}
