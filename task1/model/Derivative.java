package by.epam.task1.model;

import by.epam.task1.model.entity.Insurance;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
//это по сути должен быть класс модели
//т.е. он должен содердать только твои 2 поля и get/set методы для них (можно оставить также add и getSize для коллекции)
//для остальных методов создай какой-либо DerivativeService класс - и перенеси их туда
public class Derivative {

    private String derivativeTitle;
    private List<Insurance> insuranceList;

    public Derivative(String derivativeTitle, List insuranceList) {
        this.derivativeTitle = derivativeTitle;
        this.insuranceList = insuranceList;
    }

    public int calculateTotal() {
        int total = 0;

        for (Insurance insurance : insuranceList) {
            total += insurance.getCost();
        }

        return total;
    }

    public void sortInsurances() {
        Collections.sort(insuranceList);
    }

    //зачем 2 таких метода?
    public void sortInsurances(Comparator comparator) {
        Collections.sort(insuranceList, comparator);
    }

    public List<Insurance> findInsurances(String parameter, int min, int max) {
        List<Insurance> result = new LinkedList<>();

        switch (parameter.toLowerCase()) {
            case "cost":
                for (Insurance insurance : insuranceList) {
                    if (insurance.getCost() >= min && insurance.getCost() <= max) {
                        result.add(insurance);
                    }
                }
                break;

            case "risk":
                for (Insurance insurance : insuranceList) {
                    if (insurance.getRiskLevel() >= min && insurance.getRiskLevel() <= max) {
                        result.add(insurance);
                    }
                }
                break;
        }

        return result;
    }

    public String getDerivativeTitle() {
        return derivativeTitle;
    }

    public void setDerivativeTitle(String derivativeTitle) {
        this.derivativeTitle = derivativeTitle;
    }

    public List getInsuranceList() {
        return insuranceList;
    }

    public void setInsuranceList(List insuranceList) {
        this.insuranceList = insuranceList;
    }

    public int getSize(){
        return insuranceList.size();
    }

    public void addInsurance(Insurance insurance){
        insuranceList.add(insurance);
    }

    @Override
    public String toString(){
        return getDerivativeTitle() + ": " + insuranceList.toString();
    }

}
