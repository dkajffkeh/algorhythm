package programmers.level1.analyzedata;

import common.trigger.TestCaseInjectionTrigger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AnalyzeData implements TestCaseInjectionTrigger {

    @Override
    public void trigger() {

    }

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Stocks stocks = new Stocks(data);
        stocks = new Stocks(stocks.skimmedStocks(ext, val_ext));
        stocks.sortByCondition(sort_by);
        return stocks.stockArray();
    }

    private static class Stocks {

        private List<Stock> stocks = new ArrayList<>();

        public Stocks(int[][] datas) {
            for (int[] data : datas) {
                stocks.add(new Stock(
                        data[0],
                        data[1],
                        data[2],
                        data[3]
                ));
            }
        }

        public Stocks(List<Stock> stocks) {
            this.stocks = new ArrayList<>(stocks);
        }

        public List<Stock> skimmedStocks(String ext, int val_ext) {
            return stocks.stream().filter(stock -> {
                if(ext.equals("code")) return stock.codeLessThen(val_ext);
                if(ext.equals("date")) return stock.dateLessThen(val_ext);
                if(ext.equals("maximum")) return stock.maximumLessThen(val_ext);
                if(ext.equals("remain")) return stock.remainLessThen(val_ext);
                return false;
            }).collect(Collectors.toList());
        }

        public void sortByCondition(String sortedBy) {
            if(sortedBy.equals("code")) {
                this.stocks.sort(Comparator.comparing(Stock::getCode));
            }
            if(sortedBy.equals("date")) {
                this.stocks.sort(Comparator.comparing(Stock::getDate));
            }
            if(sortedBy.equals("maximum")) {
                this.stocks.sort(Comparator.comparing(Stock::getMaximum));
            }
            if(sortedBy.equals("remain")) {
                this.stocks.sort(Comparator.comparing(Stock::getRemain));
            }
        }

        public int[][] stockArray() {
            return stocks.stream()
                    .map(stock -> new int[]{stock.code, stock.date, stock.maximum, stock.remain})
                    .toArray(int[][]::new);
        }

        private static class Stock {

            private final int code;
            private final int date;
            private final int maximum;
            private final int remain;

            public Stock(int code, int date, int maximum, int remain) {
                this.code = code;
                this.date = date;
                this.maximum = maximum;
                this.remain = remain;
            }

            public boolean codeLessThen(int code) {
                return this.code < code;
            }

            public boolean dateLessThen(int date) {
                return this.date < date;
            }

            public boolean maximumLessThen(int maximum) {
                return this.maximum < maximum;
            }

            public boolean remainLessThen(int remain) {
                return this.remain < remain;
            }

            public int getCode() {
                return code;
            }

            public int getDate() {
                return date;
            }

            public int getMaximum() {
                return maximum;
            }

            public int getRemain() {
                return remain;
            }

        }
    }
}
