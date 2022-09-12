package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RulesCalculations {


    public static void calculate(String rules) {


    }
//min=10or//max=100and//average<5

    public List<Map<String, String>> transalteRules(String rules, List<Double> data) {
        List<Map<String, String>> rule = new ArrayList<>();
        ArrayList<String> strList = new ArrayList<String>(
                Arrays.asList(rules.split(";")));


        return rule;
    }


    public String numbersToReport(String ruleForValue) {
        String valueName;
        //data size
        List<String> data = new ArrayList<>();
        int period = data.size();
        for (int i = 0; i < data.size(); i++) {
            if (period > i + 1) {
                data.remove(data.get(i+1));

            }

        }

        ArrayList<String> strings = new ArrayList<>(Arrays.asList(ruleForValue.split("//")));
        for (String string : strings) {

            if (string.contains("period")) {
                if (period < Integer.parseInt(getVariable(string))) {
                    period = Integer.parseInt(getVariable(string));
                }
                if (string.contains("min")) {
                    List<String> numberAndCodiiton = getNumberAndCodiiton(getVariable(string));
                    List<Double> minUnder = getMinUnder(data, Double.parseDouble(numberAndCodiiton.get(1)));


                } else if (string.contains("value")) {
                    valueName = getVariable(string);
                    break;
                }

            }

            return null;
        }
    }

    private List<Double> getMinUnder(List<String> data, double trigger) {
        List<Double> triggeredNumbers = new ArrayList<>();
        for (String number : data) {
            if (Double.parseDouble(number) < trigger) {
                triggeredNumbers.add(Double.valueOf(number));
            }
        }

        return triggeredNumbers;
    }

    private List<Double> getMaxAbove(List<Double> data, double trigger) {
        List<Double> triggeredNumbers = new ArrayList<>();
        for (Double number : data) {
            if (number > trigger) {
                triggeredNumbers.add(number);
            }
        }

        return triggeredNumbers;
    }

    public String getVariable(String wholeData) {
        int i = wholeData.indexOf('=');
        return wholeData.substring(i + 1);
    }

    public List<String> getNumberAndCodiiton(String wholeData) {
//        10or
        List<String> numberAndCondition = new ArrayList<>();

        String condition = wholeData.replaceAll("[^\\.0123456789]", "");
        numberAndCondition.add(condition);
        String number = wholeData.replace(wholeData.replaceAll("[^0-9.]", ""), "");
        numberAndCondition.add(number);
        return numberAndCondition;

    }
}



